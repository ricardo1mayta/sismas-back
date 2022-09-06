package com.spring.sigmaweb.backend.process.tesoreria.egresos.repository;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.NumeracionDocumento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NumeracionDocumentoRepository extends IGenericRepo<NumeracionDocumento,Long>{

    @Query("FROM NumeracionDocumento n where n.idTipoModoPago=:idTipoModoPago and n.idObra=:idObra and n.flgEstado=true")
    NumeracionDocumento findByIdTipoModoPago(@Param("idTipoModoPago") Integer idTipoModoPago,@Param("idObra")String idObra);

//    @Query(" from NumeracionDocumento n inner join CuentaBanco  c on(n.cuentaBanco.idCuentaBanco=c.idCuentaBanco)  " +
//            "where n.idTipoModoPago=:idTipoModoPago and n.idObra=:idObra and c.idTipoMoneda=:idTipoMoneda and n.flgEstado=true ")
    @Query(value = "select \n" +
            "\tmnd.*\n" +
            "from  mt_numeracion_documento mnd  \n" +
            "inner join mt_cuenta_banco mcb  on mnd.id_cuenta_banco =mcb.id_cuenta_banco \n" +
            "where mnd.id_obra =:idObra \n" +
            " and mnd.id_tipo_modo_pago =:idTipoModoPago \n" +
            " and mcb.id_tipo_moneda =:idTipoMoneda \n" +
            " limit 1",nativeQuery = true)
    NumeracionDocumento findByIdTipoModoPagoAndTipoMoneda(@Param("idTipoModoPago") Integer idTipoModoPago,@Param("idObra")String idObra,@Param("idTipoMoneda") Integer idTipoMoneda);
}
