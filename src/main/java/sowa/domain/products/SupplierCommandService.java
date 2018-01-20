package sowa.domain.products;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SupplierCommandService {

    private final SupplierRepository repository;

    public SupplierCommandService(SupplierRepository repository) {
        this.repository = repository;
    }

    protected Flux<Supplier> insert(Mono<Supplier> supplier) {
        return repository.insert(supplier);
    }

    protected Mono<Supplier> saveOrUpdate(Supplier supplier) {
        return repository.save(supplier);
    }

    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }
}
