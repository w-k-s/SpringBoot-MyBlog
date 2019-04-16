package com.tribalscale.wks.myblog.requests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc // Only loads application context
public class MockMvcRequestTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void blogsApiShouldReturnBlogsList() throws Exception {
        final String password = NoOpPasswordEncoder.getInstance().encode("password");

        mockMvc.perform(get("/api/blogs")
                .with(user("waqqas").password(password)))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("data")));
    }
}
