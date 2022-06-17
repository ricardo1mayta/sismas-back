package com.spring.sigmaweb.backend.process.legajo.repository;

import com.spring.sigmaweb.backend.process.legajo.dto.PersonalPuestoDTO;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalCargo;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalPuesto;
import com.spring.sigmaweb.backend.process.legajo.reports.ReportPuestosCargos;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPersonalPuestoDao extends CrudRepository<PersonalPuesto, Long> {
    public PersonalPuesto findByIdPerpuest (Long idPerpuest);

    @Query("select pp " +
            "from PersonalPuesto pp inner join Obra o on (pp.idObraPerpuest = o.idobra) " +
            "inner join Personal p on (pp.idPersonalPerpuest = p.idPersonal and pp.idObraPerpuest = o.idobra) " +
            "inner join PersonalVidaLaboral pvl on (pp.idPervilaPerpuest = pvl.idPervila and o.idobra = pvl.idObraPervila) " +
            "where p.idPersonal=?1 and o.idobra = ?2 and pvl.idPervila = ?3 "
    )
    public List<PersonalPuesto> findByIdPersonalAndIdobraAndIdPervila(Long idpersona, String idobra, Long idpervila);

    @Query("select pp " +
            "from PersonalPuesto pp inner join Obra o on (pp.idObraPerpuest = o.idobra) " +
            "inner join Personal p on (pp.idPersonalPerpuest = p.idPersonal and pp.idObraPerpuest = o.idobra) " +
            "inner join PersonalVidaLaboral pvl on (pp.idPervilaPerpuest = pvl.idPervila and o.idobra = pvl.idObraPervila) " +
            "where p.idPersonal=?1 and o.idobra = ?2 and pvl.idPervila = ?3 and pp.idPerpuest=?4 "
    )
    public PersonalPuesto findByIdPersonalAndIdobraAndIdPervilaAndId(Long idpersona, String idobra, Long idpervila, Long idperpuesto);

    @Query("Select new com.spring.sigmaweb.backend.process.legajo.dto.PersonalPuestoDTO(pp.idPerpuest, " +
            "o.idobra as idObraPerpuest, " +
            "p.idPersonal, " +
            "pvl.idPervila, " +

            "pvl.fechaInicioPervila, " +
            "pvl.fechaFinPervila, " +
            "pvl.estadoPervila, " +
            "psn.apePaternoPers, " +
            "psn.apeMaternoPers, " +
            "psn.nombrePers, " +

            "pp.idPuestoTPerpuest as idPuestoTPerpuest, " +
            "pus.descripCargoTr as puestoTPerpuest, " +
            "tarea.codigoTab as idAreaPerpuest, " +
            "tarea.descripTab as AreaPerpuest, " +

            "tplanilla.codigoTab as idTipoNivelPlanillaPerpuest, " +
            "tplanilla.descripTab as TipoNivelPlanillaPerpuest, " +
            "pues.idPuesto as idPuestoPerpuest, " +
            "pues.nombrePues as PuestoPerpuest, " +

            "pp.flgPuestoDirePerpuest, " +
            "pp.flgPuestoConfiPerpuest, " +
            "pp.flgPuestoNofilcalPerpuest, " +
            "pp.flgPuestoNoAplicaPerpuest, " +
            "pp.observacionesPerpuest, " +
            "pp.estadoPerpuest, " +
            "pp.bonifCargoPerpuest, " +

            "pp.fechaIniPerpuest, " +
            "pp.fechaFinPerpuest, " +
            "pp.fechaIngPerpuest, " +
            "pp.creaPorPerpuest, " +
            "pp.fechaModiPerpuest, " +
            "pp.modiPorPerpuest" +
            ") " +
            "from PersonalPuesto pp inner join Personal p on (pp.idPersonalPerpuest = p.idPersonal and pp.idObraPerpuest = p.obraPer) " +
            "inner join Persona psn on (p.idPersona = psn.idPersona and p.obraPer=psn.obraPers) " +
            "inner join Puestos pues on (pp.idPuestoPerpuest = pues.idPuesto) " +
            "left join CargoTReg pus on (pp.idPuestoTPerpuest = pus.idCargoTr) " +
            "inner join PersonalVidaLaboral pvl on (pp.idPervilaPerpuest = pvl.idPervila and pp.idObraPerpuest = pvl.idObraPervila) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "left join TablasTabla tarea on (pp.idAreaPerpuest = tarea.codigoTab and 305 = tarea.tipoTab) " + //(case ?2 when 'SECTOR' then 306 else 305 end)
            "left join TablasTabla tplanilla on (pp.idTipoNivelPlanillaPerpuest = tplanilla.codigoTab and (case ?2 when 'SECTOR' then 303 else 302 end)=tplanilla.tipoTab) " +
            "where p.idPersonal=?1 and o.idobra = ?2 and pvl.idPervila=?3"
    )
    public List<PersonalPuestoDTO> findByObraPersonalVidaLab(Long idpersona, String idobra, Long idpervila);

    @Query("Select new com.spring.sigmaweb.backend.process.legajo.dto.PersonalPuestoDTO(pp.idPerpuest, " +
            "o.idobra as idObraPerpuest, " +
            "p.idPersonal, " +
            "pvl.idPervila, " +

            "pvl.fechaInicioPervila, " +
            "pvl.fechaFinPervila, " +
            "pvl.estadoPervila, " +
            "psn.apePaternoPers, " +
            "psn.apeMaternoPers, " +
            "psn.nombrePers, " +

            "pp.idPuestoTPerpuest as idPuestoTPerpuest, " +
            "pus.descripCargoTr as puestoTPerpuest, " +
            "tarea.codigoTab as idAreaPerpuest, " +
            "tarea.descripTab as AreaPerpuest, " +

            "tplanilla.codigoTab as idTipoNivelPlanillaPerpuest, " +
            "tplanilla.descripTab as TipoNivelPlanillaPerpuest, " +
            "pues.idPuesto as idPuestoPerpuest, " +
            "pues.nombrePues as PuestoPerpuest, " +

            "pp.flgPuestoDirePerpuest, " +
            "pp.flgPuestoConfiPerpuest, " +
            "pp.flgPuestoNofilcalPerpuest, " +
            "pp.flgPuestoNoAplicaPerpuest, " +
            "pp.observacionesPerpuest, " +
            "pp.estadoPerpuest, " +
            "pp.bonifCargoPerpuest, " +

            "pp.fechaIniPerpuest, " +
            "pp.fechaFinPerpuest, " +
            "pp.fechaIngPerpuest, " +
            "pp.creaPorPerpuest, " +
            "pp.fechaModiPerpuest, " +
            "pp.modiPorPerpuest" +
            ") " +
            "from PersonalPuesto pp inner join Personal p on (pp.idPersonalPerpuest = p.idPersonal and pp.idObraPerpuest = p.obraPer) " +
            "inner join Persona psn on (p.idPersona = psn.idPersona and p.obraPer=psn.obraPers) " +
            "inner join Puestos pues on (pp.idPuestoPerpuest = pues.idPuesto) " +
            "left join CargoTReg pus on (pp.idPuestoTPerpuest = pus.idCargoTr) " +
            "inner join PersonalVidaLaboral pvl on (pp.idPervilaPerpuest = pvl.idPervila and pp.idObraPerpuest = pvl.idObraPervila) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "left join TablasTabla tarea on (pp.idAreaPerpuest = tarea.codigoTab and 305 = tarea.tipoTab) " + //(case ?2 when 'SECTOR' then 306 else 305 end)
            "left join TablasTabla tplanilla on (pp.idTipoNivelPlanillaPerpuest = tplanilla.codigoTab and ((case ?2 when 'SECTOR' then 303 else 302 end))=tplanilla.tipoTab) " +
            "where p.idPersonal=?1 and o.idobra = ?2 and pvl.idPervila=?3 and pp.idPerpuest = ?4"
    )
    public PersonalPuestoDTO findByObraPersonalVidaLabId(Long idpersona, String idobra, Long idpervila, Long idperpuest);


    //QUERYS PARA REPORTES PUESTOS Y CARGOS
    //======================================================================================================

    @Query("select new com.spring.sigmaweb.backend.process.legajo.reports.ReportPuestosCargos(" +
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

            "pvl.idPervila," +
            "pp.idPerpuest," +
            "coalesce(cp.idPuesto, -1) as idPuestoPerpuest," +
            "coalesce(cp.nombrePues, 'NO ASIGNADO') as puestoPerpuest," +
            "coalesce(tgrocp.codigoTab, -1) as idAreaPerpuest," +
            "coalesce(tgrocp.descripTab, 'NO ASIGNADO') as areaPerpuest," +
            "coalesce(tgrplp.codigoTab, -1) as idTipoNivelPlanillaPerpuest," +
            "coalesce(tgrplp.descripTab, 'NO ASIGNADO') as tipoNivelPlanillaPerpuest," +

            "pp.flgPuestoDirePerpuest," +
            "pp.flgPuestoConfiPerpuest," +
            "pp.flgPuestoNofilcalPerpuest," +
            "pp.flgPuestoNoAplicaPerpuest," +
            "pp.observacionesPerpuest," +

            "pp.fechaIniPerpuest," +
            "pp.fechaFinPerpuest," +
            "pp.estadoPerpuest," +
            "pp.bonifCargoPerpuest," +
            "pp.fechaIngPerpuest," +
            "pp.creaPorPerpuest," +

            "pc.idPercargo," +
            "cc.idCargo as idCargoPercargo," +
            "cc.nombreCar as cargoPercargo," +
            "tgrocc.codigoTab as idAreaPercargo," +
            "tgrocc.descripTab as areaPercargo," +
            "pc.observacionesPercargo," +
            "pc.fechaIniPercargo," +
            "pc.fechaFinPercargo," +
            "pc.estadoPercargo," +
            "pc.bonifCargoPercargo," +
            "pc.fechaIngPercargo," +
            "pc.creaPorPercargo" +
            ")" +
            "from Personal p inner join Obra o on (p.obraPer=o.idobra) " +
            "inner join Persona psn on (o.idobra = psn.obraPers and p.idPersona = psn.idPersona) " +
            "inner join PersonalVidaLaboral pvl on (o.idobra = pvl.idObraPervila and p.idPersonal = pvl.idPersonalPervila and pvl.estadoPervila='ACTIVO') " +
            "left join PersonalPuesto pp on (o.idobra = pp.idObraPerpuest and p.idPersonal=pp.idPersonalPerpuest and pvl.idPervila=pp.idPervilaPerpuest) " +
            "left join PersonalCargo pc on (o.idobra = pc.idObraPercargo and p.idPersonal=pc.idPersonalPercargo and pvl.idPervila = pc.idPervilaPercargo ) " +
            "left join TablasTabla tdocu on (psn.idTipoDocPers = tdocu.codigoTab) " +
            "left join TablasTabla tgrocp on (pp.idAreaPerpuest = tgrocp.codigoTab ) " +
            "left join TablasTabla tgrplp on (pp.idTipoNivelPlanillaPerpuest = tgrplp.codigoTab and tgrplp.tipoTab = (case ?1 when 'SECTOR' then 303 else 302 end) ) " +
            "left join TablasTabla tgrocc on (pc.idAreaPercargo = tgrocc.codigoTab ) " +
            "left join TablasTabla tgrplc on (pc.idTipoNivelPlanillaPercargo = tgrplc.codigoTab and tgrplc.tipoTab = (case ?1 when 'SECTOR' then 303 else 302 end) ) " +
            "left join Puestos cp on (pp.idPuestoPerpuest = cp.idPuesto) " +
            "left join Cargo cc on (pc.idCargoPercargo = cc.idCargo) " +
            "where o.idobra =?1 and " +
            "p.estadoPer = (case ?2 when 1 then true when 0 then false else p.estadoPer end ) " +
            "and coalesce(cp.idPuesto,0) = (case ?5 when 0 then coalesce(cp.idPuesto,0) else ?5 end ) " +
            "and coalesce(pp.idAreaPerpuest,0) = (case ?3 when 0 then coalesce(pp.idAreaPerpuest,0) else ?3 end ) " +
            "and coalesce(pp.idTipoNivelPlanillaPerpuest,0) = (case ?4 when 0 then coalesce(pp.idTipoNivelPlanillaPerpuest,0) else ?4 end ) "
    )
    public List<ReportPuestosCargos> reportPuestosCargosPorObra (String idobra, Integer estadoper, Integer tipogrupo, Integer tipoplanilla, Integer idtipocontrato, Sort sort);


    @Query("select new com.spring.sigmaweb.backend.process.legajo.reports.ReportPuestosCargos(" +
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

            "pvl.idPervila," +
            "pp.idPerpuest," +
            "coalesce(cp.idPuesto, -1) as idPuestoPerpuest," +
            "coalesce(cp.nombrePues, 'NO ASIGNADO') as puestoPerpuest," +
            "coalesce(tgrocp.codigoTab, -1) as idAreaPerpuest," +
            "coalesce(tgrocp.descripTab, 'NO ASIGNADO') as areaPerpuest," +
            "coalesce(tgrplp.codigoTab, -1) as idTipoNivelPlanillaPerpuest," +
            "coalesce(tgrplp.descripTab, 'NO ASIGNADO') as tipoNivelPlanillaPerpuest," +

            "pp.flgPuestoDirePerpuest," +
            "pp.flgPuestoConfiPerpuest," +
            "pp.flgPuestoNofilcalPerpuest," +
            "pp.flgPuestoNoAplicaPerpuest," +
            "pp.observacionesPerpuest," +

            "pp.fechaIniPerpuest," +
            "pp.fechaFinPerpuest," +
            "pp.estadoPerpuest," +
            "pp.bonifCargoPerpuest," +
            "pp.fechaIngPerpuest," +
            "pp.creaPorPerpuest," +

            "pc.idPercargo," +
            "cc.idCargo as idCargoPercargo," +
            "cc.nombreCar as cargoPercargo," +
            "tgrocc.codigoTab as idAreaPercargo," +
            "tgrocc.descripTab as areaPercargo," +
            "pc.observacionesPercargo," +
            "pc.fechaIniPercargo," +
            "pc.fechaFinPercargo," +
            "pc.estadoPercargo," +
            "pc.bonifCargoPercargo," +
            "pc.fechaIngPercargo," +
            "pc.creaPorPercargo" +
            ")" +
            "from Personal p inner join Obra o on (p.obraPer=o.idobra) " +
            "inner join Persona psn on (o.idobra = psn.obraPers and p.idPersona = psn.idPersona) " +
            "inner join PersonalVidaLaboral pvl on (o.idobra = pvl.idObraPervila and p.idPersonal = pvl.idPersonalPervila and pvl.estadoPervila='ACTIVO') " +
            "left join PersonalPuesto pp on (o.idobra = pp.idObraPerpuest and p.idPersonal=pp.idPersonalPerpuest and pvl.idPervila=pp.idPervilaPerpuest) " +
            "left join PersonalCargo pc on (o.idobra = pc.idObraPercargo and p.idPersonal=pc.idPersonalPercargo and pvl.idPervila = pc.idPervilaPercargo ) " +
            "left join TablasTabla tdocu on (psn.idTipoDocPers = tdocu.codigoTab) " +
            "left join TablasTabla tgrocp on (pp.idAreaPerpuest = tgrocp.codigoTab ) " +
            "left join TablasTabla tgrplp on (pp.idTipoNivelPlanillaPerpuest = tgrplp.codigoTab and tgrplp.tipoTab = (case ?1 when 'SECTOR' then 303 else 302 end) ) " +
            "left join TablasTabla tgrocc on (pc.idAreaPercargo = tgrocc.codigoTab ) " +
            "left join TablasTabla tgrplc on (pc.idTipoNivelPlanillaPercargo = tgrplc.codigoTab and tgrplc.tipoTab = (case ?1 when 'SECTOR' then 303 else 302 end) ) " +
            "left join Puestos cp on (pp.idPuestoPerpuest = cp.idPuesto) " +
            "left join Cargo cc on (pc.idCargoPercargo = cc.idCargo) " +
            "where o.idobra =?1 " +
            "and p.idPersonal = ?2 "
    )
    public List<ReportPuestosCargos> reportPuestosCargosPorPersonalObra (String idobra, Long idPersonal);

}
