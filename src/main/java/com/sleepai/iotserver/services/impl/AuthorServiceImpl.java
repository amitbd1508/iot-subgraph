package com.sleepai.iotserver.services.impl;

import com.sleepai.iotserver.model.Author;
import com.sleepai.iotserver.model.AuthorInput;
import com.sleepai.iotserver.repositories.AuthorRespository;
import com.sleepai.iotserver.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRespository authorRespository;

    @Override
    public List<Author> getAll() {
        return authorRespository.findAll();
    }

    @Override
    public Author insert(AuthorInput input) {
        Author author = new Author();
        author.setFirstName(input.getFirstName());
        author.setLastName(input.getLastName());

        return authorRespository.insert(author);
    }
}
