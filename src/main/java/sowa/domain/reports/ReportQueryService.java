package sowa.domain.reports;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sowa.domain.orders.Order;
import sowa.domain.orders.OrderDetail;
import sowa.domain.orders.OrderRepository;
import sowa.domain.orders.customers.Customer;
import sowa.domain.orders.customers.CustomerRepository;
import sowa.domain.orders.employees.Employee;
import sowa.domain.orders.employees.EmployeesRepository;
import sowa.domain.orders.shipper.Shipper;
import sowa.domain.orders.shipper.ShipperRepository;
import sowa.domain.products.*;
import sowa.domain.reports.vm.OrderVM;
import sowa.domain.reports.vm.ReportVM;
import sowa.domain.reports.vm.details.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public final class ReportQueryService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final EmployeesRepository employeesRepository;
    private final ShipperRepository shipperRepository;
    private final SupplierRepository supplierRepository;
    private final ProductRepository productRepository;

    public ReportQueryService(OrderRepository orderRepository, CustomerRepository customerRepository, EmployeesRepository employeesRepository, ShipperRepository shipperRepository, SupplierRepository supplierRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.employeesRepository = employeesRepository;
        this.shipperRepository = shipperRepository;
        this.supplierRepository = supplierRepository;
        this.productRepository = productRepository;
    }

    Mono<ReportVM> getReport(LocalDate orderDateFrom, LocalDate orderDateTo) {
        Flux<Order> orders = orderRepository
                .findAllByOrderDateBetween(orderDateFrom, orderDateTo);

        Flux<OrderVM> orderVMFlux = orders.map(this::mapToOrderVM);

        ReportVM reportVM = new ReportVM(orderDateFrom, orderDateTo, orderVMFlux);

        return Mono.just(reportVM);
    }

    // TODO: 19.01.2018 extract above methods private

    private OrderVM mapToOrderVM(Order order) {
        OrderVM orderVM = new OrderVM();
        orderVM.id = order._id.toString();
        orderVM.orderDate = order.orderDate;
        orderVM.requiredDate = order.requiredDate;
        orderVM.shippedDate = order.shippedDate;
        orderVM.freight = order.freight;
        orderVM.shipName = order.shipName;
        orderVM.shipAddress = order.shipAddress;
        orderVM.shipCity = order.shipCity;
        orderVM.shipRegion = order.shipRegion;
        orderVM.shipPostalCode = order.shipPostalCode;
        orderVM.shipCountry = order.shipCountry;

        Mono<Customer> customer = customerRepository.findById(order.customerId.toString());
        orderVM.customer = mapToCustomerVm(customer.block());
        Mono<Employee> employee = employeesRepository.findById(order.employeeId.toString());
        orderVM.employee = mapToEmployeeVM(employee.block());
        Mono<Shipper> shipper = shipperRepository.findById(order.shipperId.toString());
        orderVM.shipper = mapToShipperVm(shipper.block());
        orderVM.orderDetails = mapToOrderDetailVMs(order.orderDetails);

        return orderVM;
    }

    private List<OrderDetailVM> mapToOrderDetailVMs(List<OrderDetail> orderDetails) {
        return orderDetails.stream()
                .map(orderDetail -> {
                    OrderDetailVM orderDetailVM = new OrderDetailVM();
                    orderDetailVM.product = mapToProductVM(productRepository.findById(orderDetail.productId.toString()).block());
                    orderDetailVM.unitPrice = orderDetail.unitPrice;
                    orderDetailVM.quantity = orderDetail.quantity;
                    orderDetailVM.discount = orderDetail.discount;
                    return orderDetailVM;
                })
                .collect(Collectors.toList());
    }


    private CustomerVM mapToCustomerVm(Customer customer) {
        CustomerVM customerVM = new CustomerVM();
        customerVM.id = customer._id.toString();
        customerVM.companyName = customer.companyName;
        customerVM.contactName = customer.contactName;
        customerVM.contactTitle = customer.contactTitle;
        customerVM.address = customer.address;
        customerVM.city = customer.city;
        customerVM.region = customer.region;
        customerVM.postalCode = customer.postalCode;
        customerVM.country = customer.country;
        customerVM.phone = customer.phone;
        customerVM.fax = customer.fax;
        return customerVM;
    }

    private ProductVM mapToProductVM(Product product) {
        ProductVM productVM = new ProductVM();
        productVM.id = product._id.toString();
        productVM.productName = product.productName;
        productVM.quantityPerUnit = product.quantityPerUnit;
        productVM.unitPrice = product.unitPrice;
        productVM.unitsInStock = product.unitsInStock;
        productVM.unitsOnOrder = product.unitsOnOrder;
        productVM.reorderLevel = product.reorderLevel;
        productVM.discontinued = product.discontinued;
        productVM.supplier = mapToSupplierVM(supplierRepository.findById(product.supplierId.toString()).block());
        productVM.category =  mapToCategoryVM(product.category);
        return productVM;
    }

    private SupplierVM mapToSupplierVM(Supplier supplier) {
        SupplierVM supplierVM = new SupplierVM();
        supplierVM.id = supplier._id.toString();
        supplierVM.companyName = supplier.companyName;
        supplierVM.contactName = supplier.contactName;
        supplierVM.contactTitle = supplier.contactTitle;
        supplierVM.address = supplier.address;
        supplierVM.city = supplier.city;
        supplierVM.region = supplier.region;
        supplierVM.postalCode = supplier.postalCode;
        supplierVM.country = supplier.country;
        supplierVM.phone = supplier.phone;
        supplierVM.fax = supplier.fax;
        supplierVM.homePage = supplier.homePage;
        return supplierVM;
    }

    private CategoryVM mapToCategoryVM(Category category) {
        CategoryVM categoryVM = new CategoryVM();
        categoryVM.name = category.name;
        categoryVM.description = category.description;
        categoryVM.picture = category.picture;
        return categoryVM;
    }

    private EmployeeVM mapToEmployeeVM(Employee employee) {
        EmployeeVM employeeVM = new EmployeeVM();
        employeeVM.id = employee._id.toString();
        employeeVM.lastName = employee.lastName;
        employeeVM.firstName = employee.firstName;
        employeeVM.title = employee.title;
        employeeVM.titleOfCourtesy = employee.titleOfCourtesy;
        employeeVM.birthDate = employee.birthDate;
        employeeVM.hireDate = employee.hireDate;
        employeeVM.address = employee.address;
        employeeVM.city = employee.city;
        employeeVM.region = employee.region;
        employeeVM.postalCode = employee.postalCode;
        employeeVM.country = employee.country;
        employeeVM.homePhone = employee.homePhone;
        employeeVM.extension = employee.extension;
        employeeVM.photo = employee.photo;
        employeeVM.notes = employee.notes;
        employeeVM.reportsTo = employee.reportsTo;
        employeeVM.photoPath = employee.photoPath;
        return employeeVM;
    }

    private ShipperVM mapToShipperVm(Shipper shipper) {
        ShipperVM shipperVM = new ShipperVM();
        shipperVM.id = shipper._id.toString();
        shipperVM.companyName = shipper.companyName;
        shipperVM.phone = shipper.phone;
        return shipperVM;
    }


}
