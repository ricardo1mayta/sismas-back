package com.spring.sigmaweb.backend.process.tesoreria.egresos.controller;

import com.spring.sigmaweb.backend.process.generic.model.TipoCambio;
import com.spring.sigmaweb.backend.process.generic.service.ITipoCambioService;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.DocumentoEgresoDto;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.DocumentoEgresoListaDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.DocumentoEgreso;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.NumeracionDocumento;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.DocumentoEgresoService;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.NumeracionDocumentoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/sigmaweb/documentoegreso")
@RequiredArgsConstructor
public class DocumentoEgresoController {
    private final DocumentoEgresoService documentoEgresoService;
    private final ModelMapper mapper;
    private final ITipoCambioService tipoCambioService;
    private final NumeracionDocumentoService numeracionDocumentoService;
    
    @GetMapping("/listar/obra")
    private ResponseEntity<Page<DocumentoEgresoListaDTO>> listarPorObraDocumentoEgreso(@RequestParam String idObra,
                                                                                      @RequestParam Integer page,
                                                                                      @RequestParam Integer size)throws Exception {
        return new ResponseEntity<>(documentoEgresoService.listarPorObra(idObra,page,size), HttpStatus.OK);
    }

    @GetMapping("/buscar")
    private DocumentoEgresoDto buscarPorIdDocumentoEgreso(@RequestParam Long idDocumentoEgreso) throws Exception {
        documentoEgresoService.buscarPorId(idDocumentoEgreso);
        return mapper.map(documentoEgresoService.buscarPorId(idDocumentoEgreso),DocumentoEgresoDto.class);
    }

    @GetMapping("/listar/tipo-solicitud")
    private ResponseEntity<Page<DocumentoEgresoListaDTO>> listarPorTipoSolicitud(@RequestParam String idObra,
                                                      @RequestParam Integer idTipoSolicitud,
                                                      @RequestParam Integer page,
                                                      @RequestParam Integer size){
        return new ResponseEntity<>(documentoEgresoService.listarPorTipoSolicitud(idObra,idTipoSolicitud,page,size),HttpStatus.OK);
    }

    @PostMapping
    public DocumentoEgresoDto guardarDocumentoEgreso (@RequestBody DocumentoEgresoDto bodyDTO) throws Exception {
        return mapper.map( documentoEgresoService.registrarTransaccional(mapper.map(bodyDTO, DocumentoEgreso.class)),DocumentoEgresoDto.class);
    }

    @PutMapping
    public DocumentoEgresoDto modificarDocumentoEgreso (@RequestBody DocumentoEgresoDto bodyDTO) throws Exception {
        return mapper.map( documentoEgresoService.modificar(mapper.map(bodyDTO,DocumentoEgreso.class)),DocumentoEgresoDto.class);
    }

    @DeleteMapping
    public void borrarDocumentoEgreso(@RequestParam Long id) throws Exception {
        documentoEgresoService.eliminar(id);
    }

    @GetMapping("tipos-cambio")
    public TipoCambio buscarPorIdObrayFechaTipoCambio(@RequestParam String idObra, @RequestParam Date fecha){
        return tipoCambioService.findByIdOBraAndDate(idObra,fecha);
    }

    @GetMapping("tipos-cambio-moneda")
    public TipoCambio buscarPorIdObrayFechayMonedaTipoCambio(@RequestParam String idObra, @RequestParam Date fecha, @RequestParam Integer moneda){
        return tipoCambioService.findByIdOBraAndDateAndMoneda(idObra,fecha, moneda);
    }

    @GetMapping("numeracion-documentos")
    public NumeracionDocumento buscarPorIdObraYTipoMoneday(@RequestParam String idObra,@RequestParam Integer idTipoModoPago, @RequestParam  Integer idTipoMoneda){
            return numeracionDocumentoService.findByIdTipoModoPagoAndTipoMoneda(idTipoModoPago,idObra,idTipoMoneda);
    }
}
