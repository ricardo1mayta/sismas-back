package com.spring.sigmaweb.backend.process.tesoreria.egresos.service.impl;

import com.spring.sigmaweb.backend.process.generic.model.TipoCambio;
import com.spring.sigmaweb.backend.process.generic.repository.ITipoCambioDao;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.AsientoDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.CajaChicaLiquidacionDto;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.RendicionCajaChicaLiquidacionDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.dtoResumen.CajaChicaLiquidacionDatosDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.dtoResumen.CentroResponsabilidadAuxDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.*;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.*;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.CajaChicaLiquidacionService;
import com.spring.sigmaweb.backend.process.utils.Constants;
import com.spring.sigmaweb.backend.process.utils.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CajaChicaLiquidacionServiceImpl extends CRUDImpl<CajaChicaLiquidacion,Long> implements CajaChicaLiquidacionService {

    private final CajaChicaLiquidacionRepository repo;
    private final DocumentoEgresoRepository documentoEgresoRepo;
    private final ITipoCambioDao tipoCambioRepo;
    private final AsientoRepository asientoRepo;
    private final SolicitudGeneralRespository solicitudGeneralRespo;
    private final SolicitudGeneralDetalleRepository solicitudGeneralDetalleRepo;
    private final DistribucionCRDetalleRepository distribucionCRDetalleRepo;
    private final ModelMapper mapper;

    @Override
    protected IGenericRepo<CajaChicaLiquidacion, Long> getRepo() {
        return repo;
    }

    @Override
    public Page<CajaChicaLiquidacionDatosDTO> listarPorObra(String idObra, Integer page, Integer size) {
        return repo.listarPorObra(idObra, PageRequest.of(page, size));
    }

    @Override
    public CajaChicaLiquidacion registrarTransaccional(CajaChicaLiquidacion cajaChicaLiquidacion, List<AsientoDTO> asientoDTOList) {
        DocumentoEgreso documentoEgreso = documentoEgresoRepo.findById(cajaChicaLiquidacion.getDocumentoEgreso().getIdDocumentoEgreso()).orElse(null);
        TipoCambio tipoCambio = tipoCambioRepo.findByIdOBraAndDate(documentoEgreso.getIdObra(), new Date());

        CajaChicaLiquidacion cajaChicaLi = CajaChicaLiquidacion.builder()
                .idObra(cajaChicaLiquidacion.getIdObra())
                .solicitudGeneral(documentoEgreso.getSolicitudGeneral())
                .idCajaChicaMovimiento(null)
                .documentoEgreso(documentoEgreso)
                .entidadProveedor(cajaChicaLiquidacion.getEntidadProveedor())
                .idTipoDocumento(cajaChicaLiquidacion.getIdTipoDocumento())
                .numeroDocumento(cajaChicaLiquidacion.getNumeroDocumento())
                .importe(cajaChicaLiquidacion.getImporte())
                .descuento(cajaChicaLiquidacion.getDescuento())
                .impuesto((cajaChicaLiquidacion.getImpuesto()))
                .importeTotal(cajaChicaLiquidacion.getImporteTotal())
                .planContable(cajaChicaLiquidacion.getPlanContable())
                .creaporPer(cajaChicaLiquidacion.getCreaporPer())
                .idTipoDistribucion(cajaChicaLiquidacion.getIdTipoDistribucion())
                .fechaLiquidacion(cajaChicaLiquidacion.getFechaLiquidacion())//validar null
                .descripcion(cajaChicaLiquidacion.getDescripcion())
                .fechaRegistro(new Date())
                .flgEstado(Constants.FLAG_ESTADO.ACTIVO)
                .build();
        repo.save(cajaChicaLi);

        asientoDTOList.forEach(cr -> {
            Asiento asiento = Asiento.builder()
                    .idObra(cajaChicaLiquidacion.getIdObra())
                    .idObjeto(cajaChicaLi.getIdCajaChicaLiquidacion())
                    .objeto(Constants.OBJETO_NAME.CAJA_CHICA_LIQUIDACION)
                    .cuentaDebe(cajaChicaLiquidacion.getPlanContable().getCuentaPlanContable())
                    .cuentaHaber(null)
                    .centroResponsabilidad(mapper.map(cr.getCentroResponsabilidad(),CentroResponsabilidad.class) )
                    .importe(cr.getImporte())
                    .numeroComprobante(cajaChicaLiquidacion.getNumeroDocumento())
                    .idObjetoCargo(cajaChicaLiquidacion.getEntidadProveedor().getIdEntidad())
                    .idTipoMoneda(documentoEgreso.getIdTipoMoneda())
                    .idTipoCambio(tipoCambio.getIdTipoCambio())
                    .tipoCambio(tipoCambio.getTipoCambioVenta())
                    .idTipoOperacion(1)//validar
                    .fechaOperacion(new Date())
                    .fechaDocumento(cajaChicaLi.getFechaLiquidacion())
                    .anio(Utils.toYear(new Date()))
                    .mes(Utils.toMonth(new Date()))
                    .idTipoDocumento(cajaChicaLiquidacion.getIdTipoDocumento())
                    .fechaRegistro(new Date())
                    .creaporPer(cajaChicaLiquidacion.getCreaporPer())
                    .flgEstado(Constants.FLAG_ESTADO.ACTIVO)
                    .build();
            asientoRepo.save(asiento);
        });


        return cajaChicaLi;
    }

    @Override
    public List<CajaChicaLiquidacionDatosDTO> listarPorIdDocumentoEgreso(Long idDocumentoEgreso) {
        return repo.listarPorIdDocumentoEgreso(idDocumentoEgreso);
    }

    @Transactional
    @Override
    public Boolean confirmarRendicion(Long idDocumentoEgreso, BigDecimal montoEntregado, BigDecimal totalRendir, BigDecimal diferencia) {

        DocumentoEgreso documentoEgreso = documentoEgresoRepo.findById(idDocumentoEgreso).orElse(null);
        SolicitudGeneral solicitudGeneral = solicitudGeneralRespo.findById(documentoEgreso.getSolicitudGeneral().getIdSolicitudGeneral()).orElse(null);

        BigDecimal totalImporteARendir = BigDecimal.valueOf(0);
        BigDecimal diferenciaCal=null;
        try{
            for (CajaChicaLiquidacionDatosDTO cajaChica : repo.listarPorIdDocumentoEgreso(idDocumentoEgreso)) {
                totalImporteARendir = cajaChica.getImporteTotal().add(totalImporteARendir);
                log.info(totalImporteARendir.toString());
            }

            BigDecimal importeEntregado = documentoEgresoRepo.findById(idDocumentoEgreso).get().getImportePagado();
            if (totalImporteARendir.compareTo(importeEntregado) == 0) {
                solicitudGeneralRespo.actualizarEstadoRendimiento(solicitudGeneral.getIdSolicitudGeneral(),Constants.TIPO_ESTADO_RENDIMIENTO.FINALIZADO);//validar los codigos =20702
                documentoEgresoRepo.actualizarEstadoRendicion(idDocumentoEgreso,Boolean.TRUE);
            } else if (totalImporteARendir.compareTo(importeEntregado) > 0) { //mayor que proceso de diferencia de pago
                //Generar una solicitud
                List<SolicitudGeneralDetalle> solicitudGeneralDetalleList = solicitudGeneral.getSolicitudGeneralDetalle();
                SolicitudGeneral solicitudGeneralNew = SolicitudGeneral.builder()
                        .personal(solicitudGeneral.getPersonal())
                        .personalCargo(solicitudGeneral.getPersonalCargo())
                        .personaCargo(solicitudGeneral.getPersonaCargo())
                        .entidadCargo(solicitudGeneral.getEntidadCargo())
                        .idObra(solicitudGeneral.getIdObra())
                        .planContable(solicitudGeneral.getPlanContable())
                        .tipoSolicitud(null)
                        .idTipoMoneda(documentoEgreso.getIdTipoMoneda())
                        .importeSolicitado(diferencia)
                        .importeAprobado(null)//validar
                        .fechaSolicitud(solicitudGeneral.getFechaSolicitud())
                        .detalle(solicitudGeneral.getDetalle().concat(" ").concat(Constants.MSJ_DIF_SOL))
                        .idEstado(Constants.ESTADO_SOLICITUD.PENDIENTE)//por validar
                        .idUsuarioAutoriza(null)
                        .creaporPer(solicitudGeneral.getCreaporPer())//corregir
                        .fechaRegistro(new Date())
                        .flgCr(Boolean.FALSE)
                        .flgEstado(Boolean.TRUE)
                        .build();
                solicitudGeneralRespo.save(solicitudGeneralNew);

                for (SolicitudGeneralDetalle sgd : solicitudGeneralDetalleList) {
                    SolicitudGeneralDetalle solicitudGeneralDetalle = SolicitudGeneralDetalle.builder()
                            .solicitudGeneral(solicitudGeneralNew)
                            .centroResponsabilidad(sgd.getCentroResponsabilidad())
                            .idDistribucionPonderacion(sgd.getIdDistribucionPonderacion())
                            .idDistribucionPonderacionDet(sgd.getIdDistribucionPonderacionDet())
                            .importe(calcularImporteDistribuido(sgd))
                            .idTipoDistribucion(sgd.getIdTipoDistribucion())
                            .creaporPer(sgd.getCreaporPer())
                            .flgEstado(Boolean.TRUE)
                            .fechaRegistro(new Date())
                            .build();
                    solicitudGeneralDetalleRepo.save(solicitudGeneralDetalle);
                }
                solicitudGeneralRespo.actualizarEstadoRendimiento(solicitudGeneral.getIdSolicitudGeneral(),Constants.TIPO_ESTADO_RENDIMIENTO.INICIADO);//validar los codigos =20702

            } else { //menor que
                solicitudGeneralRespo.actualizarEstadoRendimiento(solicitudGeneral.getIdSolicitudGeneral(),Constants.TIPO_ESTADO_RENDIMIENTO.INICIADO);//validar los codigos =20702
                documentoEgresoRepo.actualizarEstadoRendicion(idDocumentoEgreso,Boolean.TRUE);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return Boolean.TRUE;
    }

    @Override
    public RendicionCajaChicaLiquidacionDTO buscarPorIdRendicion(Long idCajaChicaLiquidacion) {
        RendicionCajaChicaLiquidacionDTO rendicion= new RendicionCajaChicaLiquidacionDTO();
//        CajaChicaLiquidacion cajaChicaLiquidacion;
//        List<Asiento> asientoDTOList;
        CajaChicaLiquidacion cajaChicaLiquidacion=repo.findById(idCajaChicaLiquidacion).orElse(null);
        List<Asiento> asientoDTOList =asientoRepo.listarPorIdObjectoYObjecto(cajaChicaLiquidacion.getIdCajaChicaLiquidacion(),Constants.OBJETO_NAME.CAJA_CHICA_LIQUIDACION, cajaChicaLiquidacion.getIdObra());
        rendicion.setCajaChicaLiquidacion(mapper.map(cajaChicaLiquidacion,CajaChicaLiquidacionDto.class));
        rendicion.setAsientoDTOList(asientoDTOList.stream().map(a->mapper.map(a,AsientoDTO.class)).collect(Collectors.toList()));
        return rendicion;
    }

    @Override
    @Transactional
    public CajaChicaLiquidacion modificarTransaccional(CajaChicaLiquidacion cajaChicaLiquidacion, List<Asiento> asientoDTOList) {
        TipoCambio tipoCambio = tipoCambioRepo.findByIdOBraAndDate(cajaChicaLiquidacion.getIdObra(), new Date());
        CajaChicaLiquidacion cajaChicaLiquidacionActual = repo.findById(cajaChicaLiquidacion.getIdCajaChicaLiquidacion()).orElse(null);
        List<Asiento> asientoListOld = asientoRepo.listarPorIdObjectoYObjecto(cajaChicaLiquidacionActual.getIdCajaChicaLiquidacion(), Constants.OBJETO_NAME.CAJA_CHICA_LIQUIDACION, cajaChicaLiquidacion.getIdObra());
        List<Asiento> asientoListActual = asientoDTOList;
        List<Asiento> asientoListAuxOld = new ArrayList<>();
        List<Asiento> asientoListAuxOld2 = asientoRepo.listarPorIdObjectoYObjecto(cajaChicaLiquidacionActual.getIdCajaChicaLiquidacion(), Constants.OBJETO_NAME.CAJA_CHICA_LIQUIDACION, cajaChicaLiquidacion.getIdObra());
        List<Asiento> asientoListFinal = new ArrayList<>();

        if (asientoListOld.size() > 0) {
            //validar coincidencias
            asientoListOld.forEach(sdo -> {
                asientoListActual.forEach(sda -> {
                    if (Objects.equals(sdo.getCentroResponsabilidad().getIdCentroResponsabilidad(), sda.getCentroResponsabilidad().getIdCentroResponsabilidad())) {
                        sda.setIdAsiento(sdo.getIdAsiento());
                        asientoListAuxOld.add(sdo);// Coincidencias modificar
                        asientoListFinal.add(sda);
                    }
                });
            });
            CajaChicaLiquidacion cajaChicaLiquidacionActualNew = repo.findById(cajaChicaLiquidacion.getIdCajaChicaLiquidacion()).orElse(null);
            List<Asiento> asientoListOld2 = asientoRepo.listarPorIdObjectoYObjecto(cajaChicaLiquidacionActual.getIdCajaChicaLiquidacion(), Constants.OBJETO_NAME.CAJA_CHICA_LIQUIDACION, cajaChicaLiquidacion.getIdObra());
            List<Asiento> asientoListAuxdNew = new ArrayList<>();
            List<Asiento> asientoListAuxNew2 = asientoDTOList;

            asientoListActual.forEach(sda->{
                asientoListOld2.forEach(sdo->{
                    if(Objects.equals(sda.getCentroResponsabilidad().getIdCentroResponsabilidad(), sdo.getCentroResponsabilidad().getIdCentroResponsabilidad())){
                        if(sda.getIdAsiento()!=null){
                            sda.setIdAsiento(sdo.getIdAsiento());
                        }
                        asientoListAuxdNew.add(sda);
                    }
                });
            });

            if (asientoListAuxOld.size()>0){
                asientoListAuxOld2.removeAll(asientoListAuxOld);
                asientoRepo.deleteAll(asientoListAuxOld2);
            }

            if(asientoListAuxOld.size()==0){
                asientoRepo.deleteAll(asientoListOld);
            }

            if(asientoListAuxdNew.size()>0){
                asientoListAuxNew2.removeAll(asientoListAuxdNew);
                asientoListFinal.addAll(asientoListAuxNew2);
            }
            if(asientoListAuxdNew.size()==0){
                asientoListFinal.addAll((asientoListAuxNew2));
            }

            List<Asiento> asientoList= new ArrayList<>();

            for (Asiento det:asientoListFinal){
                if(det.getIdAsiento()==null){
                    det.setIdObra(cajaChicaLiquidacion.getIdObra());
                    det.setIdObjeto(cajaChicaLiquidacionActual.getIdCajaChicaLiquidacion());
                    det.setObjeto(Constants.OBJETO_NAME.CAJA_CHICA_LIQUIDACION);
                    det.setCuentaDebe(cajaChicaLiquidacion.getPlanContable().getCuentaPlanContable());
                    det.setNumeroComprobante(cajaChicaLiquidacion.getNumeroDocumento());
                    det.setIdObjetoCargo(cajaChicaLiquidacion.getEntidadProveedor().getIdEntidad());
                    det.setIdTipoMoneda(cajaChicaLiquidacionActual.getDocumentoEgreso().getIdTipoMoneda());
                    det.setTipoCambio(tipoCambio.getTipoCambioVenta());
                    det.setIdTipoCambio(tipoCambio.getIdTipoCambio());
                    det.setIdTipoOperacion(1);
                    det.setFechaOperacion(new Date());
                    det.setFechaDocumento(cajaChicaLiquidacionActual.getFechaLiquidacion());
                    det.setAnio(Utils.toYear(new Date()));
                    det.setMes(Utils.toMonth(new Date()));
                    det.setIdTipoDocumento(cajaChicaLiquidacion.getIdTipoDocumento());
                    det.setCreaporPer(cajaChicaLiquidacion.getCreaporPer());
                    det.setFlgEstado(Boolean.TRUE);
                    det.setFechaRegistro(new Date());
                    asientoRepo.save(det);
                }else{
                    Asiento asiento= asientoRepo.findById(det.getIdAsiento()).orElse(null);
                    asiento.setModiporPer(det.getModiporPer());
                    asiento.setFechaActualiza(new Date());
                    asiento.setModiporPer(det.getModiporPer());
                    asiento.setIdDistribucionPonderacion(det.getIdDistribucionPonderacion());
                    asiento.setIdTipoDistribucion(det.getIdTipoDistribucion());
                    asiento.setImporte(det.getImporte());
                    asientoList.add(asiento);
                }
                asientoRepo.saveAll(asientoList);
            }
        }else {
            for (Asiento det:asientoDTOList){
                det.setIdObra(cajaChicaLiquidacion.getIdObra());
                det.setIdObjeto(cajaChicaLiquidacionActual.getIdCajaChicaLiquidacion());
                det.setObjeto(Constants.OBJETO_NAME.CAJA_CHICA_LIQUIDACION);
                det.setCuentaDebe(cajaChicaLiquidacion.getPlanContable().getCuentaPlanContable());
                det.setNumeroComprobante(cajaChicaLiquidacion.getNumeroDocumento());
                det.setIdObjetoCargo(cajaChicaLiquidacion.getEntidadProveedor().getIdEntidad());
                det.setIdTipoMoneda(cajaChicaLiquidacionActual.getDocumentoEgreso().getIdTipoMoneda());
                det.setTipoCambio(tipoCambio.getTipoCambioVenta());
                det.setIdTipoCambio(tipoCambio.getIdTipoCambio());
                det.setIdTipoOperacion(1);
                det.setFechaOperacion(new Date());
                det.setFechaDocumento(cajaChicaLiquidacionActual.getFechaLiquidacion());
                det.setAnio(Utils.toYear(new Date()));
                det.setMes(Utils.toMonth(new Date()));
                det.setIdTipoDocumento(cajaChicaLiquidacion.getIdTipoDocumento());
                det.setCreaporPer(cajaChicaLiquidacion.getCreaporPer());
                det.setFlgEstado(Boolean.TRUE);
                det.setFechaRegistro(new Date());
                asientoRepo.save(det);
            }
        }

        cajaChicaLiquidacionActual.setImporte(cajaChicaLiquidacion.getImporte());
        cajaChicaLiquidacionActual.setDescuento(cajaChicaLiquidacion.getDescuento());
        cajaChicaLiquidacionActual.setImpuesto(cajaChicaLiquidacion.getImpuesto());
        cajaChicaLiquidacionActual.setIdTipoDocumento(cajaChicaLiquidacion.getIdTipoDocumento());
        cajaChicaLiquidacionActual.setNumeroDocumento(cajaChicaLiquidacion.getNumeroDocumento());
        cajaChicaLiquidacionActual.setPlanContable(cajaChicaLiquidacion.getPlanContable());
        cajaChicaLiquidacionActual.setDescripcion(cajaChicaLiquidacion.getDescripcion());

        return repo.save(cajaChicaLiquidacionActual);
    }

    private BigDecimal calcularImporteDistribuido(SolicitudGeneralDetalle solicitudGeneralDetalle){
        BigDecimal importe=null;
        if(solicitudGeneralDetalle.getIdTipoDistribucion().equals(Constants.TIPO_DISTRIBUCION.DIVISION) || solicitudGeneralDetalle.getIdTipoDistribucion().equals(Constants.TIPO_DISTRIBUCION.PERSONALIZADA)){
            importe=solicitudGeneralDetalle.getImporte().divide(new BigDecimal(3));
        }
        if(solicitudGeneralDetalle.getIdTipoDistribucion().equals(Constants.TIPO_DISTRIBUCION.ASIGNACION_DIRECTA)){
            DistribucionPonderacionDetalle distribucionPonderacionDetalle= distribucionCRDetalleRepo.findById(solicitudGeneralDetalle.getIdDistribucionPonderacionDet()).orElse(null);
            importe=(distribucionPonderacionDetalle.getMedidaPorcentual().multiply(solicitudGeneralDetalle.getImporte())).divide(new BigDecimal(100));
        }
        return importe;
    }

}
