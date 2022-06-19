package com.nttdata.product.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nttdata.product.model.mongo.ProductMongo;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * Class Card.
 */
@Getter
@Setter
public class Card extends ProductMongo {

  private Double creditLimit;
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date expirationDate;
  private String securityCode;

  public Card() {
    super(PRODUCT_TYPE_4);
  }

  @Override
  public String toString() {
    return "{id: " + getId()
            + ", startDate: " + getStartDate()
            + ", number: " + getNumber()
            + ", type: " + getType()
            + ", customerId: " + getCustomerId()
            + ", creditLimit: " + getCreditLimit()
            + ", expirationDate: " + getExpirationDate()
            + ", securityCode: " + getSecurityCode()
            + "}";
  }

}
