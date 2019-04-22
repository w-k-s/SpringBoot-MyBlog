package com.tribalscale.wks.myblog.blogs;

import com.tribalscale.wks.myblog.data.blogs.BlogService;
import com.tribalscale.wks.myblog.util.views.DataListView;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class BlogApiController {

    private BlogService blogService;

    public BlogApiController(final BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping(value = "/blogs", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DataListView<BlogPreview>> listAllBlogs() {
        final List<BlogPreview> previews = blogService
                .getAllBlogs()
                .stream()
                .map(BlogPreview::new)
                .collect(Collectors.toList());

        return ok(new DataListView<>(previews));
    }

    @GetMapping(value = "/blog/{blogId}/comments", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<DataListView<CommentView>>> listCommentsForBlog(@NonNull @PathVariable("blogId") Long blogId) throws Exception {

        return blogService
                .getComments(blogId)
                .map(it -> it.stream().map(CommentView::new).collect(Collectors.toList()))
                .map(DataListView::new)
                .map(ResponseEntity::ok);
    }
}
