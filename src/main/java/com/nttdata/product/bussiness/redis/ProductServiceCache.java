package com.nttdata.product.bussiness.redis;

import com.nttdata.product.bussiness.impl.ProductServiceImpl;
import com.nttdata.product.model.mongo.ProductMongo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.redis.core.ReactiveHashOperations;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * Class ProductServiceCache.
 */
@Service
@ConditionalOnProperty(name = "cache.enabled", havingValue = "true")
public class ProductServiceCache extends ProductServiceImpl {

  private final Logger log = LoggerFactory.getLogger(ProductServiceCache.class);

  private static final String KEY_CACHE = "products";

  @Autowired
  private ReactiveHashOperations<String, String, ProductMongo> hashOperations;

  @Override
  public Mono<ProductMongo> getProduct(String id) {
    return hashOperations.get(KEY_CACHE, id)
            .switchIfEmpty(this.getProductSaveCacheRedis(id));
  }

  @Override
  public Mono<ProductMongo> insertProduct(ProductMongo productMongo) {
    return super.insertProduct(productMongo)
            .flatMap(this::saveCacheRedis);
  }

  @Override
  public Mono<ProductMongo> updateProduct(ProductMongo product, String id) {
    return this.hashOperations.remove(KEY_CACHE, id)
            .then(super.updateProduct(product, id))
            .flatMap(this::saveCacheRedis);
  }

  @Override
  public Mono<Void> deleteProduct(String id) {
    return this.hashOperations.remove(KEY_CACHE, id)
            .then(super.deleteProduct(id));
  }

  private Mono<ProductMongo> getProductSaveCacheRedis(String id) {
    return super.getProduct(id)
            .flatMap(this::saveCacheRedis);
  }

  private Mono<ProductMongo> saveCacheRedis(ProductMongo productMongo) {
    log.info("REDIS CACHE PRODUCT: {}", productMongo);
    return this.hashOperations.put(KEY_CACHE,
                    productMongo.getId(),
                    productMongo)
            .thenReturn(productMongo);
  }

}
