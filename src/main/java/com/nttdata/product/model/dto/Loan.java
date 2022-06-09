package com.nttdata.product.model.dto;

import com.nttdata.product.model.mongo.ProductMongo;
import lombok.Getter;
import lombok.Setter;

//SE REFIERE AL PRODUCTO, PRESTAMO O CREDITO PERSONAL QUE PUEDEN TENER LOS CLIENTES, EXTIENDE DE LA CLASE PADRE PRODUCTO
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

    @Override
    public String toString(){
        return "{id: " + getId() +
                ", start_date: " + getStart_date() +
                ", type: " + getType() +
                ", customerId: " + getCustomerId() +
                ", credit_amount: " + getCredit_amount() +
                ", payment_day: " + getPayment_day() +
                "}";
    }

}
