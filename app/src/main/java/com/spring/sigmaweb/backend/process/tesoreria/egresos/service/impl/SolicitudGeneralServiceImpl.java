package com.spring.sigmaweb.backend.process.tesoreria.egresos.service.impl;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.SolicitudGeneralListaDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.SolicitudGeneral;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.SolicitudGeneralDetalle;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.IGenericRepo;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.SolicitudGeneralDetalleRepository;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.SolicitudGeneralRespository;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.ISolicitudGeneralService;
import com.spring.sigmaweb.backend.process.utils.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Slf4j
@RequiredArgsConstructor
@Service
public class SolicitudGeneralServiceImpl extends CRUDImpl<SolicitudGeneral, Long> implements ISolicitudGeneralService {

    private final SolicitudGeneralRespository repo;
    private final SolicitudGeneralDetalleRepository repoDetalle;
    private final SolicitudGeneralDetalleServiceImpl solicitudGeneralDetalleService;
    private SolicitudGeneral solicitudGeneral;
    private SolicitudGeneralDetalle solicitudGeneralDetalle;

    @Override
    protected IGenericRepo<SolicitudGeneral, Long> getRepo() {
        return repo;
    }

    @Transactional
    @Override
    public SolicitudGeneral registrarTransaccional(SolicitudGeneral solicitudGeneral) {
        if(!solicitudGeneral.getSolicitudGeneralDetalle().isEmpty() || solicitudGeneral.getSolicitudGeneralDetalle() !=  null || solicitudGeneral.getSolicitudGeneralDetalle().size()!=0){
            solicitudGeneral.getSolicitudGeneralDetalle().forEach(det->det.setSolicitudGeneral(solicitudGeneral));
        }
        solicitudGeneral.setFlgEstado(Constants.FLAG_ESTADO.ACTIVO);
        solicitudGeneral.setIdEstado(Constants.ESTADO_SOLICITUD.PENDIENTE);
        repo.save(solicitudGeneral);
        return solicitudGeneral;
    }

    @Override
    public Page<SolicitudGeneralListaDTO> listarResumenSolicitudGeneral(String obraName, Integer page, Integer size) {
        return repo.listarResumenSolicitudGeneral(obraName,PageRequest.of(page,size));
    }

    @Override
    public Page<SolicitudGeneralListaDTO> listarPorObraIdTipoEstadoSolicitudGeneral(String obraName, Integer idEstado, Integer page, Integer size) {
        return repo.listarPorObraIdTipoEstadoSolicitudGeneral(obraName,idEstado,PageRequest.of(page,size));
    }

    @Transactional
    @Override
    public SolicitudGeneral aprobarSolicitudGeneral(SolicitudGeneral body) {

        SolicitudGeneral solicitudGeneral= repo.findById(body.getIdSolicitudGeneral()).orElse(null);
        List<SolicitudGeneralDetalle> solicitudGeneralDetalleOld=solicitudGeneral.getSolicitudGeneralDetalle();
        List<SolicitudGeneralDetalle> solicitudGeneralDetalleActual= body.getSolicitudGeneralDetalle();
        List<SolicitudGeneralDetalle>solicitudGeneralDetalleAuxOld= new ArrayList<>();
        List<SolicitudGeneralDetalle>solicitudGeneralDetalleAuxOld2= solicitudGeneral.getSolicitudGeneralDetalle();
        List<SolicitudGeneralDetalle> solicitudGeneralDetalleFinal= new ArrayList<>();

        if(solicitudGeneral.getSolicitudGeneralDetalle().size()>0){
            //validar coincidencias
            solicitudGeneralDetalleOld.forEach(sdo->{
                solicitudGeneralDetalleActual.forEach(sda->{
                    if(Objects.equals(sdo.getCentroResponsabilidad().getIdCentroResponsabilidad(), sda.getCentroResponsabilidad().getIdCentroResponsabilidad())){
                        sda.setIdSolicitudDetalle(sdo.getIdSolicitudDetalle());

                        solicitudGeneralDetalleAuxOld.add(sdo);// Coincidencias modificar
                        solicitudGeneralDetalleFinal.add(sda);
                    }
                });
            });

            SolicitudGeneral solicitudGeneralNew= repo.findById(body.getIdSolicitudGeneral()).orElse(null);
            List<SolicitudGeneralDetalle> solicitudGeneralDetalleOld2=solicitudGeneralNew.getSolicitudGeneralDetalle();
            List<SolicitudGeneralDetalle>solicitudGeneralDetalleAuxNew= new ArrayList<>();
            List<SolicitudGeneralDetalle>solicitudGeneralDetalleAuxNew2= new ArrayList<>();
            solicitudGeneralDetalleAuxNew2=body.getSolicitudGeneralDetalle();

            solicitudGeneralDetalleActual.forEach(sda->{
                solicitudGeneralDetalleOld2.forEach(sdo->{
                    if(Objects.equals(sda.getCentroResponsabilidad().getIdCentroResponsabilidad(), sdo.getCentroResponsabilidad().getIdCentroResponsabilidad())){
                        if(sda.getIdSolicitudDetalle()!=null){
                            sda.setIdSolicitudDetalle(sdo.getIdSolicitudDetalle());
                        }
                        solicitudGeneralDetalleAuxNew.add(sda);
                    }
                });
            });

            if (solicitudGeneralDetalleAuxOld.size()>0){
                solicitudGeneralDetalleAuxOld2.removeAll(solicitudGeneralDetalleAuxOld);
                repoDetalle.deleteAll(solicitudGeneralDetalleAuxOld2);
            }

            if(solicitudGeneralDetalleAuxOld.size()==0){
                repoDetalle.deleteAll(solicitudGeneralDetalleOld);
            }

            if(solicitudGeneralDetalleAuxNew.size()>0){
                solicitudGeneralDetalleAuxNew2.removeAll(solicitudGeneralDetalleAuxNew);
                solicitudGeneralDetalleFinal.addAll(solicitudGeneralDetalleAuxNew2);
            }
            if(solicitudGeneralDetalleAuxNew.size()==0){
                solicitudGeneralDetalleFinal.addAll((solicitudGeneralDetalleAuxNew2));
            }

            log.info(solicitudGeneralDetalleFinal.toString());

            List<SolicitudGeneralDetalle>solicitudGeneralDetalleList= new ArrayList<>();

            /*Actualizar o registrar detalle */
            solicitudGeneralDetalleFinal.forEach(det -> {
                det.setSolicitudGeneral(body);
                if(det.getIdSolicitudDetalle()==null){
                    det.setFechaRegistro(new Date());
                    repoDetalle.save(det);
                }else{
                    SolicitudGeneralDetalle solicitudGeneralDetalle = repoDetalle.findById(det.getIdSolicitudDetalle()).orElse(null);
                    solicitudGeneralDetalle.setModiporPer(det.getModiporPer());
                    solicitudGeneralDetalle.setFechaActualiza(new Date());
                    solicitudGeneralDetalle.setModiporPer(det.getModiporPer());
                    solicitudGeneralDetalle.setIdDistribucionPonderacion(det.getIdDistribucionPonderacion());
                    solicitudGeneralDetalle.setIdTipoDistribucion(det.getIdTipoDistribucion());
                    solicitudGeneralDetalle.setImporte(det.getImporte());
                    solicitudGeneralDetalleList.add(solicitudGeneralDetalle);
                }
                repoDetalle.saveAll(solicitudGeneralDetalleList);
            });
        }

        List<SolicitudGeneralDetalle> sgd= new ArrayList<>();
        /*Actualizando solicitud*/
        solicitudGeneral.setIdUsuarioAutoriza(body.getIdUsuarioAutoriza());
        solicitudGeneral.setFechaActualiza(new Date());
        solicitudGeneral.setSolicitudGeneralDetalle(sgd);
        solicitudGeneral.setDetalle(body.getDetalle());
        solicitudGeneral.setModiporPer(body.getModiporPer());
        solicitudGeneral.setIdTipoModoPago(body.getIdTipoModoPago());
        solicitudGeneral.setCuentaBanco(body.getCuentaBanco());
        solicitudGeneral.setImporteAprobado(body.getImporteAprobado());
        solicitudGeneral.setPlanContable(body.getPlanContable());
        solicitudGeneral.setIdEstado(Constants.ESTADO_SOLICITUD.AUTORIZADO);
        solicitudGeneral.setActividadPresupuestal(body.getActividadPresupuestal());
        return repo.save(solicitudGeneral);
    }

    @Override
    public SolicitudGeneral desaprobarSolicitudGenertal(SolicitudGeneral s) {
        SolicitudGeneral sg= repo.findById(s.getIdSolicitudGeneral()).orElse(null);
        sg.setIdEstado(Constants.ESTADO_SOLICITUD.NO_AUTORIZADO);
        sg.setModiporPer(s.getModiporPer());
        sg.setIdUsuarioAutoriza(s.getIdUsuarioAutoriza());
        sg.setDetalle(s.getDetalle());
        sg.setFechaActualiza(new Date());

        return repo.save(sg);
    }

    @Override
    public SolicitudGeneral modificarEstadoSolicitudGeneral(Long idSolicitudGeneral,Integer idEstado,String userUpdate) {
        SolicitudGeneral sg= repo.findById(idSolicitudGeneral).orElse(null);
        sg.setIdEstado(idEstado);
        sg.setModiporPer(userUpdate);
        sg.setFechaActualiza(new Date());
        if(Constants.ESTADO_SOLICITUD.ANULADO.equals(idEstado)){
            sg.setFlgEstado(Constants.FLAG_ESTADO.INACTIVO);
        }
        return repo.save(sg);
    }

    @Override
    public void actualizarEstado(Integer idEstado, Long idSolicitudGeneral) {
         repo.actualizarEstado(idEstado,idSolicitudGeneral);
    }

    @Override
    public void actualizarEstadoRendimiento() {

    }

}
