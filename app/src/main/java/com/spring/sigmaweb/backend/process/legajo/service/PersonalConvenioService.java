package com.spring.sigmaweb.backend.process.legajo.service;

import com.spring.sigmaweb.backend.process.legajo.dto.PersonalConveniosDTO;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalConvenio;
import com.spring.sigmaweb.backend.process.legajo.reports.ReportAgreement;
import com.spring.sigmaweb.backend.process.legajo.repository.IConvenioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonalConvenioService implements IPersonalConvenioService{

    @Autowired
    IConvenioDao convenioDao;

    @Override
    public PersonalConvenio findByIdPerConv(Long idPerConv) {
        return convenioDao.findByIdPerConv(idPerConv);
    }

    @Override
    public PersonalConvenio findByPersonalAndObraAndConvenio(Long idpersonal, String idobra, Long idperconv, Long idpervila) {
        return convenioDao.findByPersonalAndObraAndConvenio(idpersonal, idobra, idperconv, idpervila);
    }

    @Override
    public List<PersonalConvenio> findByPersonalAndObraList(Long idpersonal, String idobra, Long idpervila) {
        return convenioDao.findByPersonalAndObraList(idpersonal, idobra, idpervila);
    }

    @Override
    public PersonalConveniosDTO findByPersonalAndObraAndConvenioDto(Long idpersona, String idobra, Long idperconv, Long idpervila) {
        return convenioDao.findByPersonalAndObraAndConvenioDto(idpersona, idobra, idperconv, idpervila);
    }

    //Reportes

    @Override
    public List<PersonalConveniosDTO> findByPersonalAndObraListDto(Long idpersona, String idobra, Long idpervila) {
        return convenioDao.findByPersonalAndObraListDto(idpersona, idobra, idpervila);
    }

    @Override
    public List<PersonalConveniosDTO> findConvenioActivoPracticasListDto(Long idpersona, String idobra, Long idpervila) {
        return convenioDao.findConvenioActivoPracticasListDto(idpersona, idobra, idpervila);
    }

    @Override
    @Transactional
    public PersonalConvenio save(PersonalConvenio convenio) {
        return convenioDao.save(convenio);
    }

    @Override
    @Transactional
    public void deleteConvenio(PersonalConvenio convenio) {
        convenioDao.delete(convenio);
    }

    @Override
    public List<ReportAgreement> reportConveniosPorObra(String idobra, Integer estadoper, Integer tipogrupo, Integer tipoplanilla, Integer idtipoconvenio) {
        Sort sortConvenio = Sort.by(Sort.Direction.ASC, "tconv.descripTab");
        Sort sortApepat = Sort.by(Sort.Direction.ASC, "psn.apePaternoPers");
        Sort sortApeMat = Sort.by(Sort.Direction.ASC, "psn.apeMaternoPers");
        Sort sortNombres = Sort.by(Sort.Direction.ASC, "psn.nombrePers");
        Sort sortPlanilla = Sort.by(Sort.Direction.ASC, "tgrpl.descripTab");
        Sort sortOcupacional = Sort.by(Sort.Direction.ASC, "tgroc.descripTab");
        Sort grupSort = null;

        if(tipoplanilla==0 && idtipoconvenio == 0 ) {
            grupSort = sortConvenio.and(sortApepat.and(sortApeMat.and(sortNombres)));
        } else if(tipogrupo == -1 && idtipoconvenio == -1){
            grupSort = sortOcupacional.and(sortConvenio);
        } else if(tipoplanilla!=0 && idtipoconvenio == 0){
            grupSort = sortConvenio.and(sortPlanilla.and(sortOcupacional.and(sortApeMat.and(sortNombres))));
        } else if(tipoplanilla==0 && idtipoconvenio != 0){
            grupSort = sortConvenio.and(sortOcupacional.and(sortPlanilla.and(sortApepat.and(sortApeMat.and(sortNombres)))));
        } else if(tipoplanilla !=0 && idtipoconvenio != 0){
            grupSort = sortConvenio.and(sortPlanilla.and(sortOcupacional.and(sortApepat.and(sortApeMat.and(sortNombres)))));
        }
        return convenioDao.reportConveniosPorObra(idobra, estadoper, tipogrupo, tipoplanilla, idtipoconvenio,grupSort);
    }

    @Override
    public List<ReportAgreement> reportConveniosPorColaborador(String idobra, Integer estadoper, Integer tipogrupo, Integer tipoplanilla, Integer idtipoconvenio) {
        Sort sortConvenio = Sort.by(Sort.Direction.ASC, "tconv.descripTab");
        Sort sortApepat = Sort.by(Sort.Direction.ASC, "psn.apePaternoPers");
        Sort sortApeMat = Sort.by(Sort.Direction.ASC, "psn.apeMaternoPers");
        Sort sortNombres = Sort.by(Sort.Direction.ASC, "psn.nombrePers");
        Sort sortfechaConv = Sort.by(Sort.Direction.ASC, "pc.fechaIniPerconv");

        Sort grupSort = null;
        grupSort = sortApepat.and(sortApeMat.and(sortNombres.and(sortfechaConv.and(sortConvenio))));

        return convenioDao.reportConveniosPorObra(idobra, estadoper, tipogrupo, tipoplanilla, idtipoconvenio,grupSort);
    }


}
