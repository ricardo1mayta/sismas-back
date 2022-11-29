package com.spring.sigmaweb.backend.process.tesoreria.egresos.service;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.CajaGeneralDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.CajaGeneral;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface CajaGeneralService {
    List<CajaGeneralDTO> findByIdObraAndCajaAndUsuarioDTO(String idobra, Long idusuario);

    CajaGeneral findByCajaAperturadaAndObra(String idobra, Long idusuario);

    CajaGeneral findByEstadoCajaActualUsuario(String idobra, Long idusuario);

    CajaGeneral findExistDateCajaGenObra(String idobra, Date fecha, Long idCaja);

    CajaGeneralDTO findByCajaActualDTO(String idobra, Long idusuario);

    CajaGeneralDTO findByCajaAperturadaAndObraDTO(String idobra, Long idusuario);

    CajaGeneral save(CajaGeneral cajageneral);
}
