package com.spring.sigmaweb.backend.process.legajo.repository;

import com.spring.sigmaweb.backend.process.legajo.dto.HistoricoVilaLabotalDTO;

import com.spring.sigmaweb.backend.process.legajo.model.PersonalHistoricoVinculoLaboral;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPersonalHistoricoVinculoLaboralDao extends CrudRepository<PersonalHistoricoVinculoLaboral, Long> {
    public PersonalHistoricoVinculoLaboral findByIdObraHistvilaAndIdPersonalHistvilaAndIdPervilaHistvilaAndIdPercontHistvilaAndIdHistvila(
            String idObraHistvila, Long idPersonalHistvila, Long idPervilaHistvila, Long idPercontHistvila, Long idHistvila
    );

    public PersonalHistoricoVinculoLaboral findByIdObraHistvilaAndIdPersonalHistvilaAndIdPervilaHistvilaAndIdPuestoCargoHistvilaAndTipoHistvilaAndIdHistvila(
            String idObraHistvila, Long idPersonalHistvila, Long idPervilaHistvila, Long idPuestoCargoHistvila, String TipoHistvila, Long idHistvila
    );

    @Query("select phvl " +
            "from PersonalHistoricoVinculoLaboral phvl " +
            "where phvl.idObraHistvila = ?1 " +
            "And phvl.idPersonalHistvila = ?2 " +
            "And phvl.idPervilaHistvila = ?3 " +
            "and phvl.idPercontHistvila = ?4 " +
            "And coalesce(phvl.idPuestoCargoHistvila, 0) = coalesce(?5, 0) " +
            "And phvl.tipoHistvila = ?6 " +
            "And date_format(phvl.fechaCambioHistvila, '%Y%m%d') = ?7")
    public List<PersonalHistoricoVinculoLaboral> findByHistoricosPorFecha(String idObraHistvila,
                                                                          Long idPersonalHistvila,
                                                                          Long idPervilaHistvila,
                                                                          Long IdPercontHistvila,
                                                                          Long idPuestoCargoHistvila,
                                                                          String TipoHistvila,
                                                                          String fecha);



    @Query("select hvl " +
            "from PersonalHistoricoVinculoLaboral hvl " +
            "where hvl.idObraHistvila = ?1 and hvl.idPersonalHistvila = ?2 and hvl.idPervilaHistvila = ?3 " +
            "and hvl.idPercontHistvila = (case ?4 when -1 then hvl.idPercontHistvila else ?4 end) " +
            "and hvl.tipoHistvila = (case ?5 when '_' then hvl.tipoHistvila else ?5 end) " +
            "order by hvl.fechaCambioHistvila Desc")
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
            "tmo.descripTab as textMotivoHistvila, " +
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
            "left join TablasTabla tmo on (hvl.motivoHistvila = tmo.codigoTab) " +
            "where hvl.idObraHistvila = ?1 and hvl.idPersonalHistvila = ?2 and hvl.idPervilaHistvila = ?3 " +
            "and hvl.idPercontHistvila = (case ?4 when -1 then hvl.idPercontHistvila else ?4 end) " +
            "and hvl.tipoHistvila in ?5 " + //(case ?5 when '_' then hvl.tipoHistvila else ?5 end) " +
            "order by hvl.fechaCambioHistvila desc"
    )
    public List<HistoricoVilaLabotalDTO> findByObraAndPersonalAndVidaLabAndContratoAndtipoListDto(
            String idObraHistvila, Long idPersonalHistvila, Long idPervilaHistvila, Long idPercontHistvila, String[] tipoHistvila);

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
            "tmo.descripTab as textMotivoHistvila, " +
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
            "left join TablasTabla tmo on (hvl.motivoHistvila = tmo.codigoTab) " +
            "where hvl.idObraHistvila = ?1 and hvl.idPersonalHistvila = ?2 and hvl.idPervilaHistvila = ?3 " +
            "and hvl.idPercontHistvila = (case ?4 when -1 then hvl.idPercontHistvila else ?4 end) " +
            "and hvl.idHistvila = ?5"
    )
    public HistoricoVilaLabotalDTO findByObraAndPersonalAndVidaLabAndContratoAndIdDto(
            String idObraHistvila, Long idPersonalHistvila, Long idPervilaHistvila, Long idPercontHistvila, Long idHistvila);

    @Query("select new com.spring.sigmaweb.backend.process.legajo.dto.HistoricoVilaLabotalDTO(" +
            "hvl.idHistvila, " +
            "hvl.idObraHistvila," +
            "p.idPersonal as idPersonalHistvila," +
            "pc.idPerCont as idPercontHistvila," +
            "pvl.idPervila as idPervilaHistvila," +
            "hvl.motivoHistvila," +
            "tmo.descripTab as textMotivoHistvila, " +
            "hvl.tipoHistvila," +
            "hvl.fechaCambioHistvila," +
            "coalesce(hvl.jornadaSemaNewHistvila, pc.jornadaSemanalPercont) as jornadaSemaNewHistvila," +
            "coalesce(hvl.remuneracionNewHistvila, pc.remuneracionPercont) as remuneracionNewHistvila," +
            "coalesce(hvl.bonificacionNewHistvila, 0) as bonificacionNewHistvila," +
            "hvl.fechaIngHistvila," +
            "hvl.creaPorHistvila" +
            ") " +
            "from PersonalHistoricoVinculoLaboral hvl inner join Personal p on (hvl.idPersonalHistvila = p.idPersonal and hvl.idObraHistvila = p.obraPer) " +
            "inner join Persona psn on (p.idPersona = psn.idPersona) " +
            "inner join PersonalVidaLaboral pvl on (hvl.idPervilaHistvila = pvl.idPervila and hvl.idObraHistvila = pvl.idObraPervila) " +
            "inner join Obra o on (hvl.idObraHistvila = o.idobra) " +
            "inner join PersonalContrato pc on (hvl.idPercontHistvila = pc.idPerCont and hvl.idObraHistvila = pc.idObraPercont) " +
            "left join TablasTabla tmo on (hvl.motivoHistvila = tmo.codigoTab) " +
            "where hvl.idObraHistvila = ?1 and hvl.idPersonalHistvila = ?2  and hvl.idPervilaHistvila = ?3 " +
            "and hvl.idPercontHistvila = (case ?4 when -1 then hvl.idPercontHistvila else ?4 end) and hvl.tipoHistvila = ?5 " +
            "order by hvl.fechaCambioHistvila desc, hvl.idHistvila desc")
    public List<HistoricoVilaLabotalDTO> findByUltimoCambioHistoricoVidaLab(String idObraHistvila,
                                                                    Long idPersonalHistvila,
                                                                    Long idPervilaHistvila,
                                                                    Long idPercontHistvila,
                                                                    String tipo);

    @Query("select new com.spring.sigmaweb.backend.process.legajo.dto.HistoricoVilaLabotalDTO(" +
            "hvl.idHistvila, " +
            "hvl.idObraHistvila," +
            "p.idPersonal as idPersonalHistvila," +
            "pc.idPerCont as idPercontHistvila," +
            "pvl.idPervila as idPervilaHistvila," +
            "hvl.motivoHistvila," +
            "tmo.descripTab as textMotivoHistvila, " +
            "hvl.tipoHistvila," +
            "hvl.fechaCambioHistvila," +
            "coalesce(hvl.jornadaSemaNewHistvila, pc.jornadaSemanalPercont) as jornadaSemaNewHistvila," +
            "coalesce(hvl.remuneracionNewHistvila, pc.remuneracionPercont) as remuneracionNewHistvila," +
            "coalesce(hvl.bonificacionNewHistvila, 0) as bonificacionNewHistvila," +
            "hvl.fechaIngHistvila," +
            "hvl.creaPorHistvila" +
            ") " +
            "from PersonalHistoricoVinculoLaboral hvl inner join Personal p on (hvl.idPersonalHistvila = p.idPersonal and hvl.idObraHistvila = p.obraPer) " +
            "inner join Persona psn on (p.idPersona = psn.idPersona) " +
            "inner join PersonalVidaLaboral pvl on (hvl.idPervilaHistvila = pvl.idPervila and hvl.idObraHistvila = pvl.idObraPervila) " +
            "inner join Obra o on (hvl.idObraHistvila = o.idobra) " +
            "inner join PersonalContrato pc on (hvl.idPercontHistvila = pc.idPerCont and hvl.idObraHistvila = pc.idObraPercont) " +
            "left join TablasTabla tmo on (hvl.motivoHistvila = tmo.codigoTab) " +
            "where hvl.idObraHistvila = ?1 and hvl.idPersonalHistvila = ?2  and hvl.idPervilaHistvila = ?3 " +
            "and hvl.idPercontHistvila = (case ?4 when -1 then hvl.idPercontHistvila else ?4 end) and hvl.tipoHistvila = ?5 " +
            "and hvl.idPuestoCargoHistvila = (case ?6 when -1 then hvl.idPuestoCargoHistvila else ?6 end) " +
            "order by hvl.fechaCambioHistvila desc, hvl.idHistvila desc")
    public List<HistoricoVilaLabotalDTO> findByUltimoCambioHistoricoCargosVidaLab(String idObraHistvila,
                                                                            Long idPersonalHistvila,
                                                                            Long idPervilaHistvila,
                                                                            Long idPercontHistvila,
                                                                            String tipo, Long idCargoHistvila);


    @Query("select new com.spring.sigmaweb.backend.process.legajo.dto.HistoricoVilaLabotalDTO(" +
            "hvl.idHistvila, " +
            "hvl.idObraHistvila," +
            "p.idPersonal as idPersonalHistvila," +
            "pc.idPerCont as idPercontHistvila," +
            "pvl.idPervila as idPervilaHistvila," +
            "hvl.motivoHistvila," +
            "tmo.descripTab as textMotivoHistvila, " +
            "hvl.tipoHistvila," +
            "hvl.fechaCambioHistvila," +
            "coalesce(hvl.jornadaSemaNewHistvila, pc.jornadaSemanalPercont) as jornadaSemaNewHistvila," +
            "coalesce(hvl.remuneracionNewHistvila, pc.remuneracionPercont) as remuneracionNewHistvila," +
            "coalesce(hvl.bonificacionNewHistvila, 0) as bonificacionNewHistvila," +
            "hvl.fechaIngHistvila," +
            "hvl.creaPorHistvila" +
            ") " +
            "from PersonalContrato pc inner join Personal p on (pc.idPersonalPercont = p.idPersonal and pc.idObraPercont = p.obraPer) " +
            "inner join Persona psn on (p.idPersona = psn.idPersona) " +
            "inner join PersonalVidaLaboral pvl on (pc.idPersonalPercont = pvl.idPersonalPervila and pc.idObraPercont = pvl.idObraPervila) " +
            "inner join Obra o on (pc.idObraPercont = o.idobra) " +
            "left join PersonalHistoricoVinculoLaboral hvl on (o.idobra=hvl.idObraHistvila and pc.idPersonalPercont = hvl.idPersonalHistvila and pc.idPerCont=hvl.idPercontHistvila and pvl.idPervila = hvl.idPervilaHistvila) " +
            "left join TablasTabla tmo on (hvl.motivoHistvila = tmo.codigoTab) " +
            "where o.idobra = ?1 " +
            "and p.idPersonal = ?2  " +
            "and pvl.idPervila = ?3 " +
            "and pc.idPerCont = (case ?4 when -1 then pc.idPerCont else ?4 end) " +
            "and coalesce(hvl.tipoHistvila,?5) = ?5" +
            "and coalesce(CONVERT(DATE_FORMAT(hvl.fechaCambioHistvila, '%Y%m%d'), SIGNED), ?6) <= ?6 " +
            "order by hvl.fechaCambioHistvila desc, hvl.idHistvila desc")
    public List<HistoricoVilaLabotalDTO> findByUltimoCambioHistoricoVidaLabActual(String idObraHistvila,
                                                                            Long idPersonalHistvila,
                                                                            Long idPervilaHistvila,
                                                                            Long idPercontHistvila,
                                                                            String tipo,
                                                                            Integer periodoIni,
                                                                            Integer periodoFin);

    @Query("select new com.spring.sigmaweb.backend.process.legajo.dto.HistoricoVilaLabotalDTO(" +
            "hvl.idHistvila, " +
            "hvl.idObraHistvila," +
            "p.idPersonal as idPersonalHistvila," +
            "pc.idPerCont as idPercontHistvila," +
            "pvl.idPervila as idPervilaHistvila," +
            "hvl.motivoHistvila," +
            "tmo.descripTab as textMotivoHistvila, " +
            "hvl.tipoHistvila," +
            "hvl.fechaCambioHistvila," +
            "coalesce(hvl.jornadaSemaNewHistvila, pc.jornadaSemanalPercont,0) as jornadaSemaNewHistvila," +
            "coalesce(hvl.remuneracionNewHistvila, pc.remuneracionPercont,0) as remuneracionNewHistvila," +
            "coalesce(hvl.bonificacionNewHistvila, (case when coalesce(pp.idPerpuest, -1) !=-1 then pp.bonifCargoPerpuest else pcg.bonifCargoPercargo end), 0) as bonificacionNewHistvila," +
            "hvl.fechaIngHistvila," +
            "hvl.creaPorHistvila" +
            ") " +
            "from PersonalHistoricoVinculoLaboral hvl inner join Personal p on (hvl.idPersonalHistvila = p.idPersonal and hvl.idObraHistvila = p.obraPer) " +
            "inner join Persona psn on (p.idPersona = psn.idPersona) " +
            "inner join PersonalVidaLaboral pvl on (hvl.idPervilaHistvila = pvl.idPervila and hvl.idObraHistvila = pvl.idObraPervila) " +
            "inner join Obra o on (hvl.idObraHistvila = o.idobra) " +
            "inner join PersonalContrato pc on (hvl.idPercontHistvila = pc.idPerCont and hvl.idObraHistvila = pc.idObraPercont) " +
            "left join TablasTabla tmo on (hvl.motivoHistvila = tmo.codigoTab) " +
            "left join PersonalPuesto pp on (pp.idPerpuest=hvl.idPuestoCargoHistvila and pp.idObraPerpuest=o.idobra and pp.idPersonalPerpuest=p.idPersonal and pp.idPervilaPerpuest=pvl.idPervila)" +
            "left join PersonalCargo pcg on (pcg.idPercargo=hvl.idPuestoCargoHistvila and pcg.idObraPercargo=o.idobra and pcg.idPersonalPercargo=p.idPersonal and pcg.idPervilaPercargo=pvl.idPervila) " +
            "where hvl.idObraHistvila = ?1 and hvl.idPersonalHistvila = ?2  and hvl.idPervilaHistvila = ?3 " +
            "and hvl.idPercontHistvila = (case ?4 when -1 then hvl.idPercontHistvila else ?4 end) and hvl.tipoHistvila = ?5 " +
            "and hvl.idPuestoCargoHistvila = (case ?6 when -1 then hvl.idPuestoCargoHistvila else ?6 end) " +
            "and CONVERT(DATE_FORMAT(hvl.fechaCambioHistvila, '%Y%m%d'), SIGNED) <= ?7 " +
            "order by hvl.fechaCambioHistvila desc, hvl.idHistvila desc")
    public List<HistoricoVilaLabotalDTO> findByUltimoCambioHistoricoCargosPeriodoVidaLab(String idObraHistvila,
                                                                                  Long idPersonalHistvila,
                                                                                  Long idPervilaHistvila,
                                                                                  Long idPercontHistvila,
                                                                                  String tipo,
                                                                                  Long idCargoHistvila,
                                                                                  Integer periodoIni,
                                                                                  Integer periodoFin);



    @Query(value="select sum(suma) " +
            "from (" +
            "select coalesce(hist.bonificacion_new_histvila, pp.bonificacion_puesto_perpuest, 0) as suma " +
            "from mo_personalpuesto pp left join " +
            "(select h.id_obra_histvila,h.id_personal_histvila,h.id_pervila_histvila, h.bonificacion_new_histvila " +
            "from mo_historico_vinculolaboral h " +
            "left join (select hvl.id_obra_histvila, hvl.id_personal_histvila, hvl.id_pervila_histvila, max(date_format(hvl.fecha_cambio_histvila, '%Y%m%d')) as old_fecha " +
            "from mo_historico_vinculolaboral hvl where hvl.id_obra_histvila= ?1 " +
            "and hvl.id_personal_histvila= ?2 " +
            "and hvl.id_pervila_histvila= ?3 " +
            "and hvl.tipo_histvila='BONIP' " +
            "group by hvl.id_obra_histvila, hvl.id_personal_histvila, hvl.id_pervila_histvila " +
            ") as t on (h.id_obra_histvila = t.id_obra_histvila and h.id_personal_histvila = t.id_personal_histvila and h.id_pervila_histvila=t.id_pervila_histvila and date_format(h.fecha_cambio_histvila, '%Y%m%d') = t.old_fecha) " +
            "where h.id_obra_histvila=  ?1 " +
            "and h.id_personal_histvila= ?2 " +
            "and h.id_pervila_histvila= ?3 " +
            "and h.tipo_histvila='BONIP' " +
            "order by h.id_histvila desc) as hist on (pp.id_personal_perpuest = hist.id_personal_histvila and pp.id_obra_perpuest=hist.id_obra_histvila and pp.id_pervila_perpuest = hist.id_pervila_histvila) " +
            "where pp.id_obra_perpuest =  ?1 " +
            "and pp.id_personal_perpuest= ?2 " +
            "and pp.id_pervila_perpuest= ?3 " +
            "and pp.estado_perpuest = true " +
            "union " +
            "select sum(coalesce(hist.bonificacion_new_histvila, pc.bonificacion_cargo_percargo, 0)) as suma " +
            "from mo_personalcargo pc left join   " +
            "(select h.id_obra_histvila,h.id_personal_histvila,h.id_pervila_histvila, h.id_puesto_cargo_histvila, h.bonificacion_new_histvila " +
            "from mo_historico_vinculolaboral h  " +
            "left join (select hvl.id_obra_histvila, hvl.id_personal_histvila, hvl.id_pervila_histvila, hvl.id_puesto_cargo_histvila, max(date_format(hvl.fecha_cambio_histvila, '%Y%m%d')) as old_fecha " +
            "from mo_historico_vinculolaboral hvl where hvl.id_obra_histvila=  ?1  " +
            "and hvl.id_personal_histvila= ?2  " +
            "and hvl.id_pervila_histvila= ?3 " +
            "and hvl.tipo_histvila='BONIC' " +
            "group by hvl.id_obra_histvila, hvl.id_personal_histvila, hvl.id_pervila_histvila, hvl.id_puesto_cargo_histvila " +
            ") as t on (h.id_obra_histvila = t.id_obra_histvila and h.id_personal_histvila = t.id_personal_histvila and h.id_pervila_histvila=t.id_pervila_histvila  " +
            "and h.id_puesto_cargo_histvila = t.id_puesto_cargo_histvila and date_format(h.fecha_cambio_histvila, '%Y%m%d') = t.old_fecha) " +
            "where h.id_obra_histvila=  ?1 " +
            "and h.id_personal_histvila= ?2 " +
            "and h.id_pervila_histvila= ?3 " +
            "and h.tipo_histvila='BONIC' " +
            "order by h.id_histvila desc " +
            ") as hist on (pc.id_personal_percargo = hist.id_personal_histvila  " +
            "and pc.id_obra_percargo=hist.id_obra_histvila and pc.id_pervila_percargo = hist.id_pervila_histvila and pc.id_percargo = hist.id_puesto_cargo_histvila ) " +
            "where pc.id_obra_percargo =  ?1 " +
            "and pc.id_personal_percargo =  ?2 " +
            "and pc.id_pervila_percargo =  ?3 " +
            "and pc.estado_percargo = true " +
            ") as final " , nativeQuery = true)
    Double sumBonificacionPuestoyCargos(String idObraHistvila,
                                        Long idPersonalHistvila,
                                        Long idPervilaHistvila);

}
