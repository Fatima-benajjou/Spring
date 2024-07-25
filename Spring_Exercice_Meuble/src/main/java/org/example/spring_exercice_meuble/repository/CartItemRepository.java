package org.example.spring_exercice_meuble.repository;

import org.example.spring_exercice_meuble.model.CartItem;
import org.example.spring_exercice_meuble.model.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    CartItem findCartItemByFurniture_Id(int id);

}
