package com.spring.sigmaweb.backend.process.tesoreria.egresos.repository;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.TarjetaCreditoDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.TarjetaCreditoDataDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.TarjetaCredito;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TarjetaCreditoRepository extends IGenericRepo<TarjetaCredito,Long>{

    @Query("FROM TarjetaCredito t where t.idObra=:idObra and t.flgEstado =true")
    List<TarjetaCredito> findByidObra(@Param("idObra")String idObra);

    @Query("FROM TarjetaCredito t where t.idObra=:idObra and t.cuentaBanco.idCuentaBanco=:idCuentaBanco  and t.flgEstado =true")
    List<TarjetaCredito> findByIdAndCuentaBancoAndIdObra(@Param("idObra")String idObra,@Param("idCuentaBanco")Long idCuentaBanco);

    @Query("select new com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.TarjetaCreditoDataDTO(" +
            "tc.idTarjetaCredito, " +
            "cb.idCuentaBanco, " +
            "cb.descripcion, " +
            "cb.numeroCuenta, " +

            "p.idPersonal," +
            "psn.apePaternoPers, " +
            "psn.apeMaternoPers, " +
            "psn.nombrePers, " +
            "CONCAT(coalesce(psn.apePaternoPers, ''), ' ', coalesce(psn.apeMaternoPers, ''), ' ', coalesce(psn.nombrePers, '')), " +
            "psn.nroDocPers, " +
            "p.codigoPer, " +

            "tc.numeroTarjeta, " +
            "o.idobra, " +
            "tc.fechaRegistro, " +
            "tc.fechaActualiza, " +
            "tc.flgEstado " +
            ")" +
            "from TarjetaCredito tc inner join Obra o on (tc.idObra = o.idobra) " +
            "inner join Personal p on (tc.personal = p.idPersonal and p.obraPer = o.idobra) " +
            "inner join Persona psn on (p.idPersona =psn.idPersona and o.idobra= psn.obraPers) " +
            "inner join CuentaBanco cb on (tc.cuentaBanco = cb.idCuentaBanco and o.idobra = cb.idObra) " +
            "where tc.idObra=:idObra " +
            "and tc.flgEstado =(case :estado when 0 then false when 1 then true else tc.flgEstado end)"
    )
    List<TarjetaCreditoDataDTO> findByidObraEstado(@Param("idObra")String idObra , @Param("estado") Integer estado);
}
