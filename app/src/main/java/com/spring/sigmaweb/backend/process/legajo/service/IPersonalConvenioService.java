package com.spring.sigmaweb.backend.process.legajo.service;

import com.spring.sigmaweb.backend.process.legajo.dto.PersonalConveniosDTO;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalConvenio;
import com.spring.sigmaweb.backend.process.legajo.reports.ReportAgreement;

import java.util.List;

public interface IPersonalConvenioService {
    public PersonalConvenio findByIdPerConv(Long idPerConv);

    public PersonalConvenio findByPersonalAndObraAndConvenio(Long idpersonal, String idobra, Long idperconv, Long idpervila);

    public List<PersonalConvenio> findByPersonalAndObraList(Long idpersonal, String idobra, Long idpervila);

    public PersonalConveniosDTO findByPersonalAndObraAndConvenioDto(Long idpersona, String idobra, Long idperconv, Long idpervila);

    public List<PersonalConveniosDTO> findByPersonalAndObraListDto(Long idpersona, String idobra, Long idpervila);

    public List<PersonalConveniosDTO> findConvenioActivoPracticasListDto(Long idpersona, String idobra, Long idpervila);

    public PersonalConvenio save (PersonalConvenio convenio);


    //REPORTES
    public List<ReportAgreement> reportConveniosPorObra(String idobra, Integer estadoper, Integer tipogrupo, Integer tipoplanilla, Integer idtipoconvenio);
}
