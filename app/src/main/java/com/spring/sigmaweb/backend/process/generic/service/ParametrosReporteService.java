package com.spring.sigmaweb.backend.process.generic.service;

import com.spring.sigmaweb.backend.process.core.dto.SidenavItemDTO;
import com.spring.sigmaweb.backend.process.core.model.Rol;
import com.spring.sigmaweb.backend.process.core.repository.IRolesDao;
import com.spring.sigmaweb.backend.process.generic.dto.ParametrosReporteDTO;
import com.spring.sigmaweb.backend.process.generic.model.PerfilReport;
import com.spring.sigmaweb.backend.process.generic.model.Reporte;
import com.spring.sigmaweb.backend.process.generic.repository.IParametrosReporteDao;
import com.spring.sigmaweb.backend.process.generic.repository.IReportesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParametrosReporteService implements IParametrosReporteService{
    @Autowired
    private IParametrosReporteDao parametrosReporteDao;

    @Autowired
    private IReportesDao reportesDao;

    @Autowired
    private IRolesDao rolesDao;

    @Override
    @Transactional(readOnly = true)
    public List<ParametrosReporteDTO> findByParametrosPorReporte(Long idrepo) {
        return parametrosReporteDao.findByParametrosPorReporte(idrepo);
    }

    @Override
    public List<Reporte> findByIdModuloTipoRepoEstadoRepo(String idmodulo, String tiporepo, Boolean estadorepo) {
        return reportesDao.findByIdModuloTipoRepoEstadoRepo(idmodulo, tiporepo, estadorepo);
    }

    @Override
    public List<Reporte> findByIdModuloTipoRepoEstadoRepoGrupo(String idmodulo, String tiporepo, Boolean estadorepo, Integer idgrupo, String idobra) {
        return reportesDao.findByIdModuloTipoRepoEstadoRepoGrupo(idmodulo, tiporepo, estadorepo, idgrupo, idobra);

    }

    @Override
    public List<Reporte> findByIdModuloTipoRepoEstadoRepoGrupoRol(String idmodulo, String tiporepo, Boolean estadorepo, Integer idgrupo, String idobra, String idrol) {

        String[] lista= idrol.split(",");
        List<Rol> rolesList = rolesDao.buscarPorNombreRolListAndObra(lista, idobra);
        Long[] listaInt=new Long[rolesList.size()];
        Integer ind = 0 ;
        for (Rol item : rolesList) {
            listaInt[ind] = item.getIdRol();
        }


        List<Reporte> listReporGrupo = this.findByIdModuloTipoRepoEstadoRepoGrupo(idmodulo, tiporepo, estadorepo, idgrupo, idobra);
        List<PerfilReport> reportsPerfil = reportesDao.fintReportPerfil(listaInt, idobra);

        List<Reporte> listResult = new ArrayList<>();

        if (reportsPerfil != null){
            if(reportsPerfil.size() > 0 ){
                for (PerfilReport item: reportsPerfil) {
                    for (Reporte repo: listReporGrupo) {
                        if(repo.getIdRepo().equals(item.getIdRepoPerr())) {
                            listResult.add(repo);
                            continue;
                        }
                    }
                }
                return listResult;
            }
        }
        return listReporGrupo;
    }

    @Override
    public List<Reporte> findByIdModuloTipoRepoEstadoRepoNotInGrupo(String idmodulo, String tiporepo, Boolean estadorepo, String idgrupos, String idobra) {
        String[] lista= idgrupos.split(",");
        Integer[] listaInt=new Integer[lista.length];
        for(int i = 0;i < lista.length;i++)
        {
            listaInt[i] = Integer.parseInt(lista[i]);
        }

        return reportesDao.findByIdModuloTipoRepoEstadoRepoNotInGrupo(idmodulo, tiporepo, estadorepo, listaInt, idobra);
    }
}
