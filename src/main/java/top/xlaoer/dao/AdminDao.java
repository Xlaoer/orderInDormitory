package top.xlaoer.dao;

import top.xlaoer.pojo.Admin;
import top.xlaoer.pojo.Student;

import java.util.List;

/**
 * @author Xlaoer
 * @date 2022/5/19 14:54
 */
public interface AdminDao {
    List<Admin> findAdminByName(String name);
}
