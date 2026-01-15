package util;

import java.sql.*;

public class DBUtil {
    private static Connection con;

    private DBUtil() {}

    public static Connection getConnection() {
        if (con == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/simpleblog",
                    "root",
                    "password"
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return con;
    }
}
