package com.bootcamp.services;

import com.bootcamp.models.Author;
import com.bootcamp.requests.NewAuthorRequest;
import jdk.internal.dynalink.linker.LinkerServices;

import java.util.List;

public interface AuthorService {

    List<Author> getAll();
    boolean createAuthor(NewAuthorRequest request);
    Author getById(Long id);
    void deleteById(Long id);
}
