package com.spring.sigmaweb.backend.process.generic.repository;

import com.spring.sigmaweb.backend.process.generic.model.Parametro;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IParametroDao extends CrudRepository<Parametro, Long> {
    public List<Parametro> findByEstadoPara(Boolean estadoparam);
}
