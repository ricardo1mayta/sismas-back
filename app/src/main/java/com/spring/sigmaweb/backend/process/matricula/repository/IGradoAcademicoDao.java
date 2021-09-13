package com.spring.sigmaweb.backend.process.matricula.repository;

import com.spring.sigmaweb.backend.process.matricula.model.Formacion;
import com.spring.sigmaweb.backend.process.matricula.model.GradoAcademico;
import com.spring.sigmaweb.backend.process.matricula.model.NivelAcademico;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IGradoAcademicoDao extends CrudRepository<GradoAcademico, Long> {
    public GradoAcademico findByIdGrado(Long idGrado);

    @Query("select ga "
            + "from GradoAcademico ga inner join NivelAcademico n on (ga.nivelAcademico = n.idNivel) "
            + "where n.idNivel = ?1"
    )
    public List<GradoAcademico> findByGradoForIdNivel(Long idnivel);

    @Query("select n "
            + "from NivelAcademico n inner join Formacion f on (n.formacionAcademico = f.idFormacion) "
            + "where f.idFormacion = ?1"
    )
    public List<NivelAcademico> findByNivelForIdFormacion(Long idformacion);

    @Query("select f from Formacion f "
    )
    public List<Formacion> listFormacion();
}
