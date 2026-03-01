<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Online MCQ Test</title>
</head>
<body>
<%
    // Initialize session variables if it's the first time
    if (session.getAttribute("qno") == null) {
        session.setAttribute("qno", 0);
        session.setAttribute("score", 0);
        
        // Fetch random questions from database and store in a list
        List<Map<String, String>> questions = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "postgres", "root");
            Statement st = con.createStatement();
            // Select random 5 questions
            ResultSet rs = st.executeQuery("SELECT * FROM quiz_questions ORDER BY RANDOM() LIMIT 5");
            
            while (rs.next()) {
                Map<String, String> q = new HashMap<>();
                q.put("q", rs.getString("question"));
                q.put("o1", rs.getString("option1"));
                q.put("o2", rs.getString("option2"));
                q.put("o3", rs.getString("option3"));
                q.put("o4", rs.getString("option4"));
                q.put("ans", rs.getString("ans"));
                questions.add(q);
            }
            con.close();
            session.setAttribute("questions", questions);
        } catch (Exception e) {
            out.println("<p style='color:red'>Database Error: " + e.getMessage() + "</p>");
            out.println("<p>Note: Ensure 'testdb' exists with 'quiz_questions' table.</p>");
        }
    }

    int qno = (Integer) session.getAttribute("qno");
    int score = (Integer) session.getAttribute("score");
    List<Map<String, String>> questions = (List<Map<String, String>>) session.getAttribute("questions");

    // Handle "Next" or "Submit" click
    if (request.getParameter("submit") != null || request.getParameter("next") != null) {
        String selected = request.getParameter("answer");
        String correct = questions.get(qno).get("ans");
        
        if (selected != null && selected.equals(correct)) {
            score++;
            session.setAttribute("score", score);
        }
        
        qno++;
        session.setAttribute("qno", qno);
    }

    // Display Logic
    if (questions == null || questions.isEmpty()) {
        out.println("<h2>No questions available. Please check database.</h2>");
    } else if (qno < questions.size()) {
        Map<String, String> currentQ = questions.get(qno);
%>
    <h2>Question <%= qno + 1 %>:</h2>
    <p><%= currentQ.get("q") %></p>
    <form method="post">
        <input type="radio" name="answer" value="1" required> <%= currentQ.get("o1") %><br>
        <input type="radio" name="answer" value="2"> <%= currentQ.get("o2") %><br>
        <input type="radio" name="answer" value="3"> <%= currentQ.get("o3") %><br>
        <input type="radio" name="answer" value="4"> <%= currentQ.get("o4") %><br><br>
        
        <% if (qno == questions.size() - 1) { %>
            <input type="submit" name="submit" value="Submit Test">
        <% } else { %>
            <input type="submit" name="next" value="Next">
        <% } %>
    </form>
<%
    } else {
        // Test Result
        out.println("<h1>Test Completed!</h1>");
        out.println("<h3>Your Total Score: " + score + " / " + questions.size() + "</h3>");
        out.println("<a href='Slip5_2.jsp'>Restart Test</a>");
        session.invalidate(); // Clear session to restart
    }
%>
</body>
</html>

<!--
explanation:
This JSP implements a simple online quiz system using the 'session' object to manage state.
1. Initialization: When the page is first loaded, it fetches a randomized list of questions 
   from a PostgreSQL database ('quiz_questions' table) and stores them in the session.
2. State Management: The session keeps track of the 'qno' (current question index) 
   and the 'score' (number of correct answers).
3. Logic: On clicking "Next" or "Submit", the program checks if the selected radio button value 
   matches the 'ans' stored in the map. If it matches, the score is incremented.
4. Flow Control: It uses 'qno' to determine whether to show the next question or the final score.
5. Randomization: The SQL query 'ORDER BY RANDOM()' ensures questions are different each time.
-->
