package org.example.spring_exercice_api.repository;

import org.example.spring_exercice_api.entity.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Integer> {
}
