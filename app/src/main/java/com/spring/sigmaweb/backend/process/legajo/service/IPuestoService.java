package com.spring.sigmaweb.backend.process.legajo.service;

import com.spring.sigmaweb.backend.process.legajo.dto.PuestosDto;

import com.spring.sigmaweb.backend.process.legajo.model.Puestos;

import java.util.List;

public interface IPuestoService {
    public Puestos findByIdPuestoAndIdObraPues(Long idPuesto, String idObraPues);

    public Puestos findByCodigoPuesAndIdObraPues(String codigoPues, String idObraPues);

    public List<PuestosDto> findByIdObraPuesAndEstadoPues(String idObraPues, Boolean estadoPues);

    public List<PuestosDto> findByIdObraPues(String idObraPues);

    public List<PuestosDto> findByIdObraPuesAndEstadoPuesAndGrupoOcupa(String idObraPues, Boolean estadoPues, Integer idgo);

    public Puestos save(Puestos puestos);

    public void delete(Puestos puesto);

}
