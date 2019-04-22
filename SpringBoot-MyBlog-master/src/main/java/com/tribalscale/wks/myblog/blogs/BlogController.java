package com.tribalscale.wks.myblog.blogs;

import com.tribalscale.wks.myblog.data.blogs.Blog;
import com.tribalscale.wks.myblog.data.blogs.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {

    private final BlogService blogService;

    @Value("${myblog.config.bacgkground-color}")
    private String backgroundColor;

    @Value("${myblog.config.text-color}")
    private String textColor;

    @Autowired
    public BlogController(final BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping(value = "/blog/{id}", produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView getBlog(@PathVariable("id") long id) {
        Blog blog = blogService.getBlog(id);
        ModelAndView modelAndView = new ModelAndView("blog_page", "blog", blog);
        modelAndView.addObject("backgroundColor", backgroundColor);
        modelAndView.addObject("textColor", textColor);
        return modelAndView;
    }
}
