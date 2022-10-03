package com.spring.sigmaweb.backend.process.tesoreria.egresos.service.impl;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.NumeracionDocumento;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.IGenericRepo;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.NumeracionDocumentoRepository;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.NumeracionDocumentoService;
import com.spring.sigmaweb.backend.process.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class NumeracionDocumentoServiceImpl extends  CRUDImpl<NumeracionDocumento,Long> implements NumeracionDocumentoService {

     private final NumeracionDocumentoRepository repo;

    @Override
    protected IGenericRepo<NumeracionDocumento, Long> getRepo() {
        return repo;
    }

    @Override
    public NumeracionDocumento findByIdTipoModoPago(Integer idTipoModoPago, String idObra) {
        return repo.findByIdTipoModoPago(idTipoModoPago,idObra);
    }

    @Override
    public NumeracionDocumento findByIdTipoModoPagoAndTipoMoneda(Integer idTipoModoPago, String idObra, Integer idTipoMoneda) {
        NumeracionDocumento numeracionDocumento;
        if(idTipoModoPago.equals(Constants.TIPO_MODO_PAGO.CHEQUE)){
            numeracionDocumento= repo.findByIdTipoModoPagoAndTipoMoneda(idTipoModoPago,idObra,idTipoMoneda);
        }else {
            numeracionDocumento=repo.findByIdTipoModoPago(idTipoModoPago,idObra);
        }
        numeracionDocumento.setNumeracionActual(numeracionDocumento.aumentarNumeracion());
        return numeracionDocumento;
    }
}
