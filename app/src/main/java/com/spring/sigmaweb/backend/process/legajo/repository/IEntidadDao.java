package com.spring.sigmaweb.backend.process.legajo.repository;

import java.util.List;

import com.spring.sigmaweb.backend.process.legajo.dto.EntidadDataSelectDTO;
import com.spring.sigmaweb.backend.process.legajo.dto.EntidadListSelectDTO;
import com.spring.sigmaweb.backend.process.legajo.model.Entidad;
import com.spring.sigmaweb.backend.process.legajo.model.Personal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IEntidadDao extends CrudRepository<Entidad, Long> {
    public Entidad findByIdEntidad(Long idEntidad);

    @Query("select e from Entidad e inner join Obra o on (e.obraEnt = o.idobra)" +
            "where idEntidad=?1 and o.idobra = ?2")
    public Entidad findByIdEntidadAndObraEnt(Long idEntidad, String idobra);

    @Query( "select new com.spring.sigmaweb.backend.process.legajo.dto.EntidadDataSelectDTO(e.idEntidad, "
            + "o.idobra, "
            + "e.rucEnt, "
            + "e.nombreEnt, "
            + "e.nombreComerEnt, "
            + "e.telefonoEnt, "
            + "e.urlEnt, "
            + "e.emailEnt,"
            + "(case e.flgEduSupEnt when true then 'Si' else 'No' end) as flgEduSupEnt,"
            +"(case e.flgFinacieraEnt when true then 'Si' else 'No' end) as flgFinacieraEnt,"
            +"(case e.flgPrevisionalEnt when true then 'Si' else 'No' end) as flgPrevisionalEnt,"
            +"(case e.flgProveedorEnt when true then 'Si' else 'No' end) as flgProveedorEnt,"
            +"(case e.flgSaludEnt when true then 'Si' else 'No' end) as flgSaludEnt,"
            +"e.creaPorEnt, "
            +"e.modiPorEnt, "
            +"e.fechaIngEnt) "
            + "from Entidad e inner join Obra o on (e.obraEnt = o.idobra) "
            + "where o.idobra = ?1 "
    )
    public List<EntidadDataSelectDTO> findByEntidadObra(String idobra);

    @Query( "select new com.spring.sigmaweb.backend.process.legajo.dto.EntidadDataSelectDTO(e.idEntidad, "
            + "o.idobra, "
            + "e.rucEnt, "
            + "e.nombreEnt, "
            + "e.nombreComerEnt, "
            + "e.telefonoEnt, "
            + "e.urlEnt, "
            + "e.emailEnt,"
            + "(case e.flgEduSupEnt when true then 'Si' else 'No' end) as flgEduSupEnt,"
            +"(case e.flgFinacieraEnt when true then 'Si' else 'No' end) as flgFinacieraEnt,"
            +"(case e.flgPrevisionalEnt when true then 'Si' else 'No' end) as flgPrevisionalEnt,"
            +"(case e.flgProveedorEnt when true then 'Si' else 'No' end) as flgProveedorEnt,"
            +"(case e.flgSaludEnt when true then 'Si' else 'No' end) as flgSaludEnt,"
            +"e.creaPorEnt, "
            + "e.modiPorEnt, "
            +"e.fechaIngEnt) "
            + "from Entidad e inner join Obra o on (e.obraEnt = o.idobra) "
            + "where e.idEntidad=?1 and o.idobra = ?2 "
    )
    public EntidadDataSelectDTO findByIdEntidadObra(Long idEntidad,String idobra);

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
