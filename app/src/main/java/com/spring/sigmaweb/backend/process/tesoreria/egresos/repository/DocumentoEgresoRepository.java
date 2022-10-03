package com.spring.sigmaweb.backend.process.tesoreria.egresos.repository;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.DocumentoEgresoListaDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.DocumentoEgreso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DocumentoEgresoRepository extends IGenericRepo<DocumentoEgreso, Long> {

    @Query("select new com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.DocumentoEgresoListaDTO("
            +" d.idDocumentoEgreso,"
            +" d.numeroDocumentoEgreso,"
            +" d.solicitudGeneral.idSolicitudGeneral,"
            +" d.idTipoModoPago,"
            +" tmp.descripTab,"
            +" d.idDocumentoEgreso,"
            +" (case when d.personalCargo.idPersonal is not null then concat(pp.apePaternoPers ,' ',pp.apeMaternoPers,' ',pp.nombrePers) "
            +" when d.personaCargo.idPersona is not null then concat(psc.apePaternoPers ,' ',psc.apeMaternoPers,' ',psc.nombrePers)"
            +" when d.proveedorCargo.idEntidad is not null then e.nombreComerEnt else null end ),"
            +" d.numeroMovimiento,"
            +" d.importePagado,"
            +" d.idTipoMoneda,"
            +" t.descrip2Tab,"
            +" d.fechaRegistro)"
            +" from DocumentoEgreso d "
            +" left join Personal p on (d.personalCargo.idPersonal=p.idPersonal) "
            +" left join Persona pp on (p.idPersona.idPersona=pp.idPersona)"
            +" left join Persona psc on (d.personaCargo.idPersona=psc.idPersona)"
            +" left join Entidad e on (d.proveedorCargo.idEntidad=e.idEntidad)"
            +" left join TablasTabla t on (d.idTipoMoneda=t.codigoTab)"
            +" left join TablasTabla  tmp on (d.idTipoModoPago=tmp.codigoTab)"
            +" where d.idObra=:idObra and  d.flgEstado=true "
            +" order by d.idDocumentoEgreso desc")
    Page<DocumentoEgresoListaDTO> listarPorObra(@Param("idObra") String idObra, Pageable pageable);


    @Query("select new com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.DocumentoEgresoListaDTO("
            +" d.idDocumentoEgreso,"
            +" d.numeroDocumentoEgreso,"
            +" concat(sg.personal.idPersona.apePaternoPers ,sg.personal.idPersona.apeMaternoPers,sg.personal.idPersona.nombrePers),"
            +" d.solicitudGeneral.idSolicitudGeneral,"
            +" d.idTipoModoPago,"
            +" tmp.descripTab,"
            +" d.idDocumentoEgreso,"
            +" (case when d.personalCargo.idPersonal is not null then concat(pp.apePaternoPers ,' ',pp.apeMaternoPers,' ',pp.nombrePers) "
            +" when d.personaCargo.idPersona is not null then concat(psc.apePaternoPers ,' ',psc.apeMaternoPers,' ',psc.nombrePers)"
            +" when d.proveedorCargo.idEntidad is not null then e.nombreComerEnt else null end ),"
            +" d.glosa,"
            +" d.numeroMovimiento,"
            +" d.importePagado,"
            +" d.idTipoMoneda,"
            +" t.descrip2Tab,"
            +" d.fechaRegistro,"
            +" d.flgRendicion)"
            +" from DocumentoEgreso d left join SolicitudGeneral sg on(d.solicitudGeneral.idSolicitudGeneral=sg.idSolicitudGeneral)"
            +" left join Personal p on (d.personalCargo.idPersonal=p.idPersonal) "
            +" left join Persona pp on (p.idPersona.idPersona=pp.idPersona)"
            +" left join Persona psc on (d.personaCargo.idPersona=psc.idPersona)"
            +" left join Entidad e on (d.proveedorCargo.idEntidad=e.idEntidad)"
            +" left join TablasTabla t on (d.idTipoMoneda=t.codigoTab)"
            +" left join TablasTabla  tmp on (d.idTipoModoPago=tmp.codigoTab)"
            +" where d.idObra=:idObra and  d.flgEstado=true "
            +" and sg.tipoSolicitud.idTipo=:idTipo"
            +" order by d.idDocumentoEgreso desc")
    Page<DocumentoEgresoListaDTO>listarPorTipoSolicitud(@Param("idObra") String idObra, @Param("idTipo") Integer idTipo,Pageable pageable);

    @Query("FROM DocumentoEgreso e where e.idObra=:idObra and e.flgEstado=true ")
    List<DocumentoEgreso> listarPorObraDocumentoEgreso(@Param("idObra") String idObra);

    @Query(value = "select ifnull( max(numero_documento_egreso),0) from mt_documento_egreso where id_obra=:idObra ",nativeQuery = true)
    Integer numeroCorrelativo(@Param("idObra") String idObra);

    @Modifying
    @Query("update DocumentoEgreso  set flgRendicion=:flgRendicion  where idDocumentoEgreso=:idDocumentoEgreso ")
    void actualizarEstadoRendicion(@Param("idDocumentoEgreso") Long idDocumentoEgreso,@Param("flgRendicion") Boolean idEstado);

}