package com.spring.sigmaweb.backend.process.sintomatologia.controller;

import com.spring.sigmaweb.backend.process.sintomatologia.dto.FichaListEnfermedadSintomaDTO;
import com.spring.sigmaweb.backend.process.sintomatologia.dto.FichaSintomatologicaDTO;
import com.spring.sigmaweb.backend.process.sintomatologia.model.FichaSintomatologica;
import com.spring.sigmaweb.backend.process.sintomatologia.service.impl.LocalService;
import com.spring.sigmaweb.backend.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = {"*"})
@RequiredArgsConstructor
@RestController()
@RequestMapping("/sigmaweb/fichas")
public class FichaSintomatologiaController {
    private final LocalService service;
    private final ModelMapper mapper;

//    @GetMapping
//    public ResponseEntity< ?> listar(@RequestParam String idObra, @RequestParam String fechaRegistro){
//            List<FichaListEnfermedadSintomaDTO> listFichas = service.litarFichaDetalle(idObra, fechaRegistro);
//         return  new ResponseEntity<>(listFichas, HttpStatus.OK);
//    }

//    @GetMapping("/listar2")
//    public ResponseEntity< ?> listar2(@RequestParam String idObra, @RequestParam String fechaRegistro){
//        List<FichaListEnfermedadSintomaDTO> listFichas = service.litarFichaDetallePageable(idObra, "2022-04-16");
//        return  new ResponseEntity<>(listFichas, HttpStatus.OK);
//    }
    @Secured({"ROLE_ADMI","ROLE_COLA"})
    @GetMapping("/listar")
    public ResponseEntity< ?> listar(@RequestParam String idObra, @RequestParam String fechaRegistro){
        List<FichaSintomatologicaDTO> listFichas = service.litarFicha(idObra, fechaRegistro);
        return  new ResponseEntity<>(listFichas, HttpStatus.OK);
    }

    @Secured({"ROLE_ADMI","ROLE_COLA"})
    @GetMapping("/buscar")
    public ResponseEntity<?> buscarPorNombre(@RequestParam String name,@RequestParam String idObra, @RequestParam String fechaRegistro ){
        List<FichaListEnfermedadSintomaDTO> listFichas= service.listNameFichaDetalle(name,idObra, Utils.toDateRegister(fechaRegistro));
        return new ResponseEntity<>(listFichas,HttpStatus.OK);
    }

    @Secured({"ROLE_ADMI","ROLE_COLA"})
    @GetMapping("/idFicha")
    public ResponseEntity<?> buscarPorId(@RequestParam Long idFicha){
        FichaListEnfermedadSintomaDTO ficha =service.findByIdFichaDetalle(idFicha);
        return new ResponseEntity<>(ficha,HttpStatus.OK);
    }

    @Secured({"ROLE_ADMI","ROLE_COLA"})
    @PutMapping("/actualizar")
    public ResponseEntity<?> actualiar(@RequestBody FichaSintomatologicaDTO dto ){
        FichaSintomatologica fichaActual= service.finById(dto.getIdFicha());
        fichaActual.setObservacion(dto.getObservacion());
        fichaActual.setFechaActualizacion(new Date());
         return new ResponseEntity<>(service.actualizar(fichaActual),HttpStatus.CREATED);
    }

    public ResponseEntity<?> borrar(@RequestParam Long idFicha){
        return null;
    }

    @Secured({"ROLE_ADMI","ROLE_COLA"})
    @GetMapping("/listarPersonal")
    public ResponseEntity<Page<FichaSintomatologicaDTO>>listPersonalObra(String name,
                                                                         String idObra,
                                                                         Integer page,
                                                                         Integer size){
       return  ResponseEntity.ok(service.listaPersonalObra(name, idObra, page, size));
    }

    @Secured({"ROLE_ADMI","ROLE_COLA"})
    @PostMapping(value = "/export")
    public ResponseEntity<InputStreamResource> exportarRegistroFichasDia(@RequestParam String idObra,@RequestParam String fechaRegistro) throws Exception {
        ByteArrayInputStream in = service.exportFichasPersonal(idObra,fechaRegistro);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=reporteFichaSintomatologica.xlsx");
        return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
    }
}
