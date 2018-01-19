package sowa.domain.orders.employees;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import sowa.common.DomainModel;

import java.time.LocalDate;

@Document(collection = "employees")
@TypeAlias("employee")
public class Employee extends DomainModel {

    public String lastName;
    public String firstName;
    public String title;
    public String titleOfCourtesy;
    public LocalDate birthDate;
    public LocalDate hireDate;
    public String address;
    public String city;
    public String region;
    public String postalCode;
    public String country;
    public String homePhone;
    public String extension;
    public byte[] photo;
    public String notes;
    public Integer reportsTo;
    public String photoPath;
    
}
