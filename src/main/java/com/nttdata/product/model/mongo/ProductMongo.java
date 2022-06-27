package com.nttdata.product.model.mongo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Class ProductMongo.
 */
@Data
@Document(collection = "products")
public class ProductMongo {

  public static String PRODUCT_TYPE_1 = "Savings Account";
  public static String PRODUCT_TYPE_2 = "Checking Account";
  public static String PRODUCT_TYPE_3 = "Fixed Term";
  public static String PRODUCT_TYPE_4 = "Card";
  public static String PRODUCT_TYPE_5 = "Loan";
  public static String PRODUCT_TYPE_6 = "Wallet";

  public ProductMongo(String type) {
    setType(type);
  }

  @Id
  private String id;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date startDate;
  private String number;
  private String type;
  private String customerId;

}
