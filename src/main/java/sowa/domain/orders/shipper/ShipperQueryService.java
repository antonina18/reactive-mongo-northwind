package sowa.domain.orders.shipper;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public final class ShipperQueryService {

    private final ShipperRepository repository;

    public ShipperQueryService(ShipperRepository repository) {
        this.repository = repository;
    }

    protected Mono<Shipper> findByID(String id) {
        return repository.findById(id);
    }

    protected Flux<Shipper> findAll() {
        return repository.findAll();
    }


}
