package de.kozdemir.myfirststeps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/firststeps_db"; // Port für WIN 3306
    private static final String USER = "root";
    private static final String PASSWORD = ""; // Für WIN ist leer

    private DBUtil() {
    }

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Import zur Laufzeit
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
