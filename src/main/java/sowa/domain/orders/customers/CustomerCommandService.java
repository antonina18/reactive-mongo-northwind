package sowa.domain.orders.customers;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerCommandService {

    private final CustomerRepository repository;

    public CustomerCommandService(CustomerRepository repository) {
        this.repository = repository;
    }

    protected Flux<Customer> insert(Mono<Customer> customer) {
        return repository.insert(customer);
    }

    protected Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }

    protected Mono<Customer> saveOrUpdate(Customer customer) {
        return repository.save(customer);
    }
}
