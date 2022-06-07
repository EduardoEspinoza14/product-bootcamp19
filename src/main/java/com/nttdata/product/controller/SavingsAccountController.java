package com.nttdata.product.controller;

import com.nttdata.product.bussiness.impl.SavingsAccountService;
import com.nttdata.product.model.dto.SavingsAccount;
import com.nttdata.product.model.mongo.ProductMongo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/savings-account")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class SavingsAccountController {

    private final Logger log = LoggerFactory.getLogger(SavingsAccountController.class);

    @Autowired
    SavingsAccountService service;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<ProductMongo> getAllProducts() {
        return service.getProducts();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ProductMongo> getAllProducts(@PathVariable String id) {
        return service.getProduct(id);
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ProductMongo> createProduct(@RequestBody SavingsAccount product){
        return service.insertProduct(product);
    }

    @PostMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ProductMongo> modifyProduct(@RequestBody SavingsAccount product, @PathVariable String id){
        return service.updateProduct(product, id);
    }

    @PostMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Void> removeProduct(@PathVariable String id){
        return service.deleteProduct(id);
    }

    /*@PostMapping("/prueba")
    public Mono<String> prueba(){
        SavingsAccount product = new SavingsAccount();
        product.setStart_date(new Date());
        product.setMax_movement_limit(30);
        productService.insertProduct(Mono.just(product)).subscribe(pd -> log.info(pd.toString()));
        return Mono.just("exito");
    }*/

}
