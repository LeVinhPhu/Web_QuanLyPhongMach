/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.controllers;

import com.vpdq.service.EmployeeService;
import com.vpdq.service.PositionService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author vinhp
 */
@Controller
@RequestMapping("/admins")
public class AdminController {

    //Kết nối vs service
    @Autowired
    private PositionService positionService;

    @ModelAttribute
    public void commonAttribute(Model model) {
        model.addAttribute("positions", this.positionService.getPosition());
    }

    @GetMapping("/adminIndex")
    public String index() {
        return "adminIndex";
    }

    @GetMapping("/adminsManager")
    public String adminsMager(Model model) {
        return "adminsManager";
    }
    
    @GetMapping("/employeesManager")
    public String employeesManager(Model model) {
        return "employeesManager";
    }
    
    @GetMapping("/customersManager")
    public String customersManager(Model model) {
        return "customersManager";
    }
    
    @GetMapping("/reportsManager")
    public String reportsManager (){
        return "reportsManager";
    }
    
    @GetMapping("/medicinesManager")
    public String medicinesManager (){
        return "medicinesManager";
    }
    
    @GetMapping("/onCallManager")
    public String onCallManager (){
        return "onCallManager";
    }

}
