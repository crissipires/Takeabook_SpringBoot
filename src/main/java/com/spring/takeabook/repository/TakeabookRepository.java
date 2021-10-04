package com.spring.takeabook.repository;

import com.spring.takeabook.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TakeabookRepository extends CrudRepository<Post,Long>, JpaRepository<Post,Long>{
}
