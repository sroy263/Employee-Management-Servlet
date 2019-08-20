package MyServlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Login_Check {

    int CheckLogin(String user, String passw) throws ClassNotFoundException, SQLException {
        int status = 0;
        System.out.println("u : " + user + ", p : " + passw);
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@127.0.0.1:1521:saurav";
        Connection con = DriverManager.getConnection(url, user, passw);
        if (con != null) {
            System.out.println("Connection Created.");
            status = 1;
        }
        return status;
    }
    
    Connection check(String user,String passw) throws ClassNotFoundException, SQLException{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@127.0.0.1:1521:saurav";
        Connection con = DriverManager.getConnection(url,"sourav", "roy");
        if (con != null) {
            System.out.println("Connection Created.");
        }
        return con; 
    }
   
}
