package com.spring.sigmaweb.backend.process.surveys.repository;

import com.spring.sigmaweb.backend.process.surveys.model.Competencia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICompetenciaDao extends CrudRepository<Competencia,Long> {
    public Competencia findByIdCompetencia(Long idcompetencia);

    public List<Competencia> findByFlgActivoCompeOrderByDescripcionCompe(Boolean flgactivocompe);

    public Competencia findByIdCompetenciaAndIdEventoCompe(Long idcompetencia, Long ideventocompe);

    @Query("select c " +
            "from Competencia c inner join EventosPeriodo epe on (c.idEventoCompe = epe.idEvento) " +
            "inner join Periodo pe on (epe.idPeriodoEvent = pe.idPeriodo and epe.idObraEvent = pe.idObraPeri) " +
            "where epe.idObraEvent = 'SECTOR' and pe.idPeriodo = ?1 " +
            "order by c.descripcionCompe"
    )
    public List<Competencia> findByCompetenciaForPeriodo (Long idperiodo);

}
