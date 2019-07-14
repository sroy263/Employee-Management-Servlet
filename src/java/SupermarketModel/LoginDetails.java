package SupermarketModel;

import java.sql.*;

class LoginDetails 
{
    public int checkLogin(String u, String p) 
    {
        int cid = 0;
        try {
            Connection con = MyOracleConnection.getConnection();
            Statement st = con.createStatement();
            String sql = "Select Id From customer_master "
                    + "where username='" + u + "' and password='" + p +"'";
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                System.out.println("rs got");
                cid = rs.getInt(1);
                System.out.println(cid);
            }
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cid;
    }
}
