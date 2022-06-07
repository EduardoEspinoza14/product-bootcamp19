package com.nttdata.product.model.mongo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "products")
public abstract class ProductMongo {

    public static String PRODUCT_TYPE_1 = "Savings Account";

    @Id
    private String id;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date start_date;
    private String type;

}
