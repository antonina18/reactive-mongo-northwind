package sowa.domain.people.customers;

import org.springframework.data.mongodb.core.mapping.Document;
import sowa.domain.Versioned;

@Document
public class Customer extends Versioned {

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
