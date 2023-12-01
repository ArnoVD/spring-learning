package com.in28minutes.rest.webservices.restfulwebservices.basic;

import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

// Disable basic authentication
//@Configuration
public class BasicAuthenticationSecurityConfiguration {
    // Filter chain for basic authentication
    // Disabled CSRF protection
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                                                                // Permit all OPTIONS requests through Spring Security and require authentication for all other requests
        return http.authorizeHttpRequests((authorizeRequests) -> authorizeRequests.antMatchers(HttpMethod.OPTIONS, "/**").permitAll().anyRequest().authenticated())
                .httpBasic(withDefaults())
                .csrf().disable() // Disabled CSRF protection (cross-site request forgery) (not Recommended)
                .sessionManagement((sessionManagement) -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Disable session creation
                .build();
    }
}
