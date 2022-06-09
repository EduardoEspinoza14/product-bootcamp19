package com.nttdata.product.controller;

import com.nttdata.product.bussiness.ProductService;
import com.nttdata.product.model.mongo.ProductMongo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class ProductController {

    private final Logger log = LoggerFactory.getLogger(SavingsAccountController.class);

    @Autowired
    ProductService service;

    @GetMapping(value = "/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<ProductMongo> getAllProductsCustomer(@PathVariable String customerId) {
        return service.getProductsByCustomer(customerId);
    }

    @GetMapping(value = "/{customerId}/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ProductMongo> getProductCustomer(@PathVariable String customerId, @PathVariable String id) {
        return service.getProductByCustomer(customerId, id);
    }

}
