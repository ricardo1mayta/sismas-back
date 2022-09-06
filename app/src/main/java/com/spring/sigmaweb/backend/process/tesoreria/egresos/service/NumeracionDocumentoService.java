package com.spring.sigmaweb.backend.process.tesoreria.egresos.service;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.NumeracionDocumento;

public interface NumeracionDocumentoService extends ICRUD<NumeracionDocumento,Long>{

    NumeracionDocumento findByIdTipoModoPago(Integer idTipoModoPago, String idObra);
    NumeracionDocumento findByIdTipoModoPagoAndTipoMoneda(Integer idTipoModoPago, String idObra, Integer idTipoMoneda);
}
