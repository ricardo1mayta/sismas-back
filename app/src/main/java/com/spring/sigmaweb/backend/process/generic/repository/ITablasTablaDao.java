package com.spring.sigmaweb.backend.process.generic.repository;

import java.util.List;

import com.spring.sigmaweb.backend.process.generic.model.TablasTabla;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ITablasTablaDao extends CrudRepository<TablasTabla,Long>{
    public List<TablasTabla> findByTipoTab(Integer tipotab);

    public TablasTabla findByCodigoTab(Integer codigoTab);

    @Query("select t "
            + "from TablasTabla t "
            + "where tipoTab=?1 and codigoTab in ?2")
    public List<TablasTabla> findByCodigoList(Integer tipotab,Integer[] listCodigos);

    @Query("select t "
            + "from TablasTabla t "
            + "where tipoTab=?1 and codigoTab not in ?2")
    public List<TablasTabla> findByCodigoListNot(Integer tipotab,Integer[] listCodigos);
}
