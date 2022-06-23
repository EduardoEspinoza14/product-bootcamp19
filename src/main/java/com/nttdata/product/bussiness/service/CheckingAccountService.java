package com.nttdata.product.bussiness.service;

import com.nttdata.product.bussiness.ProductService;
import com.nttdata.product.model.dto.CheckingAccount;
import com.nttdata.product.model.mongo.ProductMongo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Class CheckingAccountService.
 */
@Service
public class CheckingAccountService {

  private final ProductService productService;

  public CheckingAccountService(ProductService productService) {
    this.productService = productService;
  }

  public Flux<ProductMongo> getProducts() {
    return this.productService.getProductsByType(ProductMongo.PRODUCT_TYPE_2);
  }

  public Mono<ProductMongo> getProduct(String id) {
    return this.productService.getProduct(id);
  }

  public Mono<ProductMongo> insertProduct(CheckingAccount checkingAccount) {
    //DEBERIA VALIDAR
    return this.productService.insertProduct(checkingAccount);
  }

  public Mono<ProductMongo> updateProduct(CheckingAccount checkingAccount, String id) {
    //DEBERIA VALIDAR
    return this.productService.updateProduct(checkingAccount, id);
  }

  public Mono<Void> deleteProduct(String id) {
    return this.productService.deleteProduct(id);
  }

}
