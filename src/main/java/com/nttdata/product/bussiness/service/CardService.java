package com.nttdata.product.bussiness.service;

import com.nttdata.product.bussiness.impl.ProductServiceImpl;
import com.nttdata.product.model.mongo.ProductMongo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class CardService extends ProductServiceImpl {

    @Override
    public Flux<ProductMongo> getProducts() {
        return getProductsByType(ProductMongo.PRODUCT_TYPE_4);
    }

}
