package com.example.books.dto;

public class BookDto {
    private Long id;
    private String title;
    private String author;
    private long[] pageIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long[] getPageIds() {
        return pageIds;
    }

    public void setPageIds(long[] pageIds) {
        this.pageIds = pageIds;
    }
}
