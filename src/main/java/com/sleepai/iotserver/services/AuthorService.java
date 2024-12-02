package com.sleepai.iotserver.services;

import com.sleepai.iotserver.model.Author;
import com.sleepai.iotserver.model.AuthorInput;

import java.util.List;

public interface AuthorService {
    List<Author> getAll();

    Author insert(AuthorInput author);
}
