/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.service.impl;

import com.vpdq.pojo.Employee;
import com.vpdq.repository.EmployeeRepository;
import com.vpdq.service.EmployeeService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vinhp
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    // lien ket voi Repository
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployee_Demo() {
        return this.employeeRepository.getEmployee_Demo();
    }

    @Override
    public List<Employee> getEmployee(Map<String, String> params, int page) {
        return this.employeeRepository.getEmployee(params, page);
    }

    @Override
    public int countEmployee() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addEmployee(Employee e) {
        //cần xử lý việc lấy ảnh

        e.setImage("image");
        return this.employeeRepository.addEmployee(e);
    }

    @Override
    public boolean deleteEmployee(int employeeId) {
        //Xữ lý việc ràng buộc
        
        return this.employeeRepository.deleteEmployee(employeeId);
    }

    @Override
    public List<Object[]> countEmployeeByCate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Employee getEmployeeByID(int id) {
        return this.employeeRepository.getEmployeeByID(id);
    }
}
