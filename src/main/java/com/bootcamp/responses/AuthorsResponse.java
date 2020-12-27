package com.bootcamp.responses;

import com.bootcamp.models.Author;
import lombok.Data;

import java.util.List;

@Data
public class AuthorsResponse extends Response{
    private List<Author> authors;

    public AuthorsResponse(String msg, List<Author> authors) {
        super(msg);
        this.authors = authors;
    }
}
