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
                        "/api/obras","/api/health","/api/versionapp", "/actuator/**", "/actuator", "/oauth/token", "/api/obra/active/**","/sidenav/**", "/gradoAcademico/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/familiaList/{idUser}/{obraname}").hasAnyRole("FAMI","ADMI")
                .antMatchers(HttpMethod.GET, "/api/alumnoFamiList/{idFami}/{obraname}").hasAnyRole("FAMI","ADMI")
                .antMatchers(HttpMethod.GET, "/api/alumnoFamiListprereq/{codialum}/{obra}").hasAnyRole("FAMI","ADMI")
                .antMatchers(HttpMethod.GET, "/api/matricula/{idalum}/{obraname}/{anioM}").hasAnyRole("FAMI","ADMI")
                .antMatchers(HttpMethod.GET, "/api/matriculafamilia/{idfami}/{obraname}/{anioM}").hasAnyRole("FAMI","ADMI")
                .antMatchers(HttpMethod.GET, "/roles/**").hasAnyRole("ADMI")
                .antMatchers(HttpMethod.GET, "/api/usuarios").hasRole("ADMI").anyRequest().authenticated().and().cors();
    }
}
