package com.spring.sigmaweb.backend.config;

import com.spring.sigmaweb.backend.process.core.model.Usuario;
import com.spring.sigmaweb.backend.process.core.service.IUsuarioService;
import com.spring.sigmaweb.backend.process.generic.model.Obra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InfoAdicionalToken implements TokenEnhancer {
    @Autowired
    private IUsuarioService usuarioService;


    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        /*System.out.println("inicial:" + authentication.getUserAuthentication().getDetails());
		String details[] = (String[]) authentication.getUserAuthentication().getDetails();

		System.out.println("inicial-usuario:"+ details[0]);
		*/
        String username = authentication.getName();
		/*String usernameD = username.trim().substring(0, username.trim().indexOf("*"));
		String obraD = username.trim().substring(username.trim().indexOf("*") + 1,username.trim().length());*/
        Usuario usuario = usuarioService.findByUsername(username);

        Obra obra = usuario.getObraUs();

        Map<String, Object> info = new HashMap<>();
        info.put("info_adicional", "Hola que tal!: ".concat(authentication.getName()));
        info.put("nombre", usuario.getUsername());
        info.put("emailuser", usuario.getEmailUser());
        info.put("tipouser", usuario.getTipoUser());
        info.put("iduser", usuario.getIdUser());
        info.put("obrauser", obra.getIdobra());
        info.put("idcodtipouser", usuario.getIdcodTipoUser());

        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);

        return accessToken;
    }
}
