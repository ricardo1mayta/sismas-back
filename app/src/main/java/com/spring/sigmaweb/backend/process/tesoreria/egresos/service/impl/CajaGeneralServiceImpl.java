package com.spring.sigmaweb.backend.process.tesoreria.egresos.service.impl;


import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.CajaGeneralDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.CajaGeneral;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.CajaGeneralRepository;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.IGenericRepo;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.CajaGeneralService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CajaGeneralServiceImpl extends CRUDImpl<CajaGeneral,Long> implements CajaGeneralService {

    private final CajaGeneralRepository repo;

    @Override
    protected IGenericRepo<CajaGeneral, Long> getRepo() {
        return null;
    }

    @Override
    public List<CajaGeneralDTO> findByIdObraAndCajaAndUsuarioDTO(String idobra, Long idusuario) {
        return repo.findByIdObraAndCajaAndUsuarioDTO(idobra, idusuario);
    }

    @Override
    public CajaGeneral findByCajaAperturadaAndObra(String idobra, Long idusuario) {
        return repo.findByCajaAperturadaAndObra(idobra, idusuario);
    }

    @Override
    public CajaGeneral findByEstadoCajaActualUsuario(String idobra, Long idusuario) {
        return repo.findByEstadoCajaActualUsuario(idobra, idusuario);
    }

    @Override
    public CajaGeneral findExistDateCajaGenObra(String idobra, Date fecha, Long idCaja) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dateDesv = sdf.format(fecha);

        return repo.findExistDateCajaGenObra(idobra, Integer.parseInt(dateDesv), idCaja);
    }

    @Override
    public CajaGeneralDTO findByCajaActualDTO(String idobra, Long idusuario) {
        CajaGeneral result= repo.findByEstadoCajaActualUsuario(idobra, idusuario);
        if(result != null){
            return repo.findByCajaActualDTO(result.getIdObra(), result.getIdUsuario(), result.getIdCaja(), result.getIdCajaGeneral());
        } else {
            return null;
        }
    }

    @Override
    public CajaGeneralDTO findByCajaAperturadaAndObraDTO(String idobra, Long idusuario) {
        return repo.findByCajaAperturadaAndObraDTO(idobra, idusuario);
    }

    @Override
    @Transactional
    public CajaGeneral save(CajaGeneral cajageneral) {
        return repo.save(cajageneral);
    }


}
