/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.repository.impl;
import com.vpdq.pojo.Position;
import com.vpdq.repository.PositionRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vinhp
 */

@Repository
@Transactional
public class PositionRepositoryImpl implements PositionRepository{

    
    // lien ket voi pojo
    // Tang duy nhat duoc @Autowired voi CSDL
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Position> getPosition() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Position");
        return q.getResultList();
    }
}
