package com.example.billing_service.web;


import com.example.billing_service.entities.Bill;
import com.example.billing_service.feign.CustomerServiceRestClient;
import com.example.billing_service.feign.InventoryServiceRestClient;
import com.example.billing_service.models.Customer;
import com.example.billing_service.repository.BillRepository;
import com.example.billing_service.repository.ProductItemRepository;
import jakarta.ws.rs.Path;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class BillController {
    private final BillRepository billRepository;
    private final ProductItemRepository productItemRepository;
    private final CustomerServiceRestClient customerServiceRestClient;
    private final InventoryServiceRestClient inventoryServiceRestClient;

    public BillController(BillRepository billRepository,
                          ProductItemRepository productItemRepository,
                          CustomerServiceRestClient customerServiceRestClient,
                          InventoryServiceRestClient inventoryServiceRestClient) {
        this.billRepository = billRepository;
        this.productItemRepository = productItemRepository;
        this.customerServiceRestClient = customerServiceRestClient;
        this.inventoryServiceRestClient = inventoryServiceRestClient;
    }

    @GetMapping("/bills/{id}")
    public Bill getBillBy(@PathVariable UUID id) {
        Bill bill = billRepository.findById(id).get();
        Customer customer = customerServiceRestClient.findCustomerById(bill.getCustomerId());
        bill.setCustomer(customer);
        return bill;
    }
}
