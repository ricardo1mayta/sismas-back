package com.spring.sigmaweb.backend.process.legajo.repository;


import com.spring.sigmaweb.backend.process.legajo.dto.PersonalCargosDTO;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalCargo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPersonalCargosDao extends CrudRepository<PersonalCargo, Long> {
    public PersonalCargo findByIdPercargo(Long idPercargo);

    @Query("select pc " +
            "from PersonalCargo pc inner join Personal p on (pc.idPersonalPercargo = p.idPersonal and pc.idObraPercargo = p.obraPer) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "where p.idPersonal=?1 and o.idobra = ?2 and pc.idPercargo= ?3"
    )
    public PersonalCargo findByPersonalAndObraAndIdCargo(Long idpersona, String idobra, Long idpercargo);

    @Query("select pc " +
            "from PersonalCargo pc inner join Personal p on (pc.idPersonalPercargo = p.idPersonal and pc.idObraPercargo = p.obraPer) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "where p.idPersonal=?1 and o.idobra = ?2"
    )
    public List<PersonalCargo> findByPersonalAndObraList(Long idpersona, String idobra);

    @Query("Select new com.spring.sigmaweb.backend.process.legajo.dto.PersonalCargosDTO(pc.idPercargo, " +
            "o.idobra as idObraPercargo, " +
            "p.idPersonal, " +
            "psn.apePaternoPers, " +
            "psn.apeMaternoPers, " +
            "psn.nombrePers, " +
            "car.idCargo as idCargoPercargo, " +
            "car.nombreCar as CargoPercargo, " +
            "tarea.codigoTab as idAreaPercont, " +
            "tarea.descripTab as AreaPercont, " +
            "tplanilla.codigoTab as idTipoNivelPlanillaPercargo, " +
            "tplanilla.descripTab as TipoNivelPlanillaPercargo, " +
            "pc.idPuestoPercargo, " +
            "'' as PuestoPercargo, " +
            "pc.flgCargoPrincipalPercargo, " +
            "pc.flgCargoDirectivoPercargo, " +
            "pc.flgCargoConfianzaPercargo, " +
            "pc.observacionesPercargo, " +
            "pc.estadoPercargo, " +
            "pc.bonifCargoPercargo, " +
            "pc.bonifCargoEstPercargo, " +
            "pc.fechaIniPercargo, " +
            "pc.fechaFinPercargo, " +
            "pc.fechaIngPercargo, " +
            "pc.creaPorPercargo, " +
            "pc.fechaModiPercargo, " +
            "pc.modiPorPercargo" +
            ") " +
            "from PersonalCargo pc inner join Personal p on (pc.idPersonalPercargo = p.idPersonal and pc.idObraPercargo = p.obraPer) " +
            "inner join Persona psn on (p.idPersona = psn.idPersona and p.obraPer=psn.obraPers) " +
            "inner join Cargo car on (pc.idCargoPercargo = car.idCargo) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "left join TablasTabla tarea on (pc.idAreaPercont = tarea.codigoTab and (case ?2 when 'SECTOR' then 306 else 305 end) = tarea.tipoTab) " +
            "left join TablasTabla tplanilla on (pc.idTipoNivelPlanillaPercargo = tplanilla.codigoTab and 302=tplanilla.tipoTab) " +
            "where p.idPersonal=?1 and o.idobra = ?2 and pc.idPercargo= ?3"
    )
    public PersonalCargosDTO findPersonalAndObraAndCargoDto(Long idpersona, String idobra, Long idpercargo);

    @Query("Select new com.spring.sigmaweb.backend.process.legajo.dto.PersonalCargosDTO(pc.idPercargo, " +
            "o.idobra as idObraPercargo, " +
            "p.idPersonal, " +
            "psn.apePaternoPers, " +
            "psn.apeMaternoPers, " +
            "psn.nombrePers, " +
            "car.idCargo as idCargoPercargo, " +
            "car.nombreCar as CargoPercargo, " +
            "tarea.codigoTab as idAreaPercont, " +
            "tarea.descripTab as AreaPercont, " +
            "tplanilla.codigoTab as idTipoNivelPlanillaPercargo, " +
            "tplanilla.descripTab as TipoNivelPlanillaPercargo, " +
            "pc.idPuestoPercargo, " +
            "'' as PuestoPercargo, " +
            "pc.flgCargoPrincipalPercargo, " +
            "pc.flgCargoDirectivoPercargo, " +
            "pc.flgCargoConfianzaPercargo, " +
            "pc.observacionesPercargo, " +
            "pc.estadoPercargo, " +
            "pc.bonifCargoPercargo, " +
            "pc.bonifCargoEstPercargo, " +
            "pc.fechaIniPercargo, " +
            "pc.fechaFinPercargo, " +
            "pc.fechaIngPercargo, " +
            "pc.creaPorPercargo, " +
            "pc.fechaModiPercargo, " +
            "pc.modiPorPercargo" +
            ") " +
            "from PersonalCargo pc inner join Personal p on (pc.idPersonalPercargo = p.idPersonal and pc.idObraPercargo = p.obraPer) " +
            "inner join Persona psn on (p.idPersona = psn.idPersona and p.obraPer=psn.obraPers) " +
            "inner join Cargo car on (pc.idCargoPercargo = car.idCargo) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "left join TablasTabla tarea on (pc.idAreaPercont = tarea.codigoTab and (case ?2 when 'SECTOR' then 306 else 305 end) = tarea.tipoTab) " +
            "left join TablasTabla tplanilla on (pc.idTipoNivelPlanillaPercargo = tplanilla.codigoTab and 302=tplanilla.tipoTab) " +
            "where p.idPersonal=?1 and o.idobra = ?2 "
    )
    public List<PersonalCargosDTO> findPersonalAndObraListDto(Long idpersona, String idobra);

}
