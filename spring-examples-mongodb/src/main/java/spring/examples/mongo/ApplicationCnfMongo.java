package spring.examples.mongo;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "spring.examples.mongo")
public class ApplicationCnfMongo {
}
