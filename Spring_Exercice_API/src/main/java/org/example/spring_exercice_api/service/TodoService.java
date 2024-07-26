package org.example.spring_exercice_api.service;

import org.example.spring_exercice_api.entity.Todo;
import org.example.spring_exercice_api.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    public final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAll() {
        return (List<Todo>) todoRepository.findAll();
    }

    public Todo getById(int id) {
        return todoRepository.findById(id).orElse(null);
    }

    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo create(Todo todo) {
        return todoRepository.save(todo);
    }

    public void delete(int id) {
        todoRepository.deleteById(id);
    }
    public Todo update(Todo todo) {
        return todoRepository.save(todo);
    }

   }
