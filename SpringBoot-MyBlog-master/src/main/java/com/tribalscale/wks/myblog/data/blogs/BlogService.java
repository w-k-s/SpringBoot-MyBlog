package com.tribalscale.wks.myblog.data.blogs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.List;

@Service
public class BlogService {

    @Autowired
    private final BlogRepository blogRepository;

    public BlogService(@NonNull BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public List<Blog> getAllBlogs() {
        return this.blogRepository.findAll();
    }

    public Blog getBlog(long id) {
        return this.blogRepository.getOne(id);
    }

    public Mono<Collection<Comment>> getComments(long blogId) throws BlogNotFoundException {
        return blogRepository.findById(blogId)
                .map(Blog::getComments)
                .map(Mono::just)
                .orElse(Mono.error(new BlogNotFoundException(blogId)));
    }
}