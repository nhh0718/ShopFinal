package com.example.demooooo.customer.dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class CusShopDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String shopname;

    private String shopaddress;

    private String shoptel;

    private String shopdesc;

    private int totalselledproduct;

    private int userid;
}
