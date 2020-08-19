package spring.examples.resttemplate.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import spring.examples.resttemplate.domain.Author;

@Slf4j
@RestController
@RequestMapping("/author")
class AuthorController {

    @PostMapping
    public Author post(@RequestHeader MultiValueMap<String, String> headers, @RequestParam MultiValueMap<String, String> params, @RequestBody Author author) {
        log.debug("headers: {}", headers);
        log.debug("params: {}", params);
        log.debug("body: {}", author);
        return author;
    }

}
