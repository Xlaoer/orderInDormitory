package top.xlaoer.util;

import java.sql.*;

/**
 * @author Xlaoer
 * @date 2022/5/8 19:12
 */
public class JDBCUtil {
    private static String driverName = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/orderindormitory";
    private static String user = "root";
    private static String password = "123456";


    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void release(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if(connection != null){
                connection.close();
            }
            if(statement != null){
                statement.close();
            }
            if(resultSet != null){
                resultSet.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
