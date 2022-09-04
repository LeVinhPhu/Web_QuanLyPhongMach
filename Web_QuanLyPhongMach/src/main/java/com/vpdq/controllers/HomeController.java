/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.controllers;

import com.vpdq.rolestatic.UserRole;
import com.vpdq.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author vinhp
 */
@Controller
public class HomeController {

    // Lien ket voi Service
    @Autowired
    private EmployeeService employeeService;
    
    
    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }
    
    @PostMapping("/")
    public String registers(Model model,
            @RequestParam(value = "role") String role){
        UserRole.setRole(role);
        return "login";
    }
}
