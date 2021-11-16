package com.spring.sigmaweb.backend.process.legajo.reports;

import javax.persistence.*;
import java.io.Serializable;

@SqlResultSetMapping(name="ReportProgresoActualizacionPersonal", entities = @EntityResult(
        entityClass = ReportProgresoActualizacionPersonal.class, fields = {
        @FieldResult(name = "id", column = "id"),
        @FieldResult(name = "ape_Paterno", column = "ape_Paterno"),
        @FieldResult(name = "ape_Materno", column = "ape_Materno"),
        @FieldResult(name = "nombres", column = "nombres"),
        @FieldResult(name = "obra", column = "obra"),
        @FieldResult(name = "codigo_interno", column = "codigo_interno"),
        @FieldResult(name = "fecha_autorizacion", column = "fecha_autorizacion"),
        @FieldResult(name = "ult_fecha_actualizacion", column = "ult_fecha_actualizacion"),
        @FieldResult(name = "cuenta", column = "cuenta") }
    )
)

@Entity
public class ReportProgresoActualizacionPersonal implements Serializable {
    @Id
    private Long id;

    private String ape_Paterno;
    private String ape_Materno;
    private String nombres;
    private String obra;
    private String codigo_interno;
    private String fecha_autorizacion;
    private String ult_fecha_actualizacion;
    private Double cuenta;

    public ReportProgresoActualizacionPersonal(){
        super();
    }

    public ReportProgresoActualizacionPersonal(Long id, String ape_Paterno, String ape_Materno, String nombres, String obra, String codigo_interno, String fecha_autorizacion, String ult_fecha_actualizacion, Double cuenta) {
        this.id = id;
        this.ape_Paterno = ape_Paterno;
        this.ape_Materno = ape_Materno;
        this.nombres = nombres;
        this.obra = obra;
        this.codigo_interno = codigo_interno;
        this.fecha_autorizacion = fecha_autorizacion;
        this.ult_fecha_actualizacion = ult_fecha_actualizacion;
        this.cuenta = cuenta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCodigo_interno() {
        return codigo_interno;
    }

    public void setCodigo_interno(String codigo_interno) {
        this.codigo_interno = codigo_interno;
    }

    public String getFecha_autorizacion() {
        return fecha_autorizacion;
    }

    public void setFecha_autorizacion(String fecha_autorizacion) {
        this.fecha_autorizacion = fecha_autorizacion;
    }

    public String getUlt_fecha_actualizacion() {
        return ult_fecha_actualizacion;
    }

    public void setUlt_fecha_actualizacion(String ult_fecha_actualizacion) {
        this.ult_fecha_actualizacion = ult_fecha_actualizacion;
    }

    public Double getCuenta() {
        return cuenta;
    }

    public void setCuenta(Double cuenta) {
        this.cuenta = cuenta;
    }
}
