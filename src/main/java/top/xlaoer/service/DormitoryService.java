package top.xlaoer.service;

import top.xlaoer.dao.DormitoryDao;
import top.xlaoer.dao.impl.DormitoryDaoImpl;
import top.xlaoer.pojo.Dormitory;

import java.util.List;

/**
 * @author Xlaoer
 * @date 2022/5/19 12:29
 */
public class DormitoryService {
    private DormitoryDao dormitoryDao = new DormitoryDaoImpl();

    public Dormitory findDomitoryById(int id){
        return dormitoryDao.findDomitoryById(id);
    }

    public List<Dormitory> findDomitoryByName(String name){
        return dormitoryDao.findDomitoryByName(name);
    }

    public List<Dormitory> listAll(){
        return dormitoryDao.listAll();
    }

    public int addDormitory(Dormitory dormitory) {
        return dormitoryDao.insertDomitory(dormitory);
    }
}
