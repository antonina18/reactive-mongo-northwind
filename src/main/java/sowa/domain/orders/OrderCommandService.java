package sowa.domain.orders;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderCommandService {

    private final OrderRepository repository;

    public OrderCommandService(OrderRepository repository) {
        this.repository = repository;
    }

    protected Flux<Order> insert(Mono<Order> order) {
        return repository.insert(order);
    }

    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }

    public Mono<Order> saveOrUpdate(Order order) {
        return repository.save(order);
    }
}
