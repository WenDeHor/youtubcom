package com.studio.youtubcom.controllers;

import com.studio.youtubcom.forms.UserForm;
import com.studio.youtubcom.models.Order;
import com.studio.youtubcom.models.Role;
import com.studio.youtubcom.models.State;
import com.studio.youtubcom.models.User;
import com.studio.youtubcom.repository.UserRepository;
import com.studio.youtubcom.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


@Controller
public class SignUpController {

    @Autowired
    private SignUpService service;

    @GetMapping("/signUp")
    public String getSignUpPage(Model model) {
        model.addAttribute("title", "signUp");
        return "sign-up";
    }

    @PostMapping("/signUp")
    public String signUp(UserForm userForm) {
        service.signUp(userForm);
        return "redirect:/login";
    }




}
