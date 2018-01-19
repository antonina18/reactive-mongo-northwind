package sowa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.reactive.config.EnableWebFlux;
import reactor.core.publisher.Mono;
import sowa.domain.orders.Order;
import sowa.domain.orders.OrderRepository;
import sowa.domain.orders.customers.Customer;
import sowa.domain.orders.customers.CustomerRepository;

//@EnableWebFlux
@SpringBootApplication
public class ApplicationStarter implements CommandLineRunner {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public static void main(String[] args) {
        new SpringApplicationBuilder(ApplicationStarter.class)
                .web(WebApplicationType.REACTIVE)
                .run(args);
    }

    @Override
    public void run(String args[]) {
//        Customer customer = new Customer();
//        customer.contactName = "customer test 1";
//        Mono<Customer> saveCustomerMono = customerRepository.save(customer);
//
//        saveCustomerMono.subscribe(c -> {
//            Order order = new Order();
//            order.customer = c;
//            Mono<Order> saveOrderMono = orderRepository.save(order);
//            saveOrderMono.subscribe(o -> System.out.println("order saved " + order))
//            ;
//        });


//        regionRepository.findByRegionDescription("Eastern").log().subscribe(System.out::println);
//        regionRepository.findById("2").log().subscribe(System.out::println);
//        territoryRepository.findByTerritoryID(2116).log().subscribe(System.out::println);
//
//        Region region = new Region("test test");
//        regionRepository.save(region).subscribe();
//        regionRepository.findByRegionDescription("test test").log().subscribe(System.out::println);
    }
}