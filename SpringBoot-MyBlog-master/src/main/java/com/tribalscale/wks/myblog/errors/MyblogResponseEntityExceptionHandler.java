package com.tribalscale.wks.myblog.errors;

import com.tribalscale.wks.myblog.data.blogs.BlogNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class MyblogResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BlogNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleBlogNotFound(
            BlogNotFoundException ex) {

        ex.printStackTrace();
        System.err.println("BlogNotFoundException");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDetails(ex.getMessage()));
    }
}
