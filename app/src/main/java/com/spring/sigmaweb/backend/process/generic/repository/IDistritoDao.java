package com.spring.sigmaweb.backend.process.generic.repository;

import com.spring.sigmaweb.backend.process.generic.model.Distrito;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IDistritoDao extends CrudRepository<Distrito, Long>  {
    @Query("select d from Distrito d inner join Provincia p on d.provincia=p.idProv "
            + "where p.idProv=?1")
    public List<Distrito> findByProvincia(Long idProv);
}
