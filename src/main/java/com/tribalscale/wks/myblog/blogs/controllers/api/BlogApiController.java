package com.tribalscale.wks.myblog.blogs.controllers.api;

import com.tribalscale.wks.myblog.blogs.repositories.BlogRepository;
import com.tribalscale.wks.myblog.blogs.services.BlogService;
import com.tribalscale.wks.myblog.blogs.views.BlogListView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin("*")
public class BlogApiController {

    private BlogService blogService;

    public BlogApiController(final BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/blogs")
    public ResponseEntity<BlogListView> listAllBlogs() {
        return ResponseEntity.ok(new BlogListView(blogService.getAllBlogs()));
    }
}
