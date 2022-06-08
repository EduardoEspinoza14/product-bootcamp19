package com.nttdata.product.controller;

import com.nttdata.product.bussiness.service.LoanService;
import com.nttdata.product.model.dto.Loan;
import com.nttdata.product.model.mongo.ProductMongo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/loan")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class LoanController {

    private final Logger log = LoggerFactory.getLogger(LoanController.class);

    @Autowired
    LoanService service;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<ProductMongo> getAllProducts() {
        return service.getProducts();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ProductMongo> getProduct(@PathVariable String id) {
        return service.getProduct(id);
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ProductMongo> createProduct(@RequestBody Loan product){
        return service.insertProduct(product);
    }

    @PostMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ProductMongo> modifyProduct(@RequestBody Loan product, @PathVariable String id){
        return service.updateProduct(product, id);
    }

    @PostMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Void> removeProduct(@PathVariable String id){
        return service.deleteProduct(id);
    }

}
