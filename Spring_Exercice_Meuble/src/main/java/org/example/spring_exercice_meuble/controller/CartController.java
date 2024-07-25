package org.example.spring_exercice_meuble.controller;

import org.example.spring_exercice_meuble.service.CartService;
import org.example.spring_exercice_meuble.service.FurnitureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;
    private final FurnitureService furnitureService;

    public CartController(CartService cartService, FurnitureService furnitureService) {
        this.cartService = cartService;
        this.furnitureService = furnitureService;
    }
    @GetMapping
    public String viewCart(Model model) {
        model.addAttribute("cartItems", cartService.getAllCartItems());
        return "cart/cart";
    }

    @PostMapping("/add")
    public String addFurnitureToCart(@RequestParam("furnitureId") int furnitureId, @RequestParam("quantity") int quantity) {
        cartService.addFurnitureToCart(furnitureId, quantity);
        return "redirect:/cart";
    }

    @GetMapping("/remove")
    public String removeFromCart(@RequestParam("id") int id) {
        cartService.removeFromCart(id);
        return "redirect:/cart";
    }

    @GetMapping("/clear")
    public String clearCart() {
        cartService.clearCart();
        return "redirect:/cart";
    }
}

