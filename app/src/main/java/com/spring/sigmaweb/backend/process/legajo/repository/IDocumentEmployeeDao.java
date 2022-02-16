package com.spring.sigmaweb.backend.process.legajo.repository;

import com.spring.sigmaweb.backend.process.legajo.dto.DocumentEmployeeDTO;
import com.spring.sigmaweb.backend.process.legajo.model.DocumentEmployee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IDocumentEmployeeDao extends CrudRepository<DocumentEmployee, Long> {

    public Long countByIdObraFilePerAndTipoFilePerAndOpcionFilePer(String idObraFilePer, String tipoFilePer, Long opcionFilePer);

    @Query("select new com.spring.sigmaweb.backend.process.legajo.dto.DocumentEmployeeDTO(d.idFilePer," +
            "o.idobra as idObraFilePer," +
            "p.idPersonal," +
            "psn.apePaternoPers," +
            "psn.apeMaternoPers," +
            "psn.nombrePers," +

            "d.titleFilePer," +
            "d.fileNameFilePer," +
            "d.urlFilePer, " +
            "d.tipoFilePer," +
            "d.opcionFilePer," +
            "d.idItemPadreFileper, " +
            "d.descripcionFilePer," +
            "d.typeFilePer," +
            "d.sizeFilePer," +

            "d.uploadDateFilePer," +
            "d.creaPorFilePer" +
            ") " +
            "from DocumentEmployee d inner join Personal p on (d.idPersonalFilePer = p.idPersonal and d.idObraFilePer = p.obraPer) " +
            "inner join Persona psn on (p.idPersona = psn.idPersona) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "where p.idPersonal=?1 and o.idobra = ?2 and d.tipoFilePer = ?3 and d.idItemPadreFileper=?4 "
    )
    public List<DocumentEmployeeDTO> findByDocumentPersonalAndObraAndTipoList(Long idpersonal, String idobra, String tipodocumento, Long idIPadre);

    @Query("select new com.spring.sigmaweb.backend.process.legajo.dto.DocumentEmployeeDTO(d.idFilePer," +
            "o.idobra as idObraFilePer," +
            "p.idPersonal," +
            "psn.apePaternoPers," +
            "psn.apeMaternoPers," +
            "psn.nombrePers," +

            "d.titleFilePer," +
            "d.fileNameFilePer, " +
            "d.urlFilePer, " +
            "d.tipoFilePer," +
            "d.opcionFilePer," +
            "d.idItemPadreFileper, " +
            "d.descripcionFilePer," +
            "d.typeFilePer," +
            "d.sizeFilePer," +

            "d.uploadDateFilePer," +
            "d.creaPorFilePer" +
            ") " +
            "from DocumentEmployee d inner join Personal p on (d.idPersonalFilePer = p.idPersonal and d.idObraFilePer = p.obraPer) " +
            "inner join Persona psn on (p.idPersona = psn.idPersona) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "where p.idPersonal=?1 and o.idobra = ?2 and d.tipoFilePer = ?3 and opcionFilePer=?4 and d.idItemPadreFileper=?5 and idFilePer=?6 "
    )
    public DocumentEmployeeDTO findByDocumentPersonalAndObraAndTipoAndIdDto(Long idpersonal, String idobra, String tipodocumento,
                                                                         Long idopcion, Long idIPadre, Long iddocu);

    @Query("select new com.spring.sigmaweb.backend.process.legajo.dto.DocumentEmployeeDTO(d.idFilePer," +
            "o.idobra as idObraFilePer," +
            "p.idPersonal," +
            "psn.apePaternoPers," +
            "psn.apeMaternoPers," +
            "psn.nombrePers," +

            "d.titleFilePer," +
            "d.fileNameFilePer, " +
            "d.urlFilePer, " +
            "d.tipoFilePer," +
            "d.opcionFilePer," +
            "d.idItemPadreFileper, " +
            "d.descripcionFilePer," +
            "d.typeFilePer," +
            "d.sizeFilePer," +

            "d.uploadDateFilePer," +
            "d.creaPorFilePer" +
            ") " +
            "from DocumentEmployee d inner join Personal p on (d.idPersonalFilePer = p.idPersonal and d.idObraFilePer = p.obraPer) " +
            "inner join Persona psn on (p.idPersona = psn.idPersona) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "where p.idPersonal=?1 and o.idobra = ?2 and d.tipoFilePer = ?3 and d.opcionFilePer=?4 and d.idItemPadreFileper=?5 "
    )
    public DocumentEmployeeDTO findByDocumentPersonalAndObraAndOpcionAndTipoDto(Long idpersonal, String idobra, String tipodocumento,
                                                                            Long idopcion, Long idIPadre);

    @Query("select d " +
            "from DocumentEmployee d inner join Personal p on (d.idPersonalFilePer = p.idPersonal and d.idObraFilePer = p.obraPer) " +
            "inner join Persona psn on (p.idPersona = psn.idPersona) " +
            "inner join Obra o on (p.obraPer = o.idobra) " +
            "where p.idPersonal=?1 and o.idobra = ?2 and d.tipoFilePer = ?3 and d.opcionFilePer=?4 and d.idItemPadreFileper=?5 and d.idFilePer=?6 "
    )
    public DocumentEmployee findByDocumentPersonalAndObraAndTipoAndId(Long idpersonal, String idobra, String tipodocumento,
                                                                         Long idopcion, Long idIPadre, Long iddocu);




}
