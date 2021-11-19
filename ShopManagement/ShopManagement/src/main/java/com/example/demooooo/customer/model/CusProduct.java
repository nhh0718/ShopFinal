package com.example.demooooo.customer.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "product")
public class CusProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productid")
    private int id;

    private String productname;

    private String unitprice;

    private int quantity;

    private int selledquantity;

    private int idshop;
}
