package com.spring.sigmaweb.backend.process.legajo.repository;

import com.spring.sigmaweb.backend.process.legajo.dto.PersonalDocDesvDTO;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalDocDesvinculacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPersonalDocDesvinculacionDao extends CrudRepository<PersonalDocDesvinculacion, Long> {

    public PersonalDocDesvinculacion findByIdPerentrAndIdPerdesvPerentrAndIdObraPerentr (Long idPerentr, Long idPerdesvPerentr, String idObraPerentr);

    public List<PersonalDocDesvinculacion> findByIdPerdesvPerentrAndIdObraPerentr (Long idPerdesvPerentr, String idObraPerentr);

    @Query("Select new com.spring.sigmaweb.backend.process.legajo.dto.PersonalDocDesvDTO(pdd.idPerentr," +
            "pdd.idPerdesvPerentr, " +
            "o.idobra as idObraPerentr, " +
            "pdd.idTipoDocDesvPerentr, " +

            "dv.descripcionDocdesv, " +
            "dv.tipoDocdesv, " +
            "dv.descripcionGrupoDocdesv, " +
            "dv.flgInsertarMontoDocdesv, " +
            "dv.flgAdjuntarFileDocdesv," +

            "pdd.flgEntregoPerentr, " +
            "pdd.montoPerentr, " +
            "pdd.fechaEjecucionPerentr," +
            "pdd.idResponsablePerentr" +
            ") " +
            "from PersonalDocDesvinculacion pdd inner join DocumentoDesvinculacion dv on (pdd.idTipoDocDesvPerentr = dv.idDocdesv and pdd.idObraPerentr = dv.idObraDocdesv) " +
            "inner join Obra o on (pdd.idObraPerentr = o.idobra) " +
            "where pdd.idPerdesvPerentr=?1 and o.idobra=?2 "
    )
    public List<PersonalDocDesvDTO> findDesvinculacionAndIdObralist(Long perdesv, String idobra);

    @Query("Select new com.spring.sigmaweb.backend.process.legajo.dto.PersonalDocDesvDTO(pdd.idPerentr," +
            "pdd.idPerdesvPerentr, " +
            "o.idobra as idObraPerentr, " +
            "pdd.idTipoDocDesvPerentr, " +

            "dv.descripcionDocdesv, " +
            "dv.tipoDocdesv, " +
            "dv.descripcionGrupoDocdesv, " +
            "dv.flgInsertarMontoDocdesv, " +
            "dv.flgAdjuntarFileDocdesv," +

            "pdd.flgEntregoPerentr, " +
            "pdd.montoPerentr, " +
            "pdd.fechaEjecucionPerentr," +
            "pdd.idResponsablePerentr" +
            ") " +
            "from PersonalDocDesvinculacion pdd inner join DocumentoDesvinculacion dv on (pdd.idTipoDocDesvPerentr = dv.idDocdesv and pdd.idObraPerentr = dv.idObraDocdesv) " +
            "inner join Obra o on (pdd.idObraPerentr = o.idobra) " +
            "where pdd.idPerdesvPerentr=?1 and o.idobra=?2 and pdd.idObraPerentr=?3")
    public PersonalDocDesvDTO findDesvinculacionAndIdObraAndId(Long perdesv, String idobra, Long idperentr);

}
