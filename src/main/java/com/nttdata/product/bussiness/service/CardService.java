package com.nttdata.product.bussiness.service;

import com.nttdata.product.bussiness.ProductService;
import com.nttdata.product.bussiness.impl.ProductServiceImpl;
import com.nttdata.product.model.dto.Card;
import com.nttdata.product.model.mongo.ProductMongo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * Class CardService.
 */
@Service
public class CardService {

  private final ProductService productService;

  public CardService(ProductService productService) {
    this.productService = productService;
  }

  public Flux<ProductMongo> getProducts() {
    return this.productService.getProductsByType(ProductMongo.PRODUCT_TYPE_4);
  }

  public Mono<ProductMongo> getProduct(String id) {
    return this.productService.getProduct(id);
  }

  public Mono<ProductMongo> insertProduct(Card card) {
    //DEBERIA VALIDAR
    return this.productService.insertProduct(card);
  }

  public Mono<ProductMongo> updateProduct(Card card, String id) {
    //DEBERIA VALIDAR
    return this.productService.updateProduct(card, id);
  }

  public Mono<Void> deleteProduct(String id) {
    return this.productService.deleteProduct(id);
  }

}
