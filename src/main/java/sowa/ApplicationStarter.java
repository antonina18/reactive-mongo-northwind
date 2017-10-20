package sowa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sowa.domain.people.regions.Region;
import sowa.domain.people.regions.RegionRepository;
import sowa.domain.people.regions.TerritoryRepository;

@SpringBootApplication
public class ApplicationStarter implements CommandLineRunner {

    @Autowired
    private TerritoryRepository territoryRepository;

    @Autowired
    private RegionRepository regionRepository;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationStarter.class, args);
    }

    @Override
    public void run(String args[]) {
        regionRepository.findByRegionDescription("Eastern").log().subscribe(System.out::println);
        regionRepository.findById("2").log().subscribe(System.out::println);
        territoryRepository.findByTerritoryID(2116).log().subscribe(System.out::println);

        Region region = new Region("test test");
        regionRepository.save(region).subscribe();
        regionRepository.findByRegionDescription("test test").log().subscribe(System.out::println);
    }
}