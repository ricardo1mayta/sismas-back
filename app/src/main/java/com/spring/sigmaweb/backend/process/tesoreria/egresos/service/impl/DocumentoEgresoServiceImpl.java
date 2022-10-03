package com.spring.sigmaweb.backend.process.tesoreria.egresos.service.impl;

import com.spring.sigmaweb.backend.process.generic.model.TipoCambio;
import com.spring.sigmaweb.backend.process.generic.service.impl.TipoCambioServiceImpl;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.DocumentoEgresoListaDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.*;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.DetraccionRepository;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.DocumentoEgresoRepository;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.IGenericRepo;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.CuentaBancoService;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.DocumentoEgresoService;
import com.spring.sigmaweb.backend.process.utils.Constants;
import com.spring.sigmaweb.backend.process.utils.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DocumentoEgresoServiceImpl extends CRUDImpl<DocumentoEgreso,Long> implements DocumentoEgresoService {

    private final DocumentoEgresoRepository repo;
    private final SolicitudGeneralServiceImpl solicitudGeneralService;
    private final AsientoServiceImpl asientoService;
    private final CuentaBancoService cuentaBancoService;
    private final TipoCambioServiceImpl tipoCambioService;
    private final NumeracionDocumentoServiceImpl numeracionDocumentoService;
    private final DetraccionRepository detraccionServiceRepo;

    @Override
    protected IGenericRepo<DocumentoEgreso, Long> getRepo() {
        return repo;
    }

    @Override
    public List<DocumentoEgreso> listarPorObraDocumentoEgreso(String idObra) {

        return repo.listarPorObraDocumentoEgreso(idObra);

    }

    @Override
    public Page<DocumentoEgresoListaDTO> listarPorObra(String idObra, Integer page, Integer size) {
        return repo.listarPorObra(idObra, PageRequest.of(page,size));

    }

    @Override
    public Page<DocumentoEgresoListaDTO> listarPorTipoSolicitud(String idObra, Integer idTipo, Integer page, Integer size) {
        return repo.listarPorTipoSolicitud(idObra,idTipo,PageRequest.of(page,size));
    }

    @Override
    @Transactional
    public DocumentoEgreso registrarTransaccional(DocumentoEgreso documentoEgresoBody) throws Exception {

        SolicitudGeneral solicitudGeneral=solicitudGeneralService.buscarPorId(documentoEgresoBody.getSolicitudGeneral().getIdSolicitudGeneral());
        List<SolicitudGeneralDetalle> solicitudGeneralDetalleList=solicitudGeneral.getSolicitudGeneralDetalle();
        TipoCambio tipoCambio=tipoCambioService.findByIdOBraAndDate(solicitudGeneral.getIdObra(),new Date());
        NumeracionDocumento numeracionDocumento;

        if(documentoEgresoBody.getIdTipoModoPago().equals(Constants.TIPO_MODO_PAGO.CHEQUE)){
            numeracionDocumento=numeracionDocumentoService.findByIdTipoModoPagoAndTipoMoneda(documentoEgresoBody.getIdTipoModoPago(),solicitudGeneral.getIdObra(),documentoEgresoBody.getIdTipoMoneda());
        }else {
            numeracionDocumento=numeracionDocumentoService.findByIdTipoModoPago(documentoEgresoBody.getIdTipoModoPago(),solicitudGeneral.getIdObra());
        }
        //validar detraccion si llega en 0
        DocumentoEgreso documentoEgreso= new DocumentoEgreso();
        documentoEgreso.setIdObra(solicitudGeneral.getIdObra());
       // documentoEgreso.setNumeroDocumentoEgreso(repo.numeroCorrelativo(solicitudGeneral.getIdObra())+1);//programado validar entres ingresos
        documentoEgreso.setIdCajaGen(documentoEgresoBody.getIdCajaGen());//falta validar
        documentoEgreso.setIdTipoDocumentoEgreso("A");//pendiente - validar
        documentoEgreso.setIdCompra(null);//pendiente - validar
        documentoEgreso.setSolicitudGeneral(solicitudGeneral);
        documentoEgreso.setIdCaja(documentoEgresoBody.getIdCaja());//pendiente - validar
        documentoEgreso.setUsuarioCaja(documentoEgresoBody.getUsuarioCaja());//programado validar
        documentoEgreso.setIdUsuarioCaja(documentoEgresoBody.getIdUsuarioCaja());
        documentoEgreso.setProveedorCargo(solicitudGeneral.getEntidadCargo());
        documentoEgreso.setPersonalCargo(solicitudGeneral.getPersonalCargo());
        documentoEgreso.setPersonaCargo(solicitudGeneral.getPersonaCargo());
        documentoEgreso.setIdTipoMoneda(documentoEgresoBody.getIdTipoMoneda());
        documentoEgreso.setGlosa(documentoEgresoBody.getGlosa());
        documentoEgreso.setDetraccion(documentoEgresoBody.getDetraccion());
        documentoEgreso.setImporteDetraccion(documentoEgresoBody.getImporteDetraccion());//programado validar insert
        if(documentoEgresoBody.getDetraccion()==null){
            documentoEgreso.setDetraccion(detraccionServiceRepo.findDetraccionByImport(documentoEgreso.getIdObra()));
            documentoEgreso.setImporteDetraccion(BigDecimal.valueOf(0));
        }
        documentoEgreso.setImporteGarantia(documentoEgresoBody.getImporteGarantia());
        documentoEgreso.setDescuentoNotaCredito(documentoEgresoBody.getDescuentoNotaCredito());
        documentoEgreso.setNumeroNotaCredito(documentoEgresoBody.getNumeroNotaCredito());
        documentoEgreso.setImportePagado(documentoEgresoBody.getImportePagado());
        documentoEgreso.setEntidadBanco(cuentaBancoService.buscarPorIdCuentaBanco(documentoEgresoBody.getCuentaBanco().getIdCuentaBanco()).getEntidadBanco());
        documentoEgreso.setCuentaBanco(documentoEgresoBody.getCuentaBanco());
        documentoEgreso.setTarjetaCredito(documentoEgresoBody.getTarjetaCredito());
        documentoEgreso.setNumeroMovimiento(numeracionDocumento.aumentarNumeracion());//programado por validar cheque
        documentoEgreso.setNumeroDocumentoReferencia(documentoEgresoBody.getNumeroDocumentoReferencia());
        documentoEgreso.setFlgRendicion(null);
        documentoEgreso.setIdTipoModoPago(documentoEgresoBody.getIdTipoModoPago());
        documentoEgreso.setIdTipoDocumento(documentoEgresoBody.getIdTipoDocumento());
        documentoEgreso.setIdTipoCambio(tipoCambio.getIdTipoCambio());//programado validar tipo cambio del dia o de la solicitud CONTROL DE
        documentoEgreso.setTipoCambioVenta(tipoCambio.getTipoCambioVenta());
        documentoEgreso.setCreaporPer(documentoEgresoBody.getCreaporPer());
        documentoEgreso.setFechaRegistro(new Date());
        documentoEgreso.setFlgEstado(Constants.FLAG_ESTADO.ACTIVO);
        repo.save(documentoEgreso);

        numeracionDocumento.setNumeracionActual(numeracionDocumento.aumentarNumeracion());
        numeracionDocumentoService.modificar(numeracionDocumento);

        if(solicitudGeneralDetalleList.size()>0){
            solicitudGeneralDetalleList.forEach(sd->{
                Long idObjectoCargo2=null;
                try {
                    Asiento asiento= new Asiento();
                    asiento.setIdObra(solicitudGeneral.getIdObra());
                    asiento.setIdObjeto(solicitudGeneral.getIdSolicitudGeneral());
                    asiento.setObjeto(Constants.OBJETO_NAME.SOLICITUD_GENERAL);
                    asiento.setCuentaDebe(solicitudGeneral.getPlanContable().getCuentaPlanContable());
                    //asiento.setIdCentroResponsabilidad(null);
                    asiento.setImporte(null);
                    asiento.setNumeroComprobante(documentoEgresoBody.getNumeroDocumentoReferencia());
                    asiento.setIdProcesoRecuperacion(null);
                    if(solicitudGeneral.getPersonaCargo()!=null){
                        idObjectoCargo2=solicitudGeneral.getPersonaCargo().getIdPersona();
                    }
                    if(solicitudGeneral.getPersonalCargo()!=null){
                        idObjectoCargo2=solicitudGeneral.getPersonalCargo().getIdPersonal();
                    }
                    if(solicitudGeneral.getEntidadCargo()!=null){
                        idObjectoCargo2=solicitudGeneral.getEntidadCargo().getIdEntidad();
                    }
                    asiento.setIdObjetoCargo(idObjectoCargo2);//por validar
                    asiento.setIdTipoMoneda(solicitudGeneral.getIdTipoMoneda());
                    asiento.setIdTipoCambio(tipoCambio.getIdTipoCambio());
                    asiento.setTipoCambio(tipoCambio.getTipoCambioVenta());
                    asiento.setIdTipoOperacion(null);//por validar
                    asiento.setFechaOperacion(new Date());
                    asiento.setFechaDocumento(documentoEgreso.getFechaRegistro());
                    asiento.setAnio(Utils.toYear(new Date()));
                    asiento.setMes(Utils.toMonth(new Date()));
                    asiento.setIdTipoDocumento(documentoEgresoBody.getIdTipoDocumento());//DocumentoEgreso
                    asiento.setFechaRegistro(new Date());
                    asiento.setCreaporPer(documentoEgresoBody.getCreaporPer());
                    asiento.setFlgEstado(Constants.FLAG_ESTADO.ACTIVO);

                    asiento.setCentroResponsabilidad(sd.getCentroResponsabilidad());
                    asiento.setImporte(sd.getImporte());
                    asientoService.registrar(asiento);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }else {
            Long idObjectoCargo2=null;
            try {
                Asiento asiento= new Asiento();
                asiento.setIdObra(solicitudGeneral.getIdObra());
                asiento.setIdObjeto(solicitudGeneral.getIdSolicitudGeneral());
                asiento.setObjeto(Constants.OBJETO_NAME.SOLICITUD_GENERAL);
                asiento.setCuentaDebe(solicitudGeneral.getPlanContable().getCuentaPlanContable());
                asiento.setCuentaHaber(null);
                asiento.setCentroResponsabilidad(null);
                asiento.setNumeroComprobante(documentoEgresoBody.getNumeroDocumentoReferencia());
                asiento.setIdProcesoRecuperacion(null);
                if(solicitudGeneral.getPersonaCargo()!=null){
                    idObjectoCargo2=solicitudGeneral.getPersonaCargo().getIdPersona();
                }
                if(solicitudGeneral.getPersonalCargo()!=null){
                    idObjectoCargo2=solicitudGeneral.getPersonalCargo().getIdPersonal();
                }
                if(solicitudGeneral.getEntidadCargo()!=null){
                    idObjectoCargo2=solicitudGeneral.getEntidadCargo().getIdEntidad();
                }
                asiento.setIdObjetoCargo(idObjectoCargo2);//por validar
                asiento.setIdTipoMoneda(solicitudGeneral.getIdTipoMoneda());
                asiento.setIdTipoCambio(documentoEgresoBody.getIdTipoCambio());
                asiento.setIdTipoOperacion(0);//por validar
                asiento.setFechaOperacion(new Date());
                asiento.setFechaDocumento(documentoEgreso.getFechaRegistro());
                asiento.setAnio(Utils.toYear(new Date()));
                asiento.setMes(Utils.toMonth(new Date()));
                asiento.setIdTipoDocumento(documentoEgresoBody.getIdTipoDocumento());//DocumentoEgreso
                asiento.setFechaRegistro(new Date());
                asiento.setCreaporPer(documentoEgresoBody.getCreaporPer());
                asiento.setFlgEstado(Constants.FLAG_ESTADO.ACTIVO);
                asiento.setImporte(solicitudGeneral.getImporteAprobado());
                asientoService.registrar(asiento);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        solicitudGeneral.setFechaActualiza(new Date());
        solicitudGeneral.setModiporPer(documentoEgresoBody.getCreaporPer());
        solicitudGeneralService.actualizarEstado(Constants.ESTADO_SOLICITUD.PAGADO,solicitudGeneral.getIdSolicitudGeneral());

        return documentoEgreso;
    }

    @Override
    public Integer numeroCorrelativo(String idObra) {
        //return repo.numeroCorrelativo(idObra);
        return null;
    }


}
