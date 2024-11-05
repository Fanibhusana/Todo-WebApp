package com.example.todoapp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todoapp.model.Project;
import com.example.todoapp.model.Todo;
import com.example.todoapp.repository.TodoRepository;


@Service
public class TodoService {

	@Autowired
    private TodoRepository todoRepository;

    public Todo createTodo(Project project, String description) {
        Todo todo = new Todo();
        todo.setDescription(description);
        todo.setCompleted(false);
        todo.setCreatedDate(LocalDate.now());
        todo.setProject(project);
        return todoRepository.save(todo);
    }

    public List<Todo> getTodosByProject(Project project) {
        return todoRepository.findAll().stream()
                .filter(todo -> todo.getProject().equals(project))
                .toList();
    }

    public Todo updateTodoStatus(Long todoId, boolean completed) {
        Todo todo = todoRepository.findById(todoId).orElse(null);
        if (todo != null) {
            todo.setCompleted(completed);
            todo.setUpdatedDate(LocalDate.now());
            return todoRepository.save(todo);
        }
        return null;
    }
}
