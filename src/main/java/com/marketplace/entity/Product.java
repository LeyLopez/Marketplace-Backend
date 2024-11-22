package com.marketplace.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "products")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer availability;

    @Column(nullable = false)
    private String image;


    @Enumerated(EnumType.STRING)
    private ProductStatus status;


    @ManyToOne(targetEntity = Category.class)
    @JsonBackReference
    @JsonIgnore
    private Category category;

    @ManyToOne(targetEntity = User.class)
    @JsonBackReference
    @JsonIgnore
    private User salesman;

    @OneToMany(targetEntity = Review.class, mappedBy = "product", fetch = FetchType.LAZY)
    @JsonManagedReference
    @JsonIgnore
    private Set<Review> reviews;

    @OneToMany(targetEntity = OrderItems.class, mappedBy = "product", fetch = FetchType.LAZY)
    @JsonManagedReference
    @JsonIgnore
    private Set<OrderItems> orderItems;
}
