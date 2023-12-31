package com.arnovandijck.springboot.mytodoapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    private static final List<Task> tasks = new ArrayList<>();

    private static int tasksCount = 1;

    static {
        tasks.add(new Task(tasksCount++, "arno", "Learn Spring MVC static", LocalDate.now(), false));
        tasks.add(new Task(tasksCount++, "arno", "Learn Struts static", LocalDate.now(), false));
        tasks.add(new Task(tasksCount++, "arno", "Learn Hibernate static", LocalDate.now(), false));
    }

    public static List<Task> findTaskByUser(String user) {
        return tasks.stream().filter(task -> task.getUserName().equalsIgnoreCase(user)).toList();
    }

    public static Task findTaskById(int id) {
        return tasks.stream().filter(task -> task.getId() == id).findFirst().orElse(null);
    }

    public static void addNewTask(String user, String description, LocalDate targetDate, boolean taskIsDone) {
        tasks.add(new Task(tasksCount++, user, description, targetDate, taskIsDone));
    }

    public static void deleteTaskById(int id) {
        tasks.removeIf(task -> task.getId() == id);
    }

    public static void updateTask(Task task) {
        deleteTaskById(task.getId());
        tasks.add(task);
    }
}
