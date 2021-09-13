package com.spring.sigmaweb.backend.process.generic.service;

import com.spring.sigmaweb.backend.process.generic.model.Departamento;
import com.spring.sigmaweb.backend.process.generic.repository.IDepartamentoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService implements IDepartamentoService {
    @Autowired
    private IDepartamentoDao departamentoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Departamento> findAll() {
        return (List<Departamento>) departamentoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Departamento> findById(Long id) {
        // TODO Auto-generated method stub
        return departamentoDao.findById(id);
    }
}
