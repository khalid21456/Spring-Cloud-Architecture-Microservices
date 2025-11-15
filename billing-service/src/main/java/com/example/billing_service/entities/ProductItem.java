package com.example.billing_service.entities;


import com.example.billing_service.models.Product;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ProductItem {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID productId;
    private int quantity;
    private double price;
    @ManyToOne
    private Bill bill;  
    @Transient
    private Product product;
}
