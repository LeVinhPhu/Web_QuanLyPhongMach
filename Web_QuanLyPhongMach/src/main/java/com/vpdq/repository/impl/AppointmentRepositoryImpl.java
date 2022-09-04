/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.repository.impl;

import com.vpdq.pojo.Appointment;
import com.vpdq.pojo.Customer;
import com.vpdq.pojo.Status;
import com.vpdq.repository.AppointmentRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author phamt
 */
@Repository
@Transactional
public class AppointmentRepositoryImpl implements AppointmentRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public boolean addAppointment(Appointment a) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Status s = new Status();
        s.setId(1);
        a.setStatusId(s);
        
        try {
            session.save(a);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        } 
        return false;
    }
    
}
