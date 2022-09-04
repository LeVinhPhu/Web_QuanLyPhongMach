/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.controllers;

import com.vpdq.pojo.Customer;
import com.vpdq.pojo.Employee;
import com.vpdq.pojo.MedicalRecord;
import com.vpdq.pojo.Medicine;
import com.vpdq.pojo.Service;
import com.vpdq.service.MedicalRecordService;
import com.vpdq.service.ServiceClinicService;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired 
    private ServiceClinicService serviceClinicService;

    @Autowired
    private MedicalRecordService medicalRecordService;
    
    
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
        model.addAttribute("services", this.serviceClinicService.getService());
        
        return "medicalRecord";
    }
    
    //Tạo phiếu khám - VẪN ĐANG LỖI
//    @PostMapping("/medicalRecord/{cusID}")
//    public String addMedicalRecord (Model model, HttpSession session,
//            @PathVariable(value = "cusID") int cusID,
//            @ModelAttribute(value = "medicalRecord") @Valid MedicalRecord m,
//            BindingResult rs){
//        
//        model.addAttribute("services", this.serviceClinicService.getService());
//        
//        Employee e = (Employee) session.getAttribute("currentUser");
//        m.setDoctorId(e);
//        
//        Customer c = new Customer();
//        c.setId(cusID);
//        m.setCustomerId(c);
//              
//        if (rs.hasErrors()) {
//            return "Web_QuanLyPhongMach/";
//        }
//        
//        if (this.medicalRecordService.addMedicalRecord(m) == true) {
//            return "redirect:medicalRecord";
//        }
//        
//        return "medicalRecord";
//    }
    
    
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

}
