package com.spring.sigmaweb.backend.process.surveys.repository;

import com.spring.sigmaweb.backend.process.surveys.dto.PersonalEvaluacionDTO;
import com.spring.sigmaweb.backend.process.surveys.model.PersonalEvaluacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPersonalEvaluacionDao extends CrudRepository<PersonalEvaluacion, Long> {
    public PersonalEvaluacion findByIdPerevalAndIdObraPereval(Long idPereval, String idObraPereval);

    public List<PersonalEvaluacion> findByIdObraPereval(String idObraPereval);

    @Query("select new com.spring.sigmaweb.backend.process.surveys.dto.PersonalEvaluacionDTO (" +
            "pe.idPereval," +
            "pe.idEventoPereval," +
            "ep.nombreEvent," +
            "o.idobra as idObraPereval," +
            "p.idPersonal," +
            "psn.nombrePers," +
            "psn.apePaternoPers," +
            "psn.apeMaternoPers," +
            "TRIM( concat(COALESCE(concat(psn.apePaternoPers,' '), ''), COALESCE(concat(psn.apeMaternoPers, ' '), ''), COALESCE(psn.nombrePers, '')) ) as nomCompleto, " +
            "pe.idCargoPuestoPereval," +
            "(case pe.flgEsCargoprincipalPereval when true then pst.nombrePues else cgo.nombreCar end) as nombreCargoPuestoPereval," +
            "pe.idPeriodoPereval," +
            "per.anioPeri," +
            "pe.codigoperPereval," +
            "pe.flgEsCargoprincipalPereval," +
            "pe.flgPrincipalEvalPereval," +
            "tgo.codigoTab as idGrupoOcupacionalPereval," +
            "tgo.descripTab as nombreGrupoOcupacionalPereval," +
            "pe.fechaingPereval," +
            "pe.creaporPereval," +
            "pe.fechamodiPereval," +
            "pe.modiporPereval" +
            ") " +
            "from PersonalEvaluacion pe inner join Obra o on (pe.idObraPereval=o.idobra) " +
            "inner join Personal p on (pe.idPersonalPereval = p.idPersonal and o.idobra = p.obraPer and pe.flgExternoPereval= false) " +
            "inner join Persona psn on (p.idPersona = psn.idPersona and o.idobra=psn.obraPers) " +
            "inner join Periodo per on (pe.idPeriodoPereval = per.idPeriodo) " +
            "inner join EventosPeriodo ep on (pe.idEventoPereval = ep.idEvento and ep.idPeriodoEvent=per.idPeriodo) " + //and o.idobra = ep.idObraEvent
            "inner join TablasTabla tgo on (pe.idGrupoOcupacionalPereval = tgo.codigoTab and 305 = tgo.tipoTab) " +
            "left join Puestos pst on (pe.idCargoPuestoPereval = pst.idPuesto and pe.flgEsCargoprincipalPereval = true) " +
            "left join Cargo cgo on (pe.idCargoPuestoPereval = cgo.idCargo and pe.flgEsCargoprincipalPereval = false) " +
            "where o.idobra = ?1 " +
            "and tgo.codigoTab = (case ?2 when -1 then tgo.codigoTab else ?2 end )" +
            "and coalesce(pst.idPuesto,0) = (case ?3 when -1 then coalesce(pst.idPuesto, 0) else ?3 end )" +
            "and coalesce(cgo.idCargo,0) = (case ?4 when -1 then coalesce(cgo.idCargo,0) else ?4 end ) " +
            "and pe.flgPrincipalEvalPereval = (case ?5 when -1 then pe.flgPrincipalEvalPereval else (case ?5 when 1 then true else false end) end) " +
            "AND ep.idObraEvent = 'SECTOR' " +
            "order by psn.apePaternoPers,psn.apeMaternoPers,psn.nombrePers,  (case pe.flgPrincipalEvalPereval when true then 0 else 1 end)"
    )
    public List<PersonalEvaluacionDTO> findByIdObraPerevalList(String idobra, Integer idgruoocu , Long idpuesto, Long idcargo, Integer principal);

    @Query("select Distinct new com.spring.sigmaweb.backend.process.surveys.dto.PersonalEvaluacionDTO (" +
            "pe.idEventoPereval," +
            "ep.nombreEvent," +
            "o.idobra as idObraPereval," +
            "p.idPersonal," +
            "psn.nombrePers," +
            "psn.apePaternoPers," +
            "psn.apeMaternoPers," +
            "TRIM( concat(COALESCE(concat(psn.apePaternoPers,' '), ''), COALESCE(concat(psn.apeMaternoPers, ' '), ''), COALESCE(psn.nombrePers, '')) ) as nomCompleto, " +

            "pe.idPeriodoPereval," +
            "per.anioPeri," +
            "pe.codigoperPereval" +
            ") " +
            "from PersonalEvaluacion pe inner join Obra o on (pe.idObraPereval=o.idobra) " +
            "inner join Personal p on (pe.idPersonalPereval = p.idPersonal and o.idobra = p.obraPer and pe.flgExternoPereval= false) " +
            "inner join Persona psn on (p.idPersona = psn.idPersona and o.idobra=psn.obraPers) " +
            "inner join Periodo per on (pe.idPeriodoPereval = per.idPeriodo) " +
            "inner join EventosPeriodo ep on (pe.idEventoPereval = ep.idEvento and ep.idPeriodoEvent=per.idPeriodo) " + //and o.idobra = ep.idObraEvent
            "where o.idobra = ?1 and ep.idObraEvent ='SECTOR' "
    )
    public List<PersonalEvaluacionDTO> findByIdObraPerevalDistinctList(String idobra);

    @Query("select new com.spring.sigmaweb.backend.process.surveys.dto.PersonalEvaluacionDTO (" +
            "pe.idPereval," +
            "pe.idEventoPereval," +
            "ep.nombreEvent," +
            "o.idobra as idObraPereval," +
            "p.idPersonal," +
            "psn.nombrePers," +
            "psn.apePaternoPers," +
            "psn.apeMaternoPers," +
            "TRIM( concat(COALESCE(concat(psn.apePaternoPers,' '), ''), COALESCE(concat(psn.apeMaternoPers, ' '), ''), COALESCE(psn.nombrePers, '')) ) as nomCompleto, " +
            "pe.idCargoPuestoPereval," +
            "(case pe.flgEsCargoprincipalPereval when true then pst.nombrePues else cgo.nombreCar end) as nombreCargoPuestoPereval," +
            "pe.flgEsCargoprincipalPereval, " +
            "pe.flgPrincipalEvalPereval" +
            ") " +
            "from PersonalEvaluacion pe inner join Obra o on (pe.idObraPereval=o.idobra) " +
            "inner join Personal p on (pe.idPersonalPereval = p.idPersonal and o.idobra = p.obraPer and pe.flgExternoPereval= false) " +
            "inner join Persona psn on (p.idPersona = psn.idPersona and o.idobra=psn.obraPers) " +
            "inner join Periodo per on (pe.idPeriodoPereval = per.idPeriodo) " +
            "inner join EventosPeriodo ep on (pe.idEventoPereval = ep.idEvento and ep.idPeriodoEvent=per.idPeriodo) " + //and o.idobra = ep.idObraEvent
            "inner join TablasTabla tgo on (pe.idGrupoOcupacionalPereval = tgo.codigoTab and 305 = tgo.tipoTab) " +
            "left join Puestos pst on (pe.idCargoPuestoPereval = pst.idPuesto and pe.flgEsCargoprincipalPereval = true) " +
            "left join Cargo cgo on (pe.idCargoPuestoPereval = cgo.idCargo and pe.flgEsCargoprincipalPereval = false) " +
            "where o.idobra = ?1 " +
            "and p.idPersonal = ?2 " +
            "and ep.idObraEvent = 'sector'" +
            "and pe.flgPrincipalEvalPereval = (case ?3 when 3 then pe.flgPrincipalEvalPereval when 1 then true else false end) " +
            "order by (case pe.flgPrincipalEvalPereval when true then 0 else 1 end)"

    )
    public List<PersonalEvaluacionDTO> findByIdObraPersonallListCargosPuestos(String idobra, Long idpersonal, Integer esPrincipal);


    /*PERSONAL EXTERNO*/
    @Query("select Distinct new com.spring.sigmaweb.backend.process.surveys.dto.PersonalEvaluacionDTO (" +
            "pe.idEventoPereval," +
            "ep.nombreEvent," +
            "o.idobra as idObraPereval," +
            "p.idPersonalExt," +
            "psn.nombrePers," +
            "psn.apePaternoPers," +
            "psn.apeMaternoPers," +
            "TRIM( concat(COALESCE(concat(psn.apePaternoPers,' '), ''), COALESCE(concat(psn.apeMaternoPers, ' '), ''), COALESCE(psn.nombrePers, '')) ) as nomCompleto, " +

            "pe.idPeriodoPereval," +
            "per.anioPeri," +
            "pe.codigoperPereval" +
            ") " +
            "from PersonalEvaluacion pe inner join Obra o on (pe.idObraPereval=o.idobra) " +
            "inner join PersonalExt p on (pe.idPersonalPereval = p.idPersonalExt and o.idobra = p.idObraPerext and pe.flgExternoPereval= true) " +
            "inner join Persona psn on (p.idPersPerext = psn.idPersona and o.idobra=psn.obraPers) " +
            "inner join Periodo per on (pe.idPeriodoPereval = per.idPeriodo) " +
            "inner join EventosPeriodo ep on (pe.idEventoPereval = ep.idEvento and ep.idPeriodoEvent=per.idPeriodo) " +
            "where o.idobra = ?1 and ep.idObraEvent ='SECTOR' " +
            "and pe.flgExternoPereval=true"
            )
    public List<PersonalEvaluacionDTO> findByIdObraPerevalDistinctListExternos(String idobra);

    @Query("select new com.spring.sigmaweb.backend.process.surveys.dto.PersonalEvaluacionDTO (" +
            "pe.idPereval," +
            "pe.idEventoPereval," +
            "ep.nombreEvent," +
            "o.idobra as idObraPereval," +
            "p.idPersonalExt," +
            "psn.nombrePers," +
            "psn.apePaternoPers," +
            "psn.apeMaternoPers," +
            "TRIM( concat(COALESCE(concat(psn.apePaternoPers,' '), ''), COALESCE(concat(psn.apeMaternoPers, ' '), ''), COALESCE(psn.nombrePers, '')) ) as nomCompleto, " +
            "pe.idCargoPuestoPereval," +
            "(case pe.flgEsCargoprincipalPereval when true then pst.nombrePues else cgo.nombreCar end) as nombreCargoPuestoPereval," +
            "pe.flgEsCargoprincipalPereval, " +
            "pe.flgPrincipalEvalPereval" +
            ") " +
            "from PersonalEvaluacion pe inner join Obra o on (pe.idObraPereval=o.idobra) " +
            "inner join PersonalExt p on (pe.idPersonalPereval = p.idPersonalExt and o.idobra = p.idObraPerext and pe.flgExternoPereval= true) " +
            "inner join Persona psn on (p.idPersPerext = psn.idPersona and o.idobra=psn.obraPers) " +
            "inner join Periodo per on (pe.idPeriodoPereval = per.idPeriodo) " +
            "inner join EventosPeriodo ep on (pe.idEventoPereval = ep.idEvento and ep.idPeriodoEvent=per.idPeriodo) " + //and o.idobra = ep.idObraEvent
            "inner join TablasTabla tgo on (pe.idGrupoOcupacionalPereval = tgo.codigoTab and 305 = tgo.tipoTab) " +
            "left join Puestos pst on (pe.idCargoPuestoPereval = pst.idPuesto and pe.flgEsCargoprincipalPereval = true) " +
            "left join Cargo cgo on (pe.idCargoPuestoPereval = cgo.idCargo and pe.flgEsCargoprincipalPereval = false) " +
            "where o.idobra = ?1 " +
            "and p.idPersonalExt = ?2 " +
            "and ep.idObraEvent = 'sector'" +
            "and pe.flgPrincipalEvalPereval = (case ?3 when 3 then pe.flgPrincipalEvalPereval when 1 then true else false end) " +
            "and pe.flgExternoPereval=true " +
            "order by (case pe.flgPrincipalEvalPereval when true then 0 else 1 end)"

    )
    public List<PersonalEvaluacionDTO> findByIdObraPersonallListCargosPuestosExterno(String idobra, Long idpersonal, Integer esPrincipal);


    @Query("select new com.spring.sigmaweb.backend.process.surveys.dto.PersonalEvaluacionDTO (" +
            "pe.idPereval," +
            "pe.idEventoPereval," +
            "ep.nombreEvent," +
            "o.idobra as idObraPereval," +
            "p.idPersonalExt," +
            "psn.nombrePers," +
            "psn.apePaternoPers," +
            "psn.apeMaternoPers," +
            "TRIM( concat(COALESCE(concat(psn.apePaternoPers,' '), ''), COALESCE(concat(psn.apeMaternoPers, ' '), ''), COALESCE(psn.nombrePers, '')) ) as nomCompleto, " +
            "pe.idCargoPuestoPereval," +
            "(case pe.flgEsCargoprincipalPereval when true then pst.nombrePues else cgo.nombreCar end) as nombreCargoPuestoPereval," +
            "pe.idPeriodoPereval," +
            "per.anioPeri," +
            "pe.codigoperPereval," +
            "pe.flgEsCargoprincipalPereval," +
            "pe.flgPrincipalEvalPereval," +
            "tgo.codigoTab as idGrupoOcupacionalPereval," +
            "tgo.descripTab as nombreGrupoOcupacionalPereval," +
            "pe.fechaingPereval," +
            "pe.creaporPereval," +
            "pe.fechamodiPereval," +
            "pe.modiporPereval" +
            ") " +
            "from PersonalEvaluacion pe inner join Obra o on (pe.idObraPereval=o.idobra) " +
            "inner join PersonalExt p on (pe.idPersonalPereval = p.idPersonalExt and o.idobra = p.idObraPerext and pe.flgExternoPereval= true) " +
            "inner join Persona psn on (p.idPersPerext = psn.idPersona and o.idobra=psn.obraPers) " +
            "inner join Periodo per on (pe.idPeriodoPereval = per.idPeriodo) " +
            "inner join EventosPeriodo ep on (pe.idEventoPereval = ep.idEvento and ep.idPeriodoEvent=per.idPeriodo) " + //and o.idobra = ep.idObraEvent
            "inner join TablasTabla tgo on (pe.idGrupoOcupacionalPereval = tgo.codigoTab and 305 = tgo.tipoTab) " +
            "left join Puestos pst on (pe.idCargoPuestoPereval = pst.idPuesto and pe.flgEsCargoprincipalPereval = true) " +
            "left join Cargo cgo on (pe.idCargoPuestoPereval = cgo.idCargo and pe.flgEsCargoprincipalPereval = false) " +
            "where o.idobra = ?1 " +
            "and tgo.codigoTab = (case ?2 when -1 then tgo.codigoTab else ?2 end )" +
            "and coalesce(pst.idPuesto,0) = (case ?3 when -1 then coalesce(pst.idPuesto, 0) else ?3 end )" +
            "and coalesce(cgo.idCargo,0) = (case ?4 when -1 then coalesce(cgo.idCargo,0) else ?4 end ) " +
            "and pe.flgPrincipalEvalPereval = (case ?5 when -1 then pe.flgPrincipalEvalPereval else (case ?5 when 1 then true else false end) end) " +
            "AND ep.idObraEvent = 'SECTOR' " +
            "and pe.flgExternoPereval=true " +
            "order by psn.apePaternoPers,psn.apeMaternoPers,psn.nombrePers,  (case pe.flgPrincipalEvalPereval when true then 0 else 1 end)"
    )
    public List<PersonalEvaluacionDTO> findByIdObraPerevalListExterno(String idobra, Integer idgruoocu , Long idpuesto, Long idcargo, Integer principal);



}
