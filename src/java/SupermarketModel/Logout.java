package SupermarketModel;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Logout extends HttpServlet 
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
      request.getSession().invalidate();
      //response.sendRedirect("S2");
      response.sendRedirect("Login");
    }
}