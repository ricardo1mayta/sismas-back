package com.spring.sigmaweb.backend.process.generic.repository;

import java.util.List;

import com.spring.sigmaweb.backend.process.generic.dto.TipoContratoDTO;
import com.spring.sigmaweb.backend.process.generic.model.TablasTabla;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ITablasTablaDao extends CrudRepository<TablasTabla,Long>{
    public List<TablasTabla> findByTipoTabOrderByDescripTabAsc(Integer tipotab);

    public TablasTabla findByCodigoTab(Integer codigoTab);

    @Query("select t "
            + "from TablasTabla t "
            + "where tipoTab=?1 and codigoTab in ?2 " +
            "order by t.descripTab")
    public List<TablasTabla> findByCodigoList(Integer tipotab,Integer[] listCodigos);

    @Query("select t "
            + "from TablasTabla t "
            + "where tipoTab=?1 and codigoTab not in ?2" +
            " order by t.descripTab")
    public List<TablasTabla> findByCodigoListNot(Integer tipotab,Integer[] listCodigos);

    @Query("select new com.spring.sigmaweb.backend.process.generic.dto.TipoContratoDTO( pd.codigoTab, " +
            "pd.descripTab, " +
            "h )"
            + "from TablasTabla pd left join TablasTabla h on ( substring(pd.codigoTab,1,4) = substring( h.codigoTab,1, 4) " +
            "                                                   and substring( h.codigoTab,5, 1) !='0' ) "
            + "where pd.tipoTab=?1 and substring( pd.codigoTab,5,1) ='0' "
            +" order by pd.codigoTab,h.codigoTab")
    public List<TipoContratoDTO> getTipoContrato(Integer tipotab);

    @Query("FROM TablasTabla t where t.tipoTab=?1 and t.codigoTab not in (15805,15806,15807) ")
    List<TablasTabla>findBYTipoModoPago(Integer tipotab);
}
