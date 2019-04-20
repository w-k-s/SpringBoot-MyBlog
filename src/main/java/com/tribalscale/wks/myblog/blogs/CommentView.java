package com.tribalscale.wks.myblog.blogs;

import com.tribalscale.wks.myblog.data.blogs.Comment;
import org.springframework.lang.NonNull;
import org.springframework.util.Assert;

import java.time.format.DateTimeFormatter;

public class CommentView {

    private final long id;
    private final String author;
    private final String body;
    private final String createdDate;

    public CommentView(@NonNull Comment comment) {
        Assert.notNull(comment, "comment");

        this.id = comment.getId();
        this.author = comment.getAuthor();
        this.body = comment.getBody();
        this.createdDate = comment.getCreatedDate().format(DateTimeFormatter.ofPattern("dd MMMM yyyy"));
    }

    public long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getBody() {
        return body;
    }

    public String getCreatedDate() {
        return createdDate;
    }
}
