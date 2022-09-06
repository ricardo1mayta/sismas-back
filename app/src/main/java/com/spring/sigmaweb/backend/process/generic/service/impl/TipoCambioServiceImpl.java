package com.spring.sigmaweb.backend.process.generic.service.impl;

import com.spring.sigmaweb.backend.process.generic.model.TipoCambio;
import com.spring.sigmaweb.backend.process.generic.repository.ITipoCambioDao;
import com.spring.sigmaweb.backend.process.generic.service.ITipoCambioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoCambioServiceImpl implements ITipoCambioService {

    private final ITipoCambioDao tipoCambioDao;


    @Override
    public TipoCambio findByIdTipoCambio(Long idTipoCambio) {
        return tipoCambioDao.findById(idTipoCambio).orElse(null);
    }

    @Override
    public TipoCambio save(TipoCambio tipoCambio) {
        return tipoCambioDao.save(tipoCambio);
    }

    @Override
    public TipoCambio update(TipoCambio tipoCambio) {
        return tipoCambioDao.save(tipoCambio);
    }

    @Override
    public void delete(Long idTipoCambio) {
         tipoCambioDao.deleteById(idTipoCambio);
    }

    @Override
    public List<TipoCambio> findByidObra(String idObra) {
        return tipoCambioDao.findByIdObra(idObra);
    }

    @Override
    public TipoCambio findByIdOBraAndDate(String idObra, Date fecha) {
        return tipoCambioDao.findByIdOBraAndDate(idObra,fecha);
    }
}
