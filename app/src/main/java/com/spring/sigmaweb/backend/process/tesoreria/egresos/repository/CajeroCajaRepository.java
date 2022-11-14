package com.spring.sigmaweb.backend.process.tesoreria.egresos.repository;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.CajeroCajaDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.CajeroCaja;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CajeroCajaRepository extends IGenericRepo<CajeroCaja, String>{

    CajeroCaja findByIdObraAndIdCajaAndIdUsuario (String idobra, Long idcaja, Long idusuario);

    List<CajeroCaja> findByIdObraAndIdUsuario (String idobra, Long idusuario);

    List<CajeroCaja> findByIdObraAndIdCaja (String idobra, Long idCaja);

    @Query("select new com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.CajeroCajaDTO(" +
            "cc.idCajero_caja," +
            "o.idobra," +
            "c.idCaja," +
            "c.nombreCaja," +
            "c.flgEstado as flgEstadoCaja," +
            "u.idUser as idUsuario," +
            "u.username," +
            "psn.apePaternoPers as apePaternoUsuario," +
            "psn.apeMaternoPers as apeMaternoUsuario," +
            "psn.nombrePers as apeNombresUsuario," +
            "u.Activo as activoUsuario," +
            "cc.fechaInicio," +
            "cc.fechaFin," +
            "cc.flgEstado," +
            "cc.creapor," +
            "cc.fechaRegistro," +
            "cc.modificadoPor," +
            "cc.fechaActualiza" +
            ") " +
            "from CajeroCaja cc inner join Obra o on (cc.idObra = o.idobra) " +
            "inner join Caja c on (cc.idCaja = c.idCaja and o.idobra = c.idObra) " +
            "inner join Usuario u on (cc.idUsuario = u.idUser and o.idobra = u.obraUs) " +
            "left join Personal p on (u.idcodTipoUser = p.idPersonal and o.idobra = p.obraPer) " +
            "left join Persona psn on (p.idPersona = psn.idPersona and o.idobra = psn.obraPers) " +
            "where o.idobra = :idobra " +
            "and u.idUser = :idusuario"
    )
    List<CajeroCajaDTO> findByIdObraAndIdCajaAndIdUsuarioDTO (@Param("idobra") String idobra, @Param("idusuario")Long idusuario);

    @Query("select distinct new com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.CajeroCajaDTO(" +
            "cc.idCajero_caja," +
            "o.idobra," +
            "c.idCaja," +
            "c.nombreCaja," +
            "c.flgEstado as flgEstadoCaja," +
            "u.idUser as idUsuario," +
            "u.username," +
            "psn.apePaternoPers as apePaternoUsuario," +
            "psn.apeMaternoPers as apeMaternoUsuario," +
            "psn.nombrePers as apeNombresUsuario," +
            "u.Activo as activoUsuario," +
            "cc.fechaInicio," +
            "cc.fechaFin," +
            "cc.flgEstado," +
            "cc.creapor," +
            "cc.fechaRegistro," +
            "cc.modificadoPor," +
            "cc.fechaActualiza" +
            ") " +
            "from CajeroCaja cc inner join Obra o on (cc.idObra = o.idobra) " +
            "inner join Caja c on (cc.idCaja = c.idCaja and o.idobra = c.idObra) " +
            "inner join Usuario u on (cc.idUsuario = u.idUser and o.idobra = u.obraUs) " +
            "left join Personal p on (u.idcodTipoUser = p.idPersonal and o.idobra = p.obraPer) " +
            "left join Persona psn on (p.idPersona = psn.idPersona and o.idobra = psn.obraPers) " +
            "where o.idobra = :idobra "
    )
    List<CajeroCajaDTO> findByIdObraAndIdCajaAndIdUsuarioDistintDTO (@Param("idobra") String idobra);


}
