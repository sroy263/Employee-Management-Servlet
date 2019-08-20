package MyServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "New_Reg", urlPatterns = {"/New_Reg"})
public class New_Reg extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        HttpSession session = req.getSession();
        System.out.println(session);
        if (session == null) {
            res.sendRedirect("MyLogin");
        } 
        else {
        out.println("<head>\n"
                + "	        <title>NEW REGISTRATION</title>\n"
                + "	        <meta charset=\"UTF-8\">\n"
                + "	        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "	        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n"
                + "	        <link rel='stylesheet' type='text/css' media='all' href='http://localhost:8084/MyServlet/css/mycss.css'/>\n"
                + "	    </head>\n"
                + "	    <body class=\"bg\">\n"
                + "	        <div class='container'>\n"
                + "	            <br>\n"
                + "	                <h1>REGISTRATION FORM</h1>\n"
                + "	                <br>\n"
                + "	                <form class=\"form-container\" method=\"post\">\n"
                + "	                    <div class=\"form-group row\">\n"
                + "							  <div class=\"col-xs-3\">\n"
                + "							    <label for=\"firstname\"><h4>First Name</h4></label>\n"
                + "							    <input class=\"form-control\" name=\"firstname\" type=\"text\">\n"
                + "							  </div>\n"
                + "							  <div class=\"col-xs-3\">\n"
                + "							    <label for=\"middlename\"><h4>Middle Name</h4></label>\n"
                + "							    <input class=\"form-control\" name=\"middlename\" type=\"text\">\n"
                + "							  </div>\n"
                + "							  <div class=\"col-xs-3\">\n"
                + "							    <label for=\"lastname\"><h4>Last Name</h4></label>\n"
                + "							    <input class=\"form-control\" name=\"lastname\" type=\"text\">\n"
                + "							  </div>\n"
                + "						</div>\n"
                + "						<div class=\"form-group\">\n"
                + "	                		<label for=\"gender\"><h4>Gender:</h4></label>\n"
                + "	                		<label class='radio-inline'><input type=\"radio\" name=\"gender\" value='male'><h4>Male</h4></label>\n"
                + "	                		<label class='radio-inline'><input type=\"radio\" name=\"gender\" value='female'><h4>Female</h4></label>\n"
                + "	                		\n"
                + "	                	</div>\n"
                + "\n"
                + "						<div class=\"form-group\">\n"
                + "	                		<label for=\"dob\"><h4>Date of Birth:</h4></label>\n"
                + "	                		<input type=\"date\" name=\"bday\">\n"
                + "	                		\n"
                + "	                	</div>\n"
                + "\n"
                + "\n"
                + "						<div class=\"form-group row \">\n"
                + "							<div class=\"col-xs-5\">\n"
                + "			                    <label for=\"email\"><h4>Email:</h4></label>\n"
                + "			                    <input type=\"email\" class=\"form-control\" placeholder=\"idkidkidk@gmail.com\" name=\"email\">\n"
                + "			                </div>\n"
                + "			            </div>\n"
                + "			            <div class=\"form-group row \">\n"
                + "			                <div class=\"col-xs-3\">\n"
                + "			                    <label for=\"mobile\"><h4>Mobile No:</h4></label>\n"
                + "			                    <input type=\"mobile\" class=\"form-control\" placeholder=\"9999999999\" name=\"mobile\">\n"
                + "			                </div>\n"
                + "			            </div>\n"
                + "						<div class=\"form-group row\">\n"
                + "		                    <div class=\"col-xs-4\">\n"
                + "		                    	<label for=\"username\"><h4>Username:</h4></label>\n"
                + "		                        <input type=\"username\" class=\"form-control\" placeholder=\"username\" name=\"username\">\n"
                + "		                    </div>\n"
                + "\n"
                + "                                 <div class=\"col-xs-4\">\n"
                + "		                        <label for=\"password\"><h4>Password:</h4></label>\n"
                + "		                        <input type=\"password\" class=\"form-control\" placeholder=\"password\" name=\"password\">\n"
                + "                                 </div>\n"
                + "	                	</div>\n"
                + "\n"
                + "	                	<div class=\"form-group\">\n"
                + "	                		<div class=\"form-group row\">\n"
                + "		                		<div class=\"col-xs-2\">\n"
                + "		                			<label for=\"address\"><h4>Address:</h4></label>\n"
                + "			                		<select class=\"form-control\" name=\"address\">\n"
                + "			                			<option>City</option>\n"
                + "			                			<option value=\"Nagpur\">Nagpur</option>\n"
                + "			                			<option value=\"Hyderabad\">Hyderabad</option>\n"
                + "			                			<option value=\"Pune\">Pune</option>\n"
                + "			                			<option value=\"Kolkata\">Kolkata</option>\n"
                + "			                		</select>\n"
                + "		                		</div>\n"
                + "\n"
                + "		                		<div class=\"col-xs-2\">\n"
                + "		                			<label for=\"Pincode\"><h4>PinCode:</h4></label>\n"
                + "			                		<input type=\"text\" class=\"form-control\" placeholder=\"000000\" name=\"PinCode\">\n"
                + "		                		</div>\n"
                + "	                	</div>\n"
                + "\n"
                + "\n"
                + "	                    <center><button type=\"submit\" class=\"btn btn-primary \">Submit</button></center>\n"
                + "	                    \n"
                + "	                </form>\n"
                + "	                \n"
                + "	        </div><br><br><br>\n"
                + "	    </body>");
        out.close();
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String name, fn, mn, ln, gender, email, mob, user, pass, address, pin;
        fn = req.getParameter("firstname");
        mn = req.getParameter("middlename");
        ln = req.getParameter("lastname");
        name = "" + fn + " " + mn + " " + ln;
        gender = req.getParameter("gender");
        String startDateStr = req.getParameter("bday");
        //System.out.println("date:" + startDateStr);
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = null;
        try {
            date = sdf1.parse(startDateStr);
        } catch (ParseException ex) {
            Logger.getLogger(New_Reg.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.sql.Date dob;
        dob = new java.sql.Date(date.getTime());
        //System.out.println("Converted String: " + dob);
        email = req.getParameter("email");
        mob = req.getParameter("mobile");
        user = req.getParameter("username");
        pass = req.getParameter("password");
        address = req.getParameter("address");
        pin = req.getParameter("PinCode");

        Registration r = new Registration();
        int id = r.save(name, gender, dob, email, mob, user, pass, address, pin);
        if (id == 1) {
            res.setContentType("text/html");
            PrintWriter out = res.getWriter();
            out.println("<head>\n"
                    + "	        <title>Registration Success</title>\n"
                    + "	        <meta charset=\"UTF-8\">\n"
                    + "	        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                    + "	        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n"
                    + "	        <link rel='stylesheet' type='text/css' media='all' href='http://localhost:8084/MyServlet/css/mycss.css'/>\n"
                    + "	    </head>\n"
                    + "	    <body class=\"bg\">\n"
                    + "	        <form action='Menu'>\n"
                    + "	            <br><br><br><br><center>\n"
                    + "	                <h4>Registration Successful!</h4>\n"
                    + "	                <br><br><a href='Menu'><button type=\"submit\" class=\"btn btn-success \">OK</button><br></a>"
                    + "         </center></div>"
                    + "     </body>\n");
        }
        else{
            res.setContentType("text/html");
            PrintWriter out = res.getWriter();
            out.println("<head>\n"
                    + "	        <title>Registration Success</title>\n"
                    + "	        <meta charset=\"UTF-8\">\n"
                    + "	        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                    + "	        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n"
                    + "	        <link rel='stylesheet' type='text/css' media='all' href='http://localhost:8084/MyServlet/css/mycss.css'/>\n"
                    + "	    </head>\n"
                    + "	    <body class=\"bg\">\n"
                    + "	        <form action='New_Reg'>\n"
                    + "	            <br><br><br><br><center>\n"
                    + "	                <h4>Registration Unsuccessful!</h4>\n"
                    + "	                <br><br><a href='New_Reg'><button type=\"submit\" class=\"btn btn-danger \">BACK</button><br></a>"
                    + "         </center></div>"
                    + "     </body>\n");
        }

    }

}
