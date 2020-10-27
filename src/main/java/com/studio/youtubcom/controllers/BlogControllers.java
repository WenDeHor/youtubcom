package com.studio.youtubcom.controllers;

import com.studio.youtubcom.models.Post;
import com.studio.youtubcom.repository.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
//@RequestMapping
public class BlogControllers {
    private final PostRepository postRepository;

    public BlogControllers(PostRepository postRepository) {

        this.postRepository = postRepository;
    }

    @GetMapping("/blog")
    public String blogMain(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("title", "blog page");
        model.addAttribute("posts", posts);
        return "blog-main";
    }

    @GetMapping("/blog/add")
    public String blogAdd(Model model) {
        return "blog-add";
    }

    @PostMapping("/blog/add")
    public String blogPostAdd(Long id,
                              @RequestParam String title,
                              @RequestParam String video,
                              @RequestParam String anons,
                              @RequestParam String full_text,
                              Model model) {
        Post post = new Post(id, title, video, anons, full_text);
        postRepository.save(post);
        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value = "id") Long id,
                              Model model) {
        if (!postRepository.existsById(id)) {
            return "redirect:/blog";
        }
        Optional<Post> post = postRepository.findById(id);
        List<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "blog-details";
    }

    @GetMapping("/blog/{id}/edit")
    public String blogEdit(@PathVariable(value = "id") Long id, Model model) {
//        if (!postRepository.existsById(id)) {
//            return "redirect:/blog";
//        }
            Optional<Post> post = postRepository.findById(id);
             List<Post> res = new ArrayList<>();
               post.ifPresent(res::add);
             model.addAttribute("post", res);
             return "blog-edit";
    }

    @PostMapping("/blog/{id}/edit")
    public String blogPostUpdate(@PathVariable(value = "id") Long id,
                                 @RequestParam String title,
                                 @RequestParam String video,
                                 @RequestParam String anons,
                                 @RequestParam String full_text,
                                 Model model) {
        Post post = postRepository.findById(id).orElseThrow(null);
        post.setTitle(title);
        post.setVideo(video);
        post.setAnons(anons);
        post.setFull_text(full_text);
        postRepository.save(post);
        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}/remove")
    public String blogPostUpdate(@PathVariable(value = "id") Long id, Model model) {
        Post post = postRepository.findById(id).orElseThrow(null);
        postRepository.delete(post);
        return "redirect:/blog";
    }

//    @PostMapping("/blog/{id}/remove")
//    public String blogPostUpdate(@PathVariable(value = "id") Long id, Model model) {
//        Post post = postRepository.findById(id).orElseThrow(null);
//        postRepository.delete(post);
//        return "redirect:/blog";
//    }
}
