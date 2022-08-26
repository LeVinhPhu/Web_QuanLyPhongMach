/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.repository.impl;

import com.vpdq.pojo.MedicalRecord;
import com.vpdq.pojo.Medicine;
import com.vpdq.pojo.Prescription;
import com.vpdq.repository.MedicalRecordRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
public class MedicalRecordRepositoryImpl implements MedicalRecordRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Object[]> revenueStatistics() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root mRoot = q.from(MedicalRecord.class);
        Root pRoot = q.from(Prescription.class);
        Root medicineRoot = q.from(Medicine.class);

        q.where(b.equal(pRoot.get("medicalRecordId"), mRoot.get("id")),
                b.equal(pRoot.get("medicineId"), medicineRoot.get("id")),
                b.equal(pRoot.get("medicineId"), medicineRoot.get("id")));

        q.multiselect(b.function("YEAR", Integer.class, mRoot.get("billingDate")), 
                b.sum(b.prod(pRoot.get("quantity"), medicineRoot.get("unitPrice"))));

        q.groupBy(b.function("YEAR", Integer.class, mRoot.get("billingDate")));
        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<Object[]> revenueStatisticsByQuarter(int year) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root mRoot = q.from(MedicalRecord.class);
        Root pRoot = q.from(Prescription.class);
        Root medicineRoot = q.from(Medicine.class);

        q.where(b.equal(pRoot.get("medicalRecordId"), mRoot.get("id")),
                b.equal(pRoot.get("medicineId"), medicineRoot.get("id")),
                b.equal(pRoot.get("medicineId"), medicineRoot.get("id")),
                b.equal(b.function("YEAR", Integer.class, mRoot.get("billingDate")), year));

        q.multiselect(b.function("QUARTER", Integer.class, mRoot.get("billingDate")), b.sum(b.prod(pRoot.get("quantity"), medicineRoot.get("unitPrice"))));

        q.groupBy(b.function("QUARTER", Integer.class, mRoot.get("billingDate")));
        q.orderBy(b.asc(b.function("QUARTER", Integer.class, mRoot.get("billingDate"))));
        
        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<Object[]> revenueStatisticsByMonth(int year) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root mRoot = q.from(MedicalRecord.class);
        Root pRoot = q.from(Prescription.class);
        Root medicineRoot = q.from(Medicine.class);

        q.where(b.equal(pRoot.get("medicalRecordId"), mRoot.get("id")),
                b.equal(pRoot.get("medicineId"), medicineRoot.get("id")),
                b.equal(pRoot.get("medicineId"), medicineRoot.get("id")),
                b.equal(b.function("YEAR", Integer.class, mRoot.get("billingDate")), year));

        q.multiselect(b.function("MONTH", Integer.class, mRoot.get("billingDate")), b.sum(b.prod(pRoot.get("quantity"), medicineRoot.get("unitPrice"))), b.function("YEAR", Integer.class, mRoot.get("billingDate")));

        q.groupBy(b.function("MONTH", Integer.class, mRoot.get("billingDate")));
        q.orderBy(b.asc(b.function("MONTH", Integer.class, mRoot.get("billingDate"))));
        
        Query query = session.createQuery(q);

        return query.getResultList();
    }

}
