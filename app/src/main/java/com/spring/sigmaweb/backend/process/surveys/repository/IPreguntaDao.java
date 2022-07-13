package com.spring.sigmaweb.backend.process.surveys.repository;

import com.spring.sigmaweb.backend.process.surveys.model.Competencia;
import com.spring.sigmaweb.backend.process.surveys.model.Pregunta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPreguntaDao extends CrudRepository<Pregunta,Long> {
    public Pregunta findByIdPregunta(Long idpregunta);

    public List<Pregunta> findByFlgActivoPreg(Boolean flgactivopreg);

    public Pregunta findByIdPreguntaAndIdEventoPreg(Long idpregunta, Long ideventopreg);

    @Query("select p " +
            "from Pregunta p inner join EventosPeriodo epe on (p.idEventoPreg = epe.idEvento) " +
            "inner join Periodo pe on (epe.idPeriodoEvent = pe.idPeriodo and epe.idObraEvent = pe.idObraPeri) " +
            "where epe.idObraEvent = 'SECTOR' and pe.idPeriodo = ?1 "
    )
    public List<Pregunta> findByPreguntasForPeriodo(Long idperiodo);
}
