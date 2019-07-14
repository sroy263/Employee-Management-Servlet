package SupermarketModel;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Registration extends HttpServlet 
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>\n"
                + "    <head>\n"
                + "        <title>Registration</title>\n"
                + "    </head>\n"
                + "    <body>\n"
                + "    <form action='Registration' method='post' >"
                + "        <center>\n"
                + "            <font color='red' size='7'> Registration Form</font> <br>\n"
                + "            <table border='1'>\n"
                + "                <tr><td>NAME</td>       <td><input type='text' name='NAME'></td></tr>\n"
                + "                <tr><td>ADDRESS</td>    <td><textarea cols='40' rows='3' name='ADDRESS'></textarea></td></tr>\n"
                + "                <tr><td>MEMBERSHIP</td> <td><select name='MEMBERSHIP'>\n"
                + "                                            <option value='1'>Platinum</option>\n"
                + "                                            <option value='2'>Gold</option>\n"
                + "                                            <option value='3'>Silver</option>\n"
                + "                                            </select></td></tr>\n"
                + "                <tr><td>GENDER</td>     <td><input type='radio' name='GENDER' value='M'> Male <br>\n"
                + "                                            <input type='radio' name='GENDER' value='F'> Female  </td></tr>\n"
                + "                <tr><td>SALARY</td>     <td><input type='text' name='SALARY'></td></tr>\n"
                + "                <tr><td>USERNAME</td>   <td><input type='text' name='USERNAME'></td></tr>\n"
                + "                <tr><td>PASSWORD</td>   <td><input type='password' name='PASSWORD'></td></tr>\n"
                + "                <tr><td colspan='2' align='center'> <input type='submit' value='Save'></td>   </tr>\n"
                + "            </table>\n"
                + "            \n"
                + "        </center>\n"
                + "    </form>"
                + "    </body>\n"
                + "</html>\n"
                + "");
        out.close();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      out.println("<html>\n"
                + "    <head>\n"
                + "        <title>Registration Status</title>\n"
                + "    </head>\n"
                + "    <body>\n"
                + "     <center>\n"
                + "      <font color='red' size='7'>Registration Status</font> <br><br>");
                
  
      String n = request.getParameter("NAME");
      String a = request.getParameter("ADDRESS");
      int    m = Integer.parseInt( request.getParameter("MEMBERSHIP"));
      String g = request.getParameter("GENDER");
      int    s = Integer.parseInt( request.getParameter("SALARY") );
      String u = request.getParameter("USERNAME");
      String p = request.getParameter("PASSWORD");
      
      RegistrationDetails obj = new RegistrationDetails();
      int rid = obj.saveRegistration(n,a,m,g,s,u,p);
      if(rid>0)
      {
       out.println("Registration done successfully with Id " + rid);
      }
      else
      {        
        out.println("Uable to save registration details");
      }
      out.println("<br><br> <a href='Menu'> OK </a> ");
      out.close();        
    }
}
