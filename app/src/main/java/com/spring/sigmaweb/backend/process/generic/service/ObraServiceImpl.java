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

    @Override
    public List<Obra> findAllAddCristoStamar() {
        List<Obra> obras= (List<Obra>) obraDao.findAll();
        Obra cristoRey= new Obra();
        cristoRey.setIdobra("CRISTO");
        cristoRey.setNombreobra("COLEGIO CRISTO REY - CAJAMARCA");
        Obra santaMaria= new Obra();
        santaMaria.setIdobra("STAMAR");
        santaMaria.setNombreobra("COLEGIO SANTA MARÍA DE LOS ANDES - VMT");

        obras.add(cristoRey);
        obras.add(santaMaria);
        return obras;
    }
}
