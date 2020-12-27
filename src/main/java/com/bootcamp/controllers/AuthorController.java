package com.bootcamp.controllers;

import com.bootcamp.requests.NewAuthorRequest;
import com.bootcamp.responses.AuthorsResponse;
import com.bootcamp.responses.Response;
import com.bootcamp.services.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RequestMapping(value = "/author")
@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping(value = "/getall")
    public AuthorsResponse getAll(){
        log.info("Ready to find all the Authors");
        return new AuthorsResponse("Found all the Authors", authorService.getAll()) ;
    }

    @PostMapping(value = "/createauthor",consumes = "application/json",
            produces = "application/json")
    public Response createNewAuthor(@RequestBody NewAuthorRequest request){
        log.info("Ready create a new Author");
        authorService.createAuthor(request);
        return new Response("The author has been saved");
    }

}
