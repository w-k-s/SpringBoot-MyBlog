package com.tribalscale.wks.myblog.blogs;

import com.tribalscale.wks.myblog.data.blogs.BlogService;
import com.tribalscale.wks.myblog.util.views.DataListView;
import javassist.NotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin("*")
public class BlogApiController {

    private BlogService blogService;

    public BlogApiController(final BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/blogs")
    public ResponseEntity<DataListView<BlogPreview>> listAllBlogs() {
        final List<BlogPreview> previews = blogService
                .getAllBlogs()
                .stream()
                .map(BlogPreview::new)
                .collect(Collectors.toList());

        return ok(new DataListView<>(previews));
    }

    @GetMapping("/blog/{blogId}/comments")
    public ResponseEntity<DataListView<CommentView>> listCommentsForBlog(@NonNull @PathVariable("blogId") Long blogId) throws Exception {

        final List<CommentView> commentViews = blogService
                .getComments(blogId)
                .stream()
                .map(CommentView::new)
                .collect(Collectors.toList());

        return ok(new DataListView<>(commentViews));
    }
}
