package com.arnovandijck.springboot.mytodoapp.todo;

import jakarta.validation.Valid;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@SessionAttributes("name")
public class TaskControllerJpa {

    private final TaskRepository taskRepository;

    public TaskControllerJpa(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @RequestMapping(value = "/list-tasks")
    public String showTaskListPage(ModelMap model) {
        String userName = getLoggedInUserName();
        model.addAttribute("tasks", taskRepository.findAllByUserName(userName));
        return "list-tasks";
    }

    @GetMapping(value = "/add-task")
    public String showNewTaskPage(ModelMap model) {
        Task task = new Task(0, getLoggedInUserName(), "", LocalDate.now(), false);
        model.addAttribute("task", task);
        return "task";
    }

    @GetMapping(value = "/update-task")
    public String showUpdateTaskPage(@RequestParam int id, ModelMap model) {
        Task task = taskRepository.findById(id).orElse(null);
        // not null or not empty
        if(task != null) {
            model.addAttribute("task", task);
            return "task";
        }
        return "redirect:list-tasks";
    }

    @PostMapping(value = "/add-task")
    public String addNewTask(ModelMap model, @Valid Task task, BindingResult result) {
        if (result.hasErrors()) {
            return "task";
        }
        task.setUserName(getLoggedInUserName());
        taskRepository.save(task);
        return "redirect:list-tasks";
    }

    @PostMapping(value = "/update-task")
    public String updateTask(ModelMap model, @Valid Task task, BindingResult result) {
        if (result.hasErrors()) {
            return "task";
        }
        task.setUserName(getLoggedInUserName());
        taskRepository.save(task);
        return "redirect:list-tasks";
    }

    @RequestMapping(value = "/delete-task")
    public String deleteTask(@RequestParam int id) {
        taskRepository.deleteById(id);
        return "redirect:list-tasks";
    }

    private String getLoggedInUserName() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
