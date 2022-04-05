package com.spring.sigmaweb.backend.process.legajo.repository;


import com.spring.sigmaweb.backend.process.legajo.model.CargoTReg;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICargoTRegDao extends CrudRepository<CargoTReg, Long> {

    public CargoTReg findByIdCargoTr(Long idCargoTr);

    public List<CargoTReg> findAll();
}
