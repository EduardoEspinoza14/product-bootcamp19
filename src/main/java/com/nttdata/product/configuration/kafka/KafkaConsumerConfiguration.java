package com.nttdata.product.configuration.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import reactor.core.publisher.Flux;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.receiver.ReceiverOptions;

import java.util.Collections;

/**
 * Class KafkaConsumerConfiguration.
 */
public abstract class KafkaConsumerConfiguration<K, V> {

  @Value(value = "${kafka.bootstrapAddress:}")
  public String bootstrapAddress;

  @Value(value = "${kafka.group-id:}")
  public String groupId;

  public static final String WALLET_TOPIC_INSERT = "wallet.insert";
  public static final String WALLET_TOPIC_UPDATE = "wallet.update";
  public static final String WALLET_TOPIC_DELETE = "wallet.delete";

  public abstract ReceiverOptions<K, V> receiverOptions();

  public ReceiverOptions<K, V> subscribeOptions(String topic) {
    return receiverOptions().subscription(Collections.singleton(topic));
  }

  public abstract void insertData();

  public abstract void updateData();

  public abstract void deleteData();

  /**
   * Method createReceiver.
   */
  public Flux<ConsumerRecord<K, V>> createReceiver(String topic) {
    return KafkaReceiver.create(subscribeOptions(topic))
            .receiveAutoAck()
            .concatMap(r -> r);
  }

}
