package com.spring.sigmaweb.backend.process.generic.service;

import com.spring.sigmaweb.backend.process.core.dto.SidenavItemDTO;
import com.spring.sigmaweb.backend.process.generic.dto.GroupContratos;
import com.spring.sigmaweb.backend.process.generic.dto.TipoContratoDTO;
import com.spring.sigmaweb.backend.process.generic.model.TablasTabla;
import com.spring.sigmaweb.backend.process.generic.repository.ITablasTablaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TablasTablaService implements ITablasTablaService{
    @Autowired
    private ITablasTablaDao tablastablaDao;

    @Override
    @Transactional(readOnly = true)
    public List<TablasTabla> findByTipoTab(Integer tipotab) {
        return tablastablaDao.findByTipoTabOrderByDescripTabAsc(tipotab);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TablasTabla> findByCodigoList(Integer tipotab, String listCodigos) {
        // TODO Auto-generated method stub
        String[] lista= listCodigos.split(",");
        Integer[] listaInt=new Integer[lista.length];
        for(int i = 0;i < lista.length;i++)
        {
            listaInt[i] = Integer.parseInt(lista[i]);
        }

        return tablastablaDao.findByCodigoList(tipotab, listaInt);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TablasTabla> findByCodigoListNot(Integer tipotab, String listCodigos) {
        // TODO Auto-generated method stub
        String[] lista= listCodigos.split(",");
        Integer[] listaInt=new Integer[lista.length];
        for(int i = 0;i < lista.length;i++)
        {
            listaInt[i] = Integer.parseInt(lista[i]);
        }
        return tablastablaDao.findByCodigoListNot(tipotab, listaInt);
    }

    @Override
    public List<GroupContratos> getTipoContrato(Integer tipotab) {

        List<TipoContratoDTO> resultB = tablastablaDao.getTipoContrato(tipotab);
        List<GroupContratos> result = new ArrayList<GroupContratos>();
        GroupContratos item = null;
        Integer old=0;

        List<TablasTabla> newTipo = new ArrayList<TablasTabla>();


        for (TipoContratoDTO row:resultB ) {

            if (!old.equals(row.getCodigoTab()) ) {

                if(old != 0) {
                    item.setHijos(newTipo);

                    result.add(item);
                    newTipo = new ArrayList<TablasTabla>();
                }

                item = new GroupContratos(row.getCodigoTab(),row.getDescripTab(), null);
                if(row.getTipos() == null){
                    TablasTabla tablasequal= new TablasTabla();
                    tablasequal.setCodigoTab(item.getCodigoTab());
                    tablasequal.setDescripTab(item.getDescripTab());
                    tablasequal.setDescrip2Tab(item.getDescripTab());
                    newTipo.add(tablasequal);
                } else {
                    newTipo.add(row.getTipos());
                }


                old = row.getCodigoTab();

            } else {
                newTipo.add(row.getTipos());
                old = row.getCodigoTab();
            }
        }
        item.setHijos(newTipo);
        result.add(item);

        return result;
        //return tablastablaDao.getTipoContrato(tipotab);
    }

    @Override
    public List<TablasTabla> findBYTipoModoPago(Integer tipotab) {
        return tablastablaDao.findBYTipoModoPago(tipotab);
    }

    @Override
    @Transactional(readOnly = true)
    public TablasTabla findByCodigoTab(Integer codigoTab) {
        // TODO Auto-generated method stub

        return tablastablaDao.findByCodigoTab(codigoTab);


    }
}
