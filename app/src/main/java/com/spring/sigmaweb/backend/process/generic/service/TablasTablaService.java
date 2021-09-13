package com.spring.sigmaweb.backend.process.generic.service;

import com.spring.sigmaweb.backend.process.generic.model.TablasTabla;
import com.spring.sigmaweb.backend.process.generic.repository.ITablasTablaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TablasTablaService implements ITablasTablaService{
    @Autowired
    private ITablasTablaDao tablastablaDao;

    @Override
    @Transactional(readOnly = true)
    public List<TablasTabla> findByTipoTab(Integer tipotab) {
        return tablastablaDao.findByTipoTab(tipotab);
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
    @Transactional(readOnly = true)
    public TablasTabla findByCodigoTab(Integer codigoTab) {
        // TODO Auto-generated method stub
        return tablastablaDao.findByCodigoTab(codigoTab);
    }
}
