package com.example.books.controllers;

import com.example.books.dto.BookDto;
import com.example.books.dto.PageDto;
import com.example.books.entities.Book;
import com.example.books.entities.Page;
import com.example.books.services.PageService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/books")
public class PageController {

    private final PageService pageService;
    private final ModelMapper modelMapper;

    public PageController(PageService pageService, ModelMapper modelMapper) {
        this.pageService = pageService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("{id}/page/{pageId}")
    public PageDto getPageById(@PathVariable(value = "pageId") Long pageId) {
        Page page = pageService.getPageById(pageId);
        PageDto pageDto = modelMapper.map(page, PageDto.class);
        return pageDto;
    }

}
