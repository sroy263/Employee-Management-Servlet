package MyServlet;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Registration {
    int save(String n,String g,Date d,String e,String m,String u,String p,String a,String pn){
        int id=0;
        try {
            //connect();
            /*Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connection_url = "jdbc:derby://localhost:1527/Employee;";
            Connection con = DriverManager.getConnection(connection_url, "sourav", "roy");
            if (con != null) {
                System.out.println("Connection Successful");
            }else{
                System.out.println("Unsucessful connection");
            }
            */
            Login_Check lc=new Login_Check();
            Connection con=lc.check("sourav", "roy");
            final Statement st;
            st = con.createStatement();
            
            ResultSet rs;
            String Selquery = "SELECT * FROM EMPLOYEE_DETAILS WHERE (USERNAME = ?)";
            PreparedStatement Selps = con.prepareStatement(Selquery);
            Selps.setString(1, u);
            Selps.execute();
            
            rs = Selps.executeQuery();
            if (rs.next() == false) {
                
                String query = "INSERT INTO EMPLOYEE_DETAILS (name,gender,dob,email,mobile,username,password,address,pin) VALUES(?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, n);
                ps.setString(2, g);
                ps.setDate(3,d);
                ps.setString(4, e);
                ps.setString(5, m);
                ps.setString(6, u);
                ps.setString(7, p);
                ps.setString(8, a);
                ps.setString(9, pn);
                //System.out.println(query);
                ps.execute();
            }
        } catch (SQLException exp) {
            System.out.println(exp);
            return 0;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(New_Reg.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return 1;
    }
}
