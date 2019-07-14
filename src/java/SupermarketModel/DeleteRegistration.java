package SupermarketModel;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class DeleteRegistration extends HttpServlet 
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
                + "    <form action='DeleteRegistration' method='post' >"
                + "        <center>\n"
                + "            <font color='red' size='7'> Registration Report Criteria</font> <br>\n"
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
                + "                <tr><td colspan='2' align='center'> <input type='submit' value='Show'></td>   </tr>\n"
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
                + "     <center>\n");               
  
      String n = request.getParameter("NAME");
      String a = request.getParameter("ADDRESS");
      int    m = Integer.parseInt( request.getParameter("MEMBERSHIP"));
      String g = request.getParameter("GENDER");
      
      RegistrationDetails obj = new RegistrationDetails();
      TreeSet<Customer> data = obj.getRegDetails(m,g);
      if(data.size()>0)
      {
        out.println("<font color='red' size='7'>Registration Report</font> <br><br>"
                + "<form action='ConfirmDelete' method=post>"
                + "<table border=1 align=center>"
                + "<tr><td>Select</td><td>ID</td> <td>NAME</td> <td>ADDRESS</td> <td>MEMBERSHIP</td> "
                + "    <td>GENDER</td> <td>SALARY</td> <td>USERNAME</td> </tr>");
      }
      for(Customer c : data)
      {
         out.println("<tr><td> <input type=checkbox name='ID' value="+c.i+"> </td>"
                 + "<td>"+c.i+"</td> <td>"+c.name+"</td> <td>"+c.address+"</td> <td>"+c.mt+"</td> "
                + "    <td>"+c.gen+"</td> <td>"+c.sal+"</td> <td>"+c.user+"</td> </tr>");
      }
      out.println("</table><br>"
              + "<input type=submit value='Delete'>"
              + "<br> <a href='Menu'> OK </a> "
              + "</form>"
              + "</body></html>");
      out.close();        
    }
}
