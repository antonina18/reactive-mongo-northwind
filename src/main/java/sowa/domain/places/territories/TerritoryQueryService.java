package sowa.domain.places.territories;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public final class TerritoryQueryService {

    private final TerritoryRepository repository;

    public TerritoryQueryService(TerritoryRepository repository) {
        this.repository = repository;
    }

    protected Mono<Territory> findByID(Integer id) {
        return repository.findByTerritoryID(id);
    }

    protected Flux<Territory> findAll() {
        return repository.findAll();
    }
}
