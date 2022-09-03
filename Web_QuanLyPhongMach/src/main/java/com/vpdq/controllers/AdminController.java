/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.vpdq.pojo.Employee;
import com.vpdq.pojo.Medicine;
import com.vpdq.pojo.Supplier;
import com.vpdq.service.CustomerService;
import com.vpdq.service.EmployeeService;
import com.vpdq.service.MedicalRecordService;
import com.vpdq.service.MedicineService;
import com.vpdq.service.PositionService;
import com.vpdq.service.SupplierService;
import com.vpdq.service.UnitService;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    @Bean
    public Cloudinary cloudinary() {
        Cloudinary cloudinary
                = new Cloudinary(ObjectUtils.asMap(
                        "cloud_name", "vinhphuvtv2",
                        "api_key", "335115886111226",
                        "api_secret", "Y4A5vCe_8f-liruLKg5FRmjl9tw",
                        "secure", true));
        return cloudinary;
    }
    
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
    
    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private EmployeeService employeeService;
       
    @Autowired
    private CustomerService customerService;
    
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
        model.addAttribute("employee", new Employee());
        return "employeesManager";
    }

    @PostMapping("/employeesManager")
    public String addEmployee(@ModelAttribute(value = "employee") @Valid Employee e,
            BindingResult r) {
        if (r.hasErrors()) {
            return "employeesManager"; //return lổi
        }
        if (this.employeeService.addEmployee(e) == true) {
            return "redirect:employeesManager"; //return về trang gì đó
        }
        return "employeesManager";
    }

    
    
    @PostMapping("/employeesManager/{employeeId}")
    public String updateEmployee(
            @ModelAttribute(value = "employeeUpdate") @Valid Employee e,
            BindingResult r) {
        if (r.hasErrors()) {
            return "employeesManager"; //return lổi
        }
        if (this.employeeService.updateEmployee(e) == true) {
            return "redirect:employeesManager"; //return về trang gì đó
        }
        return "employeesManager";
    }
    

    @GetMapping("/customersManager")
    public String customersManager(Model model) {
        return "customersManager";
    }

    @RequestMapping("/reportsManager")
    public String reportsManager(Model model,
            @RequestParam(value = "year", defaultValue = "2022", required = false) int year,
            @RequestParam(value = "year2", defaultValue = "2022", required = false) int year2) {
        model.addAttribute("total", this.medicalRecordService.totalRevenueStatistics());
        model.addAttribute("revenueStats", this.medicalRecordService.revenueStatistics());
        model.addAttribute("revenueStatsByQuarter", this.medicalRecordService.revenueStatisticsByQuarter(year));
        model.addAttribute("revenueStatsByMonth", this.medicalRecordService.revenueStatisticsByMonth(year2));
        model.addAttribute("year", year);
        model.addAttribute("year2", year2);
        
        String err1 = "";
        String err2 = "";
       
        //lấy năm hiện tại
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        int yearNow = zonedDateTime.getYear();
       
        if(year<1970 || year>yearNow)
            err1 = "Năm không hợp lệ! Vui lòng thử lại.";
        model.addAttribute("err1", err1);
        
        if(year2<1970 || year2>yearNow)
            err2 = "Năm không hợp lệ! Vui lòng thử lại.";
        model.addAttribute("err2", err2);
        
        return "reportsManager";
    }

    
    @RequestMapping("/reports2Manager")
    public String reports2Manager (Model model,
            @RequestParam(value = "year1", defaultValue = "2022", required = false) int year1,
            @RequestParam(value = "year2", defaultValue = "2022", required = false) int year2){
        model.addAttribute("patientStats", this.customerService.patientStatistics());
        model.addAttribute("patientStatsByYear", this.customerService.patientStatisticsByYear());
        model.addAttribute("patientStatsByQuarter", this.customerService.patientStatisticsByQuater(year1));
        model.addAttribute("patientStatsByMonth", this.customerService.patientStatisticsByMonth(year2));
        model.addAttribute("year1", year1);
        model.addAttribute("year2", year2);
        
        
        String err1 = "";
        String err2 = "";
       
        //lấy năm hiện tại
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        int yearNow = zonedDateTime.getYear();
       
        if(year1<1970 || year1>yearNow)
            err1 = "Năm không hợp lệ! Vui lòng thử lại.";
        model.addAttribute("err1", err1);
        
        if(year2<1970 || year2>yearNow)
            err2 = "Năm không hợp lệ! Vui lòng thử lại.";
        model.addAttribute("err2", err2);
        
        return "reports2Manager";
    }
    
    @RequestMapping("/reports3Manager")
    public String reports3Manager (Model model,
            @RequestParam(value = "year1", defaultValue = "2022", required = false) int year1,
            @RequestParam(value = "year2", defaultValue = "2022", required = false) int year2,
            @RequestParam(value = "year3", defaultValue = "2022", required = false) int year3,
            @RequestParam(value = "quarter2", defaultValue = "1", required = false) int quarter2,
            @RequestParam(value = "month3", defaultValue = "1", required = false) int month3) {
        model.addAttribute("frequencyMedicineUsageStatsByYear", this.medicineService.frequencyOfMedicineUsageStatisticsByYear(year1));
        model.addAttribute("year1", year1);
        
        model.addAttribute("frequencyMedicineUsageStatsByQuarter", this.medicineService.frequencyOfMedicineUsageStatisticsByQuarter(year2, quarter2));
        model.addAttribute("year2", year2);
        model.addAttribute("quarter2", quarter2);
        
        model.addAttribute("frequencyMedicineUsageStatsByMonth", this.medicineService.frequencyOfMedicineUsageStatisticsByMonth(year3, month3));
        model.addAttribute("year3", year3);
        model.addAttribute("month3", month3);
        
        String err1 = "";
        String err2 = "";
        String err3 = "";
  
       
        //lấy năm hiện tại
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        int yearNow = zonedDateTime.getYear();
       
        if(year1<1970 || year1>yearNow)
            err1 = "Năm không hợp lệ! Vui lòng thử lại.";
        model.addAttribute("err1", err1);
        
        if(year2<1970 || year2>yearNow)
            err2 = "Năm không hợp lệ! Vui lòng thử lại.";
        model.addAttribute("err2", err2);
        
        if(year3<1970 || year3>yearNow)
            err3 = "Năm không hợp lệ! Vui lòng thử lại.";
        else
            if(month3<1 || month3>12)
                err3 = "Tháng không hợp lệ! Vui lòng thử lại.";
        model.addAttribute("err3", err3);

        return "reports3Manager";
    }
  
    
//    THUỐC
    @GetMapping("/medicinesManager")
    public String listMedicine(Model model) {
        model.addAttribute("medicine", new Medicine());

//        int page = Integer.parseInt(params.getOrDefault("page", "1"));
//        model.addAttribute("medicine2", this.medicineService.getMedicines2(params, page));
        return "medicinesManager";
    }

    @PostMapping("/medicinesManager")
    public String addMedicine(@ModelAttribute(value = "medicine") @Valid Medicine m,
            BindingResult rs) throws IOException {
        //nếu có ảnh thì upload lên cloudinary
        if (m.getFile().isEmpty()==false) {
            try {
                Map r = this.cloudinary.uploader().upload(m.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                String img = (String) r.get("secure_url");
                m.setImage(img);
            } catch (IOException ex) {
                System.err.println("ADD MEDICINE " + ex.getMessage());
            }
        }
        
        if(m.getNote().isEmpty())
            m.setNote(null);
        
        if (rs.hasErrors())
            return "medicinesManager";
        
        
        if (this.medicineService.addMedicine(m) == true) 
            return "redirect:medicinesManager";
        
        return "medicinesManager";
    }

    @GetMapping("/medicinesManager/{mID}")
    public String getMedicine(Model model, Medicine m, @PathVariable(value = "mID") int id) {
        model.addAttribute("medicine", this.medicineService.getMedicineByID(id));
        return "updateMedicine";
    }

    @PostMapping("/medicinesManager/{mID}")
    public String updateMedicine(@PathVariable(value = "mID") int id,
            @ModelAttribute(value = "medicine") @Valid Medicine m,
            BindingResult rs) {
        Medicine me = this.medicineService.getMedicineByID(id);
        
        if (m.getFile().isEmpty()==false) {
            try {
                Map r = this.cloudinary.uploader().upload(m.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                String img = (String) r.get("secure_url");
                m.setImage(img);
            } catch (IOException ex) {
                System.err.println("ADD MEDICINE " + ex.getMessage());
            }
        }
        else
            m.setImage(me.getImage());
        
        if (rs.hasErrors())
            return "updateMedicine";
        
        if (this.medicineService.updateMedicineByID(id, m) == true) {
            return "redirect:/admins/medicinesManager";
        }
        return "updateMedicine";
    }

    
//LỊCH TRỰC
    @GetMapping("/onCallManager")
    public String onCallManager() {
        return "onCallManager";
    }

}
