package com.example.books.controllers;

import com.example.books.dto.BookDto;
import com.example.books.dto.PageDto;
import com.example.books.entities.Book;
import com.example.books.entities.Page;
import com.example.books.enums.PageFormat;
import com.example.books.services.BookService;
import com.example.books.services.PageService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;
    private final PageService pageService;
    private final ModelMapper modelMapper;

    public BookController(BookService bookManager, PageService pageService, ModelMapper modelMapper) {
        this.bookService = bookManager;
        this.pageService = pageService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("")
    public Set<BookDto> getAllBooks() {
        List<Book> books = bookService.getBooks();
        Set<BookDto> bookDtos = new HashSet<>();

        for (Book book: books) {
            BookDto bookDto = modelMapper.map(book, BookDto.class);
            long[] pageIds = getPageIds(book);
            bookDto.setPageIds(pageIds);
            bookDtos.add(bookDto);
        }

        return bookDtos;
    }

    @GetMapping("{id}")
    public BookDto getBookById(@PathVariable(value = "id") Long bookId) {
        Book book = bookService.getBook(bookId);
        BookDto bookDto = modelMapper.map(book, BookDto.class);
        long[] pageIds = getPageIds(book);
        bookDto.setPageIds(pageIds);

        return bookDto;
    }

    private long[] getPageIds(Book book) {
        return book.getPages().stream().mapToLong(Page::getId).toArray();
    }

    @GetMapping("{id}/pages/{pageId}")
    public PageDto getPageById(@PathVariable(value = "pageId") Long pageId, @RequestParam(name = "format", required = false) String format) {
        Page page = pageService.getPageById(pageId);
        PageDto pageDto = modelMapper.map(page, PageDto.class);

        if(Objects.equals(PageFormat.html.toString(), format)) {
            String html = getPageHtmlFormat(pageDto.getContent());
            pageDto.setContent(html);
        }

        return pageDto;
    }

    private String getPageHtmlFormat(String content) {
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<html><head></head><body>");
        String[] paragrahps = content.split("([\\r\\n])");
        for (String paragrahp: paragrahps) {
            if(!paragrahp.equals("")){
                htmlBuilder.append("<p>").append(paragrahp).append("</p>");
            }
        }
        htmlBuilder.append("</body></html>");

        return htmlBuilder.toString();
    }

}
