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

        String url= "https://www.youtube.com/embed/"+video+"?version=3&rel=1&fs=1&autohide=2&showsearch=0&showinfo=1&iv_load_policy=1&wmode=transparent";
//        https://www.youtube.com/embed/vguSoDvurss?version=3&rel=1&fs=1&autohide=2&showsearch=0&showinfo=1&iv_load_policy=1&wmode=transparent
        Post post = new Post(id, title, url, anons, full_text);
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
            Optional<Post> post = postRepository.findById(id);
             List<Post> res = new ArrayList<>();
               post.ifPresent(res::add);
             model.addAttribute("post", res);
             return "blog-edit";
    }

    @GetMapping("/blog/user/{id}")
    public String blogUserDetails(@PathVariable(value = "id") Long id, Model model) {
        Optional<Post> post = postRepository.findById(id);
        List<Post> userpost = new ArrayList<>();
        post.ifPresent(userpost::add);
        model.addAttribute("title", "user page");
        model.addAttribute("post", userpost);
        return "blogUserDetails";
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
//        String url= "https://www.youtube.com/embed/"+video+"?version=3&rel=1&fs=1&autohide=2&showsearch=0&showinfo=1&iv_load_policy=1&wmode=transparent";
//        https://www.youtube.com/embed/vguSoDvurss?version=3&rel=1&fs=1&autohide=2&showsearch=0&showinfo=1&iv_load_policy=1&wmode=transparent
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
}
