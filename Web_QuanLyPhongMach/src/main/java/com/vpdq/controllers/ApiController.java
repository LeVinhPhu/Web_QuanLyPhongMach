/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.controllers;
import com.vpdq.pojo.Admin;
import com.vpdq.pojo.Employee;
import com.vpdq.pojo.Medicine;
import com.vpdq.pojo.Unit;
import com.vpdq.service.EmployeeService;
import com.vpdq.pojo.Customer;
import com.vpdq.pojo.Medicine;
import com.vpdq.service.AdminService;
import com.vpdq.pojo.Prescription;
import com.vpdq.service.CustomerService;
import com.vpdq.service.MedicalRecordService;
import com.vpdq.service.MedicineService;
import com.vpdq.service.PrescriptionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author phamt
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private MedicineService medicineService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private EmployeeService employeeServic;
    
    @Autowired
    private PrescriptionService prescriptionService;

    @Autowired
    private AdminService adminService;

//  API-Que
    @GetMapping("/medicines")
    public ResponseEntity<List<Object[]>> listMedicine() {
        //api/medicines lấy danh sách thuốc phục vụ cho admin/medicines
        return new ResponseEntity<>(this.medicineService.getMedicines(null, 0), HttpStatus.OK);
    }

    @DeleteMapping("/medicines/{medicineId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMedicine(@PathVariable(value = "medicineId") int id) {
        this.medicineService.deleteMedicine(id);
    }

    @GetMapping("/phoneNumber")
    public ResponseEntity<List<Customer>> listPhoneNumber() {
        return new ResponseEntity<>(this.customerService.getAllPhoneNumber(), HttpStatus.OK);
    }
    
    @GetMapping("/prescription")
    public ResponseEntity<List<Object[]>> listPrescription() {
        return new ResponseEntity<>(this.prescriptionService.getPrescription(), HttpStatus.OK);
    }

//   API-Phu
    @GetMapping("/employeesManager")
    public ResponseEntity<List<Employee>> list() {
        return new ResponseEntity<>(this.employeeServic.getEmployee(null, 0), HttpStatus.OK);
    }

    @DeleteMapping("/employeesManager/{employeeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable(value = "employeeId") int employeeId) {
        this.employeeServic.deleteEmployee(employeeId);
    }

    @GetMapping("/adminsManager")
    public ResponseEntity<List<Admin>> listAdm() {
        return new ResponseEntity<>(this.adminService.getAdmin(null, 0), HttpStatus.OK);
    }

    @DeleteMapping("/adminsManager/{adminId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAdmin(@PathVariable(value = "adminId") int adminId) {
        this.adminService.deleteAdmin(adminId);
    }

    @GetMapping("/medicine/{mID}")
    public Medicine getMedicine(@PathVariable(value = "mID") int id) {
        return medicineService.getMedicineByID(id);
    }
    
    @GetMapping("/customersManager")
    public ResponseEntity<List<Customer>> listCustomer() {
        return new ResponseEntity<>(this.customerService.getCustomer(null, 0), HttpStatus.OK);
    }

}
