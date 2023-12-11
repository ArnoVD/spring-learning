package com.arnovandijck.learnspringsecurity.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class BasicAuthSecurityConfiguration {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        // Authorize all requests
        httpSecurity.authorizeHttpRequests(authorizeRequests ->
                authorizeRequests.anyRequest().authenticated()
        );
        // Disable session management (STATELESS API)
        httpSecurity.sessionManagement(sessionManagement ->
                sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );
        // Enable basic auth
        // Shows login popup instead of login page
        httpSecurity.httpBasic(Customizer.withDefaults());
        // Disable CSRF (Enable POST and PUT requests)
        httpSecurity.csrf().disable();
        // Disable frame options (Enable H2 console)
        httpSecurity.headers().frameOptions().sameOrigin();
        // Return the httpSecurity object
        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        // Create a user with username arno and password root
        var user = User.withUsername("arno")
                .password("{noop}root")
                .roles(Roles.USER.name())
                .build();

        // Create a user with username admin and password root
        var admin = User.withUsername("admin")
                .password("{noop}root")
                .roles(Roles.USER.name(), Roles.ADMIN.name())
                .build();

        // Add the users to the in memory user details manager
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.createUser(user);
        jdbcUserDetailsManager.createUser(admin);

        return jdbcUserDetailsManager;
    }

    @Bean
    public DataSource dataSource() {
        // Execute the default USER schema DDL script
        // This creates the USER table and the AUTHORITIES table in the H2 database
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
                .build();
    }
}