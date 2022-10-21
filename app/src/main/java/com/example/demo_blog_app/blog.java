package com.example.demo_blog_app;

public class blog {
    private String title,description,poster;
    public blog(String title, String description, String poster){
        this.title=title;
        this.description=description;
        this.poster=poster;
    }

    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }

    public String getPoster() {
        return poster;
    }
}
