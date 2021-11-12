package com.spring.sigmaweb.backend.process.legajo.reports;

import javax.persistence.*;
import java.io.Serializable;

@SqlResultSetMapping(name="ReportCumpleaniosPersonal", entities = @EntityResult(
        entityClass = ReportCumpleaniosPersonal.class, fields = {
            @FieldResult(name = "ape_Paterno", column = "ape_Paterno"),
            @FieldResult(name = "ape_Materno", column = "ape_Materno"),
            @FieldResult(name = "nombres", column = "nombres"),
            @FieldResult(name = "obra", column = "obra"),
            @FieldResult(name = "celular_personal", column = "celular_personal"),
            @FieldResult(name = "celular_institucional", column = "celular_institucional"),
            @FieldResult(name = "telefono_fijo", column = "telefono_fijo"),
            @FieldResult(name = "email_personal", column = "email_personal"),
            @FieldResult(name = "email_institucional", column = "email_institucional"),
            @FieldResult(name = "fecha_nac", column = "fecha_nac"),
            @FieldResult(name = "edad", column = "edad") }
        )
)

@Entity
public class ReportCumpleaniosPersonal implements Serializable {
    @Id
    private String ape_Paterno;
    private String ape_Materno;
    private String nombres;
    private String obra;
    private String celular_personal;
    private String celular_institucional;
    private String telefono_fijo;
    private String email_personal;
    private String email_institucional;
    private String fecha_nac;
    private Integer edad;

    public ReportCumpleaniosPersonal(){
        super();
    }

    public ReportCumpleaniosPersonal(String ape_Paterno, String ape_Materno, String nombres, String obra, String celular_personal, String celular_institucional, String telefono_fijo, String email_personal, String email_institucional, String fecha_nac, Integer edad) {
        this.ape_Paterno = ape_Paterno;
        this.ape_Materno = ape_Materno;
        this.nombres = nombres;
        this.obra = obra;
        this.celular_personal = celular_personal;
        this.celular_institucional = celular_institucional;
        this.telefono_fijo = telefono_fijo;
        this.email_personal = email_personal;
        this.email_institucional = email_institucional;
        this.fecha_nac = fecha_nac;
        this.edad = edad;
    }

    public String getApe_Paterno() {
        return ape_Paterno;
    }

    public void setApe_Paterno(String ape_Paterno) {
        this.ape_Paterno = ape_Paterno;
    }

    public String getApe_Materno() {
        return ape_Materno;
    }

    public void setApe_Materno(String ape_Materno) {
        this.ape_Materno = ape_Materno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getObra() {
        return obra;
    }

    public void setObra(String obra) {
        this.obra = obra;
    }

    public String getCelular_personal() {
        return celular_personal;
    }

    public void setCelular_personal(String celular_personal) {
        this.celular_personal = celular_personal;
    }

    public String getCelular_institucional() {
        return celular_institucional;
    }

    public void setCelular_institucional(String celular_institucional) {
        this.celular_institucional = celular_institucional;
    }

    public String getTelefono_fijo() {
        return telefono_fijo;
    }

    public void setTelefono_fijo(String telefono_fijo) {
        this.telefono_fijo = telefono_fijo;
    }

    public String getEmail_personal() {
        return email_personal;
    }

    public void setEmail_personal(String email_personal) {
        this.email_personal = email_personal;
    }

    public String getEmail_institucional() {
        return email_institucional;
    }

    public void setEmail_institucional(String email_institucional) {
        this.email_institucional = email_institucional;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}
