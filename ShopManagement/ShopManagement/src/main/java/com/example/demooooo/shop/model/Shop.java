package com.example.demooooo.shop.model;

import lombok.Data;

import javax.persistence.*;
@Entity
@Data
@Table(name = "shop")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idshop")
    private int id;

    private String shopname;

    private String shopaddress;

    private String shoptel;

    private String shopdesc;

    private int userid;

    private int totalselledproduct;
}
