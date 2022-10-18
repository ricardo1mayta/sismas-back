package com.spring.sigmaweb.backend.process.legajo.repository;

import com.spring.sigmaweb.backend.process.legajo.dto.CargosDto;
import com.spring.sigmaweb.backend.process.legajo.model.Cargo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICargoDao extends CrudRepository<Cargo, Long> {
    public Cargo findByIdCargo(Long idcargo);

    public List<Cargo> findAllByOrderByNombreCar();

    @Query("select c " +
            "from Cargo c " +
            "where c.idTipoGoCar=?1 and c.estadoCar=?2 " +
            "and c.flgEsCargosectorCar = (case ?3 when 1 then true when 0 then false else c.flgEsCargosectorCar end) " +
            "order by c.nombreCar")
    public List<Cargo> findByIdTipoGoCarAndEstadoCarOrderByNombreCar(Integer Idtipogocar, Boolean estadocar, Integer flgescargosectorcar);

    @Query("select new com.spring.sigmaweb.backend.process.legajo.dto.CargosDto( c.idCargo," +
            "c.nombreCar," +
            "c.abreviadoCar," +
            "c.estadoCar," +
            "c.idTipoGoCar," +
            "t.descripTab as tipoGoCar," +
            "c.flgEsCargosectorCar," +
            "c.fechaIngCar," +
            "c.creaPorCar," +
            "c.fechaModiCar," +
            "c.modiPorCar) " +
            "from Cargo c left join TablasTabla t on (c.idTipoGoCar = t.codigoTab) " +
            "where c.estadoCar = ?1 " +
            "order by c.nombreCar"
            )
    public List<CargosDto> findCargosDto(Boolean estado);

}
