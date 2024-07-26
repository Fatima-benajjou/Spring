package org.example.spring_exercice_forum.repository;

import org.example.spring_exercice_forum.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
