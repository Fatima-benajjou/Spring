package org.example.spring_exercice_product.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Product {

    private int id;
    private String name;
    private String category;
    private double price;
}
