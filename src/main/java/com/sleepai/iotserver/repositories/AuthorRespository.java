package com.sleepai.iotserver.repositories;

import com.sleepai.iotserver.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRespository  extends MongoRepository<Author, String> {
}
