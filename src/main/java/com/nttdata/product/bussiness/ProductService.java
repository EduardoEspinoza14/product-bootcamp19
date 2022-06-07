package com.nttdata.product.bussiness;

import com.nttdata.product.model.mongo.ProductMongo;
import reactor.core.publisher.Flux;

public interface ProductService {

    Flux<ProductMongo> getProducts();

}
