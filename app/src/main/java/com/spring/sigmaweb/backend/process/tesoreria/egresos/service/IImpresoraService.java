package com.spring.sigmaweb.backend.process.tesoreria.egresos.service;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.ImpresoraCajaDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.Impresora;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IImpresoraService {
    List<ImpresoraCajaDTO> findByIdObraAndFlgEstado (String idobra,Integer flgestado);

    Impresora findByIdObraAndIdImpresora(String idobra, Long idimpresora);

    List<ImpresoraCajaDTO> findByImpresorasCajaSelect(String idobra, Long idcaja, Integer estado);
}
