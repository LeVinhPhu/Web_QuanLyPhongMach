/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author vinhp
 */

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    

    //Bác sĩ quản lý
    
    @GetMapping("/doctorsIndex")
    public String doctorsIndex (){
        return "doctorsIndex";
    }
    
    @GetMapping("/medicalRecord")
    public String medicalRecord (){
        return "medicalRecord";
    }
    
    @GetMapping("/prescription")
    public String prescription (){
        return "prescription";
    }
    
    //Y tá quản lý
    
    @GetMapping("/nursesIndex")
    public String nursesIndex (Model model, HttpSession session){
//        model.addAttribute("currentUser",session.getAttribute("currentUser"));
        return "nursesIndex";
    }
    
    @GetMapping("/billsManager")
    public String billsManager (){
        return "billsManager";
    }
    
    @GetMapping("/appointmentsManager")
    public String appointmentsManager (){
        return "appointmentsManager";
    }

}
