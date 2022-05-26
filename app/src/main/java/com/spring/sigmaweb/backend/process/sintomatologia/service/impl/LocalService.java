package com.spring.sigmaweb.backend.process.sintomatologia.service.impl;

import com.spring.sigmaweb.backend.process.sintomatologia.dto.*;
import com.spring.sigmaweb.backend.process.sintomatologia.model.FichaExport;
import com.spring.sigmaweb.backend.process.sintomatologia.model.FichaSintomatologica;
import com.spring.sigmaweb.backend.process.sintomatologia.repository.IFichaEnfermedadDao;
import com.spring.sigmaweb.backend.process.sintomatologia.repository.IFichaSintomaDao;
import com.spring.sigmaweb.backend.process.sintomatologia.repository.IFichaSintomatologicaDao;
import com.spring.sigmaweb.backend.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.modelmapper.ModelMapper;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class LocalService {
    private final IFichaSintomatologicaDao ficha;
    private final IFichaEnfermedadDao fichaEnfermedad;
    private final IFichaSintomaDao fichaSintomaDao;
    private final ModelMapper mapper;
    private final ResourceLoader resourceLoader;


    public FichaSintomatologicaDTO actualizar(FichaSintomatologica dto){
        FichaSintomatologica fs= ficha.save(dto);
        FichaSintomatologicaDTO fsdto=mapper.map(fs,FichaSintomatologicaDTO.class);
        return fsdto;
    }

    public FichaListEnfermedadSintomaDTO findByIdFichaDetalle(Long id){

        FichaListEnfermedadSintomaDTO  fl= new FichaListEnfermedadSintomaDTO();
        FichaSintomatologicaDTO fichadto= ficha.findByIdFichaDetalle(id);
        List<EnfermedadDTO> fe= fichaEnfermedad.listarEnfermedadDicha(fichadto.getIdFicha());
        List<SintomaDTO> fs=fichaSintomaDao.listarSintomaFicha(fichadto.getIdFicha());
        fl.setFicha(fichadto);
        fl.setListEnfermedad(fe);
        fl.setListSintoma(fs);
         return fl;
    }

    public List<FichaListEnfermedadSintomaDTO> litarFichaDetalle(String idObra, String fechaRegistro){

        List<FichaListEnfermedadSintomaDTO>  fdl = new ArrayList<>();
        List<FichaSintomatologicaDTO> listFichaDetalle=ficha.listFichaDetalle(idObra,Utils.toDateRegister(fechaRegistro));
        FichaListEnfermedadSintomaDTO fl= null;
        for (FichaSintomatologicaDTO f : listFichaDetalle) {
            fl= new FichaListEnfermedadSintomaDTO();
            List<EnfermedadDTO> fe= fichaEnfermedad.listarEnfermedadDicha(f.getIdFicha());
            List<SintomaDTO> fs=fichaSintomaDao.listarSintomaFicha(f.getIdFicha());
            fl.setFicha(f);
            fl.setListEnfermedad(fe);
            fl.setListSintoma(fs);
            fdl.add(fl);
        }
        return fdl;
    }
    public List<FichaListEnfermedadSintomaDTO> litarFichaDetallePageable(String idObra, String fechaRegistro){
        List<FichaListEnfermedadSintomaDTO>  fdl = new ArrayList<>();
        List<FichaSintomatologicaDTO> listFichaDetalle=ficha.listFichaDetallePageable(idObra,Utils.toDateRegister(fechaRegistro));
        FichaListEnfermedadSintomaDTO fl= null;
        for (FichaSintomatologicaDTO f : listFichaDetalle) {
            fl= new FichaListEnfermedadSintomaDTO();
            List<EnfermedadDTO> fe= fichaEnfermedad.listarEnfermedadDicha(f.getIdFicha());
            List<SintomaDTO> fs=fichaSintomaDao.listarSintomaFicha(f.getIdFicha());
            fl.setFicha(f);
            fl.setListEnfermedad(fe);
            fl.setListSintoma(fs);
            fdl.add(fl);
        }
        return fdl;
    }
    public List<FichaSintomatologicaDTO> litarFicha(String idObra, String fechaRegistro){
        List<FichaSintomatologicaDTO> listFichaDetalle=ficha.listFichaDetallePageable(idObra,Utils.toDateRegister(fechaRegistro));
        return listFichaDetalle;
    }

    public List<FichaListEnfermedadSintomaDTO> listNameFichaDetalle(String name,String idObra, Date fechaRegistro){
        List<FichaListEnfermedadSintomaDTO>  fdl = new ArrayList<>();
        List<FichaSintomatologicaDTO> listFichaDetalle=ficha.findByNamePersonalFichaDetalle(name,idObra,fechaRegistro);
        FichaListEnfermedadSintomaDTO fl= null;
        for (FichaSintomatologicaDTO f : listFichaDetalle) {
            fl= new FichaListEnfermedadSintomaDTO();
            List<EnfermedadDTO> fe= fichaEnfermedad.listarEnfermedadDicha(f.getIdFicha());
            List<SintomaDTO> fs=fichaSintomaDao.listarSintomaFicha(f.getIdFicha());
            fl.setFicha(f);
            fl.setListEnfermedad(fe);
            fl.setListSintoma(fs);
            fdl.add(fl);
        }
        return fdl;
    }

    public Page<FichaSintomatologicaDTO> listaPersonalObra(String name, String idObra, Integer page , Integer size){

        return ficha.listPersonalObra(Utils.like(name),idObra, PageRequest.of(page, size));
    }

    public FichaSintomatologica finById(Long id){
        return ficha.findById(id).orElse(null);
    }

    public ByteArrayInputStream exportFichasPersonal(String idObra, String fechaRegistro) throws Exception {
        Resource resource = resourceLoader.getResource("classpath:DOWNLOAD_PERSONAL_FICHAS.xlsx");
        Workbook workbook = new XSSFWorkbook(resource.getInputStream());
        Sheet sheet = workbook.getSheet("PLANTILLA");

        List<SintomaDTO> s= new ArrayList<>();
        List<EnfermedadDTO> e= new ArrayList<>();
        List<FichaExport> feFinal= new ArrayList<>();

        List<FichaExport>fpe = ficha.personalforSector(idObra);

        List<FichaExport> fe= ficha.listFichaDetalleExport(idObra, Utils.toDateRegister(fechaRegistro));
        fe.forEach(l->{
            l.setEnfermedadList(fichaEnfermedad.listarEnfermedadDicha(l.getIdFicha()));
            l.setSintomaList(fichaSintomaDao.listarSintomaFicha(l.getIdFicha()));
        });
        //VALIDACION DE PERSONAL SIN FICHA
        boolean flag= false;
        for (FichaExport f: fpe){
            f.setSintomaList(s);
            f.setEnfermedadList(e);
            for (FichaExport f2: fe){
                if (Objects.equals(f.getIdPersonal(), f2.getIdPersonal())) {
                    flag = true;
                }
            }
            if (!flag){feFinal.add(f);}
            flag=false;
        }

        feFinal.addAll(fe);
        //CREANDO REGISTROS

        for (int i1 = 0; i1 < feFinal.size(); i1++) {
            StringBuilder enfermedades= new StringBuilder("");
            StringBuilder sintomas= new StringBuilder("");
            FichaExport p= feFinal.get(i1);

            Row row = sheet.createRow(i1 + 1);
            row.createCell(0).setCellValue(p.getIdFicha() == null ? 0 : p.getIdFicha());
            row.createCell(1).setCellValue(p.getNombrePers().toUpperCase());
            row.createCell(2).setCellValue(p.getNroDocPers().toUpperCase());
            row.createCell(3).setCellValue(p.getTelefono() == null ? "" :p.getTelefono());
            row.createCell(4).setCellValue(p.getEmailPers().toUpperCase());
            row.createCell(5).setCellValue(p.getEdad() == null ? "" :p.getEdad());
            row.createCell(6).setCellValue(p.getTalla() == null ? "" : p.getTalla());
            row.createCell(7).setCellValue(p.getPeso() == null ? "" : p.getPeso());

            if(p.getEnfermedadList().size()==0 ){
                row.createCell(8).setCellValue( enfermedades.toString());
            }else{
                for (EnfermedadDTO dto: p.getEnfermedadList()){
                    enfermedades = new StringBuilder(enfermedades + ", " + dto.getDescripcion());
                }
                row.createCell(8).setCellValue( enfermedades.deleteCharAt(0).toString());
            }
            if(p.getSintomaList().size()== 0 ){
                row.createCell(9).setCellValue( sintomas.toString());
            }else{
                for (SintomaDTO dto: p.getSintomaList()){
                    sintomas = new StringBuilder(sintomas + ", " + dto.getDescripcion());
                }
                row.createCell(9).setCellValue( sintomas.deleteCharAt(0).toString());
            }

            if (p.getFlagContactoCovid()==null){
                row.createCell(10).setCellValue( "NO");
            }else if(p.getFlagContactoCovid()){
                row.createCell(10).setCellValue( "SI");
            }else{
                row.createCell(10).setCellValue( "NO");
            }
            row.createCell(11).setCellValue( p.getObservacion() == null ? "": p.getObservacion());
            row.createCell(12).setCellValue( p.getIdFicha() == null ? "NO" : "SI");
            row.createCell(13).setCellValue( p.getFechaRegistro()==null ? "" : Utils.toDateSringHour(p.getFechaRegistro()));

        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        return new ByteArrayInputStream(out.toByteArray());
    }

    public ByteArrayInputStream exportFichasPersonaLNotification(String idObra, Date fechaRegistro) throws Exception {
        Resource resource = resourceLoader.getResource("classpath:DOWNLOAD_PERSONAL_FICHAS.xlsx");
        Workbook workbook = new XSSFWorkbook(resource.getInputStream());
        Sheet sheet = workbook.getSheet("PLANTILLA");

        List<SintomaDTO> s= new ArrayList<>();
        List<EnfermedadDTO> e= new ArrayList<>();
        List<FichaExport> fe= ficha.listFichaDetalleExport(idObra, fechaRegistro);
        fe.forEach(l->{
            l.setEnfermedadList(fichaEnfermedad.listarEnfermedadDicha(l.getIdFicha()));
            l.setSintomaList(fichaSintomaDao.listarSintomaFicha(l.getIdFicha()));
        });

        //CREANDO REGISTROS

        for (int i1 = 0; i1 < fe.size(); i1++) {
            StringBuilder enfermedades= new StringBuilder("");
            StringBuilder sintomas= new StringBuilder("");
            FichaExport p= fe.get(i1);

            Row row = sheet.createRow(i1 + 1);
            row.createCell(0).setCellValue(p.getIdFicha() == null ? 0 : p.getIdFicha());
            row.createCell(1).setCellValue(p.getNombrePers().toUpperCase());
            row.createCell(2).setCellValue(p.getNroDocPers().toUpperCase());
            row.createCell(3).setCellValue(p.getTelefono() == null ? "" :p.getTelefono());
            row.createCell(4).setCellValue(p.getEmailPers().toUpperCase());
            row.createCell(5).setCellValue(p.getEdad() == null ? "" :p.getEdad());
            row.createCell(6).setCellValue(p.getTalla() == null ? "" : p.getTalla());
            row.createCell(7).setCellValue(p.getPeso() == null ? "" : p.getPeso());

            if(p.getEnfermedadList().size()==0 ){
                row.createCell(8).setCellValue( enfermedades.toString());
            }else{
                for (EnfermedadDTO dto: p.getEnfermedadList()){
                    enfermedades = new StringBuilder(enfermedades + ", " + dto.getDescripcion());
                }
                row.createCell(8).setCellValue(enfermedades.deleteCharAt(0).toString());
            }
            if(p.getSintomaList().size()== 0 ){
                row.createCell(9).setCellValue(sintomas.toString());
            }else{
                for (SintomaDTO dto: p.getSintomaList()){
                    sintomas = new StringBuilder( sintomas + ", " + dto.getDescripcion());
                }
                row.createCell(9).setCellValue( sintomas.deleteCharAt(0).toString());
            }

            if (p.getFlagContactoCovid()==null){
                row.createCell(10).setCellValue( "NO");
            }else if(p.getFlagContactoCovid()){
                row.createCell(10).setCellValue( "SI");
            }else{
                row.createCell(10).setCellValue( "NO");
            }
            row.createCell(11).setCellValue( p.getObservacion() == null ? "": p.getObservacion());
            row.createCell(12).setCellValue( p.getIdFicha() == null ? "NO" : "SI");
            row.createCell(13).setCellValue( p.getFechaRegistro()==null ? "" : Utils.toDateSringHour(p.getFechaRegistro()));
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        return new ByteArrayInputStream(out.toByteArray());
    }

}
