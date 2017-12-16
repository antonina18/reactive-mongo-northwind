package sowa.domain.places.regions;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public final class RegionQueryService {

    private final RegionRepository repository;

    public RegionQueryService(RegionRepository repository) {
        this.repository = repository;
    }

    protected Mono<Region> findByDescription(String description) {
        return repository.findByRegionDescription(description);
    }

    protected Flux<Region> findAll() {
        return repository.findAll();
    }
}
