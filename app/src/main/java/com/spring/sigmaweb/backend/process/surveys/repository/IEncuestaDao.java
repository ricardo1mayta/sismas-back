package com.spring.sigmaweb.backend.process.surveys.repository;

import com.spring.sigmaweb.backend.process.surveys.model.CierreEvaluacionDesemp;
import com.spring.sigmaweb.backend.process.surveys.model.Encuesta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IEncuestaDao extends CrudRepository<Encuesta,Long> {

    public Encuesta findByIdMatrizevalEncuestaAndIdObraEncuesta(Long idMatrizevalEncuesta, String idObraEncuesta);

    @Query("select enc " +
            "from Encuesta enc inner join Obra o on (enc.idObraEncuesta = o.idobra) " +
            "inner join MatrizEvaluacion m on (enc.idMatrizevalEncuesta = m.idMatrizEval and o.idobra = m.idObraMaev) " +
            "inner join EventosPeriodo ep on (m.idEventoMaev = ep.idEvento) " +
            "where m.idMatrizEval = ?1 and o.idobra = ?2 and ep.idEvento = ?3 "
    )
    public Encuesta findByIdMatrizevalEncuestaAndIdObraEncuestaAndEvento(Long idMatrizevalEncuesta, String idObraEncuesta, Long idevento);

    @Query("select enc " +
            "from Encuesta enc " +
            "inner join Obra o on (enc.idObraEncuesta = o.idobra) " +
            "inner join MatrizEvaluacion m on (enc.idMatrizevalEncuesta = m.idMatrizEval and o.idobra = m.idObraMaev) " +
            "inner join EventosPeriodo ep on (m.idEventoMaev = ep.idEvento) " +
            "where enc.idEncuesta = ?1 and m.idMatrizEval = ?2 and o.idobra = ?3 and ep.idEvento = ?4 "
    )
    public Encuesta findByIdEncuestaAndIdMatrizevalEncuestaAndIdObraEncuestaAndEvento(Long idEncuesta, Long idMatrizevalEncuesta, String idObraEncuesta, Long idevento);

    @Query("select ced  " +
            "from EventosPeriodo ep inner join Obra o on (ep.idObraEvent = o.idobra ) " +
            "inner join Periodo p on (ep.idPeriodoEvent = p.idPeriodo and p.idObraPeri = o.idobra) " +
            "inner join CierreEvaluacionDesemp ced on (ep.idEvento = ced.idEventoCierreeval and ced.idObraCierreeval=?1) " +
            "where o.idobra='SECTOR' " +
            "and ced.idObraCierreeval = ?1 and ep.idEvento = ?2 " +
            "and CONVERT( concat(DATE_FORMAT(ced.fechaCierreeval, '%Y%m%d'), coalesce(ced.horaCierreeval, '2359')), SIGNED) < CONVERT(DATE_FORMAT(now(), '%Y%m%d%H%i'), SIGNED)   "
    )
    public CierreEvaluacionDesemp findEstadoCierreEvaluacion(String idobra, Long idevento);
}
