package com.nttdata.product.configuration;

import com.nttdata.product.model.dto.Card;
import com.nttdata.product.model.mongo.ProductMongo;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.serializer.JsonSerializer;
import reactor.core.publisher.Flux;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderOptions;
import reactor.kafka.sender.SenderRecord;
import reactor.kafka.sender.SenderResult;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfiguration {

  public static final String TOPIC_INSERT = "product.insert";
  public static final String TOPIC_UPDATE = "product.update";
  public static final String TOPIC_DELETE = "product.delete";

  @Value(value = "${kafka.bootstrapAddress:}")
  private String bootstrapAddress;

  public static Flux<SenderResult<Long>> senderCreate(SenderOptions<String, ProductMongo> options, SenderRecord<String, ProductMongo, Long> record){
    return KafkaSender.<String, ProductMongo>create(options).send(Flux.just(record));
  }

  @Bean
  public SenderOptions<String, ProductMongo> senderOptions() {
    Map<String, Object> props = new HashMap<>();
    props.put(
            ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
            bootstrapAddress);
    props.put(
            ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
            StringSerializer.class);
    props.put(
            ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
            JsonSerializer.class);
    return SenderOptions.create(props);
  }

  private static SenderRecord<String, ProductMongo, Long> senderRecord(String id, ProductMongo productMongo, String topic, Long correlation){
    return SenderRecord.create(
            new ProducerRecord<>(topic, id, productMongo), correlation);
  }

  private static SenderRecord<String, ProductMongo, Long> senderRecord(String id, ProductMongo productMongo, String topic){
    return senderRecord(id, productMongo, topic, new Date().getTime());
  }

  private static SenderRecord<String, ProductMongo, Long> senderRecord(ProductMongo productMongo, String topic){
    return senderRecord(productMongo.getId(), productMongo, topic);
  }

  private static SenderRecord<String, ProductMongo, Long> senderRecord(String id, String topic){
    return senderRecord(id, null, topic);
  }

  public static SenderRecord<String, ProductMongo, Long> insertRecord(ProductMongo productMongo){
    return senderRecord(productMongo, TOPIC_INSERT);
  }

  public static SenderRecord<String, ProductMongo, Long> updateRecord(ProductMongo productMongo){
    return senderRecord(productMongo, TOPIC_UPDATE);
  }

  public static SenderRecord<String, ProductMongo, Long> deleteRecord(String id){
    return senderRecord(id, TOPIC_DELETE);
  }

}
