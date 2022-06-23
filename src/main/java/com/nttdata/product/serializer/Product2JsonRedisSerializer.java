package com.nttdata.product.serializer;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nttdata.product.model.dto.Card;
import com.nttdata.product.model.dto.CheckingAccount;
import com.nttdata.product.model.dto.FixedTerm;
import com.nttdata.product.model.dto.Loan;
import com.nttdata.product.model.dto.SavingsAccount;
import com.nttdata.product.model.mongo.ProductMongo;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * Class Product2JsonRedisSerializer.
 */
public class Product2JsonRedisSerializer implements RedisSerializer<ProductMongo> {
  public static final Charset DEFAULT_CHARSET;

  static final byte[] EMPTY_ARRAY = new byte[0];

  static boolean isEmpty(byte[] data) {
    return data == null || data.length == 0;
  }

  private final ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public byte[] serialize(ProductMongo productMongo) throws SerializationException {
    if (productMongo == null) {
      return EMPTY_ARRAY;
    } else {
      try {
        return this.objectMapper.writeValueAsBytes(productMongo);
      } catch (Exception var3) {
        throw new SerializationException("Could not write JSON: "
                + var3.getMessage(), var3);
      }
    }
  }

  @Override
  public ProductMongo deserialize(byte[] bytes) throws SerializationException {
    if (isEmpty(bytes)) {
      return null;
    } else {
      try {
        JavaType type =  this.objectMapper.getTypeFactory().constructType(LinkedHashMap.class);
        LinkedHashMap<String, String> hashMap =
                this.objectMapper.readValue(bytes, 0, bytes.length, type);
        if (hashMap.get("type").equals(ProductMongo.PRODUCT_TYPE_1)) {
          type =  this.objectMapper.getTypeFactory().constructType(SavingsAccount.class);
        } else if (hashMap.get("type").equals(ProductMongo.PRODUCT_TYPE_2)) {
          type =  this.objectMapper.getTypeFactory().constructType(CheckingAccount.class);
        } else if (hashMap.get("type").equals(ProductMongo.PRODUCT_TYPE_3)) {
          type =  this.objectMapper.getTypeFactory().constructType(FixedTerm.class);
        } else if (hashMap.get("type").equals(ProductMongo.PRODUCT_TYPE_4)) {
          type =  this.objectMapper.getTypeFactory().constructType(Card.class);
        } else if (hashMap.get("type").equals(ProductMongo.PRODUCT_TYPE_5)) {
          type =  this.objectMapper.getTypeFactory().constructType(Loan.class);
        }
        return this.objectMapper.convertValue(hashMap, type);
      } catch (Exception var3) {
        throw new SerializationException("Could not read JSON: " + var3.getMessage(), var3);
      }
    }
  }

  static {
    DEFAULT_CHARSET = StandardCharsets.UTF_8;
  }

}
