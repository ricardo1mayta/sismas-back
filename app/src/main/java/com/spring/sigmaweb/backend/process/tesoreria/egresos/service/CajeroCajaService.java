package com.spring.sigmaweb.backend.process.tesoreria.egresos.service;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.CajeroCajaDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.CajeroCaja;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CajeroCajaService {
    CajeroCaja findByIdObraAndIdCajaAndIdUsuario (String idobra, Long idcaja, Long idusuario);

    List<CajeroCaja> findByIdObraAndIdUsuario (String idobra, Long idusuario);

    List<CajeroCaja> findByIdObraAndIdCaja (String idobra, Long idCaja);

    List<CajeroCajaDTO> findByIdObraAndIdCajaAndIdUsuarioDTO (String idobra, Long idusuario);

    List<CajeroCajaDTO> findByIdObraAndIdCajaAndIdUsuarioDistintDTO (String idobra);

    CajeroCaja saveCajeroCaja (CajeroCaja cajeroCaja);

    Integer deleteCajeroCaja (String idobra, Long idcaja, Long idusuario);

    void delete (CajeroCaja cajeroCaja);

}
