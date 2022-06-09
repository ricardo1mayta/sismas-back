package com.spring.sigmaweb.backend.process.legajo.repository;

import com.spring.sigmaweb.backend.process.legajo.dto.PersonalDesvinculacionDTO;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalDesvinculacion;
import com.spring.sigmaweb.backend.process.legajo.reports.ReportDesvinculacion;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
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


    //QUERYS PARA REPORTES DESVINCULACIONES
    //======================================================================================================
    @Query("select new com.spring.sigmaweb.backend.process.legajo.reports.ReportDesvinculacion(" +
            "o.idobra," +
            "o.nombreobra," +
            "p.idPersonal," +
            "p.codigoPer," +
            "(case p.estadoPer when true then 'ACTIVO' when false then 'INACTIVO' else '' end) as estadoPer," +
            "psn.apePaternoPers," +
            "psn.apeMaternoPers," +
            "psn.nombrePers," +
            "tdocu.codigoTab as idTipoDocPers," +
            "tdocu.descrip2Tab as tipoDocPers," +
            "psn.nroDocPers," +
            "tgroc.codigoTab as idAreaPerpuest, " +
            "tgroc.descripTab as areaPerpuest, " +
            "tgrpl.codigoTab as idTipoNivelPlanillaPerpuest, " +
            "tgrpl.descripTab as tipoNivelPlanillaPerpuest, " +

            "pvl.idPervila," +
            "pvl.fechaInicioPervila," +
            "pd.fechaCesePerdesv," +
            "tmode.codigoTab as idMotivoPerdesv," +
            "tmode.descripTab as motivoPerdesv," +
            "pd.observacionesPerdesv, " +
            "pd.fechaIngPerdesv," +
            "pd.creaPorPerdesv," +

            "0 as idTipoUltPercont," +
            "'' as tipoUltPercont," +
            "pvl.fechaInicioPervila as fechaIniUltPercont," +
            "pvl.fechaInicioPervila as fechaFinUltPercont,"  +
            "pvl.fechaInicioPervila as fechaTerminoUltPercont" +
            ")" +
            "from Personal p inner join Obra o on (p.obraPer=o.idobra) " +
            "inner join Persona psn on (o.idobra = psn.obraPers and p.idPersona = psn.idPersona) " +
            "inner join PersonalVidaLaboral pvl on (o.idobra = pvl.idObraPervila and p.idPersonal = pvl.idPersonalPervila) " +
            "inner join PersonalDesvinculacion pd on (o.idobra = pd.idObraPerdesv and p.idPersonal = pd.idPersonalPerdesv and pvl.idPervila = pd.idPervilaPerdesv) " +
            "left join PersonalPuesto pp on (o.idobra = pp.idObraPerpuest and p.idPersonal=pp.idPersonalPerpuest) " +
            "left join TablasTabla tdocu on (psn.idTipoDocPers = tdocu.codigoTab) " +
            "left join TablasTabla tgroc on (pp.idAreaPerpuest = tgroc.codigoTab ) " +
            "left join TablasTabla tgrpl on (pp.idTipoNivelPlanillaPerpuest = tgrpl.codigoTab and tgrpl.tipoTab = (case ?1 when 'SECTOR' then 303 else 302 end) ) " +
            "left join TablasTabla tmode on (pd.idMotivoPerdesv = tmode.codigoTab and 319 = tmode.tipoTab) " +
            "where o.idobra =?1 " +
            "and tmode.codigoTab = (case ?5 when 0 then coalesce(tmode.codigoTab,0) else ?5 end ) " +
            "and (CONVERT(DATE_FORMAT(pd.fechaCesePerdesv, '%Y%m%d'), SIGNED) between ?6 and ?7) " +
            "and p.estadoPer = (case ?2 when 1 then true when 0 then false else p.estadoPer end ) " +
            "and coalesce(pp.idAreaPerpuest,0) = (case ?3 when 0 then coalesce(pp.idAreaPerpuest,0) else ?3 end ) " +
            "and coalesce(pp.idTipoNivelPlanillaPerpuest,0) = (case ?4 when 0 then coalesce(pp.idTipoNivelPlanillaPerpuest,0) else ?4 end ) "
    )
    public List<ReportDesvinculacion> reportDesvinculacionesColaborador(String idobra, Integer estadoper, Integer tipogrupo, Integer tipoplanilla, Integer tipoDesvinculacion, Integer fechaini, Integer Fechafin, Sort sort);

    @Query("select new com.spring.sigmaweb.backend.process.legajo.reports.ReportDesvinculacion(" +
            "o.idobra," +
            "o.nombreobra," +
            "p.idPersonal," +
            "psn.apePaternoPers," +
            "psn.apeMaternoPers," +
            "psn.nombrePers," +
            "tdocu.codigoTab as idTipoDocPers," +
            "tdocu.descrip2Tab as tipoDocPers," +
            "psn.nroDocPers," +

            "tgroc.codigoTab as idAreaPerpuest, " +
            "tgroc.descripTab as areaPerpuest, " +
            "tgrpl.codigoTab as idTipoNivelPlanillaPerpuest, " +
            "tgrpl.descripTab as tipoNivelPlanillaPerpuest, " +

            "pvl.idPervila," +
            "pvl.fechaInicioPervila," +
            "pvl.fechaFinPervila," +
            "pd.idPerDesv," +
            "pd.fechaCesePerdesv," +
            "tmode.codigoTab as idMotivoPerdesv," +
            "tmode.descripTab as motivoPerdesv," +

            "0 as idTipoUltPercont," +
            "'' as tipoUltPercont," +
            "pvl.fechaInicioPervila as fechaIniUltPercont," +
            "pvl.fechaInicioPervila as fechaFinUltPercont,"  +
            "pvl.fechaInicioPervila as fechaTerminoUltPercont," +

            "pdd.idPerentr," +
            "dd.idDocdesv as idTipoDocDesvPerentr," +
            "dd.descripcionDocdesv as tipoDocDesvPerentr," +
            "(case pdd.flgEntregoPerentr when true then 'SI' ELSE 'NO' END) as flgEntregoPerentr," +
            "pdd.montoPerentr," +
            "pdd.fechaEjecucionPerentr," +
            "pdd.idResponsablePerentr," +
            "de.titleFilePer," +
            "de.sizeFilePer," +
            "de.uploadDateFilePer" +
            ")" +
            "from Personal p inner join Obra o on (p.obraPer=o.idobra) " +
            "inner join Persona psn on (o.idobra = psn.obraPers and p.idPersona = psn.idPersona) " +
            "inner join PersonalVidaLaboral pvl on (o.idobra = pvl.idObraPervila and p.idPersonal = pvl.idPersonalPervila) " +
            "inner join PersonalDesvinculacion pd on (o.idobra = pd.idObraPerdesv and p.idPersonal = pd.idPersonalPerdesv and pvl.idPervila = pd.idPervilaPerdesv) " +

            "left join PersonalPuesto pp on (o.idobra = pp.idObraPerpuest and p.idPersonal=pp.idPersonalPerpuest) " +
            "left join PersonalDocDesvinculacion pdd on (pd.idPerDesv = pdd.idPerdesvPerentr and o.idobra = pdd.idObraPerentr) " +
            "left join DocumentoDesvinculacion dd on (pdd.idTipoDocDesvPerentr = dd.idDocdesv and o.idobra=dd.idObraDocdesv) " +
            "left join DocumentEmployee de on (o.idobra =de.idObraFilePer and p.idPersonal = de.idPersonalFilePer and pd.idPerDesv =de.idItemPadreFileper and dd.idDocdesv=de.opcionFilePer and de.tipoFilePer='DESVINCDOC') " +

            "left join TablasTabla tdocu on (psn.idTipoDocPers = tdocu.codigoTab) " +
            "left join TablasTabla tgroc on (pp.idAreaPerpuest = tgroc.codigoTab ) " +
            "left join TablasTabla tgrpl on (pp.idTipoNivelPlanillaPerpuest = tgrpl.codigoTab and tgrpl.tipoTab = (case ?1 when 'SECTOR' then 303 else 302 end) ) " +
            "left join TablasTabla tmode on (pd.idMotivoPerdesv = tmode.codigoTab and 319 = tmode.tipoTab) " +

            "where o.idobra =?1 " +
            "and tmode.codigoTab = (case ?5 when 0 then coalesce(tmode.codigoTab,0) else ?5 end ) " +
            "and (CONVERT(DATE_FORMAT(pd.fechaCesePerdesv, '%Y%m%d'), SIGNED) between ?6 and ?7) " +
            "and p.estadoPer = (case ?2 when 1 then true when 0 then false else p.estadoPer end ) " +
            "and pdd.flgEntregoPerentr = (case ?8 when 1 then true when 0 then false else pdd.flgEntregoPerentr end ) " +
            "and coalesce(pp.idAreaPerpuest,0) = (case ?3 when 0 then coalesce(pp.idAreaPerpuest,0) else ?3 end ) " +
            "and coalesce(pp.idTipoNivelPlanillaPerpuest,0) = (case ?4 when 0 then coalesce(pp.idTipoNivelPlanillaPerpuest,0) else ?4 end ) "
    )
    public List<ReportDesvinculacion> reportDesvinculacionesChecklistColaborador(String idobra, Integer estadoper, Integer tipogrupo, Integer tipoplanilla, Integer tipoDesvinculacion, Integer fechaini, Integer Fechafin,Integer estadoEntrega, Sort sort);


}

