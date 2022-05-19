package top.xlaoer.dao.impl;

import top.xlaoer.dao.OrderDao;
import top.xlaoer.pojo.Order;
import top.xlaoer.pojo.Student;
import top.xlaoer.util.JDBCUtil;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Xlaoer
 * @date 2022/5/19 10:06
 */
public class OrderDaoImpl implements OrderDao {
    @Override
    public List<Order> list() {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from `order`";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Order> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int studentId = resultSet.getInt(2);
                int domitoryId= resultSet.getInt(3);
                String item = resultSet.getString(4);
                int status = resultSet.getInt(5);
                Date createDate = resultSet.getDate(6);
                list.add(new Order(id, studentId, domitoryId, item, status,createDate));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public int insertOrder(Order order) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "insert into `order`(student_id,dormitory_id,item,status,create_time)values(?,?,?,?,?)";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, order.getStudentId());
            statement.setInt(2, order.getDormitoryId());
            statement.setString(3, order.getItem());
            statement.setInt(4, order.getStatus());
            statement.setDate(5, new java.sql.Date(order.getCreateTime().getTime()));
            result = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, null);
        }
        return result;
    }

    @Override
    public List<Order> findOrderLikeName(String username) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from `order` where student_id in (select id from student where name like ?)";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Order> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, "%"+username+"%");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int studentId = resultSet.getInt(2);
                int domitoryId= resultSet.getInt(3);
                String item = resultSet.getString(4);
                int status = resultSet.getInt(5);
                Date createDate = resultSet.getDate(6);
                list.add(new Order(id, studentId, domitoryId, item, status,createDate));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public List<Order> findOrderLikeDomitory(String domitoryname) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from `order` where dormitory_id in (select id from dormitory where name like ?)";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Order> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, "%"+domitoryname+"%");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int studentId = resultSet.getInt(2);
                int domitoryId= resultSet.getInt(3);
                String item = resultSet.getString(4);
                int status = resultSet.getInt(5);
                Date createDate = resultSet.getDate(6);
                list.add(new Order(id, studentId, domitoryId, item, status,createDate));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public List<Order> findOrderLikeDate(String Date) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from `order` where create_time like ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Order> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, "%"+Date+"%");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int studentId = resultSet.getInt(2);
                int domitoryId= resultSet.getInt(3);
                String item = resultSet.getString(4);
                int status = resultSet.getInt(5);
                Date createDate = resultSet.getDate(6);
                list.add(new Order(id, studentId, domitoryId, item, status,createDate));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public int deleteOrderById(int id) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "update `order` set status = 2 where id = ?";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            result = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, null);
        }
        return result;
    }

    @Override
    public int okOrderById(int id) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "update `order` set status = 1 where id = ?";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            result = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, null);
        }
        return result;
    }

    @Override
    public List<Order> findOrderByStatus(int istatus) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from `order` where status = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Order> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, istatus);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int studentId = resultSet.getInt(2);
                int domitoryId= resultSet.getInt(3);
                String item = resultSet.getString(4);
                int status = resultSet.getInt(5);
                Date createDate = resultSet.getDate(6);
                list.add(new Order(id, studentId, domitoryId, item, status,createDate));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list;
    }
}
