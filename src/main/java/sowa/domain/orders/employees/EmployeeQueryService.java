package sowa.domain.orders.employees;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public final class EmployeeQueryService {

    private final EmployeesRepository repository;

    public EmployeeQueryService(EmployeesRepository repository) {
        this.repository = repository;
    }

    protected Mono<Employee> findByID(String id) {
        return repository.findById(id);
    }

    protected Flux<Employee> findAll() {
        return repository.findAll();
    }


}
