
package server;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
/**
 *
 * @author minhduc
 */
public class Connector {
    private static final String host = "localhost";
    private static final String username = "root";
    private static final String password = "";
    private static final String db = "network";
    private static final String url = "jdbc:mysql://"+host+":3306/"+db;
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,username,password);
            System.out.println("ket noi mysql thanh cong");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
