package com.maen.app.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String product;
    private Double price;
    @Column(name = "creationdate")
    private LocalDate creationDate;
    @Column(name = "customer_id")
    private Integer customerId;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private CustomerEntity customerEntity;
}
