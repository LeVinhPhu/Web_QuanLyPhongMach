/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.service.impl;

import com.vpdq.pojo.Admin;
import com.vpdq.repository.AdminRepository;
import com.vpdq.service.AdminService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vinhp
 */
@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminRepository adminRepository;
 
    @Override
    public int countAdmin() {
        return this.adminRepository.countAdmin();
    }

    @Override
    public boolean addAdmin(Admin adm) {
        // Cần xữ lý
        adm.setImage("https://res.cloudinary.com/vinhphuvtv2/image/upload/v1661085367/Web_QLPM/Avatar/360_F_259394679_GGA8JJAEkukYJL9XXFH2JoC3nMguBPNH_q8wpm9.jpg");
        return this.adminRepository.addAdmin(adm);
    }

    @Override
    public boolean updateAdmin(int id, Admin adm) {
        return this.adminRepository.updateAdmin(id, adm);
    }

    @Override
    public boolean deleteAdmin(int adminId) {
        //Xữ lý việc ràng buộc
        return this.adminRepository.deleteAdmin(adminId);
    }

    @Override
    public List<Object[]> countAdminByCate() {
        return null;
    }

    @Override
    public Admin getAdminByID(int id) {
        return this.adminRepository.getAdminByID(id);
    }

    @Override
    public Admin getAdminByUsername(String username) {
        return this.adminRepository.getAdminByUsername(username);
    }

    @Override

    public boolean updateImageAdmin(int id, String image) {
        return this.adminRepository.updateImageAdmin(id, image);

    public List<Object[]> getAllAdmin() {
        return this.adminRepository.getAllAdmin();

    }
    
}
