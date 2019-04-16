package com.tribalscale.wks.myblog.blogs.entities;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

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

    @Column(nullable = false, length = 140)
    @Length(min = 1, max = 140)
    @NotBlank
    @NotEmpty
    private final String slug;

    @Column(length = 256)
    @Length(min = 0, max = 256)
    private final String preview;

    @Column
    private final String body;

    @CreatedDate
    private final LocalDateTime createdDate;

    @LastModifiedDate
    private final LocalDateTime lastModifiedDate;

    private Blog() {
        this.id = 0;
        this.title = "";
        this.slug = "";
        this.preview = "";
        this.body = "";
        this.createdDate = LocalDateTime.now();
        this.lastModifiedDate = LocalDateTime.now();
    }

    public Blog(long id, String title, String slug, String preview, String body) {
        Assert.notNull(title, "title can not be null");
        Assert.notNull(title, "slug can not be null");

        this.id = id;
        this.title = title;
        this.slug = slug;
        this.preview = preview;
        this.body = body;
        this.createdDate = LocalDateTime.now();
        this.lastModifiedDate = LocalDateTime.now();
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

    public String getBody() {
        return body;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }
}
