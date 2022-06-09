package com.nttdata.product.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nttdata.product.model.mongo.ProductMongo;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

//SE REFIERE AL PRODUCTO, CUENTA A PLAZO FIJO, UN TIPO DE CUENTA DEL BANCO
@Getter
@Setter
public class FixedTerm extends ProductMongo implements Account {

    private Integer single_day_movement;

    public FixedTerm() {
        super(PRODUCT_TYPE_3);
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
                ", single_day_movement: " + getSingle_day_movement() +
                "}";
    }

}
