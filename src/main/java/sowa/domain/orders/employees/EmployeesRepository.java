package sowa.domain.orders.employees;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import sowa.domain.orders.customers.Customer;

public interface EmployeesRepository extends ReactiveMongoRepository<Employee, String> {

}
