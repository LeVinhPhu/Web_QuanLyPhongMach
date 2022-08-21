package com.vpdq.service.impl;

import com.vpdq.pojo.Position;
import com.vpdq.repository.PositionRepository;
import com.vpdq.service.PositionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vinhp
 */
@Service
public class PositionServiceImpl implements PositionService{
    // lien ket voi Repository
    @Autowired
    private PositionRepository positionRepository;

    @Override
    public List<Position> getPosition() {
        return this.positionRepository.getPosition();
    }
    
}
