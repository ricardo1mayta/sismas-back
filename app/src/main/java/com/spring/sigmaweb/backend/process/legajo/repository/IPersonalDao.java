package com.spring.sigmaweb.backend.process.legajo.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.spring.sigmaweb.backend.process.legajo.dto.PersonalDTO;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalDatosListDTO;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalDatosMedicosDTO;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalDatosPersonalesDTO;
import com.spring.sigmaweb.backend.process.legajo.model.Personal;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IPersonalDao extends CrudRepository<Personal, Long>{
    public Personal findByIdPersonal(Long idPersonal);

    @Query("select p "
            + "from Personal p inner join Obra o on (p.obraPer = o.idobra) "
            + "where p.idPersonal=?1 and o.idobra=?2")
    public Personal findByIdPersonalAndObraname(Long idpersonal, String obraname);

    @Query("select new com.spring.sigmaweb.backend.process.legajo.dto.PersonalDTO (p.idPersonal,"
            + " p.codigoPer,"
            + "	o.idobra,"
            + "	ps.nombrePers,"
            + "	ps.apePaternoPers,"
            + "	ps.apeMaternoPers,"
            + "	ps.fechaNacPers,"
            + " doc.codigoTab as idTipoDocPer,"
            + "	ps.nroDocPers,"
            + "	ps.emailPers,"
            + "	ps.celularPers,"
            + "	ps.sexoPers)"
            + " from Personal p inner join Obra o on (p.obraPer = o.idobra) "
            + " inner join Persona ps on (p.idPersona = ps.idPersona) "
            + "	inner join TablasTabla doc on (ps.idTipoDocPers = doc.codigoTab) "
            + "where ps.nroDocPers = ?1 and o.idobra=?2"
    )
    public PersonalDTO findByNroDocPerAndobraPersonal(String nroDocPer, String obraname);

    @Query("select new com.spring.sigmaweb.backend.process.legajo.dto.PersonalDatosPersonalesDTO (p.idPersonal, "
            + "o.idobra, "
            + "p.idPerSigma, "
            + "psn.nombrePers, "
            + "psn.apePaternoPers, "
            + "psn.apeMaternoPers, "
            + "p.fotoPer, "
            + "p.codigoPer, "
            + "doc.codigoTab as idTipoDocPer, "
            + "doc.descripTab as descDocuPer, "
            + "psn.nroDocPers, "
            + "psn.idPaisDocPers, "
            + "ps.nombrePais as paisotorgadoc, "
            + "etc.codigoTab as estCivilPer, "
            + "etc.descripTab as descEstCivilPer, "
            + "psn.fecCambioEstCivilPers, "
            + "psn.sexoPers, "

            + "psn.celularPers, "
            + "psn.celularBPers, "
            + "psn.telefonoFijoPers, "
            + "psn.emailPers, "
            + "psn.emailCorPers, "
            + "p.estadoPer, "
            + "p.contactoEmerPer, "
            + "p.telefContEmerPer, "
            + "p.idParentContEmerPer, "
            + "tce.descripTab as descContEmerPer, "

            + "psn.religionProfesaPers, "
            + "p.numeroEssaludPer, "
            + "p.numeroEpsPer, "
            + "ee.nombreEnt as nomEntEPS, "
            + "ee.idEntidad as idEntEPS, "
            + "p.numeroPensionPer, "
            + "ep.idEntidad as idEntPen, "
            + "ep.nombreEnt as nomEntPen, "
            + "tpn.codigoTab as idTipoPensionPer, "
            + "tpn.descripTab as descPensionPer, "
            + "psn.fechaNacPers, "

            + "psn.idPaisNacPers, "
            + "pn.nombrePais as paisnac, "
            + "psn.nacionalidadPers, "
            + "psn.idDistNacPers, "
            + "dn.nombreDist as nombreDistNacPer, "
            + "vn.idProv as idprovNacPer, "
            + "vn.nombreProv as nomprovNacPer, "
            + "tn.idDepa as iddepaNacPer, "
            + "tn.nombreDepa as nomdepaNacPer,"

            + "psn.observaNacPers, "
            + "psn.tipoViaDomiPers, "
            + "tvia.descripTab as descViaPer, "
            + "psn.domicilioPers, "
            + "psn.numeroDomiPers, "
            + "psn.interiorDomiPers, "
            + "psn.tipoZonaDomiPers, "
            + "tzona.descripTab as desczonaPer, "
            + "psn.nombreZonaDomiPers, "
            + "dd.idDist as idDistDomiPer, "
            + "dd.nombreDist as nomDistDomiPer, "

            + "vd.idProv as idprovDomPer, "
            + "vd.nombreProv as nomprovDomPer,"
            + "td.idDepa as iddepaDomPer, "
            + "td.nombreDepa as nomdepaDomPer, "

            + "psn.observacionDomiPers, "
            + "p.flgEsDiscapacitadoPer, "
            + "p.especDiscapacidadPer, "
            + "p.fechaIngPer, "
            + "p.creaPorPer, "
            + "p.fechaActivoPer, "
            + "p.fechaBajaPer, "
            + "p.modiPorPer, "
            + "p.fechaAutorizaPer) "
            + "from Personal p inner join Obra o on (p.obraPer = o.idobra) "
            + "inner join Persona psn on (p.idPersona = psn.idPersona) "
            + "inner join TablasTabla doc on (psn.idTipoDocPers = doc.codigoTab) "
            + "inner join Pais ps on (psn.idPaisDocPers = ps.idpais) "
            + "inner join TablasTabla etc on (psn.estCivilPers = etc.codigoTab) "
            + "left join Entidad ee on (p.idEntidadEpsPer = ee.idEntidad) "
            + "left join Entidad ep on (p.idEntidadPensPer = ep.idEntidad) "
            + "left join TablasTabla tpn on (p.idTipoPensionPer = tpn.codigoTab) "
            + "left join Pais pn on (psn.idPaisNacPers = pn.idpais) "
            + "left join Distrito dn on (psn.idDistNacPers = dn.idDist) "
            + "left join Provincia vn on (dn.provincia = vn.idProv) "
            + "left join Departamento tn on (vn.departamento = tn.idDepa) "
            + "left join TablasTabla tvia on (psn.tipoViaDomiPers = tvia.codigoTab) "
            + "left join TablasTabla tzona on (psn.tipoZonaDomiPers = tzona.codigoTab) "
            + "left join Distrito dd on (psn.idDistDomiPers = dd.idDist) "
            + "left join Provincia vd on (dd.provincia = vd.idProv) "
            + "left join Departamento td on (vd.departamento = td.idDepa) "
            + "left join TablasTabla tce on (p.idParentContEmerPer = tce.codigoTab) "
            + "where p.idPersonal = ?1 and o.idobra=?2 "
    )
    public PersonalDatosPersonalesDTO findByIdPersonaAndObraPersonalInfoPersonal(Long idpersonal, String obraname);

    @Query("select new com.spring.sigmaweb.backend.process.legajo.dto.PersonalDatosMedicosDTO (p.idPersonal, "
            + "o.idobra, "
            + "p.idPerSigma, "
            + "ps.nombrePers, "
            + "ps.apePaternoPers, "
            + "ps.apeMaternoPers, "
            + "p.fotoPer, "
            + "p.codigoPer, "
            + "doc.codigoTab as idTipoDocPer, "
            + "doc.descripTab as descDocuPer, "
            + "ps.nroDocPers, "
            + "ps.sexoPers, "

            + "p.numeroEssaludPer, "
            + "p.numeroEpsPer, "
            + "ee.nombreEnt as nomEntEPS, "
            + "ee.idEntidad as idEntEPS, "
            + "ps.fechaNacPers, "

            + "p.flgEsDiscapacitadoPer, "
            + "p.factorSangPer, "
            + "p.grupoSangPer, "
            + "p.flgDonaSangrePer, "
            + "p.flgEsHipertensoPer, "
            + "p.flgEsDiabeticoPer, "
            + "p.flgcancerPer, "
            + "p.flgEnferCardioPer, "
            + "p.flgEnferPulmonPer, "
            + "p.flgEsInmunoSupresorPer, "
            + "p.flgAsmaPer, "
            + "p.flgTrabajoAltoRiesgoPer, "
            + "p.nroPolizaPer, "
            + "p.nombreCompPolizaPer, "
            + "p.beneficiarioPolizaPer, "

            + "p.fechaIngPer, "
            + "p.creaPorPer, "
            + "p.fechaActivoPer, "
            + "p.fechaBajaPer) "
            + "from Personal p inner join Obra o on (p.obraPer = o.idobra) "
            + "inner join Persona ps on (p.idPersona = ps.idPersona) "
            + "inner join TablasTabla doc on (ps.idTipoDocPers = doc.codigoTab) "
            + "left join Entidad ee on (p.idEntidadEpsPer = ee.idEntidad) "
            + "where p.idPersonal = ?1 and o.idobra=?2 "
    )
    public PersonalDatosMedicosDTO findByIdPersonaAndObraInfoMedico(Long idpersonal, String obraname);

    @Query("select new com.spring.sigmaweb.backend.process.legajo.dto.PersonalDatosListDTO( p.idPersonal, "
            + "o.idobra, "
            + "p.idPerSigma, "
            + "ps.nombrePers, "
            + "ps.apePaternoPers, "
            + "ps.apeMaternoPers, "
            + "TRIM( concat(COALESCE(concat(ps.apePaternoPers,' '), ''), COALESCE(concat(ps.apeMaternoPers, ' '), ''), COALESCE(ps.nombrePers, '')) ) as nomCompleto, "
            + "p.fotoPer, "
            + "COALESCE(p.codigoPer,'') as codigoPer, "
            + "ps.nroDocPers, "
            + "ps.sexoPers, "
            + "p.estadoPer,"
            + "p.fechaAutorizaPer ) "
            + "from Personal p inner join Obra o on (p.obraPer = o.idobra) "
            + "inner join Persona ps on (p.idPersona = ps.idPersona) "
            + "where o.idobra=?1 "
    )
    public List<PersonalDatosListDTO> findByIdPersonalAndObraList(String obraname);

    @Query("select new com.spring.sigmaweb.backend.process.legajo.dto.PersonalDatosListDTO( p.idPersonal, "
            + "o.idobra, "
            + "p.idPerSigma, "
            + "ps.nombrePers, "
            + "ps.apePaternoPers, "
            + "ps.apeMaternoPers, "
            + "TRIM( concat(COALESCE(concat(ps.apePaternoPers,' '), ''), COALESCE(concat(ps.apeMaternoPers, ' '), ''), COALESCE(ps.nombrePers, '')) ) as nomCompleto, "
            + "p.fotoPer, "
            + "COALESCE(p.codigoPer,'') as codigoPer, "
            + "ps.nroDocPers, "
            + "ps.sexoPers,"
            + "p.estadoPer, "
            + "p.fechaAutorizaPer ) "
            + "from Personal p inner join Obra o on (p.obraPer = o.idobra) "
            + "inner join Persona ps on (p.idPersona = ps.idPersona) "
            + "where o.idobra=?1 and p.estadoPer = ?2"
    )
    public List<PersonalDatosListDTO> findByObraAndEstadoPerList(String obraname, Boolean estadoper);

    @Query("select new com.spring.sigmaweb.backend.process.legajo.dto.PersonalDatosListDTO( p.idPersonal, "
            + "o.idobra, "
            + "p.idPerSigma, "
            + "ps.nombrePers, "
            + "ps.apePaternoPers, "
            + "ps.apeMaternoPers, "
            + "TRIM( concat(COALESCE(concat(ps.apePaternoPers,' '), ''), COALESCE(concat(ps.apeMaternoPers, ' '), ''), COALESCE(ps.nombrePers, '')) ) as nomCompleto, "
            + "p.fotoPer, "
            + "COALESCE(p.codigoPer,'') as codigoPer, "
            + "ps.nroDocPers, "
            + "ps.sexoPers,"
            + "p.estadoPer,"
            + "p.fechaAutorizaPer ) "
            + "from Personal p inner join Obra o on (p.obraPer = o.idobra) "
            + "inner join Persona ps on (p.idPersona = ps.idPersona) "
            + "where o.idobra=?1 and p.idPersonal = ?2"
    )
    public PersonalDatosListDTO findByObraAndidPersonalBasico(String obraname, Long idpersonal);

    @Query("select new com.spring.sigmaweb.backend.process.legajo.dto.PersonalDTO (p.idPersonal,"
            + " p.codigoPer,"
            + "	o.idobra,"
            + "	ps.nombrePers,"
            + "	ps.apePaternoPers,"
            + "	ps.apeMaternoPers,"
            + "	ps.fechaNacPers,"
            + " doc.codigoTab as idTipoDocPer,"
            + "	ps.nroDocPers,"
            + "	ps.emailPers,"
            + "	ps.celularPers,"
            + "	ps.sexoPers) "
            + " from Personal p inner join Obra o on (p.obraPer = o.idobra) "
            + " inner join Persona ps on (p.idPersona = ps.idPersona) "
            + " inner join TablasTabla doc on (ps.idTipoDocPers = doc.codigoTab) "
            + "where o.idobra = ?1 and p.idPersonal=?2 and p.codigoPer=?3 "
    )
    public PersonalDTO findByObraAndidPersonalAndCodigoPer(String obraname, Long idpersonal, String codper);

    @Transactional
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query("update Personal p set p.fechaAutorizaPer = now() "
            + "where p.idPersonal = ?1")
    public Integer updateFechaConfirPersonal(Long idpersonal);

}
