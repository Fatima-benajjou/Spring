package org.example.spring_exercice_forum.repository;

import org.example.spring_exercice_forum.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
