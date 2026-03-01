import java.sql.*;

public class Slip13_1 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "postgres", "root");

            // Get DatabaseMetaData
            DatabaseMetaData dbmd = con.getMetaData();

            // Display Database details
            System.out.println("Database Product Name: " + dbmd.getDatabaseProductName());
            System.out.println("Database Product Version: " + dbmd.getDatabaseProductVersion());
            System.out.println("Driver Name: " + dbmd.getDriverName());
            System.out.println("Driver Version: " + dbmd.getDriverVersion());
            System.out.println("User Name: " + dbmd.getUserName());
            System.out.println("URL: " + dbmd.getURL());

            // List all tables in the database
            System.out.println("\nList of Tables in 'testdb':");
            String[] types = { "TABLE" };
            ResultSet rs = dbmd.getTables(null, null, "%", types);

            while (rs.next()) {
                System.out.println("Table Name: " + rs.getString("TABLE_NAME"));
            }

            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

/*
 * Explanation:
 * This program uses DatabaseMetaData to inspect the capabilities and structure
 * of the connected database.
 * 1. dbmd.getDatabaseProductName() & Version: Retrieves the branding and
 * major/minor version of the database.
 * 2. dbmd.getDriverName() & Version: Returns the details of the JDBC driver
 * implementing the connection.
 * 3. Listing Tables: The getTables() method is used to query the data
 * dictionary.
 * - The first three parameters (catalog, schema, namePattern) are set to null
 * or '%' to search globally.
 * - The fourth parameter (types) is set to {"TABLE"} to exclude views or system
 * aliases.
 * 4. Iterating: A ResultSet is returned containing metadata records. We extract
 * the 'TABLE_NAME' column to print each entry.
 */
