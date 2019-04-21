package com.tribalscale.wks.myblog.data.blogs;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.NonNull;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@EntityListeners({AuditingEntityListener.class})
@Table(name = "blogs")
public class Blog {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final long id;


    @Column(nullable = false, length = 140)
    @Length(min = 1, max = 140)
    @NotEmpty
    @NotBlank
    private final String title;

    @Column(name = "author", nullable = false)
    @NotEmpty
    @NotNull
    private final String author;

    @Column(nullable = false, length = 140)
    @Length(min = 1, max = 140)
    @NotBlank
    @NotEmpty
    private final String slug;

    @Column(length = 256)
    @Length(min = 0, max = 256)
    private final String preview;

    @Lob
    @Column(nullable = false)
    @NotEmpty
    private final String body;

    @OneToMany(mappedBy = "blog", fetch = FetchType.LAZY)
    private final List<Comment> comments;

    @CreatedDate
    private final LocalDateTime createdDate;

    @LastModifiedDate
    private final LocalDateTime lastModifiedDate;

    public Blog() {
        this.id = 0;
        this.title = "";
        this.author = "";
        this.slug = "";
        this.preview = "";
        this.body = "";
        this.comments = null;
        this.createdDate = LocalDateTime.now();
        this.lastModifiedDate = LocalDateTime.now();
    }

    public Blog(long id,
                @NonNull String title,
                @NotNull String author,
                @NonNull String slug,
                String preview,
                String body,
                List<Comment> comments) {
        Assert.notNull(title, "title");
        Assert.notNull(author, "author");
        Assert.notNull(slug, "slug");

        this.id = id;
        this.title = title;
        this.author = author;
        this.slug = slug;
        this.preview = preview;
        this.body = body;
        this.comments = comments;
        this.createdDate = LocalDateTime.now();
        this.lastModifiedDate = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getSlug() {
        return slug;
    }

    public String getPreview() {
        return preview;
    }

    public String getBody() {
        return body;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }
}
