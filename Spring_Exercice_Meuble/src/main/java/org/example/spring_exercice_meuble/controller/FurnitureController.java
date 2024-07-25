package org.example.spring_exercice_meuble.controller;

import org.example.spring_exercice_meuble.model.Furniture;
import org.example.spring_exercice_meuble.service.FurnitureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/furniture")
public class FurnitureController {

    private final FurnitureService furnitureService;

    public FurnitureController(FurnitureService furnitureService) {
        this.furnitureService = furnitureService;
    }

    @GetMapping("/")
    public String listFurniture(Model model) {
        model.addAttribute("furnitures", furnitureService.getAllFurniture());
        return "furniture/listFurniture";

    }
    @GetMapping("/addFurniture")
    public String addFurniture(Model model) {
        model.addAttribute("furniture", new Furniture());
        return "furniture/addFurniture";
    }

    @PostMapping("/addFurniture")
    public String addFurniture(@ModelAttribute("furniture") Furniture furniture) {
        furnitureService.saveFurniture(furniture);
        return "redirect:/furniture/";
    }

    @GetMapping("/edit")
    public String showEditFurnitureForm(@RequestParam("id") int id, Model model) {
        Furniture furniture = furnitureService.getFurnitureById(id);
        model.addAttribute("furniture", furniture);
        return "furniture/editFurniture";
    }

    @PostMapping("/edit")
    public String editFurniture(@RequestParam("id") int id, @ModelAttribute Furniture furniture) {
        furniture.setId(id);
        furnitureService.saveFurniture(furniture);
        return "redirect:/furniture/";
    }

    @GetMapping("/delete")
    public String deleteFurniture(@RequestParam(name="id") int id) {
        furnitureService.deleteFurniture(id);
        return "redirect:/furniture/";
    }



}
