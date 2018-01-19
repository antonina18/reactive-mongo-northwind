package sowa.configuration;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import javax.annotation.Resource;

@Configuration
@EnableReactiveMongoRepositories(basePackages = "sowa.domain")
public class MongoConfig extends AbstractReactiveMongoConfiguration {

    @Value("${spring.data.mongodb.host}")
    private String mongoHost;

    @Value("${spring.data.mongodb.port}")
    private String mongoPort;

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb://" + mongoHost + ":" + mongoPort);
    }

    @Override
    protected String getDatabaseName() {
        return "test";
    }

    @Override
    public MongoClient reactiveMongoClient() {
        return MongoClients.create("mongodb://" + mongoHost + ":" + mongoPort);
    }

    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate() {
        return new ReactiveMongoTemplate(mongoClient(), getDatabaseName());
    }
}