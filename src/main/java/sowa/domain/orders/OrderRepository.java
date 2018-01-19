package sowa.domain.orders;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import sowa.domain.products.Supplier;

public interface OrderRepository extends ReactiveMongoRepository<Order, String> {

    Flux<Order> findAllByShipName(String search);

}
