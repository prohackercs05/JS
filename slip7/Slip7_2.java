import java.sql.*;

public class Slip7_2 {
    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "postgres", "root");
            st = con.createStatement();

            // i. Create Product table
            String createTable = "CREATE TABLE IF NOT EXISTS Product (" +
                    "Pid INT PRIMARY KEY, " +
                    "Pname VARCHAR(50), " +
                    "Price DOUBLE)";
            st.executeUpdate(createTable);
            System.out.println("Table created successfully.");

            // ii. Insert 5 records
            // Using executeUpdate multiple times or batch. For simplicity:
            st.executeUpdate("INSERT INTO Product VALUES (1, 'Laptop', 50000) ON CONFLICT (Pid) DO NOTHING");
            st.executeUpdate("INSERT INTO Product VALUES (2, 'Mobile', 15000) ON CONFLICT (Pid) DO NOTHING");
            st.executeUpdate("INSERT INTO Product VALUES (3, 'Tablet', 12000) ON CONFLICT (Pid) DO NOTHING");
            st.executeUpdate("INSERT INTO Product VALUES (4, 'Watch', 3000) ON CONFLICT (Pid) DO NOTHING");
            st.executeUpdate("INSERT INTO Product VALUES (5, 'Camera', 40000) ON CONFLICT (Pid) DO NOTHING");
            System.out.println("5 Records inserted successfully.");

            // iii. Display all records
            ResultSet rs = st.executeQuery("SELECT * FROM Product");
            System.out.println("\nProduct List:");
            System.out.println("ID\tName\tPrice");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getDouble(3));
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (st != null)
                    st.close();
                if (con != null)
                    con.close();
            } catch (Exception e) {
            }
        }
    }
}

/*
 * Explanation:
 * This program uses JDBC (Java Database Connectivity) to interact with a
 * PostgreSQL
 * database.
 * 1. Connection: Establish a connection to 'testdb' using the PostgreSQL
 * Driver.
 * 2. Create Table: Executes a DDL query (CREATE TABLE) to define the Product
 * schema.
 * 3. Insert Records: Executes DML queries (INSERT) to add 5 sample products.
 * ON CONFLICT DO NOTHING is used here to avoid errors if the code is run
 * multiple times.
 * 4. Display Records: Uses a SELECT query to retrieve all data and iterates
 * through the
 * ResultSet to print the details on the console.
 */
