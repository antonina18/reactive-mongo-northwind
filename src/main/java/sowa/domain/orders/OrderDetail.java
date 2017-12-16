package sowa.domain.orders;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orderDetails")
public class OrderDetail {

    @Id
    public Integer orderDetailID;
    public Integer productId;
    public Double unitPrice;
    public Short quantity;
    public Double discount;
    
}
