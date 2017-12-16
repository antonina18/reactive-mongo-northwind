package sowa.domain.products;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

interface ProductRepository extends ReactiveMongoRepository<Product, String> {
    @Query("{'supplier.companyName': ?0}")
    Flux<Product> findAllBySupplierCountry(String search);
}
