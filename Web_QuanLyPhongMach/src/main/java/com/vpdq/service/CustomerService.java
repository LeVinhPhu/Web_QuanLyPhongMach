/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vpdq.service;

import com.vpdq.pojo.Customer;
import java.util.List;
//import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author phamt
 */
//extends UserDetailsService 
public interface CustomerService {
    boolean addCustomer(Customer c);
//    Customer getCusByPhoneNumber(String phoneNumber);
    List<Customer> getAllPhoneNumber();
}
