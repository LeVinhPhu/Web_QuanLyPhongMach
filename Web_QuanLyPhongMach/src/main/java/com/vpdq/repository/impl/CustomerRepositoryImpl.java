/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.repository.impl;

import com.vpdq.pojo.Customer;
import com.vpdq.pojo.Medicine;
import com.vpdq.pojo.Unit;
import com.vpdq.repository.CustomerRepository;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author phamt
 */
@Repository
@Transactional
@PropertySource("classpath:messages.properties")
public class CustomerRepositoryImpl implements CustomerRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public boolean addCustomer(Customer c) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            session.save(c);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage()); 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

//    @Override
//    public Customer getCusByPhoneNumber(String phoneNumber) {
//        Session session = this.sessionFactory.getObject().getCurrentSession();
//        CriteriaBuilder b = session.getCriteriaBuilder();
//        
//        CriteriaQuery<Customer> q = b.createQuery(Customer.class);
//        Root<Customer> root = q.from(Customer.class);
//        q.select(root);
//        
//        q.where(b.equal(root.get("phoneNumber"), phoneNumber));
//        
//        Query query = session.createQuery(q);
//        return (Customer) query.getSingleResult();
//    }
    
}
