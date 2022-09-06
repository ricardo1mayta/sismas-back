package com.spring.sigmaweb.backend.process.core.controller;

import com.spring.sigmaweb.backend.process.core.dto.usuarioDTO;
import com.spring.sigmaweb.backend.process.core.model.Rol;
import com.spring.sigmaweb.backend.process.core.model.Usuario;
import com.spring.sigmaweb.backend.process.core.service.IRolService;
import com.spring.sigmaweb.backend.process.core.service.IUsuarioService;
import com.spring.sigmaweb.backend.process.generic.model.Obra;
import com.spring.sigmaweb.backend.process.generic.service.IObraService;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalDatosListDTO;
import com.spring.sigmaweb.backend.process.legajo.service.IPersonalService;
import com.spring.sigmaweb.backend.process.matricula.dto.FamiliarUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/sigmaweb/api")
public class UsuarioRestController {
    String passwordBString1;
    String pass = "";
    Integer lenPass = 0;

    @Autowired
    private IUsuarioService usuarioService;

    /*@Autowired
    private IFamiliaService familiaService;*/

    @Autowired
    private IPersonalService personalservice;

    @Autowired
    private IObraService obraServices;

    @Autowired
    private IRolService rolService;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/usuarios")
    public List<Usuario> index() {
        return usuarioService.findAll();
    }

    @GetMapping("/usuariosporrolandobra/{idroles}/{idobra}")
    public List<usuarioDTO> showUsuariosPorRolAndObra(@PathVariable String idroles, @PathVariable String idobra) {
        String[] lista= idroles.split(",");
        Long[] listaR= new Long[lista.length];
        //List<Rol> RolSelect = new ArrayList<Rol>();

        Integer i=0;
        for (String item : lista) {
            //RolSelect.add(rolService.findByIdRol(Long.parseLong(item)));
            listaR[i]= Long.parseLong(item);
        }
        return usuarioService.findByIdRolAndObra(listaR, idobra);
    }

    @GetMapping("/rolesporusuario/{iduser}/{idobra}")
    public List<Rol> showUsuariosRolesObra(@PathVariable Long iduser, @PathVariable String idobra) {

        return usuarioService.usuariosRolesPorUsuario(iduser, idobra);
    }


    @GetMapping("/usuariosnoporrolandobra/{idroles}/{idobra}")
    public List<usuarioDTO> showUsuariosNoPorRolAndObra(@PathVariable String idroles, @PathVariable String idobra) {
        String[] lista= idroles.split(",");
        Long[] listaR= new Long[lista.length];
        //List<Rol> RolSelect = new ArrayList<Rol>();

        Integer i=0;
        for (String item : lista) {
            //RolSelect.add(rolService.findByIdRol(Long.parseLong(item)));
            listaR[i]= Long.parseLong(item);
        }
        return usuarioService.findByNotIdRolAndObra(listaR, idobra);
    }

    @GetMapping("/usuariousernameobradto/{username}/{idobra}")
    public usuarioDTO showUsurarioPorUsernameAndObra(@PathVariable String username, @PathVariable String idobra) {
        return usuarioService.findByUsernameAndObraDTO(username,idobra);
    }

    @GetMapping("/usuariosporobraandtipousuario/{idobra}/{tipouser}/{estado}")
    public List<usuarioDTO> showUsuariosPorObraAndTipoUsuario(@PathVariable String idobra, @PathVariable String tipouser,@PathVariable Integer estado) {
        return usuarioService.findByObraAndTipoUser(idobra, tipouser, estado);
    }

    @PutMapping("/usuarionew/{obraname}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createNewUser(@RequestBody usuarioDTO newUser, @PathVariable String obraname, BindingResult result) {
        Usuario usuNew = null;
        Usuario usuInsert = new Usuario();
        Optional<Obra> obraUsu = obraServices.findById(obraname);
        List<Rol> rolList = new ArrayList<>();

        String[] lista= newUser.getRoles().split(",");


        Map<String, Object> response = new HashMap<>();

        if(result.hasErrors()) {

            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        try {

            if (usuarioService.findByUsernameAndObra(newUser.getUsername(), obraname) == null) {

                usuInsert.setUsername(newUser.getUsername().trim() );//+ "." + obraname.trim());
                usuInsert.setPassword(passwordEncoder.encode(newUser.getPassword().trim() ));
                usuInsert.setEmailUser(newUser.getEmailUser().trim());
                usuInsert.setActivo(newUser.getActivo());
                usuInsert.setTipoUser(newUser.getTipoUser());
                usuInsert.setIdcodTipoUser(newUser.getIdcodTipoUser());
                usuInsert.setObraUs(obraUsu.get());
                //inserta roles
                rolList = rolService.findByNombreRolListAndObra(lista, obraname);

                usuInsert.setRoles(rolList);

                usuNew = usuarioService.save(usuInsert);
            } else {
                response.put("mensaje", "Usuario ya esta creado");
                response.put("error", "Usuario Duplicado");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "usuario creado con éxito!");
        response.put("usuario", usuNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

    }
/*
    @PutMapping("/usuariosfamilinsertAll/{obraname}/{tipoUser}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUuarioFamilList(@PathVariable String obraname, @PathVariable String tipoUser) {

        List<FamiliarUserDTO> famis = familiaService.findByFamiliaresPMA(obraname, 1);
        Optional<Obra> obraUsu = obraServices.findById(obraname);
        Usuario newUser = new Usuario();
        Rol rolNew = rolService.findByNombreRolAndIdObraRol("ROLE_FAMI", obraname);
        List<Rol> rolList = new ArrayList<Rol>();
        rolList.add(rolNew);

        for (FamiliarUserDTO fm : famis) {
            newUser = usuarioService.findByUsername(fm.getNroDoc().trim());

            if (newUser == null) {
                pass = fm.getNroDoc().trim();
                lenPass = pass.length();
                pass = passwordEncoder.encode(pass.substring(lenPass - 4));// 4 ultimos digitos de su doc. identidad

                newUser = new Usuario();
                newUser.setActivo(true);
                newUser.setEmailUser("");
                newUser.setIdcodTipoUser(fm.getIdFami());
                newUser.setRoles(rolList);
                newUser.setPassword(pass);
                newUser.setTipoUser(tipoUser);
                newUser.setUsername(fm.getNroDoc());
                newUser.setObraUs(obraUsu.get());

                usuarioService.save(newUser);

            }
        }
    }
*/
    @PutMapping("/usuariosColabinsertAll/{obraname}/{tipoUser}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUuariocolabList(@PathVariable String obraname, @PathVariable String tipoUser) {

        List<PersonalDatosListDTO> famis = personalservice.findByIdPersonalAndObraList(obraname);
        Optional<Obra> obraUsu = obraServices.findById(obraname);
        Usuario newUser = new Usuario();
        Rol rolNew = rolService.findByNombreRolAndIdObraRol("ROLE_COLA", obraname);
        List<Rol> rolList = new ArrayList<Rol>();
        rolList.add(rolNew);

        for (PersonalDatosListDTO fm : famis) {
            if (fm.getEmailcorp() == null ) {
                continue;
            }
            if (fm.getEmailcorp().trim().length() == 0 ) {
                continue;
            }
            if (fm.getEstadoPer() == false ) {
                continue;
            }
            newUser = usuarioService.findByUsername(fm.getEmailcorp().trim());//+ "." + obraname.toUpperCase());

            if (newUser == null) {
                pass = fm.getNroDocPers().trim();
                lenPass = pass.length();
                pass = passwordEncoder.encode(pass.substring(lenPass - 4));// 4 ultimos digitos de su doc. identidad

                newUser = new Usuario();
                newUser.setActivo(true);
                newUser.setEmailUser("");
                newUser.setIdcodTipoUser(fm.getIdPersonal());
                newUser.setRoles(rolList);
                newUser.setPassword(pass);
                newUser.setTipoUser(tipoUser);
                newUser.setUsername(fm.getEmailcorp().trim());//+"."+fm.getIdobra());
                newUser.setObraUs(obraUsu.get());

                usuarioService.save(newUser);

            }
        }
    }

    @PutMapping("/usuariosfamilinsert/{obraname}/{nrodoc}/{idfami}")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario createUuarioFamil(@PathVariable String obraname, @PathVariable String nrodoc, @PathVariable Long idfami) {
        Optional<Obra> obraUsu = obraServices.findById(obraname);

        Rol rolNew = rolService.findByNombreRolAndIdObraRol("ROLE_FAMI", obraname);

        List<Rol> rolList = new ArrayList<Rol>();

        rolList.add(rolNew);

        Usuario newUser = new Usuario();

        //busca si existe
        newUser = usuarioService.findByUsername(nrodoc.trim());

        if (newUser == null) {
            pass = nrodoc.trim();
            lenPass = pass.length();
            pass = passwordEncoder.encode(pass.substring(lenPass - 4)); //"test";

            newUser = new Usuario();
            newUser.setActivo(true);
            newUser.setEmailUser("");
            newUser.setIdcodTipoUser(idfami);
            newUser.setRoles(rolList);
            newUser.setPassword(pass);
            newUser.setTipoUser("FAMIL");
            newUser.setUsername(nrodoc.trim());
            newUser.setObraUs(obraUsu.get());

            usuarioService.save(newUser);
        }

        return newUser;
    }


    @PutMapping("/usuarioupdate/{iduser}/{idobra}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> updateUsuarios(@RequestBody usuarioDTO usuUpdate, @PathVariable Long iduser, @PathVariable String idobra, BindingResult result) {
        Usuario userAct = usuarioService.findByIdUserAndObra(iduser, idobra);
        Usuario UsuUpdate = new Usuario();
        List<Rol> rolesNuevos = rolService.findByNombreRolListAndObra(usuUpdate.getRoles().split(","), idobra);//userAct.getRoles();
        String newPassWord= "";



        Map<String, Object> response = new HashMap<>();
        if(result.hasErrors()) {

            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        try {

            //if (usuarioService.findByUsernameAndObra(usuUpdate.getUsername(), idobra) == null) {
            userAct.setActivo(usuUpdate.getActivo());

            userAct.setEmailUser(usuUpdate.getEmailUser());
            userAct.setRoles(null);
            userAct.setRoles(rolesNuevos);
            userAct.setIdcodTipoUser(usuUpdate.getIdcodTipoUser());
            userAct.setTipoUser(usuUpdate.getTipoUser());
            if (!usuUpdate.getPassword().trim().equals("")) {

                newPassWord = passwordEncoder.encode(usuUpdate.getPassword().trim());
                userAct.setPassword(newPassWord);
            }

            UsuUpdate = usuarioService.save(userAct);

            //} else {
            //response.put("mensaje", "Usuario ya esta creado");
            //response.put("error", "Usuario Duplicado");
            //return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            //}

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar update en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "usuario actualizado con éxito!");
        response.put("usuario", UsuUpdate);



        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @GetMapping("/validapassoldUsuario/{iduser}/{idobra}/{passOld}")
    public Boolean verificaPasswordOld( @PathVariable Long iduser, @PathVariable String idobra, @PathVariable String passOld ) {
        Usuario userAct = usuarioService.findByIdUserAndObra(iduser, idobra);
        String PassWOld=passwordEncoder.encode(passOld.trim());
        if (userAct != null) {
            if( passwordEncoder.matches(passOld,userAct.getPassword())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
