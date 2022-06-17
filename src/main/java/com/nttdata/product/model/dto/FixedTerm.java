package com.nttdata.product.model.dto;

import com.nttdata.product.model.mongo.ProductMongo;
import lombok.Getter;
import lombok.Setter;

/**
 * Class FixedTerm.
 */
@Getter
@Setter
public class FixedTerm extends ProductMongo {

  private Integer singleDayMovement;

  public FixedTerm() {
    super(PRODUCT_TYPE_3);
  }

  @Override
  public String toString() {
    return "{id: " + getId()
            + ", startDate: " + getStartDate()
            + ", type: " + getType()
            + ", customerId: " + getCustomerId()
            + ", singleDayMovement: " + getSingleDayMovement()
            + "}";
  }

}
