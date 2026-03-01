import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Slip10_2 extends JFrame implements ActionListener {
    JTextField t1, t2, t3;
    JButton b1;

    public Slip10_2() {
        setTitle("Student Record Display");
        setSize(400, 250);
        setLayout(new GridLayout(4, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Roll No:"));
        t1 = new JTextField();
        add(t1);

        add(new JLabel("Name:"));
        t2 = new JTextField();
        add(t2);

        add(new JLabel("Percentage:"));
        t3 = new JTextField();
        add(t3);

        b1 = new JButton("Display First Record");
        b1.addActionListener(this);
        add(new JLabel(""));
        add(b1);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "postgres", "root");
            Statement st = con.createStatement();

            // Fetch only the first record
            ResultSet rs = st.executeQuery("SELECT * FROM student LIMIT 1");

            if (rs.next()) {
                t1.setText(String.valueOf(rs.getInt(1)));
                t2.setText(rs.getString(2));
                t3.setText(String.valueOf(rs.getDouble(3)));
            } else {
                JOptionPane.showMessageDialog(this, "No records found in student table!");
            }

            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new Slip10_2();
    }
}

/*
 * Explanation:
 * This Java Swing application connects to a database to fetch and display
 * student records.
 * 1. Interface: It uses a GridLayout to align labels and TextFields for RNo,
 * SName, and Percentage.
 * 2. JDBC Connection: When the button is clicked, it connects to 'testdb' using
 * the MySQL Driver.
 * 3. SQL Query: It executes "SELECT * FROM student LIMIT 1" to retrieve only
 * the first record.
 * 4. Record Binding: If a record exists (rs.next()), the values are extracted
 * from the ResultSet
 * and set into the respective TextFields using setText().
 * 5. Error Handling: Uses a try-catch block and JOptionPane to notify the user
 * of any issues.
 */
