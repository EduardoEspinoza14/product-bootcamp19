package com.nttdata.product.repository;

import com.nttdata.product.model.mongo.ProductMongo;
import com.nttdata.product.model.dto.SavingsAccount;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<ProductMongo, String> {
    //Flux<SavingsAccount> findAllById(Integer id);
    Flux<ProductMongo> findByType(String type);

    Flux<ProductMongo> findByCustomerId(String customerId);

    Mono<ProductMongo> findByCustomerIdAndId(String customerId, String id);

}
