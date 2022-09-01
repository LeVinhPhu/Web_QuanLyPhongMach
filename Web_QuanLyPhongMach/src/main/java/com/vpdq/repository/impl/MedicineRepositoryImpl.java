/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.repository.impl;

import com.vpdq.pojo.Medicine;
import com.vpdq.pojo.Unit;
import com.vpdq.repository.MedicineRepository;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import javax.persistence.criteria.Root;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author phamt
 */
@Repository
@PropertySource("classpath:messages.properties")
@Transactional
public class MedicineRepositoryImpl implements MedicineRepository {
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private Environment env;
    
    @Override
    public List<Object[]> getMedicines(Map<String, String> params, int page) {
        //sử dụng api để lấy thuốc
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root<Medicine> mRoot = q.from(Medicine.class);
        Root<Unit> uRoot = q.from(Unit.class);
        q.where(b.equal(mRoot.get("unitId"), uRoot.get("id")));
        
        q.multiselect(mRoot.get("id"), mRoot.get("name"), mRoot.get("quantity"), mRoot.get("unitPrice"), uRoot.get("name"));

        //sap xep thuoc theo ten
        q.orderBy(b.asc(mRoot.get("name")));
        
        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

//            String kw = params.get("kw");
//            if (kw != null && !kw.isEmpty()) {
//                Predicate p = b.like(mRoot.get("name").as(String.class), String.format("%%%s%%", kw));
//                predicates.add(p);
//            }
//
//            String fp = params.get("fromPrice");
//            if (fp != null) {
//                Predicate p = b.greaterThanOrEqualTo(mRoot.get("unitPrice").as(Long.class), Long.parseLong(fp));
//                predicates.add(p);
//            }
//
//            String tp = params.get("toPrice");
//            if (tp != null) {
//                Predicate p = b.lessThanOrEqualTo(mRoot.get("unitPrice").as(Long.class), Long.parseLong(tp));
//                predicates.add(p);
//            }
//            String mediId = params.get("mediId");
//            if (mediId != null) {
//                Predicate p = b.equal(mRoot.get("categoryId"), Integer.parseInt(mediId));
//                predicates.add(p);
//            }
            q.where(predicates.toArray(Predicate[]::new));
        }
        
        Query<Object[]> query = session.createQuery(q);
        
        if (page > 0) {
            int size = Integer.parseInt(env.getProperty("page.size").toString());
            int start = (page - 1) * size;
            query.setFirstResult(start);
            query.setMaxResults(size);
        }
        
        return query.getResultList();
    }

//     public List<Object[]> getMedicines2(Map<String, String> params, int page) {
//        //sử dụng api để lấy thuốc
//        Session session = this.sessionFactory.getObject().getCurrentSession();
//        CriteriaBuilder b = session.getCriteriaBuilder();
//        CriteriaQuery<Object[]> q = b.createQuery(Medicine.class);
//        Root root = q.from(Medicine.class);
//     
//        if (params != null) {
//            List<Predicate> predicates = new ArrayList<>();
//            String kw = params.get("kw");
//            if (kw != null && !kw.isEmpty()) {
//                Predicate p = b.like(root.get("name").as(String.class), String.format("%%%s%%", kw));
//                predicates.add(p);
//            }
//
//                String fp = params.get("fromPrice");
//                if (fp != null) {
//                    Predicate p = b.greaterThanOrEqualTo(root.get("unitPrice").as(Long.class), Long.parseLong(fp));
//                    predicates.add(p);
//                }
//
//                String tp = params.get("toPrice");
//                if (tp != null) {
//                    Predicate p = b.lessThanOrEqualTo(root.get("unitPrice").as(Long.class), Long.parseLong(tp));
//                    predicates.add(p);
//                }
//                String mediId = params.get("mediId");
//                if (mediId != null) {
//                    Predicate p = b.equal(root.get("categoryId"), Integer.parseInt(mediId));
//                    predicates.add(p);
//                }
//                
//            q.where(predicates.toArray(Predicate[]::new));
//        }
//
//        Query<Object[]> query = session.createQuery(q);
//
//            if (page > 0) {
//                int size = Integer.parseInt(env.getProperty("page.size").toString());
//                int start = (page - 1) * size;
//                query.setFirstResult(start);
//                query.setMaxResults(size);
//            }
//        return query.getResultList();
//    }
    @Override
    public boolean deleteMedicine(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        try {
            Medicine m = session.get(Medicine.class, id);
            session.delete(m);
            
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean addMedicine(Medicine m) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        try {
            session.save(m);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    @Override
    public List<Medicine> getMedicines2(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Medicine> q = b.createQuery(Medicine.class);
        Root root = q.from(Medicine.class);
        q.select(root);
        
        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            q.where(predicates.toArray(Predicate[]::new));
        }
        
        Query query = session.createQuery(q);
        if (page > 0) {
            int size = Integer.parseInt(env.getProperty("page.size").toString());
            int start = (page - 1) * size;
            query.setFirstResult(start);
            query.setMaxResults(size);
            
        }
        
        return query.getResultList();
    }
    
    @Override
    public Medicine getMedicineByID(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        
        CriteriaQuery<Medicine> query = builder.createQuery(Medicine.class);
        Root<Medicine> root = query.from(Medicine.class);
        query.select(root);
        query.where(builder.equal(root.get("id"), id));
        Medicine m = session.createQuery(query).uniqueResult();
        
        return m;
    }

//    @Override
//    public void updateMedicineByID(int id, String name) {
//        Session session = this.sessionFactory.getObject().getCurrentSession();
//        Medicine m = getMedicineByID(id);
////        m.setName(name);
//        session.evict(m);
////        Medicine m = new Medicine();
////        m.setName("zzz");
////        m.setQuantity(id);
//        m.setName(name);
//        session.save(m);
//    }
    @Override
    public boolean updateMedicineByID(int id, Medicine medicine) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Medicine m = getMedicineByID(id);
        m.setName(medicine.getName());
        m.setQuantity(medicine.getQuantity());
        m.setUnitPrice(medicine.getUnitPrice());
        m.setUnitId(medicine.getUnitId());
        m.setSupplierId(medicine.getSupplierId());
        m.setNote(medicine.getNote());
        try {
            session.saveOrUpdate(m);
          return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
}

