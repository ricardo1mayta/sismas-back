package com.spring.sigmaweb.backend.process.legajo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.spring.sigmaweb.backend.process.generic.model.Distrito;
import com.spring.sigmaweb.backend.process.generic.model.TablasTabla;
import com.spring.sigmaweb.backend.process.generic.service.IDistritoService;
import com.spring.sigmaweb.backend.process.generic.service.ITablasTablaService;
import com.spring.sigmaweb.backend.process.legajo.dto.*;
import com.spring.sigmaweb.backend.process.legajo.model.Personal;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalHistorico;
import com.spring.sigmaweb.backend.process.legajo.service.IPersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/legajo/personal")
public class PersonalRestController {
    @Autowired
    private IPersonalService personalservice;

    @Autowired
    private ITablasTablaService tablastablaservice;

    @Autowired
    private IDistritoService distritoservice;

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
                !PersonalAct.getIdPersona().getNombreZonaDomiPers().trim().equals(personalDTO.getNombreZonaDomiPers().trim()) ||
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
        //System.out.println(personalDTO.getFlgEsDiscapacitadoPer());
        //System.out.println(personalDTO.getEspecDiscapacidadPer());
        PersonalAct.setFlgEsDiscapacitadoPer(personalDTO.getFlgEsDiscapacitadoPer());
        //PersonalAct.setFlgEsVoluntariadoPer(personalDTO.getFlgEsVoluntariadoPer());
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

    //HISTORICO DEL PERSONAL
    @Secured({"ROLE_PERS","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/listpersonalhistorico/{idpers}/{idobra}/{idtipo}")
    public List<PersonalHistoricoDTO> showpersonalInfoMedicosDTO(@PathVariable Long idpers, @PathVariable String idobra, @PathVariable String idtipo) {
        return personalservice.buscarPorIdPersonalAndObraAndTipo(idpers, idobra, idtipo);
    }
}
