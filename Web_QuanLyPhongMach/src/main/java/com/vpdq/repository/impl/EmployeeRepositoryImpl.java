/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.repository.impl;

import com.vpdq.pojo.Employee;
import com.vpdq.repository.EmployeeRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vinhp
 */
@Repository
@Transactional
@PropertySource("classpath:messages.properties")
public class EmployeeRepositoryImpl implements EmployeeRepository {

    // lien ket voi pojo
    // Tang duy nhat duoc @Autowired voi CSDL
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Autowired
    private Environment env;

    @Override
    public List<Employee> getEmployee_Demo() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Employee");
        return q.getResultList();
    }
    // 

    @Override
    public List<Employee> getEmployee(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Employee> q = b.createQuery(Employee.class);
        Root root = q.from(Employee.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            
            //Tìm theo tên
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate pfn = b.like(root.get("first_name").as(String.class), String.format("%%%s%%", kw));
                predicates.add(pfn);

                Predicate pln = b.like(root.get("last_name").as(String.class), String.format("%%%s%%", kw));
                if (!pfn.equals(pln)) {
                    predicates.add(pln);
                }
                
            }

            //Tìm theo ngày sinh
            String fdate = params.get("fromDate");
            if (fdate != null) {
                Predicate p = b.greaterThanOrEqualTo(root.get("dateOfBirth").as(Date.class), Date.parse(fdate));
                predicates.add(p);
            }

            String tdate = params.get("toDate");
            if (tdate != null) {
                Predicate p = b.greaterThanOrEqualTo(root.get("dateOfBirth").as(Date.class), Date.parse(tdate));
                predicates.add(p);
            }

            
            //Tìm theo posision
            String cateId = params.get("cateId");
            if (cateId != null) {
                Predicate p = b.equal(root.get("categoryId"), Integer.parseInt(cateId));
                predicates.add(p);
            }

            q.where(predicates.toArray(Predicate[]::new));
        }

        q.orderBy(b.desc(root.get("id")));

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
    public int countEmployee() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addEmployee(Employee p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean deleteEmployee(int productId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Object[]> countEmployeeByCate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Object[]> revenueStats(int quarter, int year) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
