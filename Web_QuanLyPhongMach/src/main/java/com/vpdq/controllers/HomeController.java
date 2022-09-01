/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.controllers;

import com.vpdq.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
        model.addAttribute("employees", this.employeeService.getEmployee_Demo());
        return "home";
    }
    
    
}
