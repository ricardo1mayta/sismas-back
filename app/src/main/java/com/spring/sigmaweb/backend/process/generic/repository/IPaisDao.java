package com.spring.sigmaweb.backend.process.generic.repository;

import com.spring.sigmaweb.backend.process.generic.model.Departamento;
import com.spring.sigmaweb.backend.process.generic.model.Pais;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPaisDao extends CrudRepository<Pais,Long> {
    @Query("select p "
            + "from Pais p " +
            "order by p.nombrePais")
    public List<Pais> findAll();
}
