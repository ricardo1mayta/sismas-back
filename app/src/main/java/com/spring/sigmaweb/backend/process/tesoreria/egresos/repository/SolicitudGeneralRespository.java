package com.spring.sigmaweb.backend.process.tesoreria.egresos.repository;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.SolicitudGeneralListaDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.SolicitudGeneral;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SolicitudGeneralRespository extends IGenericRepo<SolicitudGeneral, Long> {

    @Query("select new com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.SolicitudGeneralListaDTO("
            + " s.idSolicitudGeneral,"
            + " s.personal.idPersonal,"
            + " concat(s.personal.idPersona.apePaternoPers ,' ',s.personal.idPersona.apeMaternoPers,' ',s.personal.idPersona.nombrePers),"
            + " s.idSolicitudGeneral,"
            + " (case when s.personalCargo.idPersonal is not null then concat(pp.apePaternoPers ,' ',pp.apeMaternoPers,' ',pp.nombrePers) "
            + " when s.personaCargo.idPersona is not null then concat(psc.apePaternoPers ,' ',psc.apeMaternoPers,' ',psc.nombrePers)"
            + " when s.entidadCargo.idEntidad is not null then e.nombreEnt else null end ),"
            + " s.detalle,"
            + " s.idTipoMoneda,"
            + " tm.descrip2Tab,"
            + " s.importeSolicitado,"
            + " s.importeAprobado,"
            + " s.fechaSolicitud ,"
            + " pc.cuentaPlanContable,"
            + " pc.nombrePlanContable,"
            + " t.descripTab,"
            + " s.idEstado,"
            + " s.tipoSolicitud.idTipoSolicitud,"
            + " s.tipoSolicitud.nombreTipoSolicitud)"
            + " from SolicitudGeneral s "
            + " left join Personal p on (s.personal.idPersonal=p.idPersonal)"
            + " left join Persona pp on (p.idPersona.idPersona=pp.idPersona)"
            + " left join Persona psc on (s.personaCargo.idPersona=psc.idPersona)"
            + " left join Entidad e on (s.entidadCargo.idEntidad=e.idEntidad)"
            + " left join PlanContable pc on (s.planContable.idPlanContable=pc.idPlanContable)"
            + " left join TablasTabla t on( s.idEstado=t.codigoTab)"
            + " left join TablasTabla tm on (s.idTipoMoneda=tm.codigoTab)"
            + " where s.idObra = :obraName order by s.idSolicitudGeneral desc")
    Page<SolicitudGeneralListaDTO> listarResumenSolicitudGeneral(@Param("obraName") String obraName, Pageable pageable);

    @Query("select new com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.SolicitudGeneralListaDTO("
            + " s.idSolicitudGeneral,"
            + " s.personal.idPersonal,"
            + " concat(s.personal.idPersona.apePaternoPers ,' ',s.personal.idPersona.apeMaternoPers,' ',s.personal.idPersona.nombrePers),"
            + " s.idSolicitudGeneral,"
            + " (case when s.personalCargo.idPersonal is not null then concat(pp.apePaternoPers ,' ',pp.apeMaternoPers,' ',pp.nombrePers) "
            + " when s.personaCargo.idPersona is not null then concat(psc.apePaternoPers ,' ',psc.apeMaternoPers,' ',psc.nombrePers)"
            + " when s.entidadCargo.idEntidad is not null then e.nombreEnt else null end ),"
            + " s.detalle,"
            + " s.idTipoMoneda,"
            + " tm.descrip2Tab,"
            + " mp.descrip2Tab,"
            + " s.importeSolicitado,"
            + " s.importeAprobado,"
            + " s.fechaSolicitud ,"
            + " t.descripTab,"
            + " s.idEstado,"
            + " s.tipoSolicitud.idTipoSolicitud,"
            + " s.tipoSolicitud.nombreTipoSolicitud)"
            + " from SolicitudGeneral s "
            + " left join Personal p on (s.personal.idPersonal=p.idPersonal)"
            + " left join Persona pp on (p.idPersona.idPersona=pp.idPersona)"
            + " left join Persona psc on (s.personaCargo.idPersona=psc.idPersona)"
            + " left join Entidad e on (s.entidadCargo.idEntidad=e.idEntidad)"
            + " left join TablasTabla t on( s.idEstado=t.codigoTab)"
            + " left join TablasTabla tm on (s.idTipoMoneda=tm.codigoTab)"
            + " left join TablasTabla mp on (s.idTipoModoPago=mp.codigoTab)"
            + " where s.idObra = :idObra and s.idEstado=:idEstado"
            + " order by s.idSolicitudGeneral desc")
    Page<SolicitudGeneralListaDTO>listarPorObraIdTipoEstadoSolicitudGeneral(@Param("idObra")String idObra, @Param("idEstado") Integer idEstado ,Pageable pageable);

    @Modifying
    @Query("update SolicitudGeneral  set idEstado=:idEstado  where idSolicitudGeneral=:idSolicitudGeneral ")
    void actualizarEstado(@Param("idEstado") Integer idEstado,@Param("idSolicitudGeneral") Long idSolicitudGeneral);
}