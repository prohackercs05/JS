import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class Slip12_2 extends JFrame {
    JTable table;
    DefaultTableModel model;

    public Slip12_2() {
        setTitle("Project Table Viewer");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize table model with column headers
        model = new DefaultTableModel();
        model.addColumn("Project ID");
        model.addColumn("Project Name");
        model.addColumn("Description");
        model.addColumn("Status");

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Perform Database Operations
        setupDatabaseAndLoadData();

        setVisible(true);
    }

    private void setupDatabaseAndLoadData() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "postgres", "root");
            Statement st = con.createStatement();

            // i. Create PROJECT table
            String sqlCreate = "CREATE TABLE IF NOT EXISTS PROJECT (" +
                    "project_id INT PRIMARY KEY, " +
                    "Project_name VARCHAR(100), " +
                    "Project_description TEXT, " +
                    "Project_Status VARCHAR(20))";
            st.executeUpdate(sqlCreate);

            // ii. Insert values
            // Using ON DUPLICATE update to avoid errors on multiple runs
            st.executeUpdate(
                    "INSERT INTO PROJECT VALUES (1, 'E-Commerce', 'Shopping Website', 'In Progress') ON CONFLICT (project_id) DO NOTHING");
            st.executeUpdate(
                    "INSERT INTO PROJECT VALUES (2, 'CRM System', 'Client Relationship Manager', 'Completed') ON CONFLICT (project_id) DO NOTHING");
            st.executeUpdate(
                    "INSERT INTO PROJECT VALUES (3, 'Hospital CRM', 'Managing Patient Records', 'Pending') ON CONFLICT (project_id) DO NOTHING");

            // iii. Clear current model and load data into JTable
            model.setRowCount(0);
            ResultSet rs = st.executeQuery("SELECT * FROM PROJECT");
            while (rs.next()) {
                model.addRow(new Object[] {
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                });
            }

            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Slip12_2();
    }
}

/*
 * Explanation:
 * This Java Swing program integrates JDBC to manage and display project data.
 * 1. GUI Component: It uses JTable and DefaultTableModel to present database
 * records in a tabular format.
 * 2. Database Creation: The program uses DDL 'CREATE TABLE IF NOT EXISTS' to
 * define the
 * PROJECT table structure.
 * 3. Data Insertion: It executes SQL DML 'INSERT INTO' queries to add sample
 * records.
 * 'ON CONFLICT DO NOTHING' ensures no primary key violation occurs if the code
 * is repeated.
 * 4. Data Retrieval: It executes a 'SELECT *' query to fetch all records from
 * PROJECT
 * and iterates through the ResultSet to populate the table model's rows.
 * 5. Swing Presentation: The table is wrapped in a JScrollPane to handle
 * scenarios where
 * the data exceeds the visible area of the window.
 */
