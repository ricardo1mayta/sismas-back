package com.spring.sigmaweb.backend.process.legajo.repository;

import com.spring.sigmaweb.backend.process.legajo.dto.PersonalContratoObraDTO;
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
            "pc.fecFinPruebaPercont" +
            ") " +
            "from PersonalContrato pc inner join Obra o on (pc.idObraPercont=o.idobra) " +
            "inner join Personal p on (o.idobra = p.obraPer and pc.idPersonalPercont = p.idPersonal) " +
            "inner join Persona psn on (o.idobra = psn.obraPers and p.idPersona = psn.idPersona) " +
            "inner join PersonalVidaLaboral pvl on (o.idobra = pvl.idObraPervila and p.idPersonal = pvl.idPersonalPervila and pvl.estadoPervila='ACTIVO') " +
            "left join PersonalPuesto pp on (o.idobra = pp.idObraPerpuest and p.idPersonal=pp.idPersonalPerpuest) " +
            "left join TablasTabla tcont on (pc.idTipoPercont = tcont.codigoTab) " +
            "left join TablasTabla tdocu on (psn.idTipoDocPers = tdocu.codigoTab) " +
            "left join TablasTabla tgroc on (pp.idAreaPerpuest = tgroc.codigoTab and tgroc.tipoTab = (case ?1 when 'SECTOR' then 306 else 305 end) ) " +
            "left join TablasTabla tgrpl on (pp.idTipoNivelPlanillaPerpuest = tgrpl.codigoTab and tgrpl.tipoTab = (case ?1 when 'SECTOR' then 303 else 302 end) ) " +
            "where o.idobra =?1 and " +
            "p.estadoPer = (case ?2 when 1 then true when 0 then false else p.estadoPer end ) " +
            "and coalesce(tcont.codigoTab,0) = (case ?5 when 0 then coalesce(tcont.codigoTab,0) else ?5 end ) " +
            "and coalesce(pp.idAreaPerpuest,0) = (case ?3 when 0 then coalesce(pp.idAreaPerpuest,0) else ?3 end ) " +
            "and coalesce(pp.idTipoNivelPlanillaPerpuest,0) = (case ?4 when 0 then coalesce(pp.idTipoNivelPlanillaPerpuest,0) else ?4 end ) "
    )
    public List<ReportContract> reportContratosPorObra(String idobra, Integer estadoper, Integer tipogrupo, Integer tipoplanilla, Integer idtipocontrato, Sort sort);
}
