package com.spring.sigmaweb.backend.config;

import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;

import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(
                        "/sigmaweb/api/obras","/sigmaweb/api/health","/sigmaweb/api/versionapp", "/sigmaweb/actuator/**", "/sigmaweb/actuator", "/sigmaweb/oauth/token", "/sigmaweb/api/obra/active/**","/sigmaweb/sidenav/**",
                        "/sigmaweb/gradoAcademico/**","/sigmaweb/publics/**","/sigmaweb/publics/fichas/**","/sigmaweb/publics/fichas/registrar*","sigmaweb/publics/**"
                        ,"/sigmaweb/concepto/**"
                        ,"/sigmaweb/centroresponsabilidad/**"
                        ,"/sigmaweb/solicitudgeneral/**"
                        ,"/sigmaweb/tipoconcepto/**"
                        ,"/sigmaweb/plancontable/**"
                        ,"/sigmaweb/categoriaplancontable/**"
                        ,"/sigmaweb/persona/**"
                        ,"/sigmaweb/actividadpresupuestal/**"
                        ,"/sigmaweb/distribucioncr/**"
                        ,"/sigmaweb/distribuciondetalle/**"
                        ,"/sigmaweb/tipocambio/**"
                        ,"/sigmaweb/documentoegreso/**"
                        ,"/sigmaweb/detracciones/**"
                        ,"/sigmaweb/tarjetascredito/**"
                        ,"/sigmaweb/cajachica-liquidacion/**"
                        ,"/sigmaweb/cuentabanco/**")

                .permitAll()
                //.antMatchers(HttpMethod.DELETE, "/sigmaweb/centroresponsabilidad/**").permitAll()
                .antMatchers(HttpMethod.POST, "/sigmaweb/publics/fichas/registrar").permitAll()
//                .antMatchers(HttpMethod.POST, "/sigmaweb/fichas/export**").permitAll()
                .antMatchers(HttpMethod.GET, "/sigmaweb/api/familiaList/{idUser}/{obraname}").hasAnyRole("FAMI","ADMI")
                .antMatchers(HttpMethod.GET, "/sigmaweb/api/alumnoFamiList/{idFami}/{obraname}").hasAnyRole("FAMI","ADMI")
                .antMatchers(HttpMethod.GET, "/sigmaweb/api/alumnoFamiListprereq/{codialum}/{obra}").hasAnyRole("FAMI","ADMI")
                .antMatchers(HttpMethod.GET, "/sigmaweb/api/matricula/{idalum}/{obraname}/{anioM}").hasAnyRole("FAMI","ADMI")
                .antMatchers(HttpMethod.GET, "/sigmaweb/api/matriculafamilia/{idfami}/{obraname}/{anioM}").hasAnyRole("FAMI","ADMI")
                .antMatchers(HttpMethod.GET, "/sigmaweb/api/usuarios").hasRole("ADMI").anyRequest().authenticated().and().cors();


    }


    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**")
                .and().ignoring().antMatchers("/v2/api-docs",
                        "/v1/publics/save/book*",
                        "/v1/publics/find/code*",
                        "/v1/publics/fichas/**",
                        "/configuration/ui", "/swagger-resources/**", "/configuration/security",
                        "/swagger-ui.html", "/webjars/**")
                .and().ignoring().antMatchers("/v1/publics/test");
    }
}
