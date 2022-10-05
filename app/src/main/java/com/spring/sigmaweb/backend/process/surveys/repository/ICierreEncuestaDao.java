package com.spring.sigmaweb.backend.process.surveys.repository;

import com.spring.sigmaweb.backend.process.surveys.model.CierreEvaluacionDesemp;
import org.springframework.data.repository.CrudRepository;

public interface ICierreEncuestaDao extends CrudRepository<CierreEvaluacionDesemp,Long> {
    public CierreEvaluacionDesemp findByIdObraCierreevalAndIdEventoCierreeval( String idobra, Long idevento);

    


}
