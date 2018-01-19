package sowa.domain.orders.customers;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public final class CustomerQueryService {

    private final CustomerRepository repository;

    public CustomerQueryService(CustomerRepository repository) {
        this.repository = repository;
    }

    protected Mono<Customer> findByID(String id) {
        return repository.findById(id);
    }

    protected Flux<Customer> findAll() {
        return repository.findAll();
    }


}
