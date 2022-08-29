package com.spring.sigmaweb.backend.process.surveys.repository;

import com.spring.sigmaweb.backend.process.surveys.dto.MatrizEvaluacionDTO;
import com.spring.sigmaweb.backend.process.surveys.model.MatrizEvaluacion;
import com.spring.sigmaweb.backend.process.surveys.model.report.ListaEvaluadosEvaluador;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public interface IMatrizEvaluacionDao extends CrudRepository<MatrizEvaluacion, Long> {

    public MatrizEvaluacion findByIdObraMaevAndIdMatrizEvalAndIdPeriodoMaevAndIdEventoMaev(String idobra, Long idmatrizeval, Long Idperiodomaev, Long ideventomaev);

    @Query("select new com.spring.sigmaweb.backend.process.surveys.dto.MatrizEvaluacionDTO(" +
            "me.idMatrizEval," +
            "me.idObraMaev," +
            "me.idPeriodoMaev," +
            "p.anioPeri as anioPeriodoMaev," +
            "me.idEventoMaev," +
            "ep.nombreEvent as descripcionEventoMaev," +
            "me.idEvaluadorMaev," +
            "pevaluador.idPersonal as idPersonalEvaluadorMaev," +
            "psnevaluador.nombrePers as nombrePersEvaluador," +
            "psnevaluador.apePaternoPers as apePaternoPersEvaluador," +
            "psnevaluador.apeMaternoPers as apeMaternoPersEvaluador," +
            "TRIM( concat(COALESCE(concat(psnevaluador.apePaternoPers,' '), ''), COALESCE(concat(psnevaluador.apeMaternoPers, ' '), ''), COALESCE(psnevaluador.nombrePers, '')) )  as nomCompletoEvaluador," +
            "evaluador.idCargoPuestoPereval," +
            "(case evaluador.flgEsCargoprincipalPereval when true then ptoevaluador.nombrePues else cgoevaluador.nombreCar end) as nombreCargoMaevEvaluador," +
            "evaluador.flgEsCargoprincipalPereval as flgEsCargoprincipalEvaluador," +
            "evaluador.flgPrincipalEvalPereval as flgPrincipalEvalEvaluador," +
            "evaluador.idGrupoOcupacionalPereval as idTipoGoEvaluador," +
            "goevaluador.descripTab as descripcionTipoGoEvaluador," +
            "me.idEvaluadoMaev," +
            "pevaluado.idPersonal as idPersonalEvaluadoMaev," +
            "psnevaluado.nombrePers as nombrePersEvaluado," +
            "psnevaluado.apePaternoPers as apePaternoPersEvaluado," +
            "psnevaluado.apeMaternoPers as apeMaternoPersEvaluado," +
            "TRIM( concat(COALESCE(concat(psnevaluado.apePaternoPers,' '), ''), COALESCE(concat(psnevaluado.apeMaternoPers, ' '), ''), COALESCE(psnevaluado.nombrePers, '')) )  as nomCompletoEvaluado," +
            "evaluado.idCargoPuestoPereval," +
            "(case evaluado.flgEsCargoprincipalPereval when true then ptoevaluado.nombrePues else cgoevaluado.nombreCar end) as nombreCargoMaevEvaluado," +
            "evaluado.flgEsCargoprincipalPereval as flgEsCargoprincipalEvaluado," +
            "evaluado.flgPrincipalEvalPereval as flgPrincipalEvalEvaluado," +
            "evaluado.idGrupoOcupacionalPereval as idTipoGoEvaluado," +
            "goevaluado.descripTab as descripcionTipoGoEvaluado," +
            "me.estadoMaev," +
            "me.fechaingMaev," +
            "me.creaporMaev," +
            "me.fechamodiMaev," +
            "me.modiporMaev" +
            ") " +
            "from MatrizEvaluacion me inner join Obra o on (me.idObraMaev=o.idobra) " +
            "inner join PersonalEvaluacion evaluador on (me.idEvaluadorMaev = evaluador.idPereval and o.idobra = evaluador.idObraPereval and evaluador.flgExternoPereval= false) " +
            "inner join Personal pevaluador on (evaluador.idPersonalPereval = pevaluador.idPersonal and o.idobra = pevaluador.obraPer) " +
            "inner join Persona psnevaluador on (pevaluador.idPersona = psnevaluador.idPersona and o.idobra=psnevaluador.obraPers) " +
            "inner join PersonalEvaluacion evaluado on (me.idEvaluadoMaev = evaluado.idPereval and o.idobra = evaluado.idObraPereval and evaluado.flgExternoPereval= false) " +
            "inner join Personal pevaluado on (evaluado.idPersonalPereval = pevaluado.idPersonal and o.idobra = pevaluado.obraPer) " +
            "inner join Persona psnevaluado on (pevaluado.idPersona= psnevaluado.idPersona and o.idobra=psnevaluado.obraPers) " +
            "inner join TablasTabla goevaluador on (evaluador.idGrupoOcupacionalPereval = goevaluador.codigoTab) " +
            "inner join TablasTabla goevaluado on (evaluado.idGrupoOcupacionalPereval = goevaluado.codigoTab) " +
            "inner join Periodo p on (me.idPeriodoMaev = p.idPeriodo ) " +
            "inner join EventosPeriodo ep on (me.idEventoMaev = ep.idEvento and p.idPeriodo = ep.idPeriodoEvent) " + //and o.idobra=ep.idObraEvent
            "left join Puestos ptoevaluador on (evaluador.idCargoPuestoPereval = ptoevaluador.idPuesto and evaluador.flgEsCargoprincipalPereval = true) " +
            "left join Cargo cgoevaluador on (evaluador.idCargoPuestoPereval = cgoevaluador.idCargo and evaluador.flgEsCargoprincipalPereval = false) " +
            "left join Puestos ptoevaluado on (evaluado.idCargoPuestoPereval = ptoevaluado.idPuesto and evaluado.flgEsCargoprincipalPereval = true) " +
            "left join Cargo cgoevaluado on (evaluado.idCargoPuestoPereval = cgoevaluado.idCargo and evaluado.flgEsCargoprincipalPereval = false) " +
            "where o.idobra = ?1 " +
            "and pevaluador.idPersonal=?2 " +
            "and evaluador.idCargoPuestoPereval = ?3 " +
            "and evaluador.flgEsCargoprincipalPereval=?4 " +
            "and ep.idObraEvent = 'SECTOR' " +
            "and me.idEvaluadorMaev != me.idEvaluadoMaev " +
            "order by psnevaluador.apePaternoPers, psnevaluador.apeMaternoPers, psnevaluador.nombrePers "
    )
    public List<MatrizEvaluacionDTO> findListaByObraByPeriodoByEventoidByEvaluador(String idobra, Long idpersonal, Long idcargoPuesto, Boolean esPrincipal );

    @Query("select new com.spring.sigmaweb.backend.process.surveys.dto.MatrizEvaluacionDTO(" +
            "me.idMatrizEval," +
            "me.idObraMaev," +
            "me.idPeriodoMaev," +
            "p.anioPeri as anioPeriodoMaev," +
            "me.idEventoMaev," +
            "ep.nombreEvent as descripcionEventoMaev," +
            "me.idEvaluadorMaev," +
            "pevaluador.idPersonal as idPersonalEvaluadorMaev," +
            "psnevaluador.nombrePers as nombrePersEvaluador," +
            "psnevaluador.apePaternoPers as apePaternoPersEvaluador," +
            "psnevaluador.apeMaternoPers as apeMaternoPersEvaluador," +
            "TRIM( concat(COALESCE(concat(psnevaluador.apePaternoPers,' '), ''), COALESCE(concat(psnevaluador.apeMaternoPers, ' '), ''), COALESCE(psnevaluador.nombrePers, '')) )  as nomCompletoEvaluador," +
            "evaluador.idCargoPuestoPereval," +
            "(case evaluador.flgEsCargoprincipalPereval when true then ptoevaluador.nombrePues else cgoevaluador.nombreCar end) as nombreCargoMaevEvaluador," +
            "evaluador.flgEsCargoprincipalPereval as flgEsCargoprincipalEvaluador," +
            "evaluador.flgPrincipalEvalPereval as flgPrincipalEvalEvaluador," +
            "evaluador.idGrupoOcupacionalPereval as idTipoGoEvaluador," +
            "goevaluador.descripTab as descripcionTipoGoEvaluador," +
            "me.idEvaluadoMaev," +
            "pevaluado.idPersonal as idPersonalEvaluadoMaev," +
            "psnevaluado.nombrePers as nombrePersEvaluado," +
            "psnevaluado.apePaternoPers as apePaternoPersEvaluado," +
            "psnevaluado.apeMaternoPers as apeMaternoPersEvaluado," +
            "TRIM( concat(COALESCE(concat(psnevaluado.apePaternoPers,' '), ''), COALESCE(concat(psnevaluado.apeMaternoPers, ' '), ''), COALESCE(psnevaluado.nombrePers, '')) )  as nomCompletoEvaluado," +
            "evaluado.idCargoPuestoPereval," +
            "(case evaluado.flgEsCargoprincipalPereval when true then ptoevaluado.nombrePues else cgoevaluado.nombreCar end) as nombreCargoMaevEvaluado," +
            "evaluado.flgEsCargoprincipalPereval as flgEsCargoprincipalEvaluado," +
            "evaluado.flgPrincipalEvalPereval as flgPrincipalEvalEvaluado," +
            "evaluado.idGrupoOcupacionalPereval as idTipoGoEvaluado," +
            "goevaluado.descripTab as descripcionTipoGoEvaluado," +
            "me.estadoMaev," +
            "me.fechaingMaev," +
            "me.creaporMaev," +
            "me.fechamodiMaev," +
            "me.modiporMaev" +
            ") " +
            "from MatrizEvaluacion me inner join Obra o on (me.idObraMaev=o.idobra) " +
            "inner join PersonalEvaluacion evaluador on (me.idEvaluadorMaev = evaluador.idPereval and o.idobra = evaluador.idObraPereval and evaluador.flgExternoPereval= false) " +
            "inner join Personal pevaluador on (evaluador.idPersonalPereval = pevaluador.idPersonal and o.idobra = pevaluador.obraPer) " +
            "inner join Persona psnevaluador on (pevaluador.idPersona = psnevaluador.idPersona and o.idobra=psnevaluador.obraPers) " +
            "inner join PersonalEvaluacion evaluado on (me.idEvaluadoMaev = evaluado.idPereval and o.idobra = evaluado.idObraPereval and evaluado.flgExternoPereval= false) " +
            "inner join Personal pevaluado on (evaluado.idPersonalPereval = pevaluado.idPersonal and o.idobra = pevaluado.obraPer) " +
            "inner join Persona psnevaluado on (pevaluado.idPersona= psnevaluado.idPersona and o.idobra=psnevaluado.obraPers) " +
            "inner join TablasTabla goevaluador on (evaluador.idGrupoOcupacionalPereval = goevaluador.codigoTab) " +
            "inner join TablasTabla goevaluado on (evaluado.idGrupoOcupacionalPereval = goevaluado.codigoTab) " +
            "inner join Periodo p on (me.idPeriodoMaev = p.idPeriodo ) " +
            "inner join EventosPeriodo ep on (me.idEventoMaev = ep.idEvento and p.idPeriodo = ep.idPeriodoEvent) " + //and o.idobra=ep.idObraEvent
            "left join Puestos ptoevaluador on (evaluador.idCargoPuestoPereval = ptoevaluador.idPuesto and evaluador.flgEsCargoprincipalPereval = true) " +
            "left join Cargo cgoevaluador on (evaluador.idCargoPuestoPereval = cgoevaluador.idCargo and evaluador.flgEsCargoprincipalPereval = false) " +
            "left join Puestos ptoevaluado on (evaluado.idCargoPuestoPereval = ptoevaluado.idPuesto and evaluado.flgEsCargoprincipalPereval = true) " +
            "left join Cargo cgoevaluado on (evaluado.idCargoPuestoPereval = cgoevaluado.idCargo and evaluado.flgEsCargoprincipalPereval = false) " +
            "where o.idobra = ?1 " +
            "and pevaluado.idPersonal=?2 " +
            "and evaluado.idCargoPuestoPereval = ?3 " +
            "and evaluado.flgEsCargoprincipalPereval=?4 " +
            "and ep.idObraEvent = 'SECTOR' " +
            "and me.idEvaluadoMaev != me.idEvaluadorMaev " +
            "order by psnevaluado.apePaternoPers, psnevaluado.apeMaternoPers, psnevaluado.nombrePers"
    )
    public List<MatrizEvaluacionDTO> findListaByObraByPeriodoByEventoidByEvaluado(String idobra, Long idpersonal, Long idcargoPuesto, Boolean esPrincipal);

    @Query("select me " +
            "from MatrizEvaluacion me inner join Obra o on (me.idObraMaev=o.idobra) " +
            "inner join PersonalEvaluacion evaluador on (me.idEvaluadorMaev = evaluador.idPereval and o.idobra = evaluador.idObraPereval) " +
            "inner join Personal pevaluador on (evaluador.idPersonalPereval = pevaluador.idPersonal and o.idobra = pevaluador.obraPer) " +
            "inner join PersonalEvaluacion evaluado on (me.idEvaluadoMaev = evaluado.idPereval and o.idobra = evaluado.idObraPereval) " +
            "inner join Personal pevaluado on (evaluado.idPersonalPereval = pevaluado.idPersonal and o.idobra = pevaluado.obraPer) " +
            "where o.idobra = ?1 and pevaluador.idPersonal=?2 and pevaluado.idPersonal=?3"
    )
    public List<MatrizEvaluacion> contarEvaluadoresEvaluado (String idobra, Long idevaluador, Long idevaluado);

    //REPORTES PARA EVALUACION DE DESEMPEÑO
    @Query("select new com.spring.sigmaweb.backend.process.surveys.dto.MatrizEvaluacionDTO(" +
            "me.idMatrizEval," +
            "me.idObraMaev," +
            "me.idPeriodoMaev," +
            "p.anioPeri as anioPeriodoMaev," +
            "me.idEventoMaev," +
            "ep.nombreEvent as descripcionEventoMaev," +
            "me.idEvaluadorMaev," +
            "pevaluador.idPersonal as idPersonalEvaluadorMaev," +
            "psnevaluador.nombrePers as nombrePersEvaluador," +
            "psnevaluador.apePaternoPers as apePaternoPersEvaluador," +
            "psnevaluador.apeMaternoPers as apeMaternoPersEvaluador," +
            "TRIM( concat(COALESCE(concat(psnevaluador.apePaternoPers,' '), ''), COALESCE(concat(psnevaluador.apeMaternoPers, ' '), ''), COALESCE(psnevaluador.nombrePers, '')) )  as nomCompletoEvaluador," +
            "evaluador.idCargoPuestoPereval," +
            "(case evaluador.flgEsCargoprincipalPereval when true then ptoevaluador.nombrePues else cgoevaluador.nombreCar end) as nombreCargoMaevEvaluador," +
            "evaluador.flgEsCargoprincipalPereval as flgEsCargoprincipalEvaluador," +
            "evaluador.flgPrincipalEvalPereval as flgPrincipalEvalEvaluador," +
            "evaluador.idGrupoOcupacionalPereval as idTipoGoEvaluador," +
            "goevaluador.descripTab as descripcionTipoGoEvaluador," +
            "me.idEvaluadoMaev," +
            "pevaluado.idPersonal as idPersonalEvaluadoMaev," +
            "psnevaluado.nombrePers as nombrePersEvaluado," +
            "psnevaluado.apePaternoPers as apePaternoPersEvaluado," +
            "psnevaluado.apeMaternoPers as apeMaternoPersEvaluado," +
            "TRIM( concat(COALESCE(concat(psnevaluado.apePaternoPers,' '), ''), COALESCE(concat(psnevaluado.apeMaternoPers, ' '), ''), COALESCE(psnevaluado.nombrePers, '')) )  as nomCompletoEvaluado," +
            "evaluado.idCargoPuestoPereval," +
            "(case evaluado.flgEsCargoprincipalPereval when true then ptoevaluado.nombrePues else cgoevaluado.nombreCar end) as nombreCargoMaevEvaluado," +
            "evaluado.flgEsCargoprincipalPereval as flgEsCargoprincipalEvaluado," +
            "evaluado.flgPrincipalEvalPereval as flgPrincipalEvalEvaluado," +
            "evaluado.idGrupoOcupacionalPereval as idTipoGoEvaluado," +
            "goevaluado.descripTab as descripcionTipoGoEvaluado," +
            "me.estadoMaev," +
            "me.fechaingMaev," +
            "me.creaporMaev," +
            "me.fechamodiMaev," +
            "me.modiporMaev" +
            ") " +
            "from MatrizEvaluacion me inner join Obra o on (me.idObraMaev=o.idobra) " +
            "inner join PersonalEvaluacion evaluador on (me.idEvaluadorMaev = evaluador.idPereval and o.idobra = evaluador.idObraPereval) " +
            "inner join Personal pevaluador on (evaluador.idPersonalPereval = pevaluador.idPersonal and o.idobra = pevaluador.obraPer) " +
            "inner join Persona psnevaluador on (pevaluador.idPersona = psnevaluador.idPersona and o.idobra=psnevaluador.obraPers) " +
            "inner join PersonalEvaluacion evaluado on (me.idEvaluadoMaev = evaluado.idPereval and o.idobra = evaluado.idObraPereval) " +
            "inner join Personal pevaluado on (evaluado.idPersonalPereval = pevaluado.idPersonal and o.idobra = pevaluado.obraPer) " +
            "inner join Persona psnevaluado on (pevaluado.idPersona= psnevaluado.idPersona and o.idobra=psnevaluado.obraPers) " +
            "inner join TablasTabla goevaluador on (evaluador.idGrupoOcupacionalPereval = goevaluador.codigoTab) " +
            "inner join TablasTabla goevaluado on (evaluado.idGrupoOcupacionalPereval = goevaluado.codigoTab) " +
            "inner join Periodo p on (me.idPeriodoMaev = p.idPeriodo ) " +
            "inner join EventosPeriodo ep on (me.idEventoMaev = ep.idEvento  and p.idPeriodo = ep.idPeriodoEvent) " + //and o.idobra=ep.idObraEvent
            "left join Puestos ptoevaluador on (evaluador.idCargoPuestoPereval = ptoevaluador.idPuesto and evaluador.flgEsCargoprincipalPereval = true) " +
            "left join Cargo cgoevaluador on (evaluador.idCargoPuestoPereval = cgoevaluador.idCargo and evaluador.flgEsCargoprincipalPereval = false) " +
            "left join Puestos ptoevaluado on (evaluado.idCargoPuestoPereval = ptoevaluado.idPuesto and evaluado.flgEsCargoprincipalPereval = true) " +
            "left join Cargo cgoevaluado on (evaluado.idCargoPuestoPereval = cgoevaluado.idCargo and evaluado.flgEsCargoprincipalPereval = false) " +
            "where o.idobra = ?1 " +
            "and pevaluado.idPersonal= (case ?2 when 'EVALUADO' then (case ?3 when 0 then pevaluado.idPersonal else ?3 end) else pevaluado.idPersonal end) " +
            "and pevaluador.idPersonal= (case ?2 when 'EVALUADOR' then (case ?3 when 0 then pevaluador.idPersonal else ?3 end) else pevaluador.idPersonal end) " +
            "and evaluado.idCargoPuestoPereval = (case ?2 when 'EVALUADO' then (case ?4 when 0 then evaluado.idCargoPuestoPereval else ?4 end) else evaluado.idCargoPuestoPereval end) " +
            "and evaluador.idCargoPuestoPereval = (case ?2 when 'EVALUADOR' then (case ?4 when 0 then evaluador.idCargoPuestoPereval else ?4 end ) else evaluador.idCargoPuestoPereval end) " +
            "and evaluado.flgEsCargoprincipalPereval= (case ?2 when 'EVALUADO' then (case ?5 when 3 then evaluado.flgEsCargoprincipalPereval else ?5 end ) else evaluado.flgEsCargoprincipalPereval end) " +
            "and evaluador.flgEsCargoprincipalPereval= (case ?2 when 'EVALUADOR' then (case ?5 when 3 then evaluador.flgEsCargoprincipalPereval else ?5 end ) else evaluador.flgEsCargoprincipalPereval end) " +
            "and me.idPeriodoMaev = ?6 " +
            "and ep.idObraEvent = 'SECTOR'"
    )
    public List<MatrizEvaluacionDTO> reportEvaluadoEvaluador(String idobra, String tipo, Long idpersonal, Long idcargoPuesto, Integer esPrincipal, Long idperiodo, Sort sort);

    //valida si ya esta registrada la matriz de auto evaluación
    @Query("select new com.spring.sigmaweb.backend.process.surveys.model.report.ListaEvaluadosEvaluador ( pevaluado.idPersonal as id," +
            "pevaluado.idPersonal as id_persona, " +
            "enc.idEncuesta as id_encuesta, " +
            "me.idMatrizEval as id_matrizeval, " +
            "psnevaluado.apePaternoPers as ape_paterno_pers, " +
            "psnevaluado.apeMaternoPers as ape_materno_pers, " +
            "psnevaluado.nombrePers as nombre_pers, " +
            "TRIM( concat(COALESCE(concat(psnevaluado.apePaternoPers,' '), ''), COALESCE(concat(psnevaluado.apeMaternoPers, ' '), ''), COALESCE(psnevaluado.nombrePers, '')) )  as nomCompleto, " +
            "pevaluado.codigoPer as codigo_per, " +
            "(case evaluado.flgEsCargoprincipalPereval when true then ptoevaluado.nombrePues else cgoevaluado.nombreCar end) as cargo," +
            "evaluado.idCargoPuestoPereval as id_cargopuesto_pereval," +
            "evaluado.flgEsCargoprincipalPereval as flg_es_cargoprincipal_pereval," +
            "evaluado.flgPrincipalEvalPereval as flg_principal_eval_pereval," +
            "evaluado.idGrupoOcupacionalPereval as id_grupo_ocupacional_pereval, " +
            "me.idEventoMaev as id_evento_maev, " +
            "(case enc.flgEstadoEncuesta when 'R' then 'PENDIENTE' when 'P' then 'PROCESO' when 'F' then 'REALIZADO' else '<< ? >>' end) as estado " +
            ") " +
            "from MatrizEvaluacion me inner join Obra o on (me.idObraMaev=o.idobra) " +
            "inner join PersonalEvaluacion evaluado on (me.idEvaluadorMaev = evaluado.idPereval and o.idobra = evaluado.idObraPereval) " +
            "inner join Personal pevaluado on (evaluado.idPersonalPereval = pevaluado.idPersonal and o.idobra = pevaluado.obraPer) " +
            "inner join Persona psnevaluado on (pevaluado.idPersona= psnevaluado.idPersona and o.idobra=psnevaluado.obraPers) " +
            "inner join Encuesta enc on ( me.idMatrizEval = enc.idMatrizevalEncuesta and me.idObraMaev = enc.idObraEncuesta) " +
            "left join Puestos ptoevaluado on (evaluado.idCargoPuestoPereval = ptoevaluado.idPuesto and evaluado.flgEsCargoprincipalPereval = true) " +
            "left join Cargo cgoevaluado on (evaluado.idCargoPuestoPereval = cgoevaluado.idCargo and evaluado.flgEsCargoprincipalPereval = false) " +
            "where o.idobra = ?1 and pevaluado.idPersonal=?2 and me.idEvaluadorMaev = me.idEvaluadoMaev " +
            "and me.idEventoMaev = ?3 ")
    public ListaEvaluadosEvaluador findByAutoevaluación(String idobra, Long idpersonal,  Long idevento);

}
