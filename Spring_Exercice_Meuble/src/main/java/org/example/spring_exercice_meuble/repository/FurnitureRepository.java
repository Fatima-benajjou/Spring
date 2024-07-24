package org.example.spring_exercice_meuble.repository;

import org.example.spring_exercice_meuble.model.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FurnitureRepository extends JpaRepository<Furniture, Integer> {
    public Furniture findByName(String name);
    public Furniture findById(int id);
}
