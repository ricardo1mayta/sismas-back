package com.spring.sigmaweb.backend.process.legajo.repository;

import com.spring.sigmaweb.backend.process.legajo.model.Cargo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICargoDao extends CrudRepository<Cargo, Long> {
    public Cargo findByIdCargo(Long idcargo);

    public List<Cargo> findAll();
}
