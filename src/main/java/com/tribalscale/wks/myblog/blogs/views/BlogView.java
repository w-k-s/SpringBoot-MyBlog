package com.tribalscale.wks.myblog.blogs.views;

import com.tribalscale.wks.myblog.blogs.entities.Blog;
import org.springframework.lang.NonNull;
import org.springframework.util.Assert;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class BlogView {
    private final long id;
    private final String title;
    private final String slug;
    private final String body;
    private final String createdDate;

    private BlogView(){
        this.id = 0;
        this.title = "";
        this.slug = "";
        this.body = "";
        this.createdDate = "";
    }

    public BlogView(@NonNull Blog blog) {
        Assert.notNull(blog, "blog");
        this.id = blog.getId();
        this.title = blog.getTitle();
        this.slug = blog.getSlug();
        this.body = blog.getBody();
        this.createdDate = blog.getCreatedDate().format(DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.UK));
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSlug() {
        return slug;
    }

    public String getBody() {
        return body;
    }

    public String getCreatedDate() {
        return createdDate;
    }
}
