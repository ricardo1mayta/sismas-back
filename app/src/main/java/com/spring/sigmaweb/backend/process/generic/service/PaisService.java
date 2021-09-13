package com.spring.sigmaweb.backend.process.generic.service;

import com.spring.sigmaweb.backend.process.generic.model.Pais;
import com.spring.sigmaweb.backend.process.generic.repository.IPaisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaisService implements IPaisService {
    @Autowired
    private IPaisDao paisDao;

    @Override
    @Transactional(readOnly = true)
    public List<Pais> findAll() {

        return (List<Pais>) paisDao.findAll();
    }
}
