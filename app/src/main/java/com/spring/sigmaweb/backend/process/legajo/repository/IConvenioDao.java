package com.spring.sigmaweb.backend.process.legajo.repository;

import com.spring.sigmaweb.backend.process.legajo.dto.PersonalContratoObraDTO;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalConveniosDTO;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalConvenio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IConvenioDao extends CrudRepository<PersonalConvenio, Long> {
    public PersonalConvenio findByIdPerConv(Long idPerConv);

    @Query("select pc "+
            "from PersonalConvenio pc inner join Personal p on (pc.idPersonalPerconv = p.idPersonal and pc.idObraPerconv = p.obraPer) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "where p.idPersonal=?1 and o.idobra = ?2 and pc.idPerConv= ?3 "
    )
    public PersonalConvenio findByPersonalAndObraAndConvenio(Long idpersonal, String idobra, Long idperconv);

    @Query("select pc "+
            "from PersonalConvenio pc inner join Personal p on (pc.idPersonalPerconv = p.idPersonal and pc.idObraPerconv = p.obraPer) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "where p.idPersonal=?1 and o.idobra = ?2 "
    )
    public List<PersonalConvenio> findByPersonalAndObraList(Long idpersonal, String idobra);

    @Query("select new com.spring.sigmaweb.backend.process.legajo.dto.PersonalConveniosDTO(pc.idPerConv, " +
            "o.idobra as idObraPerconv," +
            "p.idPersonal, " +
            "psn.apePaternoPers, " +
            "psn.apeMaternoPers, " +
            "psn.nombrePers, " +
            "pc.idTipoPerconv," +
            "ttc.descripTab as tipoConvenio, " +
            "pc.observacionesPerconv, " +
            "pc.estadoPerconv, " +

            "pc.fechaIniPerconv," +
            "pc.fechaFinPerconv, " +

            "pc.fechaTerminoPerconv, " +
            "pc.fechaIngPerconv," +
            "pc.creaPorPerconv," +
            "pc.fechaModiPerconv," +
            "pc.modiPorPerconv" +
            ") "+
            "from PersonalConvenio pc inner join Personal p on (pc.idPersonalPerconv = p.idPersonal and pc.idObraPerconv = p.obraPer) " +
            "inner join Persona psn on (p.idPersona = psn.idPersona) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "left join TablasTabla ttc on (pc.idTipoPerconv = ttc.codigoTab and 154 = ttc.tipoTab)" +
            "where p.idPersonal=?1 and o.idobra = ?2 and pc.idPerConv = ?3 "
    )
    public PersonalConveniosDTO findByPersonalAndObraAndConvenioDto(Long idpersona, String idobra, Long idperconv);






}
