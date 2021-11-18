package com.spring.sigmaweb.backend.process.legajo.reports;

import javax.persistence.*;
import java.io.Serializable;

@SqlResultSetMapping(name="ReportentidadesPensionPersonal", entities = @EntityResult(
        entityClass = ReportentidadesPensionPersonal.class, fields = {
        @FieldResult(name = "id", column = "id"),
        @FieldResult(name = "ape_Paterno", column = "ape_Paterno"),
        @FieldResult(name = "ape_Materno", column = "ape_Materno"),
        @FieldResult(name = "nombres", column = "nombres"),
        @FieldResult(name = "obra", column = "obra"),
        @FieldResult(name = "codigo_interno", column = "codigo_interno"),
        @FieldResult(name = "tipo_documento", column = "tipo_documento"),
        @FieldResult(name = "nro_documento", column = "nro_documento"),
        @FieldResult(name = "tipo_entidad_pension", column = "tipo_entidad_pension"),
        @FieldResult(name = "entidad_pension", column = "entidad_pension")}
    )
)

@Entity
public class ReportentidadesPensionPersonal implements Serializable {
    @Id
    private Long id;

    private String ape_Paterno;
    private String ape_Materno;
    private String nombres;
    private String obra;
    private String codigo_interno;
    private String tipo_documento;
    private String nro_documento;
    private String tipo_entidad_pension;
    private String entidad_pension;

    public ReportentidadesPensionPersonal(){
        super();
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

    public String getTipo_entidad_pension() {
        return tipo_entidad_pension;
    }

    public void setTipo_entidad_pension(String tipo_entidad_pension) {
        this.tipo_entidad_pension = tipo_entidad_pension;
    }

    public String getEntidad_pension() {
        return entidad_pension;
    }

    public void setEntidad_pension(String entidad_pension) {
        this.entidad_pension = entidad_pension;
    }
}
