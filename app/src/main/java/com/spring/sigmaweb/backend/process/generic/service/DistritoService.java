package com.spring.sigmaweb.backend.process.generic.service;

import com.spring.sigmaweb.backend.process.generic.model.Distrito;
import com.spring.sigmaweb.backend.process.generic.repository.IDistritoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DistritoService implements IDistritoService{
    @Autowired
    private IDistritoDao distritoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Distrito> findByProvincia(Long idProv) {

        return (List<Distrito>) distritoDao.findByProvincia(idProv);
    }

    @Override
    public Optional<Distrito> findById(Long id) {
        // TODO Auto-generated method stub
        return distritoDao.findById(id);
    }
}
