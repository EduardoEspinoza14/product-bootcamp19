package com.nttdata.product.bussiness.impl;

import com.nttdata.product.model.mongo.ProductMongo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class SavingsAccountService extends ProductServiceImpl {

    @Override
    public Flux<ProductMongo> getProducts() {
        return getProductsByType(ProductMongo.PRODUCT_TYPE_1);
    }

}
