package com.tribalscale.wks.myblog.blogs;

import com.tribalscale.wks.myblog.data.blogs.Blog;
import com.tribalscale.wks.myblog.data.blogs.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {

    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/blog/{id}")
    public ModelAndView getBlog(@PathVariable("id") long id) {
        Blog blog = blogService.getBlog(id);
        return new ModelAndView("blog_page", "blog", blog);
    }
}
