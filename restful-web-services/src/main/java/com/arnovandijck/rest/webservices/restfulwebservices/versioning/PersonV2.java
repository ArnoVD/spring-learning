package com.arnovandijck.rest.webservices.restfulwebservices.versioning;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PersonV2 {
    private final String firstName;
    private final String lastName;
}
