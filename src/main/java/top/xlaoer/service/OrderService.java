package top.xlaoer.service;

import top.xlaoer.dao.OrderDao;
import top.xlaoer.dao.impl.OrderDaoImpl;
import top.xlaoer.pojo.Order;

import java.util.List;

/**
 * @author Xlaoer
 * @date 2022/5/19 9:54
 */
public class OrderService {
    private OrderDao orderDao = new OrderDaoImpl();

    public List<Order> listAll(){
        return orderDao.list();
    }

    public int addOrder(Order order){
        return orderDao.insertOrder(order);
    }

    public List<Order> findOrderLikeName(String username){
        return orderDao.findOrderLikeName(username);
    }

    public List<Order> findOrderLikeDomitory(String domitoryname){
        return orderDao.findOrderLikeDomitory(domitoryname);
    }

    public List<Order> findOrderLikeDate(String date){
        return orderDao.findOrderLikeDate(date);
    }

    public int deleteOrderById(int id){
        return orderDao.deleteOrderById(id);
    }

    public List<Order> findOrderByStatus(int status) {
        return orderDao.findOrderByStatus(status);
    }

    public int okOrderById(int id){
        return orderDao.okOrderById(id);
    }
}
