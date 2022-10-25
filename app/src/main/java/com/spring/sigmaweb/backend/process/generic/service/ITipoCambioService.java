package com.spring.sigmaweb.backend.process.generic.service;

import com.spring.sigmaweb.backend.process.generic.dto.TipoCambioDTO;
import com.spring.sigmaweb.backend.process.generic.model.TipoCambio;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ITipoCambioService {
    TipoCambio findByIdTipoCambio(Long idTipoCambio);
    TipoCambio save(TipoCambio tipoCambio);
    TipoCambio update(TipoCambio tipoCambio);
    void delete(Long idTipoCambio);
    List<TipoCambio> findByidObra(String idObra);
    TipoCambio findByIdOBraAndDate(String idObra, Date fecha);

    List<TipoCambioDTO> findByIdObraDto(String idObra);

    TipoCambio findByIdOBraAndDateAndMoneda(String idObra, Date fecha, Integer moneda);
}
