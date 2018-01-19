package sowa.domain.orders.customers;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import sowa.common.DomainModel;

@Document(collection = "customers")
@TypeAlias("customer")
public class Customer extends DomainModel {

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

    @Override
    public String toString() {
        return "Customer{" +
                "companyName='" + companyName + '\'' +
                ", contactName='" + contactName + '\'' +
                ", contactTitle='" + contactTitle + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", phone='" + phone + '\'' +
                ", fax='" + fax + '\'' +
                "} " + super.toString();
    }
}
