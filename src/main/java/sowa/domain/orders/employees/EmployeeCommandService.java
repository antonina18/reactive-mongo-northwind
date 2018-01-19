package sowa.domain.orders.employees;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeCommandService {

    private final EmployeesRepository repository;

    public EmployeeCommandService(EmployeesRepository repository) {
        this.repository = repository;
    }

    protected Flux<Employee> insertAll(Flux<Employee> order) {
        return repository.insert(order);
    }

    protected Flux<Employee> insert(Mono<Employee> order) {
        return repository.insert(order);
    }

    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }
}
