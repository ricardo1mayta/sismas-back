package com.spring.sigmaweb.backend.process.core.repository;

import com.spring.sigmaweb.backend.process.core.dto.usuarioDTO;
import com.spring.sigmaweb.backend.process.core.model.Rol;
import com.spring.sigmaweb.backend.process.core.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUsuarioDao extends CrudRepository<Usuario,Long> {
    @Query("select u "
            + "from Usuario u inner join Obra o on u.obraUs = o.idobra "
            + "where u.username=?1 and u.Activo = true")
    public Usuario findByUsernameActivo(String username);

    public Usuario findByUsername(String username);

    public Usuario findByIdUser(Long idUser);

    @Query("select u "
            + "from Usuario u inner join Obra o on u.obraUs = o.idobra "
            + "where o.idobra=?1 and u.idcodTipoUser=?2 and u.tipoUser=?3")
    public Usuario findByObraAndCoduserAndTipouser(String obra, Long coduser, String tipouser);

    @Query("select u "
            + "from Usuario u inner join Obra o on u.obraUs = o.idobra "
            + "where u.username=?1 and o.idobra=?2")
    public Usuario findByUsernameAndObra(String username, String obra);

    @Query("select new com.spring.sigmaweb.backend.process.core.dto.usuarioDTO ( u.idUser, "
            + "u.username,"
            + "u.password,"
            + "u.emailUser,"
            + "u.Activo, "
            + "u.tipoUser, "
            + "u.idcodTipoUser, "
            + "('') as roles,"
            + "ps.apePaternoPers as apePaternoUser,"
            + "ps.apeMaternoPers as apeMaternoUser,"
            + "ps.nombrePers as nombresUser, "
            + "('') as nomComplUser) "
            + "from Usuario u inner join Obra o on (u.obraUs = o.idobra) "
            + "left join Personal p on (u.idcodTipoUser=p.idPersonal and p.obraPer = o.idobra and u.tipoUser='COLAB') "
            + "left join Persona ps on (p.idPersona = ps.idPersona) "
            + "where o.idobra=?1 " +
            " and u.idUser = ?2")
    public usuarioDTO findByObraAndIdUserDTO(String obraname, Long iduser);

    @Query("select new com.spring.sigmaweb.backend.process.core.dto.usuarioDTO ( u.idUser, "
            + "u.username,"
            + "u.password,"
            + "u.emailUser,"
            + "u.Activo, "
            + "u.tipoUser, "
            + "u.idcodTipoUser, "
            + "('') as roles,"
            + "ps.apePaternoPers as apePaternoUser,"
            + "ps.apeMaternoPers as apeMaternoUser,"
            + "ps.nombrePers as nombresUser, "
            + "('') as nomComplUser) "
            + "from Usuario u inner join Obra o on (u.obraUs = o.idobra) "
            + "left join Personal p on (u.idcodTipoUser=p.idPersonal and p.obraPer = o.idobra and u.tipoUser='COLAB') "
            + "left join Persona ps on (p.idPersona = ps.idPersona) "
            + "where o.idobra=?1 and u.tipoUser= (case ?2 when '_' then u.tipoUser else ?2 end) " +
            " and u.Activo=(case ?3 when 3 then u.Activo else ?3 end)")
    public List<usuarioDTO> findByObraAndTipoUser(String obraname, String tipoUser, Integer activo);


    @Query("select new com.spring.sigmaweb.backend.process.core.dto.usuarioDTO ( u.idUser, "
            +"u.username, "
            +"u.password, "
            +"u.emailUser, "
            +"u.Activo, "
            +"u.tipoUser, "
            +"u.idcodTipoUser, "
            +"('') as roles,"
            +"ps.apePaternoPers as apePaternoUser, "
            +"ps.apeMaternoPers as apeMaternoUser, "
            +"ps.nombrePers as nombresUser, "
            + "('') as nomComplUser) "
            + "from Usuario u join u.roles ur "
            + "inner join Obra o on (u.obraUs = o.idobra) "
            + "left join Personal p on (u.idcodTipoUser=p.idPersonal and p.obraPer=o.idobra and u.tipoUser='COLAB') "
            + "left join Persona ps on (p.idPersona = ps.idPersona) "
            + "where ur.idRol not in ?1 and o.idobra=?2"
    )
    public List<usuarioDTO> findByNotIdRolAndObra (Long[] idrol,String idobra);

    @Query("select new com.spring.sigmaweb.backend.process.core.dto.usuarioDTO ( u.idUser, "
            +"u.username, "
            +"u.password, "
            +"u.emailUser, "
            +"u.Activo, "
            +"u.tipoUser, "
            +"u.idcodTipoUser, "
            +"('') as roles,"
            +"ps.apePaternoPers as apePaternoUser, "
            +"ps.apeMaternoPers as apeMaternoUser, "
            +"ps.nombrePers as nombresUser, "
            + "('') as nomComplUser) "
            + "from Usuario u join u.roles ur "
            + "inner join Obra o on (u.obraUs = o.idobra) "
            + "left join Personal p on (u.idcodTipoUser=p.idPersonal and p.obraPer=o.idobra and u.tipoUser='COLAB') "
            + "left join Persona ps on (p.idPersona = ps.idPersona) "
            + "where ur.idRol in ?1 and o.idobra=?2"
    )
    public List<usuarioDTO> findByIdRolAndObra (Long[] idrol, String idobra);

    @Query("select new com.spring.sigmaweb.backend.process.core.dto.usuarioDTO ( u.idUser, "
            +"u.username, "
            +"u.password, "
            +"u.emailUser, "
            +"u.Activo, "
            +"u.tipoUser, "
            +"u.idcodTipoUser, "
            +"('') as roles,"
            +"ps.apePaternoPers as apePaternoUser, "
            +"ps.apeMaternoPers as apeMaternoUser, "
            +"ps.nombrePers as nombresUser, "
            + "('') as nomComplUser) "
            + "from Usuario u join u.roles ur "
            + "inner join Obra o on (u.obraUs = o.idobra) "
            + "left join Personal p on (u.idcodTipoUser=p.idPersonal and p.obraPer=o.idobra and u.tipoUser='COLAB') "
            + "left join Persona ps on (p.idPersona = ps.idPersona) "
            + "where u.username = ?1 and o.idobra=?2"
    )
    public usuarioDTO findByUsernameAndObraDTO (String username, String idobra);

    @Query("select u "
            + "from Usuario u inner join Obra o on u.obraUs = o.idobra "
            + "where u.idUser=?1 and o.idobra=?2")
    public Usuario findByIdUserAndObra(Long iduser, String idobra);

    @Query("select ur "
            + "from Usuario u inner join u.roles ur "
            + "inner join Obra o on (u.obraUs = o.idobra) "
            + "where u.idUser in ?1 and o.idobra=?2"
    )
    public List<Rol> usuariosRolesPorUsuario(Long iduser, String idobra);
}
