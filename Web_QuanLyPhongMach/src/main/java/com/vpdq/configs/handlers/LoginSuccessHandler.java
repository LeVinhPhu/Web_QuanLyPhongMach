/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.configs.handlers;

import com.vpdq.pojo.Admin;
import com.vpdq.pojo.Customer;
import com.vpdq.pojo.Employee;
import com.vpdq.rolestatic.UserRole;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import com.vpdq.service.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author vinhp
 */
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserService userDetailsService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse respones, Authentication a) throws IOException, ServletException {
        //lay user
        if (UserRole.getRole().equals("roleAdmin")) {
            Admin adm = this.userDetailsService.getAdminByUsername(a.getName());
            request.getSession().setAttribute("currentUser", adm);
            respones.sendRedirect("/Web_QuanLyPhongMach/admins/adminIndex");
        }

        if (UserRole.getRole().equals("roleDoctor")) {
            Employee e_doctor = this.userDetailsService.getEmployeeByUsername(a.getName());
            request.getSession().setAttribute("currentUser", e_doctor);
            respones.sendRedirect("/Web_QuanLyPhongMach/employees/doctorsIndex");
        }

        if (UserRole.getRole().equals("roleNurse")) {
            Employee e_nurse = this.userDetailsService.getEmployeeByUsername(a.getName());
            request.getSession().setAttribute("currentUser", e_nurse);
            respones.sendRedirect("/Web_QuanLyPhongMach/employees/nursesIndex");
        }

        if (UserRole.getRole().equals("roleCustomer")) {
            Customer c = this.userDetailsService.getCustomerUsername(a.getName());
            request.getSession().setAttribute("currentUser", c);
            respones.sendRedirect("/Web_QuanLyPhongMach/customers/customersIndex");
        }
    }
}
