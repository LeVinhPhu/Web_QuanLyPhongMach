/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vpdq.service;

import com.vpdq.pojo.Admin;
import com.vpdq.pojo.Customer;
import com.vpdq.pojo.Employee;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author vinhp
 */
public interface UserService extends UserDetailsService{
    Employee getEmployeeByUsername(String username);
    Admin getAdminByUsername(String username);
    Customer getCustomerUsername(String username);
}
