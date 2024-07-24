package org.example.spring_exercice_meuble.service;

import org.example.spring_exercice_meuble.model.CartItem;
import org.example.spring_exercice_meuble.repository.CartItemRepository;
import org.example.spring_exercice_meuble.repository.FurnitureRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartIemService  {
    private final FurnitureService furnitureService;
    private List<CartItem> cartItems = new ArrayList<>();
    private int currentId=1;

    private final CartItemRepository cartItemRepository;
    private final FurnitureService furnitureService;

    public CartIemService(CartItemRepository cartItemRepository, FurnitureService furnitureService) {
        this.cartItemRepository = cartItemRepository;
        this.furnitureService = furnitureService;
    }

    public List<CartItem> getCartItems() {
        return cartItemRepository.findAll();
    }

    public CartItem addCartItem(CartItem entity) {
        entity.setId(currentId++);
        entity.setIdFurniture(furnitureService.getFurnitureById((entity.getFurniture().getId())))
        entity.setQuantity(entity.getQuantity());

    }


}
