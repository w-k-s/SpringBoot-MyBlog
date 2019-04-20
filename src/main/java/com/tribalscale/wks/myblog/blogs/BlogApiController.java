package com.tribalscale.wks.myblog.blogs;

import com.tribalscale.wks.myblog.data.blogs.BlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.ok;

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
        return ok(new BlogListView(blogService.getAllBlogs()));
    }

    @GetMapping("/blog/{blogId}/comments")
    public Mono<ServerResponse> listCommentsForBlog(@NonNull @PathVariable("blogId") Long blogId) {
        return blogService
                .getComments(blogId)
                .flatMapIterable(comments -> comments.stream().map(CommentView::new).collect(Collectors.toList()))
                .collectList()
                .flatMap(result -> ServerResponse.ok().syncBody(result))
                .onErrorResume(e -> ServerResponse.badRequest().build());
    }
}
