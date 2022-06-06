package com.nttdata.product.controller;

import com.nttdata.product.entity.SavingsAccount;
import com.nttdata.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/prueba")
    public String prueba(){
        SavingsAccount product = new SavingsAccount();
        product.setId(3);
        product.setStart_date(new Date());
        product.setMax_movement_limit(50);
        productRepository.save(product);
        return "exito 2";
    }

}
