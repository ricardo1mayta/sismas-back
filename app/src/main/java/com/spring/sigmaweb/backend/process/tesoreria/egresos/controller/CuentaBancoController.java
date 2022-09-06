package com.spring.sigmaweb.backend.process.tesoreria.egresos.controller;
import com.spring.sigmaweb.backend.process.generic.model.Persona;
import com.spring.sigmaweb.backend.process.generic.service.IPersonaService;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalDatosListDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.CuentaBancoDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.TarjetaCreditoDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.CuentaBanco;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.CuentaBancoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sigmaweb/cuentabanco")
public class CuentaBancoController {

    private final ModelMapper mapper;
    private final CuentaBancoService cuentaBancoService;
    private final IPersonaService personaService;

    @GetMapping()
    private List<CuentaBancoDTO> listarPorObraCuentaBanco(@RequestParam String idObra){

            Persona persona ;
            List<CuentaBanco> listarCuentaBanco=cuentaBancoService.listarPorObraCuentaBanco(idObra);
            List<CuentaBancoDTO> listaCuentaBancoDTO = cuentaBancoService.listarPorObraCuentaBanco(idObra).stream().map(c-> mapper.map(c,CuentaBancoDTO.class)).collect(Collectors.toList());

            for (CuentaBancoDTO cb: listaCuentaBancoDTO){
                if(cb.getTarjetaCredito().size()>0){
                    for (TarjetaCreditoDTO tc:cb.getTarjetaCredito() ){
                        PersonalDatosListDTO personalDTO= new PersonalDatosListDTO();
                        persona=personaService.findByIdPersona(tc.getPersonal().getIdPersonal());
                        personalDTO.setIdPersonal(tc.getPersonal().getIdPersonal());
                        personalDTO.setApePaternoPers(persona.getApePaternoPers());
                        personalDTO.setApeMaternoPers(persona.getApeMaternoPers());
                        personalDTO.setNombrePers(persona.getNombrePers());
                        personalDTO.setNomCompleto(persona.getApePaternoPers().concat(" ")
                                .concat(persona.getApeMaternoPers().concat(" "))
                                .concat(persona.getNombrePers()));
                        tc.setPersonal(personalDTO);
                    }
                }
            }
        return  listaCuentaBancoDTO;
    }
    @GetMapping("listar/obra/tipomoneda")
    private List<CuentaBancoDTO> listarPorTipoMonedaYObraCuentaBanco(@RequestParam String idObra,@RequestParam Integer idTipoMoneda){

        Persona persona ;
        List<CuentaBanco> listarCuentaBanco=cuentaBancoService.listarPorTipoMonedaYObraCuentaBanco(idObra,idTipoMoneda);
        List<CuentaBancoDTO> listaCuentaBancoDTO = cuentaBancoService.listarPorTipoMonedaYObraCuentaBanco(idObra,idTipoMoneda).stream().map(c-> mapper.map(c,CuentaBancoDTO.class)).collect(Collectors.toList());

        for (CuentaBancoDTO cb: listaCuentaBancoDTO){
            if(cb.getTarjetaCredito().size()>0){
                for (TarjetaCreditoDTO tc:cb.getTarjetaCredito() ){
                    PersonalDatosListDTO personalDTO= new PersonalDatosListDTO();
                    persona=personaService.findByIdPersona(tc.getPersonal().getIdPersonal());
                    personalDTO.setIdPersonal(tc.getPersonal().getIdPersonal());
                    personalDTO.setApePaternoPers(persona.getApePaternoPers());
                    personalDTO.setApeMaternoPers(persona.getApeMaternoPers());
                    personalDTO.setNombrePers(persona.getNombrePers());
                    personalDTO.setNomCompleto(persona.getApePaternoPers().concat(" ")
                            .concat(persona.getApeMaternoPers().concat(" "))
                            .concat(persona.getNombrePers()));
                    tc.setPersonal(personalDTO);
                }
            }
        }
        return  listaCuentaBancoDTO;
    }

    private void setNombres(PersonalDatosListDTO personalDatosListDTO){

    }

    @GetMapping("/buscar")
    private CuentaBancoDTO buscarPorIdCuentaBanco(@RequestParam Long idCuentaBanco){
        return mapper.map(cuentaBancoService.buscarPorIdCuentaBanco(idCuentaBanco),CuentaBancoDTO.class);
    }

    @PostMapping
    public CuentaBancoDTO guardarCuentaBanco (@RequestBody CuentaBancoDTO bodyDTO) throws Exception {
        return mapper.map( cuentaBancoService.registrar(mapper.map(bodyDTO, CuentaBanco.class)),CuentaBancoDTO.class);
    }

    @PutMapping
    public CuentaBancoDTO modificarCuentaBanco (@RequestBody CuentaBancoDTO bodyDTO) throws Exception {
        return mapper.map( cuentaBancoService.modificar(mapper.map(bodyDTO,CuentaBanco.class)),CuentaBancoDTO.class);
    }

    @DeleteMapping
    public void borrarCuentaBanco(@RequestParam Long id) throws Exception {
        cuentaBancoService.eliminar(id);
    }
}
