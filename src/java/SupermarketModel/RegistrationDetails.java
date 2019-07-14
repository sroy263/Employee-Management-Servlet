package SupermarketModel;
import  java.sql.*;
import  java.util.*;
public class RegistrationDetails 
{
  public int saveRegistration(String name, String address, int mt, String gen,
                              int sal, String user, String pass)
  {
    int i = 0;
    try{
       Connection con = MyOracleConnection.getConnection();
       String f = "{ ? = call save_registration(?,?,?,?,?,?,?) }";
       CallableStatement cs = con.prepareCall( f );
       cs.setString(2, name);
       cs.setString(3, address);
       cs.setInt(4, mt);
       cs.setString(5, gen);
       cs.setInt(6, sal);
       cs.setString(7, user);
       cs.setString(8, pass);
       cs.registerOutParameter(1, Types.NUMERIC);
       cs.executeUpdate();
       i = cs.getInt(1);
    }catch(Exception  e)
    {
      e.printStackTrace();
      i = 0;
    }
    return i;
  }
  
  public TreeSet<Customer> getRegDetails(int m,String g)
  {
    TreeSet<Customer> data = new TreeSet<Customer>( new SortingLogic() );
    try{
        Connection con = MyOracleConnection.getConnection();
        Statement s = con.createStatement();
        String sql = "Select ID,NAME,ADDRESS,MTYPE,GENDER,SALARY,USERNAME,PASSWORD"
                + " FROM CUSTOMER_MASTER "
                + " Where mtype="+m
                + " and gender= '"+g+"'"
                + " ORDER BY NAME";
        ResultSet rs = s.executeQuery( sql );
        while(rs.next())
        {
          data.add( new Customer(rs.getString(2), rs.getString(3), rs.getString(5), 
                  rs.getString(7), rs.getString(8), rs.getInt(1), rs.getInt(4), rs.getInt(6)));
        } 
    }catch(Exception e)
    {
      e.printStackTrace();
    }
    return data;
  }
  
  public void deleteCustomers(String ids[])
  {
    try{
        Connection con = MyOracleConnection.getConnection();
        Statement s = con.createStatement();
        for(String id : ids)
        {
          s.execute("Delete Customer_Mast Where id = " + id);
        }
        s.close();
        con.close();
       }catch(Exception e)
       {
         e.printStackTrace();
       }
      
  }
}
