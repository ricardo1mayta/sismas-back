package com.spring.sigmaweb.backend.process.generic.service;

import com.spring.sigmaweb.backend.process.generic.model.Obra;
import com.spring.sigmaweb.backend.process.generic.repository.IobraDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ObraServiceImpl implements IObraService {
    @Autowired
    private IobraDao obraDao;

    @Override
    @Transactional(readOnly = true)
    public List<Obra> findAll() {
        return (List<Obra>) obraDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Obra> findById(String id) {
        return obraDao.findById(id);
    }
}
