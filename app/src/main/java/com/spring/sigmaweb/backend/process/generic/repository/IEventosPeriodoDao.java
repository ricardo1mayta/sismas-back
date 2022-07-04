package com.spring.sigmaweb.backend.process.generic.repository;

import com.spring.sigmaweb.backend.process.generic.dto.EventosPeriodoDTO;
import com.spring.sigmaweb.backend.process.generic.model.EventosPeriodo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IEventosPeriodoDao extends CrudRepository<EventosPeriodo,Long> {
    public EventosPeriodo findByIdEventoAndIdObraEvent(Long idevento, String idobraevent);

    public List<EventosPeriodo> findAllByOrderByIdPeriodoEventAscFechaIniEventAsc();

    @Query("select new com.spring.sigmaweb.backend.process.generic.dto.EventosPeriodoDTO( " +
            "ep.idEvento," +
            "ep.idPeriodoEvent," +
            "p.anioPeri," +
            "o.idobra as idObraEvent," +
            "o.nombreobra," +
            "ep.tipoEvent," +
            "teven.descripTab as desctipoEvent," +
            "ep.nombreEvent," +
            "ep.descripcionEvent," +
            "ep.flgEstadoEvent," +
            "ep.fechaIniEvent," +
            "ep.fechaFinEvent," +
            "ep.fechaingEvent," +
            "ep.creaporEvent" +
            ") " +
            "from EventosPeriodo ep inner join Periodo p on (ep.idPeriodoEvent = p.idPeriodo) " +
            "inner join Obra o on (p.idObraPeri=o.idobra) " +
            "inner join TablasTabla teven on (ep.tipoEvent = teven.codigoTab and 401 = teven.tipoTab)" +
            "where p.idObraPeri = ?1 and p.idPeriodo=(case ?2 when -1 then p.idPeriodo else ?2 end) " +
            "and ep.flgEstadoEvent = (case ?3 when '_' then ep.flgEstadoEvent else ?3 end) " +
            "and teven.codigoTab in ?4 " +
            "order by ep.fechaIniEvent asc "
    )
    public List<EventosPeriodoDTO> findByObraAndPeriodoAndAnioPeri(String idobra, Long idperiodo, String estadoevent, Integer[] tipoevent);


}
