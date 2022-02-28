package com.spring.sigmaweb.backend.process.legajo.repository;

import com.spring.sigmaweb.backend.process.legajo.dto.ItemListVidaLaboralDTO;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalVidaLabDTO;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalVidaLaboral;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPersonalVidaLaboralDao extends CrudRepository<PersonalVidaLaboral,Long> {
    public PersonalVidaLaboral findByIdPervilaAndIdObraPervila (Long idPervila, String idObraPervila);

    @Query("select vl " +
            "from PersonalVidaLaboral vl inner join Obra o on (vl.idObraPervila = o.idobra) " +
            "inner join Personal p on (vl.idPersonalPervila = p.idPersonal and o.idobra = p.obraPer) " +
            "where o.idobra = ?1 and p.idPersonal = ?2 and vl.idPervila=?3"
    )
    public PersonalVidaLaboral findByObraPersonalId(String idobra, Long idpersonal, Long idpervila);

    @Query("select vl " +
            "from PersonalVidaLaboral vl inner join Obra o on (vl.idObraPervila = o.idobra) " +
            "inner join Personal p on (vl.idPersonalPervila = p.idPersonal and o.idobra = p.obraPer) " +
            "where o.idobra = ?1 and p.idPersonal = ?2 and vl.estadoPervila = (case ?3 when '_' then vl.estadoPervila else ?3 end) "
    )
    public List<PersonalVidaLaboral> findByObraPersonalEstado(String idobra, Long idpersonal, String estado);

    @Query("Select new com.spring.sigmaweb.backend.process.legajo.dto.PersonalVidaLabDTO(vl.idPervila," +
            "o.idobra, " +
            "p.idPersonal as idPersonalPervila, " +
            "psn.apePaternoPers, " +
            "psn.apeMaternoPers, " +
            "psn.nombrePers, " +
            "p.codigoPer, " +
            "vl.fechaInicioPervila, " +
            "vl.fechaFinPervila, " +
            "vl.estadoPervila, " +
            "vl.creaPorPervila," +
            "vl.fechaIngPervila," +
            "vl.modiPorPervila," +
            "vl.fechaModiPervila" +
            ")" +
            "from PersonalVidaLaboral vl inner join Obra o on (vl.idObraPervila = o.idobra) " +
            "inner join Personal p on (vl.idPersonalPervila = p.idPersonal and o.idobra = p.obraPer) " +
            "inner join Persona psn on (p.idPersona = psn.idPersona and p.obraPer=psn.obraPers) " +
            "where o.idobra = ?1 and p.idPersonal = ?2 and vl.idPervila=?3"
    )
    public PersonalVidaLabDTO findByObraPersonalIdDTO(String idobra, Long idpersonal, Long idpervila);

    @Query("Select new com.spring.sigmaweb.backend.process.legajo.dto.PersonalVidaLabDTO(vl.idPervila," +
            "o.idobra, " +
            "p.idPersonal as idPersonalPervila, " +
            "psn.apePaternoPers, " +
            "psn.apeMaternoPers, " +
            "psn.nombrePers, " +
            "p.codigoPer, " +
            "vl.fechaInicioPervila, " +
            "vl.fechaFinPervila, " +
            "vl.estadoPervila, " +
            "vl.creaPorPervila," +
            "vl.fechaIngPervila," +
            "vl.modiPorPervila," +
            "vl.fechaModiPervila" +
            ")" +
            "from PersonalVidaLaboral vl inner join Obra o on (vl.idObraPervila = o.idobra) " +
            "inner join Personal p on (vl.idPersonalPervila = p.idPersonal and o.idobra = p.obraPer) " +
            "inner join Persona psn on (p.idPersona = psn.idPersona and p.obraPer=psn.obraPers) " +
            "where o.idobra = ?1 and p.idPersonal = ?2 " +
            "order by vl.fechaInicioPervila desc, vl.idPervila desc"
    )
    public List<PersonalVidaLabDTO> findByObraPersonalListDTO(String idobra, Long idpersonal);

}
