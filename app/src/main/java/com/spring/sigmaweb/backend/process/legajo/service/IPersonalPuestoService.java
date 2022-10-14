package com.spring.sigmaweb.backend.process.legajo.service;

import com.spring.sigmaweb.backend.process.legajo.dto.PersonalPuestoDTO;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalPuesto;
import com.spring.sigmaweb.backend.process.legajo.reports.ReportPuestosCargos;

import java.util.List;

public interface IPersonalPuestoService {

    public List<PersonalPuesto> findByIdPersonalAndIdobraAndIdPervila(Long idpersona, String idobra, Long idpervila);

    public PersonalPuesto findByIdPersonalAndIdobraAndIdPervilaAndId(Long idpersona, String idobra, Long idpervila, Long idperpuesto);

    public List<PersonalPuestoDTO> findByObraPersonalVidaLab(Long idpersona, String idobra, Long idpervila);

    public PersonalPuestoDTO findByObraPersonalVidaLabId(Long idpersona, String idobra, Long idpervila, Long idperpuest);

    public PersonalPuesto save (PersonalPuesto newPuesto);

    //REPORTES

    public List<ReportPuestosCargos> reportPuestosCargosPorObra (String idobra, Integer estadoper, Integer tipogrupo, Integer tipoplanilla, Integer idtipopuesto, String ordenOpcion, Integer periodoIni, Integer periodoFin, Boolean verBonificacion);

    public List<ReportPuestosCargos> reportPuestosCargosPorPersonalObra (String idobra, Long idPersonal);
}
