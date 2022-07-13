package com.spring.sigmaweb.backend.process.surveys.repository;

import com.spring.sigmaweb.backend.process.surveys.dto.PreguntasCompetenciaDTO;
import com.spring.sigmaweb.backend.process.surveys.model.PreguntasCompetencia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPreguntasCompetenciaDao extends CrudRepository<PreguntasCompetencia,Long> {
    
    public PreguntasCompetencia findByIdPregcomp(Long idpregcomp);

    public PreguntasCompetencia findByIdCompetenciaPregcompAndIdPreguntaPregcompAndIdGrupoPregcompAndIdEventoPregcompAndIdPregcomp(Long idcompetenciapregcomp, Long idpreguntapregcomp, Integer idgrupopregcomp, Long ideventopregcomp,Long idpregcomp);
    
    @Query("select new com.spring.sigmaweb.backend.process.surveys.dto.PreguntasCompetenciaDTO(" +
            "pc.idPregcomp," +
            "pc.idCompetenciaPregcomp," +
            "comp.descripcionCompe as descripcionCompetencia," +
            "pc.idPreguntaPregcomp," +
            "pre.descripcionPreg as descripcionPregunta," +
            "pc.idGrupoPregcomp," +
            "tabgo.nombreTipoTab as descripcionGrupo," +
            "pc.idEventoPregcomp," +
            "evpe.nombreEvent as descripcionEvento," +
            "peri.idPeriodo as idPeriodoEvento," +
            "peri.anioPeri as anioPeriodoEvento," +
            "pc.flgActivoPregcomp," +
            "pc.fechaingPregcomp," +
            "pc.creaporPregcomp" +
            ")" +
            "from PreguntasCompetencia pc inner join EventosPeriodo evpe on (pc.idEventoPregcomp = evpe.idEvento) " +
            "inner join Periodo peri on (evpe.idPeriodoEvent = peri.idPeriodo and evpe.idObraEvent = peri.idObraPeri) " +
            "inner join Obra o on (evpe.idObraEvent = o.idobra) " +
            "inner join Pregunta pre on (pc.idPreguntaPregcomp = pre.idPregunta and evpe.idEvento = pre.idEventoPreg) " +
            "inner join Competencia comp on (pc.idCompetenciaPregcomp = comp.idCompetencia and evpe.idEvento = comp.idEventoCompe) " +
            "inner join TablasTabla tabgo on (pc.idGrupoPregcomp = tabgo.codigoTab ) " +
            "where o.idobra = 'SECTOR' and pc.idEventoPregcomp=?1 and pc.idGrupoPregcomp=?2 and pc.idCompetenciaPregcomp=?3 "
    )
    public List<PreguntasCompetenciaDTO> findByIdEventoPregcompAndIdGrupoPregcompAndIdCompetenciaPregcompDto(Long Ideventopregcomp, Integer idgrupopregcomp, Long idcompetenciapregcomp);

    @Query("select distinct new com.spring.sigmaweb.backend.process.surveys.dto.PreguntasCompetenciaDTO(" +
            "pc.idCompetenciaPregcomp," +
            "comp.descripcionCompe as descripcionCompetencia," +
            "pc.idGrupoPregcomp," +
            "tabgo.nombreTipoTab as descripcionGrupo," +
            "pc.idEventoPregcomp," +
            "evpe.nombreEvent as descripcionEvento," +
            "peri.idPeriodo as idPeriodoEvento," +
            "peri.anioPeri as anioPeriodoEvento " +
            ")" +
            "from PreguntasCompetencia pc inner join EventosPeriodo evpe on (pc.idEventoPregcomp = evpe.idEvento) " +
            "inner join Periodo peri on (evpe.idPeriodoEvent = peri.idPeriodo and evpe.idObraEvent = peri.idObraPeri) " +
            "inner join Obra o on (evpe.idObraEvent = o.idobra) " +
            "inner join Competencia comp on (pc.idCompetenciaPregcomp = comp.idCompetencia and evpe.idEvento = comp.idEventoCompe) " +
            "inner join TablasTabla tabgo on (pc.idGrupoPregcomp = tabgo.codigoTab ) " +
            "where o.idobra = 'SECTOR' and pc.idEventoPregcomp=?1 and pc.idGrupoPregcomp=?2 "
    )
    public List<PreguntasCompetenciaDTO> findByIdEventoPregcompAndIdGrupoPregcompDtoDistinct(Long Ideventopregcomp, Integer idgrupopregcomp);

}
