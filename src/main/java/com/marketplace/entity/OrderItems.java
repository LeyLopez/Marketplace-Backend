package com.marketplace.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_items")
@Entity

public class OrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne(targetEntity = Order.class)
    @JsonBackReference
    @JsonIgnore
    private Order order;

    @ManyToOne(targetEntity = Product.class)
    @JsonBackReference
    @JsonIgnore
    private Product product;
}
