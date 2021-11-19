package com.example.demooooo.product.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundExp extends RuntimeException{
    public ProductNotFoundExp(){
        super();
    }
}
