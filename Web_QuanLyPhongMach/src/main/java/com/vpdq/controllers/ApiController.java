/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.vpdq.pojo.Admin;
import com.vpdq.pojo.Appointment;
import com.vpdq.pojo.Employee;
import com.vpdq.pojo.Medicine;
import com.vpdq.pojo.Unit;
import com.vpdq.service.EmployeeService;
import com.vpdq.pojo.Customer;
import com.vpdq.pojo.Medicine;
import com.vpdq.pojo.OnCall;
import com.vpdq.service.AdminService;
import com.vpdq.pojo.Prescription;
import com.vpdq.service.AppointmentService;
import com.vpdq.service.CustomerService;
import com.vpdq.service.MedicalRecordService;
import com.vpdq.service.MedicineService;
import com.vpdq.service.OnCallService;
import com.vpdq.service.PrescriptionService;
import com.vpdq.utils.Search;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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

    @Autowired
    private AppointmentService appointmentService;
    
    @Autowired
    private MedicalRecordService medicalRecordService;

//  API-Que
    @GetMapping("/medicines")
    public ResponseEntity<List<Object[]>> listMedicine() {
        //api/medicines lấy danh sách thuốc phục vụ cho admin/medicines
        if (Search.getParam().isEmpty() == false) {
            return new ResponseEntity<>(this.medicineService.getMedicines(Search.getParam(), 0), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(this.medicineService.getMedicines(null, 0), HttpStatus.OK);
        }
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

    @GetMapping("/employeesOncall")
    public ResponseEntity<List<Object[]>> listEmployeeOncall() {
        return new ResponseEntity<>(this.employeeServic.getEmployeeOnCall(null, 0), HttpStatus.OK);
    }

    @DeleteMapping("/employeesManager/{employeeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable(value = "employeeId") int employeeId) {
        this.employeeServic.deleteEmployee(employeeId);
    }

    @GetMapping("/adminsManager")
    public ResponseEntity<List<Object[]>> listAdmin() {
        return new ResponseEntity<>(this.adminService.getAllAdmin(), HttpStatus.OK);
    }

    @DeleteMapping("/adminsManager/{adminId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAdmin(@PathVariable(value = "adminId") int adminId) {
        this.adminService.deleteAdmin(adminId);
    }

//    @GetMapping("/medicine/{mID}")
//    public Medicine getMedicine(@PathVariable(value = "mID") int id) {
//        return medicineService.getMedicineByID(id);
//    }
    @GetMapping("/customersManager")
    public ResponseEntity<List<Customer>> listCustomer() {
        return new ResponseEntity<>(this.customerService.getCustomer(null, 0), HttpStatus.OK);
    }

    //DANH SÁCH PHIẾU ĐẶT
    @GetMapping("/appointment")
    public ResponseEntity<List<Object[]>> listAppointment(HttpSession session, Model model) {
        //nếu là bệnh nhân, lấy api theo ID bệnh nhân
        
        if (Search.getIdCus() != 0)
            return new ResponseEntity<>(this.appointmentService.getAppointment(Search.getIdCus()), HttpStatus.OK);
        

        Employee e = (Employee) session.getAttribute("currentUser");

        if (e.getPositionId().getId() == 1) {
            return new ResponseEntity<>(this.appointmentService.getAppointment(-1), HttpStatus.OK);
        }  //nếu là y tá thì nạp phiếu có trạng thái chưa xác nhận
        if (e.getPositionId().getId() == 2) {
            return new ResponseEntity<>(this.appointmentService.getAppointment(0), HttpStatus.OK);
        }

        return new ResponseEntity<>(this.appointmentService.getAppointment(0), HttpStatus.OK);
    }

    //HUỶ PHIẾU ĐẶT KHÁM
    @DeleteMapping("/appointment/{aId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAppointment(@PathVariable(value = "aId") int aId) {
        this.appointmentService.deleteAppointment(aId);
    }

    //------------------ONCALL-------------------------
    @Autowired
    private OnCallService onCallService;

    @DeleteMapping("/onCallManager/{onCallId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOncall(@PathVariable(value = "onCallId") int onCallId) {
        this.onCallService.deleteOnCall(onCallId);
    }

    @GetMapping("/onCallManager")
    public ResponseEntity<List<Object[]>> listOnCall() {
        return new ResponseEntity<>(this.onCallService.getOnCallView(null, 0), HttpStatus.OK);
    }

    @GetMapping("/medi")
    public ResponseEntity<List<Object[]>> listMedi() {
        return new ResponseEntity<>(this.medicalRecordService.getMedicalRecordForPayment(), HttpStatus.OK);
    }
    
    
    @GetMapping("/medical")
    public ResponseEntity<List<Object[]>> medical() {
        return new ResponseEntity<>(this.medicalRecordService.getMedicalRecordForPaymentByID(43),HttpStatus.OK);
    }

}
