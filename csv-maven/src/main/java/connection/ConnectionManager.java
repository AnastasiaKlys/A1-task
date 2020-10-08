package connection;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import java.sql.*;

public class ConnectionManager {

    private static final String URL = "jdbc:mysql://localhost:3306/a1";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";
    private static DataSource dataSource;


    static {
        PoolProperties poolProperties = new PoolProperties();
        poolProperties.setDriverClassName("com.mysql.jdbc.Driver");
        poolProperties.setUrl(URL);
        poolProperties.setUsername(USERNAME);
        poolProperties.setPassword(PASSWORD);
        dataSource = new DataSource(poolProperties);
    }
    private ConnectionManager() {}

    public static Connection newConnection() throws SQLException {
        return dataSource.getConnection();
    }

}
