/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vpdq.repository;

import com.vpdq.pojo.Admin;
import java.util.List;
import java.util.Map;

/**
 *
 * @author vinhp
 */
public interface AdminRepository {
    List<Admin> getAdmin(Map<String, String> params, int page);

    int countAdmin();

    boolean addAdmin(Admin adm);

    boolean updateAdmin(int id, Admin adm);

    boolean deleteAdmin(int adminId);

    List<Object[]> countAdminByCate();

    Admin getAdminByID(int id);

    Admin getAdminByUsername(String username);
    
    boolean updateImageAdmin(int id, String image);

    List<Object[]> getAllAdmin();

}
