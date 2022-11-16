package com.spring.sigmaweb.backend.process.generic.repository;

import com.spring.sigmaweb.backend.process.core.model.Rol;
import com.spring.sigmaweb.backend.process.generic.model.PerfilReport;
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
            "and r.estadoRepo = ( case ?3 when 1 then true when 0 then false else r.estadoRepo end) " +
            "order by r.descripcionRepo"
    )
    public List<Reporte> findByIdModuloTipoRepoEstadoRepo(String idmodulo, String tiporepo, Boolean estadorepo);

    @Query("select r " +
            "from Reporte r inner join GruposReportes gr on (r.idRepo = gr.idRepoGrupr) " +
            "Where r.idModuloRepo = ?1 " +
            "and r.tipoRepo = ( case ?2 when '_' then r.tipoRepo else ?2 end) " +
            "and r.estadoRepo = ( case ?3 when 1 then true when 0 then false else r.estadoRepo end) " +
            "and gr.idGruporepGrupr = (case ?4 when -1 then gr.idGruporepGrupr else ?4 end ) " +
            "and gr.idObraGrupr = ?5 " +
            "order by r.descripcionRepo"
    )
    public List<Reporte> findByIdModuloTipoRepoEstadoRepoGrupo(String idmodulo, String tiporepo, Boolean estadorepo, Integer idgrupo, String idobra);

    @Query("select r " +
            "from Reporte r inner join GruposReportes gr on (r.idRepo = gr.idRepoGrupr) " +
            "Where r.idModuloRepo = ?1 " +
            "and r.tipoRepo = ( case ?2 when '_' then r.tipoRepo else ?2 end) " +
            "and r.estadoRepo = ( case ?3 when 1 then true when 0 then false else r.estadoRepo end) " +
            "and gr.idGruporepGrupr not in ?4 " +
            "and gr.idObraGrupr = ?5 " +
            "order by r.descripcionRepo"
    )
    public List<Reporte> findByIdModuloTipoRepoEstadoRepoNotInGrupo(String idmodulo, String tiporepo, Boolean estadorepo, Integer[] idgrupo, String idobra);

    @Query("select pr " +
            "from PerfilReport pr " +
            "where pr.idRolPerr in ?1 and pr.idObraPerr = ?2"
    )
    public List<PerfilReport> fintReportPerfil(Long[] idrol, String idobra);
}
