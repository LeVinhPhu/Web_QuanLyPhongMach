/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.service.impl;

import com.vpdq.repository.MedicalRecordRepository;
import com.vpdq.service.MedicalRecordService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author phamt
 */
@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {
    @Autowired
    MedicalRecordRepository medicalRecordRepository;
    
    @Override
    public List<Object[]> revenueStatistics() {
        return this.medicalRecordRepository.revenueStatistics();
    }

    @Override
    public List<Object[]> revenueStatisticsByQuarter(int quarter, int year) {
        return this.medicalRecordRepository.revenueStatisticsByQuarter(quarter, year);
    }
    
}
