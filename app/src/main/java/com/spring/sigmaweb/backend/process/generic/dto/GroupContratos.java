package com.spring.sigmaweb.backend.process.generic.dto;

import com.spring.sigmaweb.backend.process.generic.model.TablasTabla;

import java.io.Serializable;
import java.util.List;

public class GroupContratos implements Serializable {
    private Integer codigoTab;
    private String descripTab;
    private List<TablasTabla> hijos;

    public GroupContratos(Integer codigoTab, String descripTab, List<TablasTabla> hijos) {
        this.codigoTab = codigoTab;
        this.descripTab = descripTab;
        this.hijos = hijos;
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

    public List<TablasTabla> getHijos() {
        return hijos;
    }

    public void setHijos(List<TablasTabla> hijos) {
        this.hijos = hijos;
    }

    private static final long serialVersionUID = 1L;
}
