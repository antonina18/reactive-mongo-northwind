package sowa.domain.orders;

import org.springframework.data.mongodb.core.mapping.Document;
import sowa.domain.Versioned;

import java.time.LocalDateTime;

@Document
public class Order extends Versioned {

    public String customerId;
    public Integer employeeId;
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
    
}
