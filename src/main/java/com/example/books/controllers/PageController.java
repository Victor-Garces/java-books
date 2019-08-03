package com.example.books.controllers;

import com.example.books.dto.PageDto;
import com.example.books.entities.Page;
import com.example.books.enums.PageFormat;
import com.example.books.services.PageService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

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
