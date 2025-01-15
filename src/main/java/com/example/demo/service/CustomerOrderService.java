package com.example.demo.service;

import com.example.demo.model.CustomerOrder;

import java.util.Date;

public interface CustomerOrderService {
    void createCustomerOrder(Long id, String customerEmail, String customerAddress, Date orderDate);
    void updateCustomerOrderDeliveryStatus(Long orderId, String status);
    void processCustomerOrderForDelivery(Long orderId);
    CustomerOrder getCustomerOrderDetails(Long orderId);

}
