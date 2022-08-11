package com.spring.sigmaweb.backend.process.sintomatologia.repository;

import com.spring.sigmaweb.backend.process.sintomatologia.dto.FichaSintomatologicaDTO;
import com.spring.sigmaweb.backend.process.sintomatologia.model.FichaExport;
import com.spring.sigmaweb.backend.process.sintomatologia.model.FichaSintomatologica;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface IFichaSintomatologicaDao extends JpaRepository<FichaSintomatologica,Long> {

    @Query("select new com.spring.sigmaweb.backend.process.sintomatologia.dto.FichaSintomatologicaDTO(p.idPersonal,"
            + " concat(ps.apePaternoPers ,' ',ps.apeMaternoPers,' ',ps.nombrePers),"
            + "	ps.nroDocPers,"
            + "	ps.emailCorPers,"
            + "	p.obraPer.idobra,"
            + "	ps.fechaNacPers,"
            + " ps.celularPers )"
            + " from Personal p "
//            + " inner join Obra o on (p.obraPer = o.idobra) "
            + " inner join Persona ps on (p.idPersona.idPersona = ps.idPersona) "
            + " where ps.nroDocPers = :numDoc "
            + " and p.obraPer.idobra like(:obraName) "
            + " and p.estadoPer=true")
    public List<FichaSintomatologicaDTO> findByDocPersonalFicha(@Param("numDoc") String numDoc, @Param("obraName") String obraName);

    @Query("select new com.spring.sigmaweb.backend.process.sintomatologia.dto.FichaSintomatologicaDTO(p.idPersonal,"
            + " concat(ps.apePaternoPers ,' ',ps.apeMaternoPers,' ',ps.nombrePers),"
            + "	ps.nroDocPers,"
            + "	ps.emailCorPers,"
            + "	p.obraPer.idobra,"
            + "	ps.fechaNacPers)"
            + " from Personal p "
//            + " inner join Obra o on (p.obraPer = o.idobra) "
            + " inner join Persona ps on (p.idPersona.idPersona = ps.idPersona) "
            + " where p.obraPer.idobra = :obraName ")
    public List<FichaSintomatologicaDTO> listPersonalFicha(@Param("obraName") String obraName);

    @Query("select new com.spring.sigmaweb.backend.process.sintomatologia.dto.FichaSintomatologicaDTO("
            + " f.idFicha,"
            + " f.personal.idPersonal,"
            + " concat(ps.apePaternoPers ,' ',ps.apeMaternoPers,' ',ps.nombrePers),"
            + "	ps.nroDocPers,"
            + "	f.email,"
            + "	f.telefono,"
            + "	f.edad,"
            + "	f.talla,"
            + "	f.peso,"
            + "	ps.obraPers,"
            + "	f.flagContactoCovid,"
            + "	f.observacion,"
            + "	f.fechaRegistro,"
            + "	ps.fechaNacPers)"
            + " from FichaSintomatologica f "
            + " inner join Persona ps on (f.personal.idPersona.idPersona = ps.idPersona) "
            + " where ps.nroDocPers = :numDoc "
            + " and f.idFicha= (SELECT MAX(fs.idFicha) from FichaSintomatologica fs where fs.personal.nroDocPer=:numDoc)")
    public FichaSintomatologicaDTO findByDocPersonalFichaDetalle(@Param("numDoc") String numDoc);

    @Query("select new com.spring.sigmaweb.backend.process.sintomatologia.dto.FichaSintomatologicaDTO("
            + " f.idFicha,"
            + " f.personal.idPersonal,"
            + " concat(ps.apePaternoPers ,' ',ps.apeMaternoPers,' ',ps.nombrePers),"
            + "	ps.nroDocPers,"
            + "	f.email,"
            + "	f.telefono,"
            + "	f.edad,"
            + "	f.talla,"
            + "	f.peso,"
            + "	ps.obraPers,"
            + "	f.flagContactoCovid,"
            + "	f.observacion,"
            + "	f.fechaRegistro,"
            + "	ps.fechaNacPers)"
            + " from FichaSintomatologica f "
            + " inner join Persona ps on (f.personal.idPersona.idPersona = ps.idPersona) "
            + " where date(f.fechaRegistro)=date(:fechaRegistro)  and  f.idObra=:idObra"
            + " and lower(concat(ps.apePaternoPers, ' ' ,ps.apeMaternoPers,' ',ps.nombrePers)) like lower(:name)")
    public List<FichaSintomatologicaDTO> findByNamePersonalFichaDetalle(@Param("name") String name,@Param("idObra")String idObra,@Param("fecha") Date fechaRegistro);

    @Query("select new com.spring.sigmaweb.backend.process.sintomatologia.dto.FichaSintomatologicaDTO("
            + " f.idFicha,"
            + " f.personal.idPersonal,"
            + " concat(ps.apePaternoPers ,' ',ps.apeMaternoPers,' ',ps.nombrePers),"
            + "	ps.nroDocPers,"
            + "	f.email,"
            + "	f.telefono,"
            + "	f.edad,"
            + "	f.talla,"
            + "	f.peso,"
            + "	ps.obraPers,"
            + "	f.flagContactoCovid,"
            + "	f.observacion,"
            + "	f.fechaRegistro,"
            + "	ps.fechaNacPers)"
            + " from FichaSintomatologica f "
            + " inner join Persona ps on (f.personal.idPersona.idPersona = ps.idPersona) "
            + " where f.idFicha= :idFicha")
    public FichaSintomatologicaDTO findByIdFichaDetalle(@Param("idFicha") Long idFicha);

    @Query("select new com.spring.sigmaweb.backend.process.sintomatologia.dto.FichaSintomatologicaDTO("
            + " f.idFicha,"
            + " f.personal.idPersonal,"
            + " concat(ps.apePaternoPers ,' ',ps.apeMaternoPers,' ',ps.nombrePers),"
            + "	ps.nroDocPers,"
            + "	f.email,"
            + "	f.telefono,"
            + "	f.edad,"
            + "	f.talla,"
            + "	f.peso,"
            + "	ps.obraPers,"
            + "	f.flagContactoCovid,"
            + "	f.observacion,"
            + "	f.fechaRegistro,"
            + "	ps.fechaNacPers)"
            + " from FichaSintomatologica f "
            + " inner join Persona ps on (f.personal.idPersona.idPersona = ps.idPersona) "
            + " where f.idObra=:obraName "
            + " and date(f.fechaRegistro)=date(:fechaRegistro)")
    public List<FichaSintomatologicaDTO> listFichaDetalle(@Param("obraName") String obraName,@Param("fechaRegistro") Date fechaRegistro);

    @Query("select new com.spring.sigmaweb.backend.process.sintomatologia.dto.FichaSintomatologicaDTO("
            + " f.idFicha,"
            + " f.personal.idPersonal,"
            + " concat(ps.apePaternoPers ,' ',ps.apeMaternoPers,' ',ps.nombrePers),"
            + "	ps.nroDocPers,"
            + "	f.email,"
            + "	f.telefono,"
            + "	f.edad,"
            + "	f.talla,"
            + "	f.peso,"
            + "	ps.obraPers,"
            + "	f.flagContactoCovid,"
            + "	f.observacion,"
            + "	f.fechaRegistro,"
            + "	ps.fechaNacPers)"
            + " from FichaSintomatologica f "
            + " inner join Persona ps on (f.personal.idPersona.idPersona = ps.idPersona) "
            + " where f.idObra=:obraName "
            + " and date(f.fechaRegistro)=date(:fechaRegistro)")
    public List<FichaSintomatologicaDTO> listFichaDetallePageable(@Param("obraName") String obraName,@Param("fechaRegistro") Date fechaRegistro);

    @Query("select new com.spring.sigmaweb.backend.process.sintomatologia.dto.FichaSintomatologicaDTO("
            + " f.idFicha,"
            + " f.personal.idPersonal,"
            + " concat(ps.apePaternoPers ,' ',ps.apeMaternoPers,' ',ps.nombrePers),"
            + "	ps.nroDocPers,"
            + "	f.email,"
            + "	f.telefono,"
            + "	f.edad,"
            + "	f.talla,"
            + "	f.peso,"
            + "	ps.obraPers,"
            + "	f.flagContactoCovid,"
            + "	f.observacion,"
            + "	f.fechaRegistro,"
            + "	ps.fechaNacPers)"
            + " from FichaSintomatologica f "
            + " inner join Persona ps on (f.personal.idPersona.idPersona = ps.idPersona) "
            + " where f.idObra=:obraName "
            + " and date(f.fechaRegistro)=date(:fechaRegistro)")
    public List<FichaSintomatologicaDTO> listMailNotification(@Param("obraName") String obraName,@Param("fechaRegistro") Date fechaRegistro);

    @Query("select new com.spring.sigmaweb.backend.process.sintomatologia.dto.FichaSintomatologicaDTO(p.idPersonal,"
            + " concat(ps.apePaternoPers ,' ',ps.apeMaternoPers,' ',ps.nombrePers),"
            + "	ps.nroDocPers,"
            + "	ps.emailCorPers,"
            + "	p.obraPer.idobra,"
            + "	ps.fechaNacPers)"
            + " from Personal p "
            + " inner join Persona ps on (p.idPersona.idPersona = ps.idPersona)"
            + " where p.obraPer.idobra=:obraName"
            + " and lower(concat(ps.apePaternoPers, ' ' ,ps.apeMaternoPers,' ',ps.nombrePers)) like lower(:name)")
    public Page<FichaSintomatologicaDTO> listPersonalObra(@Param("name") String name,@Param("obraName") String obraName, Pageable pageable);


    @Query("from FichaSintomatologica f where f.personal.nroDocPer=:numDoc  and date(f.fechaRegistro)=date(:fecha)")
    public FichaSintomatologica findFichaByDocByDay(@Param("numDoc") String numDoc,@Param("fecha") Date fecha);

    @Query("select new com.spring.sigmaweb.backend.process.sintomatologia.model.FichaExport("
            + " f.idFicha,"
            + " f.personal.idPersonal,"
            + " concat(ps.apePaternoPers ,' ',ps.apeMaternoPers,' ',ps.nombrePers),"
            + "	ps.nroDocPers,"
            + "	f.email,"
            + "	f.telefono,"
            + "	f.edad,"
            + "	f.talla,"
            + "	f.peso,"
            + "	ps.obraPers,"
            + "	f.flagContactoCovid,"
            + "	f.observacion,"
            + "	f.fechaRegistro,"
            + "	ps.fechaNacPers)"
            + " from FichaSintomatologica f "
            + " inner join Persona ps on (f.personal.idPersona.idPersona = ps.idPersona) "
            + " where f.idObra=:obraName "
            + " and date(f.fechaRegistro)=date(:fechaRegistro)")
    public List<FichaExport> listFichaDetalleExport(@Param("obraName") String obraName, @Param("fechaRegistro") Date fechaRegistro);

    @Query("select new com.spring.sigmaweb.backend.process.sintomatologia.model.FichaExport(p.idPersonal,"
            + " concat(ps.apePaternoPers ,' ',ps.apeMaternoPers,' ',ps.nombrePers),"
            + "	ps.nroDocPers,"
            + "	ps.emailCorPers,"
            + "	p.obraPer.idobra,"
            + "	ps.fechaNacPers)"
            + " from Personal p"
            + " inner join PersonalPuesto pp on (p.idPersonal = pp.idPersonalPerpuest.idPersonal)"
            + " inner join TablasTabla tt on (pp.idTipoNivelPlanillaPerpuest=tt.codigoTab)"
            + " inner join Persona ps on (p.idPersona.idPersona = ps.idPersona) "
            + " where p.obraPer.idobra =:obraName "
            + " and pp.idTipoNivelPlanillaPerpuest in (30301,30302)"
            + " and p.estadoPer=true and p.flgNotificacion = true")
    public List<FichaExport> personalforSector(@Param("obraName") String obraName);

    @Query("select new com.spring.sigmaweb.backend.process.sintomatologia.dto.FichaSintomatologicaDTO(p.idPersonal,"
            + " concat(ps.apePaternoPers ,' ',ps.apeMaternoPers,' ',ps.nombrePers),"
            + "	ps.nroDocPers,"
            + "	ps.emailCorPers,"
            + "	p.obraPer.idobra,"
            + "	ps.fechaNacPers)"
            + " from Personal p"
            + " inner join PersonalPuesto pp on (p.idPersonal = pp.idPersonalPerpuest.idPersonal)"
            + " inner join TablasTabla tt on (pp.idTipoNivelPlanillaPerpuest=tt.codigoTab)"
            + " inner join Persona ps on (p.idPersona.idPersona = ps.idPersona) "
            + " where p.obraPer.idobra =:obraName "
            + " and p.estadoPer=true"
            + " and pp.idTipoNivelPlanillaPerpuest in (30301,30302)"
            + "  and p.flgNotificacion = true")
    public List<FichaSintomatologicaDTO> personalforSectoNotification(@Param("obraName") String obraName);

}
