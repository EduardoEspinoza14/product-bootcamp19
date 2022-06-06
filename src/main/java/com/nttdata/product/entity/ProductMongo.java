package com.nttdata.product.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public abstract class ProductMongo {

    public static String PRODUCT_TYPE_1 = "Savings Account";

    @Id
    private Integer id;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date start_date;
    private final String type;

}
