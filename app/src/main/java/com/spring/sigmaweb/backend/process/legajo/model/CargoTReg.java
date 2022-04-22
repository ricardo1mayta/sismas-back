package com.spring.sigmaweb.backend.process.legajo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "mo_cargo_t_reg")
public class CargoTReg implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id_cargo_tr", nullable = false, unique = true)
    private Long idCargoTr;

    @Column(nullable = false, length = 200, name = "descrip_cargo_tr", unique = true)
    private String descripCargoTr;

    public Long getIdCargoTr() {
        return idCargoTr;
    }

    public void setIdCargoTr(Long idCargoTr) {
        this.idCargoTr = idCargoTr;
    }

    public String getDescripCargoTr() {
        return descripCargoTr;
    }

    public void setDescripCargoTr(String descripCargoTr) {
        this.descripCargoTr = descripCargoTr;
    }
}
