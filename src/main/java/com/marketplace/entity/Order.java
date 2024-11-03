package com.marketplace.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Double total;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @ManyToOne(targetEntity = User.class)
    private User client;

    @OneToMany(targetEntity = OrderItems.class)
    private Set<OrderItems> orderItems;



}
