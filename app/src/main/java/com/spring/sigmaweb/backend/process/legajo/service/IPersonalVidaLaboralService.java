package com.spring.sigmaweb.backend.process.legajo.service;

import com.spring.sigmaweb.backend.process.legajo.dto.ItemListVidaLaboralDTO;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalVidaLabDTO;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalContrato;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalHistoricoVinculoLaboral;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalVidaLaboral;

import java.util.List;

public interface IPersonalVidaLaboralService {
    public PersonalVidaLaboral findByIdPervilaAndIdObraPervila (Long idPervila, String idObraPervila);

    public PersonalVidaLaboral findByObraPersonalId(String idobra, Long idpersonal, Long idpervila);

    public List<PersonalVidaLaboral> findByObraPersonalEstado(String idobra, Long idpersonal, String estado);

    public PersonalVidaLabDTO findByObraPersonalIdDTO(String idobra, Long idpersonal, Long idpervila);

    public PersonalVidaLabDTO ultimoPeriodoVidaLaboral(String idobra, Long idpersonal);

    public List<PersonalVidaLabDTO> findByObraPersonalListDTO(String idobra, Long idpersonal);

    public PersonalVidaLaboral save(PersonalVidaLaboral vidalaboral);

    public List<ItemListVidaLaboralDTO> findItemsVidaLaboral(String idobra, Long idpersonal, Long idpervila, String estado);

    public PersonalHistoricoVinculoLaboral findByIdObraHistvilaAndIdPersonalHistvilaAndIdPervilaHistvilaAndIdPuestoCargoHistvilaAndTipoHistvilaAndIdHistvila(
            String idObraHistvila, Long idPersonalHistvila, Long idPervilaHistvila, Long idPuestoCargoHistvila, String TipoHistvila, Long idHistvila
    );

}
