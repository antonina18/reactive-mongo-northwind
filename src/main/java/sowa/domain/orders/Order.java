package sowa.domain.orders;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import sowa.common.DomainModel;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "orders")
public class Order extends DomainModel{

    public LocalDateTime orderDate;
    public LocalDateTime requiredDate;
    public LocalDateTime shippedDate;
    public Integer shipVia;
    public Double freight;
    public String shipName;
    public String shipAddress;
    public String shipCity;
    public String shipRegion;
    public String shipPostalCode;
    public String shipCountry;

    public String customerID;
    public String employeeID;
    public String shipperID;

    @DBRef
    public List<OrderDetail> orderDetails;
    
}
