package com.spring.sigmaweb.backend.process.legajo.service;

import com.spring.sigmaweb.backend.process.generic.model.Persona;
import com.spring.sigmaweb.backend.process.legajo.dto.*;
import com.spring.sigmaweb.backend.process.legajo.model.Personal;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalHistorcoBancario;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalHistorico;
import com.spring.sigmaweb.backend.process.legajo.repository.IPersonalHistoricoBancarioDao;

import java.util.Date;
import java.util.List;

public interface IPersonalService {
    public PersonalDTO findByNroDocPerAndobraPersonal(String nroDocPer, String obraname);

    public PersonalDatosPersonalesDTO findByIdPersonaAndObraPersonalInfoPersonal(Long idpersonal, String obraname);

    public PersonalDatosMedicosDTO findByIdPersonaAndObraInfoMedico(Long idpersonal, String obraname);

    public Personal findByIdPersonalAndObraname(Long idpersonal, String obraname);

    public List<PersonalDatosListDTO> findByIdPersonalAndObraList(String obraname);

    public List<PersonalDatosListDTO> findByObraAndEstadoPerList(String obraname, Boolean estadoper);

    public List<PersonalDatosListDTO> findByObraAndEstadoPerTestList (String obraname, Integer estadoper);

    public Personal save(Personal personal);

    public Integer updateFechaConfirPersonal(Long idpersonal);

    public PersonalDatosListDTO findByObraAndidPersonalBasico(String obraname, Long idpersonal);

    public List<PersonalDatosListDTO> findByNroDocPersAndIdObra(String obraname, String nrodocpers);

    public List<PersonalDatosListDTO> findByCodigoPerAndIdObra(String obraname, String codigoPer);

    //Historico
    public PersonalHistorico saveAll(List<PersonalHistorico> persoHist);

    public List<PersonalHistoricoDTO> buscarPorIdPersonalAndObraAndTipo(Long idpers, String idobra, String tipo);

    //Financiero
    public PersonalDatosBancariosDTO findByObraAndidPersonalParaInfoBancario(String obraname, Long idpersonal);

    //activar estudiante
    public Integer updateColaboradorActivo(Long idpersonal, String obraname, String fechaactivo);

    //Historio Info Bancaria

    public List<PersonalHistorcoBancario> findByIdObraHistdbAndIdPersonalHistdbAndIdPervilaHistdb (String idObraHistdb, long idPersonalHistdb, Long idPervilaHistdb);

    public PersonalHistorcoBancario findByIdObraHistdbAndIdPersonalHistdbAndIdPervilaHistdbAndIdHistdb (String idObraHistdb, long idPersonalHistdb, Long idPervilaHistdb, Long idHistdb);

    public List<PersonalHistorcoBancario> findByIdObraHistdbAndIdPersonalHistdbAndIdPervilaHistdbAndTipoHistdb (String idObraHistdb, long idPersonalHistdb,
                                                                                                                Long idPervilaHistdb, String tipoHistdb);

    public PersonalHistorcoBancario saveHistBancario(PersonalHistorcoBancario historico);
}
