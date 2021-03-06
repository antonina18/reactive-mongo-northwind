package sowa.domain.orders.shipper;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ShipperCommandService {

    private final ShipperRepository repository;

    public ShipperCommandService(ShipperRepository repository) {
        this.repository = repository;
    }

    protected Flux<Shipper> insert(Mono<Shipper> shipper) {
        return repository.insert(shipper);
    }

    protected Mono<Shipper> saveOrUpdate(Shipper shipper) {
        return repository.save(shipper);
    }

    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }
}
