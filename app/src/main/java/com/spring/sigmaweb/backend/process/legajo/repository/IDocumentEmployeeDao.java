package com.spring.sigmaweb.backend.process.legajo.repository;

import com.spring.sigmaweb.backend.process.legajo.dto.DocumentEmployeeDTO;
import com.spring.sigmaweb.backend.process.legajo.model.DocumentEmployee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;
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
                                                                         Long idopcion, Long idIPadre, String iddocu);

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
                                                                         Long idopcion, Long idIPadre, String iddocu);

    //Guarda con un insert
    @Transactional
    @Modifying
    @Query(
            value = "insert into mo_document_uploaded_employee (id_fileper," +
                    "id_obrafileper," +
                    "id_personalfile," +
                    "title_fileper," +
                    "filename_fileper," +
                    "url_fileper," +
                    "tipo_fileper," +
                    "opcion_fileper," +
                    "id_itempadre_fileper," +
                    "description_fileper," +
                    "typefile_fileper," +
                    "size_fileper," +
                    "upload_date_fileper," +
                    "creapor_fileper) " +
                    "values (:idfile,:idobra ,:idpersonal ,:title , :filename," +
                    ":url, :tipo,:opcion, :padre, :descrip, :type," +
                    ":size, :fecha, :creapor)",
            nativeQuery = true)
    void insertNativeDocumentoUpload(@Param("idfile") String idfile, @Param("idobra") String idobra, @Param("idpersonal") Long idpersonal, @Param("title") String title, @Param("filename") String filename,
                                  @Param("url") String url, @Param("tipo") String tipo, @Param("opcion") Long opcion, @Param("padre") Long padre, @Param("descrip") String descrip, @Param("type") String type,
                                  @Param("size") Long size, @Param("fecha") Date fecha, @Param("creapor") String creapor);



}
