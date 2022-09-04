/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.controllers;

import com.vpdq.pojo.Appointment;
import com.vpdq.pojo.Customer;
import com.vpdq.service.AppointmentService;
import com.vpdq.utils.Search;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author vinhp
 */
@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/customersIndex")
    public String index() {
        return "customersIndex";
    }

    @GetMapping("/customersProfile")
    public String customersProfile() {
        return "customersProfile";
    }

    @GetMapping("/appointments")
    public String showAppointments (Model model, HttpSession session){
        model.addAttribute("appointments", new Appointment());
        model.addAttribute("currentUser",session.getAttribute("currentUser"));
        
        Customer cs = (Customer) session.getAttribute("currentUser");
        Search.setIdCus(cs.getId());
        return "appointments";
    }
    
    //Đặt lịch khám
    @PostMapping("/appointments")
    public String addAppointments (Model model, HttpSession session,
            @ModelAttribute(value = "appointments") Appointment a) {
        Customer c = (Customer) session.getAttribute("currentUser");
        a.setCustomerId(c);
        
        if(this.appointmentService.addAppointment(a))
            return "appointments";
        return "appointments";
    }

}
