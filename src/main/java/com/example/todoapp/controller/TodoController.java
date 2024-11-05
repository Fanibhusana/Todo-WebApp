package com.example.todoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.todoapp.model.Project;
import com.example.todoapp.model.Todo;
import com.example.todoapp.service.ProjectService;
import com.example.todoapp.service.TodoService;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

	@Autowired
    private TodoService todoService;

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public Todo createTodo(@RequestParam Long projectId, @RequestParam String description) {
        Project project = projectService.getProjectById(projectId);
        return todoService.createTodo(project, description);
    }

    @GetMapping("/project/{projectId}")
    public List<Todo> getTodosByProject(@PathVariable Long projectId) {
        Project project = projectService.getProjectById(projectId);
        return todoService.getTodosByProject(project);
    }

    @PatchMapping("/{todoId}")
    public Todo updateTodoStatus(@PathVariable Long todoId, @RequestParam boolean completed) {
        return todoService.updateTodoStatus(todoId, completed);
    }
}
