package com.spring.sigmaweb.backend.process.legajo.controller;

import java.util.*;
import java.util.stream.Collectors;

import com.spring.sigmaweb.backend.process.generic.model.Distrito;
import com.spring.sigmaweb.backend.process.generic.model.Obra;
import com.spring.sigmaweb.backend.process.generic.model.Persona;
import com.spring.sigmaweb.backend.process.generic.model.TablasTabla;
import com.spring.sigmaweb.backend.process.generic.service.IDistritoService;
import com.spring.sigmaweb.backend.process.generic.service.IObraService;
import com.spring.sigmaweb.backend.process.generic.service.IPersonaService;
import com.spring.sigmaweb.backend.process.generic.service.ITablasTablaService;
import com.spring.sigmaweb.backend.process.legajo.dto.*;
import com.spring.sigmaweb.backend.process.legajo.model.Personal;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalHistorico;
import com.spring.sigmaweb.backend.process.legajo.service.IPersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Parser;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/sigmaweb/legajo/personal")
public class PersonalRestController {
    @Autowired
    private IPersonalService personalservice;

    @Autowired
    private ITablasTablaService tablastablaservice;

    @Autowired
    private IDistritoService distritoservice;

    @Autowired
    private IObraService obraservice;

    @Autowired
    private IPersonaService personaService;

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/personalobralist/{obraname}")
    public List<PersonalDatosListDTO> showpersonalListDTO(@PathVariable String obraname) {
        return personalservice.findByIdPersonalAndObraList(obraname);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/personalobraandestado/{obraname}/{estadoper}")
    public List<PersonalDatosListDTO> showpersonalObraAndEstadoListDTO(@PathVariable String obraname, @PathVariable Boolean estadoper) {
        return personalservice.findByObraAndEstadoPerList(obraname, estadoper);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/personalobraandestadotest/{obraname}/{estadoper}")
    public List<PersonalDatosListDTO> showpersonalObraAndEstadoListDTO(@PathVariable String obraname, @PathVariable Integer estadoper) {
        return personalservice.findByObraAndEstadoPerTestList(obraname, estadoper);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/personalporidandobra/{idpersonal}/{obraname}")
    public Personal showpersonalDTO(@PathVariable Long idpersonal, @PathVariable String obraname) {
        return personalservice.findByIdPersonalAndObraname(idpersonal, obraname);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/personalDTO/{nrodoc}/{obraname}")
    public PersonalDTO showpersonalNrodocDTO(@PathVariable String nrodoc, @PathVariable String obraname) {
        return personalservice.findByNroDocPerAndobraPersonal(nrodoc, obraname);
    }

    @Secured({"ROLE_PERS","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/personalInfoPersonalesDTO/{idpersonal}/{obraname}")
    public PersonalDatosPersonalesDTO showpersonalInfoPersonalesDTO(@PathVariable Long idpersonal, @PathVariable String obraname) {
        return personalservice.findByIdPersonaAndObraPersonalInfoPersonal(idpersonal, obraname);
    }

    @Secured({"ROLE_PERS","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/personalInfoMedicosDTO/{idpersonal}/{obraname}")
    public PersonalDatosMedicosDTO showpersonalInfoMedicosDTO(@PathVariable Long idpersonal, @PathVariable String obraname) {
        return personalservice.findByIdPersonaAndObraInfoMedico(idpersonal, obraname);
    }

    @Secured({"ROLE_PERS","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/personalInfobasico/{obraname}/{idpersonal}")
    public PersonalDatosListDTO showpersonalObraAndIdPersonalDTO( @PathVariable String obraname,@PathVariable Long idpersonal) {
        return personalservice.findByObraAndidPersonalBasico(obraname, idpersonal);
    }

    @Secured({"ROLE_PERS","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/personalobranumerodoc/{obraname}/{nrodocpers}")
    public List<PersonalDatosListDTO> showpersonalObraAndNrodocDTO( @PathVariable String obraname,@PathVariable String nrodocpers) {
        return personalservice.findByNroDocPersAndIdObra(obraname, nrodocpers);
    }

    @Secured({"ROLE_PERS","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/personalobracodigopers/{obraname}/{codigoPer}")
    public List<PersonalDatosListDTO> showpersonalObraAndCodigoPersDTO( @PathVariable String obraname,@PathVariable String codigoPer) {
        return personalservice.findByCodigoPerAndIdObra(obraname, codigoPer);
    }

    //datos financieros
    @Secured({"ROLE_PERS","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/personalobrainfofinanciera/{obraname}/{idpersonal}")
    public PersonalDatosBancariosDTO showpersonalInfoFinanciera( @PathVariable String obraname, @PathVariable Long idpersonal) {
        return personalservice.findByObraAndidPersonalParaInfoBancario(obraname, idpersonal);
    }


    @PutMapping("/personalupdatefechaConfir")
    public Integer updatepersonalFechaConfir(@RequestBody PersonalDatosListDTO personalUpd) {
        Personal perFind = personalservice.findByIdPersonalAndObraname(personalUpd.getIdPersonal(), personalUpd.getIdobra());
        Integer resp = 0;

        if(perFind == null) {
            resp = 0;
        } else {
            if(perFind.getFechaAutorizaPer() == null) {
                resp = personalservice.updateFechaConfirPersonal(personalUpd.getIdPersonal());
            } else {
                resp = -1;
            }
        }
        return resp;
    }

    @PostMapping("/personalsave")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody PersonalDatosPersonalesDTO personalDTO, BindingResult result) {
        Personal personalNew = null;
        Personal personalResult = null;

        Persona personaNew = null;
        Persona personaResult = null;

        List<PersonalHistorico> historico = new ArrayList<PersonalHistorico>();
        String direccion="";
        PersonalHistorico itemHist = new PersonalHistorico();

        TablasTabla tablaT = tablastablaservice.findByCodigoTab(personalDTO.getIdTipoDocPer());
        Optional<Distrito> distDomi = distritoservice.findById(personalDTO.getIdDistDomiPer());
        Optional<Obra> obraNew = obraservice.findById(personalDTO.getIdobra());

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
            //busca si existe una persona ya registrada con ese número de documento
            personaResult = personaService.findByNroDocPersAndObraPers(personalDTO.getNroDocPers().trim(),personalDTO.getIdobra());
            if (personaResult ==null) {
                //se registra uno nuevo
                personaNew = new Persona();
                personaNew.setObraPers(personalDTO.getIdobra());
                personaNew.setApePaternoPers(personalDTO.getApePaternoPers());
                personaNew.setApeMaternoPers(personalDTO.getApeMaternoPers());
                personaNew.setNombrePers(personalDTO.getNombrePers());
                personaNew.setIdTipoDocPers(tablaT);
                personaNew.setNroDocPers(personalDTO.getNroDocPers().trim());
                personaNew.setIdPaisDocPers(personalDTO.getIdPaisDocPers());

                tablaT= new TablasTabla();
                tablaT = tablastablaservice.findByCodigoTab(personalDTO.getEstCivilPer());
                personaNew.setEstCivilPers(tablaT);

                personaNew.setFecCambioEstCivilPers(personalDTO.getFecCambioEstCivilPers());
                personaNew.setSexoPers(personalDTO.getSexoPers());
                personaNew.setCelularPers(personalDTO.getCelularPers());
                personaNew.setCelularBPers(personalDTO.getCelularBPers());
                personaNew.setTelefonoFijoPers(personalDTO.getTelefonoFijoPers());
                personaNew.setEmailPers(personalDTO.getEmailPers());
                personaNew.setEmailCorPers(personalDTO.getEmailCorPers());
                personaNew.setReligionProfesaPers(personalDTO.getReligionProfesaPers());
                //NACIMIENTO
                personaNew.setFechaNacPers(personalDTO.getFechaNacPers());
                personaNew.setIdPaisNacPers(personalDTO.getIdPaisNacPers());
                personaNew.setNacionalidadPers(personalDTO.getNacionalidadPers());
                personaNew.setIdDistNacPers(personalDTO.getIdDistNacPers());
                personaNew.setObservaNacPers(personalDTO.getObservaNacPers());
                //DOMICILIO
                personaNew.setTipoViaDomiPers(personalDTO.getTipoViaDomiPers());
                personaNew.setDomicilioPers(personalDTO.getDomicilioPers());
                personaNew.setNumeroDomiPers(personalDTO.getNroDocPers());
                personaNew.setInteriorDomiPers(personalDTO.getInteriorDomiPers());
                personaNew.setTipoZonaDomiPers(personalDTO.getTipoZonaDomiPers());
                personaNew.setNombreZonaDomiPers(personalDTO.getNombreZonaDomiPers());
                personaNew.setIdDistDomiPers(distDomi.get());
                personaNew.setObservacionDomiPers(personalDTO.getObservacionDomiPers());

                personaNew.setCreaPorPers(personalDTO.getCreaPorPer());
                personaNew.setCodInterPers(null);
                personaNew.setFechaIngPers(personalDTO.getFechaIngPer());

                //guardar personanew
                personaResult = personaService.save(personaNew);
            } else {
                //actualiza la información con los datos nuevos de la persona
                personaResult.setNombrePers(personalDTO.getNombrePers());
                personaResult.setApePaternoPers(personalDTO.getApePaternoPers());
                personaResult.setApeMaternoPers(personalDTO.getApeMaternoPers());

                personaResult.setIdTipoDocPers(tablaT);
                personaResult.setNroDocPers(personalDTO.getNroDocPers());
                personaResult.setIdPaisDocPers(personalDTO.getIdPaisDocPers());

                if(!personaResult.getEstCivilPers().getCodigoTab().equals( personalDTO.getEstCivilPer() ) ) {

                    //guarda en historico
                    itemHist.setTipoEstCivilHist(personaResult.getEstCivilPers().getCodigoTab());
                    itemHist.setFechaCambECHist(personaResult.getFecCambioEstCivilPers());
                    itemHist.setCreaPorHist(personalDTO.getModiPorPer());
                    itemHist.setObraHist(obraNew.get());
                    itemHist.setTipoHist("ESTCIV");
                    historico.add(itemHist);
                }

                tablaT = tablastablaservice.findByCodigoTab(personalDTO.getEstCivilPer());
                personaResult.setEstCivilPers(tablaT);
                personaResult.setFecCambioEstCivilPers(personalDTO.getFecCambioEstCivilPers());

                personaResult.setSexoPers(personalDTO.getSexoPers());
                personaResult.setCelularPers(personalDTO.getCelularPers());
                personaResult.setCelularBPers(personalDTO.getCelularBPers());
                personaResult.setTelefonoFijoPers(personalDTO.getTelefonoFijoPers());
                personaResult.setEmailPers(personalDTO.getEmailPers());
                personaResult.setEmailCorPers(personalDTO.getEmailCorPers());

                personaResult.setReligionProfesaPers(personalDTO.getReligionProfesaPers());
                personaResult.setFechaNacPers(personalDTO.getFechaNacPers());
                personaResult.setIdPaisNacPers(personalDTO.getIdPaisNacPers());
                personaResult.setNacionalidadPers(personalDTO.getNacionalidadPers());
                personaResult.setIdDistNacPers(personalDTO.getIdDistNacPers());
                personaResult.setObservaNacPers(personalDTO.getObservaNacPers());


                if (!personaResult.getTipoViaDomiPers().equals(personalDTO.getTipoViaDomiPers()) ||
                        !personaResult.getDomicilioPers().trim().equals(personalDTO.getDomicilioPers().trim()) ||
                        !personaResult.getNumeroDomiPers().trim().equals(personalDTO.getNumeroDomiPers().trim()) ||
                        !personaResult.getInteriorDomiPers().trim().equals(personalDTO.getInteriorDomiPers().trim()) ||
                        !personaResult.getTipoZonaDomiPers().equals(personalDTO.getTipoZonaDomiPers()) ||
                        !personaResult.getNombreZonaDomiPers().trim().equals( personalDTO.getNombreZonaDomiPers().trim()) ||
                        !personaResult.getIdDistDomiPers().getIdDist().equals(personalDTO.getIdDistDomiPer()) ) {

                    //guarda en historico
                    itemHist = new PersonalHistorico();
                    direccion="";
                    if (personaResult.getTipoViaDomiPers() != null) {direccion = tablastablaservice.findByCodigoTab( personaResult.getTipoViaDomiPers() ).getDescrip2Tab() + " " + personaResult.getDomicilioPers() +" ";}
                    if(personaResult.getNumeroDomiPers() != null) {direccion += personaResult.getNumeroDomiPers() +", ";}
                    if(personaResult.getInteriorDomiPers() != null) {direccion += personaResult.getInteriorDomiPers() +" ";}
                    if (personaResult.getTipoZonaDomiPers() != null) {direccion += tablastablaservice.findByCodigoTab( personaResult.getTipoZonaDomiPers() ).getDescrip2Tab() +" ";}
                    if (personaResult.getNombreZonaDomiPers() != null) {direccion += personaResult.getNombreZonaDomiPers() +" - ";}

                    if (personaResult.getIdDistDomiPers() != null) {direccion += personaResult.getIdDistDomiPers().getNombreDist(); }

                    itemHist.setDireccionHist(direccion);
                    itemHist.setCreaPorHist(personalDTO.getCreaPorPer());
                    itemHist.setObraHist(obraNew.get());
                    itemHist.setTipoHist("DIRECC");
                    historico.add(itemHist);
                }

                personaResult.setTipoViaDomiPers(personalDTO.getTipoViaDomiPers());
                personaResult.setDomicilioPers(personalDTO.getDomicilioPers().trim());
                personaResult.setNumeroDomiPers(personalDTO.getNumeroDomiPers().trim());
                personaResult.setInteriorDomiPers(personalDTO.getInteriorDomiPers().trim());
                personaResult.setTipoZonaDomiPers(personalDTO.getTipoZonaDomiPers());
                personaResult.setNombreZonaDomiPers(personalDTO.getNombreZonaDomiPers().trim());
                personaResult.setIdDistDomiPers( distDomi.get());

                personaResult.setObservacionDomiPers(personalDTO.getObservacionDomiPers());

                personaResult=personaService.save(personaResult);
            }
            //System.out.println(personaResult.getIdPersona());
            personalNew = new Personal();
            personalNew.setIdPerSigma(Long.valueOf(0));
            personalNew.setObraPer(obraNew.get());
            personalNew.setIdPersona(personaResult);//(personaResult.getIdPersona());
            personalNew.setFotoPer(personalDTO.getIdobra() + "/" + personalDTO.getCodigoPer() + ".JPG");
            personalNew.setEstadoPer(personalDTO.getEstadoPer());
            personalNew.setCodigoPer(personalDTO.getCodigoPer().trim());
            personalNew.setContactoEmerPer(personalDTO.getContactoEmerPer());
            personalNew.setTelefContEmerPer(personalDTO.getTelefContEmerPer());
            personalNew.setIdParentContEmerPer(personalDTO.getIdParentContEmerPer());
            personalNew.setNroDocPer(personalDTO.getNroDocPers());

            personalNew.setNumeroEssaludPer(personalDTO.getNumeroEssaludPer());
            personalNew.setIdEntidadEpsPer(personalDTO.getIdEntEPS());
            personalNew.setNumeroEpsPer(personalDTO.getNumeroEpsPer());
            personalNew.setIdTipoPensionPer(personalDTO.getIdTipoPensionPer());
            personalNew.setIdEntidadPensPer(personalDTO.getIdEntPen());
            personalNew.setNumeroPensionPer(personalDTO.getNumeroPensionPer());

            personalNew.setFlgEsDiscapacitadoPer(personalDTO.getFlgEsDiscapacitadoPer());
            personalNew.setEspecDiscapacidadPer(personalDTO.getEspecDiscapacidadPer());

            personalNew.setFechaIngPer(personalDTO.getFechaIngPer());
            personalNew.setCreaPorPer(personalDTO.getCreaPorPer());

            if(personalDTO.getEstadoPer()){
                personalNew.setFechaActivoPer(personalDTO.getFechaActivoPer());
            }

            //data medica ?
            personalNew.setFlgAsmaPer(false);
            personalNew.setFlgcancerPer(false);
            personalNew.setFlgDonaSangrePer(false);
            personalNew.setFlgEnferPulmonPer(false);
            personalNew.setFlgEnferCardioPer(false);
            personalNew.setFlgEsDiabeticoPer(false);
            personalNew.setFlgEsHipertensoPer(false);
            personalNew.setFlgEsInmunoSupresorPer(false);
            personalNew.setFlgTrabajoAltoRiesgoPer(false);



            personalResult=personalservice.save(personalNew);

            if (historico.size() > 0) {
                for (PersonalHistorico h : historico) {
                    h.setPersonalHist(personalResult);
                }
                personalservice.saveAll(historico);
            }


        } catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El item ha sido creado con éxito!");
        response.put("personal", personalResult);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/personalupdate/{idpersonal}/{obraname}")
    @ResponseStatus(HttpStatus.CREATED)
    public Personal updatepersonalInfopersonalesDTO(@RequestBody PersonalDatosPersonalesDTO personalDTO, @PathVariable Long idpersonal, @PathVariable String obraname) {

        Personal PersonalAct = personalservice.findByIdPersonalAndObraname(idpersonal, obraname);
        List<PersonalHistorico> historico = new ArrayList<PersonalHistorico>();
        String direccion="";

        PersonalHistorico itemHist = new PersonalHistorico();

        TablasTabla tablaT = tablastablaservice.findByCodigoTab(personalDTO.getIdTipoDocPer());
        //System.out.println(tablaT.getDescripTab());
        Optional<Distrito> distDomi = distritoservice.findById(personalDTO.getIdDistDomiPer());

        PersonalAct.getIdPersona().setNombrePers(personalDTO.getNombrePers());
        PersonalAct.getIdPersona().setApePaternoPers(personalDTO.getApePaternoPers());
        PersonalAct.getIdPersona().setApeMaternoPers(personalDTO.getApeMaternoPers());
        PersonalAct.setFotoPer(personalDTO.getFotoPer());
        PersonalAct.getIdPersona().setIdTipoDocPers(tablaT);
        PersonalAct.getIdPersona().setNroDocPers(personalDTO.getNroDocPers());
        PersonalAct.getIdPersona().setIdPaisDocPers(personalDTO.getIdPaisDocPers());

        if(!PersonalAct.getIdPersona().getEstCivilPers().getCodigoTab().equals( personalDTO.getEstCivilPer() ) ) {

            //guarda en historico
            itemHist.setTipoEstCivilHist(PersonalAct.getIdPersona().getEstCivilPers().getCodigoTab());
            itemHist.setFechaCambECHist(PersonalAct.getIdPersona().getFecCambioEstCivilPers());
            itemHist.setCreaPorHist(personalDTO.getModiPorPer());
            itemHist.setObraHist(PersonalAct.getObraPer());
            itemHist.setTipoHist("ESTCIV");
            historico.add(itemHist);
        }

        tablaT = tablastablaservice.findByCodigoTab(personalDTO.getEstCivilPer());
        PersonalAct.getIdPersona().setEstCivilPers(tablaT);
        PersonalAct.getIdPersona().setFecCambioEstCivilPers(personalDTO.getFecCambioEstCivilPers());

        PersonalAct.getIdPersona().setSexoPers(personalDTO.getSexoPers());
        PersonalAct.getIdPersona().setCelularPers(personalDTO.getCelularPers());
        PersonalAct.getIdPersona().setCelularBPers(personalDTO.getCelularBPers());
        PersonalAct.getIdPersona().setTelefonoFijoPers(personalDTO.getTelefonoFijoPers());
        PersonalAct.getIdPersona().setEmailPers(personalDTO.getEmailPers());
        PersonalAct.getIdPersona().setEmailCorPers(personalDTO.getEmailCorPers());
        PersonalAct.setEstadoPer(personalDTO.getEstadoPer());
        PersonalAct.setContactoEmerPer(personalDTO.getContactoEmerPer());
        PersonalAct.setTelefContEmerPer(personalDTO.getTelefContEmerPer());
        PersonalAct.setIdParentContEmerPer(personalDTO.getIdParentContEmerPer());
        PersonalAct.getIdPersona().setReligionProfesaPers(personalDTO.getReligionProfesaPers());
        PersonalAct.setNumeroEssaludPer(personalDTO.getNumeroEssaludPer());
        PersonalAct.setNumeroEpsPer(personalDTO.getNumeroEpsPer());
        PersonalAct.setIdEntidadEpsPer(personalDTO.getIdEntEPS());
        PersonalAct.setNumeroPensionPer(personalDTO.getNumeroPensionPer());
        PersonalAct.setIdEntidadPensPer(personalDTO.getIdEntPen());
        PersonalAct.setIdTipoPensionPer(personalDTO.getIdTipoPensionPer());
        PersonalAct.getIdPersona().setFechaNacPers(personalDTO.getFechaNacPers());
        PersonalAct.getIdPersona().setIdPaisNacPers(personalDTO.getIdPaisNacPers());
        PersonalAct.getIdPersona().setNacionalidadPers(personalDTO.getNacionalidadPers());
        PersonalAct.getIdPersona().setIdDistNacPers(personalDTO.getIdDistNacPers());
        PersonalAct.getIdPersona().setObservaNacPers(personalDTO.getObservaNacPers());


        if (!PersonalAct.getIdPersona().getTipoViaDomiPers().equals(personalDTO.getTipoViaDomiPers()) ||
                !PersonalAct.getIdPersona().getDomicilioPers().trim().equals(personalDTO.getDomicilioPers().trim()) ||
                !PersonalAct.getIdPersona().getNumeroDomiPers().trim().equals(personalDTO.getNumeroDomiPers().trim()) ||
                !PersonalAct.getIdPersona().getInteriorDomiPers().trim().equals(personalDTO.getInteriorDomiPers().trim()) ||
                !PersonalAct.getIdPersona().getTipoZonaDomiPers().equals(personalDTO.getTipoZonaDomiPers()) ||
                !PersonalAct.getIdPersona().getNombreZonaDomiPers().trim().equals( personalDTO.getNombreZonaDomiPers().trim()) ||
                !PersonalAct.getIdPersona().getIdDistDomiPers().getIdDist().equals(personalDTO.getIdDistDomiPer()) ) {

            //guarda en historico
            itemHist = new PersonalHistorico();
            direccion="";
            if (PersonalAct.getIdPersona().getTipoViaDomiPers() != null) {direccion = tablastablaservice.findByCodigoTab( PersonalAct.getIdPersona().getTipoViaDomiPers() ).getDescrip2Tab() + " " + PersonalAct.getIdPersona().getDomicilioPers() +" ";}
            if(PersonalAct.getIdPersona().getNumeroDomiPers() != null) {direccion += PersonalAct.getIdPersona().getNumeroDomiPers() +", ";}
            if(PersonalAct.getIdPersona().getInteriorDomiPers() != null) {direccion += PersonalAct.getIdPersona().getInteriorDomiPers() +" ";}
            if (PersonalAct.getIdPersona().getTipoZonaDomiPers() != null) {direccion += tablastablaservice.findByCodigoTab( PersonalAct.getIdPersona().getTipoZonaDomiPers() ).getDescrip2Tab() +" ";}
            if (PersonalAct.getIdPersona().getNombreZonaDomiPers() != null) {direccion += PersonalAct.getIdPersona().getNombreZonaDomiPers() +" - ";}
            //System.out.println(PersonalAct.getIdDistDomiPer());
            if (PersonalAct.getIdPersona().getIdDistDomiPers() != null) {direccion += PersonalAct.getIdPersona().getIdDistDomiPers().getNombreDist(); }

            itemHist.setDireccionHist(direccion);
            itemHist.setCreaPorHist(personalDTO.getCreaPorPer());
            itemHist.setObraHist(PersonalAct.getObraPer());
            itemHist.setTipoHist("DIRECC");
            historico.add(itemHist);
        }

        PersonalAct.getIdPersona().setTipoViaDomiPers(personalDTO.getTipoViaDomiPers());
        PersonalAct.getIdPersona().setDomicilioPers(personalDTO.getDomicilioPers().trim());
        PersonalAct.getIdPersona().setNumeroDomiPers(personalDTO.getNumeroDomiPers().trim());
        PersonalAct.getIdPersona().setInteriorDomiPers(personalDTO.getInteriorDomiPers().trim());
        PersonalAct.getIdPersona().setTipoZonaDomiPers(personalDTO.getTipoZonaDomiPers());
        PersonalAct.getIdPersona().setNombreZonaDomiPers(personalDTO.getNombreZonaDomiPers().trim());
        PersonalAct.getIdPersona().setIdDistDomiPers( distDomi.get());

        PersonalAct.getIdPersona().setObservacionDomiPers(personalDTO.getObservacionDomiPers());
        PersonalAct.setFlgEsDiscapacitadoPer(personalDTO.getFlgEsDiscapacitadoPer());
        PersonalAct.setEspecDiscapacidadPer(personalDTO.getEspecDiscapacidadPer());
        PersonalAct.setFechaActivoPer(personalDTO.getFechaActivoPer());
        PersonalAct.setFechaBajaPer(personalDTO.getFechaBajaPer());
        PersonalAct.setModiPorPer(personalDTO.getModiPorPer());
        PersonalAct.setFechaModiPer(new Date());

        if (historico.size() > 0) {
            for (PersonalHistorico h : historico) {
                h.setPersonalHist(PersonalAct);
            }
            personalservice.saveAll(historico);
        }

        return personalservice.save(PersonalAct);
    }

    @PutMapping("/personalmedicoupdate/{idpersonal}/{obraname}")
    @ResponseStatus(HttpStatus.CREATED)
    public Personal updatepersonalInfoMedicosDTO(@RequestBody PersonalDatosMedicosDTO personalDTO, @PathVariable Long idpersonal, @PathVariable String obraname) {
        Personal PersonalAct = personalservice.findByIdPersonalAndObraname(idpersonal, obraname);

        PersonalAct.setFactorSangPer(personalDTO.getFactorSangPer());
        PersonalAct.setGrupoSangPer(personalDTO.getGrupoSangPer());

        PersonalAct.setFlgDonaSangrePer(personalDTO.getFlgDonaSangrePer());
        PersonalAct.setFlgEsHipertensoPer(personalDTO.getFlgEsHipertensoPer());
        PersonalAct.setFlgEsDiabeticoPer(personalDTO.getFlgEsDiabeticoPer());
        PersonalAct.setFlgcancerPer(personalDTO.getFlgAsmaPer());
        PersonalAct.setFlgEnferCardioPer(personalDTO.getFlgEnferCardioPer());
        PersonalAct.setFlgEnferPulmonPer(personalDTO.getFlgEnferPulmonPer());
        PersonalAct.setFlgEsInmunoSupresorPer(personalDTO.getFlgEsInmunoSupresorPer());
        PersonalAct.setFlgAsmaPer(personalDTO.getFlgAsmaPer());

        PersonalAct.setFlgTrabajoAltoRiesgoPer(personalDTO.getFlgTrabajoAltoRiesgoPer());
        PersonalAct.setNroPolizaPer(personalDTO.getNroPolizaPer());
        PersonalAct.setNombreCompPolizaPer(personalDTO.getNombreCompPolizaPer());
        PersonalAct.setBeneficiarioPolizaPer(personalDTO.getBeneficiarioPolizaPer());
        PersonalAct.setFechaModiPer(new Date());

        return personalservice.save(PersonalAct);
    }

    @PutMapping("/personalfinancieroupdate/{idpersonal}/{obraname}")
    @ResponseStatus(HttpStatus.CREATED)
    public Personal updatepersonalInfoFinancieraDTO(@RequestBody PersonalDatosBancariosDTO personalDTO, @PathVariable Long idpersonal, @PathVariable String obraname) {
        Personal PersonalAct = personalservice.findByIdPersonalAndObraname(idpersonal, obraname);

        PersonalAct.setIdEntidadHaberesPer(personalDTO.getIdEntidadHaberesPer());
        PersonalAct.setIdEntidadCtsPer(personalDTO.getIdEntidadCtsPer());
        PersonalAct.setIdTipoMonedaCtsPer(personalDTO.getIdTipoMonedaCtsPer());
        PersonalAct.setNroCtabacHaberesper(personalDTO.getNroCtabacHaberesper());
        PersonalAct.setNroCtabacCtsper(personalDTO.getNroCtabacCtsper());
        PersonalAct.setNroCtaintbacHaberesper(personalDTO.getNroCtaintbacHaberesper());
        PersonalAct.setNroCtaintbacCtsper(personalDTO.getNroCtaintbacCtsper());

        return personalservice.save(PersonalAct);
    }

    //HISTORICO DEL PERSONAL
    @Secured({"ROLE_PERS","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/listpersonalhistorico/{idpers}/{idobra}/{idtipo}")
    public List<PersonalHistoricoDTO> showpersonalInfoMedicosDTO(@PathVariable Long idpers, @PathVariable String idobra, @PathVariable String idtipo) {
        return personalservice.buscarPorIdPersonalAndObraAndTipo(idpers, idobra, idtipo);
    }
}
