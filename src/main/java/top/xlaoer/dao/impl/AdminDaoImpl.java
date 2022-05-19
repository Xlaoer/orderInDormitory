package top.xlaoer.dao.impl;

import top.xlaoer.dao.AdminDao;
import top.xlaoer.pojo.Admin;
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
 * @date 2022/5/19 15:01
 */
public class AdminDaoImpl implements AdminDao {
    @Override
    public List<Admin> findAdminByName(String aname) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from admin where name = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Admin> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, aname);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String password = resultSet.getString(3);
                String telephone = resultSet.getString(4);
                list.add(new Admin(id, name, password, telephone));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list;
    }
}
