package org.example.spring_exercice_api.controller;

import org.example.spring_exercice_api.entity.Todo;
import org.example.spring_exercice_api.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo/")
public class todoController {

    TodoService todoService;

    public todoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<Todo>> findAll() {
        return ResponseEntity.ok(todoService.getAll());
    }

    @PostMapping("/create")
    public ResponseEntity<Todo> create(@RequestBody Todo todo) {
        Todo createdTodo = todoService.create(todo);
        return ResponseEntity.ok(createdTodo);
    }

    @GetMapping("{id}")
    public ResponseEntity<Todo> findById(@PathVariable int id) {
        return ResponseEntity.ok(todoService.getById(id));
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Todo> deleteById(@PathVariable int id) {
        todoService.delete(id);
        return ResponseEntity.ok(todoService.getById(id));
    }

    @PostMapping("/update")
    public ResponseEntity<Todo> update(@RequestBody Todo todo) {
        return ResponseEntity.ok(todoService.update(todo));
    }

}


