package com.spring.sigmaweb.backend.process.generic.service;

import com.spring.sigmaweb.backend.process.generic.dto.EventosPeriodoDTO;
import com.spring.sigmaweb.backend.process.generic.model.EventosPeriodo;
import com.spring.sigmaweb.backend.process.generic.repository.IEventosPeriodoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service

public class EventosPeriodoService implements IEventosPeriodoService{
    @Autowired
    private IEventosPeriodoDao eventosperiododao;

    @Override
    public EventosPeriodo findByIdEventoAndIdObraEvent(Long idevento, String idobraevent) {
        return eventosperiododao.findByIdEventoAndIdObraEvent(idevento, idobraevent);
    }

    @Override
    public List<EventosPeriodo> findByIdObraEventAndTipoEventAndIdPeriodoEvent(String idobraevent, Integer tipoEvent, Long idperiodo) {
        return eventosperiododao.findByIdObraEventAndTipoEventAndIdPeriodoEvent(idobraevent, tipoEvent, idperiodo);
    }

    @Override
    public List<EventosPeriodoDTO> findByObraAndPeriodoAndAnioPeri(String idobra, Long idperiodo, String estadoevent, String tipoevent) {
        String[] lista= tipoevent.split(",");
        Integer[] listaInt=new Integer[lista.length];
        for(int i = 0;i < lista.length;i++)
        {
            listaInt[i] = Integer.parseInt(lista[i]);
        }
        return eventosperiododao.findByObraAndPeriodoAndAnioPeri(idobra, idperiodo, estadoevent, listaInt);
    }

    @Override
    public List<EventosPeriodoDTO> findByObraAndFlgEstadoEventAndTipoEvent(String idobra, String estadoevent, String tipoevent) {
        String[] lista= tipoevent.split(",");
        Integer[] listaInt=new Integer[lista.length];
        for(int i = 0;i < lista.length;i++)
        {
            listaInt[i] = Integer.parseInt(lista[i]);
        }

        return eventosperiododao.findByObraAndFlgEstadoEventAndTipoEvent(idobra, estadoevent, listaInt);
    }

    @Override
    public List<EventosPeriodo> fingByAnioAndTipoEvento(String idobra, Integer anio, String tipoEvent, String estado) {
        String[] lista= tipoEvent.split(",");
        Integer[] listaInt=new Integer[lista.length];
        for(int i = 0;i < lista.length;i++)
        {
            listaInt[i] = Integer.parseInt(lista[i]);
        }

        return eventosperiododao.fingByAnioAndTipoEvento(idobra, anio, listaInt, estado);
    }

    @Override
    @Transactional
    public EventosPeriodo saveEvento(EventosPeriodo evento) {
        return eventosperiododao.save(evento);
    }
}
