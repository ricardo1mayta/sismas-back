package com.spring.sigmaweb.backend.process.legajo.repository;


import com.spring.sigmaweb.backend.process.legajo.dto.JornadaPersonalContratoDTO;

import com.spring.sigmaweb.backend.process.legajo.model.PersonalContratoJornada;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IJornadaContratoDao extends CrudRepository<PersonalContratoJornada, Long> {
    public PersonalContratoJornada findByIdPerjorn(Long idPerjorn);

    @Query("select pcj " +
            "from PersonalContratoJornada pcj inner join PersonalContrato pc on (pcj.idPersonalContPerjorn = pc.idPerCont and pcj.idObraPerjorn = pc.idObraPercont) " +
                "inner join Personal p on (pc.idPersonalPercont = p.idPersonal and pc.idObraPercont = p.obraPer) " +
                "inner join Obra o on (p.obraPer = o.idobra) " +
            "where p.idPersonal=?1 and o.idobra = ?2 and pc.idPerCont= ?3 and pcj.idPerjorn =?4 "
    )
    public PersonalContratoJornada findByJornadaPersonalAndObraAndcontrato(Long idpersona, String idobra, Long idpercont, Long idperjorn);

    @Query("select pcj " +
            "from PersonalContratoJornada pcj inner join PersonalContrato pc on (pcj.idPersonalContPerjorn = pc.idPerCont and pcj.idObraPerjorn = pc.idObraPercont) " +
            "inner join Personal p on (pc.idPersonalPercont = p.idPersonal and pc.idObraPercont = p.obraPer) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "where p.idPersonal=?1 and o.idobra = ?2 and pc.idPerCont= ?3  "
    )
    public List<PersonalContratoJornada> findByJornadaPersonalAndObraAndcontratoList(Long idpersona, String idobra, Long idpercont);

    @Query("select new com.spring.sigmaweb.backend.process.legajo.dto.JornadaPersonalContratoDTO(pc.idPerCont, " +
            "pcj.idPerjorn, " +
            "o.idobra as idObraPerjorn," +
            "p.idPersonal, " +
            "psn.apePaternoPers, " +
            "psn.apeMaternoPers, " +
            "psn.nombrePers, " +

            "pcj.idDiaPerJorn, " +
            "pcj.diaInihorPerjorn, " +
            "pcj.diaFinhorPerjorn, " +
            "pcj.tipoDiaPerjorn, " +

            "pcj.fechaIngPerjorn," +
            "pcj.creaPorPerjorn," +
            "pcj.fechaModiPerjorn," +
            "pcj.modiPorPerjorn " +
            ") " +
            "from PersonalContratoJornada pcj inner join PersonalContrato pc on (pcj.idPersonalContPerjorn = pc.idPerCont and pcj.idObraPerjorn = pc.idObraPercont) " +
            "inner join Personal p on (pc.idPersonalPercont = p.idPersonal and pc.idObraPercont = p.obraPer) " +
            "inner join Persona psn on (p.idPersona = psn.idPersona) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "where p.idPersonal=?1 and o.idobra = ?2 and pc.idPerCont= ?3 and pcj.idPerjorn =?4 ")
    public JornadaPersonalContratoDTO findIdJornadaPersonalAndObraAndContratoDTO(Long idpersona, String idobra, Long idpercont, Long idperjorn);


    @Query("select new com.spring.sigmaweb.backend.process.legajo.dto.JornadaPersonalContratoDTO(pc.idPerCont, " +
            "pcj.idPerjorn, " +
            "o.idobra as idObraPerjorn," +
            "p.idPersonal, " +
            "psn.apePaternoPers, " +
            "psn.apeMaternoPers, " +
            "psn.nombrePers, " +

            "pcj.idDiaPerJorn, " +
            "pcj.diaInihorPerjorn, " +
            "pcj.diaFinhorPerjorn, " +
            "pcj.tipoDiaPerjorn, " +

            "pcj.fechaIngPerjorn," +
            "pcj.creaPorPerjorn," +
            "pcj.fechaModiPerjorn," +
            "pcj.modiPorPerjorn " +
            ") " +
            "from PersonalContratoJornada pcj inner join PersonalContrato pc on (pcj.idPersonalContPerjorn = pc.idPerCont and pcj.idObraPerjorn = pc.idObraPercont) " +
            "inner join Personal p on (pc.idPersonalPercont = p.idPersonal and pc.idObraPercont = p.obraPer) " +
            "inner join Persona psn on (p.idPersona = psn.idPersona) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "where p.idPersonal=?1 and o.idobra = ?2 and pc.idPerCont= ?3 ")
    public List<JornadaPersonalContratoDTO> findJornadasPersonalAndObraAndContratoDTOList(Long idpersona, String idobra, Long idpercont);




}
