package com.nttdata.product.controller;

import com.nttdata.product.bussiness.service.FixedTermService;
import com.nttdata.product.model.dto.FixedTerm;
import com.nttdata.product.model.mongo.ProductMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Class FixedTermController.
 */
@RestController
@RequestMapping("/fixed-term")
@CrossOrigin(origins = "*", methods = {
  RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE
})
public class FixedTermController {

  @Autowired
  FixedTermService service;

  @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  public Flux<ProductMongo> getAllProducts() {
    return service.getProducts();
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<ProductMongo> getProduct(@PathVariable String id) {
    return service.getProduct(id);
  }

  @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<ProductMongo> createProduct(@RequestBody FixedTerm product) {
    return service.insertProduct(product);
  }

  @PostMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<ProductMongo> modifyProduct(@RequestBody FixedTerm product, @PathVariable String id) {
    return service.updateProduct(product, id);
  }

  @PostMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<Void> removeProduct(@PathVariable String id) {
    return service.deleteProduct(id);
  }

}
