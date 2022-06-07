package com.nttdata.product.model.dto;

import com.nttdata.product.model.mongo.ProductMongo;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CheckingAccount extends ProductMongo implements Account {

    protected Double commission_amount;

    public CheckingAccount() {
        super(PRODUCT_TYPE_2);
    }

    @Override
    public Double calculateCommission() {
        return null;
    }

    @Override
    public Boolean canMakeMovement() {
        return null;
    }

    @Override
    public String toString(){
        return "{id: " + getId() +
                ", start_date: " + getStart_date() +
                ", type: " + getType() +
                ", commission_amount: " + getCommission_amount() +
                "}";
    }

}
