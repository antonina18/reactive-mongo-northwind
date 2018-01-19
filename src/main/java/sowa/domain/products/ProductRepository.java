package sowa.domain.products;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
    @Query("{'supplierId': ?0}")
    Flux<Product> findAllBySupplierCountry(String supplierCountry);
}
