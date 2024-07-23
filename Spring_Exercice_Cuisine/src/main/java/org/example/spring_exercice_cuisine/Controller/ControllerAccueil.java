package org.example.spring_exercice_cuisine.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerAccueil {
    @GetMapping("/")
    public String accueil() {
        return "home";
    }

}
