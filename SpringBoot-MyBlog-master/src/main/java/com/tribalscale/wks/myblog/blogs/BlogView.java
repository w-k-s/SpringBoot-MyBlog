package com.tribalscale.wks.myblog.blogs;

import com.tribalscale.wks.myblog.data.blogs.Blog;
import org.springframework.lang.NonNull;
import org.springframework.util.Assert;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

@SuppressWarnings("unused")
public class BlogView {
    private final long id;
    private final String title;
    private final String slug;
    private final String preview;
    private final String author;
    private final String createdDate;

    private BlogView(){
        this.id = 0;
        this.title = "";
        this.slug = "";
        this.preview = "";
        this.author = "";
        this.createdDate = "";
    }

    BlogView(@NonNull Blog blog) {
        Assert.notNull(blog, "blog");
        this.id = blog.getId();
        this.title = blog.getTitle();
        this.slug = blog.getSlug();
        this.preview = blog.getPreview();
        this.author = blog.getAuthor();
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

    public String getPreview() {
        return preview;
    }

    public String getAuthor() {
        return author;
    }

    public String getCreatedDate() {
        return createdDate;
    }
}
