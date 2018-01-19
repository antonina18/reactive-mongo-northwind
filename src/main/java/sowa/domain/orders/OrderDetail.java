package sowa.domain.orders;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.bson.types.ObjectId;

public class OrderDetail {

    @JsonSerialize(using = ToStringSerializer.class)
    public ObjectId productId;
    public Double unitPrice;
    public Short quantity;
    public Double discount;
    
}
