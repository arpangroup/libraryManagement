package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnectionProject {

    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3307/librarynewprojectcosc";
    private static String user = "root";
    private static String password = "";

    public static Connection connect() {

        Connection conn = null;
        try {
            Class.forName(driver);
            conn =DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

}
