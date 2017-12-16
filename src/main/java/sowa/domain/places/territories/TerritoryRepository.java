package sowa.domain.people.regions;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface TerritoryRepository extends ReactiveMongoRepository<Territory, Integer> {

    Mono<Territory> findByTerritoryID(Integer id);
}
