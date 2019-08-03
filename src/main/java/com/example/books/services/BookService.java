package com.example.books.services;

import com.example.books.entities.Book;
import com.example.books.repositories.IBookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final IBookRepository bookRepository;

    public BookService(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }
}
