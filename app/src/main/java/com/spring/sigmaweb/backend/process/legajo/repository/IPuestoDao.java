package com.spring.sigmaweb.backend.process.legajo.repository;

import com.spring.sigmaweb.backend.process.legajo.model.Puestos;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPuestoDao extends CrudRepository<Puestos, Long> {
    public Puestos findByIdPuestoAndIdObraPues(Long idPuesto, String idObraPues);

    public Puestos findByCodigoPuesAndIdObraPues(String codigoPues, String idObraPues);

    public List<Puestos> findByIdObraPuesAndEstadoPues(String idObraPues, Boolean estadoPues);

    public List<Puestos> findByIdObraPues(String idObraPues);
}
