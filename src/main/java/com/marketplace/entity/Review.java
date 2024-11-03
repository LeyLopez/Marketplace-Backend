package com.marketplace.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reviews")
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Integer calification;

    @Column(nullable = true)
    private String comment;

    @ManyToOne(targetEntity = User.class)
    private User client;

    @ManyToOne(targetEntity = User.class)
    private User salesman;

    @ManyToOne(targetEntity = Product.class)
    private Product product;

    @OneToOne(optional = false)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Response response;
}
