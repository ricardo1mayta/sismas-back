package com.spring.sigmaweb.backend.process.legajo.repository;

import com.spring.sigmaweb.backend.process.legajo.dto.PuestosDto;
import com.spring.sigmaweb.backend.process.legajo.model.Puestos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPuestoDao extends CrudRepository<Puestos, Long> {
    public Puestos findByIdPuestoAndIdObraPues(Long idPuesto, String idObraPues);

    public Puestos findByCodigoPuesAndIdObraPues(String codigoPues, String idObraPues);

    @Query("select new com.spring.sigmaweb.backend.process.legajo.dto.PuestosDto (p.idPuesto," +
            "p.nombrePues," +
            "p.abreviadoPues," +
            "p.codigoPues," +
            "p.idObraPues," +
            "p.estadoPues," +
            "p.idTipoGoPues," +
            "t.descripTab as tipoGoPues," +
            "p.fechaIngPues," +
            "p.creaPorPues," +
            "p.fechaModiPues," +
            "p.modiPorPues" +
            ") " +
            "from Puestos p left join TablasTabla t on (p.idTipoGoPues = t.codigoTab) " +
            "where p.idObraPues = ?1 and p.estadoPues = ?2 " +
            "order by p.nombrePues"
    )
    public List<PuestosDto> findByIdObraPuesAndEstadoPues(String idObraPues, Boolean estadoPues);

    @Query("select new com.spring.sigmaweb.backend.process.legajo.dto.PuestosDto (p.idPuesto," +
            "p.nombrePues," +
            "p.abreviadoPues," +
            "p.codigoPues," +
            "p.idObraPues," +
            "p.estadoPues," +
            "p.idTipoGoPues," +
            "t.descripTab as tipoGoPues," +
            "p.fechaIngPues," +
            "p.creaPorPues," +
            "p.fechaModiPues," +
            "p.modiPorPues" +
            ") " +
            "from Puestos p left join TablasTabla t on (p.idTipoGoPues = t.codigoTab) " +
            "where p.idObraPues = ?1 " +
            "order by p.nombrePues"
    )
    public List<PuestosDto> findByIdObraPues(String idObraPues);
}
