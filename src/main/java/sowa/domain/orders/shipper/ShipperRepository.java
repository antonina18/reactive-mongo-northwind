package sowa.domain.orders.shipper;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ShipperRepository extends ReactiveMongoRepository<Shipper, String> {

}
