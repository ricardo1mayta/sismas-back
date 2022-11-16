package com.spring.sigmaweb.backend.process.tesoreria.egresos.repository;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.ImpresoraCajaDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.Impresora;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.ImpresoraCaja;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ImpresoraRepository extends IGenericRepo<Impresora, Long> {
    @Query("select new com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.ImpresoraCajaDTO(" +
            "'-1' as idImpresoraCaja," +
            "i.idObra," +
            "CAST('-1' as long) as idCaja," +
            "'' as nombreCaja," +
            "false as flgEstadoCaja," +

            "i.idImpresora," +
            "i.nombreImpresora," +
            "i.serie," +
            "i.inicio," +
            "i.fin," +
            "i.actual," +
            "i.idTipoDocumento," +
            "tdoc.descripTab as tipoDocumento," +
            "i.flgEstado as flgEstadoImpresora," +

            "false as flgEstadoIP," +

            "i.creapor," +
            "i.fechaRegistro," +
            "i.modificadoPor," +
            "i.fechaActualiza" +
            ") " +
            "from Impresora i inner join Obra o on (i.idObra=o.idobra) " +
            "inner join TablasTabla tdoc on (i.idTipoDocumento = tdoc.codigoTab) " +
            "where o.idobra = :idobra "  +
            "and i.flgEstado = :estado "
    )
    List<ImpresoraCajaDTO> findByIdObraAndFlgEstado (@Param("idobra") String idobra, @Param("estado") Boolean estado);

    Impresora findByIdObraAndIdImpresora(String idobra, Long idimpresora);

    @Query("select i " +
            "from Impresora i inner join Obra o on (i.idObra=o.idobra) " +
            "inner join ImpresoraCaja ic on (i.idImpresora = ic.idImpresora and o.idobra = ic.idObra ) " +
            "inner join Caja c on (ic.idCaja = c.idCaja and o.idobra = c.idObra) " +
            "where o.idobra = :idobra " +
            "and c.idCaja= :idcaja " +
            "and i.idImpresora = :idimpresora"
    )
    Impresora findByIdimpresorasCajaObra(@Param("idobra") String idobra, @Param("idcaja") Long idcaja, @Param("idimpresora") Long idimpresora);

    @Query("select ic " +
            "from Impresora i inner join Obra o on (i.idObra=o.idobra) " +
            "inner join ImpresoraCaja ic on (i.idImpresora = ic.idImpresora and o.idobra = ic.idObra ) " +
            "inner join Caja c on (ic.idCaja = c.idCaja and o.idobra = c.idObra) " +
            "where o.idobra = :idobra " +
            "and c.idCaja= :idcaja "
    )
    List<ImpresoraCaja> findByImpresorasCajaObraTodos(@Param("idobra") String idobra, @Param("idcaja") Long idcaja);

    @Query("select new com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.ImpresoraCajaDTO(" +
            "ic.idImpresoraCaja," +
            "o.idobra," +
            "c.idCaja," +
            "c.nombreCaja," +
            "c.flgEstado as flgEstadoCaja," +

            "i.idImpresora," +
            "i.nombreImpresora," +
            "i.serie," +
            "i.inicio," +
            "i.fin," +
            "i.actual," +
            "i.idTipoDocumento," +
            "tdoc.descripTab as tipoDocumento," +
            "i.flgEstado as flgEstadoImpresora," +

            "ic.flgEstado as flgEstadoIP," +

            "ic.creapor," +
            "ic.fechaRegistro," +
            "ic.modificadoPor," +
            "ic.fechaActualiza" +
            ") " +
            "from Impresora i inner join Obra o on (i.idObra=o.idobra) " +
            "inner join ImpresoraCaja ic on (i.idImpresora = ic.idImpresora and o.idobra = ic.idObra ) " +
            "inner join Caja c on (ic.idCaja = c.idCaja and o.idobra = c.idObra) " +
            "inner join TablasTabla tdoc on (i.idTipoDocumento = tdoc.codigoTab) " +
            "where o.idobra = :idobra "  +
            "and i.flgEstado = :estado " +
            "and c.idCaja= :idcaja " /*+
            "and ic.flgEstado = :estado "*/
    )
    List<ImpresoraCajaDTO> findByImpresorasCajaSelect(@Param("idobra") String idobra, @Param("idcaja") Long idcaja, @Param("estado") Boolean estado);

    //delete
    @Modifying
    @Query("DELETE FROM ImpresoraCaja ic WHERE ic.idObra = :idobra and ic.idCaja = :idcaja and ic.idImpresora=:idimpresora")
    public int deleteImpresoraCaja(@Param("idobra") String idobra, @Param("idcaja") Long idcaja, @Param("idimpresora") Long idimpresora);
}
