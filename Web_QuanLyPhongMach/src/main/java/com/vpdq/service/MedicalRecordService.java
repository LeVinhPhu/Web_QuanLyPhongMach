/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vpdq.service;

import java.util.List;

/**
 *
 * @author phamt
 */
public interface MedicalRecordService {
    List<Object[]> revenueStatistics();
    List<Object[]> revenueStatisticsByMonth(int year);
    List<Object[]> revenueStatisticsByQuarter(int year);
}
