package sowa.domain.suppliers;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "suppliers")
public class Supplier {

    public Integer supplierID;

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
    public String homePage;
    
}
