package com.spring.sigmaweb.backend.process.generic.service;

import com.spring.sigmaweb.backend.process.generic.dto.ParametrosReporteDTO;
import com.spring.sigmaweb.backend.process.generic.model.Reporte;

import java.util.List;

public interface IParametrosReporteService {
    public List<ParametrosReporteDTO> findByParametrosPorReporte(Long idrepo);

    public List<Reporte> findByIdModuloTipoRepoEstadoRepo(String idmodulo, String tiporepo, Boolean estadorepo);

    public List<Reporte> findByIdModuloTipoRepoEstadoRepoGrupo(String idmodulo, String tiporepo, Boolean estadorepo, Integer idgrupo, String idobra);

    public List<Reporte> findByIdModuloTipoRepoEstadoRepoGrupoRol(String idmodulo, String tiporepo, Boolean estadorepo, Integer idgrupo, String idobra, String idrol);

    public List<Reporte> findByIdModuloTipoRepoEstadoRepoNotInGrupo(String idmodulo, String tiporepo, Boolean estadorepo, String idgrupos, String idobra);
}
