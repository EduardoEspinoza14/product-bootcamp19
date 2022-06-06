package com.nttdata.product.repository;

import com.nttdata.product.entity.ProductMongo;
import com.nttdata.product.entity.SavingsAccount;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<ProductMongo, Integer> {
    Flux<SavingsAccount> findAllById(Integer id);

}
