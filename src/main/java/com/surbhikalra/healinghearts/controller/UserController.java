package com.surbhikalra.healinghearts.controller;

import com.surbhikalra.healinghearts.model.User;
import com.surbhikalra.healinghearts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//User Controller class to handle all login/register request
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register"; // Thymeleaf template for registration
    }

    @PostMapping("/register")
    public String registerUser(User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register"; // Return to the registration page if there are errors
        }

        userService.registerUser(user); // Save the user
        model.addAttribute("successMessage", "User registered successfully! Please login.");
        return "loginpage"; // Redirect to login page
    }

    @GetMapping("/loginpage")
    public String showLoginForm() {
        return "loginpage"; // Thymeleaf template for login
    }

    @PostMapping("/loginpage")
    public String loginUser(String username, String password, Model model) {

        if (userService.authenticateUser(username, password)) {
            model.addAttribute("loginMessage", "Login successful!");
            System.out.println("Login Successful!");
            model.addAttribute("username", username);
            return "home"; // Redirect to home page on successful login
        }
        model.addAttribute("errorMessage", "Invalid credentials");
        return "loginpage"; // Return to login page if authentication fails
    }
}
