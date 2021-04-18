package cn.iwannnn.mutualassistanceplatform.utils;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class ConnectDatabase {
    private static String url = "jdbc:mysql://localhost:3306/mutualassistanceplatform?useUnicode=true&characterEncoding=utf8&useSSL=true";
    private static String username = "iwan";
    private static String password = "123456";

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static void connectDatabase() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement();
    }

    public static void disconnectDatabase() throws Exception {
        statement.close();
        connection.close();
    }

    public static String insertCmd(String table, String index, String info) {
        StringBuilder cmd = new StringBuilder("INSERT INTO `");
        cmd.append(table);
        cmd.append("` (`");
        cmd.append(index);
        cmd.append("`) VALUES ('");
        cmd.append(info);
        cmd.append("');");
        return cmd.toString();
    }

    public static void insertIntoDatabase(String table, String index, String info) throws Exception {
        String cmd = insertCmd(table, index, info);
        connectDatabase();
        statement.executeUpdate(cmd);
        System.out.println(cmd);
        disconnectDatabase();
    }

    public static String updateCmd(String table, String index, String indexInfo, String key, String keyInfo) {
        StringBuilder cmd = new StringBuilder("UPDATE `");
        cmd.append(table);
        cmd.append("` SET `");
        cmd.append(index);
        cmd.append("` = '");
        cmd.append(indexInfo);
        cmd.append("' WHERE `");
        cmd.append(key);
        cmd.append("` = '");
        cmd.append(keyInfo);
        cmd.append("';");
        return cmd.toString();
    }

    public static void updateDatabase(String table, String index, String indexInfo, String key, String keyInfo)
            throws Exception {
        String cmd = updateCmd(table, index, indexInfo, key, keyInfo);
        connectDatabase();
        statement.executeUpdate(cmd);
        disconnectDatabase();
    }

    public static String selectCmd(String index, String table, String info) {
        StringBuilder cmd = new StringBuilder("SELECT `");
        cmd.append(index);
        cmd.append("` FROM `");
        cmd.append(table);
        cmd.append("` WHERE ");
        cmd.append(info);
        return cmd.toString();

    }

    public static String selectFromDatabase(String index, String table, String info) throws Exception {
        connectDatabase();
        String cmd = selectCmd(index, table, info);
        resultSet = statement.executeQuery(cmd);
        String res = null;
        while (resultSet.next()) {
            res += (resultSet.getObject(index));
        }
        resultSet.close();
        disconnectDatabase();
        return res;

    }

}
