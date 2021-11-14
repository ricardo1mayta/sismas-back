package com.spring.sigmaweb.backend.process.legajo.reports;

import javax.persistence.*;
import java.io.Serializable;

@SqlResultSetMapping(name="ReportCumpleaniosPersonal", entities = @EntityResult(
        entityClass = ReportCumpleaniosPersonal.class, fields = {
            @FieldResult(name = "id_per", column = "id_per"),
            @FieldResult(name = "ape_Paterno", column = "ape_Paterno"),
            @FieldResult(name = "ape_Materno", column = "ape_Materno"),
            @FieldResult(name = "nombres", column = "nombres"),
            @FieldResult(name = "obra", column = "obra"),
            @FieldResult(name = "fecha_nac", column = "fecha_nac"),
            @FieldResult(name = "anio_nac", column = "anio_nac"),
            @FieldResult(name = "mes_nac", column = "mes_nac"),
            @FieldResult(name = "dia_nac", column = "dia_nac"),
            @FieldResult(name = "edad", column = "edad") }
        )
)

@Entity
public class ReportCumpleaniosPersonal implements Serializable {
    @Id
    private Long id_per;
    private String ape_Paterno;
    private String ape_Materno;
    private String nombres;
    private String obra;
    private String fecha_nac;
    private String anio_nac;
    private String mes_nac;
    private String dia_nac;
    private Integer edad;

    public ReportCumpleaniosPersonal(){
        super();
    }

    public ReportCumpleaniosPersonal(Long id_per, String ape_Paterno, String ape_Materno, String nombres, String obra, String fecha_nac, String anio_nac, String mes_nac, String dia_nac, Integer edad) {
        this.id_per = id_per;
        this.ape_Paterno = ape_Paterno;
        this.ape_Materno = ape_Materno;
        this.nombres = nombres;
        this.obra = obra;
        this.fecha_nac = fecha_nac;
        this.anio_nac = anio_nac;
        this.mes_nac = mes_nac;
        this.dia_nac = dia_nac;
        this.edad = edad;
    }

    public Long getId_per() {
        return id_per;
    }

    public void setId_per(Long id_per) {
        this.id_per = id_per;
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

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getAnio_nac() {
        return anio_nac;
    }

    public void setAnio_nac(String anio_nac) {
        this.anio_nac = anio_nac;
    }

    public String getMes_nac() {
        return mes_nac;
    }

    public void setMes_nac(String mes_nac) {
        this.mes_nac = mes_nac;
    }

    public String getDia_nac() {
        return dia_nac;
    }

    public void setDia_nac(String dia_nac) {
        this.dia_nac = dia_nac;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}
