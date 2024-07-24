package org.example.spring_exercice_meuble.service;

import org.example.spring_exercice_meuble.model.Furniture;
import org.example.spring_exercice_meuble.repository.FurnitureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FurnitureService {
    private final FurnitureRepository furnitureRepository;

    public FurnitureService(FurnitureRepository furnitureRepository) {
        this.furnitureRepository = furnitureRepository;
    }

    public List<Furniture> getAllFurnitures() {
        return furnitureRepository.findAll();
    }
    public Furniture getFurnitureById(int id) {
        return furnitureRepository.findById(id);
    }

    public Furniture saveFurniture(Furniture furniture) {
        return furnitureRepository.save(furniture);
    }

    public void deleteFurniture(Furniture furniture) {
         furnitureRepository.delete(furniture);
    }
}
