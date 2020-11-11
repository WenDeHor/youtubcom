package com.studio.youtubcom.controllers;

import com.studio.youtubcom.models.Order;
import com.studio.youtubcom.models.User;
import com.studio.youtubcom.repository.OrderRepository;
import com.studio.youtubcom.repository.UserRepository;
import com.studio.youtubcom.security.details.UserDetailsImpl;
import org.springframework.security.core.Authentication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;


@Controller
@RequestMapping
public class AuthController {
    private final UserRepository repository;
    private final OrderRepository orderRepository;

    public AuthController(OrderRepository orderRepository, UserRepository repository) {
        this.orderRepository = orderRepository;
        this.repository = repository;
    }
    @PostMapping("/orderuser")
    public String orderUser(Order order) {
        Date datetoday = new Date();
        Order order1 = Order.builder()
                .username(order.getUsername())
                .phone(order.getPhone())
                .text(order.getText())
                .date(datetoday)
                .build();
        orderRepository.save(order1);
        return "okay";
    }
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
        return "redirect:/";
    }

    @GetMapping("/success")
    public String getSuccessPage(Authentication authentication, Model model) {
        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        String userRole = details.getAuthorities().toString();
        if (userRole.equals("[ADMIN]") || userRole.equals("ADMIN")) {

            List<User> listUser = repository.findAll();
            model.addAttribute("listUser", listUser);

            List<Order> listOrder = orderRepository.findAll();
            model.addAttribute("listOrder", listOrder);

            System.out.println(userRole + details.getUsername() + details.getAuthorities() + " is enter us ADMIN");
            return "blog-main";
        }
        if (userRole.equals("[USER]") || userRole.equals("USER")) {

//            TODO good Work
//            Optional<User> users = repository.findOneByEmail(authentication.getName());
//            List<User> listUser = new ArrayList<>();
//            users.ifPresent(listUser::add);
//            model.addAttribute("listUser", listUser);

            System.out.println(userRole + details.getUsername() + details.getAuthorities() + " is enter us USER");
            return "success";
        } else {
            System.out.println(userRole + details.getUsername() + details.getAuthorities() + " is not  enter");
            return "redirect:/";
        }

    }
}
