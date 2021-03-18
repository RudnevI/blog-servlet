package com.example.Collab.entity;

import java.util.Date;

public class Blog {

    private Long id;

    private String title;

    private String content;

    private Date creationDate;

    public Blog(Long id, String title, String content, Date creationDate) {
        this.id = id;
        this.title = title;
        this.content = content;
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

    public Date getCreationDate() {
        return creationDate;
    }
}
