package com.example.books.controllers;

import com.example.books.entities.Book;
import com.example.books.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    BookService bookManager;

    @GetMapping("/book")
    public List<Book> getAllBooks() {
        return bookManager.getBooks();
    }

}
