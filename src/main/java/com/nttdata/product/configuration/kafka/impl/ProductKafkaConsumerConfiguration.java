package com.nttdata.product.configuration.kafka.impl;

import com.nttdata.product.bussiness.ProductService;
import com.nttdata.product.bussiness.redis.ProductServiceCache;
import com.nttdata.product.configuration.deserializer.JsonDeserializerProduct;
import com.nttdata.product.configuration.kafka.KafkaConsumerConfiguration;
import com.nttdata.product.model.dto.Wallet;
import com.nttdata.product.model.mongo.ProductMongo;
import com.nttdata.product.repository.ProductRepository;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.kafka.receiver.ReceiverOptions;

import java.util.HashMap;
import java.util.Map;

/**
 * Class ProductKafkaConsumerConfiguration.
 */
@Configuration
public class ProductKafkaConsumerConfiguration extends KafkaConsumerConfiguration<String, Wallet> {

  private final Logger log = LoggerFactory.getLogger(ProductKafkaConsumerConfiguration.class);

  @Autowired
  private ProductService service;

  @Override
  @Bean(name = "receiverProductOptions")
  public ReceiverOptions receiverOptions() {
    Map<String, Object> props = new HashMap<>();
    props.put(
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
            bootstrapAddress);
    props.put(
            ConsumerConfig.GROUP_ID_CONFIG,
            groupId);
    props.put(
            ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
            StringDeserializer.class);
    props.put(
            ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
            JsonDeserializerProduct.class);
    return ReceiverOptions.create(props);
  }

  @Override
  @Bean(name = "insertWalletData")
  public void insertData() {
    createReceiver(WALLET_TOPIC_INSERT)
            .flatMap(r -> service.insertProduct(r.value()))
            .doOnNext(r -> log.info("INSERT PRODUCT: {}", r))
            .subscribe();
  }

  @Override
  @Bean(name = "updateWalletData")
  public void updateData() {
    createReceiver(WALLET_TOPIC_UPDATE)
            .flatMap(r -> service.getProduct(r.key())
                    .flatMap(p -> service
                            .updateProduct(r.value(), r.key())))
            .doOnNext(r -> log.info("UPDATE PRODUCT: {}", r))
            .subscribe();
  }

  @Override
  @Bean(name = "deleteWalletData")
  public void deleteData() {
    createReceiver(WALLET_TOPIC_DELETE)
            .flatMap(r -> {
              return service.getProduct(r.key())
                      .doOnNext(q -> log.info("DELETE PRODUCT: {}", q))
                      .flatMap(p -> service.deleteProduct(p.getId()));
            })
            .subscribe();
  }

}
