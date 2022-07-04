package com.spring.sigmaweb.backend.process.generic.service;

import com.spring.sigmaweb.backend.process.generic.model.Periodo;

import java.util.List;

public interface IPeriodoService {

    public List<Periodo> findByidObraPeriOrderByAnioPeri( String orden, String idobraperi);

    public List<Periodo> findByAnioPeriBetweenOrderByAnioPeri(Integer start, Integer end, String idobraperi, String orden);

    public List<Periodo> findByidObraPeriAndAnioPeri(String idobraperi, Integer anioperi);

    public Periodo findByIdPeriodoAndIdObraPeri( Long idperiodo, String idobraperi);

    public Periodo savePeriodo(Periodo periodo);

}
