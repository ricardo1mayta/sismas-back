package com.spring.sigmaweb.backend.process.legajo.repository;

import com.spring.sigmaweb.backend.process.legajo.dto.PersonalDesvinculacionDTO;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalDesvinculacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPersonalDesvinculacionDao extends CrudRepository<PersonalDesvinculacion, Long> {
    public PersonalDesvinculacion findByIdPerDesv(Long idPerDesv);

    @Query("select pd " +
            "from PersonalDesvinculacion pd inner join PersonalVidaLaboral pvl on (pd.idPervilaPerdesv = pvl.idPervila and pd.idObraPerdesv = pvl.idObraPervila) " +
            "inner join Personal p on (pd.idPersonalPerdesv = p.idPersonal and pd.idObraPerdesv = p.obraPer) " +
            "inner join Persona psn on (p.idPersona = psn.idPersona ) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "where p.idPersonal=?1 and o.idobra=?2 and pd.idPerDesv=?4 and pvl.idPervila=?3 and pd.estadoPerdesv=true"
    )
    public PersonalDesvinculacion findByPersonalDesvinculacionActivos(Long idpersonal, String idobra, Long idperdesv, Long idpervila);

    @Query("select pd " +
            "from PersonalDesvinculacion pd inner join PersonalVidaLaboral pvl on (pd.idPervilaPerdesv = pvl.idPervila and pd.idObraPerdesv = pvl.idObraPervila) " +
            "inner join Personal p on (pd.idPersonalPerdesv = p.idPersonal and pd.idObraPerdesv = p.obraPer) " +
            "inner join Persona psn on (p.idPersona = psn.idPersona ) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "where p.idPersonal=?1 and o.idobra=?2 and pd.idPerDesv=?3 "
    )
    public PersonalDesvinculacion findByPersonalDesvinculacionId(Long idpersonal, String idobra, Long idperdesv);

    @Query("select new com.spring.sigmaweb.backend.process.legajo.dto.PersonalDesvinculacionDTO(pd.idPerDesv," +
            "o.idobra as idObraPerdesv," +
            "p.idPersonal," +
            "pvl.idPervila, " +
            "pvl.fechaInicioPervila, " +
            "pvl.fechaFinPervila, " +
            "pvl.estadoPervila, " +
            "psn.apePaternoPers, " +
            "psn.apeMaternoPers, " +
            "psn.nombrePers, " +

            "pd.fechaCesePerdesv," +
            "tt.codigoTab as idMotivoPerdesv," +
            "tt.descripTab as motivoPerdesv," +

            "pd.observacionesPerdesv," +
            "pd.flgCompesacionPerdesv," +
            "pd.estadoPerdesv," +
            "pd.compeGraciaPerdesv," +
            "pd.liquidacionPerdesv," +

            "pd.fechaIngPerdesv," +
            "pd.creaPorPerdesv," +
            "pd.fechaModiPerdesv," +
            "pd.modiPorPerdesv" +
            ")" +
            "from PersonalDesvinculacion pd inner join PersonalVidaLaboral pvl on (pd.idPervilaPerdesv = pvl.idPervila and pd.idObraPerdesv = pvl.idObraPervila) " +
            "inner join Personal p on (pd.idPersonalPerdesv = p.idPersonal and pd.idObraPerdesv = p.obraPer) " +
            "inner join Persona psn on (p.idPersona = psn.idPersona ) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "left join TablasTabla tt on (pd.idMotivoPerdesv = tt.codigoTab and 319 = tt.tipoTab)" +
            "where p.idPersonal=?1 and o.idobra=?2 and pd.idPerDesv=?3 and pvl.idPervila=?4 and pd.estadoPerdesv=true"
    )
    public PersonalDesvinculacionDTO findByPersonalDesvinculacionActivosDTO(Long idpersonal, String idobra, Long idperdesv, Long idpervila);

    @Query("select new com.spring.sigmaweb.backend.process.legajo.dto.PersonalDesvinculacionDTO(pd.idPerDesv," +
            "o.idobra as idObraPerdesv," +
            "p.idPersonal," +
            "pvl.idPervila, " +
            "pvl.fechaInicioPervila, " +
            "pvl.fechaFinPervila, " +
            "pvl.estadoPervila, " +

            "psn.apePaternoPers, " +
            "psn.apeMaternoPers, " +
            "psn.nombrePers, " +

            "pd.fechaCesePerdesv," +
            "tt.codigoTab as idMotivoPerdesv," +
            "tt.descripTab as motivoPerdesv," +

            "pd.observacionesPerdesv," +
            "pd.flgCompesacionPerdesv," +
            "pd.estadoPerdesv," +
            "pd.compeGraciaPerdesv," +
            "pd.liquidacionPerdesv," +

            "pd.fechaIngPerdesv," +
            "pd.creaPorPerdesv," +
            "pd.fechaModiPerdesv," +
            "pd.modiPorPerdesv" +
            ")" +
            "from PersonalDesvinculacion pd inner join PersonalVidaLaboral pvl on (pd.idPervilaPerdesv = pvl.idPervila and pd.idObraPerdesv = pvl.idObraPervila) " +
            "inner join Personal p on (pd.idPersonalPerdesv = p.idPersonal and pd.idObraPerdesv = p.obraPer) " +
            "inner join Persona psn on (p.idPersona = psn.idPersona ) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "left join TablasTabla tt on (pd.idMotivoPerdesv = tt.codigoTab and 319 = tt.tipoTab)" +
            "where p.idPersonal=?1 and o.idobra=?2 and pvl.idPervila=?3 and pd.estadoPerdesv=true"
    )
    public List<PersonalDesvinculacionDTO> findByPersonalDesvinculacionActivosListDTO(Long idpersonal, String idobra, Long idpervila);

    @Query("select new com.spring.sigmaweb.backend.process.legajo.dto.PersonalDesvinculacionDTO(pd.idPerDesv," +
            "o.idobra as idObraPerdesv," +
            "p.idPersonal," +
            "pvl.idPervila, " +
            "pvl.fechaInicioPervila, " +
            "pvl.fechaFinPervila, " +
            "pvl.estadoPervila, " +

            "psn.apePaternoPers, " +
            "psn.apeMaternoPers, " +
            "psn.nombrePers, " +

            "pd.fechaCesePerdesv," +
            "tt.codigoTab as idMotivoPerdesv," +
            "tt.descripTab as motivoPerdesv," +

            "pd.observacionesPerdesv," +
            "pd.flgCompesacionPerdesv," +
            "pd.estadoPerdesv," +
            "pd.compeGraciaPerdesv," +
            "pd.liquidacionPerdesv," +

            "pd.fechaIngPerdesv," +
            "pd.creaPorPerdesv," +
            "pd.fechaModiPerdesv," +
            "pd.modiPorPerdesv" +
            ")" +
            "from PersonalDesvinculacion pd inner join PersonalVidaLaboral pvl on (pd.idPervilaPerdesv = pvl.idPervila and pd.idObraPerdesv = pvl.idObraPervila) " +
            "inner join Personal p on (pd.idPersonalPerdesv = p.idPersonal and pd.idObraPerdesv = p.obraPer) " +
            "inner join Persona psn on (p.idPersona = psn.idPersona ) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "left join TablasTabla tt on (pd.idMotivoPerdesv = tt.codigoTab and 319 = tt.tipoTab)" +
            "where p.idPersonal=?1 and o.idobra=?2"
    )
    public List<PersonalDesvinculacionDTO> findByPersonalDesvinculacionListDTO(Long idpersonal, String idobra);
}

