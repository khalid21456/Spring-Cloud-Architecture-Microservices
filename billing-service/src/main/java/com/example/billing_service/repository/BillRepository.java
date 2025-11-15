package com.example.billing_service.repository;

import com.example.billing_service.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource
public interface BillRepository extends JpaRepository<Bill, UUID> {

}
