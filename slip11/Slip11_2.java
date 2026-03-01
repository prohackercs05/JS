import java.sql.*;

public class Slip11_2 {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "postgres", "root");

            Statement st = con.createStatement();

            // Query the DONAR table (assuming it exists)
            ResultSet rs = st.executeQuery("SELECT * FROM DONAR");

            // Get Metadata from the ResultSet
            ResultSetMetaData rsmd = rs.getMetaData();

            int columnCount = rsmd.getColumnCount();
            System.out.println("No. of Columns: " + columnCount);
            System.out.println("------------------------------------------------------------------");
            System.out.printf("%-20s %-15s %-10s\n", "Column Name", "Data Type", "Size");
            System.out.println("------------------------------------------------------------------");

            for (int i = 1; i <= columnCount; i++) {
                String name = rsmd.getColumnName(i);
                String type = rsmd.getColumnTypeName(i);
                int size = rsmd.getColumnDisplaySize(i);

                System.out.printf("%-20s %-15s %-10d\n", name, type, size);
            }

            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Note: Ensure the 'DONAR' table exists in 'testdb'.");
        }
    }
}

/*
 * Explanation:
 * This program demonstrates how to retrieve information about a database
 * table's structure
 * (metadata) using the ResultSetMetaData interface.
 * 1. Execution: It first executes a SELECT query on the 'DONAR' table.
 * 2. rs.getMetaData(): This method returns a ResultSetMetaData object
 * containing
 * descriptive information about the columns in the ResultSet.
 * 3. Metadata Methods:
 * - getColumnCount(): Returns the total number of columns in the table.
 * - getColumnName(i): Returns the name of the i-th column.
 * - getColumnTypeName(i): Returns the database-specific data type of the i-th
 * column.
 * - getColumnDisplaySize(i): Returns the maximum character width of the i-th
 * column.
 * This is useful for building generic tools that can handle any database table
 * without
 * knowing its schema in advance.
 */
