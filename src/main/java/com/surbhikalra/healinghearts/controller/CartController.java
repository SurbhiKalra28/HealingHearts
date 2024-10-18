package com.surbhikalra.healinghearts.controller;


import com.surbhikalra.healinghearts.exception.AppointmentNotFoundException;
import com.surbhikalra.healinghearts.model.Appointment;
import com.surbhikalra.healinghearts.model.Cart;
import com.surbhikalra.healinghearts.service.AppointmentService;
import com.surbhikalra.healinghearts.service.CartService;
import com.surbhikalra.healinghearts.service.MerchandiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


//Appointment Controller class to handle all appointment related request
@Controller
public class CartController {

    final String path = "/cart";

    @Autowired
    private CartService cartService;
    @Autowired
    private MerchandiseService merchandiseService;

    //Get all appointments
    @GetMapping(path)
    public String getCart(Model model) {
        return "cart";
    }

    //Get all appointments
    @GetMapping(path+ "/add")
    public String addCart(Model model) {
        return "cart";
    }


    //Create new appointment in the model
    @PostMapping(path + "/add")
    public String saveCart(@ModelAttribute("cart") Cart cart) {
        System.out.println(cart);
        cartService.saveCart(cart);
        return "cart";
    }

}
