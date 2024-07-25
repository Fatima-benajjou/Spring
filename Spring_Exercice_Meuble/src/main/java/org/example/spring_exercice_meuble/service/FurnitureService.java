package org.example.spring_exercice_meuble.service;

import org.example.spring_exercice_meuble.model.Furniture;
import org.example.spring_exercice_meuble.repository.FurnitureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class FurnitureService {

    @Autowired
    private FurnitureRepository furnitureRepository;

    public List<Furniture> getAllFurniture() {
        return furnitureRepository.findAll();
    }

    public void saveFurniture(Furniture furniture) {
        furnitureRepository.save(furniture);
    }

    public Furniture getFurnitureById(int id) {
        return furnitureRepository.findById(id).orElse(null);
    }

    public void deleteFurniture(int id) {
        furnitureRepository.deleteById(id);
    }
}

