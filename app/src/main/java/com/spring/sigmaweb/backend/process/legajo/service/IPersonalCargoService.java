package com.spring.sigmaweb.backend.process.legajo.service;

import com.spring.sigmaweb.backend.process.legajo.dto.CargosDto;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalCargosDTO;
import com.spring.sigmaweb.backend.process.legajo.model.Cargo;
import com.spring.sigmaweb.backend.process.legajo.model.CargoTReg;
import com.spring.sigmaweb.backend.process.legajo.model.DocumentEmployee;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalCargo;
import com.spring.sigmaweb.backend.process.legajo.reports.ReportPuestosCargos;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IPersonalCargoService {

    public PersonalCargo findByIdPercargo(Long idPercargo);

    public PersonalCargo findByPersonalAndObraAndIdCargo(Long idpersona, String idobra, Long idpercargo, Long idpervila);

    public List<PersonalCargo> findByPersonalAndObraList(Long idpersona, String idobra, Long idpervila);

    public PersonalCargosDTO findPersonalAndObraAndCargoDto(Long idpersona, String idobra, Long idpercargo, Long idpervila);

    public List<PersonalCargosDTO> findPersonalAndObraListDto(Long idpersona, String idobra, Long idpervila);

    public PersonalCargo save(PersonalCargo cargo);

    public void personalcargodelete(PersonalCargo personalcargo);

    //cargo
    public Cargo findByIdCargo(Long idcargo);

    public List<Cargo> findAll();

    public List<Cargo> findByIdTipoGoCarAndEstadoCarOrderByNombreCar(Integer Idtipogocar, Boolean estadocar);

    public List<CargosDto> findCargosDto(Boolean estado);

    public Cargo savecargo(Cargo cargo);

    public void delete(Cargo cargo);

    //Cargo TR
    public CargoTReg findByIdCargoTr(Long idCargoTr);

    public List<CargoTReg> findAllCargoTr();


}
