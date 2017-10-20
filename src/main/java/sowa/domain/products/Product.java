package sowa.domain.products;

import org.springframework.data.mongodb.core.mapping.Document;
import sowa.domain.Versioned;

@Document
public class Product extends Versioned {

    public String productName;
    public String quantityPerUnit;
    public Double unitPrice;
    public Short unitsInStock;
    public Short unitsOnOrder;
    public Short reorderLevel;
    public Boolean discontinued;

    // ID of corresponding Supplier Object
    public Integer supplierId;
    // Embedded Category Object (One-to-One relation)
    public Category category;

    //    public Integer categoryId;
}
