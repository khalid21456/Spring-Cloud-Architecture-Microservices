package com.example.billing_service.models;

import lombok.*;

import java.util.UUID;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class Customer {
    private UUID id;
    private String name;
    private String email;
}
