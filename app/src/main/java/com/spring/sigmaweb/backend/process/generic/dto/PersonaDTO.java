package com.spring.sigmaweb.backend.process.generic.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.sigmaweb.backend.process.generic.model.TablasTabla;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO {
    private Long idPersona;
    private String obraPers;
    private String apePaternoPers;
    private String apeMaternoPers;
    private String nombrePers;

    @JsonIgnoreProperties({"alumnoDocumento", "padreDocumento", "madreDocumento", "otroFamiDocumento",
            "personalDocumento", "padreEstCivil", "madreEstCivil", "otroEstCivil", "personalEstCivil",
            "personalDepEstCivil", "alumnosviveCom", "otroFamiParentalumnosRespPago", "hibernateLazyInitializer",
            "handler"})
    private TablasTabla idTipoDocPers;

    private String nroDocPers;
    private Long idPaisDocPers;

    @JsonIgnoreProperties({"alumnoDocumento", "padreDocumento", "madreDocumento", "otroFamiDocumento",
            "personalDocumento", "padreEstCivil", "madreEstCivil", "otroEstCivil", "personalEstCivil",
            "personalDepEstCivil", "alumnosviveCom", "otroFamiParentalumnosRespPago", "hibernateLazyInitializer",
            "handler"})
    private TablasTabla estCivilPers;
    private Date fecCambioEstCivilPers;
    private Integer tipoViaDomiPers;
    private Integer tipoZonaDomiPers;
    private String domicilioPers;
    private Byte sexoPers;
    private String celularPers;
    private String celularBPers;
    private String telefonoFijoPers;
    private String emailPers;
    private String emailCorPers;
    private String religionProfesaPers;
    private Date fechaNacPers;
    private Long idPaisNacPers;
    private String referencia;
    private String creaPorPers;
    private Date fechaIngPers;
    private String referenciaContactoPers;
}
