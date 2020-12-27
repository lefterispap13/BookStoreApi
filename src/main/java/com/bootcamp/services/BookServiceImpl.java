package com.bootcamp.services;

import com.bootcamp.models.Author;
import com.bootcamp.models.Book;
import com.bootcamp.repository.AuthorRepository;
import com.bootcamp.repository.BookRepository;
import com.bootcamp.requests.NewBookRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j(topic ="BookServiceImpl" )
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;


    @Override
    public List<Book> getAll() {
        return null;
    }

    @Override
    public void createNewBook(NewBookRequest request) {
        log.info("Ready to create a new Book");

        //Find the Authors and add them to a list
        List<Long> authorIds = request.getAuthorIds();
        Set<Author> authorsSet = new HashSet<>();
        log.info("Ready to find all the authors");
        for(Long current :authorIds){
           Author author = authorRepository.findById(current).orElse(null);
            log.info("The author is {}", author);
            authorsSet.add(author);
        }
        log.info("Ready to save the new Book");
        Book book = new Book(request.getTitle(),authorsSet);
        bookRepository.save(book);
        log.info("Saves successufully");
    }
}
