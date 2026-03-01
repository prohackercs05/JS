import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Slip27_1_Servlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String tableName = request.getParameter("tableName");

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "postgres", "root");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM " + tableName + " LIMIT 1");
            ResultSetMetaData rsmd = rs.getMetaData();

            out.println("<html><body>");
            out.println("<h2>Table Context: " + tableName + "</h2>");
            out.println("<table border='1'><tr><th>Name</th><th>Type</th><th>Size</th></tr>");

            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                out.println("<tr><td>" + rsmd.getColumnName(i) + "</td>");
                out.println("<td>" + rsmd.getColumnTypeName(i) + "</td>");
                out.println("<td>" + rsmd.getColumnDisplaySize(i) + "</td></tr>");
            }
            out.println("</table></body></html>");

            con.close();
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}
