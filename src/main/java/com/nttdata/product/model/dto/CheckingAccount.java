package com.nttdata.product.model.dto;

import com.nttdata.product.model.mongo.ProductMongo;
import lombok.Getter;
import lombok.Setter;

/**
 * Class CheckingAccount.
 */
@Setter
@Getter
public class CheckingAccount extends ProductMongo {

  private Double commissionAmount;

  public CheckingAccount() {
    super(PRODUCT_TYPE_2);
  }

  @Override
  public String toString() {
    return "{id: " + getId()
            + ", startDate: " + getStartDate()
            + ", type: " + getType()
            + ", customerId: " + getCustomerId()
            + ", commissionAmount: " + getCommissionAmount()
            + "}";
  }

}
