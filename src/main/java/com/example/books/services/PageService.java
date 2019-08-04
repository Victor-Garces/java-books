package com.example.books.services;

import com.example.books.entities.Page;
import com.example.books.exceptions.ResourceNotFoundException;
import com.example.books.repositories.IPageRepository;
import org.springframework.stereotype.Service;

@Service
public class PageService {
    private final IPageRepository pageRepository;

    public PageService(IPageRepository pageRepository) {
        this.pageRepository = pageRepository;
    }

    public Page getPageById(Long id) {
        return pageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Page", "id", id));
    }
}
