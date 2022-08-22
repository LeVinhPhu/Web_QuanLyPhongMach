/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.controllers;

import com.vpdq.pojo.Medicine;
import com.vpdq.pojo.Unit;
import com.vpdq.service.MedicineService;
import com.vpdq.service.UnitService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class ApiMedicineController {

    @Autowired
    private MedicineService medicineService;

    @Autowired
    private UnitService unitService;

    @GetMapping("/medicines")
        public ResponseEntity<List<Object[]>> listMedicine() {
            //api/medicines lấy danh sách thuốc phục vụ cho admin/medicines
        return new ResponseEntity<>(this.medicineService.getMedicines(null, 0), HttpStatus.OK);
    }
//    public String getM() {
//        return "medicines.jsp";
//    }



//    @GetMapping("/units")
//    public ResponseEntity<List<Unit>> list() {
//        return new ResponseEntity<>(this.unitService.getUnits(null, 0), HttpStatus.OK);
//    }
        
//    @GetMapping(value = "medicines", params = "unitName")
//    public String Unit(Unit u) {
//        return this.unitService.getUnitById(u);
//    }
    @DeleteMapping("/medicines/{medicineId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMedicine(@PathVariable(value = "medicineId") int id) {
        this.medicineService.deleteMedicine(id);
    }

}
