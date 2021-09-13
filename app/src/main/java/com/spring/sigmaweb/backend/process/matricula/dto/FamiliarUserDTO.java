package com.spring.sigmaweb.backend.process.matricula.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FamiliarUserDTO implements Serializable {
        private Long idFami;
        private String descFami;
        private String codigoFami;
        private String nombre;
        private String apPaterno;
        private String apMaterno;
        private Integer idTipoDoc; // codigoTab;
        private String descDocu; // descripTab
        private String nroDoc;

        @JsonFormat(pattern = "yyyy-MM-dd")
        private Date fechaNac;

        private String direc;
        private Long idDist;// idDist
        private String nombreDist; // nombreDist
        private String telefono;
        private String email;

        public FamiliarUserDTO(Long idFami, String descFami, String codigoFami, String nombre, String apPaterno,
                               String apMaterno, Integer idTipoDoc, String descDocu, String nroDoc, Date fechaNac, String direc,
                               Long idDist, String nombreDist, String telefono, String email) {
            super();
            this.idFami = idFami;
            this.descFami = descFami;
            this.codigoFami = codigoFami;
            this.nombre = nombre;
            this.apPaterno = apPaterno;
            this.apMaterno = apMaterno;
            this.idTipoDoc = idTipoDoc;
            this.descDocu = descDocu;
            this.nroDoc = nroDoc;
            this.fechaNac = fechaNac;
            this.direc = direc;
            this.idDist = idDist;
            this.nombreDist = nombreDist;
            this.telefono = telefono;
            this.email = email;
        }

        public Long getIdFami() {
            return idFami;
        }

        public void setIdFami(Long idFami) {
            this.idFami = idFami;
        }

        public String getDescFami() {
            return descFami;
        }

        public void setDescFami(String descFami) {
            this.descFami = descFami;
        }

        public String getCodigoFami() {
            return codigoFami;
        }

        public void setCodigoFami(String codigoFami) {
            this.codigoFami = codigoFami;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApPaterno() {
            return apPaterno;
        }

        public void setApPaterno(String apPaterno) {
            this.apPaterno = apPaterno;
        }

        public String getApMaterno() {
            return apMaterno;
        }

        public void setApMaterno(String apMaterno) {
            this.apMaterno = apMaterno;
        }

        public Integer getIdTipoDoc() {
            return idTipoDoc;
        }

        public void setIdTipoDoc(Integer idTipoDoc) {
            this.idTipoDoc = idTipoDoc;
        }

        public String getDescDocu() {
            return descDocu;
        }

        public void setDescDocu(String descDocu) {
            this.descDocu = descDocu;
        }

        public String getNroDoc() {
            return nroDoc;
        }

        public void setNroDoc(String nroDoc) {
            this.nroDoc = nroDoc;
        }

        public Date getFechaNac() {
            return fechaNac;
        }

        public void setFechaNac(Date fechaNac) {
            this.fechaNac = fechaNac;
        }

        public String getDirec() {
            return direc;
        }

        public void setDirec(String direc) {
            this.direc = direc;
        }

        public Long getIdDist() {
            return idDist;
        }

        public void setIdDist(Long idDist) {
            this.idDist = idDist;
        }

        public String getNombreDist() {
            return nombreDist;
        }

        public void setNombreDist(String nombreDist) {
            this.nombreDist = nombreDist;
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        private static final long serialVersionUID = 1L;
}
