package com.spring.sigmaweb.backend.process.tesoreria.egresos.controller;

import com.spring.sigmaweb.backend.process.generic.model.Periodo;
import com.spring.sigmaweb.backend.process.generic.model.TipoCambio;
import com.spring.sigmaweb.backend.process.generic.service.ITipoCambioService;
import com.spring.sigmaweb.backend.process.generic.service.PeriodoService;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.CajaGeneralDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.Caja;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.CajaGeneral;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.CajeroCaja;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.CajaGeneralService;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.CajaService;
import com.spring.sigmaweb.backend.process.utils.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("sigmaweb/cajageneral")
@RequiredArgsConstructor
public class CajaGeneralController {
    private final ModelMapper mapper;
    private final CajaGeneralService cajageneralService;

    private final CajaService cajaService;
    private final PeriodoService periodoService;

    private final ITipoCambioService tipoCambioService;

    @GetMapping("listardto/obra/idusuario")
    public List<CajaGeneralDTO> listasCajaPorObras(@RequestParam String idobra, @RequestParam Long idusuario) throws Exception{
        return cajageneralService.findByIdObraAndCajaAndUsuarioDTO(idobra, idusuario);
    }

    @GetMapping("showcajaaperturada/obra/usuario")
    public CajaGeneral listasCajaAperturadaObras(@RequestParam String idobra, @RequestParam Long usuario) throws Exception{
        return cajageneralService.findByCajaAperturadaAndObra(idobra, usuario);
    }

    @GetMapping("showcajaaperturadaDTO/obra/usuario")
    public CajaGeneralDTO listasCajaAperturadaObrasDTO(@RequestParam String idobra, @RequestParam Long usuario) throws Exception{
        return cajageneralService.findByCajaAperturadaAndObraDTO(idobra, usuario);
    }

    @GetMapping("showcajaactual/obra/usuario")
    public CajaGeneral listasEstadoCajaActual(@RequestParam String idobra, @RequestParam Long usuario) throws Exception{
        return cajageneralService.findByEstadoCajaActualUsuario(idobra, usuario);
    }

    @GetMapping("showcajaactualDTO/obra/usuario")
    public CajaGeneralDTO listasEstadoCajaActualDTO(@RequestParam String idobra, @RequestParam Long usuario) throws Exception{
        return cajageneralService.findByCajaActualDTO(idobra, usuario);
    }

    @PostMapping()
    public ResponseEntity<?> aperturaCajaGeneral(@RequestBody CajaGeneral body, @RequestParam Float tcCompra, @RequestParam Float tcVenta, BindingResult result) {
        CajaGeneral newItem=null;
        CajaGeneral cajaGenExisteFecha = null;
        TipoCambio tipoCambio = tipoCambioService.findByIdOBraAndDateAndMoneda(body.getIdObra(), body.getFechaApertura(), Constants.TIPO_MONEDA.DOLARES);
        Periodo periodoCajaGen = null ;
        CajaGeneral cajaAperturada = cajageneralService.findByCajaAperturadaAndObra(body.getIdObra(), body.getIdUsuario());
        Map<String, Object> response = new HashMap<>();

        if(result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        try {
           periodoCajaGen = periodoService.findByidObraPeriAndAnioPeri(body.getIdObra(), Integer.parseInt(  body.getIdPeriodo() + ""  )).get(0);
            if(cajaAperturada == null ){
                cajaGenExisteFecha = cajageneralService.findExistDateCajaGenObra(body.getIdObra(), body.getFechaApertura(), body.getIdCaja());
                if(cajaGenExisteFecha == null){
                    newItem = new CajaGeneral();
                    newItem.setIdObra(body.getIdObra());
                    newItem.setIdCaja(body.getIdCaja());
                    newItem.setIdUsuario(body.getIdUsuario());
                    newItem.setIdPeriodo(periodoCajaGen.getIdPeriodo());
                    newItem.setIdSupervizor(body.getIdSupervizor());
                    newItem.setFechaApertura(body.getFechaApertura());
                    newItem.setCreapor(body.getCreapor());
                    newItem.setFechaRegistro(new Date());

                    newItem = cajageneralService.save(newItem);

                    //guarda tipo de cambio
                    if(tipoCambio == null){
                        tipoCambio = new TipoCambio();
                        tipoCambio.setIdObra(body.getIdObra());
                        tipoCambio.setFecha(body.getFechaApertura());
                        tipoCambio.setIdTipoMoneda(Constants.TIPO_MONEDA.DOLARES);
                        tipoCambio.setTipoCambioCompra(tcCompra);
                        tipoCambio.setTipoCambioVenta(tcVenta);
                        tipoCambio.setCreaporPer(body.getCreapor());
                        tipoCambio.setFechaRegistro(new Date());
                        tipoCambio.setFlgEstado(true);

                        tipoCambioService.save(tipoCambio);
                    }

                } else {
                    response.put("mensaje", "Fecha de caja general registrada");
                    response.put("error", "Fecha de Caja General registrada");
                    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }

            } else {
                response.put("mensaje", "Ya existe una caja aperturada");
                response.put("error", "caja con fecha indicada ya existe o hay posteriores");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }


        } catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El item ha sido creado con éxito!");
        response.put("cajageneral", newItem);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping()
    public CajaGeneral updateCajaGeneral(@RequestBody CajaGeneral body) {
        CajaGeneral cajaUpdate = cajageneralService.findByCajaAperturadaAndObra(body.getIdObra(), body.getIdUsuario());
        CajaGeneral cajaReturn = null;
        if(cajaUpdate != null){
            if(body.getIdCajaGeneral().equals(cajaUpdate.getIdCajaGeneral())
                    && body.getIdObra().equals(cajaUpdate.getIdObra())){
                //son la misma caja, procede a cerra

                cajaUpdate.setFechaActualiza(new Date());
                cajaUpdate.setModificadoPor(body.getModificadoPor());
                cajaReturn = cajageneralService.save(cajaUpdate);
            }
        }
        return  cajaReturn;
    }

    @PutMapping("/cierrecaja")
    public CajaGeneral updateCloseCajaGeneral(@RequestBody CajaGeneral body) {

        CajaGeneral cajaUpdate = cajageneralService.findByCajaAperturadaAndObra(body.getIdObra(), body.getIdUsuario());
        CajaGeneral cajaReturn = null;
        if(cajaUpdate != null){
            if(body.getIdCajaGeneral().equals(cajaUpdate.getIdCajaGeneral())
                    && body.getIdObra().equals(cajaUpdate.getIdObra())){
                //son la misma caja, procede a cerra
                cajaUpdate.setFechaCierre(body.getFechaCierre());
                cajaUpdate.setFechaActualiza(new Date());
                cajaUpdate.setModificadoPor(body.getModificadoPor());

                cajaReturn = cajageneralService.save(cajaUpdate);
            }
        }

        return  cajaReturn;
    }


}
