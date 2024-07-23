package org.example.spring_exercice_cuisine.Controller;

import jakarta.validation.Valid;
import org.example.spring_exercice_cuisine.Model.Recette;
import org.example.spring_exercice_cuisine.Service.RecetteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/recettes")
public class RecetteController {

    private RecetteService recetteService;
public RecetteController(RecetteService recetteService) {
    this.recetteService = recetteService;
}

    @GetMapping("/")
    public String listRecettes(Model model) {
        model.addAttribute("recettes", recetteService.getAllRecettes());
        return "recettes/listeRecettes";
    }


    @GetMapping("/ajout")
    public String showAddRecetteForm(Model model) {
        model.addAttribute("recette", new Recette());
        return "recettes/ajoutRecette";
    }

    @PostMapping("/ajout")
    public String addRecette(@Valid @ModelAttribute Recette recette, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "recettes/ajoutRecette";
        }
        recetteService.addRecette(recette);
        return "redirect:/recettes";
    }

    @GetMapping("/modifier/{id}")
    public String showEditRecetteForm(@PathVariable("id") int id, Model model) {
        Recette recette = recetteService.getRecetteById(id);
        model.addAttribute("recette", recette);
        return "recettes/modifierRecette";
    }

    @PostMapping("/modifier/{id}")
    public String updateRecette(@PathVariable("id") int id, @Valid @ModelAttribute Recette recette, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "recettes/modifierRecette";
        }
        recetteService.addRecette(recette);
        return "redirect:/recettes";
    }

    @GetMapping("/supprimer/{id}")
    public String deleteRecette(@PathVariable("id") int id) {
        recetteService.deleteRecetteById(id);
        return "redirect:/recettes";
    }
}
