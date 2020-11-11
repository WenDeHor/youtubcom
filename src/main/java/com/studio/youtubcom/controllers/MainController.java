package com.studio.youtubcom.controllers;

import com.studio.youtubcom.models.Post;
import com.studio.youtubcom.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private final PostRepository postRepository;

    public MainController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        model.addAttribute("title", "Main paige");
        return "home";
    }


    //    @GetMapping("/about")
//    public String about(Model model) {
//        model.addAttribute("title", "Сторінка про нас");
//        return "about";
//    }
//    @GetMapping("/about")
//    public String about() {
//        return "/about";
//    }
    @GetMapping("/news")
    public String news() {
        return "news";
    }
    @GetMapping("/pagePrice")
    public String pagePrace() {
        return "pagePrace";
    }
}

