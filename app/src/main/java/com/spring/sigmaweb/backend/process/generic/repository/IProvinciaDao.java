package com.spring.sigmaweb.backend.process.generic.repository;

import com.spring.sigmaweb.backend.process.generic.model.Provincia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface IProvinciaDao extends CrudRepository<Provincia, Long>{
    @Query("select p from Provincia p inner join Departamento d on p.departamento=d.idDepa "
            + "where d.idDepa=?1")
    public List<Provincia> findByDepartamento(Long idDepa);
}
