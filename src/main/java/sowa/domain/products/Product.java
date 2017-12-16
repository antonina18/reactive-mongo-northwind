package sowa.domain.products;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import sowa.common.DomainModel;

@Document(collection = "products")
public class Product extends DomainModel {

    public String productName;
    public String quantityPerUnit;
    public Double unitPrice;
    public Short unitsInStock;
    public Short unitsOnOrder;
    public Short reorderLevel;
    public Boolean discontinued;

    // ID of corresponding Supplier Object
    public String supplierId;
    // Embedded Category Object (One-to-One relation)
    @DBRef
    public Category category;
}
