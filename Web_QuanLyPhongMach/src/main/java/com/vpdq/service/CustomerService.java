/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vpdq.service;

import com.vpdq.pojo.Customer;
import java.util.List;
import java.util.Map;
//import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author phamt
 */
//extends UserDetailsService 
public interface CustomerService {

    boolean addCustomer(Customer c);

    boolean updateCustomer(int id, Customer c);
    
    boolean updateImageCustomer(int id, String image);

    boolean deleteCustomer(int customerId);
    
    Customer getCustomerByID(int id);

    List<Customer> getAllPhoneNumber();

    boolean check(String phone);

    List<Object[]> patientStatistics();

    List<Object[]> patientStatisticsByYear();

    List<Object[]> patientStatisticsByQuater(int year);

    List<Object[]> patientStatisticsByMonth(int year);

    List<Customer> getCustomer(Map<String, String> params, int page);


}
