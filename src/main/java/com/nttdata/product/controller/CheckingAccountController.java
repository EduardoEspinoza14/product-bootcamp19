package com.nttdata.product.controller;

import com.nttdata.product.bussiness.service.CheckingAccountService;
import com.nttdata.product.model.dto.CheckingAccount;
import com.nttdata.product.model.mongo.ProductMongo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/checking-account")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class CheckingAccountController {

    private final Logger log = LoggerFactory.getLogger(CheckingAccountController.class);

    @Autowired
    CheckingAccountService service;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<ProductMongo> getAllProducts() {
        return service.getProducts();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ProductMongo> getAllProducts(@PathVariable String id) {
        return service.getProduct(id);
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ProductMongo> createProduct(@RequestBody CheckingAccount product){
        return service.insertProduct(product);
    }

    @PostMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ProductMongo> modifyProduct(@RequestBody CheckingAccount product, @PathVariable String id){
        return service.updateProduct(product, id);
    }

    @PostMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Void> removeProduct(@PathVariable String id){
        return service.deleteProduct(id);
    }

}
