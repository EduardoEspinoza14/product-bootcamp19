package com.nttdata.product.configuration.deserializer;

import com.nttdata.product.model.dto.Wallet;
import com.nttdata.product.model.mongo.ProductMongo;
import org.springframework.kafka.support.serializer.JsonDeserializer;

/**
 * Class JsonDeserializerProduct.
 */
public class JsonDeserializerProduct extends JsonDeserializer<Wallet> {

  /**
   * Constructor.
   */
  public JsonDeserializerProduct() {
    super();
    this.setRemoveTypeHeaders(false);
    this.addTrustedPackages("*");
    this.setUseTypeMapperForKey(true);
  }

}