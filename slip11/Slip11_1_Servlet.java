import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Slip11_1_Servlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String bgroup = request.getParameter("bgroup");

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "postgres", "root");

            String query = "SELECT * FROM DONAR WHERE blood_group = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, bgroup);

            ResultSet rs = pst.executeQuery();

            out.println("<html><body>");
            out.println("<h2>Donors with Blood Group: " + bgroup + "</h2>");
            out.println("<table border='1'>");
            out.println("<tr><th>ID</th><th>Name</th><th>Last Donation</th></tr>");

            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getInt(1) + "</td>");
                out.println("<td>" + rs.getString(2) + "</td>");
                out.println("<td>" + rs.getDate(4) + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("<br><a href='slip11/Slip11_1.html'>Back</a>");
            out.println("</body></html>");

            con.close();
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}
