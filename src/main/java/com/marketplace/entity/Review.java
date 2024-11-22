package com.marketplace.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonBackReference
    @JsonIgnore
    private User client;

    @ManyToOne(targetEntity = User.class)
    @JsonBackReference
    @JsonIgnore
    private User salesman;

    @ManyToOne(targetEntity = Product.class)
    @JsonBackReference
    @JsonIgnore
    private Product product;

    @OneToOne(mappedBy = "review", cascade = CascadeType.ALL, optional = true)
    @JsonBackReference
    @JsonIgnore
    private Response response;
}
