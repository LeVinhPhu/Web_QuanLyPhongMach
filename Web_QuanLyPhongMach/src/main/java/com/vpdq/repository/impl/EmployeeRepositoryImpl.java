/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.repository.impl;

import com.vpdq.pojo.Employee;
import com.vpdq.pojo.Position;
import com.vpdq.repository.EmployeeRepository;
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
            //Tìm theo posision
            String positionId = params.get("positionId");
            if (positionId != null) {
                Predicate p = b.equal(root.get("positionId"), Integer.parseInt(positionId));
                predicates.add(p);
            }

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

    @Override
    public int countEmployee() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        org.hibernate.query.Query q = session.createQuery("SELECT COUNT(*) FROM Employee");

        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    public boolean addEmployee(Employee e) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(e);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteEmployee(int employeeId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            Employee e = session.get(Employee.class, employeeId);
            session.delete(e);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Object[]> countEmployeeByCate() {
        return null;
    }

    @Override
    public Employee getEmployeeByID(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("From Employee e WHERE e.id =: idEmpl");

        q.setParameter("idEmpl", id);
        return (Employee) q.getSingleResult();
    }

    @Override
    public boolean updateEmployee(int id, Employee e) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Employee enew = getEmployeeByID(id);

        enew.setPositionId(e.getPositionId());
        enew.setFirstName(e.getFirstName());
        enew.setLastName(e.getLastName());
        enew.setDateOfBirth(e.getDateOfBirth());
        enew.setSex(e.getSex());
        enew.setAddress(e.getAddress());
        enew.setEmail(e.getEmail());
        enew.setPhone(e.getPhone());
        enew.setSpecialize(e.getSpecialize());
        enew.setUsername(e.getUsername());
        enew.setPassword(e.getPassword());
        try {
            session.saveOrUpdate(enew);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public Employee getEmployeeByUsername(String username) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Employee> q = b.createQuery(Employee.class);
        Root root = q.from(Employee.class);
        q.select(root);

        q.where(b.equal(root.get("username"), username));

        Query query = session.createQuery(q);
        return (Employee) query.getSingleResult();
    }

    @Override
    public boolean updateImageEmployee(int id, String image) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Employee enew = getEmployeeByID(id);

        enew.setImage(image);
        try {
            session.saveOrUpdate(enew);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Object[]> getEmployeeOnCall(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root<Employee> eRoot = q.from(Employee.class);
        Root<Position> pRoot = q.from(Position.class);
        q.where(b.equal(eRoot.get("positionId"), pRoot.get("id")));

        q.multiselect(
                eRoot.get("id"),
                eRoot.get("firstName"),
                eRoot.get("lastName"),
                pRoot.get("name"),
                eRoot.get("phone"),
                eRoot.get("specialize"));

        q.orderBy(b.asc(eRoot.get("id")));

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw");

            if (kw != null && !kw.isEmpty()) {
                Predicate p = b.like(eRoot.get("lastName").as(String.class), String.format("%%%s%%", kw));
                Predicate p2 = b.equal(eRoot.get("positionId"), pRoot.get("id"));
                q = q.where(b.and(p, p2));
            }
        }

        Query<Object[]> query = session.createQuery(q);

        return query.getResultList();
    }

}
