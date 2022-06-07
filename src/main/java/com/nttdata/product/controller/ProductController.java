package com.nttdata.product.controller;

import com.nttdata.product.bussiness.ProductService;
import com.nttdata.product.model.mongo.ProductMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<ProductMongo> getAllProducts() {
        return productService.getProducts();
    }

    /*@GetMapping("/prueba")
    public String prueba(){
        SavingsAccount product = new SavingsAccount();
        product.setId(3);
        product.setStart_date(new Date());
        product.setMax_movement_limit(50);
        productRepository.save(product);
        return "exito 2";
    }*/

}
