package com.example.billing_service.repository;

import com.example.billing_service.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource
public interface ProductItemRepository extends JpaRepository<ProductItem, UUID> {
    List<ProductItem> findByBillId(UUID billId);
}
