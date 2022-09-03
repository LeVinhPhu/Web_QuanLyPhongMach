/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.repository.impl;

import com.vpdq.pojo.Medicine;
import com.vpdq.pojo.Prescription;
import com.vpdq.pojo.Unit;
import com.vpdq.repository.PrescriptionRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
public class PrescriptionRepositoryImpl implements PrescriptionRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Object[]> getPrescription() {
        //sử dụng api 
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root pRoot = q.from(Prescription.class);
        Root<Medicine> mRoot = q.from(Medicine.class);
        
        q.where(b.equal(mRoot.get("id"), pRoot.get("medicineId")));
        
        q.multiselect(mRoot.get("id"), mRoot.get("name"));
        
        Query<Object[]> query = session.createQuery(q);
        return query.getResultList();
        
    }

}
