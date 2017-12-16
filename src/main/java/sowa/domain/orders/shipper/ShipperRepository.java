package sowa.domain.orders.shipper;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ShipperRepository extends ReactiveMongoRepository<Shipper, String> {

}
