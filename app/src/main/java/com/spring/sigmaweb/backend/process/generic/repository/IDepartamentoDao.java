package com.spring.sigmaweb.backend.process.generic.repository;

import com.spring.sigmaweb.backend.process.generic.model.Departamento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IDepartamentoDao extends CrudRepository<Departamento, Long> {
    @Query("select d "
            + "from Departamento d " +
            "order by d.nombreDepa")
    public List<Departamento> findAll();
}
