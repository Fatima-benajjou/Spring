package org.example.spring_exercice_cuisine.Service;

import org.example.spring_exercice_cuisine.Model.Recette;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecetteService {
    private final List<Recette> recettes=new ArrayList<>();
    private int compteurId = 1;

//    public RecetteService() {

//
//        recettes.add((new Recette(compteurId++, "Lasagne", "pates", "instruction", 1)));
//        recettes.add((new Recette(compteurId++, "Risotto", "pates", "instruction", "plat2")));

//    }

    public void addRecette(Recette recette) {
        recette.setId(recettes.size() + 1);
        recettes.add(recette);
    }
    public void save(Recette recette) {
        if (recette.getId() == 0) {
            recette.setId(compteurId++);
            recettes.add(recette);
        } else {
            int index = recettes.indexOf(getRecetteById(recette.getId()));
            recettes.set(index, recette);
        }
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

