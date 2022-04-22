package com.spring.sigmaweb.backend.process.legajo.repository;

import com.spring.sigmaweb.backend.process.legajo.dto.PersonalPuestoDTO;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalCargo;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalPuesto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPersonalPuestoDao extends CrudRepository<PersonalPuesto, Long> {
    public PersonalPuesto findByIdPerpuest (Long idPerpuest);

    @Query("select pp " +
            "from PersonalPuesto pp inner join Obra o on (pp.idObraPerpuest = o.idobra) " +
            "inner join Personal p on (pp.idPersonalPerpuest = p.idPersonal and pp.idObraPerpuest = o.idobra) " +
            "inner join PersonalVidaLaboral pvl on (pp.idPervilaPerpuest = pvl.idPervila and o.idobra = pvl.idObraPervila) " +
            "where p.idPersonal=?1 and o.idobra = ?2 and pvl.idPervila = ?3 "
    )
    public List<PersonalPuesto> findByIdPersonalAndIdobraAndIdPervila(Long idpersona, String idobra, Long idpervila);

    @Query("select pp " +
            "from PersonalPuesto pp inner join Obra o on (pp.idObraPerpuest = o.idobra) " +
            "inner join Personal p on (pp.idPersonalPerpuest = p.idPersonal and pp.idObraPerpuest = o.idobra) " +
            "inner join PersonalVidaLaboral pvl on (pp.idPervilaPerpuest = pvl.idPervila and o.idobra = pvl.idObraPervila) " +
            "where p.idPersonal=?1 and o.idobra = ?2 and pvl.idPervila = ?3 and pp.idPerpuest=?4 "
    )
    public PersonalPuesto findByIdPersonalAndIdobraAndIdPervilaAndId(Long idpersona, String idobra, Long idpervila, Long idperpuesto);

    @Query("Select new com.spring.sigmaweb.backend.process.legajo.dto.PersonalPuestoDTO(pp.idPerpuest, " +
            "o.idobra as idObraPerpuest, " +
            "p.idPersonal, " +
            "pvl.idPervila, " +

            "pvl.fechaInicioPervila, " +
            "pvl.fechaFinPervila, " +
            "pvl.estadoPervila, " +
            "psn.apePaternoPers, " +
            "psn.apeMaternoPers, " +
            "psn.nombrePers, " +

            "pp.idPuestoTPerpuest as idPuestoTPerpuest, " +
            "pus.descripCargoTr as puestoTPerpuest, " +
            "tarea.codigoTab as idAreaPerpuest, " +
            "tarea.descripTab as AreaPerpuest, " +

            "tplanilla.codigoTab as idTipoNivelPlanillaPerpuest, " +
            "tplanilla.descripTab as TipoNivelPlanillaPerpuest, " +
            "pues.idPuesto as idPuestoPerpuest, " +
            "pues.nombrePues as PuestoPerpuest, " +

            "pp.flgPuestoDirePerpuest, " +
            "pp.flgPuestoConfiPerpuest, " +
            "pp.flgPuestoNofilcalPerpuest, " +
            "pp.flgPuestoNoAplicaPerpuest, " +
            "pp.observacionesPerpuest, " +
            "pp.estadoPerpuest, " +
            "pp.bonifCargoPerpuest, " +

            "pp.fechaIniPerpuest, " +
            "pp.fechaFinPerpuest, " +
            "pp.fechaIngPerpuest, " +
            "pp.creaPorPerpuest, " +
            "pp.fechaModiPerpuest, " +
            "pp.modiPorPerpuest" +
            ") " +
            "from PersonalPuesto pp inner join Personal p on (pp.idPersonalPerpuest = p.idPersonal and pp.idObraPerpuest = p.obraPer) " +
            "inner join Persona psn on (p.idPersona = psn.idPersona and p.obraPer=psn.obraPers) " +
            "inner join Puestos pues on (pp.idPuestoPerpuest = pues.idPuesto) " +
            "left join CargoTReg pus on (pp.idPuestoTPerpuest = pus.idCargoTr) " +
            "inner join PersonalVidaLaboral pvl on (pp.idPervilaPerpuest = pvl.idPervila and pp.idObraPerpuest = pvl.idObraPervila) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "left join TablasTabla tarea on (pp.idAreaPerpuest = tarea.codigoTab and 305 = tarea.tipoTab) " + //(case ?2 when 'SECTOR' then 306 else 305 end)
            "left join TablasTabla tplanilla on (pp.idTipoNivelPlanillaPerpuest = tplanilla.codigoTab and (case ?2 when 'SECTOR' then 303 else 302 end)=tplanilla.tipoTab) " +
            "where p.idPersonal=?1 and o.idobra = ?2 and pvl.idPervila=?3"
    )
    public List<PersonalPuestoDTO> findByObraPersonalVidaLab(Long idpersona, String idobra, Long idpervila);

    @Query("Select new com.spring.sigmaweb.backend.process.legajo.dto.PersonalPuestoDTO(pp.idPerpuest, " +
            "o.idobra as idObraPerpuest, " +
            "p.idPersonal, " +
            "pvl.idPervila, " +

            "pvl.fechaInicioPervila, " +
            "pvl.fechaFinPervila, " +
            "pvl.estadoPervila, " +
            "psn.apePaternoPers, " +
            "psn.apeMaternoPers, " +
            "psn.nombrePers, " +

            "pp.idPuestoTPerpuest as idPuestoTPerpuest, " +
            "pus.descripCargoTr as puestoTPerpuest, " +
            "tarea.codigoTab as idAreaPerpuest, " +
            "tarea.descripTab as AreaPerpuest, " +

            "tplanilla.codigoTab as idTipoNivelPlanillaPerpuest, " +
            "tplanilla.descripTab as TipoNivelPlanillaPerpuest, " +
            "pues.idPuesto as idPuestoPerpuest, " +
            "pues.nombrePues as PuestoPerpuest, " +

            "pp.flgPuestoDirePerpuest, " +
            "pp.flgPuestoConfiPerpuest, " +
            "pp.flgPuestoNofilcalPerpuest, " +
            "pp.flgPuestoNoAplicaPerpuest, " +
            "pp.observacionesPerpuest, " +
            "pp.estadoPerpuest, " +
            "pp.bonifCargoPerpuest, " +

            "pp.fechaIniPerpuest, " +
            "pp.fechaFinPerpuest, " +
            "pp.fechaIngPerpuest, " +
            "pp.creaPorPerpuest, " +
            "pp.fechaModiPerpuest, " +
            "pp.modiPorPerpuest" +
            ") " +
            "from PersonalPuesto pp inner join Personal p on (pp.idPersonalPerpuest = p.idPersonal and pp.idObraPerpuest = p.obraPer) " +
            "inner join Persona psn on (p.idPersona = psn.idPersona and p.obraPer=psn.obraPers) " +
            "inner join Puestos pues on (pp.idPuestoPerpuest = pues.idPuesto) " +
            "left join CargoTReg pus on (pp.idPuestoTPerpuest = pus.idCargoTr) " +
            "inner join PersonalVidaLaboral pvl on (pp.idPervilaPerpuest = pvl.idPervila and pp.idObraPerpuest = pvl.idObraPervila) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "left join TablasTabla tarea on (pp.idAreaPerpuest = tarea.codigoTab and 305 = tarea.tipoTab) " + //(case ?2 when 'SECTOR' then 306 else 305 end)
            "left join TablasTabla tplanilla on (pp.idTipoNivelPlanillaPerpuest = tplanilla.codigoTab and ((case ?2 when 'SECTOR' then 303 else 302 end))=tplanilla.tipoTab) " +
            "where p.idPersonal=?1 and o.idobra = ?2 and pvl.idPervila=?3 and pp.idPerpuest = ?4"
    )
    public PersonalPuestoDTO findByObraPersonalVidaLabId(Long idpersona, String idobra, Long idpervila, Long idperpuest);

}
