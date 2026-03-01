import java.sql.*;

public class Slip26_1 {
    public static void main(String[] args) {
        // Step 1: Validate command line arguments
        if (args.length == 0) {
            System.out.println("Please provide the Employee ID (ENo) as an argument.");
            System.out.println("Usage: java Slip26_1 <ENo>");
            return;
        }

        int eno;
        try {
            eno = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid Employee ID. Please enter a number.");
            return;
        }

        Connection con = null;
        PreparedStatement pst = null;

        try {
            // Step 2: Establish connection
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "postgres", "root");

            // Step 3: Define DELETE query with PreparedStatement
            String sql = "DELETE FROM employee WHERE eno = ?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, eno);

            // Step 4: Execute query
            int rowsDeleted = pst.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Successfully deleted record for ENo: " + eno);
            } else {
                System.out.println("No employee found with ENo: " + eno);
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            // Step 5: Clean up resources
            try {
                if (pst != null)
                    pst.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

/*
 * Explanation:
 * This program demonstrates how to delete data from a database securely.
 * 1. Command-line Input: The employee ID is captured from args[0].
 * 2. JDBC Connection: Uses the provided credentials for 'testdb'.
 * 3. PreparedStatement: Used for the DELETE query to prevent SQL injection
 * (mapping the '?' placeholder to the 'eno' variable).
 * 4. executeUpdate(): Returns the number of rows affected. If > 0, the record
 * was removed.
 */
