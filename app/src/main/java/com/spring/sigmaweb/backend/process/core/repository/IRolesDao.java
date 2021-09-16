package com.spring.sigmaweb.backend.process.core.repository;

import com.spring.sigmaweb.backend.process.core.model.Rol;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IRolesDao extends CrudRepository<Rol, Long> {
    //public Rol findByNombreRol(String nombreRol);
    public Rol findByIdRol(Long idRol);

    public List<Rol> findByIdobraRol(String idobra);

    //public Rol findByIdRolAndIdobraRol(Long idrol, String idobra);

    public Rol findByNombreRolAndIdobraRol(String nombreRol, String idobra);

    @Query("select r "
            + "from Rol r  "
            + "where nombreRol in ?1 and idobraRol = ?2  ")
    public List<Rol> buscarPorNombreRolListAndObra(String[] nombresRol, String idobra);

    @Query("select r "
            + "from Rol r "
            + "where idRol = ?1 and idobraRol = ?2 ")
    public Rol findByIdRolAndIdobraRol(Long idrol, String idobra);

}
