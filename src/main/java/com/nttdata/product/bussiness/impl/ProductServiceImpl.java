package com.nttdata.product.bussiness.impl;

import com.nttdata.product.bussiness.ProductService;
import com.nttdata.product.model.mongo.ProductMongo;
import com.nttdata.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Flux<ProductMongo> getProducts() {
        return productRepository.findAll();
    }

}
