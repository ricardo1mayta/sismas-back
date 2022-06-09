package com.spring.sigmaweb.backend.process.legajo.service;

import com.spring.sigmaweb.backend.process.legajo.dto.PersonalDesvinculacionDTO;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalDocDesvDTO;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalDesvinculacion;
import com.spring.sigmaweb.backend.process.legajo.reports.ReportDesvinculacion;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface IPersonalDesvinculacionService {
    public PersonalDesvinculacion findByIdPerDesv(Long idPerDesv);

    public PersonalDesvinculacion findByPersonalDesvinculacionActivos(Long idpersonal, String idobra, Long idperdesv, Long idpervila);

    public PersonalDesvinculacion findByPersonalDesvinculacionId(Long idpersonal, String idobra, Long idperdesv);

    public PersonalDesvinculacionDTO findByPersonalDesvinculacionActivosDTO(Long idpersonal, String idobra, Long idperdesv, Long idpervila);

    public List<PersonalDesvinculacionDTO> findByPersonalDesvinculacionActivosListDTO(Long idpersonal, String idobra, Long idpervila);

    public List<PersonalDesvinculacionDTO> findByPersonalDesvinculacionListDTO(Long idpersonal, String idobra);

    public PersonalDesvinculacion save (PersonalDesvinculacion desvinculacion);

    //procedimiento
    public Long countByIdObraPerentrAndIdTipoDocDesvPerentr(String idObraPerentr, Long idTipoDocDesvPerentr);

    public void update_spu_desvinculacion (Long id_personal, String obra, Long idpervila, String usermodi, Date datetermino, Integer habilita );

    public String insertNativePersoDocDesv (PersonalDocDesvDTO perdocDesv);

    public Integer updatePerdocDesvincula(String idperentr, String obraname, Long idperdesv, Boolean flgEnt, Double monto, Date fecha, String idfile);

    public Integer deletePersonalDocDesv(String idperentr, String obraname, Long idperdesv);

    //reportes
    public List<ReportDesvinculacion> reportDesvinculacionesColaborador(String idobra, Integer estadoper, Integer tipogrupo, Integer tipoplanilla, Integer tipoDesvinculacion, Integer fechaini, Integer Fechafin, String ordenOpcion);

    public List<ReportDesvinculacion> reportDesvinculacionesChecklistColaborador(String idobra, Integer estadoper, Integer tipogrupo, Integer tipoplanilla, Integer tipoDesvinculacion, Integer fechaini, Integer Fechafin, Integer estadoEntrega, String ordenOpcion);
}
