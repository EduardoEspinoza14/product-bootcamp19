package com.nttdata.product.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nttdata.product.model.mongo.ProductMongo;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Card extends ProductMongo implements Credit {

    private Double credit_limit;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date expiration_date;
    private String security_code;

    public Card() {
        super(PRODUCT_TYPE_4);
    }

    @Override
    public Double calculateFee() {
        return null;
    }

    @Override
    public String toString(){
        return "{id: " + getId() +
                ", start_date: " + getStart_date() +
                ", type: " + getType() +
                ", customerId: " + getCustomerId() +
                ", credit_limit: " + getCredit_limit() +
                ", expiration_date: " + getExpiration_date() +
                ", security_code: " + getSecurity_code() +
                "}";
    }

}
