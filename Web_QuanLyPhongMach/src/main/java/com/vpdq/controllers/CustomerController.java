/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.controllers;

import com.vpdq.pojo.Appointment;
import com.vpdq.pojo.Customer;
import com.vpdq.service.AppointmentService;
import com.vpdq.service.CustomerService;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

    @Autowired
    private CustomerService customerService;
    
    @GetMapping("/customersIndex")
    public String index() {
        return "customersIndex";
    }

    @GetMapping("/appointments")
    public String showAppointments (Model model, HttpSession session){
        model.addAttribute("appointments", new Appointment());
        model.addAttribute("currentUser",session.getAttribute("currentUser"));
        return "appointments";
    }
    
    //Đặt lịch khám
    @PostMapping("/appointments")
    public String addAppointments (Model model,  
            @ModelAttribute(value = "appointments") Appointment a,
            @RequestParam(value = "idCus", defaultValue = "", required = false) int idCus) {

        Customer c = new Customer();
        c.setId(idCus);
        a.setCustomerId(c);
        if(this.appointmentService.addAppointment(a))
            return "appointments";
        return "appointments";
    }
    
    //
    @GetMapping("/customersProfile")
    public String adminsProfile(Model model, HttpSession session) {
        model.addAttribute("currentUser", session.getAttribute("currentUser"));
        model.addAttribute("updateProfileCustomer", new Customer());
        return "customersProfile";
    }

    //Trang cá nhân Customer
    @PostMapping("/customersProfile")
    public String updateProfileAdmin(HttpSession session,
            @ModelAttribute(value = "updateProfileCustomer") @Valid Customer c,
            BindingResult r) {
        if (r.hasErrors()) {
            return "customersProfile";
            //return lổi
        }
        Customer ct = (Customer) session.getAttribute("currentUser");
        if (this.customerService.updateCustomer(ct.getId(), c) == true) {
            return "redirect:customersProfile"; //return về trang gì đó
        }
        return "customersProfile";
    }

}
