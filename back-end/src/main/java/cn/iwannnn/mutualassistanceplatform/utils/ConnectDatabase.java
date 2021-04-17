package cn.iwannnn.mutualassistanceplatform.utils;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class ConnectDatabase {
    public static String url = "jdbc:mysql://localhost:3306/mutualassistanceplatform?useUnicode=true&characterEncoding=utf8&useSSL=true";
    public static String username = "iwan";
    public static String password = "123456";

    public static String getFromDatabase(String cmd) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(cmd);
        String res = resultSet.toString();
        resultSet.close();
        statement.close();
        connection.close();
        return res.toString();
    }

    public static void saveIntoDatabase(String cmd) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        statement.executeQuery(cmd);
        statement.close();
        connection.close();
    }
}
