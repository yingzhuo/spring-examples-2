package spring.examples.elasticsearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import spring.examples.elasticsearch.dao.EmployeeSearchDao;
import spring.examples.elasticsearch.document.Employee;

@EnableElasticsearchRepositories(basePackages = "spring.examples")
@Configuration
public class ApplicationCnfES implements ApplicationRunner {

    @Autowired
    private EmployeeSearchDao dao;

    @Override
    public void run(ApplicationArguments args) {
        dao.save(new Employee("1", "应卓", 36));
    }

}
