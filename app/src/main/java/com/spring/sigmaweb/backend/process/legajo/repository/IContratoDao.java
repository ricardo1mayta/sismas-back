package com.spring.sigmaweb.backend.process.legajo.repository;

import com.spring.sigmaweb.backend.process.legajo.dto.PersonalContratoObraDTO;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalContrato;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;

public interface IContratoDao extends CrudRepository<PersonalContrato, Long> {
    public PersonalContrato findByIdPerCont(Long idPerCont);

    @Query("select pc " +
            "from PersonalContrato pc inner join Personal p on (pc.idPersonalPercont = p.idPersonal and pc.idObraPercont = p.obraPer) " +
            "inner join PersonalVidaLaboral pvl on (pc.idPervilaPercont = pvl.idPervila and pc.idObraPercont = pvl.idObraPervila) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "where p.idPersonal=?1 and o.idobra = ?2 and pc.idPerCont= ?3 and pvl.idPervila = ?4"
    )
    public PersonalContrato findByPersonalAndObraAndcontrato(Long idpersona, String idobra, Long idpercont, Long idpervila);

    @Query("select pc " +
            "from PersonalContrato pc inner join Personal p on (pc.idPersonalPercont = p.idPersonal and pc.idObraPercont = p.obraPer) " +
            "inner join PersonalVidaLaboral pvl on (pc.idPervilaPercont = pvl.idPervila and pc.idObraPercont = pvl.idObraPervila) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "where p.idPersonal=?1 and o.idobra = ?2 and pvl.idPervila = ?3"
    )
    public List<PersonalContrato> findByPersonalAndObraList(Long idpersona, String idobra, Long idpervila);

    @Query("select pc " +
            "from PersonalContrato pc inner join Personal p on (pc.idPersonalPercont = p.idPersonal and pc.idObraPercont = p.obraPer) " +
            "inner join PersonalVidaLaboral pvl on (pc.idPervilaPercont = pvl.idPervila and pc.idObraPercont = pvl.idObraPervila) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "where p.idPersonal=?1 and o.idobra = ?2 and pvl.idPervila = ?3 and pc.estadoPercont = 'ACTIVO'  " +
            "ORDER BY pc.fechaIniPercont, pc.fechaFinPercont"
    )
    public List<PersonalContrato> findByActivosPersonalAndObraList(Long idpersona, String idobra, Long idpervila);

    @Query("select new com.spring.sigmaweb.backend.process.legajo.dto.PersonalContratoObraDTO(pc.idPerCont, " +
            "o.idobra as idObraPercont," +
            "p.idPersonal, " +
            "pvl.idPervila, " +
            "pvl.fechaInicioPervila, " +
            "pvl.fechaFinPervila, " +
            "pvl.estadoPervila, " +
            "psn.apePaternoPers, " +
            "psn.apeMaternoPers, " +
            "psn.nombrePers, " +
            "pc.idTipoPercont," +
            "ttc.descripTab as tipoContrato, " +
            "pc.fechaIniPercont," +
            "pc.fechaFinPercont, " +
            "pc.observacionesPercont, " +
            "pc.estadoPercont, " +
            "pc.fechaTerminoPercont, " +
            "pc.jornadaSemanalPercont, " +
            "pc.remuneracionPercont, " +
            "pc.bonificacionPercont, " +
            "pc.fecIniPruebaPercont," +
            "pc.fecFinPruebaPercont," +
            "pc.fechaIngPercont," +
            "pc.creaPorPercont," +
            "pc.fechaModiPercont," +
            "pc.modiPorPercont" +
            ") "+
            "from PersonalContrato pc inner join Personal p on (pc.idPersonalPercont = p.idPersonal and pc.idObraPercont = p.obraPer) " +
            "inner join Persona psn on (p.idPersona = psn.idPersona) " +
            "inner join PersonalVidaLaboral pvl on (pc.idPervilaPercont = pvl.idPervila and pc.idObraPercont = pvl.idObraPervila) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "left join TablasTabla ttc on (pc.idTipoPercont = ttc.codigoTab and 154 = ttc.tipoTab)" +
            "where p.idPersonal=?1 and o.idobra = ?2 and pc.idPerCont =?3 and pvl.idPervila = ?4 "
    )
    public PersonalContratoObraDTO findByPersonalAndObraAndcontratoDto(Long idpersona, String idobra, Long idpercont, Long idpervila);

    @Query("select new com.spring.sigmaweb.backend.process.legajo.dto.PersonalContratoObraDTO(pc.idPerCont, " +
            "o.idobra as idObraPercont," +
            "p.idPersonal, " +
            "pvl.idPervila, " +
            "pvl.fechaInicioPervila, " +
            "pvl.fechaFinPervila, " +
            "pvl.estadoPervila, " +
            "psn.apePaternoPers, " +
            "psn.apeMaternoPers, " +
            "psn.nombrePers, " +
            "pc.idTipoPercont," +
            "ttc.descripTab as tipoContrato, " +
            "pc.fechaIniPercont," +
            "pc.fechaFinPercont, " +
            "pc.observacionesPercont, " +
            "pc.estadoPercont, " +
            "pc.fechaTerminoPercont, " +
            "pc.jornadaSemanalPercont, " +
            "pc.remuneracionPercont, " +
            "pc.bonificacionPercont, " +
            "pc.fecIniPruebaPercont," +
            "pc.fecFinPruebaPercont," +
            "pc.fechaIngPercont," +
            "pc.creaPorPercont," +
            "pc.fechaModiPercont," +
            "pc.modiPorPercont" +
            ") "+
            "from PersonalContrato pc inner join Personal p on (pc.idPersonalPercont = p.idPersonal and pc.idObraPercont = p.obraPer) " +
            "inner join Persona psn on (p.idPersona = psn.idPersona) " +
            "inner join PersonalVidaLaboral pvl on (pc.idPervilaPercont = pvl.idPervila and pc.idObraPercont = pvl.idObraPervila) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "left join TablasTabla ttc on (pc.idTipoPercont = ttc.codigoTab and 154 = ttc.tipoTab)" +
            "where p.idPersonal=?1 and o.idobra = ?2 and pvl.idPervila = ?3 " +
            "order by pc.fechaIniPercont desc "
    )
    public List<PersonalContratoObraDTO> findByPersonalAndObraAndcontratoDtoList(Long idpersona, String idobra, Long idpervila);

    @Query("select new com.spring.sigmaweb.backend.process.legajo.dto.PersonalContratoObraDTO(pc.idPerCont, " +
            "o.idobra as idObraPercont," +
            "p.idPersonal, " +
            "pvl.idPervila, " +
            "pvl.fechaInicioPervila, " +
            "pvl.fechaFinPervila, " +
            "pvl.estadoPervila, " +
            "psn.apePaternoPers, " +
            "psn.apeMaternoPers, " +
            "psn.nombrePers, " +
            "pc.idTipoPercont," +
            "ttc.descripTab as tipoContrato, " +
            "pc.fechaIniPercont," +
            "pc.fechaFinPercont, " +
            "pc.observacionesPercont, " +
            "pc.estadoPercont, " +
            "pc.fechaTerminoPercont, " +
            "pc.jornadaSemanalPercont, " +
            "pc.remuneracionPercont, " +
            "pc.bonificacionPercont, " +
            "pc.fecIniPruebaPercont," +
            "pc.fecFinPruebaPercont," +
            "pc.fechaIngPercont," +
            "pc.creaPorPercont," +
            "pc.fechaModiPercont," +
            "pc.modiPorPercont" +
            ") "+
            "from PersonalContrato pc inner join Personal p on (pc.idPersonalPercont = p.idPersonal and pc.idObraPercont = p.obraPer) " +
            "inner join Persona psn on (p.idPersona = psn.idPersona) " +
            "inner join PersonalVidaLaboral pvl on (pc.idPervilaPercont = pvl.idPervila and pc.idObraPercont = pvl.idObraPervila) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "left join TablasTabla ttc on (pc.idTipoPercont = ttc.codigoTab and 154 = ttc.tipoTab)" +
            "where p.idPersonal=?1 and o.idobra = ?2 and pvl.idPervila = ?3 and pc.estadoPercont = 'ACTIVO'  " +
            "ORDER BY pc.fechaIniPercont, pc.fechaFinPercont"
    )
    public List<PersonalContratoObraDTO> findContratoActivoPersonalObra(Long idpersona, String idobra, Long idpervila);

    @Query("select new com.spring.sigmaweb.backend.process.legajo.dto.PersonalContratoObraDTO(pc.idPerCont, " +
            "o.idobra as idObraPercont," +
            "p.idPersonal, " +
            "pvl.idPervila, " +
            "pvl.fechaInicioPervila, " +
            "pvl.fechaFinPervila, " +
            "pvl.estadoPervila, " +
            "psn.apePaternoPers, " +
            "psn.apeMaternoPers, " +
            "psn.nombrePers, " +
            "pc.idTipoPercont," +
            "ttc.descripTab as tipoContrato, " +
            "pc.fechaIniPercont," +
            "pc.fechaFinPercont, " +
            "pc.observacionesPercont, " +
            "pc.estadoPercont, " +
            "pc.fechaTerminoPercont, " +
            "pc.jornadaSemanalPercont, " +
            "pc.remuneracionPercont, " +
            "pc.bonificacionPercont, " +
            "pc.fecIniPruebaPercont," +
            "pc.fecFinPruebaPercont," +
            "pc.fechaIngPercont," +
            "pc.creaPorPercont," +
            "pc.fechaModiPercont," +
            "pc.modiPorPercont" +
            ") "+
            "from PersonalContrato pc inner join Personal p on (pc.idPersonalPercont = p.idPersonal and pc.idObraPercont = p.obraPer) " +
            "inner join Persona psn on (p.idPersona = psn.idPersona) " +
            "inner join PersonalVidaLaboral pvl on (pc.idPervilaPercont = pvl.idPervila and pc.idObraPercont = pvl.idObraPervila) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "left join TablasTabla ttc on (pc.idTipoPercont = ttc.codigoTab and 154 = ttc.tipoTab)" +
            "where p.idPersonal =?1 and o.idobra = ?2 and pvl.idPervila = ?3 and pc.idPerCont != ?4 and" +
            "   pc.fechaIniPercont < ?5  " +
            "ORDER BY pc.fechaIniPercont desc, pc.fechaFinPercont "
            )
    public List<PersonalContratoObraDTO> findAnteriorContratoPersonalVidaLaboralObra(Long idpersona, String idobra, Long idpervila, Long idpercont, Date fechaini);
}
