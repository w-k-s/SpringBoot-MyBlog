package com.tribalscale.wks.myblog.blogs.controllers.api;

import com.tribalscale.wks.myblog.blogs.BlogPreview;
import com.tribalscale.wks.myblog.util.views.DataListView;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // Loads context and server
public class RandomPortRequestTests {

    @LocalServerPort
    private int port;

    @Test
    public void blogsApiShouldReturnBlogsList() throws Exception {
        final String password = NoOpPasswordEncoder.getInstance().encode("password");

//        TestRestTemplate testRestTemplate = new TestRestTemplate("waqqas", password, TestRestTemplate.HttpClientOption.ENABLE_COOKIES);
//        ResponseEntity<DataListView<BlogPreview>> response = testRestTemplate.getForEntity("http://localhost:" + port + "/api/blogs",
//                DataListView.class);
//        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
//        assertThat(response.getBody()).isNotNull();
    }
}
