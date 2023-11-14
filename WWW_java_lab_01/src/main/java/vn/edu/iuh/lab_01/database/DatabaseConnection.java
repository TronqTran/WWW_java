package vn.edu.iuh.lab_01.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static DatabaseConnection instance = null;
    private Connection connection;

    private DatabaseConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "sapassword");
    }

    public static DatabaseConnection getInstance() throws Exception {
        if (instance == null)
            instance = new DatabaseConnection();
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
