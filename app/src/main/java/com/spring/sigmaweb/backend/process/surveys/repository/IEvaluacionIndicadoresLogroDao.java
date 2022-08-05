package com.spring.sigmaweb.backend.process.surveys.repository;

import com.spring.sigmaweb.backend.process.surveys.dto.EvaluacionIndicadoresLogroDTO;
import com.spring.sigmaweb.backend.process.surveys.model.EvaluacionIndicadoresLogro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IEvaluacionIndicadoresLogroDao extends CrudRepository<EvaluacionIndicadoresLogro,Long> {


    @Query("select new com.spring.sigmaweb.backend.process.surveys.dto.EvaluacionIndicadoresLogroDTO (" +
            "eil.idEvalindlog," +
            "eil.idObraEvalindlog," +
            "eil.idIndicgoEvalindlog," +
            "il.idIndicadorLogro as idIndicador," +
            "il.descripcionIndic as descripcionIndicador," +
            "tgo.codigoTab as idGrupoOcupacional," +
            "tgo.descripTab as descripcionGrupoOcupa," +
            "eil.idPersonalEvalindlog," +
            "psn.apePaternoPers," +
            "psn.apeMaternoPers," +
            "psn.nombrePers," +
            "pto.idPuesto as idPuestoPerpuest," +
            "pto.nombrePues," +
            "eil.promedioEvalindlog," +
            "eil.creaporEvalindlog," +
            "eil.modiporEvalindlog " +
            ") " +
            "from PersonalEvaluacion pe inner join Obra o on (pe.idObraPereval = o.idobra) " +
            "inner join Personal p on (pe.idPersonalPereval = p.idPersonal and o.idobra = p.obraPer) " +
            "inner join Persona psn on (p.idPersona = psn.idPersona and o.idobra = psn.obraPers ) " +
            "inner join PersonalPuesto pp on (p.idPersonal = pp.idPersonalPerpuest and o.idobra = pp.idObraPerpuest ) " +
            "inner join Puestos pto on (pp.idPuestoPerpuest = pto.idPuesto and o.idobra = pto.idObraPues ) " +

            "left join IndicadoresGO igo on (pe.idGrupoOcupacionalPereval = igo.idGrupoocupacionalIndicgo and coalesce(igo.idObraIndicgo, '_') = (case ?1 when 'SECTOR' THEN ?1 else '_' end) " +
                                            "and coalesce(pto.idPuesto, -1) = coalesce(igo.idPuestoIndicgo, -1) ) " +
            "left join IndicadoresLogro il on (igo.idIndicadorIndicgo = il.idIndicadorLogro) " +
            "left join TablasTabla tgo on (igo.idGrupoocupacionalIndicgo = tgo.codigoTab) " +

            "left join EvaluacionIndicadoresLogro eil on (o.idobra = eil.idObraEvalindlog and p.idPersonal = eil.idPersonalEvalindlog and igo.idIndicgo = eil.idIndicgoEvalindlog) " +

            "where o.idobra = ?1 " +
            "and pto.idTipoGoPues = ?2 " +
            "and coalesce(pto.idPuesto, -1) =(case when ?2 != 30501 then coalesce(pto.idPuesto, -1) else ?3 end) " +
            "and igo.idEventoIndicgo = ?4 " +
            "order by psn.apePaternoPers, psn.apeMaternoPers, psn.nombrePers, il.descripcionIndic"
    )
    public List<EvaluacionIndicadoresLogroDTO> findByEvaluacionObraGrupoocupacionalEvento(String idobra, Integer idgo, Long idpuesto, Long idevento);


}
