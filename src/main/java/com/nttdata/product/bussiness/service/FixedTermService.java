package com.nttdata.product.bussiness.service;

import com.nttdata.product.bussiness.ProductService;
import com.nttdata.product.model.dto.FixedTerm;
import com.nttdata.product.model.mongo.ProductMongo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Class FixedTermService.
 */
@Service
public class FixedTermService {

  private final ProductService productService;

  public FixedTermService(ProductService productService) {
    this.productService = productService;
  }

  public Flux<ProductMongo> getProducts() {
    return this.productService.getProductsByType(ProductMongo.PRODUCT_TYPE_3);
  }

  public Mono<ProductMongo> getProduct(String id) {
    return this.productService.getProduct(id);
  }

  public Mono<ProductMongo> insertProduct(FixedTerm fixedTerm) {
    //DEBERIA VALIDAR
    return this.productService.insertProduct(fixedTerm);
  }

  public Mono<ProductMongo> updateProduct(FixedTerm fixedTerm, String id) {
    //DEBERIA VALIDAR
    return this.productService.updateProduct(fixedTerm, id);
  }

  public Mono<Void> deleteProduct(String id) {
    return this.productService.deleteProduct(id);
  }

}
