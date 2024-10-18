package com.surbhikalra.healinghearts.controller;

import com.surbhikalra.healinghearts.service.AppointmentService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//Main Controller class to handle all other request
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

    @GetMapping("/{username}")
    public String home(@PathVariable String username) {
        return "home";  // return the name of your homepage Thymeleaf template
    }

    @GetMapping("/contact/{username}")
    public String contact(@PathVariable String username) {
        return "contact";
    }

    @GetMapping("/about/{username}")
    public String about(@PathVariable String username) {
        return "about";
    }


}