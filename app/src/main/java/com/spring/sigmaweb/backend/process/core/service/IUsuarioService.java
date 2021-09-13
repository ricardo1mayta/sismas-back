package com.spring.sigmaweb.backend.process.core.service;

import com.spring.sigmaweb.backend.process.core.dto.usuarioDTO;
import com.spring.sigmaweb.backend.process.core.model.Rol;
import com.spring.sigmaweb.backend.process.core.model.Usuario;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> findAll();

    public Usuario findByUsername(String username);

    public Usuario findByUsernameAndObra(String username, String obra);

    public Usuario save(Usuario usuario);

    public Usuario findByIdUser(Long idUser);

    public List<usuarioDTO> findByObraAndTipoUser(String obraname, String tipoUser, Integer estado);

    public List<usuarioDTO> findByIdRolAndObra(Long[] idrol, String idobra);

    public List<usuarioDTO> findByNotIdRolAndObra(Long[] idrol,String idobra);

    public Usuario findByIdUserAndObra(Long iduser, String idobra);

    public List<Rol> usuariosRolesPorUsuario(Long iduser, String idobra);
}
