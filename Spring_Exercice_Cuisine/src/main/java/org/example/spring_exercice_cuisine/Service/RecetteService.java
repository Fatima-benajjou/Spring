package org.example.spring_exercice_cuisine.Service;

import org.example.spring_exercice_cuisine.Model.Recette;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecetteService {
    private final List<Recette> recettes;
    private int compteurId = 1;

    public RecetteService() {
        recettes = new ArrayList<>();

        recettes.add((new Recette(compteurId++, "Lasagne", "pates", "instruction", "plat")));
        recettes.add((new Recette(compteurId++, "Risotto", "pates", "instruction", "plat2")));

    }

    public void addRecette(Recette recette) {
        recette.setId(recettes.size() + 1);
        recettes.add(recette);
    }

    public List<Recette> getAllRecettes() {
        return recettes;
    }

    public Recette getRecetteById(int id) {
        return recettes.stream().filter(recette -> recette.getId() == id).findFirst().orElse(null);
    }

    public Recette getRecetteByNom(String nom) {
        return recettes.stream().filter(r -> r.getNom().equals(nom)).findFirst().orElse(null);
    }

    public boolean deleteRecetteById(int id) {
        Recette recette = recettes.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
        return recettes.remove(recette);
    }

    public Recette updateRecette(Recette recette) {
        Recette recetteUpDate = getRecetteById(recette.getId());
        int index = recettes.indexOf(recetteUpDate);
        return recettes.set(index, recette);
    }

}

