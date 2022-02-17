package com;

import java.sql.*;

public class run {
    public static void main(String[] args)  {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "update users set name = ? , address = ? where id = ? ";
        //ResultSet resultSet = null;
        try {
            connection = jdbcutils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"冯七");
            preparedStatement.setString(2,"山东");
            preparedStatement.setInt(3,5);
            preparedStatement.executeUpdate();
            //resultSet = preparedStatement.executeQuery();
            //while(resultSet.next())
            //{
            //    String id = resultSet.getString("id");
            //    String name = resultSet.getString("name");
            //   String address = resultSet.getString("address");
            //   System.out.println(id + "\t" + name + "\t" +address);
            // }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            jdbcutils.close(null,preparedStatement,connection);
        }


    }
}
