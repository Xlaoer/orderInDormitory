package top.xlaoer.dao.impl;

import top.xlaoer.dao.DormitoryDao;
import top.xlaoer.pojo.Dormitory;
import top.xlaoer.pojo.Order;
import top.xlaoer.pojo.Student;
import top.xlaoer.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Xlaoer
 * @date 2022/5/19 12:27
 */
public class DormitoryDaoImpl implements DormitoryDao {
    @Override
    public Dormitory findDomitoryById(int did) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from dormitory where id = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Dormitory dormitory = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, did);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                dormitory = new Dormitory(id, name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return dormitory;
    }

    @Override
    public List<Dormitory> findDomitoryByName(String dname) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from dormitory where name = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Dormitory dormitory = null;
        List<Dormitory> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, dname);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                dormitory = new Dormitory(id, name);
                list.add(dormitory);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public int insertDomitory(Dormitory dormitory) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "insert into dormitory(name)values(?)";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, dormitory.getName());
            result = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, null);
        }
        return result;
    }

    @Override
    public List<Dormitory> listAll() {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from dormitory";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Dormitory dormitory = null;
        List<Dormitory> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                dormitory = new Dormitory(id, name);
                list.add(dormitory);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list;
    }
}
