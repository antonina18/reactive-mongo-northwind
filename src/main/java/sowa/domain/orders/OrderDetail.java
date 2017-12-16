package sowa.domain.orders;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orderDetails")
public class OrderDetail {

    public Integer productId;
    public Double unitPrice;
    public Short quantity;
    public Double discount;
    
}
