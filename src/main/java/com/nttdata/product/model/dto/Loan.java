package com.nttdata.product.model.dto;

import com.nttdata.product.model.mongo.ProductMongo;
import lombok.Getter;
import lombok.Setter;

/**
 * Class Loan.
 */
@Getter
@Setter
public class Loan extends ProductMongo {

  private Double creditAmount;
  private Integer paymentDay;

  public Loan() {
    super(PRODUCT_TYPE_5);
  }

  @Override
  public String toString() {
    return "{id: " + getId()
            + ", startDate: " + getStartDate()
            + ", number: " + getNumber()
            + ", type: " + getType()
            + ", customerId: " + getCustomerId()
            + ", creditAmount: " + getCreditAmount()
            + ", paymentDay: " + getPaymentDay()
            + "}";
  }

}
