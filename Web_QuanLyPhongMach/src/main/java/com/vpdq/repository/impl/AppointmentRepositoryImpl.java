/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.repository.impl;

import com.vpdq.pojo.Appointment;
import com.vpdq.pojo.Customer;
import com.vpdq.pojo.Status;
import com.vpdq.repository.AppointmentRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
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

        try
        {
            session.save(a);
            return true;
        } catch (HibernateException ex)
        {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public List<Object[]> getAppointment(float idCus) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root<Appointment> aRoot = q.from(Appointment.class);
        Root<Status> sRoot = q.from(Status.class);
        Root<Customer> cRoot = q.from(Customer.class);

        q.where(b.equal(aRoot.get("customerId"), cRoot.get("id")),
                b.equal(aRoot.get("statusId"), sRoot.get("id")),
                b.equal(aRoot.get("statusId"), 1));

        if (idCus < 0) {
            q.where(b.equal(aRoot.get("customerId"), cRoot.get("id")),
                b.equal(aRoot.get("statusId"), sRoot.get("id")),
                b.equal(aRoot.get("statusId"), 2));
        }
        
        if (idCus > 0) {
            q.where(b.equal(aRoot.get("customerId"), cRoot.get("id")),
                b.equal(aRoot.get("statusId"), sRoot.get("id")),
                b.equal(cRoot.get("id"), idCus));
        }
        
        q.multiselect(aRoot.get("id"),
                aRoot.get("date"),
                aRoot.get("time"),
                aRoot.get("note"),
                cRoot.get("id"),
                cRoot.get("firstName"),
                cRoot.get("lastName"),
                sRoot.get("id"),
                sRoot.get("name"));
        
        Query<Object[]> query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public boolean deleteAppointment(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            Appointment a = session.get(Appointment.class, id);
            session.delete(a);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
