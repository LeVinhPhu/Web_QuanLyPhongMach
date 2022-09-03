/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.service.impl;

import com.vpdq.pojo.Admin;
import com.vpdq.pojo.Customer;
import com.vpdq.pojo.Employee;
import com.vpdq.repository.AdminRepository;
import com.vpdq.repository.CustomerRepository;
import com.vpdq.repository.EmployeeRepository;
import com.vpdq.rolestatic.UserRole;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.vpdq.service.UserService;

/**
 *
 * @author vinhp
 */
@Service("UserDetailsService")
public class UserServiceImpl implements UserService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Employee getEmployeeByUsername(String username) {
        return this.employeeRepository.getEmployeeByUsername(username);
    }

    @Override
    public Admin getAdminByUsername(String username) {
        return this.adminRepository.getAdminByUsername(username);
    }

    @Override
    public Customer getCustomerUsername(String username) {
        return this.customerRepository.getCustomerByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //Phân quyền user
        String role = "";
        role = UserRole.getRole();
        switch (role) {
            case "roleAdmin": {
                Admin adm = adminRepository.getAdminByUsername(username);
                if (adm == null) {
                    throw new UsernameNotFoundException("Không tồn tại!");
                }

                Set<GrantedAuthority> authorities = new HashSet<>();
                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                return new org.springframework.security.core.userdetails.User(
                        adm.getUsername(), adm.getPassword(), authorities);
            }

            case "roleDoctor": {
                Employee e_doctor = employeeRepository.getEmployeeByUsername(username);
                if (e_doctor == null) {
                    throw new UsernameNotFoundException("Không tồn tại!");
                }
                Set<GrantedAuthority> authorities = new HashSet<>();
                authorities.add(new SimpleGrantedAuthority("ROLE_DOCTOR"));
                return new org.springframework.security.core.userdetails.User(
                        e_doctor.getUsername(), e_doctor.getPassword(), authorities);
            }

            case "roleNurse": {
                Employee e_nurse = employeeRepository.getEmployeeByUsername(username);
                if (e_nurse == null) {
                    throw new UsernameNotFoundException("Không tồn tại!");
                }
                Set<GrantedAuthority> authorities = new HashSet<>();
                authorities.add(new SimpleGrantedAuthority("ROLE_NURSE"));
                return new org.springframework.security.core.userdetails.User(
                        e_nurse.getUsername(), e_nurse.getPassword(), authorities);
            }

            case "roleCustomer": {
                Customer c = customerRepository.getCustomerByUsername(username);
                if (c == null) {
                    throw new UsernameNotFoundException("Không tồn tại!");
                }
                Set<GrantedAuthority> authorities = new HashSet<>();
                authorities.add(new SimpleGrantedAuthority("ROLE_CUSTOMER"));
                return new org.springframework.security.core.userdetails.User(
                        c.getPhoneNumber(), c.getPassword(), authorities);
            }

            default: {
                Set<GrantedAuthority> authorities = new HashSet<>();
                authorities.add(new SimpleGrantedAuthority("ROLE_"));
                return new org.springframework.security.core.userdetails.User(
                        null, null, authorities);
            }
        }
    }
}
