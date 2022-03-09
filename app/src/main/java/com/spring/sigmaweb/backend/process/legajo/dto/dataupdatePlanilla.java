package com.spring.sigmaweb.backend.process.legajo.dto;

import java.io.Serializable;

public class dataupdatePlanilla implements Serializable {
    private Long p_idpersonal;
    private String p_obra;
    private String p_codigo;
    private String p_usuario;
    private String p_sexo;
    private String p_fecha_ingreso;
    private String p_num_ipss;
    private String p_num_cuspp;
    private String p_afp;

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
}
