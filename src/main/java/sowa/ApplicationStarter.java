package sowa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ApplicationStarter {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ApplicationStarter.class)
                .web(WebApplicationType.REACTIVE)
                .run(args);
    }

}