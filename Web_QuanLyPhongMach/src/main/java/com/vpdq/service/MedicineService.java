/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vpdq.service;

import com.vpdq.pojo.Medicine;
import java.util.List;
import java.util.Map;

/**
 *
 * @author phamt
 */

public interface MedicineService {
    List<Object[]> getMedicines(Map<String, String> params, int page);
    
    boolean deleteMedicine(int id);
    boolean addMedicine(Medicine m);
}
