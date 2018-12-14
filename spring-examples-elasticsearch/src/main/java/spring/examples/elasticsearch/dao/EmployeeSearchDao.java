package spring.examples.elasticsearch.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import spring.examples.elasticsearch.document.Employee;

public interface EmployeeSearchDao extends ElasticsearchCrudRepository<Employee, String> {
}
