package com.tribalscale.wks.myblog.data.blogs;

public class BlogNotFoundException extends Exception {
    BlogNotFoundException(long blogId) {
        super(String.format("Blog '%d' does not exist", blogId));
    }
}
