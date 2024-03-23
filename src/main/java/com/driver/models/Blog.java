package com.driver.models;

import java.util.Date;

public class Blog {
    private int blogId;
    private String title;
    private String content;
    private Date pubDate;
    private User user; // Assuming you have a User class

    // Constructors
    public Blog() {
    }

    public Blog(int blogId, String title, String content, Date pubDate, User user) {
        this.blogId = blogId;
        this.title = title;
        this.content = content;
        this.pubDate = pubDate;
        this.user = user;
    }

    // Getters and Setters
    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // Additional methods
    public void deleteBlogById(int blogId) {
        // Your implementation to delete a blog by its ID
    }

    public void removeImage(Image image) {
    }
}
