package com.spring.sigmaweb.backend.process.legajo.repository;

import java.util.List;

import com.spring.sigmaweb.backend.process.legajo.dto.EntidadListSelectDTO;
import com.spring.sigmaweb.backend.process.legajo.model.Entidad;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IEntidadDao extends CrudRepository<Entidad, Long> {
    @Query( "select new com.spring.sigmaweb.backend.process.legajo.dto.EntidadListSelectDTO(e.idEntidad, "
            + "o.idobra, "
            + "e.rucEnt, "
            + "e.nombreEnt, "
            + "e.nombreComerEnt, "
            + "e.telefonoEnt, "
            + "e.urlEnt, "
            + "e.emailEnt) "
            + "from Entidad e inner join Obra o on (e.obraEnt = o.idobra) "
            + "where o.idobra = ?1 and e.flgSaludEnt=true"
    )
    public List<EntidadListSelectDTO> findByTipoEntAndFlgSaludEntAndObra(String idobra);


    @Query( "select new com.spring.sigmaweb.backend.process.legajo.dto.EntidadListSelectDTO(e.idEntidad, "
            + "o.idobra, "
            + "e.rucEnt, "
            + "e.nombreEnt, "
            + "e.nombreComerEnt, "
            + "e.telefonoEnt, "
            + "e.urlEnt, "
            + "e.emailEnt) "
            + "from Entidad e inner join Obra o on (e.obraEnt = o.idobra) "
            + "where e.tipoEnt=?1 and o.idobra = ?2 and e.flgPrevisionalEnt=true"
    )
    public List<EntidadListSelectDTO> findByTipoEntAndFlgPrevisionalEntAndObra(Integer tipoEnt, String idobra);

}
