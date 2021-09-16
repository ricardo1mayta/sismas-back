package com.spring.sigmaweb.backend.process.core.service;

import com.spring.sigmaweb.backend.process.core.model.Rol;

import java.util.List;

public interface IRolService {
    public Rol findByNombreRolAndIdObraRol(String nombreRol, String idobra);

    public List<Rol> findByNombreRolListAndObra(String[] nombresRol, String idobra);

    public Rol findByIdRolAndIdObraRol(Long idrol, String idobra);

    public Iterable<Rol> findAll();

    public List<Rol> findByIdobraRol(String idobra);

    public Rol findByIdRol(Long idRol);

    public void delete(Rol rol);

    public Rol save(Rol rol);
}
