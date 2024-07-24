package org.example.spring_exercice_cuisine.Controller;


import jakarta.validation.Valid;
import org.example.spring_exercice_cuisine.Model.Categorie;
import org.example.spring_exercice_cuisine.Service.CategorieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categories")
public class CategorieController {

    private CategorieService categorieService;
    public CategorieController(CategorieService categorieService) {this.categorieService = categorieService;}

    @GetMapping("/")
    public String listCategories(Model model) {
        model.addAttribute("categories", categorieService.getAll());
        return "categories/listeCategories";
    }

    @GetMapping("/ajout")
    public String showAddCategorieForm(Model model) {
        model.addAttribute("categorie", new Categorie());
        return "categories/ajoutCategorie";
    }

    @PostMapping("/ajout")
    public String addCategorie(@Valid @ModelAttribute Categorie categorie, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:/categories/ajout";
        }
        categorieService.addCategorie(categorie);
        return "redirect:/categories";
    }

    @GetMapping("/modifier/{id}")
    public String showEditCategorieForm(@PathVariable("id") int id, Model model) {
        Categorie categorie = categorieService.getCategorieById(id);
        model.addAttribute("categorie", categorie);
        return "categories/modifierCategorie";
    }

    @PostMapping("/modifier/{id}")
    public String updateCategorie(@PathVariable("id") int id, @Valid @ModelAttribute Categorie categorie, BindingResult result) {
        if (result.hasErrors()) {
            return "categories/modifierCategorie";
        }
        categorieService.addCategorie(categorie);
        return "redirect:/categories";
    }

    @GetMapping("/supprimer/{id}")
    public String deleteCategorie(@PathVariable("id") int id) {
        categorieService.deleteCategorieById(id);
        return "redirect:/categories";
    }
}

