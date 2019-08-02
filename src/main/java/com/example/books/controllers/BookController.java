package com.example.books.controllers;

import com.example.books.models.Book;
import com.example.books.repositories.BookRepository;
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
    BookRepository bookRepository;

    @GetMapping("/book")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
