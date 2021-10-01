package com.spring.takeabook.utils;

import com.spring.takeabook.model.Post;
import com.spring.takeabook.repository.TakeabookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Component
public class DummyData {
    @Autowired
    TakeabookRepository takeabookRepository;

    ///@PostConstruct
    public void savePost(){
        Post post1 = new Post();
        post1.setAuthor("Marcos Teixeira");
        post1.setDate(LocalDate.now());
        post1.setTitle("Ubuntu");
        post1.setText("lorem ipsulon colorem ipsulon copiu ehdia enad oe djlorem ipsulon copiu ehdia enad oe djlorem ipsulon copiu ehdia enad oe djpiu ehdia enad oe djlorem ipsulon copiu ehdia enad oe djlorem ipsulon copiu ehdia enad oe djlorem ipsulon copiu ehdia enad oe djlorem ipsulon copiu ehdia enad oe djlorem ipsulon copiu ehdia enad oe djlorem ipsulon copiu ehdia enad oe djvvv ");

        takeabookRepository.save(post1);
    }
}
