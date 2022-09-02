/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vpdq.repository;

import com.vpdq.pojo.Customer;
import java.util.List;
import java.util.Map;

/**
 *
 * @author phamt
 */
public interface CustomerRepository {

    boolean addCustomer(Customer c);
//    Customer getCusByPhoneNumber(String phoneNumber);

    List<Customer> getAllPhoneNumber();

    boolean check(String phone);

    boolean updateCustomer(Customer e);

    boolean deleteCustomer(int customerId);

    List<Object[]> countEmployeeByCate();

    Customer getCustomerID(int id);

    Customer getCustomerByUsername(String username);


    List<Object[]> patientStatistics();
    List<Object[]> patientStatisticsByYear();
    List<Object[]> patientStatisticsByQuater(int year);
    List<Object[]> patientStatisticsByMonth(int year);

}
