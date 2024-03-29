/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.controllers;

import com.cloudinary.utils.ObjectUtils;
import com.vpdq.pojo.Admin;
import com.vpdq.pojo.Customer;
import com.vpdq.pojo.Employee;
import com.vpdq.rolestatic.UserRole;
import com.vpdq.service.CustomerService;
import static java.awt.SystemColor.window;
import java.io.IOException;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author phamt
 */
@Controller
public class UserController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/register")
    public String registerView(Model model) {
        model.addAttribute("customers", new Customer());
        return "register";
    }

    @PostMapping("/register")
    public String registers(Model model,
            @ModelAttribute(value = "customers") Customer customer) {
        String errMsg = "";
        
        if (customer.getPassword().equals(customer.getConfirmPassword())) {
            if (this.customerService.addCustomer(customer) == true) {
                return "redirect:/login";
            } else {
                errMsg = "Đã có lỗi xảy ra!";
            }
        } else {
            errMsg = "TOOFN TAI!";
        }

        model.addAttribute("errMsg", errMsg);
        return "register";
    }

}
