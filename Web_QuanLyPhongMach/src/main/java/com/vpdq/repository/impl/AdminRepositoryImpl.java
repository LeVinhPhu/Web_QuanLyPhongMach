/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.repository.impl;

import com.vpdq.pojo.Admin;
import com.vpdq.repository.AdminRepository;
import java.util.ArrayList;
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
public class AdminRepositoryImpl implements AdminRepository {

    // lien ket voi pojo
    // Tang duy nhat duoc @Autowired voi CSDL
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Autowired
    private Environment env;
    
    

    @Override
    public int countAdmin() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addAdmin(Admin adm) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(adm);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateAdmin(int id, Admin adm) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Admin admnew = getAdminByID(id);
        
        admnew.setFirstName(adm.getFirstName());
        admnew.setLastName(adm.getLastName());
        admnew.setDateOfBirth(adm.getDateOfBirth());
        admnew.setSex(adm.getSex());
        admnew.setAddress(adm.getAddress());
        admnew.setEmail(adm.getEmail());
        admnew.setPhone(adm.getPhone());
        admnew.setUsername(adm.getUsername());
        admnew.setPassword(adm.getPassword());
        try {
            session.saveOrUpdate(admnew);
          return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteAdmin(int adminId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            Admin adm = session.get(Admin.class, adminId);
            session.delete(adm);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }}

    @Override
    public List<Object[]> countAdminByCate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Admin getAdminByID(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        
        CriteriaQuery<Admin> query = builder.createQuery(Admin.class);
        Root<Admin> root = query.from(Admin.class);
        query.select(root);
        query.where(builder.equal(root.get("id"), id));
        Admin adm = session.createQuery(query).uniqueResult();
        
        return adm;}

    @Override
    public Admin getAdminByUsername(String username) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Admin> q = b.createQuery(Admin.class);
        Root root = q.from(Admin.class);
        q.select(root);

        q.where(b.equal(root.get("username"), username));

        Query query = session.createQuery(q);
        return (Admin) query.getSingleResult();
    }

    @Override
    public List<Admin> getAdmin(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Admin> q = b.createQuery(Admin.class);
        Root root = q.from(Admin.class);
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
            //Tìm theo posision

            q.where(predicates.toArray(Predicate[]::new));
        }

        q.orderBy(b.desc(root.get("id")));

        Query query = session.createQuery(q);

        //Phân trang
        if (page > 0) {
            int size = Integer.parseInt(env.getProperty("page.size").toString());
            int start = (page - 1) * size;
            query.setFirstResult(start);
            query.setMaxResults(size);
        }

        return query.getResultList();
    }

}
