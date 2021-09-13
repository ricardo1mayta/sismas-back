package com.spring.sigmaweb.backend.process.generic.service;

import com.spring.sigmaweb.backend.process.generic.model.Provincia;
import com.spring.sigmaweb.backend.process.generic.repository.IProvinciaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProvinciaService implements IProvinciaService {
    @Autowired
    private IProvinciaDao provinciaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Provincia> findByDepartamento(Long idDepa) {
        return (List<Provincia>) provinciaDao.findByDepartamento(idDepa);
    }

    @Override
    public Optional<Provincia> findById(Long id) {
        // TODO Auto-generated method stub
        return provinciaDao.findById(id);
    }
}
