package com.arnovandijck.springboot.mytodoapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@SessionAttributes("name")
public class TaskController {

    @RequestMapping(value = "/list-tasks")
    public String showTaskListPage(ModelMap model) {
        model.addAttribute("tasks", TaskService.findTaskByUser("arno"));
        return "list-tasks";
    }

    @GetMapping(value = "/add-task")
    public String showNewTaskPage(ModelMap model) {
        Task task = new Task(0, (String) model.get("name"), "", LocalDate.now(), false);
        model.addAttribute("task", task);
        return "task";
    }

    @GetMapping(value = "/update-task")
    public String showUpdateTaskPage(@RequestParam int id, ModelMap model) {
        Task task = TaskService.findTaskById(id);
        model.addAttribute("task", task);
        return "task";
    }

    @PostMapping(value = "/add-task")
    public String addNewTask(ModelMap model, @Valid Task task, BindingResult result) {
        if (result.hasErrors()) {
            return "task";
        }
        String userName = (String) model.get("name");
        TaskService.addNewTask(userName, task.getDescription(), LocalDate.now().plusYears(1), false);
        return "redirect:list-tasks";
    }

    @PostMapping(value = "/update-task")
    public String updateTask(ModelMap model, @Valid Task task, BindingResult result) {
        if (result.hasErrors()) {
            return "task";
        }
        String userName = (String) model.get("name");
        task.setUser(userName);
        TaskService.updateTask(task);
        return "redirect:list-tasks";
    }

    @RequestMapping(value = "/delete-task")
    public String deleteTask(@RequestParam int id) {
        TaskService.deleteTaskById(id);
        return "redirect:list-tasks";
    }
}
