package com.nttdata.product.controller;

import com.nttdata.product.bussiness.ProductService;
import com.nttdata.product.model.mongo.ProductMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Class ProductController.
 */
@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*", methods = {
    RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE
})
public class ProductController {

  @Autowired
  ProductService service;

  @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  public Flux<ProductMongo> getAllProducts() {
    return service.getProducts();
  }

  @GetMapping(value = "/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Flux<ProductMongo> getAllProductsCustomer(@PathVariable String customerId) {
    return service.getProductsByCustomer(customerId);
  }

  @GetMapping(value = "/{customerId}/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<ProductMongo> getProductCustomer(@PathVariable String customerId,
                                               @PathVariable String id) {
    return service.getProductByCustomer(customerId, id);
  }

}
