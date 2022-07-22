package com.spring.sigmaweb.backend.process.surveys.model.report;

import javax.persistence.*;
import java.io.Serializable;

@SqlResultSetMapping(name="ListaEvaluadosEvaluador", entities = @EntityResult(
        entityClass = ListaEvaluadosEvaluador.class, fields = {
        @FieldResult(name = "id", column = "id"),
        @FieldResult(name = "id_personal", column = "id_personal"),
        @FieldResult(name = "id_encuesta", column = "id_encuesta"),
        @FieldResult(name = "id_matrizeval", column = "id_matrizeval"),
        @FieldResult(name = "ape_paterno_pers", column = "ape_paterno_pers"),
        @FieldResult(name = "ape_materno_pers", column = "ape_materno_pers"),
        @FieldResult(name = "nombre_pers", column = "nombre_pers"),
        @FieldResult(name = "nomCompleto", column = "nomCompleto"),
        @FieldResult(name = "codigo_per", column = "codigo_per"),
        @FieldResult(name = "cargo", column = "cargo"),
        @FieldResult(name = "id_cargopuesto_pereval", column = "id_cargopuesto_pereval"),
        @FieldResult(name = "flg_es_cargoprincipal_pereval", column = "flg_es_cargoprincipal_pereval"),
        @FieldResult(name = "flg_principal_eval_pereval", column = "flg_principal_eval_pereval"),
        @FieldResult(name = "id_grupo_ocupacional_pereval", column = "id_grupo_ocupacional_pereval"),
        @FieldResult(name = "id_evento_maev", column = "id_evento_maev"),
        @FieldResult(name = "estado", column = "estado")}
    )
)

@Entity
public class ListaEvaluadosEvaluador implements Serializable {
    @Id
    private Long id;

    private Long id_personal;
    private Long id_encuesta;
    private Long id_matrizeval;
    private String ape_paterno_pers;
    private String ape_materno_pers;
    private String nombre_pers;
    private String nomCompleto;
    private String codigo_per;
    private String cargo;
    private Long id_cargopuesto_pereval;
    private Boolean flg_es_cargoprincipal_pereval;
    private Boolean flg_principal_eval_pereval;
    private Integer id_grupo_ocupacional_pereval;
    private Long id_evento_maev;
    private String estado;

    public ListaEvaluadosEvaluador(){
        super();
    }

    public ListaEvaluadosEvaluador(Long id, Long id_personal, Long id_encuesta, Long id_matrizeval, String ape_paterno_pers, String ape_materno_pers, String nombre_pers, String nomCompleto, String codigo_per,String cargo, Long id_cargopuesto_pereval, Boolean flg_es_cargoprincipal_pereval, Boolean flg_principal_eval_pereval, Integer id_grupo_ocupacional_pereval, Long id_evento_maev, String estado) {
        this.id = id;
        this.id_personal = id_personal;
        this.id_encuesta = id_encuesta;
        this.id_matrizeval = id_matrizeval;
        this.ape_paterno_pers = ape_paterno_pers;
        this.ape_materno_pers = ape_materno_pers;
        this.nombre_pers = nombre_pers;
        this.nomCompleto = nomCompleto;
        this.codigo_per = codigo_per;
        this.cargo = cargo;
        this.id_cargopuesto_pereval = id_cargopuesto_pereval;
        this.flg_es_cargoprincipal_pereval = flg_es_cargoprincipal_pereval;
        this.flg_principal_eval_pereval = flg_principal_eval_pereval;
        this.id_grupo_ocupacional_pereval = id_grupo_ocupacional_pereval;
        this.id_evento_maev = id_evento_maev;
        this.estado = estado;
    }

    public Integer getId_grupo_ocupacional_pereval() {
        return id_grupo_ocupacional_pereval;
    }

    public void setId_grupo_ocupacional_pereval(Integer id_grupo_ocupacional_pereval) {
        this.id_grupo_ocupacional_pereval = id_grupo_ocupacional_pereval;
    }

    public Long getId_evento_maev() {
        return id_evento_maev;
    }

    public void setId_evento_maev(Long id_evento_maev) {
        this.id_evento_maev = id_evento_maev;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_personal() {
        return id_personal;
    }

    public void setId_personal(Long id_personal) {
        this.id_personal = id_personal;
    }

    public Long getId_encuesta() {
        return id_encuesta;
    }

    public void setId_encuesta(Long id_encuesta) {
        this.id_encuesta = id_encuesta;
    }

    public Long getId_matrizeval() {
        return id_matrizeval;
    }

    public void setId_matrizeval(Long id_matrizeval) {
        this.id_matrizeval = id_matrizeval;
    }

    public String getApe_paterno_pers() {
        return ape_paterno_pers;
    }

    public void setApe_paterno_pers(String ape_paterno_pers) {
        this.ape_paterno_pers = ape_paterno_pers;
    }

    public String getApe_materno_pers() {
        return ape_materno_pers;
    }

    public void setApe_materno_pers(String ape_materno_pers) {
        this.ape_materno_pers = ape_materno_pers;
    }

    public String getNombre_pers() {
        return nombre_pers;
    }

    public void setNombre_pers(String nombre_pers) {
        this.nombre_pers = nombre_pers;
    }

    public String getNomCompleto() {
        return nomCompleto;
    }

    public void setNomCompleto(String nomCompleto) {
        this.nomCompleto = nomCompleto;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Long getId_cargopuesto_pereval() {
        return id_cargopuesto_pereval;
    }

    public void setId_cargopuesto_pereval(Long id_cargopuesto_pereval) {
        this.id_cargopuesto_pereval = id_cargopuesto_pereval;
    }

    public Boolean getFlg_es_cargoprincipal_pereval() {
        return flg_es_cargoprincipal_pereval;
    }

    public void setFlg_es_cargoprincipal_pereval(Boolean flg_es_cargoprincipal_pereval) {
        this.flg_es_cargoprincipal_pereval = flg_es_cargoprincipal_pereval;
    }

    public Boolean getFlg_principal_eval_pereval() {
        return flg_principal_eval_pereval;
    }

    public void setFlg_principal_eval_pereval(Boolean flg_principal_eval_pereval) {
        this.flg_principal_eval_pereval = flg_principal_eval_pereval;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigo_per() {
        return codigo_per;
    }

    public void setCodigo_per(String codigo_per) {
        this.codigo_per = codigo_per;
    }
}
