package com.spring.sigmaweb.backend.process.legajo.repository;

import com.spring.sigmaweb.backend.process.legajo.dto.PersonalContratoObraDTO;
import com.spring.sigmaweb.backend.process.legajo.model.Personal;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalContrato;
import com.spring.sigmaweb.backend.process.legajo.reports.ReportContract;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;

public interface IContratoDao extends CrudRepository<PersonalContrato, Long> {
    public PersonalContrato findByIdPerCont(Long idPerCont);

    @Query("select new com.spring.sigmaweb.backend.process.legajo.dto.PersonalContratoObraDTO(" +
            "pc.idPerCont," +
            "o.idobra as idObraPercont," +
            "p.idPersonal," +
            "ttc.codigoTab as idTipoPercont," +
            "ttc.descripTab as tipoContrato," +
            "pc.fechaIniPercont," +
            "pc.fechaFinPercont," +
            "pc.observacionesPercont," +
            "pc.estadoPercont," +
            "pc.fechaTerminoPercont," +
            "pc.fechaIngPercont," +
            "pc.creaPorPercont" +
            ")" +
            "from PersonalContrato pc inner join Personal p on pc.idPersonalPercont = p.idPersonal " +
            "inner join Obra o on (pc.idObraPercont = o.idobra ) " +
            "inner join PersonalVidaLaboral pvl on (pc.idPervilaPercont = pvl.idPervila) " +
            "left join TablasTabla ttc on (pc.idTipoPercont = ttc.codigoTab and 154 = ttc.tipoTab) " +
            "where p.idPersonal = ?1 and pvl.idPervila = ?2 and o.idobra = ?3 " +
            "order by coalesce (pc.fechaFinPercont, pc.fechaTerminoPercont) desc"
    )
    public List<PersonalContratoObraDTO> findByIdPersonalPercontAndIdPervilaPercontAndIdObraPervila(Long idPerCont, Long idPersonalPervila, String idobra);

    @Query("select pc " +
            "from PersonalContrato pc inner join Personal p on (pc.idPersonalPercont = p.idPersonal and pc.idObraPercont = p.obraPer) " +
            "inner join PersonalVidaLaboral pvl on (pc.idPervilaPercont = pvl.idPervila and pc.idObraPercont = pvl.idObraPervila) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "where p.idPersonal=?1 and o.idobra = ?2 and pc.idPerCont= ?3 and pvl.idPervila = ?4"
    )
    public PersonalContrato findByPersonalAndObraAndcontrato(Long idpersona, String idobra, Long idpercont, Long idpervila);

    @Query("select pc " +
            "from PersonalContrato pc inner join Personal p on (pc.idPersonalPercont = p.idPersonal and pc.idObraPercont = p.obraPer) " +
            "inner join PersonalVidaLaboral pvl on (pc.idPervilaPercont = pvl.idPervila and pc.idObraPercont = pvl.idObraPervila) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "where p.idPersonal=?1 and o.idobra = ?2 and pvl.idPervila = ?3"
    )
    public List<PersonalContrato> findByPersonalAndObraList(Long idpersona, String idobra, Long idpervila);

    @Query("select pc " +
            "from PersonalContrato pc inner join Personal p on (pc.idPersonalPercont = p.idPersonal and pc.idObraPercont = p.obraPer) " +
            "inner join PersonalVidaLaboral pvl on (pc.idPervilaPercont = pvl.idPervila and pc.idObraPercont = pvl.idObraPervila) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "where p.idPersonal=?1 and o.idobra = ?2 and pvl.idPervila = ?3 and pc.estadoPercont = 'ACTIVO'  " +
            "ORDER BY pc.fechaIniPercont, pc.fechaFinPercont"
    )
    public List<PersonalContrato> findByActivosPersonalAndObraList(Long idpersona, String idobra, Long idpervila);

    @Query("select new com.spring.sigmaweb.backend.process.legajo.dto.PersonalContratoObraDTO(pc.idPerCont, " +
            "o.idobra as idObraPercont," +
            "p.idPersonal, " +
            "pvl.idPervila, " +
            "pvl.fechaInicioPervila, " +
            "pvl.fechaFinPervila, " +
            "pvl.estadoPervila, " +
            "psn.apePaternoPers, " +
            "psn.apeMaternoPers, " +
            "psn.nombrePers, " +
            "pc.idTipoPercont," +
            "ttc.descripTab as tipoContrato, " +
            "pc.fechaIniPercont," +
            "pc.fechaFinPercont, " +
            "pc.observacionesPercont, " +
            "pc.estadoPercont, " +
            "pc.fechaTerminoPercont, " +
            "pc.jornadaSemanalPercont, " +
            "pc.remuneracionPercont, " +
            "pc.bonificacionPercont, " +
            "pc.fecIniPruebaPercont," +
            "pc.fecFinPruebaPercont," +
            "pc.fechaIngPercont," +
            "pc.creaPorPercont," +
            "pc.fechaModiPercont," +
            "pc.modiPorPercont" +
            ") "+
            "from PersonalContrato pc inner join Personal p on (pc.idPersonalPercont = p.idPersonal and pc.idObraPercont = p.obraPer) " +
            "inner join Persona psn on (p.idPersona = psn.idPersona) " +
            "inner join PersonalVidaLaboral pvl on (pc.idPervilaPercont = pvl.idPervila and pc.idObraPercont = pvl.idObraPervila) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "left join TablasTabla ttc on (pc.idTipoPercont = ttc.codigoTab and 154 = ttc.tipoTab)" +
            "where p.idPersonal=?1 and o.idobra = ?2 and pc.idPerCont =?3 and pvl.idPervila = ?4 "
    )
    public PersonalContratoObraDTO findByPersonalAndObraAndcontratoDto(Long idpersona, String idobra, Long idpercont, Long idpervila);

    @Query("select new com.spring.sigmaweb.backend.process.legajo.dto.PersonalContratoObraDTO(pc.idPerCont, " +
            "o.idobra as idObraPercont," +
            "p.idPersonal, " +
            "pvl.idPervila, " +
            "pvl.fechaInicioPervila, " +
            "pvl.fechaFinPervila, " +
            "pvl.estadoPervila, " +
            "psn.apePaternoPers, " +
            "psn.apeMaternoPers, " +
            "psn.nombrePers, " +
            "pc.idTipoPercont," +
            "ttc.descripTab as tipoContrato, " +
            "pc.fechaIniPercont," +
            "pc.fechaFinPercont, " +
            "pc.observacionesPercont, " +
            "pc.estadoPercont, " +
            "pc.fechaTerminoPercont, " +
            "pc.jornadaSemanalPercont, " +
            "pc.remuneracionPercont, " +
            "pc.bonificacionPercont, " +
            "pc.fecIniPruebaPercont," +
            "pc.fecFinPruebaPercont," +
            "pc.fechaIngPercont," +
            "pc.creaPorPercont," +
            "pc.fechaModiPercont," +
            "pc.modiPorPercont" +
            ") "+
            "from PersonalContrato pc inner join Personal p on (pc.idPersonalPercont = p.idPersonal and pc.idObraPercont = p.obraPer) " +
            "inner join Persona psn on (p.idPersona = psn.idPersona) " +
            "inner join PersonalVidaLaboral pvl on (pc.idPervilaPercont = pvl.idPervila and pc.idObraPercont = pvl.idObraPervila) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "left join TablasTabla ttc on (pc.idTipoPercont = ttc.codigoTab and 154 = ttc.tipoTab)" +
            "where p.idPersonal=?1 and o.idobra = ?2 and pvl.idPervila = ?3 " +
            "order by pc.fechaIniPercont desc "
    )
    public List<PersonalContratoObraDTO> findByPersonalAndObraAndcontratoDtoList(Long idpersona, String idobra, Long idpervila);

    @Query("select new com.spring.sigmaweb.backend.process.legajo.dto.PersonalContratoObraDTO(pc.idPerCont, " +
            "o.idobra as idObraPercont," +
            "p.idPersonal, " +
            "pvl.idPervila, " +
            "pvl.fechaInicioPervila, " +
            "pvl.fechaFinPervila, " +
            "pvl.estadoPervila, " +
            "psn.apePaternoPers, " +
            "psn.apeMaternoPers, " +
            "psn.nombrePers, " +
            "pc.idTipoPercont," +
            "ttc.descripTab as tipoContrato, " +
            "pc.fechaIniPercont," +
            "pc.fechaFinPercont, " +
            "pc.observacionesPercont, " +
            "pc.estadoPercont, " +
            "pc.fechaTerminoPercont, " +
            "pc.jornadaSemanalPercont, " +
            "pc.remuneracionPercont, " +
            "pc.bonificacionPercont, " +
            "pc.fecIniPruebaPercont," +
            "pc.fecFinPruebaPercont," +
            "pc.fechaIngPercont," +
            "pc.creaPorPercont," +
            "pc.fechaModiPercont," +
            "pc.modiPorPercont" +
            ") "+
            "from PersonalContrato pc inner join Personal p on (pc.idPersonalPercont = p.idPersonal and pc.idObraPercont = p.obraPer) " +
            "inner join Persona psn on (p.idPersona = psn.idPersona) " +
            "inner join PersonalVidaLaboral pvl on (pc.idPervilaPercont = pvl.idPervila and pc.idObraPercont = pvl.idObraPervila) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "left join TablasTabla ttc on (pc.idTipoPercont = ttc.codigoTab and 154 = ttc.tipoTab)" +
            "where p.idPersonal=?1 and o.idobra = ?2 and pvl.idPervila = ?3 and pc.estadoPercont = 'ACTIVO'  " +
            "ORDER BY pc.fechaIniPercont, pc.fechaFinPercont"
    )
    public List<PersonalContratoObraDTO> findContratoActivoPersonalObra(Long idpersona, String idobra, Long idpervila);

    @Query("select new com.spring.sigmaweb.backend.process.legajo.dto.PersonalContratoObraDTO(pc.idPerCont, " +
            "o.idobra as idObraPercont," +
            "p.idPersonal, " +
            "pvl.idPervila, " +
            "pvl.fechaInicioPervila, " +
            "pvl.fechaFinPervila, " +
            "pvl.estadoPervila, " +
            "psn.apePaternoPers, " +
            "psn.apeMaternoPers, " +
            "psn.nombrePers, " +
            "pc.idTipoPercont," +
            "ttc.descripTab as tipoContrato, " +
            "pc.fechaIniPercont," +
            "pc.fechaFinPercont, " +
            "pc.observacionesPercont, " +
            "pc.estadoPercont, " +
            "pc.fechaTerminoPercont, " +
            "pc.jornadaSemanalPercont, " +
            "pc.remuneracionPercont, " +
            "pc.bonificacionPercont, " +
            "pc.fecIniPruebaPercont," +
            "pc.fecFinPruebaPercont," +
            "pc.fechaIngPercont," +
            "pc.creaPorPercont," +
            "pc.fechaModiPercont," +
            "pc.modiPorPercont" +
            ") "+
            "from PersonalContrato pc inner join Personal p on (pc.idPersonalPercont = p.idPersonal and pc.idObraPercont = p.obraPer) " +
            "inner join Persona psn on (p.idPersona = psn.idPersona) " +
            "inner join PersonalVidaLaboral pvl on (pc.idPervilaPercont = pvl.idPervila and pc.idObraPercont = pvl.idObraPervila) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "left join TablasTabla ttc on (pc.idTipoPercont = ttc.codigoTab and 154 = ttc.tipoTab)" +
            "where p.idPersonal =?1 and o.idobra = ?2 and pvl.idPervila = ?3 and pc.idPerCont != ?4 and" +
            "   pc.fechaIniPercont < ?5  " +
            "ORDER BY pc.fechaIniPercont desc, pc.fechaFinPercont "
            )
    public List<PersonalContratoObraDTO> findAnteriorContratoPersonalVidaLaboralObra(Long idpersona, String idobra, Long idpervila, Long idpercont, Date fechaini);


    //QUERYS PARA REPORTES CONTRATOS
    //======================================================================================================
    @Query("select new com.spring.sigmaweb.backend.process.legajo.reports.ReportContract(" +
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
            "tgroc.descripTab as grupoOcupacional, " +
            "tgrpl.descripTab as nivelPlanilla, " +
            "pvl.idPervila," +

            "pc.idPerCont," +
            "tcont.codigoTab as idTipoPercont," +
            "tcont.descripTab as tipoPercont," +
            "pc.fechaIniPercont," +
            "pc.fechaFinPercont," +
            "pc.fechaTerminoPercont," +
            "pc.estadoPercont," +
            "pc.jornadaSemanalPercont," +
            "pc.remuneracionPercont," +
            "pc.jornadaSemanalPercont as jornadaSemanalAct," +
            "pc.remuneracionPercont as remuneracionAct," +
            "pc.fecIniPruebaPercont," +
            "pc.fecFinPruebaPercont" +
            ") " +
            "from Personal p inner join Obra o on (p.obraPer=o.idobra) " +
            "inner join Persona psn on (o.idobra = psn.obraPers and p.idPersona = psn.idPersona) " +
            "inner join PersonalVidaLaboral pvl on (o.idobra = pvl.idObraPervila and p.idPersonal = pvl.idPersonalPervila and pvl.estadoPervila in ('ACTIVO', 'FINALIZADO')) " +
            "left join PersonalContrato pc on (pc.idObraPercont=o.idobra and pc.idPersonalPercont = p.idPersonal and pc.idPervilaPercont=pvl.idPervila ) " +
            "left join PersonalPuesto pp on (o.idobra = pp.idObraPerpuest and p.idPersonal=pp.idPersonalPerpuest and pvl.idPervila = pp.idPervilaPerpuest) " +
            "left join Puestos pst on (pp.idPuestoPerpuest = pst.idPuesto and o.idobra = pst.idObraPues) " +
            "left join TablasTabla tcont on (pc.idTipoPercont = tcont.codigoTab) " +
            "left join TablasTabla tdocu on (psn.idTipoDocPers = tdocu.codigoTab) " +
            "left join TablasTabla tgroc on (coalesce(pst.idTipoGoPues, pp.idAreaPerpuest) = tgroc.codigoTab ) " +
            "left join TablasTabla tgrpl on (pp.idTipoNivelPlanillaPerpuest = tgrpl.codigoTab and tgrpl.tipoTab = (case ?1 when 'SECTOR' then 303 else 302 end) ) " +
            "where o.idobra =?1 and " +
            "p.estadoPer = (case ?2 when 1 then true when 0 then false else p.estadoPer end ) " +
            "and coalesce(tcont.codigoTab,0) = (case ?5 when 0 then coalesce(tcont.codigoTab,0) else ?5 end ) " +
            "and coalesce(tgroc.codigoTab,0) = (case ?3 when 0 then coalesce(tgroc.codigoTab,0) else ?3 end ) " +
            "and coalesce(pp.idTipoNivelPlanillaPerpuest,0) = (case ?4 when 0 then coalesce(pp.idTipoNivelPlanillaPerpuest,0) else ?4 end ) " +
            "and ( (?6 between coalesce( CONVERT(DATE_FORMAT(  pc.fechaIniPercont, '%Y%m%d'), SIGNED), ?6)  and coalesce(CONVERT( DATE_FORMAT(  pc.fechaFinPercont, '%Y%m%d'), SIGNED), ?7) ) " +
              " or (?7 between coalesce( CONVERT(DATE_FORMAT(  pc.fechaIniPercont, '%Y%m%d'), SIGNED), ?6)  and coalesce(CONVERT( DATE_FORMAT(  pc.fechaFinPercont, '%Y%m%d'), SIGNED), ?7) ) " +
            ")"
    )
    public List<ReportContract> reportContratosPorObra(String idobra, Integer estadoper, Integer tipogrupo, Integer tipoplanilla, Integer idtipocontrato, Integer periodoIni, Integer periodoFin, Sort sort);

    @Query("select new com.spring.sigmaweb.backend.process.legajo.reports.ReportContract(" +
            "o.idobra," +
            "o.nombreobra," +
            "p.idPersonal," +
            "psn.apePaternoPers," +
            "psn.apeMaternoPers," +
            "psn.nombrePers," +
            "tdocu.codigoTab as idTipoDocPers," +
            "tdocu.descrip2Tab as tipoDocPers," +
            "psn.nroDocPers," +
            "pvl.idPervila," +
            "pc.idPerCont," +
            "tcont.codigoTab as idTipoPercont," +
            "tcont.descripTab as tipoPercont," +
            "pc.fechaIniPercont," +
            "pc.fechaFinPercont," +
            "pc.fechaTerminoPercont," +

            "pc.estadoPercont," +
            "pc.jornadaSemanalPercont," +
            "pc.remuneracionPercont," +
            "pc.fecIniPruebaPercont," +
            "pc.fecFinPruebaPercont," +

            "phv.motivoHistvila," +
            "tmoti.descripTab as descMotivoHistvila," +
            "phv.tipoHistvila," +
            "phv.fechaCambioHistvila," +
            "phv.jornadaSemaNewHistvila," +
            "phv.remuneracionNewHistvila" +
            ") " +
            "from Personal p inner join Obra o on (p.obraPer=o.idobra) " +
            "inner join Persona psn on (o.idobra = psn.obraPers and p.idPersona = psn.idPersona) " +
            "inner join PersonalVidaLaboral pvl on (o.idobra = pvl.idObraPervila and p.idPersonal = pvl.idPersonalPervila and pvl.estadoPervila in ('ACTIVO', 'FINALIZADO')) " +
            "left join PersonalContrato pc on (pc.idObraPercont=o.idobra and pc.idPersonalPercont = p.idPersonal and pc.idPervilaPercont=pvl.idPervila ) " +
            "left join PersonalHistoricoVinculoLaboral phv on (o.idobra = phv.idObraHistvila and p.idPersonal = phv.idPersonalHistvila and pc.idPerCont = phv.idPercontHistvila and pvl.idPervila = phv.idPervilaHistvila and phv.tipoHistvila IN ('JORN', 'REMU')) " +
            "left join TablasTabla tmoti on (phv.motivoHistvila = tmoti.codigoTab) " +
            "left join PersonalPuesto pp on (o.idobra = pp.idObraPerpuest and p.idPersonal=pp.idPersonalPerpuest and pvl.idPervila = pp.idPervilaPerpuest) " +
            "left join Puestos pst on (pp.idPuestoPerpuest = pst.idPuesto and o.idobra = pst.idObraPues) " +
            "left join TablasTabla tcont on (pc.idTipoPercont = tcont.codigoTab) " +
            "left join TablasTabla tdocu on (psn.idTipoDocPers = tdocu.codigoTab) " +
            "left join TablasTabla tgroc on (coalesce(pst.idTipoGoPues, pp.idAreaPerpuest) = tgroc.codigoTab) " + /*pp.idAreaPerpuest */
            "left join TablasTabla tgrpl on (pp.idTipoNivelPlanillaPerpuest = tgrpl.codigoTab and tgrpl.tipoTab = (case ?1 when 'SECTOR' then 303 else 302 end) ) " +
            "where o.idobra =?1 " +
            "and p.estadoPer = (case ?2 when 1 then true when 0 then false else p.estadoPer end ) " +
            "and concat(coalesce(psn.apePaternoPers, ''), ' ',coalesce(psn.apeMaternoPers, ''), ' ',coalesce(psn.nombrePers, '')) like concat('%',?6,'%') " +
            "and coalesce(tcont.codigoTab,0) = (case ?5 when 0 then coalesce(tcont.codigoTab,0) else ?5 end ) " +
            "and coalesce(tgroc.codigoTab,0) = (case ?3 when 0 then coalesce(tgroc.codigoTab,0) else ?3 end ) " +
            "and coalesce(pp.idTipoNivelPlanillaPerpuest,0) = (case ?4 when 0 then coalesce(pp.idTipoNivelPlanillaPerpuest,0) else ?4 end )" +
            "and ( (?7 between coalesce( CONVERT(DATE_FORMAT(  pc.fechaIniPercont, '%Y%m%d'), SIGNED), ?7)  and coalesce(CONVERT( DATE_FORMAT(  pc.fechaFinPercont, '%Y%m%d'), SIGNED), ?8) ) " +
            " or (?8 between coalesce( CONVERT(DATE_FORMAT(  pc.fechaIniPercont, '%Y%m%d'), SIGNED), ?7)  and coalesce(CONVERT( DATE_FORMAT(  pc.fechaFinPercont, '%Y%m%d'), SIGNED), ?8) ) " +
            ") "+
            "order by o.idobra, concat(coalesce(psn.apePaternoPers, ''),coalesce(psn.apeMaternoPers, ''),coalesce(psn.nombrePers, '')), " +
            "pc.fechaIniPercont desc, phv.fechaCambioHistvila desc "

    )
    public List<ReportContract> reportContratosHistoricoPorObra(String idobra, Integer estadoper, Integer tipogrupo, Integer tipoplanilla, Integer idtipocontrato, String textolike, Integer periodoIni, Integer periodoFin);
}
