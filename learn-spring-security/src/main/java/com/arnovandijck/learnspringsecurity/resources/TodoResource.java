package com.arnovandijck.learnspringsecurity.resources;

import jakarta.annotation.security.RolesAllowed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoResource {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private static final List<Todo> TODOS_LIST =
            List.of(new Todo("in28minutes", "Learn AWS"),
                    new Todo("in28minutes", "Get AWS Certified"));

    @GetMapping("/todos")
    public List<Todo> retrieveAllTodos() {
        return TODOS_LIST;
    }

    @GetMapping("/users/{username}/todos")
    // Pre-and Post authorization are the recommended way to do authorization
    @PreAuthorize("hasRole('USER') and #username == authentication.name") // User should have role ROLE_USER and username should be the same as the authenticated user
    @PostAuthorize("returnObject.username == 'in28minutes'") // The username of the returned object should be the same as the authenticated user
    @RolesAllowed({"ADMIN", "USER"}) // User should have role USER or ADMIN
    @Secured({"ROLE_ADMIN", "ROLE_USER"}) // User should have role ROLE_USER or ROLE_ADMIN
    public Todo retrieveTodosForSpecificUser(@PathVariable String username) {
        return TODOS_LIST.get(0);
    }t

    @PostMapping("/users/{username}/todos")
    public void createTodoForSpecificUser(@PathVariable String username
            , @RequestBody Todo todo) {
        logger.info("Create {} for {}", todo, username);
    }

}

record Todo (String username, String description) {}