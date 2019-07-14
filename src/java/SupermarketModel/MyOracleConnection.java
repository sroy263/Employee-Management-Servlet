package SupermarketModel;

import java.sql.*;

public class MyOracleConnection 
{
  public static Connection getConnection()
      throws ClassNotFoundException, SQLException
  {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
    Connection  con = DriverManager.getConnection(url,"market", "m");
    return con;       
   }
}