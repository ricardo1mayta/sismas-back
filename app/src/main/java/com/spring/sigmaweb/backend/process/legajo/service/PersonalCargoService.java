package com.spring.sigmaweb.backend.process.legajo.service;

import com.spring.sigmaweb.backend.process.legajo.dto.CargosDto;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalCargosDTO;
import com.spring.sigmaweb.backend.process.legajo.model.Cargo;
import com.spring.sigmaweb.backend.process.legajo.model.CargoTReg;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalCargo;
import com.spring.sigmaweb.backend.process.legajo.reports.ReportPuestosCargos;
import com.spring.sigmaweb.backend.process.legajo.repository.ICargoDao;
import com.spring.sigmaweb.backend.process.legajo.repository.ICargoTRegDao;
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
    private ICargoTRegDao cargoTrDao;

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

    @Override
    @Transactional
    public void personalcargodelete(PersonalCargo personalcargo) {
        personalcargoDao.delete(personalcargo);
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
        return cargoDao.findAllByOrderByNombreCar();
    }

    @Override
    @Transactional(readOnly = true)
    public List<CargosDto> findCargosDto(Boolean estado) {
        return cargoDao.findCargosDto(estado);
    }

    @Override
    @Transactional
    public Cargo savecargo(Cargo cargo) {
        return cargoDao.save( cargo);
    }

    @Override
    @Transactional
    public void delete(Cargo cargo) {
        cargoDao.delete(cargo);
    }

    //CARGO TR
    @Override
    @Transactional(readOnly = true)
    public CargoTReg findByIdCargoTr(Long idCargoTr) {
        return cargoTrDao.findByIdCargoTr(idCargoTr);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CargoTReg> findAllCargoTr() {
        return cargoTrDao.findAll();
    }




}
