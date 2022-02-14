package com.spring.sigmaweb.backend.process.legajo.service;

import com.spring.sigmaweb.backend.process.legajo.dto.PersonalCargosDTO;
import com.spring.sigmaweb.backend.process.legajo.model.Cargo;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalCargo;
import com.spring.sigmaweb.backend.process.legajo.repository.ICargoDao;
import com.spring.sigmaweb.backend.process.legajo.repository.IPersonalCargosDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonalCargoService implements IPersonalCargoService{

    @Autowired
    private ICargoDao cargoDao;

    @Autowired
    private IPersonalCargosDao personalcargoDao;

    @Override
    @Transactional(readOnly = true)
    public PersonalCargo findByIdPercargo(Long idPercargo) {
        return personalcargoDao.findByIdPercargo(idPercargo);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonalCargo findByPersonalAndObraAndIdCargo(Long idpersona, String idobra, Long idpercargo, Long idpervila) {
        return personalcargoDao.findByPersonalAndObraAndIdCargo(idpersona, idobra, idpercargo, idpervila);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonalCargo> findByPersonalAndObraList(Long idpersona, String idobra, Long idpervila) {
        return personalcargoDao.findByPersonalAndObraList(idpersona, idobra, idpervila);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonalCargosDTO findPersonalAndObraAndCargoDto(Long idpersona, String idobra, Long idpercargo, Long idpervila) {
        return personalcargoDao.findPersonalAndObraAndCargoDto(idpersona, idobra, idpercargo, idpervila);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonalCargosDTO> findPersonalAndObraListDto(Long idpersona, String idobra, Long idpervila) {
        return personalcargoDao.findPersonalAndObraListDto(idpersona, idobra, idpervila);
    }

    @Override
    @Transactional
    public PersonalCargo save(PersonalCargo cargo) {
        return personalcargoDao.save(cargo);
    }

    //CARGO

    @Override
    @Transactional(readOnly = true)
    public Cargo findByIdCargo(Long idcargo) {
        return cargoDao.findByIdCargo(idcargo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cargo> findAll() {
        return cargoDao.findAll();
    }
}
