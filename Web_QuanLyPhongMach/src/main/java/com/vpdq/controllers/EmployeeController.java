/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.vpdq.pojo.Employee;
import com.vpdq.pojo.MedicalRecord;
import com.vpdq.service.EmployeeService;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author vinhp
 */

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    
    
    private EmployeeService employeeService;

    //Bác sĩ quản lý
    
    @GetMapping("/doctorsIndex")
    public String doctorsIndex (){
        return "doctorsIndex";
    }
    
    @GetMapping("/doctorsProfile")
    public String doctorsProfile (){
        return "doctorsProfile";
    }
    
    @GetMapping("/medicalRecord/{cusID}")
    public String medicalRecord (Model model, @PathVariable(value = "cusID") int cusID){
        
        model.addAttribute("medicalRecord", new MedicalRecord());
        
        return "medicalRecord";
    }
    
    @GetMapping("/prescription")
    public String prescription (){
        return "prescription";
    }
    
    //Y tá quản lý
    
    @GetMapping("/nursesIndex")
    public String nursesIndex (Model model, HttpSession session){
        model.addAttribute("currentUser",session.getAttribute("currentUser"));
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
    
    //Trang Ca nhan Admin
    @GetMapping("/employeesProfile")
    public String adminsProfile(Model model, HttpSession session) {
        model.addAttribute("currentUser", session.getAttribute("currentUser"));
        model.addAttribute("updateProfileEmployee", new Employee());
        return "employeesProfile";
    }

    @PostMapping("/employeesProfile")
    public String updateProfileAdmin(HttpSession session,
            @ModelAttribute(value = "updateProfileEmployee") @Valid Employee e,
            BindingResult r) {
        if (r.hasErrors()) {
            return "employeesProfile";
            //return lổi
        }
        Employee e2 = (Employee) session.getAttribute("currentUser");
        if (this.employeeService.updateEmployee(e2.getId(), e) == true) {
            return "redirect:updateProfileEmployee"; //return về trang gì đó
        }
        return "updateProfileEmployee";
    }

}
