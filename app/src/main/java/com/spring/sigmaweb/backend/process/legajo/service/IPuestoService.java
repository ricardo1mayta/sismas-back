package com.spring.sigmaweb.backend.process.legajo.service;

import com.spring.sigmaweb.backend.process.legajo.model.Puestos;

import java.util.List;

public interface IPuestoService {
    public Puestos findByIdPuestoAndIdObraPues(Long idPuesto, String idObraPues);

    public Puestos findByCodigoPuesAndIdObraPues(String codigoPues, String idObraPues);

    public List<Puestos> findByIdObraPuesAndEstadoPues(String idObraPues, Boolean estadoPues);

    public List<Puestos> findByIdObraPues(String idObraPues);

    public Puestos save(Puestos puestos);

}
