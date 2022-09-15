package com.spring.sigmaweb.backend.process.tesoreria.egresos.service;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.SolicitudGeneralListaDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.SolicitudGeneral;
import org.springframework.data.domain.Page;

public interface ISolicitudGeneralService extends  ICRUD<SolicitudGeneral,Long> {

    SolicitudGeneral registrarTransaccional( SolicitudGeneral s) ;

    Page<SolicitudGeneralListaDTO> listarResumenSolicitudGeneral(String obraName, Integer page, Integer size);
    Page<SolicitudGeneralListaDTO> listarPorObraIdTipoEstadoSolicitudGeneral(String obraName,Integer idEstado , Integer page, Integer size);
    SolicitudGeneral aprobarSolicitudGeneral(SolicitudGeneral s);
    SolicitudGeneral desaprobarSolicitudGenertal(SolicitudGeneral s);
    SolicitudGeneral modificarEstadoSolicitudGeneral(Long idSolicitudGeneral, Integer idEstadoSolicitud, String userUpdate);
    void actualizarEstado(Integer idEstado, Long idSolicitudGeneral);
    void actualizarEstadoRendimiento();
}
