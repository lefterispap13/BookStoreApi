package com.bootcamp.requests;

import lombok.Data;

import java.util.List;

@Data
public class NewBookRequest {
    private String title;
    private List<Long> authorIds;

}
