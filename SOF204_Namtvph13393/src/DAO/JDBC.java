package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC {
    static final String url = "jdbc:sqlserver://localhost;database=Polypro;user=sa;password=513223";
    public static Connection getConnection(){
        Connection con = null;
        try {
            DriverManager.deregisterDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            con = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
//    public static void main(String[] args) {
//        JDBC.getConnection();
//    }
}
