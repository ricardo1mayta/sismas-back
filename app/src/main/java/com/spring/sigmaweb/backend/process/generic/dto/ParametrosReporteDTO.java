package com.spring.sigmaweb.backend.process.generic.dto;

import java.io.Serializable;

public class ParametrosReporteDTO implements Serializable {
    private Long idRepo;
    private Long idPara;
    private Long idParaRepo;
    private String descripcionPara;
    private String tipoPara;
    private Integer ordenParaRepo;
    private String descAlterParaRepo;
    private Integer valorMinParaRepo;
    private String valorDefaultParaRepo;
    private String tablaSelectParaRepo;
    private Boolean estadoParaRepo;
    private Boolean estadoPara;
    private Boolean estadoRepo;

    public ParametrosReporteDTO(Long idRepo, Long idPara, Long idParaRepo, String descripcionPara, String tipoPara, Integer ordenParaRepo, String descAlterParaRepo, Integer valorMinParaRepo, String valorDefaultParaRepo, String tablaSelectParaRepo, Boolean estadoParaRepo, Boolean estadoPara, Boolean estadoRepo) {
        this.idRepo = idRepo;
        this.idPara = idPara;
        this.idParaRepo = idParaRepo;
        this.descripcionPara = descripcionPara;
        this.tipoPara = tipoPara;
        this.ordenParaRepo = ordenParaRepo;
        this.descAlterParaRepo = descAlterParaRepo;
        this.valorMinParaRepo = valorMinParaRepo;
        this.valorDefaultParaRepo = valorDefaultParaRepo;
        this.tablaSelectParaRepo = tablaSelectParaRepo;
        this.estadoParaRepo = estadoParaRepo;
        this.estadoPara = estadoPara;
        this.estadoRepo = estadoRepo;
    }

    public Long getIdRepo() {
        return idRepo;
    }

    public void setIdRepo(Long idRepo) {
        this.idRepo = idRepo;
    }

    public Long getIdPara() {
        return idPara;
    }

    public void setIdPara(Long idPara) {
        this.idPara = idPara;
    }

    public Long getIdParaRepo() {
        return idParaRepo;
    }

    public void setIdParaRepo(Long idParaRepo) {
        this.idParaRepo = idParaRepo;
    }

    public String getDescripcionPara() {
        return descripcionPara;
    }

    public void setDescripcionPara(String descripcionPara) {
        this.descripcionPara = descripcionPara;
    }

    public String getTipoPara() {
        return tipoPara;
    }

    public void setTipoPara(String tipoPara) {
        this.tipoPara = tipoPara;
    }

    public Integer getOrdenParaRepo() {
        return ordenParaRepo;
    }

    public void setOrdenParaRepo(Integer ordenParaRepo) {
        this.ordenParaRepo = ordenParaRepo;
    }

    public String getDescAlterParaRepo() {
        return descAlterParaRepo;
    }

    public void setDescAlterParaRepo(String descAlterParaRepo) {
        this.descAlterParaRepo = descAlterParaRepo;
    }

    public Integer getValorMinParaRepo() {
        return valorMinParaRepo;
    }

    public void setValorMinParaRepo(Integer valorMinParaRepo) {
        this.valorMinParaRepo = valorMinParaRepo;
    }

    public String getValorDefaultParaRepo() {
        return valorDefaultParaRepo;
    }

    public void setValorDefaultParaRepo(String valorDefaultParaRepo) {
        this.valorDefaultParaRepo = valorDefaultParaRepo;
    }

    public String getTablaSelectParaRepo() {
        return tablaSelectParaRepo;
    }

    public void setTablaSelectParaRepo(String tablaSelectParaRepo) {
        this.tablaSelectParaRepo = tablaSelectParaRepo;
    }

    public Boolean getEstadoParaRepo() {
        return estadoParaRepo;
    }

    public void setEstadoParaRepo(Boolean estadoParaRepo) {
        this.estadoParaRepo = estadoParaRepo;
    }

    public Boolean getEstadoPara() {
        return estadoPara;
    }

    public void setEstadoPara(Boolean estadoPara) {
        this.estadoPara = estadoPara;
    }

    public Boolean getEstadoRepo() {
        return estadoRepo;
    }

    public void setEstadoRepo(Boolean estadoRepo) {
        this.estadoRepo = estadoRepo;
    }

    private static final long serialVersionUID = 1L;
}
