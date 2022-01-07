package com.spring.sigmaweb.backend.process.legajo.service;

import com.spring.sigmaweb.backend.process.legajo.dto.PersonalCargosDTO;
import com.spring.sigmaweb.backend.process.legajo.model.Cargo;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalCargo;

import java.util.List;

public interface IPersonalCargoService {

    public PersonalCargo findByIdPercargo(Long idPercargo);

    public PersonalCargo findByPersonalAndObraAndIdCargo(Long idpersona, String idobra, Long idpercargo);

    public List<PersonalCargo> findByPersonalAndObraList(Long idpersona, String idobra);

    public PersonalCargosDTO findPersonalAndObraAndCargoDto(Long idpersona, String idobra, Long idpercargo);

    public List<PersonalCargosDTO> findPersonalAndObraListDto(Long idpersona, String idobra);

    public PersonalCargo save(PersonalCargo cargo);

    //cargo
    public Cargo findByIdCargo(Long idcargo);

    public List<Cargo> findAll();
}
