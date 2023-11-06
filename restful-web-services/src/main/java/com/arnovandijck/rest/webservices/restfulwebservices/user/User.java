package com.arnovandijck.rest.webservices.restfulwebservices.user;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private Integer id;
    private String name;
    private LocalDate birthDate;
}
