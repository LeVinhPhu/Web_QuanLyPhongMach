/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.controllers;

import com.vpdq.pojo.Medicine;
import com.vpdq.service.EmployeeService;
import com.vpdq.service.MedicalRecordService;
import com.vpdq.service.MedicineService;
import com.vpdq.service.PositionService;
import com.vpdq.service.SupplierService;
import com.vpdq.service.UnitService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
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
@RequestMapping("/admins")
@ControllerAdvice //dung trong khai bao thuoc tinh dung chung 
public class AdminController {

    //Kết nối vs service
    @Autowired
    private PositionService positionService;
    
    @Autowired
    private MedicineService medicineService;
    
    @Autowired
    private UnitService unitService;

    @Autowired
    private SupplierService supplierService;
    
    @Autowired
    private MedicalRecordService medicalRecordService;
    
    
    //dung chung
    @ModelAttribute
    public void commonAttribute(Model model) {
        model.addAttribute("positions", this.positionService.getPosition());
        model.addAttribute("units", this.unitService.getUnits());
        model.addAttribute("suppliers", this.supplierService.getSuppliers());
//        model.addAttribute("revenueStats", this.medicalRecordService.revenueStatistics());
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
    
    @RequestMapping("/reportsManager")
    public String reportsManager (Model model,
            @RequestParam(value = "year", defaultValue = "0", required = false) int year,
            @RequestParam(value = "year2", defaultValue = "0", required = false) int year2){
        model.addAttribute("revenueStats", this.medicalRecordService.revenueStatistics());
        model.addAttribute("revenueStatsByQuarter", this.medicalRecordService.revenueStatisticsByQuarter(year));
        model.addAttribute("revenueStatsByMonth", this.medicalRecordService.revenueStatisticsByMonth(year2));
        return "reportsManager";
    }
  
  
    
    @GetMapping("/medicinesManager")
    public String listMedicine (Model model) {
        model.addAttribute("medicine", new Medicine());
        
//        int page = Integer.parseInt(params.getOrDefault("page", "1"));
//        model.addAttribute("medicine2", this.medicineService.getMedicines2(params, page));
        
        return "medicinesManager";
    }
    
    @PostMapping("/medicinesManager")
    public String addMedicine(@ModelAttribute(value = "medicine") @Valid Medicine m, 
            BindingResult rs) {
        if (rs.hasErrors())
            return "medicinesManager";
        
        if (this.medicineService.addMedicine(m)==true)
            return "medicinesManager";
        
        return "medicinesManager";
        
    }
    
    @GetMapping("/onCallManager")
    public String onCallManager (){
        return "onCallManager";
    }

}
