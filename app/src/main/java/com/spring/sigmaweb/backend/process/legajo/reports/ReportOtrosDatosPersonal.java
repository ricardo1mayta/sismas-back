package com.spring.sigmaweb.backend.process.legajo.reports;

import javax.persistence.*;
import java.io.Serializable;

@SqlResultSetMapping(name="ReportOtrosDatosPersonal", entities = @EntityResult(
        entityClass = ReportOtrosDatosPersonal.class, fields = {
        @FieldResult(name = "Id", column = "Id"),
        @FieldResult(name = "ape_Paterno", column = "ape_Paterno"),
        @FieldResult(name = "ape_Materno", column = "ape_Materno"),
        @FieldResult(name = "nombres", column = "nombres"),
        @FieldResult(name = "obra", column = "obra"),
        @FieldResult(name = "codigo_interno", column = "codigo_interno"),
        @FieldResult(name = "religion_profesa", column = "religion_profesa"),
        @FieldResult(name = "es_discapacitado", column = "es_discapacitado"),
        @FieldResult(name = "discapacidad", column = "discapacidad") }
)
)

@Entity
public class ReportOtrosDatosPersonal implements Serializable {
    @Id
    private Long Id;

    private String ape_Paterno;
    private String ape_Materno;
    private String nombres ;
    private String obra;
    private String codigo_interno;
    private String religion_profesa;
    private String es_discapacitado;
    private String discapacidad;

    public ReportOtrosDatosPersonal(){
        super();
    }

    public ReportOtrosDatosPersonal(Long id, String ape_Paterno, String ape_Materno, String nombres, String obra, String codigo_interno, String religion_profesa, String es_discapacitado, String discapacidad) {
        Id = id;
        this.ape_Paterno = ape_Paterno;
        this.ape_Materno = ape_Materno;
        this.nombres = nombres;
        this.obra = obra;
        this.codigo_interno = codigo_interno;
        this.religion_profesa = religion_profesa;
        this.es_discapacitado = es_discapacitado;
        this.discapacidad = discapacidad;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public String getReligion_profesa() {
        return religion_profesa;
    }

    public void setReligion_profesa(String religion_profesa) {
        this.religion_profesa = religion_profesa;
    }

    public String getEs_discapacitado() {
        return es_discapacitado;
    }

    public void setEs_discapacitado(String es_discapacitado) {
        this.es_discapacitado = es_discapacitado;
    }

    public String getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(String discapacidad) {
        this.discapacidad = discapacidad;
    }
}
