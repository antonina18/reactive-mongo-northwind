package sowa.domain.orders;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import sowa.common.DomainModel;
import sowa.domain.orders.customers.Customer;
import sowa.domain.orders.employees.Employee;
import sowa.domain.orders.shipper.Shipper;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "orders")
@TypeAlias("order")
public class Order extends DomainModel {

    public LocalDate orderDate;
    public LocalDate requiredDate;
    public LocalDate shippedDate;
    public Double freight;
    public String shipName;
    public String shipAddress;
    public String shipCity;
    public String shipRegion;
    public String shipPostalCode;
    public String shipCountry;

    @JsonSerialize(using = ToStringSerializer.class)
    public ObjectId customerId;
    @JsonSerialize(using = ToStringSerializer.class)
    public ObjectId employeeId;
    @JsonSerialize(using = ToStringSerializer.class)
    public ObjectId shipperId;

    public List<OrderDetail> orderDetails;

}
