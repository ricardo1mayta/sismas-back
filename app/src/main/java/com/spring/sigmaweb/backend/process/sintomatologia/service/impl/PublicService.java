package com.spring.sigmaweb.backend.process.sintomatologia.service.impl;

import com.spring.sigmaweb.backend.process.sintomatologia.dto.*;
import com.spring.sigmaweb.backend.process.sintomatologia.model.*;
import com.spring.sigmaweb.backend.process.sintomatologia.repository.*;
import com.spring.sigmaweb.backend.utils.Utils;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;

import java.util.*;

@RequiredArgsConstructor
@Service
public class PublicService {

    private final IEnfermedadDao enfermedad;
    private final ISintomaDao sintoma;
    private final IFichaSintomatologicaDao  ficha;
    private final IFichaEnfermedadDao fichaEnfermedad;
    private final IFichaSintomaDao fichaSintomaDao;
    private final ModelMapper mapper;


    public ResponseEntity< Map<String,Object>> findByDocPersonalFicha(String numDoc, String obraName) {
        Map<String,Object> e = new HashMap<>();
        List<FichaSintomatologicaDTO> ps = ficha.findByDocPersonalFicha(numDoc, Utils.like(obraName));
        if (ps.size()>1){
            e.put("error","Seleccionar su Colegio");
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }

//        FichaSintomatologica fss =ficha.findFichaByDocByDay(numDoc, LocalDateTime.now());
//        if (fss !=null){
//            e.put("error"," Ya existe un registro!");
//            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
//        }

        FichaSintomatologicaDTO psf=null;
        for (FichaSintomatologicaDTO p:ps){
            psf=p;
            //psf.setFechaNacPers(Utils.fechaNac(p.getFechaNacPers()));
        }
        e.put("fichaSintomatologica",psf);
        return  new ResponseEntity<>(e, HttpStatus.OK);
    }

    public ResponseEntity< Map<String,Object>> findFichaDetalle(String numDoc,String obraName){
        Map<String,Object> e = new HashMap<>();
        FichaListEnfermedadSintomaDTO fl= null;
        List<EnfermedadDTO> fe = new ArrayList<>();
        List<SintomaDTO> fs= new ArrayList<>();
        SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd");
        Calendar calendar = Calendar.getInstance();
        Date dateObj = calendar.getTime();

        FichaSintomatologica fss =ficha.findFichaByDocByDay(numDoc, dateObj);
        if (fss==null){
            e.put("mensaje"," Ya existe un registro de la ficha sintomatológica con la fecha de hoy!");
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }

        FichaSintomatologicaDTO f = ficha.findByDocPersonalFichaDetalle(numDoc);
        if(f == null){
            List<FichaSintomatologicaDTO> ps = ficha.findByDocPersonalFicha(numDoc, Utils.like(obraName));
            if (ps.size()>1){
                e.put("mensaje","Seleccionar su Colegio/Obra");
                e.put("flag",true);
                return new ResponseEntity<>(e,HttpStatus.OK);
            }

            if(ps.size() == 0){
                e.put("mensaje","DNI: ".concat(numDoc).concat(" u Obra incorrecto, verificar!"));
                e.put("flag",false);
                return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
            }

            FichaSintomatologicaDTO psf=null;
            for (FichaSintomatologicaDTO p:ps){
                psf=p;
                String  fn= Utils.toDateSring(p.getFechaNacPers());
                psf.setEdad(Utils.calculateYear(fn));
            }

            fl= new FichaListEnfermedadSintomaDTO();
            fl.setFicha(psf);
            fl.setListEnfermedad(fe);
            fl.setListSintoma(fs);
            e.put("mensaje","");
            e.put("fichaSintomatologica",fl);
            e.put("flag",false);
            return  new ResponseEntity<>(e, HttpStatus.OK);
        }

        String  fn= Utils.toDateSring(f.getFechaNacPers());
        f.setEdad(Utils.calculateYear(fn));

        fe= fichaEnfermedad.listarEnfermedadDicha(f.getIdFicha());
        fs=fichaSintomaDao.listarSintomaFicha(f.getIdFicha());

        fl= new FichaListEnfermedadSintomaDTO();

        fl.setFicha(f);
        fl.setListEnfermedad(fe);
        fl.setListSintoma(fs);
        e.put("fichaSintomatologica",fl);

        return new ResponseEntity< Map<String,Object>>(e,HttpStatus.OK);
    }

    @Transactional
    public  ResponseEntity<Map<String,Object>> saveFicha(FichaSintomatologica f, List<Enfermedad> listenfermedad, List<Sintoma> listSintoma){
        Map<String,Object> response = new HashMap<>();
        ficha.save(f);
        listenfermedad.forEach(e->this.fichaEnfermedad.registrar(f.getIdFicha(),e.getIdEnfermedad()) );
        listSintoma.forEach(e->this.fichaSintomaDao.registrar(f.getIdFicha(),e.getIdSintoma()) );
        response.put("mensaje","Registro exitoso!");
        response.put("flag",false);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    public List<FichaEnfermedad> listarEnfermedadPorConsulta(Long idFicha){
       return  fichaEnfermedad.listarEnfermedadPorFicha(idFicha);
    }

    public List<Enfermedad> ListarEnfemerdades(){
        return enfermedad.findAll();
    }

    public List<Sintoma> ListarSintomas(){
        return sintoma.findAll();
    }
}
