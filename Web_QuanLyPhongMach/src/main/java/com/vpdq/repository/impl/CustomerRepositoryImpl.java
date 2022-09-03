/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.repository.impl;

import com.vpdq.pojo.Customer;
import com.vpdq.pojo.MedicalRecord;
import com.vpdq.pojo.Medicine;
import com.vpdq.pojo.Prescription;
import com.vpdq.pojo.Unit;
import com.vpdq.repository.CustomerRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
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

    @Override
    public List<Customer> getAllPhoneNumber() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();

        CriteriaQuery<Customer> q = b.createQuery(Customer.class);
        Root root = q.from(Customer.class);
        q.select(root);

        q.select(root.get("phoneNumber"));

        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public boolean check(String phone) {
        boolean kq = false;
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();

        CriteriaQuery<Customer> q = b.createQuery(Customer.class);
        Root root = q.from(Customer.class);
        q.where(b.equal(root.get("phoneNumber"), phone));
        q.select(root);
        if (root.get("phoneNumber").equals(phone)) {
            kq = true;
        }
        return kq;
    }

    @Override

    public boolean updateCustomer(Customer e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean deleteCustomer(int customerId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Object[]> countEmployeeByCate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Customer getCustomerID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override // username là phone number
    public Customer getCustomerByUsername(String username) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Customer> q = b.createQuery(Customer.class);
        Root root = q.from(Customer.class);
        q.select(root);

        q.where(b.equal(root.get("phoneNumber"), username));

        Query query = session.createQuery(q);
        return (Customer) query.getSingleResult();
    }

    public List<Object[]> patientStatistics() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root root = q.from(MedicalRecord.class);
        q.multiselect(b.count(root.get("id")));

        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<Object[]> patientStatisticsByYear() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root root = q.from(MedicalRecord.class);

        q.multiselect(b.function("YEAR", Integer.class, root.get("billingDate")), b.count(root.get("id")));

        q.groupBy(b.function("YEAR", Integer.class, root.get("billingDate")));
        q.orderBy(b.asc(b.function("YEAR", Integer.class, root.get("billingDate"))));
        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<Object[]> patientStatisticsByQuater(int year) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root root = q.from(MedicalRecord.class);
        q.where(b.equal(b.function("YEAR", Integer.class, root.get("billingDate")), year));
        q.multiselect(b.function("QUARTER", Integer.class, root.get("billingDate")),
                b.count(root.get("id")));

        q.groupBy(b.function("QUARTER", Integer.class, root.get("billingDate")));
        q.orderBy(b.asc(b.function("QUARTER", Integer.class, root.get("billingDate"))));
        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<Object[]> patientStatisticsByMonth(int year) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root root = q.from(MedicalRecord.class);
        q.where(b.equal(b.function("YEAR", Integer.class, root.get("billingDate")), year));
        q.multiselect(b.function("MONTH", Integer.class, root.get("billingDate")),
                b.count(root.get("id")));

        q.groupBy(b.function("MONTH", Integer.class, root.get("billingDate")));
        q.orderBy(b.asc(b.function("MONTH", Integer.class, root.get("billingDate"))));
        Query query = session.createQuery(q);

        return query.getResultList();
    }

}
