package org.example.spring_exercice_cuisine.Model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Recette {
    private int id;
    @NotNull (message = "champs obligatoire")
    private String nom;
    @NotNull(message = "veuillez remplir ce champs")
    private String ingredients;
    private String instructions;
    private String categorie;
}
