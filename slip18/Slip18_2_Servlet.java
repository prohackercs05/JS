import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Slip18_2_Servlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String seatNo = request.getParameter("seatNo");
        String name = request.getParameter("name");
        String className = request.getParameter("class");
        int totalMarks = Integer.parseInt(request.getParameter("totalMarks"));

        double percentage = (totalMarks / 500.0) * 100;
        String grade;

        if (percentage >= 70)
            grade = "Distinction";
        else if (percentage >= 60)
            grade = "First Class";
        else if (percentage >= 50)
            grade = "Second Class";
        else if (percentage >= 40)
            grade = "Pass Class";
        else
            grade = "Fail";

        out.println("<html><body>");
        out.println("<h2>Student Result</h2>");
        out.println("<p>Seat No: " + seatNo + "</p>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Class: " + className + "</p>");
        out.println("<p>Total Marks: " + totalMarks + "</p>");
        out.println("<p>Percentage: " + String.format("%.2f", percentage) + "%</p>");
        out.println("<h3>Grade: " + grade + "</h3>");
        out.println("</body></html>");
    }
}
