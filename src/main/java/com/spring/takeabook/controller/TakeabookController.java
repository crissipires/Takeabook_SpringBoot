package com.spring.takeabook.controller;

import com.spring.takeabook.model.Post;
import com.spring.takeabook.service.TakeabookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
public class TakeabookController {

    @Autowired
    TakeabookService takeabookService;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView getPosts() {
        ModelAndView mv = new ModelAndView("posts");
        List<Post> postsList = takeabookService.findAll();
        mv.addObject("posts", postsList);
        return mv;
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public ModelAndView getPostDetails(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("postDetails");
        Post post = takeabookService.findById(id);
        mv.addObject("post", post);
        return mv;
    }

    @RequestMapping(value = "/posts/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes attributes){
        takeabookService.deleteById(id);
        attributes.addFlashAttribute("message", "A postagem foi deletada com sucesso!");
        return "redirect:/posts";
    }

    @RequestMapping(value = "/newpost",method = RequestMethod.GET)
    public String getPostForm(){
        return "postForm";
    }

    @RequestMapping(value = "/savepost", method= RequestMethod.POST)
    public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem","Verifique se os campos obrigatórios foram preenchidos!");
            return "redirect:/newpost";
        }
        post.setDate(LocalDate.now());
        takeabookService.save(post);
        return "redirect:/posts";
    }

    @RequestMapping(value = "posts/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("postEdit");
        Post post = takeabookService.findById(id);
        takeabookService.deleteById(id);
        mv.addObject("post", post);
        return mv;
    }
}
