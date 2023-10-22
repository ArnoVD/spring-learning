package com.arnovandijck.springboot.mytodoapp.todo;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@ToString
public class Task {
    private int id;
    private String user;
    @Size(min = 5, message = "Enter at least 5 characters")
    @Size(max = 100, message = "Enter at most 100 characters")
    private String description;
    private LocalDate targetDate;
    private boolean taskIsDone;
}
