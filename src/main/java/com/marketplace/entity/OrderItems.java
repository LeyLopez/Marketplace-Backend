package com.marketplace.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders_items")
@Entity

public class OrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long quantity;

    @ManyToOne(targetEntity = Order.class)
    private Order order;

    @ManyToOne(targetEntity = Product.class)
    private Product product;
}
