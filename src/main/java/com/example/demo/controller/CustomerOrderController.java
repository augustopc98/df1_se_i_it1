package com.example.demo.controller;

import com.example.demo.model.CustomerOrder;
import com.example.demo.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/customer-orders")
public class CustomerOrderController {

    @Autowired
    private CustomerOrderService customerOrderService;

    @PostMapping
    public ResponseEntity<String> createCustomerOrder(@RequestParam Long id,
                                                      @RequestParam String customerEmail,
                                                      @RequestParam String customerAddress) {
        customerOrderService.createCustomerOrder(id, customerEmail, customerAddress, new Date());
        return ResponseEntity.ok("CustomerOrder created successfully!");
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<String> updateCustomerOrderDeliveryStatus(@PathVariable Long id,
                                                                    @RequestParam String status) {
        customerOrderService.updateCustomerOrderDeliveryStatus(id, status);
        return ResponseEntity.ok("CustomerOrder status updated successfully!");
    }

    @PutMapping("/{id}/process")
    public ResponseEntity<String> processCustomerOrderForDelivery(@PathVariable Long id) {
        customerOrderService.processCustomerOrderForDelivery(id);
        return ResponseEntity.ok("CustomerOrder processed for delivery!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerOrder> getCustomerOrderDetails(@PathVariable Long id) {
        CustomerOrder customerOrder = customerOrderService.getCustomerOrderDetails(id);
        return ResponseEntity.ok(customerOrder);
    }
}
