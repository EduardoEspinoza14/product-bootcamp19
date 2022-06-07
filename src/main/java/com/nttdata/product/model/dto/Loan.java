package com.nttdata.product.model.dto;

import com.nttdata.product.model.mongo.ProductMongo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Loan extends ProductMongo implements Credit {

    private Double credit_amount;
    private Integer payment_day;

    public Loan() {
        super(PRODUCT_TYPE_5);
    }

    @Override
    public Double calculateFee() {
        return null;
    }
}
