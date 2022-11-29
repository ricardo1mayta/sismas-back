package com.spring.sigmaweb.backend.process.generic.service.impl;

import com.spring.sigmaweb.backend.process.generic.model.ConfiguracionesModulos;
import com.spring.sigmaweb.backend.process.generic.repository.IConfiguracionesModulosDao;
import com.spring.sigmaweb.backend.process.generic.service.IConfiguracionesModulosService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConfiguracionesModulosService implements IConfiguracionesModulosService {
    @Autowired
    private IConfiguracionesModulosDao configuracionesModulosDao;

    @Override
    public ConfiguracionesModulos findByIdConfiguracion(Long idconfiguracion) {
        return configuracionesModulosDao.findByIdConfiguracion(idconfiguracion);
    }

    @Override
    public List<ConfiguracionesModulos> findByIdObraAndIdModulo(String idobra, String idmodulo) {
        return configuracionesModulosDao.findByIdObraAndIdModulo(idobra, idmodulo);
    }

    @Override
    public ConfiguracionesModulos findByIdObraAndIdModuloAndCodigoGrupoAndCodigoSubgrupo1AndCodigoOpcion(String idobra, String idmodulo, String codigogrupo, String codigosubgrupo1, String codigoopcion) {
        return configuracionesModulosDao.findByIdObraAndIdModuloAndCodigoGrupoAndCodigoSubgrupo1AndCodigoOpcion(idobra, idmodulo, codigogrupo, codigosubgrupo1, codigoopcion);
    }

    @Override
    @Transactional
    public ConfiguracionesModulos save(ConfiguracionesModulos configuracionesModulos) {
        return configuracionesModulosDao.save(configuracionesModulos);
    }
}
