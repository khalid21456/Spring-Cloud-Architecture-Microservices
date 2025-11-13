package com.ecom.customer_service.repository;

import com.ecom.customer_service.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, UUID> {

}
