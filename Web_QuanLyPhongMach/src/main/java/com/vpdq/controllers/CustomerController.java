/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author vinhp
 */

@Controller
@RequestMapping("customers")
public class CustomerController {
    
    @GetMapping("/customersIndex")
    public String index (){
        return "customersIndex";
    }
    
    @GetMapping("/appointments")
    public String appointments (){
        return "appointments";
    }
    
}
