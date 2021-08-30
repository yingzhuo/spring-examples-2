package spring.examples.graphql.controller;

import org.springframework.graphql.data.method.annotation.GraphQlController;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import spring.examples.graphql.domain.Author;

@GraphQlController
public class AuthorController {

    @QueryMapping(name = "findUniqueAuthor")
    public Author getAuthor() {
        return Author.builder()
                .id(1)
                .name("莫言")
                .build();
    }

}
