package atguigu.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtilsByDruid {
    private static javax.sql.DataSource ds;

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("C:\\Users\\admin\\Desktop\\IDEACode\\JavaWeb07(书城项目第三阶段)\\book_mall-03\\src\\druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
