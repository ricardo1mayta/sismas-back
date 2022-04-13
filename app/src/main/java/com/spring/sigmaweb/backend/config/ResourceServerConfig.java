package com.spring.sigmaweb.backend.config;

import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(HttpMethod.GET,
                        "/sigmaweb/api/obras","/sigmaweb/api/health","/sigmaweb/api/versionapp", "/sigmaweb/actuator/**", "/sigmaweb/actuator", "/sigmaweb/oauth/token", "/sigmaweb/api/obra/active/**","/sigmaweb/sidenav/**", "/sigmaweb/gradoAcademico/**").permitAll()
                .antMatchers(HttpMethod.GET, "/sigmaweb/api/familiaList/{idUser}/{obraname}").hasAnyRole("FAMI","ADMI")
                .antMatchers(HttpMethod.GET, "/sigmaweb/api/alumnoFamiList/{idFami}/{obraname}").hasAnyRole("FAMI","ADMI")
                .antMatchers(HttpMethod.GET, "/sigmaweb/api/alumnoFamiListprereq/{codialum}/{obra}").hasAnyRole("FAMI","ADMI")
                .antMatchers(HttpMethod.GET, "/sigmaweb/api/matricula/{idalum}/{obraname}/{anioM}").hasAnyRole("FAMI","ADMI")
                .antMatchers(HttpMethod.GET, "/sigmaweb/api/matriculafamilia/{idfami}/{obraname}/{anioM}").hasAnyRole("FAMI","ADMI")
                .antMatchers(HttpMethod.GET, "/sigmaweb/api/usuarios").hasRole("ADMI").anyRequest().authenticated().and().cors();
    }
}
