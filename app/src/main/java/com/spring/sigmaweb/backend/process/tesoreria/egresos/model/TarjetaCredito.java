package com.spring.sigmaweb.backend.process.tesoreria.egresos.model;

import com.spring.sigmaweb.backend.process.legajo.model.Personal;
import lombok.*;
import javax.persistence.*;
import java.util.Date;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "mt_tarjeta_credito")
public class TarjetaCredito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTarjetaCredito;

    @ManyToOne
    @JoinColumn(name = "id_cuenta_banco")
    private CuentaBanco cuentaBanco;

    @ManyToOne
    @JoinColumn(name = "id_personal")
    private Personal personal;

    private String numeroTarjeta;
    private String idObra;
    private Date fechaRegistro;
    private Date fechaActualiza;
    private Boolean flgEstado;
}
