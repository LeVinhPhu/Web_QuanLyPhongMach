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
        return 0;
    }

    @Override
    public boolean addEmployee(Employee e) {
        //cần xử lý việc lấy ảnh
        e.setImage("https://res.cloudinary.com/vinhphuvtv2/image/upload/v1661085367/Web_QLPM/Avatar/360_F_259394679_GGA8JJAEkukYJL9XXFH2JoC3nMguBPNH_q8wpm9.jpg");
        return this.employeeRepository.addEmployee(e);
    }

    @Override
    public boolean deleteEmployee(int employeeId) {
        //Xữ lý việc ràng buộc
        
        return this.employeeRepository.deleteEmployee(employeeId);
    }

    @Override
    public List<Object[]> countEmployeeByCate() {
        return null;
    }

    @Override
    public Employee getEmployeeByID(int id) {
        return this.employeeRepository.getEmployeeByID(id);
    }

    @Override
    public boolean updateEmployee(Employee e) {
        return this.employeeRepository.updateEmployee(e);
    }
}
