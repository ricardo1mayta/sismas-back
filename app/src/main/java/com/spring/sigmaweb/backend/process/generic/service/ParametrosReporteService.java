package com.spring.sigmaweb.backend.process.generic.service;

import com.spring.sigmaweb.backend.process.generic.dto.ParametrosReporteDTO;
import com.spring.sigmaweb.backend.process.generic.model.Reporte;
import com.spring.sigmaweb.backend.process.generic.repository.IParametrosReporteDao;
import com.spring.sigmaweb.backend.process.generic.repository.IReportesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ParametrosReporteService implements IParametrosReporteService{
    @Autowired
    private IParametrosReporteDao parametrosReporteDao;

    @Autowired
    private IReportesDao reportesDao;

    @Override
    @Transactional(readOnly = true)
    public List<ParametrosReporteDTO> findByParametrosPorReporte(Long idrepo) {
        return parametrosReporteDao.findByParametrosPorReporte(idrepo);
    }

    @Override
    public List<Reporte> findByIdModuloTipoRepoEstadoRepo(String idmodulo, String tiporepo, Boolean estadorepo) {
        return reportesDao.findByIdModuloTipoRepoEstadoRepo(idmodulo, tiporepo, estadorepo);
    }
}
