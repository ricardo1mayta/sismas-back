package com.spring.sigmaweb.backend.process.generic.repository;

import com.spring.sigmaweb.backend.process.generic.model.TipoCambio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ITipoCambioDao  extends CrudRepository<TipoCambio,Long> {
    @Query(value = "FROM TipoCambio tc  where tc.idObra=:idObra")
    List<TipoCambio> findByIdObra(@Param("idObra")String idObra);

    @Query(value = "FROM TipoCambio tc  where tc.idObra=:idObra and date(tc.fecha)=date(:fecha) ")
    TipoCambio findByIdOBraAndDate(@Param("idObra") String idObra, @Param("fecha") Date fecha);

}
