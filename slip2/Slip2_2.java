import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Slip2_2 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Request and Server Information</h2>");
        out.println("<p><b>Client IP:</b> " + request.getRemoteAddr() + "</p>");
        out.println("<p><b>Browser (User-Agent):</b> " + request.getHeader("User-Agent") + "</p>");
        out.println("<p><b>Server Name:</b> " + request.getServerName() + "</p>");
        out.println("<p><b>Server Port:</b> " + request.getServerPort() + "</p>");
        out.println("<p><b>Context Path:</b> " + request.getContextPath() + "</p>");
        out.println("<p><b>Request Method:</b> " + request.getMethod() + "</p>");
        out.println("</body></html>");
    }
}
