package com.spring.sigmaweb.backend.process.legajo.reports;

import javax.persistence.*;
import java.io.Serializable;

@SqlResultSetMapping(name="ReportEntidadesEPSPersonal", entities = @EntityResult(
        entityClass = ReportEntidadesEPSPersonal.class, fields = {
        @FieldResult(name = "id", column = "id"),
        @FieldResult(name = "ape_Paterno", column = "ape_Paterno"),
        @FieldResult(name = "ape_Materno", column = "ape_Materno"),
        @FieldResult(name = "nombres", column = "nombres"),
        @FieldResult(name = "obra", column = "obra"),
        @FieldResult(name = "codigo_interno", column = "codigo_interno"),
        @FieldResult(name = "tipo_documento", column = "tipo_documento"),
        @FieldResult(name = "nro_documento", column = "nro_documento"),
        @FieldResult(name = "codigoEssalud", column = "codigoEssalud"),
        @FieldResult(name = "entidad_salud_privada", column = "entidad_salud_privada")}
    )
)

@Entity
public class ReportEntidadesEPSPersonal implements Serializable {
    @Id
    private Long id;

    private String ape_Paterno;
    private String ape_Materno;
    private String nombres;
    private String obra;
    private String codigo_interno;
    private String tipo_documento;
    private String nro_documento;
    private String codigoEssalud;
    private String entidad_salud_privada;

    public ReportEntidadesEPSPersonal(){
        super();
    }

    public ReportEntidadesEPSPersonal(Long id, String ape_Paterno, String ape_Materno, String nombres, String obra, String codigo_interno, String tipo_documento, String nro_documento, String codigoEssalud, String entidad_salud_privada) {
        this.id = id;
        this.ape_Paterno = ape_Paterno;
        this.ape_Materno = ape_Materno;
        this.nombres = nombres;
        this.obra = obra;
        this.codigo_interno = codigo_interno;
        this.tipo_documento = tipo_documento;
        this.nro_documento = nro_documento;
        this.codigoEssalud = codigoEssalud;
        this.entidad_salud_privada = entidad_salud_privada;
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

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNro_documento() {
        return nro_documento;
    }

    public void setNro_documento(String nro_documento) {
        this.nro_documento = nro_documento;
    }

    public String getCodigoEssalud() {
        return codigoEssalud;
    }

    public void setCodigoEssalud(String codigoEssalud) {
        this.codigoEssalud = codigoEssalud;
    }

    public String getEntidad_salud_privada() {
        return entidad_salud_privada;
    }

    public void setEntidad_salud_privada(String entidad_salud_privada) {
        this.entidad_salud_privada = entidad_salud_privada;
    }
}
