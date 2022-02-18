package com.spring.sigmaweb.backend.process.legajo.repository;

import com.spring.sigmaweb.backend.process.legajo.model.PersonalHistorcoBancario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPersonalHistoricoBancarioDao extends CrudRepository<PersonalHistorcoBancario, Long> {
    public List<PersonalHistorcoBancario> findByIdObraHistdbAndIdPersonalHistdbAndIdPervilaHistdb (String idObraHistdb, long idPersonalHistdb, Long idPervilaHistdb);

    public PersonalHistorcoBancario findByIdObraHistdbAndIdPersonalHistdbAndIdPervilaHistdbAndIdHistdb (String idObraHistdb, long idPersonalHistdb, Long idPervilaHistdb, Long idHistdb);

    @Query("select hdb " +
            "from PersonalHistorcoBancario hdb " +
            "where hdb.idObraHistdb= ?1 and hdb.idPersonalHistdb=?2 and hdb.idPervilaHistdb = ?3 " +
            "and hdb.tipoHistdb = (case ?4 when '_' then hdb.tipoHistdb else ?4 end ) " +
            "order by fechaCambioHistdb desc ")
    public List<PersonalHistorcoBancario> findByIdObraHistdbAndIdPersonalHistdbAndIdPervilaHistdbAndTipoHistdb (String idObraHistdb, long idPersonalHistdb,
                                                                                                                Long idPervilaHistdb, String tipoHistdb);


}
