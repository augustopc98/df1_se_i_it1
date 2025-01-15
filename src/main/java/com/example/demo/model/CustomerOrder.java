package com.example.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerEmail;
    private String customerAddress;

    @Temporal(TemporalType.DATE)
    private Date orderDate;

    private String deliveryStatus;

    public CustomerOrder() {}

    public CustomerOrder(Long id, String customerEmail, String customerAddress, Date orderDate) {
        this.id = id;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.orderDate = orderDate;
        this.deliveryStatus = "Pending";
    }

    // Getters and setters

    public void updateDeliveryStatus(String status) {
        this.deliveryStatus = status;
    }

    public void sendForDelivery() {
        this.deliveryStatus = "Out for Delivery";
    }

    // Getters

    public Long getId() { return id; }
    public String getCustomerEmail() { return customerEmail; }
    public String getCustomerAddress() { return customerAddress; }
    public Date getOrderDate() { return orderDate; }
}
