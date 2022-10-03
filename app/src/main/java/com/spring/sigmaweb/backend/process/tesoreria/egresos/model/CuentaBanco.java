package com.spring.sigmaweb.backend.process.tesoreria.egresos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.sigmaweb.backend.process.legajo.model.Entidad;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mt_cuenta_banco")
public class CuentaBanco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCuentaBanco;

    @ManyToOne
    @JoinColumn(name = "id_entidad_banco")
    private Entidad entidadBanco;
    private String numeroCuenta;
    private Integer cuentaContableBanco;
    private Integer idTipoCuentaBanco;
    private Integer idTipoMoneda;
    private String descripcion;
    private Date fechaApertura;
    private String creaporPer;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    private String modipoPer;
    private String fechaActualiza;
    private String idObra;
    private Boolean flgEstado;
    private Boolean flgEgreso;

    @JsonIgnoreProperties({"cuentaBanco","hibernateLazyInitializer", "handler" })
    @OneToMany(mappedBy = "cuentaBanco", cascade = {CascadeType.ALL})
    private List<TarjetaCredito> tarjetaCredito;

    @PrePersist
    public void prePersist(){this.fechaRegistro= new Date();}
}
