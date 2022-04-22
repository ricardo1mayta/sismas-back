package com.spring.sigmaweb.backend.process.sintomatologia.repository;

import com.spring.sigmaweb.backend.process.legajo.model.Personal;
import com.spring.sigmaweb.backend.process.sintomatologia.dto.EnfermedadDTO;
import com.spring.sigmaweb.backend.process.sintomatologia.dto.SintomaDTO;
import com.spring.sigmaweb.backend.process.sintomatologia.model.FichaEnfermedad;
import com.spring.sigmaweb.backend.process.sintomatologia.model.FichaSintoma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IFichaSintomaDao extends JpaRepository<Personal,Long> {
    @Modifying
    @Query(value = "INSERT INTO ms_ficha_sintoma (id_ficha, id_sintoma) VALUES (:id_ficha, :id_sintoma)", nativeQuery = true)
    Integer registrar(@Param("id_ficha") Long id_ficha, @Param("id_sintoma") Long id_sintoma);

    @Query(value = "FROM FichaSintoma f where f.ficha.idFicha=:idFicha")
    List<FichaSintoma> listarSintomaPorFicha(@Param("idFicha") Long idFicha);

    @Query(value = "select new com.spring.sigmaweb.backend.process.sintomatologia.dto.SintomaDTO("
            + "f.sintoma.idSintoma ,"
            + "f.sintoma.descripcion,"
            + "true)"
            + " from  FichaSintoma  f where  f.ficha.idFicha=:idFicha")
    List<SintomaDTO> listarSintomaFicha(@Param("idFicha") Long idFicha);
}
