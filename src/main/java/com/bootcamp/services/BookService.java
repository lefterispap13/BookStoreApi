package com.bootcamp.services;

import com.bootcamp.models.Book;
import com.bootcamp.requests.NewBookRequest;

import java.util.List;

public interface BookService {
    List<Book> getAll();
    void createNewBook(NewBookRequest request);
}
