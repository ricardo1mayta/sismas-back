package com.spring.sigmaweb.backend.process.generic.service;

import com.spring.sigmaweb.backend.process.generic.dto.EventosPeriodoDTO;
import com.spring.sigmaweb.backend.process.generic.model.EventosPeriodo;

import java.util.List;

public interface IEventosPeriodoService {
    public EventosPeriodo findByIdEventoAndIdObraEvent(Long idevento, String idobraevent);

    public List<EventosPeriodoDTO> findByObraAndPeriodoAndAnioPeri(String idobra, Long idperiodo, String estadoevent, String tipoevent);

    public EventosPeriodo saveEvento(EventosPeriodo evento);
}
