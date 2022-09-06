package com.spring.sigmaweb.backend.process.tesoreria.egresos.repository;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.CuentaBanco;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CuentaBancoRepository extends  IGenericRepo<CuentaBanco,Long>{

    @Query(" FROM CuentaBanco cb where cb.idObra=:idObra")
    List<CuentaBanco> listarPorObraCuentaBanco(@Param("idObra") String idObra);

    @Query(" FROM CuentaBanco cb where cb.idObra=:idObra and cb.idTipoMoneda=:idTipoMoneda" )
    List<CuentaBanco> listarPorTipoMonedaYObraCuentaBanco(@Param("idObra") String idObra,@Param("idTipoMoneda")Integer idTipoMoneda);

    @Query(" FROM CuentaBanco cb where cb.idCuentaBanco=:idCuentaBanco")
    CuentaBanco buscarPorIdCuentaBanco(@Param("idCuentaBanco")Long idCuentaBanco);

}
