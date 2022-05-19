package top.xlaoer.dao;

import top.xlaoer.pojo.Order;

import java.util.List;

/**
 * @author Xlaoer
 * @date 2022/5/19 9:58
 */
public interface OrderDao {
    List<Order> list();

    int insertOrder(Order order);

    List<Order> findOrderLikeName(String username);

    List<Order> findOrderLikeDomitory(String domitoryname);

    List<Order> findOrderLikeDate(String Date);

    int deleteOrderById(int id);

    List<Order> findOrderByStatus(int status);

    int okOrderById(int id);
}
