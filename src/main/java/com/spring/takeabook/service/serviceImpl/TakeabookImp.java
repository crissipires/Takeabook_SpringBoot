package com.spring.takeabook.service.serviceImpl;

import com.spring.takeabook.model.Post;
import com.spring.takeabook.repository.TakeabookRepository;
import com.spring.takeabook.service.TakeabookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TakeabookImp implements TakeabookService {

    @Autowired
    TakeabookRepository takeabookRepository;

    @Override
    public List<Post> findAll() {
        return takeabookRepository.findAll();
    }

    @Override
    public Post findById(Long id) {
        return takeabookRepository.findById(id).get();
    }

    @Override
    public Post save(Post post) {
        return takeabookRepository.save(post);
    }

    @Override
    public void deleteById(Long id) {
        takeabookRepository.deleteById(id);
    }
}
