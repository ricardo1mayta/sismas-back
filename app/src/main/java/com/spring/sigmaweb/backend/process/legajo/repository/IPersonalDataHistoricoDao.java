package com.spring.sigmaweb.backend.process.legajo.repository;

import com.spring.sigmaweb.backend.process.legajo.dto.PersonalHistoricoDTO;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalHistorico;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPersonalDataHistoricoDao extends CrudRepository<PersonalHistorico, Long> {
        @Query("select new com.spring.sigmaweb.backend.process.legajo.dto.PersonalHistoricoDTO (ph.idPersonalHist,"
                + "o.idobra,"
                + "o.nombreobra,"
                + "p.idPersonal,"
                + "p.idPerSigma,"
                + "p.codigoPer,"
                + "ps.apePaternoPers,"
                + "ps.apeMaternoPers,"
                + "ps.nombrePers,"
                + "doc.descripTab as descDocPer,"
                + "ps.nroDocPers,"
                + "ph.tipoHist,"
                + "ph.direccionHist,"
                + "ph.tipoEstCivilHist,"
                + "estc.descripTab as descEstCivilHist,"
                + "ph.fechaCambECHist,"
                + "ph.creaPorHist,"
                + "ph.fechaIngHist"
                + ") "
                + "from PersonalHistorico ph inner join Personal p on(ph.personalHist=p.idPersonal) "
                + "inner join Obra o on (ph.obraHist=o.idobra) "
                + "inner join Persona ps on (p.idPersona = ps.idPersona)"
                + "left join TablasTabla doc on (ps.idTipoDocPers = doc.codigoTab) "
                + "left join TablasTabla estc on (ph.tipoEstCivilHist = estc.codigoTab) "
                + "where p.idPersonal = ?1 and o.idobra = ?2 and ph.tipoHist = ?3 "
                + "order by ph.fechaIngHist")
        public List<PersonalHistoricoDTO> buscarPorIdPersonalAndObraAndTipo(Long idpers, String idobra, String tipo);
}
