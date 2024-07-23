package org.example.spring_exercice_cuisine.Service;

import java.util.ArrayList;
import java.util.List;

import org.example.spring_exercice_cuisine.Model.Categorie;
import org.example.spring_exercice_cuisine.Model.Recette;
import org.springframework.stereotype.Service;

@Service
public class CategorieService {
    private final List<Categorie> categories = new ArrayList<>();
    private int currentId = 1;

    public CategorieService() {
        categories.add(new Categorie(currentId++,"Categorie1", "description1"));
        categories.add(new Categorie(currentId++,"Categorie2", "description2"));
    }

    public void addCategorie(Categorie categorie) {
        categorie.setId((categories.size()+1));
        categories.add(categorie);
    }

    public List<Categorie> getAll() {
        return categories;
    }

    public Categorie getCategorieById(int id) {
        return categories.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

   public Categorie getCategorieByNom(String nom) {
        return categories.stream().filter(c -> c.getNom().equals(nom)).findFirst().orElse(null);
   }

    public boolean deleteCategorieById(int id) {
        Categorie categorie = categories.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
        return categories.remove(categorie);
    }

    public Categorie updateCategorie(Categorie categorie) {
        Categorie old = getCategorieById(categorie.getId());
       int index = categories.indexOf(old);
       return categories.set(index, categorie);
    }
}
