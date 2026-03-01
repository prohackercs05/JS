import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Slip19_2_Servlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "postgres", "root");

            PreparedStatement pst = con.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
            pst.setString(1, uname);
            pst.setString(2, pass);

            ResultSet rs = pst.executeQuery();

            out.println("<html><body>");
            if (rs.next()) {
                out.println("<h2 style='color:green'>Success! Welcome, " + uname + "</h2>");
            } else {
                out.println("<h2 style='color:red'>Invalid Credentials!</h2>");
                out.println("<a href='slip19/Slip19_2.html'>Try Again</a>");
            }
            out.println("</body></html>");

            con.close();
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}
