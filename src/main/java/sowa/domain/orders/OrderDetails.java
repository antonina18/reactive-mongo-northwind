package sowa.domain.orders;

import org.springframework.data.mongodb.core.mapping.Document;
import sowa.domain.Versioned;

@Document
public class OrderDetails extends Versioned {

    public Integer productId;
    public Double unitPrice;
    public Short quantity;
    public Double discount;
    
}
