package com.arnovandijck.rest.webservices.restfulwebservices.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
public class UserController {

    private final UserDaoService service;

    public UserController(UserDaoService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return service.findAll();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id) {
        User user = service.findOne(id);
        if(user == null) {
            throw new UserNotFoundException("User with id:" + id + " not found!");
        }
        return user;
    }

    @PostMapping("/user")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        service.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(Objects.requireNonNull(user.getId()))
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
