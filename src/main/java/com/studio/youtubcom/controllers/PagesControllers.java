package com.studio.youtubcom.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class PagesControllers {
    @GetMapping("/honeyPage")
    public String honeyPage(Model model) {
        model.addAttribute("title", "Honey Page");
        return "honeyPage";
    }
    @GetMapping("/pollenPage")
    public String pollenPage(Model model) {
        model.addAttribute("title", "Pollen Page");
        return "pollenPage";
    }

    @GetMapping("/propolisPage")
    public String  propolisPage(Model model) {
        model.addAttribute("title", "Propolis Page");
        return "propolisPage";
    }

    @GetMapping("/pricePage")
    public String   pricePage(Model model) {
        model.addAttribute("title", "Price Page");
        return "pricePage";
    }

}
