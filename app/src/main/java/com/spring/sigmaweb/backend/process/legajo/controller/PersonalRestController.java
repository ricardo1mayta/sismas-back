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
import com.spring.sigmaweb.backend.process.legajo.model.*;
import com.spring.sigmaweb.backend.process.legajo.service.IDocumentEmployeeService;
import com.spring.sigmaweb.backend.process.legajo.service.IEntidadService;
import com.spring.sigmaweb.backend.process.legajo.service.IPersonalService;
import com.spring.sigmaweb.backend.process.legajo.service.IPersonalVidaLaboralService;

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

    @Autowired
    private IDocumentEmployeeService documentemployeeservice;

    @Autowired
    private IPersonalVidaLaboralService vidalabservice;

    @Autowired
    private IEntidadService entidadservice;

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

    @Secured({"ROLE_PERS","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/dataplanillaweb/{obraname}")
    public List<dataPlanillaDTO> showListDataPlanillaDTO( @PathVariable String obraname) {
        return personalservice.listDataPlanilla(obraname);
    }

    //datos financieros
    @Secured({"ROLE_PERS","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/personalobrainfofinanciera/{obraname}/{idpersonal}")
    public PersonalDatosBancariosDTO showpersonalInfoFinanciera( @PathVariable String obraname, @PathVariable Long idpersonal) {
        return personalservice.findByObraAndidPersonalParaInfoBancario(obraname, idpersonal);
    }

    //document
    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/listdocuemplidpersonalobratipo/{idpersona}/{idobra}/{idtipo}/{idpadre}")
    public List<DocumentEmployeeDTO> showCargoPorId(@PathVariable Long idpersona, @PathVariable String idobra, @PathVariable String idtipo,@PathVariable Long idpadre){
        return documentemployeeservice.findByDocumentPersonalAndObraAndTipoList(idpersona,idobra, idtipo, idpadre);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/persdocdescviculacionitem/{idpersonal}/{idobra}/{tipodocumento}/{idopcion}/{idIPadre}")
    public DocumentEmployeeDTO showdocumentoDesvinculaPersonal(@PathVariable Long idpersonal, @PathVariable String idobra, @PathVariable String tipodocumento,
                                                                     @PathVariable Long idopcion, @PathVariable Long idIPadre){
        return documentemployeeservice.findByDocumentPersonalAndObraAndOpcionAndTipoDto(idpersonal, idobra, tipodocumento, idopcion, idIPadre);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/countporobratipoyopcion/{idObraFilePer}/{tipoFilePer}/{opcionFilePer}")
    public Long countObraTipoOpcion(@PathVariable String idObraFilePer, @PathVariable String tipoFilePer, @PathVariable Long opcionFilePer){
        return documentemployeeservice.countByIdObraFilePerAndtipoFilePerAndOpcionFilePer(idObraFilePer,tipoFilePer, opcionFilePer);
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

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @PutMapping("personalupdateactivo/{fechaactivo}")
    public Integer updatePersonalActivo(@RequestBody PersonalContratoObraDTO contratoUpd, @PathVariable String fechaactivo){
        Personal perFind = personalservice.findByIdPersonalAndObraname(contratoUpd.getIdPersonal(), contratoUpd.getIdObraPercont());
        Integer resp = 0;
        Boolean clearCod =false;



        if(perFind == null) {
            resp = 0;
        } else {
            if(perFind.getEstadoPer() == false) {
                // cuando habilite un colaborador reingresante debe verificar que el codigo no sea duplicado
                List<PersonalDatosListDTO> personal = personalservice.findByCodigoPerAndIdObra(perFind.getObraPer().getIdobra(), perFind.getCodigoPer());

                if (personal != null){
                    if(personal.size() == 1 ){
                        if( !personal.get(0).getIdPersonal().equals(perFind.getIdPersonal()) ){
                            //actualiza
                            clearCod=true;
                        }
                    } else {
                        //actualizar
                        clearCod = true;
                    }
                }

                resp = personalservice.updateColaboradorActivo(contratoUpd.getIdPersonal(), contratoUpd.getIdObraPercont(), fechaactivo, clearCod);
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

        Personal personalAct = personalservice.findByIdPersonalAndObraname(idpersonal, obraname);
        Persona personaAct = personaService.findByIdPersona( personalAct.getIdPersona().getIdPersona() );
        Obra obra = obraservice.findById(obraname).get();

        List<PersonalHistorico> historico = new ArrayList<PersonalHistorico>();
        String direccion="";

        PersonalHistorico itemHist = new PersonalHistorico();

        TablasTabla tablaT = tablastablaservice.findByCodigoTab(personalDTO.getIdTipoDocPer());

        Optional<Distrito> distDomi = distritoservice.findById(personalDTO.getIdDistDomiPer());
/*
        PersonalAct.getIdPersona().setNombrePers(personalDTO.getNombrePers());
        PersonalAct.getIdPersona().setApePaternoPers(personalDTO.getApePaternoPers());
        PersonalAct.getIdPersona().setApeMaternoPers(personalDTO.getApeMaternoPers());
        PersonalAct.setFotoPer(personalDTO.getFotoPer());
        PersonalAct.getIdPersona().setIdTipoDocPers(tablaT);
        PersonalAct.getIdPersona().setNroDocPers(personalDTO.getNroDocPers());
        PersonalAct.getIdPersona().setIdPaisDocPers(personalDTO.getIdPaisDocPers());
*/
        personaAct.setNombrePers(personalDTO.getNombrePers());
        personaAct.setApePaternoPers(personalDTO.getApePaternoPers());
        personaAct.setApeMaternoPers(personalDTO.getApeMaternoPers());
        personalAct.setFotoPer(personalDTO.getFotoPer());
        personaAct.setIdTipoDocPers(tablaT);
        personaAct.setNroDocPers(personalDTO.getNroDocPers());
        personaAct.setIdPaisDocPers(personalDTO.getIdPaisDocPers());

        if(!personaAct.getEstCivilPers().getCodigoTab().equals( personalDTO.getEstCivilPer() ) ) {

            //guarda en historico
            itemHist.setTipoEstCivilHist(personalAct.getIdPersona().getEstCivilPers().getCodigoTab());
            itemHist.setFechaCambECHist(personalAct.getIdPersona().getFecCambioEstCivilPers());
            itemHist.setCreaPorHist(personalDTO.getModiPorPer());
            itemHist.setObraHist(obra);//PersonalAct.getObraPer());
            itemHist.setTipoHist("ESTCIV");
            historico.add(itemHist);
        }

        tablaT = tablastablaservice.findByCodigoTab(personalDTO.getEstCivilPer());
        personaAct.setEstCivilPers(tablaT);
        personaAct.setFecCambioEstCivilPers(personalDTO.getFecCambioEstCivilPers());

        personaAct.setSexoPers(personalDTO.getSexoPers());
        personaAct.setCelularPers(personalDTO.getCelularPers());
        personaAct.setCelularBPers(personalDTO.getCelularBPers());
        personaAct.setTelefonoFijoPers(personalDTO.getTelefonoFijoPers());
        personaAct.setEmailPers(personalDTO.getEmailPers());
        personaAct.setEmailCorPers(personalDTO.getEmailCorPers());
        personalAct.setEstadoPer(personalDTO.getEstadoPer());
        personalAct.setContactoEmerPer(personalDTO.getContactoEmerPer());
        personalAct.setTelefContEmerPer(personalDTO.getTelefContEmerPer());
        personalAct.setIdParentContEmerPer(personalDTO.getIdParentContEmerPer());
        personaAct.setReligionProfesaPers(personalDTO.getReligionProfesaPers());
        personalAct.setNumeroEssaludPer(personalDTO.getNumeroEssaludPer());
        personalAct.setNumeroEpsPer(personalDTO.getNumeroEpsPer());
        personalAct.setIdEntidadEpsPer(personalDTO.getIdEntEPS());
        personalAct.setNumeroPensionPer(personalDTO.getNumeroPensionPer());
        personalAct.setIdEntidadPensPer(personalDTO.getIdEntPen());
        personalAct.setIdTipoPensionPer(personalDTO.getIdTipoPensionPer());
        personaAct.setFechaNacPers(personalDTO.getFechaNacPers());
        personaAct.setIdPaisNacPers(personalDTO.getIdPaisNacPers());
        personaAct.setNacionalidadPers(personalDTO.getNacionalidadPers());
        personaAct.setIdDistNacPers(personalDTO.getIdDistNacPers());
        personaAct.setObservaNacPers(personalDTO.getObservaNacPers());
        personalAct.setCodigoPer(personalDTO.getCodigoPer());

        if (!personaAct.getTipoViaDomiPers().equals(personalDTO.getTipoViaDomiPers()) ||
                !personaAct.getDomicilioPers().trim().equals(personalDTO.getDomicilioPers().trim()) ||
                !personaAct.getNumeroDomiPers().trim().equals(personalDTO.getNumeroDomiPers().trim()) ||
                !personaAct.getInteriorDomiPers().trim().equals(personalDTO.getInteriorDomiPers().trim()) ||
                !personaAct.getTipoZonaDomiPers().equals(personalDTO.getTipoZonaDomiPers()) ||
                !personaAct.getNombreZonaDomiPers().trim().equals( personalDTO.getNombreZonaDomiPers().trim()) ||
                !personaAct.getIdDistDomiPers().getIdDist().equals(personalDTO.getIdDistDomiPer()) ) {

            //guarda en historico
            itemHist = new PersonalHistorico();
            direccion="";
            if (personaAct.getTipoViaDomiPers() != null) {direccion = tablastablaservice.findByCodigoTab( personaAct.getTipoViaDomiPers() ).getDescrip2Tab() + " " + personaAct.getDomicilioPers() +" ";}
            if(personaAct.getNumeroDomiPers() != null) {direccion += personaAct.getNumeroDomiPers() +", ";}
            if(personaAct.getInteriorDomiPers() != null) {direccion += personaAct.getInteriorDomiPers() +" ";}
            if (personaAct.getTipoZonaDomiPers() != null) {direccion += tablastablaservice.findByCodigoTab( personaAct.getTipoZonaDomiPers() ).getDescrip2Tab() +" ";}
            if (personaAct.getNombreZonaDomiPers() != null) {direccion += personaAct.getNombreZonaDomiPers() +" - ";}

            if (personaAct.getIdDistDomiPers() != null) {direccion += personaAct.getIdDistDomiPers().getNombreDist(); }

            itemHist.setDireccionHist(direccion);
            itemHist.setCreaPorHist(personalDTO.getCreaPorPer());
            itemHist.setObraHist(obra);//PersonalAct.getObraPer());
            itemHist.setTipoHist("DIRECC");
            historico.add(itemHist);
        }

        personaAct.setTipoViaDomiPers(personalDTO.getTipoViaDomiPers());
        personaAct.setDomicilioPers(personalDTO.getDomicilioPers().trim());
        personaAct.setNumeroDomiPers(personalDTO.getNumeroDomiPers().trim());
        personaAct.setInteriorDomiPers(personalDTO.getInteriorDomiPers().trim());
        personaAct.setTipoZonaDomiPers(personalDTO.getTipoZonaDomiPers());
        personaAct.setNombreZonaDomiPers(personalDTO.getNombreZonaDomiPers().trim());
        personaAct.setIdDistDomiPers( distDomi.get());

        personaAct.setObservacionDomiPers(personalDTO.getObservacionDomiPers());
        personaAct.setFechaModiPers(new Date());
        personaAct.setModiPorPers(personalDTO.getModiPorPer());
        personalAct.setFlgEsDiscapacitadoPer(personalDTO.getFlgEsDiscapacitadoPer());
        personalAct.setEspecDiscapacidadPer(personalDTO.getEspecDiscapacidadPer());
        personalAct.setFechaActivoPer(personalDTO.getFechaActivoPer());
        personalAct.setFechaBajaPer(personalDTO.getFechaBajaPer());
        personalAct.setModiPorPer(personalDTO.getModiPorPer());
        personalAct.setFechaModiPer(new Date());
        personalAct.setIdPersona(personaAct);

        if (historico.size() > 0) {
            for (PersonalHistorico h : historico) {
                h.setPersonalHist(personalAct);
            }
            personalservice.saveAll(historico);
        }
        personalAct.setObraPer(obra);
        return personalservice.save(personalAct);
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
        List<PersonalHistorcoBancario> historico = new ArrayList<PersonalHistorcoBancario>();
        PersonalHistorcoBancario itemHist = new PersonalHistorcoBancario();
        PersonalDatosBancariosDTO dataoldDTO = personalservice.findByObraAndidPersonalParaInfoBancario(obraname, idpersonal);
        //verifica en historico

        PersonalVidaLabDTO vidaladhist = vidalabservice.ultimoPeriodoVidaLaboral(obraname, idpersonal);
        if(vidaladhist == null) {
            return null;
        }

        if(vidaladhist.getEstadoPervila().equals("FINALIZADO")) {
            return null;
        }

        //desnulea
        Long entHabold = PersonalAct.getIdEntidadHaberesPer() == null ? Long.parseLong("-1") : PersonalAct.getIdEntidadHaberesPer();
        Long entHabnew = personalDTO.getIdEntidadHaberesPer() == null ? Long.parseLong("-1") : personalDTO.getIdEntidadHaberesPer();
        String ctaBancohabold = PersonalAct.getNroCtabacHaberesPer() == null ? " " : PersonalAct.getNroCtabacHaberesPer();
        String ctaBancohabnew = personalDTO.getNroCtabacHaberesPer() == null ? " " : personalDTO.getNroCtabacHaberesPer();
        String ctaInterhabold = PersonalAct.getNroCtaintbacHaberesPer() == null ? " " : PersonalAct.getNroCtaintbacHaberesPer();
        String ctaInterhabnew = personalDTO.getNroCtaintbacHaberesPer() == null ? " " : personalDTO.getNroCtaintbacHaberesPer();


        if (!entHabold.equals(entHabnew) ||
                !ctaBancohabold.equals(ctaBancohabnew) ||
                !ctaInterhabold.equals(ctaInterhabnew) ) {

            itemHist.setFechaCambioHistdb(new Date());
            itemHist.setIdObraHistdb(obraname);
            itemHist.setIdPersonalHistdb(idpersonal);
            itemHist.setIdPervilaHistdb(vidaladhist.getIdPervila());
            itemHist.setTipoHistdb("HAB");


            itemHist.setEntidadHabOldHistdb(dataoldDTO.getEntidadHaberesPer() );
            itemHist.setEntidadHabNewHistdb(personalDTO.getEntidadHaberesPer() );
            itemHist.setCtaBancoHabOldHistdb(PersonalAct.getNroCtabacHaberesPer());
            itemHist.setCtaBancoHabNewHistdb(personalDTO.getNroCtabacHaberesPer());

            itemHist.setCtaInterHabOldHistdb(PersonalAct.getNroCtaintbacHaberesPer());
            itemHist.setCtaInterHabNewHistdb(personalDTO.getNroCtaintbacHaberesPer());


            historico.add(itemHist);
        }

        Long entCtsold = PersonalAct.getIdEntidadCtsPer() == null ? Long.parseLong("-1") : PersonalAct.getIdEntidadCtsPer();
        Long entCtsnew = personalDTO.getIdEntidadCtsPer() == null ? Long.parseLong("-1") : personalDTO.getIdEntidadCtsPer();
        String ctaBancoCtsold = PersonalAct.getNroCtabacCtsPer() == null ? " " : PersonalAct.getNroCtabacCtsPer();
        String ctaBancoCtsnew = personalDTO.getNroCtabacCtsPer() == null ? " " : personalDTO.getNroCtabacCtsPer();
        String ctaInterCtsold = PersonalAct.getNroCtaintbacCtsPer() == null ? " " : PersonalAct.getNroCtaintbacCtsPer();
        String ctaInterCtsnew = personalDTO.getNroCtaintbacCtsPer() == null ? " " : personalDTO.getNroCtaintbacCtsPer();
        Integer monedaCtsold = PersonalAct.getIdTipoMonedaCtsPer() == null ? Integer.parseInt("-1") : PersonalAct.getIdTipoMonedaCtsPer();
        Integer monedaCtsnew = personalDTO.getIdTipoMonedaCtsPer() == null ? Integer.parseInt("-1") : personalDTO.getIdTipoMonedaCtsPer();


        if (!entCtsold.equals(entCtsnew) ||
                !ctaBancoCtsold.equals(ctaBancoCtsnew) ||
                !ctaInterCtsold.equals(ctaInterCtsnew) ||
                !monedaCtsold.equals(monedaCtsnew) ) {
            itemHist = new PersonalHistorcoBancario();
            itemHist.setFechaCambioHistdb(new Date());
            itemHist.setIdObraHistdb(obraname);
            itemHist.setIdPersonalHistdb(idpersonal);
            itemHist.setIdPervilaHistdb(vidaladhist.getIdPervila());
            itemHist.setTipoHistdb("CTS");


            itemHist.setEntidadCtsOldHistdb(dataoldDTO.getEntidadCtsPer() );
            itemHist.setEntidadCtsNewHistdb(personalDTO.getEntidadCtsPer() );

            itemHist.setCtaBancoCtsOldHistdb(PersonalAct.getNroCtabacCtsPer());
            itemHist.setCtaBancoCtsNewHistdb(personalDTO.getNroCtabacCtsPer());

            itemHist.setCtaInterCtsOldHistdb(PersonalAct.getNroCtaintbacCtsPer());
            itemHist.setCtaInterCtsNewHistdb(personalDTO.getNroCtaintbacCtsPer());

            itemHist.setTipoMonedaCtsOldHistdb(dataoldDTO.getTipoMonedaCtsPer());
            itemHist.setTipoMonedaCtsNewHistdb(personalDTO.getTipoMonedaCtsPer());
            historico.add(itemHist);
        }

        PersonalAct.setIdEntidadHaberesPer(personalDTO.getIdEntidadHaberesPer());
        PersonalAct.setIdEntidadCtsPer(personalDTO.getIdEntidadCtsPer());
        PersonalAct.setIdTipoMonedaCtsPer(personalDTO.getIdTipoMonedaCtsPer());
        PersonalAct.setNroCtabacHaberesPer(personalDTO.getNroCtabacHaberesPer());
        PersonalAct.setNroCtabacCtsPer(personalDTO.getNroCtabacCtsPer());
        PersonalAct.setNroCtaintbacHaberesPer(personalDTO.getNroCtaintbacHaberesPer());
        PersonalAct.setNroCtaintbacCtsPer(personalDTO.getNroCtaintbacCtsPer());

        PersonalAct.setFlgRequiereAperturaCtaCtsPer(personalDTO.getFlgRequiereAperturaCtaCtsPer());
        PersonalAct.setFlgRequiereAperturaCtaHaberesPer(personalDTO.getFlgRequiereAperturaCtaHaberesPer());

        if(personalDTO.getFlgRequiereAperturaCtaCtsPer() != null){
            if(personalDTO.getFlgRequiereAperturaCtaCtsPer().equals("R")){
                PersonalAct.setFechaResAperturaCtaCtsPer(new Date());
            } else if(personalDTO.getFlgRequiereAperturaCtaCtsPer().equals("S")){
                PersonalAct.setFechaSolAperturaCtaCtsPer(new Date());
            }
        }

        if(personalDTO.getFlgRequiereAperturaCtaHaberesPer() != null){
            if(personalDTO.getFlgRequiereAperturaCtaHaberesPer().equals("R")){
                PersonalAct.setFechaResAperturaCtaHaberesPer(new Date());
            } else if(personalDTO.getFlgRequiereAperturaCtaHaberesPer().equals("S")){
                PersonalAct.setFechaSolAperturaCtaHaberesPer(new Date());
            }
        }

        PersonalAct.setFlgPermitirCambioCtsPer(personalDTO.getFlgPermitirCambioCtsPer());
        PersonalAct.setFlgPermitirCambioHaberesPer(personalDTO.getFlgPermitirCambioHaberesPer());

        if (historico.size() > 0) {
            for (PersonalHistorcoBancario h : historico) {
                personalservice.saveHistBancario(h);
            }
        }

        return personalservice.save(PersonalAct);
    }

    //HISTORICO DEL PERSONAL
    @Secured({"ROLE_PERS","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/listpersonalhistorico/{idpers}/{idobra}/{idtipo}")
    public List<PersonalHistoricoDTO> showpersonalInfoMedicosDTO(@PathVariable Long idpers, @PathVariable String idobra, @PathVariable String idtipo) {
        return personalservice.buscarPorIdPersonalAndObraAndTipo(idpers, idobra, idtipo);
    }

    //documewntos de personal save/update/delete

    @PostMapping("/documentosave")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createdocumentoPersonal(@RequestBody DocumentEmployeeDTO documentoDTO, BindingResult result) {
        DocumentEmployee documentoNew = null;
        DocumentEmployee documentoInsert = null;
        Personal persoDocumento = personalservice.findByIdPersonalAndObraname(documentoDTO.getIdPersonal(), documentoDTO.getIdObraFilePer());
        Map<String, Object> response = new HashMap<>();
        String idFile = documentemployeeservice.generateIdFile(documentoDTO.getIdPersonal(), documentoDTO.getIdObraFilePer(), documentoDTO.getTipoFilePer(), documentoDTO.getIdItemPadreFileper(), documentoDTO.getOpcionFilePer() );
        if(result.hasErrors()) {

            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        try {
            documentoInsert = new DocumentEmployee();
            documentoInsert.setIdFilePer(idFile);
            documentoInsert.setIdObraFilePer(documentoDTO.getIdObraFilePer());
            documentoInsert.setIdPersonalFilePer(persoDocumento);
            documentoInsert.setTitleFilePer(documentoDTO.getTitleFilePer());
            documentoInsert.setFileNameFilePer(documentoDTO.getFileNameFilePer());
            documentoInsert.setUrlFilePer(documentoDTO.getUrlFilePer());

            documentoInsert.setTipoFilePer(documentoDTO.getTipoFilePer());
            documentoInsert.setOpcionFilePer(documentoDTO.getOpcionFilePer());
            documentoInsert.setIdItemPadreFileper(documentoDTO.getIdItemPadreFileper());

            documentoInsert.setDescripcionFilePer(documentoDTO.getDescripcionFilePer());
            documentoInsert.setTypeFilePer(documentoDTO.getTypeFilePer());
            documentoInsert.setSizeFilePer(documentoDTO.getSizeFilePer());

            documentoInsert.setUploadDateFilePer(documentoDTO.getUploadDateFilePer());
            documentoInsert.setCreaPorFilePer(documentoDTO.getCreaPorFilePer());

            documentemployeeservice.insertNativeDocumentoUpload(documentoInsert);//documentemployeeservice.save(documentoInsert);

            documentoNew = documentemployeeservice.findByDocumentPersonalAndObraAndTipoAndId(documentoInsert.getIdPersonalFilePer().getIdPersonal(), documentoInsert.getIdObraFilePer(), documentoInsert.getTipoFilePer(), documentoInsert.getOpcionFilePer(),
                    documentoInsert.getIdItemPadreFileper(), documentoInsert.getIdFilePer());

        } catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El item ha sido creado con éxito!");
        response.put("document", documentoNew);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @DeleteMapping("/documentopersonaldelete/{idpersonal}/{idobra}/{tipodocumento}/{idopcion}/{idIPadre}/{iddocu}")
    public ResponseEntity<?> delete(@PathVariable Long idpersonal, @PathVariable String idobra, @PathVariable String tipodocumento, @PathVariable Long idopcion, @PathVariable Long idIPadre, @PathVariable String iddocu){

        Map<String, Object> response = new HashMap<>();

        try {
            DocumentEmployee documentDelete = documentemployeeservice.findByDocumentPersonalAndObraAndTipoAndId(idpersonal, idobra, tipodocumento, idopcion, idIPadre, iddocu);
            documentemployeeservice.delete(documentDelete);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar el Documento de la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", " Se elimino el archivo con exito!");

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/tipodocumentoid/{idTipoFile}/{idObraTipoFile}")
    public TipoDocumento showTipoDocId(@PathVariable Long idTipoFile, @PathVariable String idObraTipoFile) {
        return documentemployeeservice.findByIdTipoFileAndIdObraTipoFile(idTipoFile, idObraTipoFile);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/tipodocumentotipo/{tipoFile}/{idObraTipoFile}")
    public List<TipoDocumento> showTipoDocTipo(@PathVariable String tipoFile, @PathVariable String idObraTipoFile) {
        return documentemployeeservice.findByTipoFileAndIdObraTipoFile(tipoFile, idObraTipoFile);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/tipodocumentoidestado/{tipoFile}/{estadoTipoFile}/{idObraTipoFile}")
    public List<TipoDocumento> showTipoDocTipoEstado(@PathVariable String tipoFile, @PathVariable Boolean estadoTipoFile, @PathVariable String idObraTipoFile) {
        return documentemployeeservice.findByTipoFileAndEstadoTipoFileAndIdObraTipoFile(tipoFile, estadoTipoFile, idObraTipoFile);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/tipodocumentoidcodigoestado/{tipoFile}/{codigoTipoFile}/{estadoTipoFile}/{idObraTipoFile}")
    public List<TipoDocumento> showTipoDocTipoEstadoAndcodigo(@PathVariable String tipoFile, @PathVariable String codigoTipoFile, @PathVariable Boolean estadoTipoFile, @PathVariable String idObraTipoFile) {
        return documentemployeeservice.findByTipoFileAndCodigoTipoFileAndEstadoTipoFileAndIdObraTipoFile(tipoFile, codigoTipoFile, estadoTipoFile, idObraTipoFile);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/tipodocumentoidcodigoestadorepeat/{tipoFile}/{codigoTipoFile}/{estadoTipoFile}/{idObraTipoFile}/{numRepeatTipoFile}")
    public List<TipoDocumento> showTipoDocTipoEstadoAndcodigoAndRepedir(@PathVariable String tipoFile, @PathVariable String codigoTipoFile, @PathVariable Boolean estadoTipoFile, @PathVariable String idObraTipoFile, @PathVariable Integer numRepeatTipoFile) {
        return documentemployeeservice.findByTipoFileAndCodigoTipoFileAndEstadoTipoFileAndIdObraTipoFileAndNumRepeatTipoFile(tipoFile, codigoTipoFile, estadoTipoFile, idObraTipoFile, numRepeatTipoFile);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/tipodocumentoidcodigoestadoall/{tipoFile}/{codigoTipoFile}/{estadoTipoFile}/{idObraTipoFile}")
    public List<TipoDocumento> showTipoDocTipoEstadoAndcodigoPublicos(@PathVariable String tipoFile, @PathVariable String codigoTipoFile, @PathVariable Boolean estadoTipoFile, @PathVariable String idObraTipoFile) {
        return documentemployeeservice.findByTipoCodigoEstadoObras(tipoFile, codigoTipoFile, estadoTipoFile, idObraTipoFile);
    }


    @PostMapping("/tipodocumentosave")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createTipoDocumento(@RequestBody TipoDocumento documento, BindingResult result) {
        TipoDocumento documentoNew = null;
        TipoDocumento documentoInsert = null;

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
            documentoInsert = new TipoDocumento();
            documentoInsert.setDescripTipoFile(documento.getDescripTipoFile());
            documentoInsert.setCodigoTipoFile(documento.getCodigoTipoFile());
            documentoInsert.setIdObraTipoFile(documento.getIdObraTipoFile());
            documentoInsert.setTipoFile(documento.getTipoFile());
            documentoInsert.setEstadoTipoFile(documento.getEstadoTipoFile());
            documentoInsert.setNumRepeatTipoFile(documento.getNumRepeatTipoFile());
            documentoInsert.setFechaIngTipoFile(new Date());

            documentoNew = documentemployeeservice.save(documentoInsert);

        } catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El item ha sido creado con éxito!");
        response.put("TipoDocumento", documentoNew);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }


    @PutMapping("/tipodocumentoupdate/{idtipofile}/{obraname}")
    @ResponseStatus(HttpStatus.CREATED)
    public TipoDocumento updatepersonalInfoFinancieraDTO(@RequestBody String descripcion, @PathVariable Long idtipofile, @PathVariable String obraname) {
        TipoDocumento tipoDocumentoAct = documentemployeeservice.findByIdTipoFileAndIdObraTipoFile(idtipofile,obraname);

        tipoDocumentoAct.setDescripTipoFile(descripcion);

        return documentemployeeservice.save(tipoDocumentoAct);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @DeleteMapping("/tipodocumentodelete/{obraname}/{idtipofile}")
    public ResponseEntity<?> deleteTipoDocumento( @PathVariable String obraname,@PathVariable Long idtipofile){

        Map<String, Object> response = new HashMap<>();

        try {
            TipoDocumento tipoDocumentoDelete = documentemployeeservice.findByIdTipoFileAndIdObraTipoFile(idtipofile,obraname);
            documentemployeeservice.delete(tipoDocumentoDelete);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar el tipo de Documento de la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", " Se elimino el tipo de documento con exito!");

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    //historico info bancaria
    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/historicoinfobancariaobrapersonalvidala/{idObraHistdb}/{idPersonalHistdb}/{idPervilaHistdb}")
    public List<PersonalHistorcoBancario> showHistoricoInfoBancarioPorObraPersonalVidaLab(@PathVariable String idObraHistdb, @PathVariable long idPersonalHistdb, @PathVariable Long idPervilaHistdb) {
        return personalservice.findByIdObraHistdbAndIdPersonalHistdbAndIdPervilaHistdb(idObraHistdb, idPersonalHistdb, idPervilaHistdb);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/historicoinfobancariaobrapersonalvidalaid/{tipoFile}/{estadoTipoFile}/{idObraTipoFile}/{idHistdb}")
    public PersonalHistorcoBancario showHistoricoInfoBancarioPorObraPersonalVidaLabId(@PathVariable String idObraHistdb, @PathVariable long idPersonalHistdb, @PathVariable Long idPervilaHistdb, @PathVariable Long idHistdb) {
        return personalservice.findByIdObraHistdbAndIdPersonalHistdbAndIdPervilaHistdbAndIdHistdb(idObraHistdb, idPersonalHistdb, idPervilaHistdb,idHistdb);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/historicoinfobancariaobrapersonalvidalatipo/{idObraHistdb}/{idPersonalHistdb}/{idPervilaHistdb}/{tipoHistdb}")
    public List<PersonalHistorcoBancario> showHistoricoInfoBancarioPorObraPersonalVidaLabTipo(@PathVariable String idObraHistdb, @PathVariable long idPersonalHistdb, @PathVariable Long idPervilaHistdb, @PathVariable String tipoHistdb) {
        return personalservice.findByIdObraHistdbAndIdPersonalHistdbAndIdPervilaHistdbAndTipoHistdb(idObraHistdb, idPersonalHistdb, idPervilaHistdb, tipoHistdb);
    }


    @PostMapping("/historicoinfobancariasave")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createHistoricoInfoBancaria(@RequestBody PersonalHistorcoBancario historico, BindingResult result) {
        PersonalHistorcoBancario HistoricoNew = null;
        PersonalHistorcoBancario historicoInsert = null;

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
            historicoInsert = new PersonalHistorcoBancario();
            historicoInsert.setIdObraHistdb(historico.getIdObraHistdb());
            historicoInsert.setIdPersonalHistdb(historico.getIdPersonalHistdb());
            historicoInsert.setIdPervilaHistdb(historico.getIdPervilaHistdb());
            historicoInsert.setFechaCambioHistdb(historico.getFechaCambioHistdb());
            historicoInsert.setTipoHistdb(historico.getTipoHistdb());

            historicoInsert.setEntidadHabOldHistdb(historico.getEntidadHabOldHistdb());
            historicoInsert.setEntidadHabNewHistdb(historico.getEntidadHabNewHistdb());
            historicoInsert.setCtaBancoHabOldHistdb(historico.getCtaBancoHabOldHistdb());
            historicoInsert.setCtaBancoHabNewHistdb(historico.getCtaBancoHabNewHistdb());
            historicoInsert.setCtaInterHabOldHistdb(historico.getCtaInterHabOldHistdb());
            historicoInsert.setCtaInterHabNewHistdb(historico.getCtaInterHabNewHistdb());

            historicoInsert.setEntidadCtsOldHistdb(historico.getEntidadCtsOldHistdb());
            historicoInsert.setEntidadCtsNewHistdb(historico.getEntidadCtsNewHistdb());
            historicoInsert.setCtaBancoCtsOldHistdb(historico.getCtaBancoCtsOldHistdb());
            historicoInsert.setCtaBancoCtsNewHistdb(historico.getCtaBancoCtsNewHistdb());
            historicoInsert.setCtaInterCtsOldHistdb(historico.getCtaInterCtsOldHistdb());
            historicoInsert.setCtaInterCtsNewHistdb(historico.getCtaInterCtsNewHistdb());
            historicoInsert.setTipoMonedaCtsOldHistdb(historico.getTipoMonedaCtsOldHistdb());
            historicoInsert.setTipoMonedaCtsNewHistdb(historico.getTipoMonedaCtsNewHistdb());

            HistoricoNew = personalservice.saveHistBancario(historicoInsert);

        } catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El item ha sido creado con éxito!");
        response.put("personalhistorcobancario", HistoricoNew);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PostMapping("/updatedataplanillasave")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> updateDataPlanilla(@RequestBody dataupdatePlanilla data, BindingResult result) {
        Double basico = 0.00;
        Double bonificacion = 0.00;
        Double jornada = 0.00;

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

            this.personalservice.updatePlanilla(data.getP_idpersonal(),data.getP_obra(), data.getP_idpervila(),data.getP_codigo(),
                    data.getP_usuario(), data.getP_sexo(), data.getP_fecha_ingreso(), data.getP_num_ipss(),
                    data.getP_num_cuspp(), data.getP_afp(), data.getP_ocupacion(),
                    data.getP_contrato(), data.getP_basico(), data.getP_bonicargo(), data.getP_jornadas());


        } catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El item ha sido creado con éxito!");
        response.put("personaldesvinculacion", data);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @GetMapping("buscar/usuario/{idUsuario}")
    public PersonalDatosListDTO personal(@PathVariable Long idUsuario){
        return personalservice.findByIdUser(idUsuario);
    }
}
