package com.example.backend_blog.post;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository  extends JpaRepository<Post, Long>{

}
