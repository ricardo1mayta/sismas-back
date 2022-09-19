package com.spring.sigmaweb.backend.process.generic.controller;

import com.spring.sigmaweb.backend.process.generic.dto.ResponseStatusApp;
import com.spring.sigmaweb.backend.process.generic.dto.versionAppDTO;
import com.spring.sigmaweb.backend.process.generic.model.Obra;
import com.spring.sigmaweb.backend.process.generic.service.IObraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/sigmaweb/api")
public class ObraRestController {
    @Autowired
    private IObraService obraService;

    @GetMapping("/obras")
    public List<Obra> index(){
        return obraService.findAll();
    }

    @GetMapping("/obrascristostamar")
    public List<Obra> indexCritoAndStamar(){
        return obraService.findAllAddCristoStamar();
    }

    @GetMapping("/obrasid/{idobra}")
    public Optional<Obra> obrasid(@PathVariable String idobra){
        return obraService.findById(idobra);
    }

    @GetMapping("/versionapp")
    public List<versionAppDTO> versionApp(){
        versionAppDTO itemAnd= new versionAppDTO("android","1.0.1","https://play.google.com/store/apps/details?id=com.maristas.academic");
        versionAppDTO itemIos= new versionAppDTO("ios","1.0.1","https://apps.apple.com/pe/app/sigma-maristas/id1548168983");

        ArrayList<versionAppDTO> version = new ArrayList<versionAppDTO>();


        version.add(0,itemAnd) ;
        version.add(1,itemIos) ;
        return version;
    }

    @GetMapping("/obra/active/{idobra}")
    public ResponseStatusApp obrasidnew(@PathVariable String idobra){
        Optional<Obra> optionalObra = obraService.findById(idobra);
        if (!optionalObra.isPresent()) {
            return new ResponseStatusApp(false, "Obra no existe");
        }
        // Sube Cambios para volver a desplegar
        Integer active = optionalObra.get().getIdActivoApp();
        if (active == null) return new ResponseStatusApp(false, "No tiene un valor asignado");
        if (active == 1) return new ResponseStatusApp(true, "App Activa");
        if (active == 0) return new ResponseStatusApp(false, "Actualmente nos encontramos en mantenimiento, por favor vuelva a intentar más tarde, gracias");

        return new ResponseStatusApp(false, "No tiene un valor asignado");


    }

    @GetMapping("/health")
    public ArrayList<String>  health(){
        ArrayList<String> nombreArray = new ArrayList();
        nombreArray.add("{status : OK}");
        return nombreArray;
    }
}
