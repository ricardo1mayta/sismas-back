package com.spring.sigmaweb.backend.process.generic.service;

import com.spring.sigmaweb.backend.process.generic.model.ConfiguracionesModulos;

import java.util.List;

public interface IConfiguracionesModulosService {
    ConfiguracionesModulos findByIdConfiguracion(Long idconfiguracion);

    List<ConfiguracionesModulos> findByIdObraAndIdModulo(String idobra, String idmodulo);

    ConfiguracionesModulos findByIdObraAndIdModuloAndCodigoGrupoAndCodigoSubgrupo1AndCodigoOpcion(String idobra, String idmodulo, String codigogrupo, String codigosubgrupo1, String codigoopcion);

    ConfiguracionesModulos save(ConfiguracionesModulos configuracionesModulos);
}
