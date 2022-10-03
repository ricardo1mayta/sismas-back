package com.spring.sigmaweb.backend.process.tesoreria.egresos.service;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.dtoResumen.CuentaBancoListDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.CuentaBanco;

import java.util.List;

public interface CuentaBancoService extends ICRUD<CuentaBanco,Long>{

    List<CuentaBanco> listarPorObraCuentaBanco(String idObra);
    List<CuentaBanco> listarPorTipoMonedaYObraCuentaBanco(String idObra, Integer idTipoMoneda);
    CuentaBanco buscarPorIdCuentaBanco(Long idCuentaBanco);
    List<CuentaBancoListDTO>listarPorObraCuentaBancoDTO(String idObra);
}
