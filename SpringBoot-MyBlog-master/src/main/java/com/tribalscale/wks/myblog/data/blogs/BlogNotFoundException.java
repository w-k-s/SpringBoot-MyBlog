package com.tribalscale.wks.myblog.data.blogs;

public class BlogNotFoundException extends Exception {
    public BlogNotFoundException(long blogId) {
        super(Long.valueOf(blogId).toString());
    }
}
