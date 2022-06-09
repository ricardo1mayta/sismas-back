package com.spring.sigmaweb.backend.process.legajo.repository;

import com.spring.sigmaweb.backend.process.legajo.dto.PersonalContratoObraDTO;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalConveniosDTO;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalConvenio;
import com.spring.sigmaweb.backend.process.legajo.reports.ReportAgreement;
import com.spring.sigmaweb.backend.process.legajo.reports.ReportContract;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IConvenioDao extends CrudRepository<PersonalConvenio, Long> {
    public PersonalConvenio findByIdPerConv(Long idPerConv);

    @Query("select pc "+
            "from PersonalConvenio pc inner join Personal p on (pc.idPersonalPerconv = p.idPersonal and pc.idObraPerconv = p.obraPer) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "inner join PersonalVidaLaboral pvl on (pc.idPervilaPerconv = pvl.idPervila and pc.idObraPerconv = pvl.idObraPervila) " +
            "where p.idPersonal=?1 and o.idobra = ?2 and pc.idPerConv= ?3 and pvl.idPervila = ?4"
    )
    public PersonalConvenio findByPersonalAndObraAndConvenio(Long idpersonal, String idobra, Long idperconv, Long idpervila);

    @Query("select pc "+
            "from PersonalConvenio pc inner join Personal p on (pc.idPersonalPerconv = p.idPersonal and pc.idObraPerconv = p.obraPer) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "inner join PersonalVidaLaboral pvl on (pc.idPervilaPerconv = pvl.idPervila and pc.idObraPerconv = pvl.idObraPervila) " +
            "where p.idPersonal=?1 and o.idobra = ?2 and pvl.idPervila = ?3"
    )
    public List<PersonalConvenio> findByPersonalAndObraList(Long idpersonal, String idobra, Long idpervila);

    @Query("select new com.spring.sigmaweb.backend.process.legajo.dto.PersonalConveniosDTO(pc.idPerConv, " +
            "o.idobra as idObraPerconv," +
            "p.idPersonal, " +
            "pvl.idPervila, " +
            "pvl.fechaInicioPervila, " +
            "pvl.fechaFinPervila, " +
            "pvl.estadoPervila, " +
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
            "inner join PersonalVidaLaboral pvl on (pc.idPervilaPerconv = pvl.idPervila and pc.idObraPerconv = pvl.idObraPervila) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "left join TablasTabla ttc on (pc.idTipoPerconv = ttc.codigoTab and 320 = ttc.tipoTab)" +
            "where p.idPersonal=?1 and o.idobra = ?2 and pc.idPerConv = ?3 and pvl.idPervila = ?4"
    )
    public PersonalConveniosDTO findByPersonalAndObraAndConvenioDto(Long idpersona, String idobra, Long idperconv, Long idpervila);

    @Query("select new com.spring.sigmaweb.backend.process.legajo.dto.PersonalConveniosDTO(pc.idPerConv, " +
            "o.idobra as idObraPerconv," +
            "p.idPersonal, " +
            "pvl.idPervila, " +
            "pvl.fechaInicioPervila, " +
            "pvl.fechaFinPervila, " +
            "pvl.estadoPervila, " +
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
            "inner join PersonalVidaLaboral pvl on (pc.idPervilaPerconv = pvl.idPervila and pc.idObraPerconv = pvl.idObraPervila) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "left join TablasTabla ttc on (pc.idTipoPerconv = ttc.codigoTab and 320 = ttc.tipoTab)" +
            "where p.idPersonal=?1 and o.idobra = ?2 and pvl.idPervila =?3"
    )
    public List<PersonalConveniosDTO> findByPersonalAndObraListDto(Long idpersona, String idobra, Long idpervila);

    @Query("select new com.spring.sigmaweb.backend.process.legajo.dto.PersonalConveniosDTO(pc.idPerConv, " +
            "o.idobra as idObraPerconv," +
            "p.idPersonal, " +
            "pvl.idPervila, " +
            "pvl.fechaInicioPervila, " +
            "pvl.fechaFinPervila, " +
            "pvl.estadoPervila, " +
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
            "inner join PersonalVidaLaboral pvl on (pc.idPervilaPerconv = pvl.idPervila and pc.idObraPerconv = pvl.idObraPervila) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "left join TablasTabla ttc on (pc.idTipoPerconv = ttc.codigoTab and 320 = ttc.tipoTab)" +
            "where p.idPersonal=?1 and o.idobra = ?2 and pvl.idPervila =?3 and pc.idTipoPerconv in (32006,32007) and pc.estadoPerconv='ACTIVO' " +
            "order by pc.fechaIniPerconv, pc.fechaFinPerconv "
    )
    public List<PersonalConveniosDTO> findConvenioActivoPracticasListDto(Long idpersona, String idobra, Long idpervila);

    //QUERYS PARA REPORTES CONVENIOS
    //======================================================================================================
    @Query("select new com.spring.sigmaweb.backend.process.legajo.reports.ReportAgreement(" +
            "o.idobra," +
            "o.nombreobra," +
            "p.idPersonal," +
            "p.codigoPer," +
            "(case p.estadoPer when true then 'ACTIVO' when false then 'INACTIVO' else '' end) as estadoPer," +
            "psn.apePaternoPers," +
            "psn.apeMaternoPers," +
            "psn.nombrePers," +

            "tdocu.codigoTab as idTipoDocPers," +
            "tdocu.descrip2Tab as tipoDocPers," +
            "psn.nroDocPers," +
            "tgroc.descripTab as grupoOcupacional, " +
            "tgrpl.descripTab as nivelPlanilla, " +

            "pvl.idPervila," +
            "pc.idPerConv," +
            "tconv.codigoTab as idTipoPerconv," +
            "tconv.descripTab as tipoPerconv," +

            "pc.fechaIniPerconv," +
            "pc.fechaFinPerconv," +
            "pc.fechaTerminoPerconv," +
            "pc.observacionesPerconv," +

            "pc.estadoPerconv," +
            "pc.fechaIngPerconv," +
            "pc.creaPorPerconv" +
            ") " +
            "from Personal p inner join Obra o on (p.obraPer=o.idobra) " +
            "inner join Persona psn on (o.idobra = psn.obraPers and p.idPersona = psn.idPersona) " +
            "inner join PersonalVidaLaboral pvl on (o.idobra = pvl.idObraPervila and p.idPersonal = pvl.idPersonalPervila and pvl.estadoPervila='ACTIVO') " +
            "left join PersonalConvenio pc on (pc.idObraPerconv=o.idobra and pc.idPersonalPerconv = p.idPersonal and pc.idPervilaPerconv=pvl.idPervila ) " +
            "left join PersonalPuesto pp on (o.idobra = pp.idObraPerpuest and p.idPersonal=pp.idPersonalPerpuest) " +
            "left join TablasTabla tconv on (pc.idTipoPerconv = tconv.codigoTab) " +
            "left join TablasTabla tdocu on (psn.idTipoDocPers = tdocu.codigoTab) " +
            "left join TablasTabla tgroc on (pp.idAreaPerpuest = tgroc.codigoTab and tgroc.tipoTab = (case ?1 when 'SECTOR' then 306 else 305 end) ) " +
            "left join TablasTabla tgrpl on (pp.idTipoNivelPlanillaPerpuest = tgrpl.codigoTab and tgrpl.tipoTab = (case ?1 when 'SECTOR' then 303 else 302 end) ) " +
            "where o.idobra =?1 and " +
            "p.estadoPer = (case ?2 when 1 then true when 0 then false else p.estadoPer end ) " +
            "and coalesce(tconv.codigoTab,0) = (case ?5 when 0 then tconv.codigoTab when -1 then 0 else ?5 end ) " +
            "and coalesce(pp.idAreaPerpuest,0) = (case ?3 when 0 then coalesce(pp.idAreaPerpuest,0) else ?3 end ) " +
            "and coalesce(pp.idTipoNivelPlanillaPerpuest,0) = (case ?4 when 0 then coalesce(pp.idTipoNivelPlanillaPerpuest,0) else ?4 end ) "
    )
    public List<ReportAgreement> reportConveniosPorObra(String idobra, Integer estadoper, Integer tipogrupo, Integer tipoplanilla, Integer idtipoconvenio, Sort sort);


}
