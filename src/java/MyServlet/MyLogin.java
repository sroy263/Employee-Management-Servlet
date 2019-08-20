package MyServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        //req.getRequestDispatcher("login.html");
        PrintWriter out = res.getWriter();
        out.println("<head>\n"
                + "        <title>LOGIN</title>\n"
                + "        <meta charset=\"UTF-8\">\n"
                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "	   <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n"
                + "        <link rel='stylesheet' type='text/css' media='all' href='http://localhost:8084/MyServlet/css/mycss.css'/>\n"
                + "    </head>\n"
                + "    <body class='bg'>\n"
                + "        <script src=\"myjs.js\"></script>\n"
                + "        <div class='container-fluid'>\n"
                + "            <center>\n"
                + "                <br><br><br>\n"
                + "                <h1>LOGIN</h1>\n"
                + "                <br><br><br>\n"
                + "                 <div class='row'>"
                + "                 <div class='col-sm-2'>"
                + "                 </div>"
                + "                <div class='col-sm-4'>"
                + "                <form class='box' action='MyLogin' method='post'>\n"
                + "                     <h4>admin login</h4>"
                + "                     <div class='form-group'>\n"
                + "                         <div class='form-group row'>"
                + "                             <label for='USERNAME'><h4>USERNAME:</h4></label>"
                + "                             <input type=\"text\" name=\"USERNAME\">\n"
                + "                         </div>\n"
                + "                         <div class='form-group row'>"
                + "                             <label for='PASSWORD'><h4>PASSWORD:</h4></label>"
                + "                             <input type='password' name='PASSWORD'><br>\n"
                + "                         </div>\n"
                + "                         <div class='form-group row'>"
                + "                             <button type=\"submit\" class=\"btn btn-primary \">Submit</button><br>\n"
                + "                         </div>"
                + "                     </div>\n"
                + "                </form>\n"
                + "                </div>\n"
                
                + "                <div class='col-sm-4'>"
                + "                <form class='box' action='MyLogin' method='post'>\n"
                + "                     <h4>employee login</h4>"
                + "                     <div class='form-group'>\n"
                + "                         <div class='form-group row'>"
                + "                             <label for='USERNAME'><h4>USERNAME:</h4></label>"
                + "                             <input type=\"text\" name=\"USERNAME\">\n"
                + "                         </div>\n"
                + "                         <div class='form-group row'>"
                + "                             <label for='PASSWORD'><h4>PASSWORD:</h4></label>"
                + "                             <input type='password' name='PASSWORD'><br>\n"
                + "                         </div>\n"
                + "                         <div class='form-group row'>"
                + "                             <button type=\"submit\" class=\"btn btn-primary \">Submit</button><br>\n"
                + "                         </div>"
                + "                     </div>\n"
                + "                </form>\n"
                + "                </div>\n"
                + "                 </div>"
                + "                <br><br>\n"
                + "            </center>\n"
                + "            \n"
                + "        </div>\n"
                + "    </body>\n"
                + "");
        out.close();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String usr = req.getParameter("USERNAME");
        String pwd = req.getParameter("PASSWORD");
        Login_Check lgc = new Login_Check();
        int flag = 0;
        try {
            flag = lgc.CheckLogin(usr, pwd);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        if (flag == 1) {
            res.sendRedirect("Menu");
        } else {
            res.setContentType("text/html");
            PrintWriter out = res.getWriter();
            out.println("<head>\n"
                    + "        <title>WELCOME</title>\n"
                    + "        <meta charset=\"UTF-8\">\n"
                    + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                    + "	        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n"
                    + "        <link rel=\"stylesheet\" href=\"http://localhost:8084/MyServlet/css/mycss.css\">\n"
                    + "    </head>"
                    + "<body class='bg'><center>\n"
                    + " <form>\n"
                    + "<br><br><br><br><br><br><br><br><h2>The username or password entered is incorrect</h2>"
                    + "<br><a href='MyLogin'><button type=\"submit\" class=\"btn btn-danger \">BACK</button><br></a>"
                    + "</form></center></body>");
        }
    }

}
