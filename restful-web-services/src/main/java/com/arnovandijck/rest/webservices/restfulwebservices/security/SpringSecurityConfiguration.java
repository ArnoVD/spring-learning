package com.arnovandijck.rest.webservices.restfulwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        // Authorize all requests
        httpSecurity.authorizeHttpRequests(
                authorizeRequests -> authorizeRequests.anyRequest().authenticated()
        );
        // Enable basic auth
        // Shows login popup instead of login page
        httpSecurity.httpBasic(Customizer.withDefaults());
        // Disable CSRF (Enable POST and PUT requests)
        httpSecurity.csrf().disable();
        // Return the httpSecurity object
        return httpSecurity.build();
    }
}
