package sowa.domain.products;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface SupplierRepository extends ReactiveMongoRepository<Supplier, String> {

    Flux<Supplier> findAllByCity(String search);

}
