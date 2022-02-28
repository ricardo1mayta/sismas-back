package com.spring.sigmaweb.backend.process.legajo.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.sigmaweb.backend.process.core.dto.SidenavItemDTO;
import com.spring.sigmaweb.backend.process.core.model.Rol;
import com.spring.sigmaweb.backend.process.legajo.dto.*;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalContrato;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalVidaLaboral;
import com.spring.sigmaweb.backend.process.legajo.repository.IContratoDao;
import com.spring.sigmaweb.backend.process.legajo.repository.IConvenioDao;
import com.spring.sigmaweb.backend.process.legajo.repository.IPersonalCargosDao;
import com.spring.sigmaweb.backend.process.legajo.repository.IPersonalVidaLaboralDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PersonalVidaLaboralService implements IPersonalVidaLaboralService{
    @Autowired
    IPersonalVidaLaboralDao personalVidaLaboralDao;

    @Autowired
    IContratoDao contratoDao;

    @Autowired
    IConvenioDao convenioDao;

    @Autowired
    IPersonalCargosDao cargoDao;


    @Override
    @Transactional(readOnly = true)
    public PersonalVidaLaboral findByIdPervilaAndIdObraPervila(Long idPervila, String idObraPervila) {
        return personalVidaLaboralDao.findByIdPervilaAndIdObraPervila(idPervila, idObraPervila);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonalVidaLaboral findByObraPersonalId(String idobra, Long idpersonal, Long idpervila) {
        return personalVidaLaboralDao.findByObraPersonalId(idobra, idpersonal, idpervila);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonalVidaLaboral> findByObraPersonalEstado(String idobra, Long idpersonal, String estado) {
        return personalVidaLaboralDao.findByObraPersonalEstado(idobra, idpersonal, estado);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonalVidaLabDTO findByObraPersonalIdDTO(String idobra, Long idpersonal, Long idpervila) {
        return personalVidaLaboralDao.findByObraPersonalIdDTO(idobra, idpersonal, idpervila);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonalVidaLabDTO ultimoPeriodoVidaLaboral(String idobra, Long idpersonal) {

        List<PersonalVidaLabDTO> vidaLabList = personalVidaLaboralDao.findByObraPersonalListDTO(idobra, idpersonal);
        PersonalVidaLabDTO vidaLabRtn = new PersonalVidaLabDTO();
        /*Integer countR=0;*/
        if(vidaLabList.size() < 1) {
            return null;
        } else {
            /*countR = vidaLabList.size();*/

            vidaLabRtn = vidaLabList.get(0);
        }
        return vidaLabRtn;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonalVidaLabDTO> findByObraPersonalListDTO(String idobra, Long idpersonal) {

        return personalVidaLaboralDao.findByObraPersonalListDTO(idobra, idpersonal);
    }

    @Override
    @Transactional
    public PersonalVidaLaboral save(PersonalVidaLaboral vidalaboral) {
        return personalVidaLaboralDao.save(vidalaboral);
    }

    @Override
    public List<ItemListVidaLaboralDTO> findItemsVidaLaboral(String idobra, Long idpersonal, Long idpervila, String estado) {
        PersonalVidaLabDTO vidalab = personalVidaLaboralDao.findByObraPersonalIdDTO(idobra, idpersonal, idpervila);
        ItemListVidaLaboralDTO item = null;
        List<ItemListVidaLaboralDTO> listItem=new ArrayList<ItemListVidaLaboralDTO>() ;


        if (vidalab != null){
            List<PersonalContratoObraDTO> contratoVL = contratoDao.findByPersonalAndObraAndcontratoDtoList(idpersonal, idobra, idpervila);
            List<PersonalConveniosDTO> conveniosVL = convenioDao.findByPersonalAndObraListDto(idpersonal, idobra, idpervila);
            List<PersonalCargosDTO> cargoVL = cargoDao.findPersonalAndObraListDto(idpersonal, idobra, idpervila);

            if(contratoVL.size() > 0){
                for (PersonalContratoObraDTO c : contratoVL) {
                    if(c.getEstadoPercont().equals(estado) || estado.equals("_") ){
                        item =new ItemListVidaLaboralDTO();
                        item.setIdPervila(vidalab.getIdPervila());
                        item.setIdObraPervila(vidalab.getIdObraPervila());
                        item.setIdPersonalPervila(vidalab.getIdPersonalPervila());
                        item.setApePaternoPers(vidalab.getApePaternoPers());
                        item.setApeMaternoPers(vidalab.getApeMaternoPers());
                        item.setNombrePers(vidalab.getNombrePers());
                        item.setCodigoPer(vidalab.getCodigoPer());
                        item.setFechaInicioPervila(vidalab.getFechaIngPervila());
                        item.setFechaFinPervila(vidalab.getFechaFinPervila());
                        item.setEstadoPervila(vidalab.getEstadoPervila());

                        item.setTipoItem("Contrato");
                        item.setIdItem(c.getIdPerCont());
                        item.setTipoDetItem(c.getTipoContrato());
                        item.setFechaIniItem(c.getFechaIniPercont());
                        item.setFechaFinItem(c.getFechaFinPercont());
                        item.setEstadoItem(c.getEstadoPercont());
                        listItem.add(item);
                    }

                }
            }
            if(conveniosVL.size() > 0){
                for (PersonalConveniosDTO v : conveniosVL) {
                    if(v.getEstadoPerconv().equals(estado) || estado.equals("_")){
                        item =new ItemListVidaLaboralDTO();
                        item.setIdPervila(vidalab.getIdPervila());
                        item.setIdObraPervila(vidalab.getIdObraPervila());
                        item.setIdPersonalPervila(vidalab.getIdPersonalPervila());
                        item.setApePaternoPers(vidalab.getApePaternoPers());
                        item.setApeMaternoPers(vidalab.getApeMaternoPers());
                        item.setNombrePers(vidalab.getNombrePers());
                        item.setCodigoPer(vidalab.getCodigoPer());
                        item.setFechaInicioPervila(vidalab.getFechaIngPervila());
                        item.setFechaFinPervila(vidalab.getFechaFinPervila());
                        item.setEstadoPervila(vidalab.getEstadoPervila());

                        item.setTipoItem("Convenio");
                        item.setIdItem(v.getIdPerConv());
                        item.setTipoDetItem(v.getTipoConvenio());
                        item.setFechaIniItem(v.getFechaIniPerconv());
                        item.setFechaFinItem(v.getFechaFinPerconv());
                        item.setEstadoItem(v.getEstadoPerconv());
                        listItem.add(item);
                    }

                }
            }
            if(cargoVL.size() > 0){
                for (PersonalCargosDTO g : cargoVL) {
                    String est = g.getEstadoPercargo()== true ?"ACTIVO" : "FINALIZADO";
                    if(est.equals(estado) || estado.equals("_")){
                        item =new ItemListVidaLaboralDTO();
                        item.setIdPervila(vidalab.getIdPervila());
                        item.setIdObraPervila(vidalab.getIdObraPervila());
                        item.setIdPersonalPervila(vidalab.getIdPersonalPervila());
                        item.setApePaternoPers(vidalab.getApePaternoPers());
                        item.setApeMaternoPers(vidalab.getApeMaternoPers());
                        item.setNombrePers(vidalab.getNombrePers());
                        item.setCodigoPer(vidalab.getCodigoPer());
                        item.setFechaInicioPervila(vidalab.getFechaIngPervila());
                        item.setFechaFinPervila(vidalab.getFechaFinPervila());
                        item.setEstadoPervila(vidalab.getEstadoPervila());

                        item.setTipoItem("Cargo");
                        item.setIdItem(g.getIdPercargo());
                        item.setTipoDetItem(g.getCargoPercargo());
                        item.setFechaIniItem(g.getFechaIniPercargo());
                        item.setFechaFinItem(g.getFechaFinPercargo());
                        item.setEstadoItem(g.getEstadoPercargo() == true ? "ACTIVO" : "FINALIZADO" );
                        listItem.add(item);
                    }

                }
            }

        } else {
            return null;
        }
        return listItem;
    }
}
