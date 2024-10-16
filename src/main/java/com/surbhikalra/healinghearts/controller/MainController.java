package com.surbhikalra.healinghearts.controller;

import com.surbhikalra.healinghearts.service.AppointmentService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {


    @GetMapping("/")
    public String home(Authentication authentication, Model model) {
        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();  // Get the username of the logged-in user
            model.addAttribute("username", username);
        }
        return "home";  // return the name of your homepage Thymeleaf template
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }


}