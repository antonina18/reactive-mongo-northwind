package sowa.domain.orders;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sowa.domain.products.Supplier;

@Service
public final class OrderQueryService {

    private final OrderRepository repository;

    public OrderQueryService(OrderRepository repository) {
        this.repository = repository;
    }

    protected Mono<Order> findByID(String id) {
        return repository.findById(id);
    }

    protected Flux<Order> findAll() {
        return repository.findAll();
    }

    protected Flux<Order> findAllByShipName(String shipName) {
        return repository.findAllByShipName(shipName);
    }

}
