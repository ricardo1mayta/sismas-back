package com.spring.sigmaweb.backend.process.tesoreria.egresos.repository;

import com.spring.sigmaweb.backend.process.core.dto.usuarioDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.CajeroCajaDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.CajeroCaja;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CajeroCajaRepository extends IGenericRepo<CajeroCaja, Long>{

    CajeroCaja findByIdObraAndIdCajeroCaja (String idobra, Long idCajeroCaja);

    CajeroCaja findByIdObraAndIdCajaAndIdUsuario (String idobra, Long idcaja, Long idusuario);

    List<CajeroCaja> findByIdObraAndIdUsuario (String idobra, Long idusuario);

    List<CajeroCaja> findByIdObraAndIdCaja (String idobra, Long idCaja);

    @Query("select new com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.CajeroCajaDTO(" +
            "cc.idCajeroCaja," +
            "o.idobra," +
            "c.idCaja," +
            "c.nombreCaja," +
            "c.flgEstado as flgEstadoCaja," +
            "u.idUser as idUsuario," +
            "u.username," +
            "u.emailUser as emailuser ," +
            "coalesce(psn.apePaternoPers,'') as apePaternoUsuario," +
            "coalesce(psn.apeMaternoPers,'') as apeMaternoUsuario," +
            "coalesce(psn.nombrePers,'') as apeNombresUsuario," +
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

    @Query("select new com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.CajeroCajaDTO(" +
            "cc.idCajeroCaja," +
            "o.idobra," +
            "c.idCaja," +
            "c.nombreCaja," +
            "c.flgEstado as flgEstadoCaja," +
            "u.idUser as idUsuario," +
            "u.username," +
            "u.emailUser as emailuser ," +
            "coalesce(psn.apePaternoPers,'') as apePaternoUsuario," +
            "coalesce(psn.apeMaternoPers,'') as apeMaternoUsuario," +
            "coalesce(psn.nombrePers,'') as nombresUsuario," +
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

    @Query("select new com.spring.sigmaweb.backend.process.core.dto.usuarioDTO(" +
            "u.idUser, " +
            "u.username, " +
            "u.password, " +
            "u.emailUser, " +
            "u.Activo, " +
            "u.tipoUser, " +
            "u.idcodTipoUser, " +
            "('') as roles," +
            "ps.apePaternoPers as apePaternoUser, " +
            "ps.apeMaternoPers as apeMaternoUser, " +
            "ps.nombrePers as nombresUser, " +
             "(case when coalesce(p.idPersonal, -1) != -1 then concat(coalesce(ps.apePaternoPers,''),' ',coalesce(ps.apeMaternoPers,''),' ',coalesce(ps.nombrePers,'')) else u.emailUser end) as nomComplUser " +
            ") " +
            "from Usuario u inner join Obra o on (u.obraUs = o.idobra) " +
            "join u.roles r " +
            "left join Personal p on (u.idcodTipoUser=p.idPersonal and p.obraPer = o.idobra and u.tipoUser='COLAB') " +
            "left join Persona ps on (p.idPersona = ps.idPersona and o.idobra = ps.obraPers) " +
            "left join CajeroCaja cc on (o.idobra = cc.idObra and u.idUser = cc.idUsuario) " +
            "where o.idobra = :idobra " +
            "and r.nombreRol = 'ROLE_CAJE' " +
            "and coalesce(cc.idCajeroCaja, '') = '' " +
            "and u.Activo = true " +
            "order by ps.apePaternoPers, ps.apeMaternoPers,ps.nombrePers"
    )
    List<usuarioDTO> findByIdObraSinCajaDTO (@Param("idobra") String idobra);

}
