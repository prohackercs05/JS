import java.sql.*;
import java.util.Scanner;

public class Slip16_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection con = null;
        PreparedStatement pst = null;

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "postgres", "root");

            Statement st = con.createStatement();
            st.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS Teacher (TNo INT PRIMARY KEY, TName VARCHAR(50), Subject VARCHAR(50))");

            // Insert 5 records using PreparedStatement
            System.out.println("Enter details for 5 Teachers:");
            String insertSql = "INSERT INTO Teacher (TNo, TName, Subject) VALUES (?, ?, ?)";
            pst = con.prepareStatement(insertSql);

            for (int i = 1; i <= 5; i++) {
                System.out.println("Teacher " + i + ":");
                System.out.print("Enter TNo: ");
                int tno = sc.nextInt();
                sc.nextLine(); // Consume newline
                System.out.print("Enter TName: ");
                String tname = sc.nextLine();
                System.out.print("Enter Subject: ");
                String subject = sc.nextLine();

                pst.setInt(1, tno);
                pst.setString(2, tname);
                pst.setString(3, subject);
                pst.executeUpdate();
                System.out.println("Record Inserted.");
            }

            // Display teachers who teach "JAVA" Subject
            System.out.println("\nTeachers teaching 'JAVA' Subject:");
            String selectSql = "SELECT * FROM Teacher WHERE Subject = ?";
            pst = con.prepareStatement(selectSql);
            pst.setString(1, "JAVA");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                System.out.println(
                        "TNo: " + rs.getInt(1) + ", TName: " + rs.getString(2) + ", Subject: " + rs.getString(3));
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            try {
                if (pst != null)
                    pst.close();
                if (con != null)
                    con.close();
                sc.close();
            } catch (Exception e) {
            }
        }
    }
}

/*
 * Explanation:
 * This program demonstrates the use of PreparedStatement for database
 * interactions.
 * 1. Database Connectivity: Connects to 'testdb' using MySQL JDBC Driver.
 * 2. Table Creation: Ensures the 'Teacher' table exists using Statement.
 * 3. Data Insertion: Uses a PreparedStatement to insert records loop.
 * PreparedStatement is preferred for security (prevents SQL injection) and
 * performance
 * when executing the same query multiple times with different values.
 * 4. Data Retrieval: Uses a parameterized query SELECT ... WHERE Subject = ?
 * with a PreparedStatement. The parameter 'JAVA' is bound securely before
 * execution.
 * 5. Iteration: The ResultSet is scanned to display each matching record's
 * details.
 */
