package org.example.spring_exercice_forum.repository;

import org.example.spring_exercice_forum.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
