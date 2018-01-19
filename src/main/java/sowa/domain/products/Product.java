package sowa.domain.products;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import sowa.common.DomainModel;

@Document(collection = "products")
@TypeAlias("product")
public class Product extends DomainModel {

    public String productName;
    public String quantityPerUnit;
    public Double unitPrice;
    public Short unitsInStock;
    public Short unitsOnOrder;
    public Short reorderLevel;
    public Boolean discontinued;

    // ID of corresponding Supplier Object
    public ObjectId supplierId;
    // Embedded Category Object (One-to-One relation)
    public Category category;
}
