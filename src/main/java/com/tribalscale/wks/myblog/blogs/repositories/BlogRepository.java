package com.tribalscale.wks.myblog.blogs.repositories;

import com.tribalscale.wks.myblog.blogs.entities.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long>{

}
