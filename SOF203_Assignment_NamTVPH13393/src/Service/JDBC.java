
package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class JDBC {
    public static final String url = "jdbc:sqlserver://localhost;database=FPT_DaoTao;user=sa;password=513223";
    public static Connection getConnection(){
        try {
            DriverManager.deregisterDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            Connection connection = DriverManager.getConnection(url);
            return connection;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Kết nối CSDL thất bại");
        }
        return null;
    }
    
    
    
}
