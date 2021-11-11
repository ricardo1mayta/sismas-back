package com.spring.sigmaweb.backend.process.generic.repository;

import com.spring.sigmaweb.backend.process.generic.dto.ParametrosReporteDTO;
import com.spring.sigmaweb.backend.process.generic.model.ParametrosReporte;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IParametrosReporteDao extends CrudRepository<ParametrosReporte, Long> {
    @Query("select new com.spring.sigmaweb.backend.process.generic.dto.ParametrosReporteDTO(" +
            "r.idRepo, " +
            "p.idPara, " +
            "pr.idParaRepo, " +
            "p.descripcionPara, " +
            "p.tipoPara, " +
            "pr.ordenParaRepo, " +
            "pr.descAlterParaRepo, " +
            "pr.valorMinParaRepo, " +
            "pr.valorDefaultParaRepo, " +
            "pr.tablaSelectParaRepo, " +
            "pr.estadoParaRepo, " +
            "p.estadoPara, " +
            "r.estadoRepo" +
            ")" +
            "From ParametrosReporte pr inner join Parametro p on (pr.idparaParaRepo = p.idPara) " +
            "inner join Reporte r on (pr.idrepoParaRepo = r.idRepo) " +
            "where r.estadoRepo=true and pr.estadoParaRepo=true " +
            "and r.idRepo=?1")
    public List<ParametrosReporteDTO> findByParametrosPorReporte(Long idrepo);
}
