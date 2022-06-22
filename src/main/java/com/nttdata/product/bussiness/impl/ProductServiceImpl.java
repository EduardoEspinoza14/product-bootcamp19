package com.nttdata.product.bussiness.impl;

import com.nttdata.product.bussiness.ProductService;
import com.nttdata.product.configuration.KafkaProducerConfiguration;
import com.nttdata.product.model.mongo.ProductMongo;
import com.nttdata.product.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.kafka.sender.SenderOptions;

/**
 * Class ProductServiceImpl.
 */
@Service
@Primary
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private SenderOptions<String, ProductMongo> senderOptions;

  @Override
  public Flux<ProductMongo> getProducts() {
    return productRepository.findAll();
  }

  @Override
  public Flux<ProductMongo> getProductsByCustomer(String customerId) {
    return productRepository.findByCustomerId(customerId);
  }

  public Flux<ProductMongo> getProductsByType(String type) {
    return productRepository.findByType(type);
  }

  @Override
  public Mono<ProductMongo> getProduct(String id) {
    return productRepository.findById(id);
  }

  @Override
  public Mono<ProductMongo> getProductByCustomer(String customerId, String id) {
    return productRepository.findByCustomerIdAndId(customerId, id);
  }

  @Override
  public Mono<ProductMongo> insertProduct(ProductMongo product) {
    return productRepository.insert(product)
            .doOnSuccess(productMongo -> KafkaProducerConfiguration
                    .senderCreate(senderOptions,
                            KafkaProducerConfiguration.insertRecord(productMongo))
                    .subscribe());
  }

  @Override
  public Mono<ProductMongo> updateProduct(ProductMongo product, String id) {
    return productRepository.findById(id)
            .map(productMongo -> {
              BeanUtils.copyProperties(product, productMongo, "id", "type");
              return productMongo;
            })
            .flatMap(productRepository::save)
            .doOnSuccess(productMongo -> KafkaProducerConfiguration
                    .senderCreate(senderOptions,
                            KafkaProducerConfiguration.updateRecord(productMongo))
                    .subscribe());
  }

  @Override
  public Mono<Void> deleteProduct(String id) {
    return productRepository.findById(id)
            .flatMap(p -> productRepository.deleteById(p.getId()))
            .doOnSuccess(voidReturn -> KafkaProducerConfiguration
                    .senderCreate(senderOptions, KafkaProducerConfiguration.deleteRecord(id))
                    .subscribe());
  }

}
