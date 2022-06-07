package com.nttdata.product.model.dto;

import com.nttdata.product.model.mongo.ProductMongo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SavingsAccount extends ProductMongo implements Account {

    protected Integer max_movement_limit;

    public SavingsAccount() {
        super(PRODUCT_TYPE_1);
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
                ", max_movement_limit: " + getMax_movement_limit() +
                "}";
    }

}
