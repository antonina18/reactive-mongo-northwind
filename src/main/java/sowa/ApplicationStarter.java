package sowa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ApplicationStarter implements CommandLineRunner {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ApplicationStarter.class)
                .web(WebApplicationType.REACTIVE)
                .run(args);
    }

    @Override
    public void run(String args[]) {
//        regionRepository.findByRegionDescription("Eastern").log().subscribe(System.out::println);
//        regionRepository.findById("2").log().subscribe(System.out::println);
//        territoryRepository.findByTerritoryID(2116).log().subscribe(System.out::println);
//
//        Region region = new Region("test test");
//        regionRepository.save(region).subscribe();
//        regionRepository.findByRegionDescription("test test").log().subscribe(System.out::println);
    }
}