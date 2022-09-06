package com.spring.sigmaweb.backend.process.surveys.repository;

import com.spring.sigmaweb.backend.process.surveys.model.EncuestaDet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IEncuestaDetDao extends CrudRepository<EncuestaDet,Long> {

    public List<EncuestaDet> findByIdEncuestaEncdetAndIdObraEncdet(Long idencuestaencdet, String idobraencdet);

}
