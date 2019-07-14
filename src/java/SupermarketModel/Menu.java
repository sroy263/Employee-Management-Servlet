package SupermarketModel;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Menu extends HttpServlet 
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      out.println("<html> <head><title>S1 GET</title></head>"
              + "<body> <center>"
              + "<font color=blue size=7> <u>Menu</u> </font> <br>"
              + "<a href='Registration'> New Registration </a> <br>"
              + "<a href=''> Update Registration </a> <br>"
              + "<a href='DeleteRegistration'> Delete Registration </a> <br>"
              + "<a href='RegistrationReport'> Registration Report</a> <br>"
              + "<a href='Logout'> Logout </a> <br>"
              + " </center> </body></html>");
      out.close();
    }
}