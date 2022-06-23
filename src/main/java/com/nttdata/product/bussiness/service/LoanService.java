package com.nttdata.product.bussiness.service;

import com.nttdata.product.bussiness.ProductService;
import com.nttdata.product.model.dto.Loan;
import com.nttdata.product.model.mongo.ProductMongo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Class LoanService.
 */
@Service
public class LoanService {

  private final ProductService productService;

  public LoanService(ProductService productService) {
    this.productService = productService;
  }

  public Flux<ProductMongo> getProducts() {
    return this.productService.getProductsByType(ProductMongo.PRODUCT_TYPE_5);
  }

  public Mono<ProductMongo> getProduct(String id) {
    return this.productService.getProduct(id);
  }

  public Mono<ProductMongo> insertProduct(Loan loan) {
    //DEBERIA VALIDAR
    return this.productService.insertProduct(loan);
  }

  public Mono<ProductMongo> updateProduct(Loan loan, String id) {
    //DEBERIA VALIDAR
    return this.productService.updateProduct(loan, id);
  }

  public Mono<Void> deleteProduct(String id) {
    return this.productService.deleteProduct(id);
  }

}
