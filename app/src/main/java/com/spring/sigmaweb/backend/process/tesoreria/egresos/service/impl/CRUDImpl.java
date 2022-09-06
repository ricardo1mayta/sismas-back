package com.spring.sigmaweb.backend.process.tesoreria.egresos.service.impl;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.IGenericRepo;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.ICRUD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID>{

    protected abstract IGenericRepo<T, ID> getRepo();

    @Transactional
    @Override
    public T registrar(T p) throws Exception {
        return getRepo().save(p);
    }

    @Override
    public T modificar(T p) throws Exception {
        return getRepo().save(p);
    }

    @Transactional(readOnly = true)
    @Override
    public List<T> listar() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T buscarPorId(ID id) throws Exception {
        return getRepo().findById(id).orElse(null);
    }

    @Override
    public void eliminar(ID id) throws Exception {
        getRepo().deleteById(id);
    }

}
