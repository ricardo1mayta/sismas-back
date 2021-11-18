package com.spring.sigmaweb.backend.process.legajo.reports;

import javax.persistence.*;
import java.io.Serializable;

@SqlResultSetMapping(name="ReporteListaHijosPersonal", entities = @EntityResult(
        entityClass = ReporteListaHijosPersonal.class, fields = {
        @FieldResult(name = "id", column = "id"),
        @FieldResult(name = "ape_Paterno", column = "ape_Paterno"),
        @FieldResult(name = "ape_Materno", column = "ape_Materno"),
        @FieldResult(name = "nombres", column = "nombres"),
        @FieldResult(name = "obra", column = "obra"),
        @FieldResult(name = "codigo_interno", column = "codigo_interno"),
        @FieldResult(name = "ape_Paterno_familiar", column = "ape_Paterno_familiar"),
        @FieldResult(name = "ape_Materno_familiar", column = "ape_Materno_familiar"),
        @FieldResult(name = "nombre_familiar", column = "nombre_familiar"),
        @FieldResult(name = "sexo_familiar", column = "sexo_familiar"),
        @FieldResult(name = "documento_Familiar", column = "documento_Familiar"),
        @FieldResult(name = "nro_doc_Familiar", column = "nro_doc_Familiar"),
        @FieldResult(name = "fecha_nacimiento_familiar", column = "fecha_nacimiento_familiar"),
        @FieldResult(name = "edad_familiar", column = "edad_familiar"),
        @FieldResult(name = "grado_Academico_familiar", column = "grado_Academico_familiar"),
        @FieldResult(name = "estudia_actualmente", column = "estudia_actualmente"),
        @FieldResult(name = "lugar_estudio", column = "lugar_estudio")}
)
)

@Entity
public class ReporteListaHijosPersonal implements Serializable {
    @Id
    private Long id;

    private String ape_Paterno;
    private String ape_Materno;
    private String nombres;
    private String obra;
    private String codigo_interno;
    private String ape_Paterno_familiar;
    private String ape_Materno_familiar;
    private String nombre_familiar;
    private String sexo_familiar;
    private String documento_Familiar;
    private String nro_doc_Familiar;
    private String fecha_nacimiento_familiar;
    private String edad_familiar;
    private String grado_Academico_familiar;
    private String estudia_actualmente;
    private String lugar_estudio;

    public ReporteListaHijosPersonal(){
        super();
    }

    public ReporteListaHijosPersonal(Long id, String ape_Paterno, String ape_Materno, String nombres, String obra, String codigo_interno, String ape_Paterno_familiar, String ape_Materno_familiar, String nombre_familiar, String sexo_familiar, String documento_Familiar, String nro_doc_Familiar, String fecha_nacimiento_familiar, String edad_familiar, String grado_Academico_familiar, String estudia_actualmente, String lugar_estudio) {
        this.id = id;
        this.ape_Paterno = ape_Paterno;
        this.ape_Materno = ape_Materno;
        this.nombres = nombres;
        this.obra = obra;
        this.codigo_interno = codigo_interno;
        this.ape_Paterno_familiar = ape_Paterno_familiar;
        this.ape_Materno_familiar = ape_Materno_familiar;
        this.nombre_familiar = nombre_familiar;
        this.sexo_familiar = sexo_familiar;
        this.documento_Familiar = documento_Familiar;
        this.nro_doc_Familiar = nro_doc_Familiar;
        this.fecha_nacimiento_familiar = fecha_nacimiento_familiar;
        this.edad_familiar = edad_familiar;
        this.grado_Academico_familiar = grado_Academico_familiar;
        this.estudia_actualmente = estudia_actualmente;
        this.lugar_estudio = lugar_estudio;
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

    public String getApe_Paterno_familiar() {
        return ape_Paterno_familiar;
    }

    public void setApe_Paterno_familiar(String ape_Paterno_familiar) {
        this.ape_Paterno_familiar = ape_Paterno_familiar;
    }

    public String getApe_Materno_familiar() {
        return ape_Materno_familiar;
    }

    public void setApe_Materno_familiar(String ape_Materno_familiar) {
        this.ape_Materno_familiar = ape_Materno_familiar;
    }

    public String getNombre_familiar() {
        return nombre_familiar;
    }

    public void setNombre_familiar(String nombre_familiar) {
        this.nombre_familiar = nombre_familiar;
    }

    public String getSexo_familiar() {
        return sexo_familiar;
    }

    public void setSexo_familiar(String sexo_familiar) {
        this.sexo_familiar = sexo_familiar;
    }

    public String getDocumento_Familiar() {
        return documento_Familiar;
    }

    public void setDocumento_Familiar(String documento_Familiar) {
        this.documento_Familiar = documento_Familiar;
    }

    public String getNro_doc_Familiar() {
        return nro_doc_Familiar;
    }

    public void setNro_doc_Familiar(String nro_doc_Familiar) {
        this.nro_doc_Familiar = nro_doc_Familiar;
    }

    public String getFecha_nacimiento_familiar() {
        return fecha_nacimiento_familiar;
    }

    public void setFecha_nacimiento_familiar(String fecha_nacimiento_familiar) {
        this.fecha_nacimiento_familiar = fecha_nacimiento_familiar;
    }

    public String getEdad_familiar() {
        return edad_familiar;
    }

    public void setEdad_familiar(String edad_familiar) {
        this.edad_familiar = edad_familiar;
    }

    public String getGrado_Academico_familiar() {
        return grado_Academico_familiar;
    }

    public void setGrado_Academico_familiar(String grado_Academico_familiar) {
        this.grado_Academico_familiar = grado_Academico_familiar;
    }

    public String getEstudia_actualmente() {
        return estudia_actualmente;
    }

    public void setEstudia_actualmente(String estudia_actualmente) {
        this.estudia_actualmente = estudia_actualmente;
    }

    public String getLugar_estudio() {
        return lugar_estudio;
    }

    public void setLugar_estudio(String lugar_estudio) {
        this.lugar_estudio = lugar_estudio;
    }
}
