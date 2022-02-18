package com.spring.sigmaweb.backend.process.legajo.repository;

import com.spring.sigmaweb.backend.process.legajo.dto.PersonalDocDesvDTO;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalDocDesvinculacion;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public interface IPersonalDocDesvinculacionDao extends CrudRepository<PersonalDocDesvinculacion, String> {

    public PersonalDocDesvinculacion findByIdPerentrAndIdPerdesvPerentrAndIdObraPerentr(String idPerentr, Long idPerdesvPerentr, String idObraPerentr);

    public List<PersonalDocDesvinculacion> findByIdPerdesvPerentrAndIdObraPerentr(Long idPerdesvPerentr, String idObraPerentr);

    public Long countByIdObraPerentrAndIdTipoDocDesvPerentr(String idObraPerentr, Long idTipoDocDesvPerentr);

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
            "pdd.idResponsablePerentr," +
            "pdd.idfileUploadPerentr" +
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
            "pdd.idResponsablePerentr," +
            "pdd.idfileUploadPerentr" +
            ") " +
            "from PersonalDocDesvinculacion pdd inner join DocumentoDesvinculacion dv on (pdd.idTipoDocDesvPerentr = dv.idDocdesv and pdd.idObraPerentr = dv.idObraDocdesv) " +
            "inner join Obra o on (pdd.idObraPerentr = o.idobra) " +
            "where pdd.idPerdesvPerentr=?1 and o.idobra=?2 and pdd.idPerentr=?3")
    public PersonalDocDesvDTO findDesvinculacionAndIdObraAndId(Long perdesv, String idobra, String idperentr);

    //Guarda con un insert
    @Transactional
    @Modifying
    @Query(
            value = "insert into mo_personal_docdesv (id_perentr, id_perdesv_perentr, id_obra_perentr, id_tipodocudesv_perentr, id_responsable_perentr, flg_entrego_perentr) " +
                    "values (:idperentr,:perdesv ,:obra ,:tipo ,:respon , false)",
            nativeQuery = true)
    void insertNativePersoDocDesv(@Param("idperentr") String idperentr, @Param("perdesv") Long perdesv, @Param("obra") String obra, @Param("tipo") Long tipo, @Param("respon") String respon);

    //update
    @Transactional
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query("update PersonalDocDesvinculacion pdd set flgEntregoPerentr = ?4, " +
            "montoPerentr = ?5, " +
            "fechaEjecucionPerentr = ?6, " +
            "idfileUploadPerentr=?7 " +
            "where pdd.idPerentr = ?1 and pdd.idObraPerentr = ?2 and pdd.idPerdesvPerentr=?3"
    )
    public Integer updatePerdocDesvincula(String idperentr,
                                          String obraname,
                                          Long idperdesv,
                                          Boolean flgEnt,
                                          Double monto,
                                          Date fecha,
                                          String idfile);
    //delete
    @Modifying
    @Query("DELETE FROM PersonalDocDesvinculacion pdd where pdd.idPerentr = ?1 and pdd.idObraPerentr = ?2 and pdd.idPerdesvPerentr=?3")
    public int deletePersonalDocDesv(String idperentr, String obraname, Long idperdesv);

}