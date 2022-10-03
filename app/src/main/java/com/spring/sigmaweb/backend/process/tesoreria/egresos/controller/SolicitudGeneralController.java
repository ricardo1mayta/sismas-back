package com.spring.sigmaweb.backend.process.tesoreria.egresos.controller;

import com.spring.sigmaweb.backend.process.legajo.dto.PersonalDatosListDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.SolicitudGeneralDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.SolicitudGeneralListaDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.TipoSolicitudDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.SolicitudGeneral;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.ISolicitudGeneralService;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.ITipoSolicitudService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/sigmaweb/solicitudgeneral")
@Validated
@RequiredArgsConstructor
public class SolicitudGeneralController {

    private final ModelMapper mapper;
    private final ISolicitudGeneralService solicitudGeneralService;
    private final ITipoSolicitudService tipoSolicitudService;
    private SolicitudGeneral solicitudGeneral;

    @GetMapping
    public ResponseEntity<Page<SolicitudGeneralListaDTO>> listarResumenSolicitudGeneral(@RequestParam String obra,
                                                                                        @RequestParam Integer page,
                                                                                        @RequestParam Integer size) throws Exception {
         return new ResponseEntity<>(solicitudGeneralService.listarResumenSolicitudGeneral(obra,page,size), HttpStatus.OK) ;
    }

    @GetMapping("/listar/estado")
    public ResponseEntity<Page<SolicitudGeneralListaDTO>>listarPorObraIdTipoEstadoSolicitudGeneral(@RequestParam String idObra,
                                                                                                 @RequestParam Integer page,
                                                                                                 @RequestParam Integer size,
                                                                                                  @RequestParam Integer idTipoEstado){
        return new ResponseEntity<>(solicitudGeneralService.listarPorObraIdTipoEstadoSolicitudGeneral(idObra,idTipoEstado,page,size),HttpStatus.OK);
    }

    @GetMapping("/buscar")
    public SolicitudGeneralDTO buscarPorIdSolicitudGeneral(@RequestParam Long id) throws  Exception {
//        return solicitudGeneralService.listarPorId(id);}
        SolicitudGeneralDTO solicitudGeneralDTO;
        PersonalDatosListDTO personalDTO = new PersonalDatosListDTO();
        PersonalDatosListDTO personalCargoDTO = new PersonalDatosListDTO();
        solicitudGeneral =solicitudGeneralService.buscarPorId(id);
        solicitudGeneralDTO = mapper.map(solicitudGeneral, SolicitudGeneralDTO.class);
        personalDTO.setIdPersonal(solicitudGeneral.getPersonal().getIdPersonal());
        personalDTO.setApePaternoPers(solicitudGeneral.getPersonal().getIdPersona().getApePaternoPers());
        personalDTO.setApeMaternoPers(solicitudGeneral.getPersonal().getIdPersona().getApeMaternoPers());
        personalDTO.setNombrePers(solicitudGeneral.getPersonal().getIdPersona().getNombrePers());
        personalDTO.setNroDocPers(solicitudGeneral.getPersonal().getNroDocPer());
        personalDTO.setNomCompleto(solicitudGeneral.getPersonal().getIdPersona().getApePaternoPers().concat(" ")
                .concat(solicitudGeneral.getPersonal().getIdPersona().getApeMaternoPers().concat(" "))
                .concat(solicitudGeneral.getPersonal().getIdPersona().getNombrePers()));

        if(solicitudGeneral.getPersonalCargo()!=null){
            personalCargoDTO.setIdPersonal(solicitudGeneral.getPersonalCargo().getIdPersonal());
            personalCargoDTO.setApePaternoPers(solicitudGeneral.getPersonalCargo().getIdPersona().getApePaternoPers());
            personalCargoDTO.setApeMaternoPers(solicitudGeneral.getPersonalCargo().getIdPersona().getApeMaternoPers());
            personalCargoDTO.setNombrePers(solicitudGeneral.getPersonalCargo().getIdPersona().getNombrePers());
            personalCargoDTO.setNroDocPers(solicitudGeneral.getPersonalCargo().getNroDocPer());
            personalCargoDTO.setNomCompleto(solicitudGeneral.getPersonalCargo().getIdPersona().getApePaternoPers().concat(" ")
                    .concat(solicitudGeneral.getPersonalCargo().getIdPersona().getApeMaternoPers().concat(" "))
                    .concat(solicitudGeneral.getPersonalCargo().getIdPersona().getNombrePers()));
            solicitudGeneralDTO.setPersonalCargo(personalCargoDTO);
        }
        solicitudGeneralDTO.setPersonal(personalDTO);


        return solicitudGeneralDTO;
    }

    @PostMapping
    public SolicitudGeneralDTO registrarSolicitudGeneral (@RequestBody SolicitudGeneralDTO bodyDTO) throws Exception {
        //return solicitudGeneralService.registrarTransaccional(bodyDTO);
        return mapper.map(solicitudGeneralService.registrarTransaccional( mapper.map(bodyDTO, SolicitudGeneral.class) ),SolicitudGeneralDTO.class);
    }

    @PutMapping
    public SolicitudGeneralDTO modificarSolicitudGeneral (@RequestBody SolicitudGeneralDTO bodyDTO) throws Exception {
        bodyDTO.setFechaSolicitud(new Date());
        SolicitudGeneral so=mapper.map(bodyDTO, SolicitudGeneral.class);
        SolicitudGeneral so2 =solicitudGeneralService.modificar(so);
        return mapper.map(solicitudGeneralService.modificar( mapper.map(so, SolicitudGeneral.class) ),SolicitudGeneralDTO.class);

    }

    @PutMapping("/aprobar")
    public SolicitudGeneralDTO aprobarSolicitudGeneral (@RequestBody SolicitudGeneralDTO bodyDTO) throws Exception {
        bodyDTO.setFechaActualiza(new Date());
        return mapper.map(solicitudGeneralService.aprobarSolicitudGeneral( mapper.map(bodyDTO, SolicitudGeneral.class) ),SolicitudGeneralDTO.class);
    }

    @PutMapping("/desaprobar")
    public SolicitudGeneralDTO desaprobarSolicitudGeneral(@RequestBody SolicitudGeneralDTO bodyDTO ){
        bodyDTO.setFechaActualiza(new Date());
        return mapper.map(solicitudGeneralService.desaprobarSolicitudGenertal(mapper.map(bodyDTO,SolicitudGeneral.class)),SolicitudGeneralDTO.class);
    }

    @DeleteMapping
    public void borrarSolicitudGeneral(@RequestParam Long idSolicitudGeneral) throws Exception {

        solicitudGeneralService.eliminar(idSolicitudGeneral);
    }

    @PutMapping("/modificar-estado")
    public void modificarEstado(@RequestParam Long idSolicitudGeneral,
                                @RequestParam Integer idEstadoSolicitud,
                                @RequestParam String userUpdate){
        solicitudGeneralService.modificarEstadoSolicitudGeneral(idSolicitudGeneral,idEstadoSolicitud,userUpdate);
    }

    @GetMapping("tiposolicitud")
    public List<TipoSolicitudDTO> listarTipoSolicitud() throws Exception {
        return tipoSolicitudService.listar().stream().map(s->mapper.map(s,TipoSolicitudDTO.class)).collect(Collectors.toList());
    }

}
