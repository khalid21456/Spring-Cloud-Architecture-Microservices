package com.example.inventory_service.repository;

import com.example.inventory_service.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, UUID> {

}
