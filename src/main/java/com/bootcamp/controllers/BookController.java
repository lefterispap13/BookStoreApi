package com.bootcamp.controllers;

import com.bootcamp.requests.NewBookRequest;
import com.bootcamp.responses.Response;
import com.bootcamp.services.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RequestMapping(value = "/books")
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping(value = "/newbook", consumes = "application/json", produces = "application/json")
    public Response createNewBook(@RequestBody NewBookRequest request){
        log.info("Ready to insert the new book");
        bookService.createNewBook(request);
        return new Response("The book has been inserted");
    }
}
