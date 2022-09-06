package com.spring.sigmaweb.backend.process.surveys.repository;

import com.spring.sigmaweb.backend.process.surveys.dto.EvaluacionIndicadoresLogroDTO;
import com.spring.sigmaweb.backend.process.surveys.model.EvaluacionIndicadoresLogro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IEvaluacionIndicadoresLogroDao extends CrudRepository<EvaluacionIndicadoresLogro,Long> {
    public EvaluacionIndicadoresLogro findByIdIndicgoEvalindlogAndIdObraEvalindlogAndIdPersonalEvalindlog(Long idIndicgoEvalindlog, String idobra, Long idPersonalEvalindlog);


    @Query("select new com.spring.sigmaweb.backend.process.surveys.dto.EvaluacionIndicadoresLogroDTO (" +
            "eil.idEvalindlog," +
            "o.idobra as idObraEvalindlog," +
            "igo.idIndicgo as idIndicgoEvalindlog," +
            "il.idIndicadorLogro as idIndicador," +
            "il.descripcionIndic as descripcionIndicador," +
            "tgo.codigoTab as idGrupoOcupacional," +
            "tgo.descripTab as descripcionGrupoOcupa," +
            "tnp.descripTab as descripcionNivelPlanilla," +
            "pe.idPersonalPereval  as idPersonalEvalindlog," +
            "psn.apePaternoPers," +
            "psn.apeMaternoPers," +
            "psn.nombrePers," +
            "pto.idPuesto as idPuestoPerpuest," +
            "pto.nombrePues," +
            "igo.ordenIndicgo," +
            "eil.promedioEvalindlog," +
            "eil.creaporEvalindlog," +
            "eil.modiporEvalindlog " +
            ") " +
            "from PersonalEvaluacion pe inner join Obra o on (pe.idObraPereval = o.idobra) " +
            "inner join Personal p on (pe.idPersonalPereval = p.idPersonal and o.idobra = p.obraPer) " +
            "inner join Persona psn on (p.idPersona = psn.idPersona and o.idobra = psn.obraPers ) " +
            "left join PersonalPuesto pp on (p.idPersonal = pp.idPersonalPerpuest and o.idobra = pp.idObraPerpuest and pp.estadoPerpuest = true ) " +
            "left join TablasTabla tnp on (pp.idTipoNivelPlanillaPerpuest = tnp.codigoTab) " +
            "left join Puestos pto on (pe.idCargoPuestoPereval = pto.idPuesto and pe.flgEsCargoprincipalPereval=true and o.idobra = pto.idObraPues ) " +
            "left join Cargo cgo on (pe.idCargoPuestoPereval = cgo.idCargo and pe.flgEsCargoprincipalPereval=false) " +

            "left join IndicadoresGO igo on (pe.idGrupoOcupacionalPereval = igo.idGrupoocupacionalIndicgo " +
        "                                   and coalesce(igo.idObraIndicgo, '_') = (case ?1 when 'SECTOR' THEN ?1 else '_' end) " +
                                            "and coalesce(igo.idPuestoIndicgo, -1) = (case when ?2 != 30501 then -1 else (case pe.flgEsCargoprincipalPereval when true then pto.equivalenciaCargoPues else cgo.idCargo end)  end) ) " +
            "left join IndicadoresLogro il on (igo.idIndicadorIndicgo = il.idIndicadorLogro) " +
            "left join TablasTabla tgo on (igo.idGrupoocupacionalIndicgo = tgo.codigoTab) " +

            "left join EvaluacionIndicadoresLogro eil on (o.idobra = eil.idObraEvalindlog and p.idPersonal = eil.idPersonalEvalindlog and igo.idIndicgo = eil.idIndicgoEvalindlog) " +

            "where o.idobra = ?1 " +
            "and pe.idGrupoOcupacionalPereval = ?2 " +
            "and pe.flgPrincipalEvalPereval = true " +
            "and coalesce(igo.idPuestoIndicgo, -1) =(case when ?2 != 30501 then coalesce(igo.idPuestoIndicgo, -1) else ?3 end) " +
            "and igo.idEventoIndicgo = ?4 " +
            "order by psn.apePaternoPers, psn.apeMaternoPers, psn.nombrePers, igo.ordenIndicgo, il.descripcionIndic"
    )
    public List<EvaluacionIndicadoresLogroDTO> findByEvaluacionObraGrupoocupacionalEvento(String idobra, Integer idgo, Long idpuesto, Long idevento);

}
