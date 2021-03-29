package com.example.Collab.entity;

import java.util.Date;

public class Blog {

    private Long id;

    private String title;

    private String content;

    private Long authorId;

    private String creationDate;

    public Long getAuthorId() {
        return authorId;
    }



    public Blog(Long id, String title, String content, Long authorId, String creationDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
        this.authorId = authorId;
    }

    public Blog(String title, String content, Long authorId, String creationDate) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getCreationDate() {
        return creationDate;
    }
}
