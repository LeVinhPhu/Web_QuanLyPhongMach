/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.service.impl;

import com.vpdq.pojo.Customer;
import com.vpdq.pojo.Position;
import com.vpdq.repository.CustomerRepository;
import com.vpdq.service.CustomerService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author phamt
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public boolean addCustomer(Customer c) {
        String pass = c.getPassword();
        c.setPassword(this.passwordEncoder.encode(pass));
        return this.customerRepository.addCustomer(c);
    }

//    @Override
//    public Customer getCusByPhoneNumber(String phoneNumber) {
//        return this.customerRepository.getCusByPhoneNumber(phoneNumber);
//    }

    
//    @Override
//    public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
//        Customer c = this.getCusByPhoneNumber(phoneNumber);
//        if (c == null) {
//            throw new UsernameNotFoundException("Invalid phone number");
//        }
//
//        Set<GrantedAuthority> authorities = new HashSet<>();
//
//        return new org.springframework.security.core.userdetails.User(
//                c.getPhoneNumber(), c.getPassword(), authorities);
//    }

    @Override
    public List<Customer> getAllPhoneNumber() {
        return this.customerRepository.getAllPhoneNumber();
    }

    @Override
    public boolean check(String phone) {
        return this.customerRepository.check(phone);
    }

    @Override
    public List<Object[]> patientStatistics() {
        return this.customerRepository.patientStatistics();
    }

    @Override
    public List<Object[]> patientStatisticsByYear() {
        return this.customerRepository.patientStatisticsByYear();
    }

    @Override
    public List<Object[]> patientStatisticsByQuater(int year) {
        return this.customerRepository.patientStatisticsByQuater(year);
    }

    @Override
    public List<Object[]> patientStatisticsByMonth(int year) {
        return this.customerRepository.patientStatisticsByMonth(year);
    }


}
