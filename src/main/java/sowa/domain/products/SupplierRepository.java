package sowa.domain.products;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface SupplierRepository extends ReactiveMongoRepository<Supplier, String> {
}
