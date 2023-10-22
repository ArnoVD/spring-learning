package com.arnovandijck.springboot.mytodoapp.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
public class Task {
    @Id
    @GeneratedValue
    private int id;
    private String userName;
    @Size(min = 5, message = "Enter at least 5 characters")
    @Size(max = 100, message = "Enter at most 100 characters")
    private String description;
    private LocalDate targetDate;
    private boolean taskIsDone;

    public Task() {
        super();
    }

    public Task(int id, String user, String description, LocalDate targetDate, boolean taskIsDone) {
        super();
        this.id = id;
        this.userName = user;
        this.description = description;
        this.targetDate = targetDate;
        this.taskIsDone = taskIsDone;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public boolean isTaskIsDone() {
        return taskIsDone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public void setTaskIsDone(boolean taskIsDone) {
        this.taskIsDone = taskIsDone;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", user='" + userName + '\'' +
                ", description='" + description + '\'' +
                ", targetDate=" + targetDate +
                ", taskIsDone=" + taskIsDone +
                '}';
    }
}
