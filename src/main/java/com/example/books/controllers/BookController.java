package com.example.books.controllers;

import com.example.books.dto.BookDto;
import com.example.books.entities.Book;
import com.example.books.services.BookService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;
    private final ModelMapper modelMapper;

    public BookController(BookService bookManager, ModelMapper modelMapper) {
        this.bookService = bookManager;
        this.modelMapper = modelMapper;
    }

    @GetMapping("")
    public List<BookDto> getAllBooks() {
        List<Book> books = bookService.getBooks();
        List<BookDto> bookDtos = modelMapper.map(books, new TypeToken<List<BookDto>>(){}.getType());
        return bookDtos;
    }

    @GetMapping("{id}")
    public BookDto getBookById(@PathVariable(value = "id") Long bookId) {
        Book book = bookService.getBook(bookId);
        BookDto bookDto = modelMapper.map(book, BookDto.class);
        return bookDto;
    }

}
