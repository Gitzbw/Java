package com;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class jdbcutils {
    private static String url;
    private static String password;
    private static String user;
    private static String driver;

    static
    {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("C:\\Users\\admin\\Desktop\\IDEACode\\test107\\src\\com\\mysql.properties"));
            url = properties.getProperty("url");
            password = properties.getProperty("password");
            user = properties.getProperty("user");
            driver = properties.getProperty("driver");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection()
    {
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet resultSet, Statement statement,Connection connection)
    {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
