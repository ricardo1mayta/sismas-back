package com.spring.sigmaweb.backend.process.legajo.service;

import com.spring.sigmaweb.backend.process.legajo.dto.PuestosDto;
import com.spring.sigmaweb.backend.process.legajo.model.Puestos;
import com.spring.sigmaweb.backend.process.legajo.repository.IPuestoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PuestService implements IPuestoService{
    @Autowired
    private IPuestoDao puestoDao;

    @Override
    @Transactional(readOnly = true)
    public Puestos findByIdPuestoAndIdObraPues(Long idPuesto, String idObraPues) {
        return puestoDao.findByIdPuestoAndIdObraPues(idPuesto,idObraPues);
    }

    @Override
    @Transactional(readOnly = true)
    public Puestos findByCodigoPuesAndIdObraPues(String codigoPues, String idObraPues) {
        return puestoDao.findByCodigoPuesAndIdObraPues(codigoPues, idObraPues);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PuestosDto> findByIdObraPuesAndEstadoPues(String idObraPues, Boolean estadoPues) {
        return puestoDao.findByIdObraPuesAndEstadoPues(idObraPues, estadoPues);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PuestosDto> findByIdObraPues(String idObraPues) {
        return puestoDao.findByIdObraPues(idObraPues);
    }

    @Override
    @Transactional
    public Puestos save(Puestos puesto) {
        return puestoDao.save(puesto);
    }
}
