package com.spring.sigmaweb.backend.process.tesoreria.egresos.repository;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.TarjetaCredito;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TarjetaCreditoRepository extends IGenericRepo<TarjetaCredito,Long>{

    @Query("FROM TarjetaCredito t where t.idObra=:idObra and t.flgEstado =true")
    List<TarjetaCredito> findByidObra(@Param("idObra")String idObra);

    @Query("FROM TarjetaCredito t where t.idObra=:idObra and t.cuentaBanco.idCuentaBanco=:idCuentaBanco  and t.flgEstado =true")
    List<TarjetaCredito> findByIdAndCuentaBancoAndIdObra(@Param("idObra")String idObra,@Param("idCuentaBanco")Long idCuentaBanco);
}
