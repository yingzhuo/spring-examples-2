package spring.examples.resttemplate;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import spring.examples.resttemplate.domain.Author;

import java.util.Collections;

@Slf4j
@SpringBootApplication
public class ApplicationBoot implements ApplicationRunner {

    private final RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        SpringApplication.run(ApplicationBoot.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/{path}")
                .queryParam("foo", "foo")
                .uriVariables(Collections.singletonMap("path", "author"));

        Author body = new Author("hello", "hello@foo.com");
        HttpEntity<Author> entity = new HttpEntity<>(body, headers);

        val response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, Author.class);

        log.debug("{}", response.getBody());
    }

}
