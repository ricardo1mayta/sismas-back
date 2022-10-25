package com.spring.sigmaweb.backend.process.tesoreria.egresos.service;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.TarjetaCreditoDataDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.TarjetaCredito;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TarjetaCreditoService extends ICRUD<TarjetaCredito,Long>{

    List<TarjetaCredito> listarPorIdObra(String idObra);
    List<TarjetaCredito> listarPorIdCuentaBancoYObra(Long idCuentaBanco, String idObra);

    List<TarjetaCreditoDataDTO> findByidObraEstado(String idObra, Integer estado);

    TarjetaCredito save(TarjetaCredito tarjetaCredito);
}
