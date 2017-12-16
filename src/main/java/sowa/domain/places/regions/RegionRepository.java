package sowa.domain.people.regions;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface RegionRepository extends ReactiveMongoRepository<Region, String> {

    Mono<Region> findByRegionDescription(String regionDescription);
}
