package com.sleepai.iotserver;

import com.sleepai.iotserver.model.Author;
import com.sleepai.iotserver.model.AuthorInput;
import com.sleepai.iotserver.model.Book;
import com.sleepai.iotserver.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {


    @Autowired
    private AuthorService authorService;

    @QueryMapping
    public Book bookById(@Argument String id) {
        return Book.getById(id);
    }

    @SchemaMapping
    public Author author(Book book) {
        return new Author();
    }

    @QueryMapping
    public List<Author> getAllAuthors() {
        return authorService.getAll();
    }

    @MutationMapping
    public Author addAuthor(@Argument("author") AuthorInput authorInput) {
        return this.authorService.insert(authorInput);
    }
}