package com.tribalscale.wks.myblog.blogs.views;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tribalscale.wks.myblog.blogs.entities.Blog;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class BlogListView {

    @JsonProperty(value = "data")
    private final Collection<BlogView> blogViews;

    private BlogListView(){
        this.blogViews = Collections.emptyList();
    }

    public BlogListView(Collection<Blog> blogs) {
        this.blogViews = blogs == null ? Collections.emptyList() : blogs.stream().map(BlogView::new).collect(Collectors.toList());
    }

    public Collection<BlogView> getBlogViews() {
        return blogViews;
    }
}
