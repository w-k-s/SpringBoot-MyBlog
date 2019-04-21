package com.tribalscale.wks.myblog.blogs.controllers.api;

import com.tribalscale.wks.myblog.blogs.BlogApiController;
import com.tribalscale.wks.myblog.data.blogs.Blog;
import com.tribalscale.wks.myblog.data.blogs.BlogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BlogApiController.class) // only loads the web layer
@AutoConfigureMockMvc
public class WebMvcRequestTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BlogService blogService;

    @Test
    public void blogsApiShouldReturnMockBlogsList() throws Exception {
        final List<Blog> blogs = Arrays.asList(
                new Blog(
                        0,
                        "10 Reasons to eat fish",
                        "Joe",
                        "ten_reasons_to_eat_fish",
                        "Number 3 will surprise you",
                        "1. It contains fish.",
                        null
                )
        );

        when(blogService.getAllBlogs()).thenReturn(blogs);

        final String password = NoOpPasswordEncoder.getInstance().encode("password");
        mockMvc.perform(get("/api/blogs")
                .with(user("waqqas").password(password)))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Number 3 will surprise you")));
    }
}
