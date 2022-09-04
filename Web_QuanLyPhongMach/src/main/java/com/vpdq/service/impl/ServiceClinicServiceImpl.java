/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.service.impl;

import com.vpdq.repository.ServiceRepository;
import com.vpdq.service.ServiceClinicService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author phamt
 */
@Service
public class ServiceClinicServiceImpl implements ServiceClinicService {
    @Autowired
    private ServiceRepository serviceRepository;
    
    @Override
    public List<com.vpdq.pojo.Service> getService() {
        return this.serviceRepository.getService();
    }
    
}
