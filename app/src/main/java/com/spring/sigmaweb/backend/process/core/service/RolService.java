package com.spring.sigmaweb.backend.process.core.service;

import com.spring.sigmaweb.backend.process.core.model.Rol;
import com.spring.sigmaweb.backend.process.core.repository.IRolesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RolService implements IRolService{

    @Autowired
    IRolesDao rolesDao;

    @Override
    @Transactional(readOnly=true)
    public Rol findByNombreRolAndIdObraRol(String nombreRol, String idobra) {
        return rolesDao.findByNombreRolAndIdobraRol(nombreRol , idobra);
    }

    @Override
    @Transactional(readOnly=true)
    public Iterable<Rol> findAll() {
        return rolesDao.findAll();
    }

    @Override
    public List<Rol> findByNombreRolListAndObra(String[] nombresRol, String idobra) {
        return rolesDao.buscarPorNombreRolListAndObra(nombresRol, idobra);
    }

    @Override
    @Transactional(readOnly=true)
    public Rol findByIdRol(Long idRol) {
        return rolesDao.findByIdRol(idRol);
    }

    @Override
    @Transactional
    public void delete(Rol rol) {
        rolesDao.delete(rol);
    }

    @Override
    @Transactional
    public Rol save(Rol rol) {
        return rolesDao.save(rol);
    }

    @Override
    @Transactional(readOnly=true)
    public Rol findByIdRolAndIdObraRol(Long idrol, String idobra) {
        // TODO Auto-generated method stub
        return rolesDao.findByIdRolAndIdobraRol(idrol,idobra);
    }

    @Override
    public List<Rol> findByIdobraRol(String idobra) {
        return rolesDao.findByIdobraRol(idobra);
    }
}
