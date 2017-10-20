package sowa.domain.people.employees;

import org.springframework.data.mongodb.core.mapping.Document;
import sowa.domain.Versioned;

import java.time.LocalDateTime;

@Document
public class Employee extends Versioned {

    public String lastName;
    public String firstName;
    public String title;
    public String titleOfCourtesy;
    public LocalDateTime birthDate;
    public LocalDateTime hireDate;
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
