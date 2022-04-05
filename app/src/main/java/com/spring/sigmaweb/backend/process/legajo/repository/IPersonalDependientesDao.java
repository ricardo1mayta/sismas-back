package com.spring.sigmaweb.backend.process.legajo.repository;

import java.util.List;

import com.spring.sigmaweb.backend.process.legajo.dto.PersonalDependienteDTO;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalDependiente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IPersonalDependientesDao extends CrudRepository<PersonalDependiente, Long>{
    public PersonalDependiente findByIdPersonalDep(Long idPersonalDep);

    @Query("select pd "
            + "from PersonalDependiente pd inner join Personal p on (pd.personalDep = p.idPersonal) "
            + "inner join Obra o on (p.obraPer = o.idobra) "
            + "where pd.idPersonalDep = ?1 and p.idPersonal = ?2 and o.idobra = ?3 "
    )
    public PersonalDependiente findByIdPersonalAndObraname(Long idpersonaldep, Long idpersonal, String obraname);

    @Query("select pd "
            + "from PersonalDependiente pd inner join Personal p on (pd.personalDep=p.idPersonal) "
            + "inner join Obra o on (p.obraPer = o.idobra) "
            + "where p.idPersonal=?1 and o.idobra=?2 "
    )
    public List<PersonalDependiente> findByIdPersonalAndObranameList(Long idpersonal, String obraname);

    @Query("select new com.spring.sigmaweb.backend.process.legajo.dto.PersonalDependienteDTO (pd.idPersonalDep, "
            + "p.idPersonal, "
            + "o.idobra, "
            + "parent.codigoTab as idparentPerDep, "
            + "parent.descripTab as descparentPerDep, "
            + "pd.flgvive, " +
            "pd.flgDiscapacidadPerdep,"
            + "pd.nombrePerDep, "
            + "pd.apPaternoPerDep, "
            + "pd.apMaternoPerDep, "
            + "pd.sexoAPerDep, "
            + "estciv.codigoTab as idEstcivPerDep, "
            + "estciv.descripTab as descEstcivPerDep, "
            + "docu.codigoTab as idTipodocPerDep, "
            + "docu.descripTab as descTipodocPerDep, "
            + "pd.nroDocPerDep, "
            + "pd.fechaNacPerDep, "
            + "pd.telefonoPerDep, "
            + "pd.nacionalidadPerDep, "
            + "pd.gradoAcademicoPerDep, "
            + "ga.nombreGrado, "
            + "na.idNivel, "
            + "na.nombreNvel, "
            + "fa.idFormacion, "
            + "fa.nombreFormacion, "
            + "pd.flgEstudiaActPerDep, "
            + "pd.nombreInstEducPerDep, "
            + "pd.creaPorPerDep, "
            + "pd.fechaIngPerDep, "
            + "pd.modiPorPerDep ) "
            + "from PersonalDependiente pd inner join Personal p on (pd.personalDep=p.idPersonal) "
            + "inner join Obra o on (p.obraPer = o.idobra) "
            + "inner join TablasTabla parent on (pd.parentescoPerDep = parent.codigoTab) "
            + "inner join TablasTabla estciv on (pd.estCivilPerDep = estciv.codigoTab) "
            + "inner join TablasTabla docu on (pd.idTipoDocPerDep = docu.codigoTab) "
            + "left join GradoAcademico ga on (pd.gradoAcademicoPerDep = ga.idGrado) "
            + "left join NivelAcademico na on (ga.nivelAcademico = na.idNivel) "
            + "left join Formacion fa on (na.formacionAcademico = fa.idFormacion) "
            + "where p.idPersonal=?1 and o.idobra=?2"
    )
    public List<PersonalDependienteDTO> findByIdPersonalAndIdObra(Long idpersonal, String idobra);

    @Query("select new com.spring.sigmaweb.backend.process.legajo.dto.PersonalDependienteDTO (pd.idPersonalDep, "
            + "p.idPersonal, "
            + "o.idobra, "
            + "parent.codigoTab as idparentPerDep, "
            + "parent.descripTab as descparentPerDep, "
            + "pd.flgvive, " +
            "pd.flgDiscapacidadPerdep, "
            + "pd.nombrePerDep, "
            + "pd.apPaternoPerDep, "
            + "pd.apMaternoPerDep, "
            + "pd.sexoAPerDep, "
            + "estciv.codigoTab as idEstcivPerDep, "
            + "estciv.descripTab as descEstcivPerDep, "
            + "docu.codigoTab as idTipodocPerDep, "
            + "docu.descripTab as descTipodocPerDep, "
            + "pd.nroDocPerDep, "
            + "pd.fechaNacPerDep, "
            + "pd.telefonoPerDep, "
            + "pd.nacionalidadPerDep, "
            + "pd.gradoAcademicoPerDep, "
            + "ga.nombreGrado, "
            + "na.idNivel, "
            + "na.nombreNvel, "
            + "fa.idFormacion, "
            + "fa.nombreFormacion, "
            + "pd.flgEstudiaActPerDep, "
            + "pd.nombreInstEducPerDep, "
            + "pd.creaPorPerDep, "
            + "pd.fechaIngPerDep, "
            + "pd.modiPorPerDep ) "
            + "from PersonalDependiente pd inner join Personal p on (pd.personalDep=p.idPersonal) "
            + "inner join Obra o on (p.obraPer = o.idobra) "
            + "inner join TablasTabla parent on (pd.parentescoPerDep = parent.codigoTab) "
            + "inner join TablasTabla estciv on (pd.estCivilPerDep = estciv.codigoTab) "
            + "inner join TablasTabla docu on (pd.idTipoDocPerDep = docu.codigoTab) "
            + "left join GradoAcademico ga on (pd.gradoAcademicoPerDep = ga.idGrado) "
            + "left join NivelAcademico na on (ga.nivelAcademico = na.idNivel) "
            + "left join Formacion fa on (na.formacionAcademico = fa.idFormacion) "
            + "where pd.idPersonalDep=?1 and p.idPersonal=?2 and o.idobra=?3  "
    )
    public PersonalDependienteDTO findByIdPersonalAndIdObraAndIdPerDep(Long idpersonaldep, Long idpersonal, String idobra);

}
