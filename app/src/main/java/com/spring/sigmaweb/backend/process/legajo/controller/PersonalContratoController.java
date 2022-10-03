package com.spring.sigmaweb.backend.process.legajo.controller;

import com.spring.sigmaweb.backend.process.core.service.IUsuarioService;
import com.spring.sigmaweb.backend.process.legajo.dto.*;
import com.spring.sigmaweb.backend.process.legajo.model.*;
import com.spring.sigmaweb.backend.process.legajo.reports.ReportContract;
import com.spring.sigmaweb.backend.process.legajo.repository.IPersonalHistoricoVinculoLaboralDao;
import com.spring.sigmaweb.backend.process.legajo.service.IDocumentEmployeeService;
import com.spring.sigmaweb.backend.process.legajo.service.IPersonalContratoService;
import com.spring.sigmaweb.backend.process.legajo.service.IPersonalService;
import com.spring.sigmaweb.backend.process.legajo.service.IPersonalVidaLaboralService;
import com.spring.sigmaweb.backend.process.surveys.model.Encuesta;
import com.spring.sigmaweb.backend.process.surveys.model.MatrizEvaluacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.MediaSizeName;
import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/sigmaweb/legajo/personal/contrato")
public class PersonalContratoController {
    @Autowired
    private IPersonalContratoService personalcontratoservice;

    @Autowired
    private IPersonalService personalservice;

    @Autowired
    private IPersonalVidaLaboralService personalvidalaboralservice;


    @Autowired
    private IUsuarioService usuarioservice;

    @Autowired
    private IDocumentEmployeeService documentosservices;


    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/historicoactualportipo/{idObraHistvila}/{idPersonalHistvila}/{idPervilaHistvila}/{idPercontHistvila}/{tipo}")
    public HistoricoVilaLabotalDTO showHistoricoActualTipo(@PathVariable String idObraHistvila, @PathVariable Long idPersonalHistvila, @PathVariable Long idPervilaHistvila, @PathVariable Long idPercontHistvila, @PathVariable String tipo){
        return personalcontratoservice.findByUltimoCambioHistoricoVidaLab(idObraHistvila, idPersonalHistvila, idPervilaHistvila, idPercontHistvila, tipo);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/historicomasactualtipofecha/{idObraHistvila}/{idPersonalHistvila}/{idPervilaHistvila}/{idPercontHistvila}/{tipo}/{periodoIni}/{periodoFin}")
    public HistoricoVilaLabotalDTO showHistoricoACtualTipoFecha(@PathVariable String idObraHistvila, @PathVariable Long idPersonalHistvila, @PathVariable Long idPervilaHistvila, @PathVariable Long idPercontHistvila, @PathVariable String tipo, Integer periodoIni, Integer periodoFin){
        return personalcontratoservice.findByUltimoCambioHistoricoVidaLabMasActual(idObraHistvila, idPersonalHistvila, idPervilaHistvila, idPercontHistvila, tipo, periodoIni, periodoFin);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/contratoidcontrato/{idPerCont}")
    public PersonalContrato showContratoPorIdContrato(@PathVariable Long idPerCont){
        return personalcontratoservice.findByIdPerCont(idPerCont);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/contratoidcontratoobrapersonal/{idpersonal}/{idobra}/{idpercont}/{idpervila}")
    public PersonalContrato showContratoPorIdContratoAndObraAndIdpersonal(@PathVariable Long idpersonal, @PathVariable String idobra, @PathVariable Long idpercont, @PathVariable Long idpervila){
        return personalcontratoservice.findByPersonalAndObraAndcontrato(idpersonal, idobra, idpercont, idpervila);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/contratoobrapersonallist/{idpersonal}/{idobra}/{idpervila}")
    public List<PersonalContrato> showContratoPorIdContratoAndObraAndIdpersonalList(@PathVariable Long idpersonal, @PathVariable String idobra, @PathVariable Long idpervila){
        return personalcontratoservice.findByPersonalAndObraList(idpersonal, idobra, idpervila);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/contratoidcontratoobrapersonaldto/{idpersonal}/{idobra}/{idpercont}/{idpervila}")
    public PersonalContratoObraDTO showContratoPorIdContratoAndObraAndIdpersonalDTO(@PathVariable Long idpersonal, @PathVariable String idobra, @PathVariable Long idpercont, @PathVariable Long idpervila){
        return personalcontratoservice.findByPersonalAndObraAndcontratoDto(idpersonal, idobra, idpercont, idpervila);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/contratoobrapersonaldtolist/{idpersonal}/{idobra}/{idpervila}")
    public List<PersonalContratoObraDTO> showContratoPorObraAndIdpersonalDTOList(@PathVariable Long idpersonal, @PathVariable String idobra, @PathVariable Long idpervila){
        return personalcontratoservice.findByPersonalAndObraAndcontratoDtoList(idpersonal, idobra, idpervila);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/contratoactivopersonal/{idpersonal}/{idobra}/{idpervila}")
    public List<PersonalContratoObraDTO> showContratoActivopersonalDTOList(@PathVariable Long idpersonal, @PathVariable String idobra, @PathVariable Long idpervila){
        return personalcontratoservice.findContratoActivoPersonalObra(idpersonal, idobra, idpervila);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/contratoanteriorpersonalvidalaboral/{idpersonal}/{idobra}/{idpervila}/{idpercont}")
    public PersonalContratoObraDTO showContratoActivopersonalDTOList(@PathVariable Long idpersonal, @PathVariable String idobra, @PathVariable Long idpervila, @PathVariable Long idpercont){
        PersonalContratoObraDTO data = personalcontratoservice.findByPersonalAndObraAndcontratoDto(idpersonal, idobra, idpercont, idpervila);

        return personalcontratoservice.findAnteriorContratoPersonalVidaLaboralObra(idpersonal, idobra, idpervila, idpercont, data.getFechaIniPercont());
    }

    @PostMapping("/contratosave")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody PersonalContratoObraDTO contrato, BindingResult result) {
        PersonalContrato contratoNew = null;
        PersonalContrato contratoInsert = null;

        Personal persoContrato = personalservice.findByIdPersonalAndObraname(contrato.getIdPersonal(), contrato.getIdObraPercont());

        PersonalVidaLaboral vidaLaboral = personalvidalaboralservice.findByObraPersonalId(contrato.getIdObraPercont(), contrato.getIdPersonal(), contrato.getIdPervila());
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

            if(vidaLaboral == null) {
                //CREA UNO NUEVO
                vidaLaboral = new PersonalVidaLaboral();
                vidaLaboral.setIdObraPervila(contrato.getIdObraPercont());
                vidaLaboral.setIdPersonalPervila(persoContrato);
                vidaLaboral.setFechaInicioPervila(contrato.getFechaIniPercont());
                vidaLaboral.setEstadoPervila("ACTIVO");
                vidaLaboral.setFechaIngPervila(contrato.getFechaIngPercont());
                vidaLaboral.setCreaPorPervila(contrato.getCreaPorPercont());

                vidaLaboral = personalvidalaboralservice.save(vidaLaboral);
            } else if (vidaLaboral.getEstadoPervila().equals("FINALIZADO")) {
                //busca vida laboral activa
                PersonalVidaLabDTO vidaLaboralEnd = personalvidalaboralservice.ultimoPeriodoVidaLaboral(contrato.getIdObraPercont(), contrato.getIdPersonal());
                if(vidaLaboralEnd.getEstadoPervila().equals("FINALIZADO")){
                    //CREA UNO NUEVO
                    vidaLaboral = new PersonalVidaLaboral();
                    vidaLaboral.setIdObraPervila(contrato.getIdObraPercont());
                    vidaLaboral.setIdPersonalPervila(persoContrato);
                    vidaLaboral.setFechaInicioPervila(contrato.getFechaIniPercont());
                    vidaLaboral.setEstadoPervila("ACTIVO");
                    vidaLaboral.setFechaIngPervila(contrato.getFechaIngPercont());
                    vidaLaboral.setCreaPorPervila(contrato.getCreaPorPercont());

                    vidaLaboral = personalvidalaboralservice.save(vidaLaboral);
                } else if (vidaLaboralEnd.getEstadoPervila().equals("ACTIVO")){
                    vidaLaboral = personalvidalaboralservice.findByObraPersonalId(vidaLaboralEnd.getIdObraPervila(), vidaLaboralEnd.getIdPersonalPervila(), vidaLaboralEnd.getIdPervila());
                }

            } else if(persoContrato.getEstadoPer() == false){
                //NO DEBERIA DEJAR GUARDAR PORQUE ESTA FINALIZADO
                response.put("mensaje", "Error Vida Laboral finalizada.");
                response.put("error", "no es vida laboral actual");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }

            contratoInsert = new PersonalContrato();

            contratoInsert.setIdObraPercont(contrato.getIdObraPercont());
            contratoInsert.setIdPersonalPercont(persoContrato);
            contratoInsert.setIdPervilaPercont(vidaLaboral);
            contratoInsert.setIdTipoPercont(contrato.getIdTipoPercont());
            contratoInsert.setFechaIniPercont(contrato.getFechaIniPercont());
            contratoInsert.setFechaFinPercont(contrato.getFechaFinPercont());
            contratoInsert.setObservacionesPercont(contrato.getObservacionesPercont());
            contratoInsert.setEstadoPercont(contrato.getEstadoPercont());
            contratoInsert.setJornadaSemanalPercont(contrato.getJornadaSemanalPercont());
            contratoInsert.setRemuneracionPercont(contrato.getRemuneracionPercont());

            contratoInsert.setBonificacionPercont(contrato.getBonificacionPercont());
            contratoInsert.setFecIniPruebaPercont(contrato.getFecIniPruebaPercont());
            contratoInsert.setFecFinPruebaPercont(contrato.getFecFinPruebaPercont());
            contratoInsert.setFechaIngPercont(new Date());
            contratoInsert.setCreaPorPercont(contrato.getCreaPorPercont());

            contratoNew = personalcontratoservice.save(contratoInsert);

            //finalizar contratos anteriores, si hay
            List<PersonalContrato> contratosOld = personalcontratoservice.findByActivosPersonalAndObraList(contrato.getIdPersonal(), contrato.getIdObraPercont(), contrato.getIdPervila());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(contrato.getFechaIniPercont());
            calendar.add(Calendar.DAY_OF_YEAR, -1);
            Date dataOld = calendar.getTime();
            for (PersonalContrato c : contratosOld) {

                if( !c.getIdPerCont().equals(contratoNew.getIdPerCont()) ){
                    c.setEstadoPercont("FINALIZADO");
                    c.setFechaTerminoPercont(dataOld );
                    if(c.getIdTipoPercont().equals(15410)){ /*plazo indeterminado*/
                        c.setFechaFinPercont(dataOld);
                    }
                    personalcontratoservice.save(c);
                }
            }

            //Habilita el usuario relaciona al colaborador del contrato.
            usuarioservice.modificaEstadoUser(contrato.getIdObraPercont(), contrato.getIdPersonal(),"COLAB", true);
            

        } catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El item ha sido creado con éxito!");
        response.put("personalcontrato", contratoNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/contratoupdate/{idcontrato}/{idpersonal}/{obraname}/{idpervila}")
    @ResponseStatus(HttpStatus.CREATED)
    public PersonalContrato updateContratoDTO  (@RequestBody PersonalContratoObraDTO contratoDTO, @PathVariable Long idcontrato, @PathVariable Long idpersonal, @PathVariable String obraname, @PathVariable Long idpervila) {
        PersonalContrato contratoAct = personalcontratoservice.findByPersonalAndObraAndcontrato(idpersonal, obraname, idcontrato, idpervila);

        if(contratoAct != null) {

            contratoAct.setIdTipoPercont(contratoDTO.getIdTipoPercont());
            contratoAct.setFechaIniPercont(contratoDTO.getFechaIniPercont());
            contratoAct.setFechaFinPercont(contratoDTO.getFechaFinPercont());
            contratoAct.setObservacionesPercont(contratoDTO.getObservacionesPercont());
            contratoAct.setEstadoPercont(contratoDTO.getEstadoPercont());
            contratoAct.setJornadaSemanalPercont(contratoDTO.getJornadaSemanalPercont());
            contratoAct.setRemuneracionPercont(contratoDTO.getRemuneracionPercont());
            contratoAct.setBonificacionPercont(contratoDTO.getBonificacionPercont());
            contratoAct.setFecIniPruebaPercont(contratoDTO.getFecIniPruebaPercont());
            contratoAct.setFecFinPruebaPercont(contratoDTO.getFecFinPruebaPercont());
            contratoAct.setFechaModiPercont(new Date());
            contratoAct.setModiPorPercont(contratoDTO.getModiPorPercont());
        }
        return personalcontratoservice.save(contratoAct);
    }

    @Secured({"ROLE_ADMI", "ROLE_COLA"})
    @DeleteMapping("/contratodelete/{idpersonal}/{idobra}/{idcontrato}/{idvidalab}")
    public ResponseEntity<?> deleteContrato(@PathVariable Long idpersonal, @PathVariable String idobra, @PathVariable Long idcontrato, @PathVariable Long idvidalab){
        Map<String, Object> response = new HashMap<>();
        Boolean actoEliminar = true;
        PersonalContrato contratoDelete = personalcontratoservice.findByPersonalAndObraAndcontrato(idpersonal, idobra, idcontrato, idvidalab);
        List<DocumentEmployeeDTO> documentos= documentosservices.findByDocumentPersonalAndObraAndTipoList(idpersonal,idobra, "CONTRATO", idcontrato);
        try {

            if(contratoDelete != null){
                if(contratoDelete.getEstadoPercont().equals("FINALIZADO")){
                    if(documentos.size()>0){
                        response.put("mensaje", "No se puede Eliminar ");
                        response.put("error", "Hay documentos adjuntos al contrato a eliminar, elimínelos primero ");
                        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
                    } else {
                        personalcontratoservice.deletePersonalContrato(contratoDelete);
                    }

                } else {
                    response.put("mensaje", "No se puede Eliminar ");
                    response.put("error", "No se puede eliminar un contrato activo");
                    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
                }
            } else{
                response.put("mensaje", "Contrato no encontrada");
                response.put("error", "no se encuentra el contrato a eliminar");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
            }

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar el registro");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", " Se elimino el registro correctamente");
        response.put("personalcontrato", contratoDelete);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }


    //************************************* jornadas *******************************************

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/jornadaporidjornada/{idPerjorn}")
    public PersonalContratoJornada showJornadaIdjornada(@PathVariable Long idPerjorn){
        return personalcontratoservice.findByIdPerjorn(idPerjorn);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/jornadaporidjorncontratopersonalobra/{idpersonal}/{idobra}/{idpercont}/{idperjorn}")
    public PersonalContratoJornada showjornadaPorIdjornAndContratoAndObraAndIdpersonal(@PathVariable Long idpersonal, @PathVariable String idobra, @PathVariable Long idpercont, @PathVariable Long idperjorn){
        return personalcontratoservice.findByJornadaPersonalAndObraAndcontrato(idpersonal, idobra, idpercont,idperjorn);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/jornadaporcontratopersonalobra/{idpersonal}/{idobra}/{idpercont}")
    public List<PersonalContratoJornada> showjornadaPorContratoAndObraAndIdpersonal(@PathVariable Long idpersonal, @PathVariable String idobra, @PathVariable Long idpercont){
        return personalcontratoservice.findByJornadaPersonalAndObraAndcontratoList(idpersonal, idobra, idpercont);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/jornadaporidjorncontratopersonalobradto/{idpersonal}/{idobra}/{idpercont}/{idperjorn}")
    public JornadaPersonalContratoDTO showjornadaPorIdjornAndContratoAndObraAndIdpersonalDTO(@PathVariable Long idpersonal, @PathVariable String idobra, @PathVariable Long idpercont, @PathVariable Long idperjorn){
        return personalcontratoservice.findIdJornadaPersonalAndObraAndContratoDTO(idpersonal, idobra, idpercont,idperjorn);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/jornadaporcontratopersonalobradtolist/{idpersonal}/{idobra}/{idpercont}")
    public List<JornadaPersonalContratoDTO> showjornadaPorContratoAndObraAndIdpersonalDtoList(@PathVariable Long idpersonal, @PathVariable String idobra, @PathVariable Long idpercont){
        return personalcontratoservice.findJornadasPersonalAndObraAndContratoDTOList(idpersonal, idobra, idpercont);
    }

    @PostMapping("/jornadacontratosave")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody List<JornadaPersonalContratoDTO> jornada, BindingResult result) {
        PersonalContratoJornada jornadaNew = null;
        PersonalContratoJornada jornadaInsert = null;

        PersonalContrato persoContrato = personalcontratoservice.findByPersonalAndObraAndcontrato(jornada.get(0).getIdPersonal(), jornada.get(0).getIdObraPerjorn(), jornada.get(0).getIdPerCont(),jornada.get(0).getIdPersonal());

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
            for (JornadaPersonalContratoDTO jorn : jornada) {

                jornadaInsert = new PersonalContratoJornada();
                jornadaInsert.setIdPerjorn(jorn.getIdPerjorn());
                jornadaInsert.setIdPersonalContPerjorn(persoContrato);
                jornadaInsert.setIdObraPerjorn(jorn.getIdObraPerjorn());

                jornadaInsert.setIdDiaPerJorn(jorn.getIdDiaPerJorn());
                jornadaInsert.setDiaInihorPerjorn(jorn.getDiaInihorPerjorn());
                jornadaInsert.setDiaFinhorPerjorn(jorn.getDiaFinhorPerjorn());
                jornadaInsert.setTipoDiaPerjorn(jorn.getTipoDiaPerjorn());

                jornadaInsert.setCreaPorPerjorn(jorn.getCreaPorPerjorn());
                jornadaInsert.setFechaIngPerjorn(jorn.getFechaIngPerjorn());

                jornadaNew = personalcontratoservice.save(jornadaInsert);

            }

        } catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El item ha sido creado con éxito!");
        response.put("Entidad", jornadaNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/jornadaupdate/{idcontrato}/{idpersonal}/{obraname}")
    @ResponseStatus(HttpStatus.CREATED)
    public PersonalContratoJornada updateContratoDTO  (@RequestBody JornadaPersonalContratoDTO jornadaDTO, @PathVariable Long idcontrato, @PathVariable Long idjornada, @PathVariable Long idpersonal, @PathVariable String obraname) {
        PersonalContratoJornada jornadaAct = personalcontratoservice.findByJornadaPersonalAndObraAndcontrato(idpersonal,obraname, idcontrato, idjornada);

        if(jornadaAct != null) {
            jornadaAct.setIdDiaPerJorn(jornadaDTO.getIdDiaPerJorn());
            jornadaAct.setDiaInihorPerjorn(jornadaDTO.getDiaInihorPerjorn());
            jornadaAct.setDiaFinhorPerjorn(jornadaDTO.getDiaFinhorPerjorn());
            jornadaAct.setTipoDiaPerjorn(jornadaDTO.getTipoDiaPerjorn());


            jornadaAct.setCreaPorPerjorn(jornadaDTO.getCreaPorPerjorn());
            jornadaAct.setFechaIngPerjorn(jornadaDTO.getFechaIngPerjorn());
        }
        return personalcontratoservice.save(jornadaAct);
    }

    @Secured({"ROLE_ADMI"})
    @DeleteMapping("/jornadadeleteall/{idpersonal}/{obraname}/{idcontrato}")
    public ResponseEntity<?> deleteAll(@PathVariable Long idpersonal, @PathVariable String obraname, @PathVariable Long idcontrato){
        Map<String, Object> response = new HashMap<>();
        try {
            List<PersonalContratoJornada> jornadaDelete = personalcontratoservice.findByJornadaPersonalAndObraAndcontratoList(idpersonal, obraname, idcontrato);

            if(jornadaDelete.size()>0){
                personalcontratoservice.deleteAll(jornadaDelete);
            }

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar jornada");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", " Se eliminaron las jornadas del contrato");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }


    //Historico vida laboral
    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/historicovidalabobrapersonavidalabcontratoid/{idObra}/{idPersonal}/{idPervila}/{idPercont}/{idHistvila}")
    public PersonalHistoricoVinculoLaboral showHistoricoId(@PathVariable String idObra, @PathVariable Long idPersonal,
                                                                 @PathVariable Long idPervila, @PathVariable Long idPercont,
                                                                 @PathVariable Long idHistvila){
        return personalcontratoservice.findByIdObraHistvilaAndIdPersonalHistvilaAndIdPervilaHistvilaAndIdPercontHistvilaAndIdHistvila(idObra, idPersonal, idPervila, idPercont, idHistvila);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/historicovidalabobrapersonavidalabcontratotipolist/{idObra}/{idPersonal}/{idPervila}/{idPercont}/{tipo}")
    public List<PersonalHistoricoVinculoLaboral> showHistoricotipoList(@PathVariable String idObra, @PathVariable Long idPersonal,
                                                           @PathVariable Long idPervila, @PathVariable Long idPercont,
                                                           @PathVariable String tipo){
        return personalcontratoservice.findByObraAndPersonalAndVidaLabAndContratoAndtipoList(idObra, idPersonal, idPervila, idPercont, tipo);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/historicovidalabobrapersonavidalabcontratoidDto/{idObra}/{idPersonal}/{idPervila}/{idPercont}/{tipo}")
    public List<HistoricoVilaLabotalDTO> showHistoricoId(@PathVariable String idObra, @PathVariable Long idPersonal,
                                                         @PathVariable Long idPervila, @PathVariable Long idPercont,
                                                         @PathVariable String tipo){
        return personalcontratoservice.findByObraAndPersonalAndVidaLabAndContratoAndtipoListDto(idObra, idPersonal, idPervila, idPercont, tipo);
    }

    @PostMapping("/historicovidalabsave")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createHistoricoVidaLab(@RequestBody HistoricoVilaLabotalDTO historico, BindingResult result) {
        PersonalHistoricoVinculoLaboral HistoricoNew = null;
        PersonalHistoricoVinculoLaboral historicoInsert = null;

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
            historicoInsert = new PersonalHistoricoVinculoLaboral();
            historicoInsert.setIdObraHistvila(historico.getIdObraHistvila());
            historicoInsert.setIdPersonalHistvila(historico.getIdPersonalHistvila());
            historicoInsert.setIdPercontHistvila(historico.getIdPercontHistvila());
            historicoInsert.setIdPervilaHistvila(historico.getIdPervilaHistvila());

            historicoInsert.setMotivoHistvila(historico.getMotivoHistvila());
            historicoInsert.setTipoHistvila(historico.getTipoHistvila());
            historicoInsert.setFechaCambioHistvila(historico.getFechaCambioHistvila());
            historicoInsert.setJornadaSemaOldHistvila(historico.getJornadaSemaOldHistvila());
            historicoInsert.setBonificacionOldHistvila(historico.getBonificacionOldHistvila());
            historicoInsert.setRemuneracionOldHistvila(historico.getRemuneracionOldHistvila());


            if(historico.getTipoHistvila().equals("REMU")) {
                historicoInsert.setJornadaSemaNewHistvila(null);
                historicoInsert.setBonificacionNewHistvila(null);
                historicoInsert.setRemuneracionNewHistvila(historico.getRemuneracionNewHistvila());
            } else if(historico.getTipoHistvila().equals("JORN")) {
                historicoInsert.setJornadaSemaNewHistvila(historico.getJornadaSemaNewHistvila());
                historicoInsert.setRemuneracionNewHistvila(null);
                historicoInsert.setBonificacionNewHistvila(null);
            } else if(historico.getTipoHistvila().equals("BONIP") || historico.getTipoHistvila().equals("BONIC")) {
                historicoInsert.setJornadaSemaNewHistvila(null);
                historicoInsert.setBonificacionNewHistvila(historico.getBonificacionNewHistvila());
                historicoInsert.setJornadaSemaNewHistvila(null);
                historicoInsert.setIdPuestoCargoHistvila(historico.getIdPuestoCargoHistvila());
            }

            historicoInsert.setBonificacionNewHistvila(historico.getBonificacionNewHistvila());

            historicoInsert.setFechaIngHistvila(new Date());
            historicoInsert.setCreaPorHistvila(historico.getCreaPorHistvila());
            historicoInsert.setEstadoHistvila(historico.getEstadoHistvila());

            HistoricoNew = personalcontratoservice.saveHistVidaLab(historicoInsert);

        } catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El item ha sido creado con éxito!");
        response.put("personalhistoricovinculolaboral", HistoricoNew);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }


    @PutMapping("/historicovidalabupdate/{idObra}/{idPersonal}/{idPervila}/{idPercont}/{idHistvila}")
    @ResponseStatus(HttpStatus.CREATED)
    public PersonalHistoricoVinculoLaboral updateHistoricoVidaLabUpdate(@RequestBody HistoricoVilaLabotalDTO historico, @PathVariable String idObra, @PathVariable Long idPersonal,
                                                 @PathVariable Long idPervila, @PathVariable Long idPercont,
                                                 @PathVariable Long idHistvila) {

        PersonalHistoricoVinculoLaboral historicoAct = null;
        if(historico.getTipoHistvila().equals("BONIC") || historico.getTipoHistvila().equals("BONIP")){

            historicoAct = personalvidalaboralservice.findByIdObraHistvilaAndIdPersonalHistvilaAndIdPervilaHistvilaAndIdPuestoCargoHistvilaAndTipoHistvilaAndIdHistvila(idObra, idPersonal, idPervila, historico.getIdPuestoCargoHistvila() , historico.getTipoHistvila(), idHistvila);
        } else {
            historicoAct = personalcontratoservice.findByIdObraHistvilaAndIdPersonalHistvilaAndIdPervilaHistvilaAndIdPercontHistvilaAndIdHistvila(idObra, idPersonal, idPervila,idPercont, idHistvila);
        };

        if(historicoAct != null) {
            historicoAct.setMotivoHistvila(historico.getMotivoHistvila());
            historicoAct.setTipoHistvila(historico.getTipoHistvila());
            historicoAct.setFechaCambioHistvila(historico.getFechaCambioHistvila());

            historicoAct.setJornadaSemaOldHistvila(historico.getJornadaSemaOldHistvila());
            historicoAct.setBonificacionOldHistvila(historico.getBonificacionOldHistvila());
            historicoAct.setRemuneracionOldHistvila(historico.getRemuneracionOldHistvila());

            if(historico.getTipoHistvila().equals("REMU")) {
                historicoAct.setRemuneracionNewHistvila(historico.getRemuneracionNewHistvila());
                historicoAct.setJornadaSemaNewHistvila(null);
                historicoAct.setBonificacionNewHistvila(null);
            } else if(historico.getTipoHistvila().equals("JORN")) {
                historicoAct.setJornadaSemaNewHistvila(historico.getJornadaSemaNewHistvila());
                historicoAct.setRemuneracionNewHistvila(null);
                historicoAct.setBonificacionNewHistvila(null);
            } else if(historico.getTipoHistvila().equals("BONIP") || historico.getTipoHistvila().equals("BONIC")) {
                historicoAct.setJornadaSemaNewHistvila(null);
                historicoAct.setRemuneracionNewHistvila(null);
                historicoAct.setBonificacionNewHistvila(historico.getBonificacionNewHistvila());
            }

            historicoAct.setFechaModiHistvila(new Date());
            historicoAct.setModiPorHistvila(historico.getModiPorHistvila());
            historicoAct.setEstadoHistvila(historico.getEstadoHistvila());

            return personalcontratoservice.saveHistVidaLab(historicoAct);
        } else {
            return null;
        }


    }





}
