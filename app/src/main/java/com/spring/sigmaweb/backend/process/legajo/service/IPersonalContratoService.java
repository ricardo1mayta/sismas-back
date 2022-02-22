package com.spring.sigmaweb.backend.process.legajo.service;

import com.spring.sigmaweb.backend.process.core.model.RolSideNavItem;
import com.spring.sigmaweb.backend.process.legajo.dto.HistoricoVilaLabotalDTO;
import com.spring.sigmaweb.backend.process.legajo.dto.JornadaPersonalContratoDTO;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalContratoObraDTO;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalContrato;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalContratoJornada;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalHistoricoVinculoLaboral;

import java.util.List;

public interface IPersonalContratoService {
    public PersonalContrato findByIdPerCont(Long idPerCont);

    public PersonalContrato findByPersonalAndObraAndcontrato(Long idpersona, String idobra, Long idpercont, Long idpervila);

    public List<PersonalContrato> findByPersonalAndObraList(Long idpersona, String idobra, Long idpervila);

    public PersonalContratoObraDTO findByPersonalAndObraAndcontratoDto(Long idpersona, String idobra, Long idpercont, Long idpervila);
    public List<PersonalContratoObraDTO> findByPersonalAndObraAndcontratoDtoList(Long idpersona, String idobra, Long idpervila);
    public List<PersonalContratoObraDTO> findContratoActivoPersonalObra(Long idpersona, String idobra, Long idpervila);

    public PersonalContrato save (PersonalContrato contrato);

    //************** JORNADA *********************

    public PersonalContratoJornada findByIdPerjorn(Long idPerjorn);

    public PersonalContratoJornada findByJornadaPersonalAndObraAndcontrato(Long idpersona, String idobra, Long idpercont, Long idperjorn);

    public List<PersonalContratoJornada> findByJornadaPersonalAndObraAndcontratoList(Long idpersona, String idobra, Long idpercont);

    public JornadaPersonalContratoDTO findIdJornadaPersonalAndObraAndContratoDTO(Long idpersona, String idobra, Long idpercont, Long idperjorn);

    public List<JornadaPersonalContratoDTO> findJornadasPersonalAndObraAndContratoDTOList(Long idpersona, String idobra, Long idpercont);

    public void deleteAll(List<PersonalContratoJornada> jornadas);

    public void delete(PersonalContratoJornada jornada);

    public PersonalContratoJornada save (PersonalContratoJornada jornada);
    //historico contrato

    public PersonalHistoricoVinculoLaboral findByIdObraHistvilaAndIdPersonalHistvilaAndIdPervilaHistvilaAndIdPercontHistvilaAndIdHistvila(
            String idObraHistvila, Long idPersonalHistvila, Long idPervilaHistvila, Long idPercontHistvila, Long idHistvila
    );

    public List<PersonalHistoricoVinculoLaboral> findByObraAndPersonalAndVidaLabAndContratoAndtipoList(
            String idObraHistvila, Long idPersonalHistvila, Long idPervilaHistvila, Long idPercontHistvila, String tipoHistvila
    );

    public List<HistoricoVilaLabotalDTO> findByObraAndPersonalAndVidaLabAndContratoAndtipoListDto(
            String idObraHistvila, Long idPersonalHistvila, Long idPervilaHistvila, Long idPercontHistvila, String tipoHistvila
    );

    public PersonalHistoricoVinculoLaboral saveHistVidaLab(PersonalHistoricoVinculoLaboral historico);

}
