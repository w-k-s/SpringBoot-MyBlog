package com.tribalscale.wks.myblog.data.blogs;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
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

    public Mono<Collection<Comment>>  getComments(long blogId){
        return blogRepository.findById(blogId)
                .map(Blog::getComments)
                .map(Mono::just)
                .orElse(Mono.error(new NotFoundException(String.format("blog with id %d not found", blogId))));
    }
}