package com.spring.sigmaweb.backend.process.tesoreria.egresos.repository;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.CajaGeneralDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.CajaGeneral;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.CajeroCaja;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CajaGeneralRepository extends IGenericRepo<CajaGeneral, Long>{

    CajaGeneral findByIdObraAndIdCajaAndIdUsuario(String idobra, Long idcaja, Long idusuario);

    CajaGeneral findByIdCajaGeneral(Long idCajaGeneral);

    @Query("select new com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.CajaGeneralDTO(" +
            "cg.idCajaGeneral, " +
            "o.idobra, " +
            "c as idCaja, " +
            "c.nombreCaja," +
            "u.idUser," +
            "(case when coalesce(pusu.idPersonal, -1) = -1 then u.emailUser else concat(coalesce(psnusu.apePaternoPers,''),' ', coalesce(psnusu.apeMaternoPers,''),' ', coalesce(psnusu.nombrePers, '')) end), " +

            "p.idPeriodo," +
            "p.anioPeri," +
            "psup.idPersonal," +
            "concat(coalesce(psnsup.apePaternoPers,''),' ', coalesce(psnsup.apeMaternoPers,''),' ', coalesce(psnsup.nombrePers, ''))," +

            "cg.aperturaSol," +
            "cg.aperturaDolar," +
            "cg.ingresoSol," +
            "cg.ingresoDolar," +
            "cg.ingresoPos1," +
            "cg.ingresoPos2," +
            "cg.engresoSol," +
            "cg.engresoDolar," +
            "cg.saldoSol," +
            "cg.saldoDolar," +
            "cg.diferenciaSol," +
            "cg.diferenciaDolar," +

            "cg.fechaApertura," +
            "cg.fechaCierre," +
            "cg.fechaDeposito," +
            "cg.rucBanco," +
            "cg.numCuentaSol," +
            "cg.numCuentaDolar," +
            "cg.numOperacionSol," +
            "cg.numOperacionDolar," +
            "cg.montoDepositoSol," +
            "cg.montoDepositoDolar," +
            "cg.flgTipoCajageneral," +
            "cg.idTipoCajageneral," +
            "cg.creapor," +
            "cg.fechaRegistro," +
            "cg.modificadoPor," +
            "cg.fechaActualiza" +
            ") " +
            "from CajaGeneral cg inner join Obra o on (cg.idObra = o.idobra) " +
            "inner join Caja c on (cg.idCaja = c.idCaja and o.idobra = c.idObra) " +
            "inner join Periodo p on (cg.idPeriodo = p.idPeriodo and o.idobra = p.idObraPeri) " +
            "inner join Personal psup on (cg.idSupervizor = psup.idPersonal and o.idobra = psup.obraPer) " +
            "inner join Persona psnsup on (psup.idPersona = psnsup.idPersona and o.idobra = psnsup.obraPers) " +
            "inner join Usuario u on (u.idUser = cg.idUsuario and o.idobra = u.obraUs) " +
            "left join Personal pusu on (u.idcodTipoUser = pusu.idPersonal and o.idobra = pusu.obraPer) " +
            "left join Persona psnusu on (pusu.idPersona = psnusu.idPersona and o.idobra = psnusu.obraPers) " +
            "where o.idobra = :idobra " +
            "and u.idUser = (case :idusuario when -1 then u.idUser else :idusuario end) " +
            "order by cg.fechaApertura desc"
            )
    List<CajaGeneralDTO> findByIdObraAndCajaAndUsuarioDTO(@Param("idobra") String idobra, @Param("idusuario") Long idusuario);

    @Query("select cg " +
            "from CajaGeneral cg inner join Obra o on (cg.idObra = o.idobra) " +
            "inner join CajeroCaja cc on (o.idobra = cc.idObra and cg.idUsuario = cc.idUsuario and cg.idCaja = cc.idCaja) " +
            "where cg.idObra = :idobra " +
            "and cg.idUsuario = :idusuario " +
            "and coalesce(cg.fechaCierre, '') = '' " +
            "order by cg.fechaApertura desc"
    )
    CajaGeneral findByCajaAperturadaAndObra(@Param("idobra") String idobra, @Param("idusuario") Long idusuario);

    @Query(value= "select cg.* " +
            "from mt_caja_general cg inner join mg_obras o on (cg.id_Obra = o.id_obra) " +
            "inner join mt_cajero_caja cc on (o.id_obra = cc.id_obra and cg.id_usuario = cc.id_usuario and cg.id_caja = cc.id_caja) " +
            "where cg.id_obra = :idobra " +
            "and cg.id_usuario = :idusuario " +
            "order by cg.fecha_apertura desc limit 1 "
    , nativeQuery = true)
    CajaGeneral findByEstadoCajaActualUsuario(@Param("idobra") String idobra, @Param("idusuario") Long idusuario);

    @Query("select cg " +
            "from CajaGeneral cg inner join Obra o on (cg.idObra = o.idobra) " +
            "where o.idobra = :idobra " +
            "and  CONVERT(DATE_FORMAT(cg.fechaApertura, '%Y%m%d'), SIGNED) >= :fecha " +
            "and cg.idCaja= :idcaja"
    )
    CajaGeneral findExistDateCajaGenObra(@Param("idobra") String idobra, @Param("fecha") Integer fecha, @Param("idcaja") Long idcaja);

    @Query("select new com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.CajaGeneralDTO(" +
            "cg.idCajaGeneral, " +
            "o.idobra, " +
            "c as idCaja, " +
            "c.nombreCaja," +
            "u.idUser," +
            "(case when coalesce(pusu.idPersonal, -1) = -1 then u.emailUser else concat(coalesce(psnusu.apePaternoPers,''),' ', coalesce(psnusu.apeMaternoPers,''),' ', coalesce(psnusu.nombrePers, '')) end), " +

            "p.idPeriodo," +
            "p.anioPeri," +
            "psup.idPersonal," +
            "concat(coalesce(psnsup.apePaternoPers,''),' ', coalesce(psnsup.apeMaternoPers,''),' ', coalesce(psnsup.nombrePers, ''))," +

            "cg.aperturaSol," +
            "cg.aperturaDolar," +
            "cg.ingresoSol," +
            "cg.ingresoDolar," +
            "cg.ingresoPos1," +
            "cg.ingresoPos2," +
            "cg.engresoSol," +
            "cg.engresoDolar," +
            "cg.saldoSol," +
            "cg.saldoDolar," +
            "cg.diferenciaSol," +
            "cg.diferenciaDolar," +

            "cg.fechaApertura," +
            "cg.fechaCierre," +
            "cg.fechaDeposito," +
            "cg.rucBanco," +
            "cg.numCuentaSol," +
            "cg.numCuentaDolar," +
            "cg.numOperacionSol," +
            "cg.numOperacionDolar," +
            "cg.montoDepositoSol," +
            "cg.montoDepositoDolar," +
            "cg.flgTipoCajageneral," +
            "cg.idTipoCajageneral," +
            "cg.creapor," +
            "cg.fechaRegistro," +
            "cg.modificadoPor," +
            "cg.fechaActualiza" +
            ") " +
            "from CajaGeneral cg inner join Obra o on (cg.idObra = o.idobra) " +
            "inner join Caja c on (cg.idCaja = c.idCaja and o.idobra = c.idObra) " +
            "inner join Periodo p on (cg.idPeriodo = p.idPeriodo and o.idobra = p.idObraPeri) " +
            "inner join Personal psup on (cg.idSupervizor = psup.idPersonal and o.idobra = psup.obraPer) " +
            "inner join Persona psnsup on (psup.idPersona = psnsup.idPersona and o.idobra = psnsup.obraPers) " +
            "inner join Usuario u on (u.idUser = cg.idUsuario and o.idobra = u.obraUs) " +
            "left join Personal pusu on (u.idcodTipoUser = pusu.idPersonal and o.idobra = pusu.obraPer) " +
            "left join Persona psnusu on (pusu.idPersona = psnusu.idPersona and o.idobra = psnusu.obraPers) " +
            "where o.idobra = :idobra " +
            "and u.idUser = :idusuario " +
            "and c.idCaja = :idcaja " +
            "and cg.idCajaGeneral = :idcajagen"
    )
    CajaGeneralDTO findByCajaActualDTO(@Param("idobra") String idobra, @Param("idusuario") Long idusuario, @Param("idcaja") Long idcaja, @Param("idcajagen") Long idCajaGeneral);

    @Query("select new com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.CajaGeneralDTO(" +
            "cg.idCajaGeneral, " +
            "o.idobra, " +
            "c as idCaja, " +
            "c.nombreCaja," +
            "u.idUser," +
            "(case when coalesce(pusu.idPersonal, -1) = -1 then u.emailUser else concat(coalesce(psnusu.apePaternoPers,''),' ', coalesce(psnusu.apeMaternoPers,''),' ', coalesce(psnusu.nombrePers, '')) end), " +

            "p.idPeriodo," +
            "p.anioPeri," +
            "psup.idPersonal," +
            "concat(coalesce(psnsup.apePaternoPers,''),' ', coalesce(psnsup.apeMaternoPers,''),' ', coalesce(psnsup.nombrePers, ''))," +

            "cg.aperturaSol," +
            "cg.aperturaDolar," +
            "cg.ingresoSol," +
            "cg.ingresoDolar," +
            "cg.ingresoPos1," +
            "cg.ingresoPos2," +
            "cg.engresoSol," +
            "cg.engresoDolar," +
            "cg.saldoSol," +
            "cg.saldoDolar," +
            "cg.diferenciaSol," +
            "cg.diferenciaDolar," +

            "cg.fechaApertura," +
            "cg.fechaCierre," +
            "cg.fechaDeposito," +
            "cg.rucBanco," +
            "cg.numCuentaSol," +
            "cg.numCuentaDolar," +
            "cg.numOperacionSol," +
            "cg.numOperacionDolar," +
            "cg.montoDepositoSol," +
            "cg.montoDepositoDolar," +
            "cg.flgTipoCajageneral," +
            "cg.idTipoCajageneral," +
            "cg.creapor," +
            "cg.fechaRegistro," +
            "cg.modificadoPor," +
            "cg.fechaActualiza" +
            ") " +
            "from CajaGeneral cg inner join Obra o on (cg.idObra = o.idobra) " +
            "inner join Caja c on (cg.idCaja = c.idCaja and o.idobra = c.idObra) " +
            "inner join Periodo p on (cg.idPeriodo = p.idPeriodo and o.idobra = p.idObraPeri) " +
            "inner join Personal psup on (cg.idSupervizor = psup.idPersonal and o.idobra = psup.obraPer) " +
            "inner join Persona psnsup on (psup.idPersona = psnsup.idPersona and o.idobra = psnsup.obraPers) " +
            "inner join Usuario u on (u.idUser = cg.idUsuario and o.idobra = u.obraUs) " +
            "inner join CajeroCaja cc on (o.idobra = cc.idObra and cg.idUsuario = cc.idUsuario and cg.idCaja = cc.idCaja) " +
            "left join Personal pusu on (u.idcodTipoUser = pusu.idPersonal and o.idobra = pusu.obraPer) " +
            "left join Persona psnusu on (pusu.idPersona = psnusu.idPersona and o.idobra = psnusu.obraPers) " +
            "where cg.idObra = :idobra " +
            "and cg.idUsuario = :idusuario " +
            "and coalesce(cg.fechaCierre, '') = '' " +
            "order by cg.fechaApertura desc"
    )
    CajaGeneralDTO findByCajaAperturadaAndObraDTO(@Param("idobra") String idobra, @Param("idusuario") Long idusuario);
}
/*


"from CajaGeneral cg inner join Obra o on (cg.idObra = o.idobra) " +
            "inner join CajeroCaja cc on (o.idobra = cc.idObra and cg.idUsuario = cc.idUsuario and cg.idCaja = cc.idCaja) " +
            "where cg.idObra = :idobra " +
            "and cg.idUsuario = :idusuario " +
            "and coalesce(cg.fechaCierre, '') = '' " +
            "order by cg.fechaApertura desc"
 */

