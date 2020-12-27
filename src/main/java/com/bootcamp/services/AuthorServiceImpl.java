package com.bootcamp.services;

import com.bootcamp.models.Author;
import com.bootcamp.repository.AuthorRepository;
import com.bootcamp.requests.NewAuthorRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j(topic = "AuthorServiceImpl")
@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> getAll() {
        log.info("Ready to get all the Authors");
        return authorRepository.findAll();
    }

    @Override
    public boolean createAuthor(NewAuthorRequest request) {
        log.info("Ready to insert a new  Author. The request is {}", request);
        Author author = new Author(request.getFirstName(), request.getLastName());
        Author newAuthor = authorRepository.save(author);
        log.info("The new author is {}", newAuthor);
        log.info("The author has been inserted to the DB");
        return true;
    }

    @Override
    public Author getById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
