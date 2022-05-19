package top.xlaoer.dao.impl;

import top.xlaoer.dao.StudentDao;
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
 * @date 2022/5/8 19:11
 */
public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> list() {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from student";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Student> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String password = resultSet.getString(3);
                String gender = resultSet.getString(4);
                String telephone = resultSet.getString(5);
                int domitoryId = resultSet.getInt(6);
                Date createDate = resultSet.getDate(7);
                int status = resultSet.getInt(8);
                list.add(new Student(id, name, password, gender, telephone,domitoryId,createDate,status));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public Student findStudentById(Integer uid) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from student where id = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Student student = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, uid);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String password = resultSet.getString(3);
                String gender = resultSet.getString(4);
                String telephone = resultSet.getString(5);
                int domitoryId = resultSet.getInt(6);
                Date createDate = resultSet.getDate(7);
                int status = resultSet.getInt(8);
                student = new Student(id, name, password, gender, telephone,domitoryId,createDate,status);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return student;
    }

    @Override
    public List<Student> findStudentByName(String uname) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from student where name = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Student> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, uname);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String password = resultSet.getString(3);
                String gender = resultSet.getString(4);
                String telephone = resultSet.getString(5);
                int domitoryId = resultSet.getInt(6);
                Date createDate = resultSet.getDate(7);
                int status = resultSet.getInt(8);
                list.add(new Student(id, name, password, gender, telephone,domitoryId,createDate,status));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public List<Student> findStudentByDormitoryId(Integer did) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from student where domitory_id = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Student> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, did);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String password = resultSet.getString(3);
                String gender = resultSet.getString(4);
                String telephone = resultSet.getString(5);
                int domitoryId = resultSet.getInt(6);
                Date createDate = resultSet.getDate(7);
                int status = resultSet.getInt(8);
                list.add(new Student(id, name, password, gender, telephone,domitoryId,createDate,status));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public Integer insert(Student student) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "insert into student(name,password,gender,telephone,dormitory_id,create_date,status)values(?,?,?,?,?,?,?)";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, student.getName());
            statement.setString(2, student.getPassword());
            statement.setString(3, student.getGender());
            statement.setString(4, student.getTelephone());
            statement.setInt(5, student.getDormitoryId());
            statement.setDate(6, new java.sql.Date(student.getCreateDate().getTime()));
            statement.setInt(7, student.getStatus());
            result = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, null);
        }
        return result;
    }

    @Override
    public Integer updateStudent(Student student) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "update student set name = ?,password = ?,gender = ?,telephone = ?,domitoryId = ?,status=? where id = ?";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, student.getName());
            statement.setString(2, student.getPassword());
            statement.setString(3, student.getGender());
            statement.setString(4, student.getTelephone());
            statement.setInt(5, student.getDormitoryId());
            statement.setInt(6, student.getStatus());
            statement.setInt(7, student.getId());
            result = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, null);
        }
        return result;
    }

    @Override
    public Integer updateStatusById(Integer id, Integer status) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "update student set status=? where id = ?";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, status);
            statement.setInt(2, id);
            result = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, null);
        }
        return result;
    }
}
