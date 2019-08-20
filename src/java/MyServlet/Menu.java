package MyServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Menu extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        String name = req.getParameter("USERNAME");
        HttpSession session = req.getSession();
        System.out.println(session);
        if (session == null) {
            res.sendRedirect("MyLogin");
        } 
        else {
            PrintWriter out = res.getWriter();
            out.println("<head>"
                    + "            <title>MENU</title>\n"
                    + "            <meta charset=\"UTF-8\">\n"
                    + "            <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                    + "	        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n"
                    + "            <link rel='stylesheet' type='text/css' media='all' href='http://localhost:8084/MyServlet/css/mycss.css'/>\n"
                    + "\n"
                    + "    </head>\n"
                    + "    <body>\n"
                    + "        <div class='bg'>\n"
                    + "         <br><br><br>\n"
                    + "            <div class='menu'>\n"
                    + "                 <h1>Menu</h1>\n"
                    + "                 <ul>\n"
                    + "                     <li><a href=\"New_Reg\"><h4>Add new employee</h4></a></li>\n"
                    + "                     <li><a href=\"#\"><h4>Update employee details</h4></a></li>\n"
                    + "                     <li><a href=\"#\"><h4>Remove employee details</h4></a></li>\n"
                    + "                     <li><a href=\"#\"><h4>Employee data</h4></a></li>\n"
                    + "                     <li><a href=\"Logout\"><h4>Logout</h4></a></li>\n"
                    + "                 </ul>\n"
                    + "             </div>\n"
                    + "        </div>\n"
                    + "\n"
                    + "    </body>");

        }
    }
}
