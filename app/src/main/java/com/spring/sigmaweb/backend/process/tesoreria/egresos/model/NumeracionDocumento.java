package com.spring.sigmaweb.backend.process.tesoreria.egresos.model;

import com.spring.sigmaweb.backend.process.legajo.model.Entidad;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "mt_numeracion_documento")
public class NumeracionDocumento {
    @Id
    private Long idNumeracionDocumento;
    private Integer idTipoDocumento;
    private Integer idTipoModoPago;

    @ManyToOne
    @JoinColumn(name = "id_entidad_banco")
    private Entidad entidadBanco;

    @ManyToOne
    @JoinColumn(name = "id_cuenta_banco")
    private CuentaBanco cuentaBanco;

    private String nombre;
    private String numeracionInicio;
    private String numeracionFin;
    private String numeracionActual;
    private String observacion;
    private String creaporPer;
    private Date fechaRegistro;
    private String modiporPer;
    private Date fechaActualiza;
    private Boolean flgEstado;
    private String idObra;

    public String aumentarNumeracion(){
          Integer numeracion=Integer.parseInt(getNumeracionActual())+1;
       return String.format("%08d",numeracion);
    }


}
