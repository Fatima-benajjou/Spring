package org.example.spring_exercice_meuble.service;


import org.example.spring_exercice_meuble.model.CartItem;
import org.example.spring_exercice_meuble.model.Furniture;
import org.example.spring_exercice_meuble.repository.CartItemRepository;
import org.example.spring_exercice_meuble.repository.FurnitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private FurnitureRepository furnitureRepository;

  public List<CartItem> getAllCartItems() {
      return cartItemRepository.findAll();
  }

  public CartItem getCartById (int id) {
      return cartItemRepository.findById(id).orElse(null);
  }

  public CartItem addFurnitureToCart ( int id, int quantity) {
      Furniture furniture = furnitureRepository.findById(id).orElse(null);
      furniture.setStock(furniture.getStock() - quantity);

      CartItem cartItem = cartItemRepository.findCartItemByFurniture_Id(id);
      if (cartItem == null) {
          cartItem = new CartItem();
          cartItem.setFurniture(furniture);
          cartItem.setQuantity(quantity);


      } else {
          cartItem.setQuantity(cartItem.getQuantity() + quantity);
      }
      return cartItemRepository.save(cartItem);
  }



//    public void addToCart(int furnitureId, int quantity) {
//        Furniture furniture = furnitureRepository.findById(furnitureId).orElse(null);
//        if (furniture != null && quantity > 0 && furniture.getStock()>0) {
//            CartItem cartItem = new CartItem();
//            cartItem.setFurniture(furniture);
//            cartItem.setQuantity(quantity);
//            cartItemRepository.save(cartItem);
//            furniture.setStock(furniture.getStock() - quantity);
//            furnitureRepository.save(furniture);
//        }
//    }

    public void removeFromCart(int id) {
        CartItem cartItem = cartItemRepository.findById(id).orElse(null);
        if (cartItem != null) {
            Furniture furniture = cartItem.getFurniture();
            furniture.setStock(furniture.getStock() + cartItem.getQuantity());
            furnitureRepository.save(furniture);
            cartItemRepository.deleteById(id);
        }
    }

    public void clearCart() {
        List<CartItem> cartItems = cartItemRepository.findAll();
        for (CartItem cartItem : cartItems) {
            Furniture furniture = cartItem.getFurniture();
            furniture.setStock(furniture.getStock() + cartItem.getQuantity());
            furnitureRepository.save(furniture);
        }
        cartItemRepository.deleteAll();
    }



}

