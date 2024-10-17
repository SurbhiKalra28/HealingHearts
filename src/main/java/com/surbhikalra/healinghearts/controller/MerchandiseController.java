package com.surbhikalra.healinghearts.controller;

import com.surbhikalra.healinghearts.model.Appointment;
import com.surbhikalra.healinghearts.model.Merchandise;
import com.surbhikalra.healinghearts.service.AppointmentService;
import com.surbhikalra.healinghearts.service.MerchandiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class MerchandiseController {

    @Autowired
    private MerchandiseService merchandiseService;

    //Get all appointments
    @GetMapping("merchandise")
    public String getAllMerchandise(Model model) {
        List<Merchandise> merchandise = merchandiseService.getAllMerchandise();
        model.addAttribute("merchandise", merchandise);
        return "merchandise-list";
    }

    //Get all appointments by client
    @GetMapping("merchandise/{username}")
    public String getAllMerchandiseForUser(@PathVariable String username, Model model) {
        List<Merchandise> merchandise = merchandiseService.getAllMerchandise();
        System.out.println(merchandise);
        model.addAttribute("merchandise", merchandise);
        return "merchandise-list";
    }

}
