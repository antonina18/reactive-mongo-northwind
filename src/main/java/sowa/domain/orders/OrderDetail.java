package sowa.domain.orders;

import org.springframework.data.mongodb.core.mapping.Document;
import sowa.common.DomainModel;

@Document(collection = "orderDetails")
public class OrderDetail extends DomainModel {

    public Integer orderDetailID;
    public Integer productId;
    public Double unitPrice;
    public Short quantity;
    public Double discount;
    
}
