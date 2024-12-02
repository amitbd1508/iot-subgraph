package com.sleepai.iotserver.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//public record Author (String id, String firstName, String lastName) {
//
//    private static List<Author> authors = Arrays.asList(
//            new Author("author-1", "Joshua", "Bloch"),
//            new Author("author-2", "Douglas", "Adams"),
//            new Author("author-3", "Bill", "Bryson")
//    );
//
//    public static Author getById(String id) {
//        return authors.stream()
//				.filter(author -> author.id().equals(id))
//				.findFirst()
//				.orElse(null);
//    }
//}

@Data
@NoArgsConstructor
@Document("Author")
public class Author {

    @Id
    private String id;

    private String firstName;
    private String lastName;

    public Author(String id, String firstName, String lastName) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;


    }
}
