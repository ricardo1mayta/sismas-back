package com.spring.sigmaweb.backend.process.generic.repository;

import com.spring.sigmaweb.backend.process.generic.model.Persona;
import com.spring.sigmaweb.backend.process.generic.model.Reporte;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IReportesDao extends CrudRepository<Reporte, Long> {
    public List<Reporte> findByIdModuloRepo(String idmodulo);

    public List<Reporte> findByIdModuloRepoAndTipoRepoAndEstadoRepo(String idmodulo, String tiporepo, Boolean estadorepo);

    @Query("select r " +
            "from Reporte r " +
            "Where r.idModuloRepo = ?1 " +
            "and r.tipoRepo = ( case ?2 when '_' then r.tipoRepo else ?2 end) " +
            "and r.estadoRepo = ( case ?3 when 1 then true when 0 then false else r.estadoRepo end)"
    )
    public List<Reporte> findByIdModuloTipoRepoEstadoRepo(String idmodulo, String tiporepo, Boolean estadorepo);

}
