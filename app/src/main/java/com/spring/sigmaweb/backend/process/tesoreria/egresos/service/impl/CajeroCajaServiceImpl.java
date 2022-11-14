package com.spring.sigmaweb.backend.process.tesoreria.egresos.service.impl;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.CajeroCajaDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.CajeroCaja;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.CajeroCajaRepository;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.IGenericRepo;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.ImpresoraRepository;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.CajeroCajaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CajeroCajaServiceImpl extends CRUDImpl<CajeroCaja,String> implements CajeroCajaService {
    private final CajeroCajaRepository repo;

    @Override
    public CajeroCaja findByIdObraAndIdCajaAndIdUsuario(String idobra, Long idcaja, Long idusuario) {
        return repo.findByIdObraAndIdCajaAndIdUsuario(idobra, idcaja, idusuario);
    }

    @Override
    public List<CajeroCaja> findByIdObraAndIdUsuario(String idobra, Long idusuario) {
        return repo.findByIdObraAndIdUsuario(idobra, idusuario);
    }

    @Override
    public List<CajeroCaja> findByIdObraAndIdCaja(String idobra, Long idCaja) {
        return repo.findByIdObraAndIdCaja(idobra, idCaja);
    }

    @Override
    public List<CajeroCajaDTO> findByIdObraAndIdCajaAndIdUsuarioDTO(String idobra, Long idusuario) {
        return repo.findByIdObraAndIdCajaAndIdUsuarioDTO(idobra, idusuario);
    }

    @Override
    public List<CajeroCajaDTO> findByIdObraAndIdCajaAndIdUsuarioDistintDTO(String idobra) {
        return repo.findByIdObraAndIdCajaAndIdUsuarioDistintDTO(idobra);
    }

    @Override
    @Transactional
    public CajeroCaja saveCajeroCaja(CajeroCaja cajeroCaja) {
        return repo.save(cajeroCaja);
    }

    @Override
    @Transactional
    public Integer deleteCajeroCaja(String idobra, Long idcaja, Long idusuario) {
        return null;
    }

    @Override
    @Transactional
    public void delete(CajeroCaja cajeroCaja) {
        repo.delete(cajeroCaja);

    }

    @Override
    protected IGenericRepo<CajeroCaja, String> getRepo() {
        return null;
    }
}
