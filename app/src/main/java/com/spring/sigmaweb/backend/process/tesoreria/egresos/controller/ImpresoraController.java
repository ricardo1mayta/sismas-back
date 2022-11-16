package com.spring.sigmaweb.backend.process.tesoreria.egresos.controller;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.ImpresoraCajaDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.Impresora;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.ImpresoraCaja;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.IImpresoraService;
import com.spring.sigmaweb.backend.process.utils.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("sigmaweb/impresora")
@RequiredArgsConstructor
public class ImpresoraController {
    private final IImpresoraService impresoraService;

    @GetMapping("/listar/obra/flgestado")
    public List<ImpresoraCajaDTO> listasCajaPorObras(@RequestParam String idobra, @RequestParam Integer flgestado) throws Exception{
        return impresoraService.findByIdObraAndFlgEstado(idobra,flgestado);
    }

    @GetMapping("/buscar/obra/id")
    public Impresora listasCajaPorObras(@RequestParam String idobra, @RequestParam Long idimpresora) throws Exception{
        return impresoraService.findByIdObraAndIdImpresora(idobra, idimpresora);
    }

    @GetMapping("/buscarimpresorasCaja/obra/caja/flgestado")
    public List<ImpresoraCajaDTO> listasImpresorascaja(@RequestParam String idobra, @RequestParam Long idcaja, @RequestParam Integer flgestado) throws Exception{
        return impresoraService.findByImpresorasCajaSelect(idobra, idcaja, flgestado);
    }

    @PostMapping("/impresoraCaja")
    public Integer guardarImpresoraCaja (@RequestBody List<ImpresoraCaja> body,@RequestParam String idobra, @RequestParam Long idcaja) throws Exception {
        List<ImpresoraCaja> newItems= body;
        //String idobra = newItems.get(0).getIdObra();
        //Long idcaja = newItems.get(0).getIdCaja();
        Impresora impresora = null;
        String idimpresoracaja="";
        Integer countInsert =0;
        List<ImpresoraCaja> impresoras = impresoraService.findByImpresorasCajaObraTodos(idobra,idcaja);

        for (ImpresoraCaja item : impresoras) {
            idimpresoracaja="";
            for (ImpresoraCaja find: newItems) {
                if(item.getIdObra().equals(find.getIdObra()) &&
                    item.getIdCaja().equals(find.getIdCaja()) &&
                    item.getIdImpresora().equals(find.getIdImpresora())
                ){
                    idimpresoracaja = item.getIdImpresoraCaja();
                }
            }
            if(idimpresoracaja.equals("")){
                //Elimina
                impresoraService.deleteImpresoraCaja(idobra, idcaja, item.getIdImpresora() );
            }
        }

        for (ImpresoraCaja item: newItems) {
            idimpresoracaja="";
            for (ImpresoraCaja find: impresoras) {
                if(item.getIdObra().equals(find.getIdObra()) &&
                        item.getIdCaja().equals(find.getIdCaja()) &&
                        item.getIdImpresora().equals(find.getIdImpresora())
                ){
                    idimpresoracaja = find.getIdImpresoraCaja();
                }
            }
            if(idimpresoracaja.equals("")) {
                item.setIdImpresoraCaja(Utils.idObraNumerico(idobra) + "-" + idcaja + "-" + item.getIdImpresora());
                item.setFechaRegistro(new Date());
                this.impresoraService.saveImpresoraCaja(item);
                countInsert += 1;
            }
        }

        return countInsert;

    }

}
