package com.spring.sigmaweb.backend.process.core.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.spring.sigmaweb.backend.process.core.dto.usuarioDTO;
import com.spring.sigmaweb.backend.process.core.model.Rol;
import com.spring.sigmaweb.backend.process.core.model.Usuario;
import com.spring.sigmaweb.backend.process.core.repository.IUsuarioDao;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalDTO;
import com.spring.sigmaweb.backend.process.legajo.repository.IPersonalDao;
import com.spring.sigmaweb.backend.process.matricula.dto.FamiliarUserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService implements IUsuarioService, UserDetailsService{
    private Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    private IUsuarioDao usuarioDao;

    /*@Autowired
    private IFamiliaDao familiaDao;*/

    @Autowired
    private IPersonalDao personalDao;

    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        String usernameD = username.trim().substring(0, username.trim().indexOf("*"));
        String codInternoD = username.trim().substring(username.trim().indexOf("*") + 1,username.trim().length());

        Usuario usuario = usuarioDao.findByUsernameActivo(usernameD) ;//usuarioDao.findByUsernameAndObra(usernameD.trim(),obraD.trim());
        PersonalDTO personal = null;
        username=usernameD;

        if(usuario == null) {
            logger.error("Error en el login: no existe el usuario '"+username+"' en el sistema!");
            throw new UsernameNotFoundException("Error en el login: no existe el usuario '"+username+"' en el sistema!");
        } else {

            if(usuario.getTipoUser().equals("COLAB")) {
                personal = personalDao.findByObraAndidPersonalAndCodigoPer(usuario.getObraUs().getIdobra(), usuario.getIdcodTipoUser(),codInternoD.trim());

                if (personal == null ) {
                    logger.error("Error en el login: no existe el usuario '"+username+"' con código Interno '"+ codInternoD +"' en el sistema!");
                    throw new UsernameNotFoundException("Error en el login: no existe el usuario '"+username+"' con código Interno '"+ codInternoD +"' en el sistema!");
                } else {
                    //System.out.println(personal.getApePaternoPers());
                }
            } else if(usuario.getTipoUser().equals("EXTER")) {

            }
        }

        List<GrantedAuthority> authorities = usuario.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getNombreRol()))
                .peek(authority -> logger.info("Role: " + authority.getAuthority()))
                .collect(Collectors.toList());

        return new User(usuario.getUsername(), usuario.getPassword(), usuario.getActivo(), true, true, true, authorities);
    }


    @Override
    @Transactional(readOnly=true)
    public Usuario findByUsername(String username) {
        return usuarioDao.findByUsername(username);
    }

    @Override
    @Transactional(readOnly=true)
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Usuario findByUsernameAndObra(String username, String obra) {
        return usuarioDao.findByUsernameAndObra(username, obra);
    }


    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        return usuarioDao.save(usuario);

    }
    @Override
    @Transactional(readOnly=true)
    public Usuario findByIdUser(Long idUser) {
        return usuarioDao.findByIdUser(idUser);
    }

    @Override
    public usuarioDTO findByObraAndIdUserDTO(String obraname, Long iduser) {
        return usuarioDao.findByObraAndIdUserDTO(obraname, iduser);
    }


    @Override
    @Transactional(readOnly=true)
    public List<usuarioDTO> findByObraAndTipoUser(String obraname, String tipoUser, Integer estado) {

        List<usuarioDTO> users= usuarioDao.findByObraAndTipoUser(obraname, tipoUser, estado);
        List<FamiliarUserDTO> famiDNI = new ArrayList<FamiliarUserDTO>();
        List<Rol> userRol = new ArrayList<Rol>();

        String rolesString = "";
        for (usuarioDTO usu : users) {
            userRol = usuarioDao.usuariosRolesPorUsuario(usu.getIdUser(), obraname);
            rolesString ="";
            for (Rol rol : userRol) {
                rolesString += rol.getNombreRol() + ",";
            }

            usu.setRoles(rolesString);
            if(usu.getTipoUser().equals("FAMIL")) {
            /*    famiDNI = familiaDao.finbByIdFamiAndObraAndNroDoc(usu.getIdcodTipoUser(), obraname, usu.getUsername());
                if(famiDNI.size()>0) {
                    usu.setApePaternoUser(famiDNI.get(0).getApPaterno());
                    usu.setApeMaternoUser(famiDNI.get(0).getApMaterno());
                    usu.setNombresUser(famiDNI.get(0).getNombre());
                }*/
            }
            if(usu.getTipoUser().equals("EXTER")) {
                usu.setNomComplUser(usu.getEmailUser());
            } else {
                usu.setNomComplUser( this.nomCompleto(usu.getApePaternoUser(), usu.getApeMaternoUser(), usu.getNombresUser()));
            }
        }

        return users;
    }


    @Override
    @Transactional(readOnly=true)
    public List<usuarioDTO> findByIdRolAndObra(Long[] idrol, String idobra) {
        // TODO Auto-generated method stub
        List<usuarioDTO> users= usuarioDao.findByIdRolAndObra(idrol, idobra); //idrol, idobra
        List<FamiliarUserDTO> famiDNI = new ArrayList<FamiliarUserDTO>();
        List<Rol> userRol = new ArrayList<Rol>();
        String rolesString = "";
        for (usuarioDTO usu : users) {
            userRol = usuarioDao.usuariosRolesPorUsuario(usu.getIdUser(), idobra);
            for (Rol rol : userRol) {
                rolesString += rol.getNombreRol() + ",";
            }
            usu.setNomComplUser("");
            usu.setRoles(rolesString);
            if(usu.getTipoUser().equals("FAMIL")) {
                /*famiDNI = familiaDao.finbByIdFamiAndObraAndNroDoc(usu.getIdcodTipoUser(), idobra, usu.getUsername());
                if(famiDNI.size()>0) {
                    usu.setApePaternoUser(famiDNI.get(0).getApPaterno());
                    usu.setApeMaternoUser(famiDNI.get(0).getApMaterno());
                    usu.setNombresUser(famiDNI.get(0).getNombre());
                }*/
            }
            if(usu.getTipoUser().equals("EXTER")) {
                usu.setNomComplUser(usu.getEmailUser());
            } else {
                usu.setNomComplUser(this.nomCompleto(usu.getApePaternoUser(), usu.getApeMaternoUser(), usu.getNombresUser()));
            }
        }

        return users;
    }

    @Override
    @Transactional(readOnly=true)
    public List<usuarioDTO> findByNotIdRolAndObra(Long[] idrol, String idobra) {
        // TODO Auto-generated method stub
        List<usuarioDTO> users= usuarioDao.findByNotIdRolAndObra(idrol, idobra);
        List<FamiliarUserDTO> famiDNI = new ArrayList<FamiliarUserDTO>();
        List<Rol> userRol = new ArrayList<Rol>();
        String rolesString = "";

        for (usuarioDTO usu : users) {
            userRol = usuarioDao.usuariosRolesPorUsuario(usu.getIdUser(), idobra);
            for (Rol rol : userRol) {
                rolesString += rol.getNombreRol() + ",";
            }
            usu.setRoles(rolesString);
            if(usu.getTipoUser().equals("FAMIL")) {
                /*famiDNI = familiaDao.finbByIdFamiAndObraAndNroDoc(usu.getIdcodTipoUser(), idobra, usu.getUsername());

                if(famiDNI.size()>0) {
                    usu.setApePaternoUser(famiDNI.get(0).getApPaterno());
                    usu.setApeMaternoUser(famiDNI.get(0).getApMaterno());
                    usu.setNombresUser(famiDNI.get(0).getNombre());
                }*/
            }

            if(usu.getTipoUser().equals("EXTER")) {
                usu.setNomComplUser(usu.getEmailUser());
            } else {
                usu.setNomComplUser( this.nomCompleto(usu.getApePaternoUser(), usu.getApeMaternoUser(), usu.getNombresUser()));
            }
        }

        return users;
    }


    @Override
    @Transactional(readOnly=true)
    public Usuario findByIdUserAndObra(Long iduser, String idobra) {
        // TODO Auto-generated method stub
        return usuarioDao.findByIdUserAndObra(iduser, idobra);
    }

    @Override
    public List<usuarioDTO> findByIdUserAndObraArrayDTO(String iduser, String idobra) {
        String[] lista= iduser.split(",");
        Long[] ids = new Long[lista.length];
        Integer i=0;
        for (String item : lista) {
            //RolSelect.add(rolService.findByIdRol(Long.parseLong(item)));
            ids[i]= Long.parseLong(item);
            i++;
        }

        List<usuarioDTO> result = usuarioDao.findByIdUserAndObraArrayDTO(ids, idobra);
        return result;
    }

    private String nomCompleto(String apePat, String apeMat, String nombre) {
        String name="";
        if (apePat != null && apeMat != null && nombre != null) {
            name = apePat + " " + apeMat + ", " + nombre;

        } else if (apePat != null && nombre != null) {
            name = apePat + ", " + nombre;
        } else if (apeMat != null && nombre != null) {
            name = apeMat + ", " + nombre;
        } else if (apePat != null && apeMat != null) {
            name = apePat + " " + apeMat;
        } else if (nombre != null) {
            name = nombre;
        }
        return name;
    }


    @Override
    @Transactional(readOnly=true)
    public List<Rol> usuariosRolesPorUsuario(Long iduser, String idobra) {
        // TODO Auto-generated method stub
        return usuarioDao.usuariosRolesPorUsuario(iduser, idobra);
    }

    @Override
    public usuarioDTO findByUsernameAndObraDTO(String username, String idobra) {

        usuarioDTO users = usuarioDao.findByUsernameAndObraDTO(username, idobra);

        List<FamiliarUserDTO> famiDNI = new ArrayList<FamiliarUserDTO>();
        List<Rol> userRol = new ArrayList<Rol>();
        String rolesString = "";


        userRol = usuarioDao.usuariosRolesPorUsuario(users.getIdUser(), idobra);
        for (Rol rol : userRol) {
            rolesString += rol.getNombreRol() + ",";
        }
        users.setRoles(rolesString);
        if(users.getTipoUser().equals("FAMIL")) {
            /*famiDNI = familiaDao.finbByIdFamiAndObraAndNroDoc(usu.getIdcodTipoUser(), idobra, usu.getUsername());

            if(famiDNI.size()>0) {
                usu.setApePaternoUser(famiDNI.get(0).getApPaterno());
                usu.setApeMaternoUser(famiDNI.get(0).getApMaterno());
                usu.setNombresUser(famiDNI.get(0).getNombre());
            }*/
        }

        if(users.getTipoUser().equals("EXTER")) {
            users.setNomComplUser(users.getEmailUser());
        } else {
            users.setNomComplUser( this.nomCompleto(users.getApePaternoUser(), users.getApeMaternoUser(), users.getNombresUser()));
        }
        return users;
    }

    @Override
    public void modificaEstadoUser(String idobra, Long codiuser, String tipouser, Boolean estado) {
        Usuario user = usuarioDao.findByObraAndCoduserAndTipouser(idobra, codiuser, tipouser);
        if(user != null){
            user.setActivo(estado);
            usuarioDao.save(user);
        }
    }

}
