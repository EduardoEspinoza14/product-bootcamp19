package com.nttdata.product.model.dto;

import com.nttdata.product.model.mongo.ProductMongo;
import lombok.Getter;
import lombok.Setter;

/**
 * Class SavingsAccount.
 */
@Setter
@Getter
public class SavingsAccount extends ProductMongo {

  private Integer maxMovementLimit;

  public SavingsAccount() {
    super(PRODUCT_TYPE_1);
  }

  @Override
  public String toString() {
    return "{id: " + getId()
            + ", start_date: " + getStartDate()
            + ", number: " + getNumber()
            + ", type: " + getType()
            + ", customerId: " + getCustomerId()
            + ", maxMovementLimit: " + getMaxMovementLimit()
            + "}";
  }

}
