package com.example.books.controllers;

import com.example.books.dto.BookDto;
import com.example.books.entities.Book;
import com.example.books.services.BookService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookManager;
    private final ModelMapper modelMapper;

    public BookController(BookService bookManager, ModelMapper modelMapper) {
        this.bookManager = bookManager;
        this.modelMapper = modelMapper;
    }

    @GetMapping("")
    public List<BookDto> getAllBooks() {
        List<Book> books = bookManager.getBooks();
        List<BookDto> bookDtos = modelMapper.map(books, new TypeToken<List<BookDto>>(){}.getType());
        return bookDtos;
    }

}
