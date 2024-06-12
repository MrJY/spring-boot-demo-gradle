package mrjy.online.springboot.demo.controller;

import mrjy.online.springboot.demo.entity.CourseEntity;
import mrjy.online.springboot.demo.graphql.Author;
import mrjy.online.springboot.demo.graphql.Book;
import mrjy.online.springboot.demo.repository.CourseQuerydslRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BookController {

    @Resource
    private CourseQuerydslRepository courseQuerydslRepository;

    @QueryMapping
    public Book bookById(@Argument String id) {
        return Book.getById(id);
    }

    @SchemaMapping
    public Author author(Book book) {
        return Author.getById(book.authorId());
    }

    @GetMapping("/test")
    public void index() {

    }

}
