package com.spring.sigmaweb.backend.process.sintomatologia.repository;

import com.spring.sigmaweb.backend.process.sintomatologia.dto.EnfermedadDTO;
import com.spring.sigmaweb.backend.process.sintomatologia.model.Enfermedad;
import com.spring.sigmaweb.backend.process.sintomatologia.model.FichaEnfermedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IFichaEnfermedadDao extends JpaRepository<FichaEnfermedad, Long> {
    @Modifying
    @Query(value = "INSERT INTO ms_ficha_enfermedad (id_ficha, id_enfermedad) VALUES (:id_ficha, :id_enfermedad)", nativeQuery = true)
    Integer registrar(@Param("id_ficha") Long id_ficha, @Param("id_enfermedad") Long id_enfermedad);

    @Query(value = "FROM FichaEnfermedad f where f.ficha.idFicha=:idFicha")
    List<FichaEnfermedad> listarEnfermedadPorFicha(@Param("idFicha") Long idFicha);

    @Query(value = "select new com.spring.sigmaweb.backend.process.sintomatologia.dto.EnfermedadDTO("
            + "f.enfermedad.idEnfermedad ,"
            + "f.enfermedad.descripcion,"
            + "true)"
            + " from  FichaEnfermedad  f where  f.ficha.idFicha=:idFicha")
    List<EnfermedadDTO> listarEnfermedadDicha(@Param("idFicha") Long idFicha);
}
