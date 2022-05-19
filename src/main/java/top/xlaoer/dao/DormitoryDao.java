package top.xlaoer.dao;

import top.xlaoer.pojo.Dormitory;

import java.util.List;

/**
 * @author Xlaoer
 * @date 2022/5/19 12:26
 */
public interface DormitoryDao {
    Dormitory findDomitoryById(int id);

    List<Dormitory> findDomitoryByName(String name);

    int insertDomitory(Dormitory dormitory);

    List<Dormitory> listAll();
}
