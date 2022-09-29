package com.spring.sigmaweb.backend.process.tesoreria.egresos.service.impl;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.dtoResumen.CuentaBancoListDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.CuentaBanco;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.CuentaBancoRepository;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.IGenericRepo;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.CuentaBancoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CuentaBancoServiceImpl extends CRUDImpl<CuentaBanco,Long > implements CuentaBancoService {

    private final CuentaBancoRepository repo;

    @Override
    protected IGenericRepo<CuentaBanco, Long> getRepo() {
        return repo;
    }

    @Override
    public List<CuentaBanco> listarPorObraCuentaBanco(String idObra) {

        return repo.listarPorObraCuentaBanco(idObra);
    }

    @Override
    public List<CuentaBanco> listarPorTipoMonedaYObraCuentaBanco(String idObra, Integer idTipoMoneda) {
        return repo.listarPorTipoMonedaYObraCuentaBanco(idObra,idTipoMoneda);
    }

    @Override
    public CuentaBanco buscarPorIdCuentaBanco(Long idCuentaBanco) {
        return repo.buscarPorIdCuentaBanco(idCuentaBanco);
    }

    @Override
    public List<CuentaBancoListDTO> listarPorObraCuentaBancoDTO(String idObra) {
        return repo.listarPorObraCuentaBancoDTO(idObra);
    }

}
