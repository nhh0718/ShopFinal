package com.example.demooooo.shop.shopDto;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@Table(name = "shop")
public class ShopDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idshop")
    private int id;

    @NotEmpty(message = "Chưa nhập tên cửa hàng!")
    private String shopname;

    @NotEmpty(message = "Chưa nhập địa chỉ cửa hàng!")
    private String shopaddress;

//    @Pattern(regexp="(^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$)", message = "Nhập sai sđt kìa !")
    @NotEmpty(message = "Chưa nhập số điện thoại!")
    private String shoptel;

    private String shopdesc;

    private int userid;

    private int totalselledproduct;
}
