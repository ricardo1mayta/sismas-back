package com.spring.sigmaweb.backend.process.core.service;

import com.spring.sigmaweb.backend.process.core.dto.RolSideNavItemActivosDTO;
import com.spring.sigmaweb.backend.process.core.dto.RolSideNavItemMenuOrderDTO;
import com.spring.sigmaweb.backend.process.core.dto.SidenavItemDTO;
import com.spring.sigmaweb.backend.process.core.model.RolSideNavItem;
import com.spring.sigmaweb.backend.process.core.model.SideNavItem;

import java.util.List;

public interface IRolSideNavItemService {
    public List<RolSideNavItemMenuOrderDTO> findByMenuPorRolAndObra(String idroles, String idobra);

    public List<SidenavItemDTO> listesquemaMenu (String idroles, String idobra);

    public List<SidenavItemDTO> listesquemaMenuAll();

    public List<SidenavItemDTO> ordenarMenuPadreHijos( List<RolSideNavItemMenuOrderDTO> lista);

    public List<RolSideNavItemMenuOrderDTO> findByMenuGeneral();

    public List<RolSideNavItemActivosDTO> findByMenuPorRolAndObraActivos(String idrol, String idobra);

    public List<RolSideNavItem> findByIdRolAndIdObra(Long idrol, String idobra);

    public void deleteAll(List<RolSideNavItem> rolSide);

    public RolSideNavItem save(RolSideNavItem rolside);

    public SideNavItem findBysideNavItem(Long idItem, String idobra);
}
