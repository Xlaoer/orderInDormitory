package top.xlaoer.service;

import top.xlaoer.dao.AdminDao;
import top.xlaoer.dao.impl.AdminDaoImpl;
import top.xlaoer.pojo.Admin;
import top.xlaoer.pojo.Student;

import java.util.List;

/**
 * @author Xlaoer
 * @date 2022/5/19 15:03
 */
public class AdminService {
    private AdminDao adminDao = new AdminDaoImpl();

    public Admin login(String name, String password){
        List<Admin> adminByName = adminDao.findAdminByName(name);
        if(adminByName==null||adminByName.isEmpty())return null;
        for(Admin admin:adminByName){
            if(admin.getPassword().equals(password)){
                return admin;
            }
        }
        return null;
    }
}
