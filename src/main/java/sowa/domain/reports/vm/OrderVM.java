package sowa.domain.reports.vm;

import sowa.domain.reports.vm.details.CustomerVM;
import sowa.domain.reports.vm.details.EmployeeVM;
import sowa.domain.reports.vm.details.OrderDetailVM;
import sowa.domain.reports.vm.details.ShipperVM;

import java.time.LocalDate;
import java.util.List;

public class OrderVM {

    public String id;

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

    public CustomerVM customer;
    public EmployeeVM employee;
    public ShipperVM shipper;

    public List<OrderDetailVM> orderDetails;

}
