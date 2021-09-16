package com.spring.sigmaweb.backend.process.core.repository;

import com.spring.sigmaweb.backend.process.core.dto.RolSideNavItemActivosDTO;
import com.spring.sigmaweb.backend.process.core.dto.RolSideNavItemMenuOrderDTO;
import com.spring.sigmaweb.backend.process.core.model.RolSideNavItem;
import com.spring.sigmaweb.backend.process.core.model.SideNavItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IRolSideNavItemDao extends CrudRepository<RolSideNavItem, Long> {
    @Query("select Distinct new com.spring.sigmaweb.backend.process.core.dto.RolSideNavItemMenuOrderDTO ( substring(concat(convert( convert( concat("
            + " concat( (CASE WHEN coalesce(s5.position, 0) < 10 THEN '0' ELSE '' END), convert(coalesce( s5.position, 0), CHAR), 000) , "
            + " concat( (CASE WHEN coalesce(s4.position, 0) < 10 THEN '0' ELSE '' END), convert(coalesce( s4.position, 0), CHAR), 000) , "
            + " concat( (CASE WHEN coalesce(s3.position, 0) < 10 THEN '0' ELSE '' END), convert(coalesce( s3.position, 0), CHAR), 000) , "
            + "	concat( (CASE WHEN coalesce(s2.position, 0) < 10 THEN '0' ELSE '' END), convert(coalesce( s2.position, 0), CHAR), 000) , "
            + "	concat( (CASE WHEN coalesce(s.position, 0) < 10 THEN '0' ELSE '' END), convert(coalesce( s.position, 0), CHAR), 000) ) , signed), char ), '000000000000000'),1,15)  as ordenMenu, "
            + "(case when s5.idPadreItem is not null then 5 else ("
            + "	case when s4.idPadreItem is not null then 4 else ("
            + "	case when s3.idPadreItem is not null then 3 else ("
            + "	case when s2.idPadreItem is not null then 2 else ("
            + "	case when s.idPadreItem is not null then 1 else 0 end) end) end) end) end ) as nivelMenu, "
            + "s.idItem, "
            + "s.position, "
            + "m.idModulo, "
            + "s.name, "
            + "s.idPadreItem,"
            + "s.icon, "
            + "s.routeOrFunction, "
            + "s.pathMatchExact, "
            + "s.badge, "
            + "s.badgeColor, "
            + "s.type, "
            + "s.customClass) "
            + "from SideNavItem s inner join RolSideNavItem rs on (s.idItem = rs.idItem) "
            + "inner join Obra o on (rs.obraRolItem = o.idobra) "
            + "inner join Modulo m on (s.moduloItem = m.idModulo) "
            + "inner join Rol r on (r.idRol = rs.rolRolItem and r.idobraRol = o.idobra) "
            + "left join SideNavItem s2 on (s.idPadreItem = s2.idItem) "
            + "left join SideNavItem s3 on (s2.idPadreItem = s3.idItem) "
            + "left join SideNavItem s4 on (s3.idPadreItem = s4.idItem) "
            + "left join SideNavItem s5 on (s4.idPadreItem = s5.idItem) "
            + "where r.idRol in ?1 and o.idobra=?2 "
            + "order by 1"
    )
    public List<RolSideNavItemMenuOrderDTO> findByMenuPorRolAndObra(Long[] idrol, String idobra);

    @Query("select Distinct new com.spring.sigmaweb.backend.process.core.dto.RolSideNavItemMenuOrderDTO ( substring(concat(convert( convert( concat("
            + " concat( (CASE WHEN coalesce(s5.position, 0) < 10 THEN '0' ELSE '' END), convert(coalesce( s5.position, 0), CHAR), 000) , "
            + " concat( (CASE WHEN coalesce(s4.position, 0) < 10 THEN '0' ELSE '' END), convert(coalesce( s4.position, 0), CHAR), 000) , "
            + " concat( (CASE WHEN coalesce(s3.position, 0) < 10 THEN '0' ELSE '' END), convert(coalesce( s3.position, 0), CHAR), 000) , "
            + "	concat( (CASE WHEN coalesce(s2.position, 0) < 10 THEN '0' ELSE '' END), convert(coalesce( s2.position, 0), CHAR), 000) , "
            + "	concat( (CASE WHEN coalesce(s.position, 0) < 10 THEN '0' ELSE '' END), convert(coalesce( s.position, 0), CHAR), 000) ) , signed), char ), '000000000000000'),1,15)  as ordenMenu, "
            + "(case when s5.idPadreItem is not null then 5 else ("
            + "	case when s4.idPadreItem is not null then 4 else ("
            + "	case when s3.idPadreItem is not null then 3 else ("
            + "	case when s2.idPadreItem is not null then 2 else ("
            + "	case when s.idPadreItem is not null then 1 else 0 end) end) end) end) end ) as nivelMenu, "
            + "s.idItem, "
            + "s.position, "
            + "m.idModulo, "
            + "s.name, "
            + "s.idPadreItem,"
            + "s.icon, "
            + "s.routeOrFunction, "
            + "s.pathMatchExact, "
            + "s.badge, "
            + "s.badgeColor, "
            + "s.type, "
            + "s.customClass) "
            + "from SideNavItem s inner join Modulo m on (s.moduloItem = m.idModulo) "
            + "left join SideNavItem s2 on (s.idPadreItem = s2.idItem) "
            + "left join SideNavItem s3 on (s2.idPadreItem = s3.idItem) "
            + "left join SideNavItem s4 on (s3.idPadreItem = s4.idItem) "
            + "left join SideNavItem s5 on (s4.idPadreItem = s5.idItem) "
            + "WHERE coalesce(s.position, 0) <> 0"
            + "order by 1"
    )
    public List<RolSideNavItemMenuOrderDTO> findByMenuGeneral();
    //
    @Query("select new com.spring.sigmaweb.backend.process.core.dto.RolSideNavItemActivosDTO ( rs.idRolItem, "
            + "o.idobra, "
            + "r.idRol, "
            + "s.idItem, "
            + "m.idModulo, "
            + "s.name, "
            + "rs.flgActivoRolItem, "
            + "rs.flgLecturaRolItem, "
            + "rs.flgEscrituraRolItem, "
            + "rs.modiPorUltRolItem,"
            + "coalesce(s.routeOrFunction,'') as routeOrFunction ) "
            + "from SideNavItem s inner join RolSideNavItem rs on (s.idItem = rs.idItem) "
            + "inner join Obra o on (rs.obraRolItem = o.idobra) "
            + "inner join Modulo m on (s.moduloItem = m.idModulo) "
            + "inner join Rol r on (rs.rolRolItem = r.idRol and o.idobra = r.idobraRol) "
            + "where r.idRol in ?1 and o.idobra=?2 and coalesce(s.position, 0) <> 0 "
            + "order by 1"
    )
    public List<RolSideNavItemActivosDTO> findByMenuPorRolAndObraActivos(Long[] idrol, String idobra);

    @Query("select rs "
            + "from RolSideNavItem rs inner join Obra o on (rs.obraRolItem = o.idobra) "
            + "inner join Rol r on (r.idRol = rs.rolRolItem and r.idobraRol = o.idobra) "
            + "where r.idRol = ?1 and o.idobra = ?2"
    )
    public List<RolSideNavItem> findByIdRolAndIdObra(Long idrol, String idobra);

    @Query("select s "
            + "from SideNavItem s "
            + "inner join Modulo m on (s.moduloItem = m.idModulo) "
            + "where s.idItem = ?1 and s.obraItem= (case ?2 when '_' then s.obraItem else ?2 end)"
    )
    public SideNavItem findBysideNavItem(Long idItem, String idobra);
}
