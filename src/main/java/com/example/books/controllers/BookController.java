package com.example.books.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @RequestMapping("/")
    public String GetBooks(){
        return "Hello book!!";
    }
}
