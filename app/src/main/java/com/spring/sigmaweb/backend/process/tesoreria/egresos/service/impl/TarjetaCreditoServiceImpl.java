package com.spring.sigmaweb.backend.process.tesoreria.egresos.service.impl;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.TarjetaCredito;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.IGenericRepo;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.TarjetaCreditoRepository;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.TarjetaCreditoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TarjetaCreditoServiceImpl extends CRUDImpl<TarjetaCredito,Long > implements TarjetaCreditoService {

    private final TarjetaCreditoRepository repo;

    @Override
    protected IGenericRepo<TarjetaCredito, Long> getRepo() {

        return repo;
    }


    @Override
    public List<TarjetaCredito> listarPorIdObra(String idObra) {
        return repo.findByidObra(idObra);
    }

    @Override
    public List<TarjetaCredito> listarPorIdCuentaBancoYObra(Long idCuentaBanco, String idObra) {
        return repo.findByIdAndCuentaBancoAndIdObra(idObra ,idCuentaBanco);
    }
}
