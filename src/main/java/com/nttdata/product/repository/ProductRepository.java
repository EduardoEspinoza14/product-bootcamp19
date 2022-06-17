package com.nttdata.product.repository;

import com.nttdata.product.model.mongo.ProductMongo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Interface ProductRepository.
 */
@Repository
public interface ProductRepository extends ReactiveMongoRepository<ProductMongo, String> {

  Flux<ProductMongo> findByType(String type);

  Flux<ProductMongo> findByCustomerId(String customerId);

  Mono<ProductMongo> findByCustomerIdAndId(String customerId, String id);

}
