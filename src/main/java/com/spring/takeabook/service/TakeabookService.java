package com.spring.takeabook.service;

import com.spring.takeabook.model.Post;

import java.util.List;

public interface TakeabookService {

    List<Post> findAll();

    Post findById(Long id);

    Post save(Post post);
}
