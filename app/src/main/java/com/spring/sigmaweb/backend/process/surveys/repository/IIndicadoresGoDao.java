package com.spring.sigmaweb.backend.process.surveys.repository;

import com.spring.sigmaweb.backend.process.surveys.dto.IndicadoresGODto;
import com.spring.sigmaweb.backend.process.surveys.model.IndicadoresGO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IIndicadoresGoDao extends CrudRepository<IndicadoresGO,Long> {

    @Query("select new com.spring.sigmaweb.backend.process.surveys.dto.IndicadoresGODto(" +
            "igo.idIndicgo," +
            "igo.idIndicadorIndicgo," +
            "il.descripcionIndic as indicadorIndicgo," +
            "igo.idGrupoocupacionalIndicgo," +
            "tgo.descripTab as grupoocupacionalIndicgo," +
            "igo.idObraIndicgo," +
            "igo.idPuestoIndicgo," +
            "p.nombrePues as puestoIndicgo," +
            "igo.idEventoIndicgo," +
            "igo.flgActivoIndicgo," +
            "igo.fechaingIndicgo," +
            "igo.creaporIndicgo," +
            "igo.fechamodiIndicgo," +
            "igo.modiporIndicgo" +
            ") " +
            "from IndicadoresGO igo inner join IndicadoresLogro il on (igo.idIndicadorIndicgo = il.idIndicadorLogro) " +
            "inner join TablasTabla tgo on (igo.idGrupoocupacionalIndicgo = tgo.codigoTab) " +
            "left join Puestos p on (igo.idPuestoIndicgo = p.idPuesto ) " +
            "where coalesce(igo.idObraIndicgo, '_') = ?1 " +
            "and tgo.codigoTab = ?2 " +
            "and coalesce(p.idPuesto,-1) = (case when ?2 != 30501 then coalesce(p.idPuesto,-1) else ?3 end) " +
            "and igo.idEventoIndicgo = ?4"
    )
    public List<IndicadoresGODto> findByObraAndGrupoOcupacionalAndPuestoAndEvento(String idobra, Integer idgo, Long idpuesto, Long idevento);
}
