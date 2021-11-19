package com.example.demooooo.product.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
public class ProductDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "productid")
    private int id;

    private int idshop;
    private String productname;
    private double unitprice;
    private int quantity, selledquantity;
}
