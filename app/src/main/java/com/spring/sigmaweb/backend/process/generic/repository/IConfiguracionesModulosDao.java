package com.spring.sigmaweb.backend.process.generic.repository;

import com.spring.sigmaweb.backend.process.generic.model.ConfiguracionesModulos;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.IGenericRepo;

import java.util.List;

public interface IConfiguracionesModulosDao extends IGenericRepo<ConfiguracionesModulos, Long> {
    ConfiguracionesModulos findByIdConfiguracion(Long idconfiguracion);

    List<ConfiguracionesModulos> findByIdObraAndIdModulo(String idobra, String idmodulo);

    ConfiguracionesModulos findByIdObraAndIdModuloAndCodigoGrupoAndCodigoSubgrupo1AndCodigoOpcion(String idobra, String idmodulo, String codigogrupo, String codigosubgrupo1, String codigoopcion);
}
