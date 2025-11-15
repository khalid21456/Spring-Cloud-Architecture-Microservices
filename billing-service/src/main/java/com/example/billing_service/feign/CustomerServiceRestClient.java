package com.example.billing_service.feign;


import com.example.billing_service.models.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "customer-service")
public interface CustomerServiceRestClient {
    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customer-service", fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable UUID id);

    default Customer getDefaultCustomer(UUID id, Exception ex) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName("default customer name");
        customer.setEmail("default@gmail.com");
        return customer;
    }
}
