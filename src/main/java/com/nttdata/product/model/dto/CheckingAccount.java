package com.nttdata.product.model.dto;

import com.nttdata.product.model.mongo.ProductMongo;
import lombok.Getter;
import lombok.Setter;

//SE REFIERE A LAS CUENTAS CORRIENTES, UN PRODUCTO DEL BANCO
@Setter
@Getter
public class CheckingAccount extends ProductMongo implements Account {

    private Double commission_amount;

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
                ", customerId: " + getCustomerId() +
                ", commission_amount: " + getCommission_amount() +
                "}";
    }

}
