package com.spring.sigmaweb.backend.process.tesoreria.egresos.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Table(name = "mt_asiento")
public class Asiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAsiento;
    private String idObra;
    private Long idObjeto;
    private String objeto;
    private Integer cuentaDebe;
    private Integer cuentaHaber;
    private Long idCentroResponsabilidad;
    private BigDecimal importe;
    private String numeroComprobante;
    private Long idProcesoRecuperacion;
    private Long  idObjetoCargo; //documento
    private Integer idTipoMoneda;
    private Long idTipoCambio;
    private Float tipoCambio;
    private Integer idTipoOperacion;//por validar
    private Date fechaOperacion;
    private Date fechaDocumento;
    private Integer anio;
    private Integer mes;
    private Integer idTipoDocumento;
    private Date fechaRegistro;
    private String creaporPer;
    private String modiporPer;
    private Date fechaActualiza;
    private Boolean flgEstado;

}
