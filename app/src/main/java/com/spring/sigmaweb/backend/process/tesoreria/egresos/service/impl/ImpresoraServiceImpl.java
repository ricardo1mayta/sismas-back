package com.spring.sigmaweb.backend.process.tesoreria.egresos.service.impl;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.ImpresoraCajaDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.Caja;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.Impresora;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.ImpresoraCaja;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.CajaRepository;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.IGenericRepo;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.ImpresoraCajaRepository;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.ImpresoraRepository;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.IImpresoraService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImpresoraServiceImpl extends CRUDImpl<Impresora,Long> implements IImpresoraService {
    private final ImpresoraRepository repo;

    private final ImpresoraCajaRepository impresoraCajaRepository;

    @Override
    public List<ImpresoraCajaDTO> findByIdObraAndFlgEstado(String idobra,Integer flgestado) {
        Boolean estado = flgestado.equals(1) ? true : false;
        return repo.findByIdObraAndFlgEstado(idobra, estado);
    }

    @Override
    public Impresora findByIdObraAndIdImpresora(String idobra, Long idimpresora) {
        return repo.findByIdObraAndIdImpresora(idobra, idimpresora);
    }

    @Override
    public Impresora findByIdimpresorasCajaObra(String idobra, Long idcaja, Long idimpresora) {
        return repo.findByIdimpresorasCajaObra(idobra, idcaja, idimpresora);
    }

    @Override
    public List<ImpresoraCaja> findByImpresorasCajaObraTodos(String idobra, Long idcaja) {
        return repo.findByImpresorasCajaObraTodos(idobra,idcaja);
    }

    @Override
    public List<ImpresoraCajaDTO> findByImpresorasCajaSelect(String idobra, Long idcaja, Integer estado) {
        Boolean flgestado = estado.equals(1) ? true : false;
        return repo.findByImpresorasCajaSelect(idobra, idcaja,flgestado);
    }

    @Override
    public ImpresoraCaja saveImpresoraCaja(ImpresoraCaja impresoracaja) {
        return impresoraCajaRepository.save(impresoracaja);
    }

    @Override
    @Transactional
    public Integer deleteImpresoraCaja(String idobra, Long idcaja, Long idimpresora) {

        return repo.deleteImpresoraCaja(idobra,idcaja,idimpresora);
    }

    @Override
    protected IGenericRepo<Impresora, Long> getRepo() {
        return null;
    }
}
