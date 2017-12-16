package sowa.domain.people.customers;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customers")
public class Customer {

    @Id
    public Integer customerID;

    public String companyName;
    public String contactName;
    public String contactTitle;
    public String address;
    public String city;
    public String region;
    public String postalCode;
    public String country;
    public String phone;
    public String fax;

}
