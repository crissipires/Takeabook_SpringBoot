package com.spring.takeabook.repository;

import com.spring.takeabook.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TakeabookRepository extends JpaRepository<Post,Long> {
}
