package com.spring.sigmaweb.backend.process.tesoreria.egresos.repository;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.dtoResumen.CajaChicaLiquidacionDatosDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.CajaChicaLiquidacion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CajaChicaLiquidacionRepository extends IGenericRepo<CajaChicaLiquidacion, Long> {

    @Query("select new com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.dtoResumen.CajaChicaLiquidacionDatosDTO("
            +" c.idCajaChicaLiquidacion,"
            +" de.idDocumentoEgreso,"
            +" e.idEntidad,"
            +" c.idTipoDocumento,"
            +" td.descripTab,"
            +" c.numeroDocumento,"
            +" c.importe,"
            +" c.descuento,"
            +" c.impuesto,"
            +" c.importeTotal,"
            +" c.importeDevuelto)"
            +" from CajaChicaLiquidacion c "
            +" left join DocumentoEgreso de on (c.documentoEgreso.idDocumentoEgreso=de.idDocumentoEgreso) "
            +" left join Entidad e on (c.entidadProveedor.idEntidad=e.idEntidad)"
            +" left join TablasTabla td on (c.idTipoDocumento=td.codigoTab)"
            +" where c.idObra=:idObra and  c.flgEstado=true "
            +" order by c.idCajaChicaLiquidacion desc")
    Page<CajaChicaLiquidacionDatosDTO> listarPorObra(@Param("idObra")String idObra, Pageable pageable);

    @Query("select new com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.dtoResumen.CajaChicaLiquidacionDatosDTO("
            +" c.idCajaChicaLiquidacion,"
            +" de.idDocumentoEgreso,"
            +" e.idEntidad,"
            +" e.nombreEnt,"
            +" e.rucEnt,"
            +" c.idTipoDocumento,"
            +" td.descripTab,"
            +" c.numeroDocumento,"
            +" c.importe,"
            +" c.descuento,"
            +" c.impuesto,"
            +" c.importeTotal,"
            +" c.importeDevuelto)"
            +" from CajaChicaLiquidacion c "
            +" left join DocumentoEgreso de on (c.documentoEgreso.idDocumentoEgreso=de.idDocumentoEgreso) "
            +" left join Entidad e on (c.entidadProveedor.idEntidad=e.idEntidad)"
            +" left join TablasTabla td on (c.idTipoDocumento=td.codigoTab)"
            +" where c.documentoEgreso.idDocumentoEgreso=:idDocumentoEgreso and  c.flgEstado=true "
            +" order by c.idCajaChicaLiquidacion desc")
    List<CajaChicaLiquidacionDatosDTO> listarPorIdDocumentoEgreso(@Param("idDocumentoEgreso") Long idDocumentoEgreso);



}