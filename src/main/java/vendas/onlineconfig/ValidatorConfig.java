package main.java.vendas.onlineconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

public class ValidatorConfig {

    @Configuration
    @EnableMongoRepositories(basePackages = "br.com.rpires.vendas.online.repository")
    public class MongoConfig {

    }
}
