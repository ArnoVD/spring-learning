package com.arnovandijck.learnspringsecurity.resources;

import jakarta.servlet.http.HttpServlet;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringSecurityTestResource {

    @GetMapping("/csrf-token")
    public CsrfToken retrieveCsrfToken(HttpServlet request) {
        return (CsrfToken) request.getAttribute("_csrf").toString();
    }

}