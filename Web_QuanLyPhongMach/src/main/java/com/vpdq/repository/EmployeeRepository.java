/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.repository;

import com.vpdq.pojo.Employee;
import java.util.List;
import java.util.Map;

/**
 *
 * @author vinhp
 */
public interface EmployeeRepository {
    
    // lien ket voi pojo
    List<Employee> getEmployee_Demo();
    
    //
    List<Employee> getEmployee(Map<String, String> params, int page);
    int countEmployee();
    boolean addEmployee(Employee p);
    boolean deleteEmployee(int productId);
    List<Object[]> countEmployeeByCate();
    List<Object[]> revenueStats(int quarter, int year);
}