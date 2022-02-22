package com.spring.sigmaweb.backend.process.legajo.repository;

import com.spring.sigmaweb.backend.process.legajo.dto.HistoricoVilaLabotalDTO;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalConveniosDTO;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalHistoricoVinculoLaboral;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPersonalHistoricoVinculoLaboralDao extends CrudRepository<PersonalHistoricoVinculoLaboral, Long> {
    public PersonalHistoricoVinculoLaboral findByIdObraHistvilaAndIdPersonalHistvilaAndIdPervilaHistvilaAndIdPercontHistvilaAndIdHistvila(
            String idObraHistvila, Long idPersonalHistvila, Long idPervilaHistvila, Long idPercontHistvila, Long idHistvila
    );



    @Query("select hvl " +
            "from PersonalHistoricoVinculoLaboral hvl " +
            "where hvl.idObraHistvila = ?1 and hvl.idPersonalHistvila = ?2 and hvl.idPervilaHistvila = ?3 " +
            "and hvl.idPercontHistvila = (case ?4 when -1 then hvl.idPercontHistvila else ?4 end) " +
            "and hvl.tipoHistvila = (case ?5 when '_' then hvl.tipoHistvila else ?5 end)")
    public List<PersonalHistoricoVinculoLaboral> findByObraAndPersonalAndVidaLabAndContratoAndtipoList(
            String idObraHistvila, Long idPersonalHistvila, Long idPervilaHistvila, Long idPercontHistvila, String tipoHistvila
    );

    @Query("select new com.spring.sigmaweb.backend.process.legajo.dto.HistoricoVilaLabotalDTO(hvl.idHistvila, " +
            "hvl.idObraHistvila," +
            "p.idPersonal as idPersonalHistvila," +
            "p.codigoPer," +
            "p.estadoPer," +
            "psn.apePaternoPers," +
            "psn.apeMaternoPers," +
            "psn.nombrePers," +
            "psn.nroDocPers," +

            "pc.idPerCont as idPercontHistvila," +
            "pc.fechaIniPercont," +
            "pc.fechaFinPercont," +
            "pc.fechaTerminoPercont," +
            "ttc.descripTab as tipoPercont," +

            "pvl.idPervila as idPervilaHistvila," +
            "pvl.fechaInicioPervila," +
            "pvl.fechaFinPervila," +
            "pvl.estadoPervila," +

            "hvl.motivoHistvila," +
            "hvl.tipoHistvila," +

            "hvl.fechaCambioHistvila," +
            "hvl.jornadaSemaOldHistvila," +
            "hvl.bonificacionOldHistvila," +
            "hvl.remuneracionOldHistvila," +

            "hvl.jornadaSemaNewHistvila," +
            "hvl.bonificacionNewHistvila," +
            "hvl.remuneracionNewHistvila," +

            "hvl.fechaIngHistvila," +
            "hvl.fechaModiHistvila," +
            "hvl.creaPorHistvila," +
            "hvl.modiPorHistvila," +
            "hvl.estadoHistvila" +
            ") " +
            "from PersonalHistoricoVinculoLaboral hvl inner join Personal p on (hvl.idPersonalHistvila = p.idPersonal and hvl.idObraHistvila = p.obraPer) " +
            "inner join Persona psn on (p.idPersona = psn.idPersona) " +
            "inner join PersonalVidaLaboral pvl on (hvl.idPervilaHistvila = pvl.idPervila and hvl.idObraHistvila = pvl.idObraPervila) " +
            "inner join Obra o on (hvl.idObraHistvila = o.idobra) " +
            "inner join PersonalContrato pc on (hvl.idPercontHistvila = pc.idPerCont and hvl.idObraHistvila = pc.idObraPercont) " +
            "left join TablasTabla ttc on (pc.idTipoPercont = ttc.codigoTab and 154 = ttc.tipoTab) " +
            "where hvl.idObraHistvila = ?1 and hvl.idPersonalHistvila = ?2 and hvl.idPervilaHistvila = ?3 " +
            "and hvl.idPercontHistvila = (case ?4 when -1 then hvl.idPercontHistvila else ?4 end) " +
            "and hvl.tipoHistvila = (case ?5 when '_' then hvl.tipoHistvila else ?5 end)"
    )
    public List<HistoricoVilaLabotalDTO> findByObraAndPersonalAndVidaLabAndContratoAndtipoListDto(
            String idObraHistvila, Long idPersonalHistvila, Long idPervilaHistvila, Long idPercontHistvila, String tipoHistvila
    );




}
