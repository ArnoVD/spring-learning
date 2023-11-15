package com.arnovandijck.rest.webservices.restfulwebservices.user.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class ErrorDetails {
    private final LocalDateTime timestamp;
    private final String message;
    private final String details;
}
