package com.spring.sigmaweb.backend.process.generic.repository;

import com.spring.sigmaweb.backend.process.generic.dto.TipoCambioDTO;
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

    @Query(value = "FROM TipoCambio tc where tc.idObra=:idObra and date(tc.fecha)=date(:fecha) and tc.idTipoMoneda = :moneda")
    TipoCambio findByIdOBraAndDateAndMoneda(@Param("idObra") String idObra, @Param("fecha") Date fecha, @Param("moneda") Integer moneda);

    @Query("select new com.spring.sigmaweb.backend.process.generic.dto.TipoCambioDTO(" +
            "tc.idTipoCambio, " +
            "tc.fecha, " +
            "tc.idTipoMoneda," +
            "t.descripTab, " +
            "tc.tipoCambioVenta, " +
            "tc.tipoCambioCompra, " +
            "tc.creaporPer, " +
            "tc.fechaRegistro, " +
            "tc.idObra, " +
            "tc.flgEstado" +
            ") " +
            "FROM TipoCambio tc inner join TablasTabla t on (tc.idTipoMoneda = t.codigoTab and 501 = t.tipoTab) " +
            "where tc.idObra=:idObra " +
            "order by tc.fecha desc")
    List<TipoCambioDTO> findByIdObraDto(@Param("idObra")String idObra);
}
