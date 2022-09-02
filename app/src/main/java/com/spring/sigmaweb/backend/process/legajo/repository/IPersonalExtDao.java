package com.spring.sigmaweb.backend.process.legajo.repository;

import com.spring.sigmaweb.backend.process.legajo.dto.PersonalDatosListDTO;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalExt;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IPersonalExtDao extends CrudRepository<PersonalExt, Long> {
    @Query("select new com.spring.sigmaweb.backend.process.legajo.dto.PersonalDatosListDTO( p.idPersonalExt as idPersonal, "
            + "o.idobra, "
            + " p.idPersonalExt as idPerSigma, "
            + "ps.nombrePers, "
            + "ps.apePaternoPers, "
            + "ps.apeMaternoPers, "
            + "TRIM( concat(COALESCE(concat(ps.apePaternoPers,' '), ''), COALESCE(concat(ps.apeMaternoPers, ' '), ''), COALESCE(ps.nombrePers, '')) ) as nomCompleto, "
            + "'' as fotoPer, "
            + "COALESCE(p.codigoPerext,'') as codigoPer, "
            + "ps.nroDocPers, "
            + "ps.emailCorPers as emailcorp, "
            + "ps.emailPers as emailpers, "
            + "ps.sexoPers,"
            + "p.estadoPerext as estadoPer,"
            + "now() as fechaAutorizaPer , " +
            "p.fechaModiPerext as fechaModiPer," +
            "p.fechaIngPerExt as fechaIngPer" +
            ") "
            + "from PersonalExt p inner join Obra o on (p.idObraPerext = o.idobra) "
            + "inner join Persona ps on (p.idPersPerext = ps.idPersona) "
            + "where o.idobra=?1 and p.idPersonalExt = ?2"
    )
    public PersonalDatosListDTO findByObraAndidPersonalExternoBasico(String obraname, Long idpersonal);
}
