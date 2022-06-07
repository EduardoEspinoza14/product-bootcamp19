package com.nttdata.product.bussiness;

import com.nttdata.product.model.mongo.ProductMongo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {

    Flux<ProductMongo> getProducts();

    Mono<ProductMongo> insertProduct(Mono<ProductMongo> product);

}
