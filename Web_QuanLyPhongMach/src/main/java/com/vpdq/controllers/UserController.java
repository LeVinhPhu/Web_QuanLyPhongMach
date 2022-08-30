/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.controllers;

import com.cloudinary.utils.ObjectUtils;
import com.vpdq.pojo.Customer;
import com.vpdq.service.CustomerService;
import java.io.IOException;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author phamt
 */
@Controller
public class UserController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String registerView(Model model) {
        model.addAttribute("customers", new Customer());
        return "register";
    }

//    @PostMapping("/register")
//    public String register(Model model,
//            @ModelAttribute(value = "customers") @Valid Customer customer, BindingResult rs) {
//        String errMsg = "";
//        if (rs.hasErrors() == false) {
//            if (customer.getPassword().equals(customer.getConfirmPassword())) {
//                if (this.customerService.addCustomer(customer) == true) {
//                    return "redirect:/login";
//                } else {
//                    errMsg = "Đã có lỗi xảy ra!";
//                }
//            } else 
//                errMsg = "Mật khẩu xác nhận không hợp lệ!";
//        }
//        else
//            errMsg = "Lỗi";
//
//        model.addAttribute("errMsg", errMsg);
//
//        return "register";
//    }
    @PostMapping("/register")
    public String register(Model model,
            @ModelAttribute(value = "customers") Customer customer) {
        String errMsg = "";

        if (this.customerService.addCustomer(customer) == true) {
            return "redirect:/login";
        } else {
            errMsg = "Đã có lỗi xảy ra!";
        }

        model.addAttribute("errMsg", errMsg);
        return "register";
    }

}
