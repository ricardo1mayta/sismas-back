package com.spring.sigmaweb.backend.process.sintomatologia.repository;

import com.spring.sigmaweb.backend.process.sintomatologia.model.Enfermedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IEnfermedadDao extends JpaRepository<Enfermedad, Long> {


}
