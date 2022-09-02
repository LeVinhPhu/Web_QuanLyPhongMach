/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.service.impl;

import com.vpdq.pojo.Employee;
import com.vpdq.pojo.Position;
import com.vpdq.repository.EmployeeRepository;
import com.vpdq.service.EmployeeLoginService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author vinhp
 */
@Service("UserDetailsService")
public class EmployeeLoginServiceImpl implements EmployeeLoginService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee getEmployeeByUsername(String username) {
        return this.employeeRepository.getEmployeeByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee e = employeeRepository.getEmployeeByUsername(username);
        if (e == null) {
            throw new UsernameNotFoundException("Không tồn tại!");
        }
        Position p = e.getPositionId();
        
        
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(p.getId().toString()));
        return new org.springframework.security.core.userdetails.User(
                e.getUsername(), e.getPassword(), authorities);
    }

}
