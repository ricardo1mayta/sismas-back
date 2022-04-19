package com.spring.sigmaweb.backend.process.core.service;

import java.util.ArrayList;
import java.util.List;

import com.spring.sigmaweb.backend.process.core.dto.RolSideNavItemActivosDTO;
import com.spring.sigmaweb.backend.process.core.dto.RolSideNavItemMenuOrderDTO;
import com.spring.sigmaweb.backend.process.core.dto.SidenavItemDTO;
import com.spring.sigmaweb.backend.process.core.model.Rol;
import com.spring.sigmaweb.backend.process.core.model.RolSideNavItem;
import com.spring.sigmaweb.backend.process.core.model.SideNavItem;
import com.spring.sigmaweb.backend.process.core.repository.IRolSideNavItemDao;
import com.spring.sigmaweb.backend.process.core.repository.IRolesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RolSideNavItemService implements IRolSideNavItemService{
    @Autowired
    private IRolSideNavItemDao rolsidenavitemDao;

    @Autowired
    private IRolesDao rolesDao;

    @Override
    @Transactional(readOnly = true)
    public List<RolSideNavItemMenuOrderDTO> findByMenuPorRolAndObra(String idroles, String idobra) {
        String[] lista= idroles.split(",");
        List<Rol> rolesList = rolesDao.buscarPorNombreRolListAndObra(lista, idobra);
        Long[] listaInt=new Long[rolesList.size()];
        Integer ind = 0 ;
        for (Rol item : rolesList) {
            listaInt[ind] = item.getIdRol();
            ind += 1;

        }
        return rolsidenavitemDao.findByMenuPorRolAndObra(listaInt, idobra);
    }

    public List<SidenavItemDTO> ordenarMenuPadreHijos(List<RolSideNavItemMenuOrderDTO> lista, String idObra ){
        List<SidenavItemDTO> menuReturn = new ArrayList<SidenavItemDTO>();
        List<SidenavItemDTO> menuNivel1 = new ArrayList<SidenavItemDTO>();
        List<SidenavItemDTO> menuNivel2 = new ArrayList<SidenavItemDTO>();
        List<SidenavItemDTO> menuNivel3 = new ArrayList<SidenavItemDTO>();
        List<SidenavItemDTO> menuNivel4 = new ArrayList<SidenavItemDTO>();
        List<SidenavItemDTO> menuNivel5 = new ArrayList<SidenavItemDTO>();
        List<SidenavItemDTO> menutmp = new ArrayList<SidenavItemDTO>();
        SidenavItemDTO menuItem =new SidenavItemDTO();

        for (RolSideNavItemMenuOrderDTO row : lista) {
            //System.out.println(row.getName());
            if(row.getIdModulo().equals("STO") && !idObra.equals("SECTOR") ){
                continue;
            }
            menuItem = new SidenavItemDTO();
            menuItem.setName(row.getName());
            menuItem.setIcon(row.getIcon());
            menuItem.setRouteOrFunction(row.getRouteOrFunction());
            menuItem.setPosition(row.getPosition());
            menuItem.setPathMatchExact(row.getPathMatchExact());
            menuItem.setBadge(row.getBadge());
            menuItem.setBadgeColor(row.getBadgeColor());
            menuItem.setType(row.getType());
            menuItem.setCustomClass(row.getCustomClass());
            menuItem.setIdPadre(row.getIdPadreItem());
            menuItem.setIdItem(row.getIdItem());
            menuItem.setFlgLecturaRolItem(row.getFlgLecturaRolItem());
            menuItem.setFlgEscrituraRolItem(row.getFlgEscrituraRolItem());
            menuItem.setSubItems(null);

            if (row.getIdPadreItem() == null) {
                menuReturn.add(menuItem);
            } else if (row.getNivelMenu()==1) {
                menuNivel1.add(menuItem);
            } else if (row.getNivelMenu()==2) {
                menuNivel2.add(menuItem);
            } else if (row.getNivelMenu()==3) {
                menuNivel3.add(menuItem);
            } else if (row.getNivelMenu()==4) {
                menuNivel4.add(menuItem);
            } else if (row.getNivelMenu()==5) {
                menuNivel5.add(menuItem);
            }
        }

        for(SidenavItemDTO row4 : menuNivel4) {
            menutmp= new ArrayList<SidenavItemDTO>();
            for(SidenavItemDTO row5 : menuNivel5) {
                if(row5.getIdPadre() == row4.getIdItem()) {
                    menutmp.add(row5);
                }
            }
            row4.setSubItems(menutmp);
        }

        for(SidenavItemDTO row3 : menuNivel3) {
            menutmp= new ArrayList<SidenavItemDTO>();
            for(SidenavItemDTO row4 : menuNivel4) {
                if(row4.getIdPadre() == row3.getIdItem()) {
                    menutmp.add(row4);
                }
            }
            row3.setSubItems(menutmp);
        }

        for(SidenavItemDTO row2 : menuNivel2) {
            menutmp= new ArrayList<SidenavItemDTO>();
            for(SidenavItemDTO row3 : menuNivel3) {
                if(row3.getIdPadre() == row2.getIdItem()) {
                    menutmp.add(row3);
                }
            }
            row2.setSubItems(menutmp);
        }

        for(SidenavItemDTO row1 : menuNivel1) {
            menutmp= new ArrayList<SidenavItemDTO>();
            for(SidenavItemDTO row2 : menuNivel2) {
                if(row2.getIdPadre() == row1.getIdItem()) {
                    menutmp.add(row2);
                }
            }
            row1.setSubItems(menutmp);
        }

        for(SidenavItemDTO row0 : menuReturn) {
            menutmp= new ArrayList<SidenavItemDTO>();
            for(SidenavItemDTO row1 : menuNivel1) {
                if(row0.getIdItem() == row1.getIdPadre()) {
                    menutmp.add(row1);
                }
            }
            row0.setSubItems(menutmp);
        }
        return menuReturn;
    }

    @Override
    @Transactional(readOnly = true)
    public List<SidenavItemDTO> listesquemaMenu(String idroles, String idobra) {

        List<RolSideNavItemMenuOrderDTO> listmenu = this.findByMenuPorRolAndObra(idroles, idobra);
        return this.ordenarMenuPadreHijos(listmenu, idobra);

    }

    @Override
    @Transactional(readOnly = true)
    public List<SidenavItemDTO> listesquemaMenuAll() {

        List<RolSideNavItemMenuOrderDTO> listmenu = this.rolsidenavitemDao.findByMenuGeneral("");
        return this.ordenarMenuPadreHijos(listmenu,"");

    }

    @Override
    @Transactional(readOnly = true)
    public List<RolSideNavItemMenuOrderDTO> findByMenuGeneral(String idObra) {
        // TODO Auto-generated method stub
        return rolsidenavitemDao.findByMenuGeneral(idObra);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RolSideNavItemActivosDTO> findByMenuPorRolAndObraActivos(String idroles, String idobra) {
        String[] lista= idroles.split(",");
        List<Rol> rolesList = rolesDao.buscarPorNombreRolListAndObra(lista, idobra);
        Long[] listaInt=new Long[rolesList.size()];
        Integer ind = 0 ;
        for (Rol item : rolesList) {
            listaInt[ind] = item.getIdRol();
        }
        return rolsidenavitemDao.findByMenuPorRolAndObraActivos(listaInt, idobra);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RolSideNavItem> findByIdRolAndIdObra(Long idrol, String idobra) {
        return rolsidenavitemDao.findByIdRolAndIdObra(idrol, idobra);
    }

    @Override
    @Transactional
    public void deleteAll(List<RolSideNavItem> rolSide) {
        rolsidenavitemDao.deleteAll(rolSide);

    }

    @Override
    public RolSideNavItem save(RolSideNavItem rolside) {
        // TODO Auto-generated method stub
        return rolsidenavitemDao.save(rolside);
    }

    @Override
    @Transactional(readOnly = true)
    public SideNavItem findBysideNavItem(Long idItem, String idobra) {
        return rolsidenavitemDao.findBysideNavItem(idItem, idobra);
    }
}
