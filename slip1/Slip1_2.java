import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Slip1_2 extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4;
    JTextField t1, t2, t3, t4;
    JButton b1;

    public Slip1_2() {

        setTitle("Employee Details");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        l1 = new JLabel("Employee No:");
        t1 = new JTextField();

        l2 = new JLabel("Employee Name:");
        t2 = new JTextField();

        l3 = new JLabel("Designation:");
        t3 = new JTextField();

        l4 = new JLabel("Salary:");
        t4 = new JTextField();

        b1 = new JButton("Save to Database");
        b1.addActionListener(this);

        add(l1); add(t1);
        add(l2); add(t2);
        add(l3); add(t3);
        add(l4); add(t4);
        add(new JLabel(""));
        add(b1);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {

            try {
                int eno = Integer.parseInt(t1.getText());
                String ename = t2.getText();
                String desig = t3.getText();
                double sal = Double.parseDouble(t4.getText());

<<<<<<< HEAD
                Class.forName("org.postgresql.Driver");
                con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "postgres", "root");
=======
                // Load PostgreSQL JDBC Driver
                Class.forName("org.postgresql.Driver");

                // Establish connection to PostgreSQL database
                Connection con = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/projectdb",
                        "postgres",
                        "root"
                );

                // Prepare SQL Insert Query
                PreparedStatement pst = con.prepareStatement(
                        "INSERT INTO employee (eno, ename, designation, salary) VALUES (?, ?, ?, ?)"
                );
>>>>>>> 546047a5172bffb33a481f342c8a0341ce213838

                pst.setInt(1, eno);
                pst.setString(2, ename);
                pst.setString(3, desig);
                pst.setDouble(4, sal);

                int result = pst.executeUpdate();

                if (result > 0) {
                    JOptionPane.showMessageDialog(this, "Record Inserted Successfully!");
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                }

                pst.close();
                con.close();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numeric values.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Slip1_2();
    }
}

/*
 * Explanation:
<<<<<<< HEAD
 * This program creates a graphical user interface using Java Swing to collect
 * employee details.
 * It uses a JFrame with a GridLayout to arrange labels and text fields for Eno,
 * EName, Designation, and Salary.
 * When the 'Save to Database' button is clicked, the actionPerformed method is
 * triggered.
 * It retrieves data from the text fields and establishes a connection to a
 * MySQL database using JDBC. (Updated to PostgreSQL)
 * A PreparedStatement is used to securely insert the data into the 'employee'
 * table.
 * The program handles errors using a try-catch block and displays a success or
 * error message using JOptionPane.
 * Note: You need to have the PostgreSQL JDBC Driver in your classpath and a
 * 'testdb' database with an 'employee' table.
=======
 *
 * This program is a Java Swing application that inserts employee details
 * into a PostgreSQL database using JDBC.
 *
 * 1. The program creates a graphical user interface (GUI) using JFrame.
 * 2. GridLayout is used to arrange labels and text fields in rows and columns.
 * 3. The user enters:
 *      - Employee Number
 *      - Employee Name
 *      - Designation
 *      - Salary
 * 4. When the "Save to Database" button is clicked, the actionPerformed()
 *    method is triggered.
 * 5. The program reads input from the text fields and converts numeric
 *    values using Integer.parseInt() and Double.parseDouble().
 * 6. The PostgreSQL JDBC driver (org.postgresql.Driver) is loaded.
 * 7. A connection is established to the PostgreSQL database:
 *      Database Name : projectdb
 *      Username      : postgres
 *      Password      : root
 *      Port          : 5432
 * 8. A PreparedStatement is used to insert data securely into the
 *    "employee" table. PreparedStatement prevents SQL injection.
 * 9. If insertion is successful, a success message is displayed
 *    using JOptionPane and the text fields are cleared.
 * 10. The program handles invalid input and database errors using
 *     try-catch blocks.
 *
 * Requirements:
 * - PostgreSQL must be installed and running.
 * - Database "projectdb" must exist.
 * - Table "employee" must be created:
 *
 *   CREATE TABLE employee(
 *       eno INT PRIMARY KEY,
 *       ename VARCHAR(50),
 *       designation VARCHAR(50),
 *       salary DOUBLE PRECISION
 *   );
 *
 * - PostgreSQL JDBC driver JAR must be added to the project.
 *
 * This program demonstrates:
 * - Java Swing GUI
 * - Event Handling
 * - JDBC Connectivity
 * - PostgreSQL Database Integration
>>>>>>> 546047a5172bffb33a481f342c8a0341ce213838
 */
