package com.studio.youtubcom.controllers;

import com.studio.youtubcom.models.Post;
import com.studio.youtubcom.repository.PostRepository;
import com.studio.youtubcom.security.details.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping
public class AuthController {

    @GetMapping("/login")
    public String getLoginPage(Authentication authentication, ModelMap model, HttpServletRequest request) {

        if (authentication != null) {
            return "redirect:/success";
        } else if (request.getParameterMap().containsKey("error")) {
            model.addAttribute("error", true);
        }
        model.addAttribute("title", "login");
        return "login";
    }


    @PostMapping("/logout")
    public String postLogout(Model model) {
//        model.addAttribute("title", true);
        return "redirect:/";
    }

    @GetMapping("/success")
    public String getSuccessPage(Authentication authentication) {
        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        String userRole = details.getAuthorities().toString();
        if (userRole.equals("[ADMIN]") || userRole.equals("ADMIN")) {
            System.out.println(userRole + details.getUsername() + details.getAuthorities() + " is enter us ADMIN");
            return "blog-main";
        }
        if (userRole.equals("[USER]") || userRole.equals("USER")) {
            System.out.println(userRole + details.getUsername() + details.getAuthorities() + " is enter us USER");
            return "success";
        } else {
            System.out.println(userRole + details.getUsername() + details.getAuthorities() + " is not  enter");
            return "redirect:/";
        }

    }
}
