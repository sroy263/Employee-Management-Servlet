package SupermarketModel;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class ConfirmDelete extends HttpServlet 
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String ids[] = request.getParameterValues("ID");
      RegistrationDetails obj = new RegistrationDetails();
      obj.deleteCustomers(ids);
      response.sendRedirect("DeleteRegistration");
      out.close();        
    }
}
