package com.spring.sigmaweb.backend.process.tesoreria.egresos.service;

import com.spring.sigmaweb.backend.process.core.dto.usuarioDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.CajeroCajaDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.Caja;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.CajeroCaja;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CajeroCajaService {

    CajeroCaja findByIdObraAndIdCajeroCaja (String idobra, Long idCajeroCaja);

    CajeroCaja findByIdObraAndIdCajaAndIdUsuario (String idobra, Long idcaja, Long idusuario);

    List<CajeroCaja> findByIdObraAndIdUsuario (String idobra, Long idusuario);

    List<CajeroCaja> findByIdObraAndIdCaja (String idobra, Long idCaja);

    List<CajeroCajaDTO> findByIdObraAndIdCajaAndIdUsuarioDTO (String idobra, Long idusuario);

    List<CajeroCajaDTO> findByIdObraAndIdCajaAndIdUsuarioDistintDTO (String idobra);

    List<usuarioDTO> findByIdObraSinCajaDTO (@Param("idobra") String idobra);

    List<Caja> findByCajasSinCajero (@Param("idobra") String idobra);

    CajeroCaja saveCajeroCaja (CajeroCaja cajeroCaja);

    Integer deleteCajeroCaja (String idobra, Long idcaja, Long idusuario);

    void delete (CajeroCaja cajeroCaja);

}
