package com.spring.sigmaweb.backend.process.legajo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "mo_personal_datosbancarios_historico")
public class PersonalHistorcoBancario implements Serializable {

    @Id
    @Column(name = "id_histdb", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistdb;

    @Column(name = "id_obra_histdb", nullable = false, length = 6)
    private String idObraHistdb;

    @Column(name = "id_persona_histdb", nullable = false)
    private Long idPersonalHistdb;

    @Column(name = "id_pervila_histdb", nullable = false)
    private Long idPervilaHistdb;

    @Column(nullable = true, name = "fechacambio_histdb")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCambioHistdb;

    @Column(name = "tipo_histdb", nullable = false, length = 3)
    private String tipoHistdb;

    @Column(name = "entidad_hab_old_histdb", nullable = true, length = 100)
    private String entidadHabOldHistdb;

    @Column(name = "ctabanco_hab_old_histdb", nullable = true, length = 100)
    private String ctaBancoHabOldHistdb;

    @Column(name = "ctainter_hab_old_histdb", nullable = true, length = 100)
    private String ctaInterHabOldHistdb;

    @Column(name = "entidad_hab_new_histdb", nullable = true, length = 100)
    private String entidadHabNewHistdb;

    @Column(name = "ctabanco_hab_new_histdb", nullable = true, length = 100)
    private String ctaBancoHabNewHistdb;

    @Column(name = "ctainter_hab_new_histdb", nullable = true, length = 100)
    private String ctaInterHabNewHistdb;

    //cts
    @Column(name = "entidad_cts_old_histdb", nullable = true, length = 100)
    private String entidadCtsOldHistdb;

    @Column(name = "ctabanco_cts_old_histdb", nullable = true, length = 100)
    private String ctaBancoCtsOldHistdb;

    @Column(name = "ctainter_cts_old_histdb", nullable = true, length = 100)
    private String ctaInterCtsOldHistdb;

    @Column(name = "tipomoneda_cts_old_histdb", nullable = true)
    private String tipoMonedaCtsOldHistdb;

    @Column(name = "entidad_cts_new_histdb", nullable = true, length = 100)
    private String entidadCtsNewHistdb;

    @Column(name = "ctabanco_cts_new_histdb", nullable = true, length = 100)
    private String ctaBancoCtsNewHistdb;

    @Column(name = "ctainter_cts_new_histdb", nullable = true, length = 100)
    private String ctaInterCtsNewHistdb;

    @Column(name = "tipomoneda_cts_new_histdb", nullable = true)
    private String tipoMonedaCtsNewHistdb;

    @PrePersist
    public void prePersist() {
        this.fechaCambioHistdb= new Date();
    }

    public Long getIdHistdb() {
        return idHistdb;
    }

    public void setIdHistdb(Long idHistdb) {
        this.idHistdb = idHistdb;
    }

    public String getIdObraHistdb() {
        return idObraHistdb;
    }

    public void setIdObraHistdb(String idObraHistdb) {
        this.idObraHistdb = idObraHistdb;
    }

    public Long getIdPersonalHistdb() {
        return idPersonalHistdb;
    }

    public void setIdPersonalHistdb(Long idPersonalHistdb) {
        this.idPersonalHistdb = idPersonalHistdb;
    }

    public Long getIdPervilaHistdb() {
        return idPervilaHistdb;
    }

    public void setIdPervilaHistdb(Long idPervilaHistdb) {
        this.idPervilaHistdb = idPervilaHistdb;
    }

    public Date getFechaCambioHistdb() {
        return fechaCambioHistdb;
    }

    public void setFechaCambioHistdb(Date fechaCambioHistdb) {
        this.fechaCambioHistdb = fechaCambioHistdb;
    }

    public String getTipoHistdb() {
        return tipoHistdb;
    }

    public void setTipoHistdb(String tipoHistdb) {
        this.tipoHistdb = tipoHistdb;
    }


    public String getCtaBancoHabOldHistdb() {
        return ctaBancoHabOldHistdb;
    }

    public void setCtaBancoHabOldHistdb(String ctaBancoHabOldHistdb) {
        this.ctaBancoHabOldHistdb = ctaBancoHabOldHistdb;
    }

    public String getCtaInterHabOldHistdb() {
        return ctaInterHabOldHistdb;
    }

    public void setCtaInterHabOldHistdb(String ctaInterHabOldHistdb) {
        this.ctaInterHabOldHistdb = ctaInterHabOldHistdb;
    }

    public String getCtaBancoHabNewHistdb() {
        return ctaBancoHabNewHistdb;
    }

    public void setCtaBancoHabNewHistdb(String ctaBancoHabNewHistdb) {
        this.ctaBancoHabNewHistdb = ctaBancoHabNewHistdb;
    }

    public String getCtaInterHabNewHistdb() {
        return ctaInterHabNewHistdb;
    }

    public void setCtaInterHabNewHistdb(String ctaInterHabNewHistdb) {
        this.ctaInterHabNewHistdb = ctaInterHabNewHistdb;
    }

    public String getCtaBancoCtsOldHistdb() {
        return ctaBancoCtsOldHistdb;
    }

    public void setCtaBancoCtsOldHistdb(String ctaBancoCtsOldHistdb) {
        this.ctaBancoCtsOldHistdb = ctaBancoCtsOldHistdb;
    }

    public String getCtaInterCtsOldHistdb() {
        return ctaInterCtsOldHistdb;
    }

    public void setCtaInterCtsOldHistdb(String ctaInterCtsOldHistdb) {
        this.ctaInterCtsOldHistdb = ctaInterCtsOldHistdb;
    }


    public String getCtaBancoCtsNewHistdb() {
        return ctaBancoCtsNewHistdb;
    }

    public void setCtaBancoCtsNewHistdb(String ctaBancoCtsNewHistdb) {
        this.ctaBancoCtsNewHistdb = ctaBancoCtsNewHistdb;
    }

    public String getCtaInterCtsNewHistdb() {
        return ctaInterCtsNewHistdb;
    }

    public void setCtaInterCtsNewHistdb(String ctaInterCtsNewHistdb) {
        this.ctaInterCtsNewHistdb = ctaInterCtsNewHistdb;
    }


    public String getEntidadHabOldHistdb() {
        return entidadHabOldHistdb;
    }

    public void setEntidadHabOldHistdb(String entidadHabOldHistdb) {
        this.entidadHabOldHistdb = entidadHabOldHistdb;
    }

    public String getEntidadHabNewHistdb() {
        return entidadHabNewHistdb;
    }

    public void setEntidadHabNewHistdb(String entidadHabNewHistdb) {
        this.entidadHabNewHistdb = entidadHabNewHistdb;
    }

    public String getEntidadCtsOldHistdb() {
        return entidadCtsOldHistdb;
    }

    public void setEntidadCtsOldHistdb(String entidadCtsOldHistdb) {
        this.entidadCtsOldHistdb = entidadCtsOldHistdb;
    }

    public String getEntidadCtsNewHistdb() {
        return entidadCtsNewHistdb;
    }

    public void setEntidadCtsNewHistdb(String entidadCtsNewHistdb) {
        this.entidadCtsNewHistdb = entidadCtsNewHistdb;
    }

    public String getTipoMonedaCtsOldHistdb() {
        return tipoMonedaCtsOldHistdb;
    }

    public void setTipoMonedaCtsOldHistdb(String tipoMonedaCtsOldHistdb) {
        this.tipoMonedaCtsOldHistdb = tipoMonedaCtsOldHistdb;
    }

    public String getTipoMonedaCtsNewHistdb() {
        return tipoMonedaCtsNewHistdb;
    }

    public void setTipoMonedaCtsNewHistdb(String tipoMonedaCtsNewHistdb) {
        this.tipoMonedaCtsNewHistdb = tipoMonedaCtsNewHistdb;
    }

    private static final long serialVersionUID = 1L;
}
