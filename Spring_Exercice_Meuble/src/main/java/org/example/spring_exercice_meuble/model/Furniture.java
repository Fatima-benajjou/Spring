package org.example.spring_exercice_meuble.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="fourniture")
public class Furniture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
    private int id;
    private String name;
    private String description;
    private double price;
    private int stock;
    @OneToOne
    @JoinColumn(name="id_CartItem")
    private CartItem cartItem;

}
