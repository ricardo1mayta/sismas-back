package com.spring.sigmaweb.backend.process.generic.repository;

import com.spring.sigmaweb.backend.process.generic.model.Periodo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPeriodoDao extends CrudRepository<Periodo, Long> {

    public List<Periodo> findByIdObraPeriOrderByAnioPeriDesc(String idobraperi);

    public List<Periodo> findByIdObraPeriOrderByAnioPeriAsc(String idobraperi);

    public List<Periodo> findByIdObraPeriAndAnioPeriBetweenOrderByAnioPeriAsc(String idobraperi, Integer start, Integer end);

    public List<Periodo> findByIdObraPeriAndAnioPeriBetweenOrderByAnioPeriDesc(String idobraperi, Integer start, Integer end);

    public List<Periodo> findByIdObraPeriAndAnioPeri(String idobraperi, Integer anioperi);

    public Periodo findByIdPeriodoAndIdObraPeri( Long idperiodo, String idobraperi);


}
