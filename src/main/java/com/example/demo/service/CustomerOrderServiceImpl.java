package com.example.demo.service;

import com.example.demo.model.CustomerOrder;
import com.example.demo.repository.CustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    @Override
    public void createCustomerOrder(Long id, String customerEmail, String customerAddress, Date orderDate) {
        CustomerOrder customerOrder = new CustomerOrder(id, customerEmail, customerAddress, orderDate);
        customerOrderRepository.save(customerOrder);
    }

    @Override
    public void updateCustomerOrderDeliveryStatus(Long orderId, String status) {
        CustomerOrder customerOrder = customerOrderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("CustomerOrder not found"));
        customerOrder.updateDeliveryStatus(status);
        customerOrderRepository.save(customerOrder);
    }

    @Override
    public void processCustomerOrderForDelivery(Long orderId) {
        CustomerOrder customerOrder = customerOrderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("CustomerOrder not found"));
        customerOrder.sendForDelivery();
        customerOrderRepository.save(customerOrder);
    }

    @Override
    public CustomerOrder getCustomerOrderDetails(Long orderId) {
        return customerOrderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("CustomerOrder not found"));
    }
}
