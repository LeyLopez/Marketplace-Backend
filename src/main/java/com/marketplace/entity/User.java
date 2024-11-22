package com.marketplace.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String address;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    @OneToMany(targetEntity = Review.class, mappedBy = "client", fetch = FetchType.LAZY)
    @JsonManagedReference
    @JsonIgnore
    private Set<Review> reviews;

    @OneToMany(targetEntity = Review.class, mappedBy = "salesman", fetch = FetchType.LAZY)
    @JsonManagedReference
    @JsonIgnore
    private Set<Review> salesReviews;

    @OneToMany(targetEntity = Order.class, mappedBy = "client", fetch = FetchType.LAZY)
    @JsonManagedReference
    @JsonIgnore
    private Set<Order> orders;

    @OneToMany(targetEntity = Product.class, mappedBy = "salesman", fetch = FetchType.LAZY)
    @JsonManagedReference
    @JsonIgnore
    private Set<Product> products;
}
