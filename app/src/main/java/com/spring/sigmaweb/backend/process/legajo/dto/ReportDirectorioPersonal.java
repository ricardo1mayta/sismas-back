package com.spring.sigmaweb.backend.process.legajo.dto;

import javax.persistence.*;
import java.io.Serializable;

@SqlResultSetMapping(name = "ReportDirectorioPersonal", entities = @EntityResult(
    entityClass = ReportDirectorioPersonal.class, fields = {
        @FieldResult(name = "id_per", column = "id_per"),
        @FieldResult(name = "ape_Paterno", column = "ape_Paterno"),
        @FieldResult(name = "ape_Materno", column = "ape_Materno"),
        @FieldResult(name = "nombre_colaborador", column = "nombre_colaborador"),
        @FieldResult(name = "estado", column = "estado"),
        @FieldResult(name = "documento", column = "documento"),
        @FieldResult(name = "nro_documento", column = "nro_documento"),
        @FieldResult(name = "celular_personal", column = "celular_personal"),
        @FieldResult(name = "celular_institucional", column = "celular_institucional"),
        @FieldResult(name = "email_personal", column = "email_personal"),
        @FieldResult(name = "email_institucional", column = "email_institucional"),
        @FieldResult(name = "contacto_emerg", column = "contacto_emerg"),
        @FieldResult(name = "parentesco_contacto_emerg", column = "parentesco_contacto_emerg"),
        @FieldResult(name = "telefono_contacto_emerg", column = "telefono_contacto_emerg") }
    )
)

@Entity
public class ReportDirectorioPersonal implements Serializable {
    @Id
    private Long id_per;

    private String ape_Paterno;
    private String ape_Materno;
    private String nombre_colaborador;
    private String estado;
    private String documento;
    private String nro_documento;
    private String celular_personal;
    private String celular_institucional;
    private String telefono_fijo;
    private String email_personal;
    private String email_institucional;
    private String contacto_emerg;
    private String parentesco_contacto_emerg;
    private String telefono_contacto_emerg;
    private String direccion;

    public ReportDirectorioPersonal(){
        super();
    }


    public ReportDirectorioPersonal(String ape_Paterno, String ape_Materno, String nombre_colaborador, String estado, String documento, String nro_documento, String celular_personal, String celular_institucional, String telefono_fijo, String email_personal, String email_institucional, String contacto_emerg, String parentesco_contacto_emerg, String telefono_contacto_emerg, String direccion) {
        this.ape_Paterno = ape_Paterno;
        this.ape_Materno = ape_Materno;
        this.nombre_colaborador = nombre_colaborador;
        this.estado = estado;
        this.documento = documento;
        this.nro_documento = nro_documento;
        this.celular_personal = celular_personal;
        this.celular_institucional = celular_institucional;
        this.telefono_fijo = telefono_fijo;
        this.email_personal = email_personal;
        this.email_institucional = email_institucional;
        this.contacto_emerg = contacto_emerg;
        this.parentesco_contacto_emerg = parentesco_contacto_emerg;
        this.telefono_contacto_emerg = telefono_contacto_emerg;
        this.direccion = direccion;
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

    public String getNombre_colaborador() {
        return nombre_colaborador;
    }

    public void setNombre_colaborador(String nombre_colaborador) {
        this.nombre_colaborador = nombre_colaborador;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNro_documento() {
        return nro_documento;
    }

    public void setNro_documento(String nro_documento) {
        this.nro_documento = nro_documento;
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

    public String getContacto_emerg() {
        return contacto_emerg;
    }

    public void setContacto_emerg(String contacto_emerg) {
        this.contacto_emerg = contacto_emerg;
    }

    public String getParentesco_contacto_emerg() {
        return parentesco_contacto_emerg;
    }

    public void setParentesco_contacto_emerg(String parentesco_contacto_emerg) {
        this.parentesco_contacto_emerg = parentesco_contacto_emerg;
    }

    public String getTelefono_contacto_emerg() {
        return telefono_contacto_emerg;
    }

    public void setTelefono_contacto_emerg(String telefono_contacto_emerg) {
        this.telefono_contacto_emerg = telefono_contacto_emerg;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
