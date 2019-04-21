package com.tribalscale.wks.myblog.context;

import com.tribalscale.wks.myblog.blogs.BlogApiController;
import com.tribalscale.wks.myblog.blogs.BlogController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles(profiles = "test")
public class MyblogApplicationTests {

    @Autowired
    BlogApiController blogApiController;

    @Autowired
    BlogController blogController;

    @Test
    public void contextLoads() {
        assertThat(blogController).isNotNull();
        assertThat(blogApiController).isNotNull();
    }

}
