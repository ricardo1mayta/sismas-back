package com.spring.sigmaweb.backend.process.tesoreria.egresos.service;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.ImpresoraCajaDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.Impresora;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.ImpresoraCaja;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IImpresoraService {
    List<ImpresoraCajaDTO> findByIdObraAndFlgEstado (String idobra,Integer flgestado);

    Impresora findByIdObraAndIdImpresora(String idobra, Long idimpresora);

    Impresora findByIdimpresorasCajaObra(@Param("idobra") String idobra, @Param("idcaja") Long idcaja, @Param("idimpresora") Long idimpresora);

    List<ImpresoraCaja> findByImpresorasCajaObraTodos(@Param("idobra") String idobra, @Param("idcaja") Long idcaja);

    List<ImpresoraCajaDTO> findByImpresorasCajaSelect(String idobra, Long idcaja, Integer estado);


    ImpresoraCaja saveImpresoraCaja(ImpresoraCaja impresoracaja);

    Integer deleteImpresoraCaja(String idobra, Long idcaja, Long idimpresora);
}
