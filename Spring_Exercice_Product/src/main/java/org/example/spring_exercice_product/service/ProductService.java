package org.example.spring_exercice_product.service;



import org.example.spring_exercice_product.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductService {

    private final List<Product> products;

    public ProductService() {
        products = new ArrayList<>();
        Product product = new Product();

        // Ajouter quelques produits pour la démonstration
        products.add(new Product(1, "Product1", "Food", 100));
        products.add(new Product(2, "Product2", "Electronic", 200));
        products.add(new Product(3, "Product3", "Mode", 150));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(int id) {
        return products.stream().filter(product -> product.getId() == id).findFirst().orElse(null);
    }

}