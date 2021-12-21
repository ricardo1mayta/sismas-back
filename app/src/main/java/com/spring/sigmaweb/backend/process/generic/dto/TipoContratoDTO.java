package com.spring.sigmaweb.backend.process.generic.dto;

import com.spring.sigmaweb.backend.process.generic.model.TablasTabla;

import java.io.Serializable;
import java.util.ArrayList;

public class TipoContratoDTO implements Serializable {
    private Integer codigoTab;
    private String descripTab;

    private TablasTabla tipos;

    public TipoContratoDTO(Integer codigoTab, String descripTab, TablasTabla tipos) {
        this.codigoTab = codigoTab;
        this.descripTab = descripTab;
        this.tipos = tipos;
    }

    public Integer getCodigoTab() {
        return codigoTab;
    }

    public void setCodigoTab(Integer codigoTab) {
        this.codigoTab = codigoTab;
    }

    public String getDescripTab() {
        return descripTab;
    }

    public void setDescripTab(String descripTab) {
        this.descripTab = descripTab;
    }

    public TablasTabla getTipos() {
        return tipos;
    }

    public void setTipos(TablasTabla tipos) {
        this.tipos = tipos;
    }

    private static final long serialVersionUID = 1L;
}
