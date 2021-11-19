package com.example.demooooo.product.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "productid")
    private int id;

    private int idshop;
    private String productname;
    private double unitprice;
    private int quantity, selledquantity;
}
