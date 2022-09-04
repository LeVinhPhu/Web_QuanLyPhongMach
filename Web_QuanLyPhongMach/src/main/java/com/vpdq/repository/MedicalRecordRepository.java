/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vpdq.repository;

import com.vpdq.pojo.MedicalRecord;
import java.util.List;
import java.util.Map;

/**
 *
 * @author phamt
 */
public interface MedicalRecordRepository {
//    List<Object[]> revenueStatistics();
    List<Object[]> totalRevenueStatistics();
    List<Object[]> revenueStatistics();
    List<Object[]> revenueStatisticsByMonth(int year);
    List<Object[]> revenueStatisticsByQuarter(int year);
    boolean addMedicalRecord (MedicalRecord m);
}
