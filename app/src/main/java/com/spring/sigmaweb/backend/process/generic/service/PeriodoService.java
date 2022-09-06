package com.spring.sigmaweb.backend.process.generic.service;

import com.spring.sigmaweb.backend.process.generic.model.Periodo;
import com.spring.sigmaweb.backend.process.generic.repository.IPeriodoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Period;
import java.util.List;

@Service
public class PeriodoService implements IPeriodoService {
    @Autowired
    private IPeriodoDao periododao;


    @Override
    public List<Periodo> findByidObraPeriOrderByAnioPeri(String orden, String idobraperi) {
        if(orden.equals("A")){
            return periododao.findByIdObraPeriOrderByAnioPeriAsc(idobraperi);
        } else {
            return periododao.findByIdObraPeriOrderByAnioPeriDesc(idobraperi);
        }
    }

    @Override
    public List<Periodo> findByAnioPeriBetweenOrderByAnioPeri(Integer start, Integer end, String idobraperi, String orden) {
        if(orden.equals("A")){
            return periododao.findByIdObraPeriAndAnioPeriBetweenOrderByAnioPeriAsc(idobraperi, start,end);
        } else {
            return periododao.findByIdObraPeriAndAnioPeriBetweenOrderByAnioPeriDesc(idobraperi, start, end);
        }
    }

    @Override
    public List<Periodo> findByidObraPeriAndAnioPeri(String idobraperi, Integer anioperi) {
        return periododao.findByIdObraPeriAndAnioPeri(idobraperi, anioperi);
    }

    @Override
    public Periodo findByIdPeriodoAndIdObraPeri(Long idperiodo, String idobraperi) {
        return periododao.findByIdPeriodoAndIdObraPeri(idperiodo, idobraperi);
    }

    @Override
    @Transactional
    public Periodo savePeriodo(Periodo periodo) {
        return periododao.save(periodo);
    }
}
