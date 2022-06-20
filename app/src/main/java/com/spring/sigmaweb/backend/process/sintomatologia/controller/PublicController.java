package com.spring.sigmaweb.backend.process.sintomatologia.controller;

import com.spring.sigmaweb.backend.process.legajo.model.Personal;
import com.spring.sigmaweb.backend.process.legajo.repository.IPersonalDao;
import com.spring.sigmaweb.backend.process.sintomatologia.dto.*;
import com.spring.sigmaweb.backend.process.sintomatologia.model.Enfermedad;
import com.spring.sigmaweb.backend.process.sintomatologia.model.FichaEnfermedad;
import com.spring.sigmaweb.backend.process.sintomatologia.model.FichaSintomatologica;
import com.spring.sigmaweb.backend.process.sintomatologia.model.Sintoma;
import com.spring.sigmaweb.backend.process.sintomatologia.service.impl.PublicService;
import com.spring.sigmaweb.backend.process.sintomatologia.task.NotificationTask;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = {"*"})
@RequiredArgsConstructor
@RestController
@RequestMapping("/sigmaweb/publics")
public class PublicController {

    private final PublicService publicService;
    private final ModelMapper mapper;
    private final IPersonalDao p;
    private final NotificationTask notificationTask;

    @GetMapping("/fichas/numDoc")
    public ResponseEntity<?>  findByDocPersonal(@RequestParam String numDoc, @RequestParam String obraName){
        return publicService.findByDocPersonalFicha(numDoc,obraName);
    }

    @PostMapping("/fichas/registrar")
    public ResponseEntity<?> registrar(@RequestBody FichaListEnfermedadSintomaDTO dto)  {
        FichaSintomatologica f = FichaSintomatologica.builder()
                    .personal(new Personal(dto.getFicha().getIdPersonal()))
                    .edad(dto.getFicha().getEdad())
                    .peso(dto.getFicha().getPeso())
                    .talla(dto.getFicha().getTalla())
                    .telefono(dto.getFicha().getTelefono())
                    .email(dto.getFicha().getEmailPers())
                    .flagContactoCovid(dto.getFicha().getFlagContactoCovid())
                    .fechaRegistro(new Date())
                    .idObra(dto.getFicha().getIdObra())
                    .build();
        List<Sintoma> sintomas = mapper.map(dto.getListSintoma(), new TypeToken<List<Sintoma>>() {
        }.getType());

        List<Enfermedad> enfermedades = mapper.map(dto.getListEnfermedad(), new TypeToken<List<Enfermedad>>() {
        }.getType());
        return publicService.saveFicha(f,enfermedades , sintomas);
    }

    @GetMapping("/fichas")
    public ResponseEntity<?> findFichaDetalle(@RequestParam String numDoc,@RequestParam String obraName){
        return  publicService.findFichaDetalle(numDoc,obraName);
    }

    @GetMapping("/fichas/enfermedad")
    public List<FichaEnfermedadDTO> listarEnfermedadPorConsulta(@RequestParam("idFicha") Long idFicha){

        List<FichaEnfermedad> fe=publicService.listarEnfermedadPorConsulta(idFicha);
        List<FichaEnfermedadDTO> fed=mapper.map(fe, new TypeToken<List<FichaEnfermedadDTO>>(){}.getType());
        return fed;
    }

    @GetMapping("/enfermedades")
    public List<EnfermedadDTO> listarEnfermedades(){
       List<Enfermedad>e = publicService.ListarEnfemerdades();
       List<EnfermedadDTO> dto=  mapper.map(e, new TypeToken<List<EnfermedadDTO>>(){}.getType());
       return dto;
    }

    @GetMapping("/sintomas")
    public List<SintomaDTO> listarSintomas(){
        List<Sintoma>e = publicService.ListarSintomas();
        List<SintomaDTO> dto=  mapper.map(e, new TypeToken<List<SintomaDTO>>(){}.getType());
        return dto;
    }

    @GetMapping("/mail")
    public void enviar(){
        notificationTask.sendNotificactionPendingRegister();
    }


    @GetMapping("/mail2")
    public void enviar2() throws Exception {
        notificationTask.sendNotificationFichaRegistered();
    }


}
