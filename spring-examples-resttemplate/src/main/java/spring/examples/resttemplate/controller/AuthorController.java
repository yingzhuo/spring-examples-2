package spring.examples.resttemplate.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.examples.resttemplate.domain.Author;

@RestController
@RequestMapping("/author")
class AuthorController {

    private static final Author AUTHOR = new Author("应卓", "yingzhor@gmail.com");

    @PostMapping
    public Author post() {
        return AUTHOR;
    }

}
