package com.tribalscale.wks.myblog.data.blogs;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final long id;

    @Column(nullable = false)
    @NotBlank
    @NotEmpty
    private final String author;

    @Column
    @CreatedDate
    private LocalDateTime createdDate;

    @Column(nullable = false)
    @Lob
    @NotBlank
    @NotEmpty
    private final String body;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "blog_id", nullable = false)
    private final Blog blog;

    private Comment() {
        this.id = 0;
        this.author = "";
        this.createdDate = LocalDateTime.now();
        this.body = "";
        this.blog = null;
    }

    public Comment(long id, @NonNull String author, @NonNull String body, @NonNull Blog blog) {
        this.id = id;
        this.author = author;
        this.body = body;
        this.blog = blog;
    }

    public long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public String getBody() {
        return body;
    }

    public Blog getBlog() {
        return blog;
    }
}
