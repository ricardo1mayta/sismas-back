package com.spring.sigmaweb.backend.process.generic.service;

import com.spring.sigmaweb.backend.process.generic.dto.EventosPeriodoDTO;
import com.spring.sigmaweb.backend.process.generic.model.EventosPeriodo;

import java.util.List;

public interface IEventosPeriodoService {
    public EventosPeriodo findByIdEventoAndIdObraEvent(Long idevento, String idobraevent);

    public List<EventosPeriodo> findByIdObraEventAndTipoEventAndIdPeriodoEvent(String idobraevent, Integer tipoEvent, Long idperiodo);

    public List<EventosPeriodoDTO> findByObraAndPeriodoAndAnioPeri(String idobra, Long idperiodo, String estadoevent, String tipoevent);

    public List<EventosPeriodoDTO> findByObraAndFlgEstadoEventAndTipoEvent(String idobra, String estadoevent, String tipoevent);

    public List<EventosPeriodo>fingByAnioAndTipoEvento(String idobra, Integer anio, String tipoEvent, String estado);

    public EventosPeriodo saveEvento(EventosPeriodo evento);

}
