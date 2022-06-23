package com.nttdata.product.bussiness.service;

import com.nttdata.product.bussiness.ProductService;
import com.nttdata.product.model.dto.SavingsAccount;
import com.nttdata.product.model.mongo.ProductMongo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Class SavingsAccountService.
 */
@Service
public class SavingsAccountService {

  private final ProductService productService;

  public SavingsAccountService(ProductService productService) {
    this.productService = productService;
  }

  public Flux<ProductMongo> getProducts() {
    return this.productService.getProductsByType(ProductMongo.PRODUCT_TYPE_1);
  }

  public Mono<ProductMongo> getProduct(String id) {
    return this.productService.getProduct(id);
  }

  public Mono<ProductMongo> insertProduct(SavingsAccount savingsAccount) {
    //DEBERIA VALIDAR
    return this.productService.insertProduct(savingsAccount);
  }

  public Mono<ProductMongo> updateProduct(SavingsAccount savingsAccount, String id) {
    //DEBERIA VALIDAR
    return this.productService.updateProduct(savingsAccount, id);
  }

  public Mono<Void> deleteProduct(String id) {
    return this.productService.deleteProduct(id);
  }

}
