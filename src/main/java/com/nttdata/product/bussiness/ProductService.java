package com.nttdata.product.bussiness;

import com.nttdata.product.model.mongo.ProductMongo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {

    Flux<ProductMongo> getProducts();

    Flux<ProductMongo> getProductsByCustomer(String customerId);

    Mono<ProductMongo> getProduct(String id);

    Mono<ProductMongo> getProductByCustomer(String customerId, String id);

    Mono<ProductMongo> insertProduct(ProductMongo product);

    Mono<ProductMongo> updateProduct(ProductMongo product, String id);

    Mono<Void> deleteProduct(String id);

}
