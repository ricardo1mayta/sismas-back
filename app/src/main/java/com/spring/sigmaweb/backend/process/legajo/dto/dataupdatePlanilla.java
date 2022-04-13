package com.spring.sigmaweb.backend.process.legajo.dto;

import java.io.Serializable;

public class dataupdatePlanilla implements Serializable {
    private Long p_idpersonal;
    private String p_obra;
    private Long p_idpervila;
    private String p_codigo;
    private String p_usuario;
    private String p_sexo;
    private String p_fecha_ingreso;
    private String p_num_ipss;
    private String p_num_cuspp;
    private String p_afp;
    private String p_ocupacion;

    private String p_contrato;
    private String p_basico;
    private String p_bonicargo;
    private String p_jornadas;


    public Long getP_idpersonal() {
        return p_idpersonal;
    }

    public void setP_idpersonal(Long p_idpersonal) {
        this.p_idpersonal = p_idpersonal;
    }

    public String getP_obra() {
        return p_obra;
    }

    public void setP_obra(String p_obra) {
        this.p_obra = p_obra;
    }

    public String getP_codigo() {
        return p_codigo;
    }

    public void setP_codigo(String p_codigo) {
        this.p_codigo = p_codigo;
    }

    public String getP_usuario() {
        return p_usuario;
    }

    public void setP_usuario(String p_usuario) {
        this.p_usuario = p_usuario;
    }

    public String getP_sexo() {
        return p_sexo;
    }

    public void setP_sexo(String p_sexo) {
        this.p_sexo = p_sexo;
    }

    public String getP_fecha_ingreso() {
        return p_fecha_ingreso;
    }

    public void setP_fecha_ingreso(String p_fecha_ingreso) {
        this.p_fecha_ingreso = p_fecha_ingreso;
    }

    public String getP_num_ipss() {
        return p_num_ipss;
    }

    public void setP_num_ipss(String p_num_ipss) {
        this.p_num_ipss = p_num_ipss;
    }

    public String getP_num_cuspp() {
        return p_num_cuspp;
    }

    public void setP_num_cuspp(String p_num_cuspp) {
        this.p_num_cuspp = p_num_cuspp;
    }

    public String getP_afp() {
        return p_afp;
    }

    public void setP_afp(String p_afp) {
        this.p_afp = p_afp;
    }

    public String getP_ocupacion() {
        return p_ocupacion;
    }

    public void setP_ocupacion(String p_ocupacion) {
        this.p_ocupacion = p_ocupacion;
    }

    public Long getP_idpervila() {
        return p_idpervila;
    }

    public void setP_idpervila(Long p_idpervila) {
        this.p_idpervila = p_idpervila;
    }

    public String getP_contrato() {
        return p_contrato;
    }

    public void setP_contrato(String p_contrato) {
        this.p_contrato = p_contrato;
    }

    public String getP_basico() {
        return p_basico;
    }

    public void setP_basico(String p_basico) {
        this.p_basico = p_basico;
    }

    public String getP_bonicargo() {
        return p_bonicargo;
    }

    public void setP_bonicargo(String p_bonicargo) {
        this.p_bonicargo = p_bonicargo;
    }

    public String getP_jornadas() {
        return p_jornadas;
    }

    public void setP_jornadas(String p_jornadas) {
        this.p_jornadas = p_jornadas;
    }
}
