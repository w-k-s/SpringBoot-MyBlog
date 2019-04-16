package com.tribalscale.wks.myblog.blogs.services;

import com.tribalscale.wks.myblog.blogs.entities.Blog;
import com.tribalscale.wks.myblog.blogs.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    @Autowired
    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public List<Blog> getAllBlogs() {
        return this.blogRepository.findAll();
    }

    public Blog getBlog(long id) {
        return this.blogRepository.getOne(id);
    }
}