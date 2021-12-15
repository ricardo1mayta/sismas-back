package com.spring.sigmaweb.backend.process.legajo.repository;

import com.spring.sigmaweb.backend.process.legajo.dto.PersonalContratoObraDTO;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalContrato;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IContratoDao extends CrudRepository<PersonalContrato, Long> {
    public PersonalContrato findByIdPerCont(Long idPerCont);

    @Query("select pc " +
            "from PersonalContrato pc inner join Personal p on (pc.idPersonalPercont = p.idPersonal and pc.idObraPercont = p.obraPer) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "where p.idPersonal=?1 and o.idobra = ?2 and pc.idPerCont= ?3 "
    )
    public PersonalContrato findByPersonalAndObraAndcontrato(Long idpersona, String idobra, Long idpercont);

    @Query("select pc " +
            "from PersonalContrato pc inner join Personal p on (pc.idPersonalPercont = p.idPersonal and pc.idObraPercont = p.obraPer) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "where p.idPersonal=?1 and o.idobra = ?2 "
    )
    public List<PersonalContrato> findByPersonalAndObraList(Long idpersona, String idobra);

    @Query("select new com.spring.sigmaweb.backend.process.legajo.dto.PersonalContratoObraDTO(pc.idPerCont, " +
            "o.idobra as idObraPercont," +
            "p.idPersonal, " +
            "psn.apePaternoPers, " +
            "psn.apeMaternoPers, " +
            "psn.nombrePers, " +
            "pc.idTipoPercont," +
            "ttc.descripTab as tipoContrato, " +
            "pc.urlDocumentoPercont, " +
            "pc.fechaIniPercont," +
            "pc.fechaFinPercont, " +
            "pc.observacionesPercont, " +
            "pc.estadoPercont, " +
            "pc.fechaTerminoPercont, " +
            "pc.fechaIngPercont," +
            "pc.creaPorPercont," +
            "pc.fechaModiPercont," +
            "pc.modiPorPercont" +
            ") "+
            "from PersonalContrato pc inner join Personal p on (pc.idPersonalPercont = p.idPersonal and pc.idObraPercont = p.obraPer) " +
            "inner join Persona psn on (p.idPersona = psn.idPersona) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "left join TablasTabla ttc on (pc.idTipoPercont = ttc.codigoTab and 154 = ttc.tipoTab)" +
            "where p.idPersonal=?1 and o.idobra = ?2 and pc.idPerCont = ?3 "
    )
    public PersonalContratoObraDTO findByPersonalAndObraAndcontratoDto(Long idpersona, String idobra, Long idpercont);

    @Query("select new com.spring.sigmaweb.backend.process.legajo.dto.PersonalContratoObraDTO(pc.idPerCont, " +
            "o.idobra as idObraPercont," +
            "p.idPersonal, " +
            "psn.apePaternoPers, " +
            "psn.apeMaternoPers, " +
            "psn.nombrePers, " +
            "pc.idTipoPercont," +
            "ttc.descripTab as tipoContrato, " +
            "pc.urlDocumentoPercont, " +
            "pc.fechaIniPercont," +
            "pc.fechaFinPercont, " +
            "pc.observacionesPercont, " +
            "pc.estadoPercont, " +
            "pc.fechaTerminoPercont, " +
            "pc.fechaIngPercont," +
            "pc.creaPorPercont," +
            "pc.fechaModiPercont," +
            "pc.modiPorPercont" +
            ") "+
            "from PersonalContrato pc inner join Personal p on (pc.idPersonalPercont = p.idPersonal and pc.idObraPercont = p.obraPer) " +
            "inner join Persona psn on (p.idPersona = psn.idPersona) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "left join TablasTabla ttc on (pc.idTipoPercont = ttc.codigoTab and 154 = ttc.tipoTab)" +
            "where p.idPersonal=?1 and o.idobra = ?2 "

    )
    public List<PersonalContratoObraDTO> findByPersonalAndObraAndcontratoDtoList(Long idpersona, String idobra);

}
