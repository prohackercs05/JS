import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Slip25_2 extends JFrame implements ActionListener {
    JTextArea queryArea;
    JButton btnCreate, btnAlter, btnDrop;
    Connection con;
    Statement st;

    public Slip25_2() {
        setTitle("DDL Query Executor");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(new JLabel("Type Your DDL Query Here:"), BorderLayout.NORTH);
        queryArea = new JTextArea(5, 40);
        centerPanel.add(new JScrollPane(queryArea), BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel();
        btnCreate = new JButton("Create Table");
        btnAlter = new JButton("Alter Table");
        btnDrop = new JButton("Drop Table");

        btnCreate.addActionListener(this);
        btnAlter.addActionListener(this);
        btnDrop.addActionListener(this);

        btnPanel.add(btnCreate);
        btnPanel.add(btnAlter);
        btnPanel.add(btnDrop);
        add(btnPanel, BorderLayout.SOUTH);

        // Connect to database on startup
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "postgres", "root");
            st = con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "DB Connection Error: " + e.getMessage());
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String query = queryArea.getText().trim();
        if (query.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please type a query first!");
            return;
        }

        try {
            // executeUpdate() is used for DDL statements
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(this, "Query Executed Successfully!");
            queryArea.setText("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Execution Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new Slip25_2();
    }
}

/*
 * Explanation:
 * This program is a GUI-based SQL executor for DDL (Data Definition Language)
 * queries.
 * 1. Interface: Uses a JTextArea for multi-line query input and three
 * specialized buttons.
 * 2. Logic: The program connects to 'testdb' at startup.
 * 3. Execution: When any button is clicked, it grabs the text from the area and
 * runs st.executeUpdate(query).
 * 4. DDL Handling: executeUpdate() is the standard method for running CREATE,
 * ALTER,
 * and DROP statements in JDBC because they do not return a ResultSet.
 * 5. Error Feedback: Uses JOptionPane to notify the user if the SQL syntax is
 * invalid
 * or the operation succeeded.
 */
