package SupermarketModel;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>\n"
                + "    <head>\n"
                + "        <title>Welcome to Sumermarket</title>\n"
                + "	   <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n"
                + "    </head>\n"
                + "    <body>\n"
                + "        <center>\n"
                + "        <font color=\"blue\" size=\"7\">\n"
                + "         Login Screen\n"
                + "        </font><br><br><br>\n"
                + "        <form action='Login' method='post'>\n "
                + "         Username <input type=\"text\" name=\"USERNAME\"><br>\n"
                + "         Password <input type=\"password\" name=\"PASSWORD\"><br>\n"
                + "        <button type=\"submit\" class=\"btn btn-primary \">Submit</button><br>\n"
                + "        </form> "
                + "        </center>\n"
                + "    </body>\n"
                + "</html>\n"
                + "");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String u = request.getParameter("USERNAME");
        String p = request.getParameter("PASSWORD");
        LoginDetails obj = new LoginDetails();
        int lid = obj.checkLogin(u, p);
        if (lid > 0) {
            response.sendRedirect("Menu");
        } else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html> <head><title>Invalid password</title></head>"
                    + "<body>"
                    + "<font size=8 color='red'> Please check username/password</font> <br><br>"
                    + "<a href='Login'> OK </a> <br><br>"
                    + "</body></html>");
            out.close();
        }
    }
}
